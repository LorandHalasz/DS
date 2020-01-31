package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedicationViewDTO;
import com.example.springdemo.entities.Medication;

public class MedicationViewBuilder {

    public MedicationViewBuilder() {
    }

    public static MedicationViewDTO generateDTOFromEntity(Medication medication){
        return new MedicationViewDTO(
                medication.getDrugID(),
                medication.getName(),
                medication.getSideEffects(),
                medication.getDosage());
    }

    public static Medication generateEntityFromDTO(MedicationViewDTO medicationViewDTO){
        return new Medication(
                medicationViewDTO.getDrugID(),
                medicationViewDTO.getName(),
                medicationViewDTO.getSideEffects(),
                medicationViewDTO.getDosage());
    }
}
