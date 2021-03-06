package com.sd.assignment4.dto.builders;

import com.sd.assignment4.dto.PatientDTO;
import com.sd.assignment4.dto.UserDTO;
import com.sd.assignment4.entities.Patient;
import com.sd.assignment4.repositories.UserRepository;

public class PatientBuilder {

    PatientBuilder(){
    }

    public static PatientDTO generateDTOFromEntity(Patient patient){
        return new PatientDTO(
                patient.getPatientID(),
                patient.getMedicalRecord(),
                patient.getUser().getName(),
                patient.getUser().getUsername(),
                patient.getUser().getPassword(),
                patient.getUser().getEmail(),
                patient.getUser().getBirthdate().toString(),
                patient.getUser().getGender(),
                patient.getUser().getAddress(),
                patient.getCaregiver().getName());
    }

    public static Patient generateEntityFromDTO(PatientDTO patientDTO, UserRepository userRepository){
        return new Patient(
                patientDTO.getPatientID(),
                patientDTO.getMedicalRecord(),
                UserBuilder.generateEntityFromDTO(new UserDTO(null, patientDTO.getName(), patientDTO.getUsername(),
                                patientDTO.getPassword(), patientDTO.getEmail(), patientDTO.getBirthdate(), patientDTO.getGender(), patientDTO.getAddress(), patientDTO.getRole())),
                userRepository.findUserByName(patientDTO.getCaregiverName()));
    }
}
