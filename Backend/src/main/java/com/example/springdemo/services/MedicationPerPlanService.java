package com.example.springdemo.services;

import com.example.springdemo.dto.MedicationPerPlanDTO;
import com.example.springdemo.dto.MedicationPerPlanViewDTO;
import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.dto.builders.MedicationPerPlanBuilder;
import com.example.springdemo.dto.builders.MedicationPerPlanViewBuilder;
import com.example.springdemo.dto.builders.MedicationPlanBuilder;
import com.example.springdemo.entities.MedicationPerPlan;
import com.example.springdemo.entities.MedicationPlan;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.*;
import com.example.springdemo.validators.MedicationPerPlanFieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicationPerPlanService {

    private final MedicationPerPlanRepository medicationPerPlanRepository;
    private final MedicationRepository medicationRepository;
    private final MedicationPlanRepository medicationPlanRepository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    @Autowired
    public MedicationPerPlanService(MedicationPerPlanRepository medicationPerPlanRepository, MedicationRepository medicationRepository,
                                    MedicationPlanRepository medicationPlanRepository, PatientRepository patientRepository, UserRepository userRepository) {
        this.medicationPerPlanRepository = medicationPerPlanRepository;
        this.medicationRepository = medicationRepository;
        this.medicationPlanRepository = medicationPlanRepository;
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }

    public MedicationPerPlanViewDTO findMedicationPerPlanById(Integer id){
        Optional<MedicationPerPlan> medicationPerPlan  = medicationPerPlanRepository.findById(id);

        if (!medicationPerPlan.isPresent()) {
            throw new ResourceNotFoundException("MedicationPerPlan", "medicationPerPlan id", id);
        }
        return MedicationPerPlanViewBuilder.generateDTOFromEntity(medicationPerPlan.get());
    }

    public List<MedicationPerPlanViewDTO> findAll(){
        List<MedicationPerPlan> medicationPerPlans = medicationPerPlanRepository.getAllOrdered();

        return medicationPerPlans.stream()
                .map(MedicationPerPlanViewBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    ////////////////////////////////////////////////////////////////////////////////////
    public List<MedicationPerPlanViewDTO> findAllPlans(String username){
        List<MedicationPerPlan> medicationPerPlans = medicationPerPlanRepository.getAllOrdered();
        List<MedicationPerPlan> res = medicationPerPlanRepository.getAllOrdered();

        List<Patient> patients = patientRepository.findAllByCaregiverUserID(userRepository.findUserByUsername(username).getUserID());

        for(MedicationPerPlan medicationPerPlan: medicationPerPlans) {
            if(patients.contains(medicationPerPlan.getMedicationPlan().getPatient()) && !res.contains(medicationPerPlan))
                res.add(medicationPerPlan);
        }
        return res.stream()
                .map(MedicationPerPlanViewBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public List<MedicationPerPlanViewDTO> findAllMedicationPerPlanById(String username){
        List<MedicationPlan> medicationPlans = medicationPlanRepository.findAllMedicationPlansByPatient(patientRepository.findPatientByUserUsername(username));
        List<MedicationPerPlan> medicationPerPlans = new ArrayList<MedicationPerPlan>();
        for(MedicationPlan medicationPlan : medicationPlans) {
            System.out.println(medicationPlan);
            List<MedicationPerPlan> med = medicationPerPlanRepository.findMedicationPerPlanByMedicationPlan(medicationPlan);
            medicationPerPlans.addAll(med);
        }

        return medicationPerPlans.stream()
                .map(MedicationPerPlanViewBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Integer insert(MedicationPerPlanDTO medicationPerPlanDTO) {

        MedicationPerPlanFieldValidator.validateInsertOrUpdate(medicationPerPlanDTO);

        return medicationPerPlanRepository
                .save(MedicationPerPlanBuilder.generateEntityFromDTO(medicationPerPlanDTO, medicationRepository, medicationPlanRepository))
                .getMedicationPerPlanID();
    }

    public Integer update(MedicationPerPlanDTO medicationPerPlanDTO) {

        Optional<MedicationPerPlan> medicationPerPlan = medicationPerPlanRepository.findById(medicationPerPlanDTO.getMedicationPerPlanID());

        if(!medicationPerPlan.isPresent()){
            throw new ResourceNotFoundException("MedicationPerPlan", "medicationPerPlan id", medicationPerPlanDTO.getMedicationPerPlanID().toString());
        }
        MedicationPerPlanFieldValidator.validateInsertOrUpdate(medicationPerPlanDTO);

        return medicationPerPlanRepository.save(MedicationPerPlanBuilder.generateEntityFromDTO(medicationPerPlanDTO, medicationRepository, medicationPlanRepository)).getMedicationPerPlanID();
    }

    public void delete(MedicationPerPlanViewDTO medicationPerPlanViewDTO){
        //MedicationPerPlanFieldValidator.validateDelete(userViewDTO);

        if(medicationPerPlanViewDTO.getMedicationPlanId() != null) {
            this.medicationPerPlanRepository.delete(medicationPerPlanRepository.findMedicationPerPlanByMedicationPerPlanID(medicationPerPlanViewDTO.getMedicationPerPlanID()));
        }
    }
}
