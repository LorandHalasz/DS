package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedicationPlanViewDTO;
import com.example.springdemo.entities.MedicationPlan;
import com.example.springdemo.repositories.PatientRepository;
import com.example.springdemo.repositories.UserRepository;

public class MedicationPlanViewBuilder {

    public MedicationPlanViewBuilder() {
    }

    public static MedicationPlanViewDTO generateDTOFromEntity(MedicationPlan medicationPlan){
        return new MedicationPlanViewDTO(
                medicationPlan.getPlanID(),
                medicationPlan.getPatient().getUser().getName(),
                medicationPlan.getDoctor().getName());
    }

    public static MedicationPlan generateEntityFromDTO(MedicationPlanViewDTO medicationPlanViewDTO, UserRepository userRepository, PatientRepository patientRepository){
        return new MedicationPlan(
                medicationPlanViewDTO.getPlanID(),
                patientRepository.findPatientByUser(userRepository.findUserByName(medicationPlanViewDTO.getPatientName())),
                userRepository.findUserByName(medicationPlanViewDTO.getDoctorName()));
    }
}
