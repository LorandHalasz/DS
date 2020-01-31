package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.PillDispenserDTO;
import com.example.springdemo.entities.PillDispenser;
import com.example.springdemo.repositories.MedicationRepository;
import com.example.springdemo.repositories.PatientRepository;

public class PillDispenserBuilder {

    public PillDispenserBuilder() {
    }

    public static PillDispenserDTO generateDTOFromEntity(PillDispenser pillDispenser){
        return new PillDispenserDTO(
                pillDispenser.getPillDispenserID(),
                pillDispenser.getPatient().getUser().getName(),
                pillDispenser.getMedication().getName(),
                pillDispenser.getDate(),
                pillDispenser.getMedication().getDosage().toString(),
                pillDispenser.getIntakeInterval(),
                pillDispenser.getTaken()
        );
    }

    public static PillDispenser generateEntityFromDTO(PillDispenserDTO pillDispenserDTO, PatientRepository patientRepository, MedicationRepository medicationRepository){
        return new PillDispenser(
                pillDispenserDTO.getPillDispenserID(),
                patientRepository.findPatientByUserUsername(pillDispenserDTO.getPatient()),
                medicationRepository.findMedicationByName(pillDispenserDTO.getMedication()),
                pillDispenserDTO.getDate(),
                pillDispenserDTO.getIntakeInterval(),
                pillDispenserDTO.getTaken()
        );
    }
}
