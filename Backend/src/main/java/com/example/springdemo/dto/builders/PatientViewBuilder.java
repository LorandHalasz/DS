package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.PatientViewDTO;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.repositories.UserRepository;

public class PatientViewBuilder {

    PatientViewBuilder(){
    }

    public static PatientViewDTO generateDTOFromEntity(Patient patient){
        return new PatientViewDTO(
                patient.getPatientID(),
                patient.getMedicalRecord(),
                patient.getUser().getName(),
                patient.getUser().getUsername(),
                patient.getUser().getEmail(),
                patient.getUser().getBirthdate().toString(),
                patient.getUser().getGender(),
                patient.getUser().getAddress(),
                patient.getUser().getRole(),
                patient.getCaregiver().getName());
    }

    public static Patient generateEntityFromDTO(PatientViewDTO patientViewDTO, UserRepository userRepository){
        return new Patient(
                patientViewDTO.getPatientID(),
                patientViewDTO.getMedicalRecord(),
                userRepository.findUserByUsername(patientViewDTO.getUsername()),
                userRepository.findUserByUsername(patientViewDTO.getCaregiverName()));
    }
}
