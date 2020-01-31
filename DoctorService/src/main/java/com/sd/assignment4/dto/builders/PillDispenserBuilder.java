package com.sd.assignment4.dto.builders;

import com.sd.assignment4.dto.PillDispenserDTO;
import com.sd.assignment4.entities.PillDispenser;
import com.sd.assignment4.repositories.MedicationRepository;
import com.sd.assignment4.repositories.PatientRepository;

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
