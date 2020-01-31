package com.example.springdemo.services;

import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.dto.MedicationPlanViewDTO;
import com.example.springdemo.dto.builders.MedicationPlanBuilder;
import com.example.springdemo.dto.builders.MedicationPlanViewBuilder;
import com.example.springdemo.entities.MedicationPlan;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.MedicationPlanRepository;
import com.example.springdemo.repositories.PatientRepository;
import com.example.springdemo.repositories.UserRepository;
import com.example.springdemo.validators.MedicationPlanFieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicationPlanService {

    private final MedicationPlanRepository medicationPlanRepository;
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public MedicationPlanService(MedicationPlanRepository medicationPlanRepository, UserRepository userRepository, PatientRepository patientRepository) {
        this.medicationPlanRepository = medicationPlanRepository;
        this.userRepository = userRepository;
        this.patientRepository = patientRepository;
    }

    public MedicationPlanViewDTO findMedicationPlanById(Integer id){
        Optional<MedicationPlan> medicationPlan  = medicationPlanRepository.findById(id);

        if (!medicationPlan.isPresent()) {
            throw new ResourceNotFoundException("MedicationPlan", "medicationPlan id", id);
        }
        return MedicationPlanViewBuilder.generateDTOFromEntity(medicationPlan.get());
    }

    public List<MedicationPlanViewDTO> findAll(){
        List<MedicationPlan> medicationPlans = medicationPlanRepository.getAllOrdered();

        return medicationPlans.stream()
                .map(MedicationPlanViewBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Integer insert(MedicationPlanDTO medicationPlanDTO) {

        MedicationPlanFieldValidator.validateInsertOrUpdate(medicationPlanDTO);

        return medicationPlanRepository
                .save(MedicationPlanBuilder.generateEntityFromDTO(medicationPlanDTO, userRepository, patientRepository))
                .getPlanID();
    }

    public Integer update(MedicationPlanDTO medicationPlanDTO) {

        Optional<MedicationPlan> medicationPlan = medicationPlanRepository.findById(medicationPlanDTO.getPlanID());

        if(!medicationPlan.isPresent()){
            throw new ResourceNotFoundException("MedicationPlan", "medicationPlan id", medicationPlanDTO.getPlanID().toString());
        }
        MedicationPlanFieldValidator.validateInsertOrUpdate(medicationPlanDTO);

        return medicationPlanRepository.save(MedicationPlanBuilder.generateEntityFromDTO(medicationPlanDTO, userRepository, patientRepository)).getPlanID();
    }

    public void delete(MedicationPlanViewDTO medicationPlanViewDTO){
        //MedicationPlanFieldValidator.validateDelete(userViewDTO);

        if(medicationPlanViewDTO.getPatientName() != null && medicationPlanViewDTO.getDoctorName() != null) {
            this.medicationPlanRepository.delete(medicationPlanRepository.findMedicationPlanByPatient(patientRepository.findPatientByUser(userRepository.findUserByName(medicationPlanViewDTO.getPatientName()))));
        }
    }
}
