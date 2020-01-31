package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.entities.MedicationPlan;
import com.example.springdemo.repositories.PatientRepository;
import com.example.springdemo.repositories.UserRepository;

public class MedicationPlanBuilder {

    public MedicationPlanBuilder() {
    }

    public static MedicationPlanDTO generateDTOFromEntity(MedicationPlan medicationPlan){
        return new MedicationPlanDTO(
                medicationPlan.getPlanID(),
                medicationPlan.getPatient().getUser().getName(),
                medicationPlan.getDoctor().getName());
    }

    public static MedicationPlan generateEntityFromDTO(MedicationPlanDTO medicationPlanDTO, UserRepository userRepository, PatientRepository patientRepository){
        return new MedicationPlan(
                medicationPlanDTO.getPlanID(),
                patientRepository.findPatientByUser(userRepository.findUserByName(medicationPlanDTO.getPatientName())),
                userRepository.findUserByName(medicationPlanDTO.getDoctorName()));
    }
}
