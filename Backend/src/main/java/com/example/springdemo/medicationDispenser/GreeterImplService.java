package com.example.springdemo.medicationDispenser;

import com.example.springdemo.dto.PillDispenserDTO;
import com.example.springdemo.dto.builders.PillDispenserBuilder;
import com.example.springdemo.entities.MedicationPerPlan;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.entities.PillDispenser;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.*;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class GreeterImplService extends GreeterGrpc.GreeterImplBase {

    private MedicationPerPlanRepository medicationPerPlanRepository;
    private PillDispenserRepository pillDispenserRepository;
    private MedicationRepository medicationRepository;
    private PatientRepository patientRepository;

    @Autowired
    public GreeterImplService(MedicationPerPlanRepository medicationPerPlanRepository, PillDispenserRepository pillDispenserRepository, MedicationRepository medicationRepository, PatientRepository patientRepository) {
        this.medicationPerPlanRepository = medicationPerPlanRepository;
        this.pillDispenserRepository = pillDispenserRepository;
        this.medicationRepository = medicationRepository;
        this.patientRepository = patientRepository;
    }

    private static String date;


    @Override
    public void sayHello(Request req, StreamObserver<AllReplies> responseObserver) {

        List<MedicationPerPlan> medicationPerPlans = medicationPerPlanRepository.findAll();
        System.out.println("I received a request from: " + req.getDate());
        date = req.getDate();
        List<Reply> list = new ArrayList<>();
        for(MedicationPerPlan medicationPerPlan: medicationPerPlans) {
            if (medicationPerPlan.getStartTime().isBefore(LocalDate.parse(req.getDate())) && medicationPerPlan.getEndTime().isAfter(LocalDate.parse(req.getDate()))){
                Reply.Builder builder = Reply.newBuilder();
                builder = builder.setName(medicationPerPlan.getMedicationPlan().getPatient().getUser().getName());
                builder = builder.setMedicationName(medicationPerPlan.getMedication().getName());
                builder = builder.setStartDate(medicationPerPlan.getStartTime().toString());
                builder = builder.setEndDate(medicationPerPlan.getEndTime().toString());
                builder = builder.setDosage(medicationPerPlan.getMedication().getDosage().toString());
                builder = builder.setIntakeInterval(medicationPerPlan.getRemarks());
                list.add(builder.build());
            }
        }
        AllReplies replies = AllReplies.newBuilder().addAllRepliesList(list).build();
        responseObserver.onNext(replies);
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void transmitResponse(AllReplies request, StreamObserver<Request> responseObserver) {
        for(int i = 0; i < request.getRepliesListCount(); i++) {
            System.out.println("The patient " + request.getRepliesList(i).getName() + " didn't take the medication " +
                    request.getRepliesList(i).getMedicationName() + " at the right moment (" + request.getRepliesList(i).getIntakeInterval() + ")");
            PillDispenser pillDispenser = (PillDispenserBuilder.generateEntityFromDTO(new PillDispenserDTO(request.getRepliesList(i).getName(), request.getRepliesList(i).getMedicationName(),
                    date, request.getRepliesList(i).getDosage(), request.getRepliesList(i).getIntakeInterval(), 0), patientRepository, medicationRepository));

            pillDispenserRepository.save(pillDispenser);
        }
        Request reply = Request.newBuilder().setDate("Response received!").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void transmitPositiveResponse(Reply request, StreamObserver<Request> responseObserver) {

        System.out.println("The patient " + request.getName() + " took the medication " +
                    request.getMedicationName() + " at the right moment (" + request.getIntakeInterval() + ")");
        PillDispenser pillDispenser = new PillDispenser(null, patientRepository.findPatientByUserUsername(request.getName()), medicationRepository.findMedicationByName(request.getMedicationName()),
                date, request.getIntakeInterval(), 1);
        pillDispenserRepository.save(pillDispenser);
        Request reply = Request.newBuilder().setDate("Response received!").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    public List<PillDispenserDTO> findPillDispenserByDateAndPatient(String date, String patientName){
        Patient patient = patientRepository.findPatientByUserUsername(patientName);

        List<PillDispenser> pillDispenserList = pillDispenserRepository.findPillDispenserByDateAndPatient(date, patient);
        List<PillDispenserDTO> pillDispenserDTOList = new ArrayList<>();

        for(PillDispenser pillDispenser : pillDispenserList){
            pillDispenserDTOList.add(PillDispenserBuilder.generateDTOFromEntity(pillDispenser));
        }

        return pillDispenserDTOList;
    }

    public Integer insert(PillDispenserDTO pillDispenserDTO) {

        return pillDispenserRepository
                .save(PillDispenserBuilder.generateEntityFromDTO(pillDispenserDTO, patientRepository, medicationRepository))
                .getPillDispenserID();
    }

    public Integer update(PillDispenserDTO pillDispenserDTO) {

        Optional<PillDispenser> pillDispenser = pillDispenserRepository.findById(pillDispenserDTO.getPillDispenserID());

        if(!pillDispenser.isPresent()){
            throw new ResourceNotFoundException("PillDispenser", "pillDispenser id", pillDispenserDTO.getPillDispenserID().toString());
        }

        return pillDispenserRepository.save(PillDispenserBuilder.generateEntityFromDTO(pillDispenserDTO, patientRepository, medicationRepository)).getPillDispenserID();
    }
}
