package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedicationPerPlanViewDTO;
import com.example.springdemo.entities.MedicationPerPlan;
import com.example.springdemo.repositories.MedicationPlanRepository;
import com.example.springdemo.repositories.MedicationRepository;

import java.time.LocalDate;

public class MedicationPerPlanViewBuilder {

    public MedicationPerPlanViewBuilder() {
    }

    public static MedicationPerPlanViewDTO generateDTOFromEntity(MedicationPerPlan medicationPerPlan){
        return new MedicationPerPlanViewDTO(
                medicationPerPlan.getMedicationPerPlanID(),
                medicationPerPlan.getMedication().getName(),
                medicationPerPlan.getMedication().getDosage(),
                medicationPerPlan.getMedicationPlan().getPlanID(),
                medicationPerPlan.getMedicationPlan().getDoctor().getName(),
                medicationPerPlan.getStartTime().toString(),
                medicationPerPlan.getEndTime().toString(),
                medicationPerPlan.getRemarks(),
                medicationPerPlan.getMedicationPlan().getPatient().getUser().getName()
        );
    }

    public static MedicationPerPlan generateEntityFromDTO(MedicationPerPlanViewDTO medicationPerPlanDTO, MedicationRepository medicationRepository, MedicationPlanRepository medicationPlanRepository){
        return new MedicationPerPlan(
                medicationPerPlanDTO.getMedicationPerPlanID(),
                medicationRepository.findMedicationByName(medicationPerPlanDTO.getMedicationName()),
                medicationPlanRepository.findMedicationPlanByPlanID(medicationPerPlanDTO.getMedicationPlanId()),
                LocalDate.parse(medicationPerPlanDTO.getTreatmentEndTime()),
                LocalDate.parse(medicationPerPlanDTO.getTreatmentStartTime()),
                medicationPerPlanDTO.getRemarks()
        );
    }

}
