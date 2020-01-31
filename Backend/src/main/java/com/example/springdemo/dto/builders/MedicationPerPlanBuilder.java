package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedicationPerPlanDTO;
import com.example.springdemo.entities.MedicationPerPlan;
import com.example.springdemo.repositories.MedicationPlanRepository;
import com.example.springdemo.repositories.MedicationRepository;
import com.example.springdemo.services.MedicationService;

import java.time.LocalDate;

public class MedicationPerPlanBuilder {

    public MedicationPerPlanBuilder() {
    }

    public static MedicationPerPlanDTO generateDTOFromEntity(MedicationPerPlan medicationPerPlan){
        return new MedicationPerPlanDTO(
                medicationPerPlan.getMedicationPerPlanID(),
                medicationPerPlan.getMedication().getName(),
                medicationPerPlan.getMedication().getDosage(),
                medicationPerPlan.getMedicationPlan().getPlanID(),
                medicationPerPlan.getMedicationPlan().getDoctor().getName(),
                medicationPerPlan.getStartTime().toString(),
                medicationPerPlan.getEndTime().toString(),
                medicationPerPlan.getRemarks()
        );
    }

    public static MedicationPerPlan generateEntityFromDTO(MedicationPerPlanDTO medicationPerPlanDTO, MedicationRepository medicationRepository, MedicationPlanRepository medicationPlanRepository){
        return new MedicationPerPlan(
                medicationPerPlanDTO.getMedicationPerPlanID(),
                medicationRepository.findMedicationByName(medicationPerPlanDTO.getMedicationName()),
                medicationPlanRepository.findMedicationPlanByPlanID(medicationPerPlanDTO.getMedicationPlanId()),
                LocalDate.parse(medicationPerPlanDTO.getTreatmentStartTime()),
                LocalDate.parse(medicationPerPlanDTO.getTreatmentEndTime()),
                medicationPerPlanDTO.getRemarks()
        );
    }
}
