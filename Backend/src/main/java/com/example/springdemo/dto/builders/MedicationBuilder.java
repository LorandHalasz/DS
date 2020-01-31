package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedicationDTO;
import com.example.springdemo.entities.Medication;

public class MedicationBuilder {

    public MedicationBuilder() {
    }

    public static MedicationDTO generateDTOFromEntity(Medication medication){
        return new MedicationDTO(
                medication.getDrugID(),
                medication.getName(),
                medication.getSideEffects(),
                medication.getDosage());
    }

    public static Medication generateEntityFromDTO(MedicationDTO medicationDTO){
        return new Medication(
                medicationDTO.getDrugID(),
                medicationDTO.getName(),
                medicationDTO.getSideEffects(),
                medicationDTO.getDosage());
    }
}
