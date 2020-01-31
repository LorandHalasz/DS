package com.example.springdemo.services;

import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.dto.PatientViewDTO;
import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.dto.UserViewDTO;
import com.example.springdemo.dto.builders.PatientBuilder;
import com.example.springdemo.dto.builders.PatientViewBuilder;
import com.example.springdemo.dto.builders.UserBuilder;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.entities.User;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.PatientRepository;
import com.example.springdemo.repositories.UserRepository;
import com.example.springdemo.validators.PatientFieldValidator;
import com.example.springdemo.validators.UserFieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, UserRepository userRepository) {
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }

    public PatientViewDTO findPatientById(Integer id){
        Optional<Patient> patient  = patientRepository.findById(id);

        if (!patient.isPresent()) {
            throw new ResourceNotFoundException("Patient", "patient id", id);
        }

        return PatientViewBuilder.generateDTOFromEntity(patient.get());
    }

    public List<PatientViewDTO> findAll(){
        List<Patient> patients = patientRepository.getAllOrdered();

        return patients.stream()
                .map(PatientViewBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public List<PatientViewDTO> findAllPatientsForACaregiver(String username){
        UserFieldValidator.validateUsername(username);

        List<Patient> patients = patientRepository.findAllByCaregiverUserID(userRepository.findUserByUsername(username).getUserID());

        return patients.stream()
                .map(PatientViewBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Integer insert(PatientDTO patientDTO) {

        patientDTO.setRole("patient");

        PatientFieldValidator.validateInsertOrUpdate(patientDTO);

        Patient patient = PatientBuilder.generateEntityFromDTO(patientDTO, userRepository);

        patient.getUser().setUserID(userRepository.save(patient.getUser()).getUserID());

        return patientRepository.save(patient)
                .getPatientID();
        /*return patientRepository
                .save(new Patient(patientDTO.getPatientID(), patientDTO.getMedicalRecord(),
                        userRepository.save(UserBuilder.generateEntityFromDTO(new UserDTO(patientDTO.getUserID(), patientDTO.getName(), patientDTO.getUsername(),
                                patientDTO.getPassword(), patientDTO.getEmail(), patientDTO.getBirthdate(), patientDTO.getGender(), patientDTO.getAddress(), patientDTO.getRole()))),
                        userRepository.findUserByUsername(patientDTO.getCaregiverName())))
                .getPatientID();*/
    }

    @Transactional
    public Integer update(PatientDTO patientDTO) {

        PatientFieldValidator.validateInsertOrUpdate(patientDTO);

        Patient patient = patientRepository.findPatientByUserUsername(patientDTO.getUsername());
        patient.getUser().setName(patientDTO.getName());
        patient.getUser().setEmail(patientDTO.getEmail());
        patient.getUser().setBirthdate(LocalDate.parse(patientDTO.getBirthdate()));
        patient.getUser().setGender(patientDTO.getGender());
        patient.getUser().setAddress(patientDTO.getAddress());
        patient.setMedicalRecord(patientDTO.getMedicalRecord());
        patient.setCaregiver(userRepository.findUserByName(patientDTO.getCaregiverName()));

        return patient.getPatientID();
    }

    @Transactional
    public void delete(String username){

        UserFieldValidator.validateUsername(username);
        Patient patient = patientRepository.findPatientByUserUsername(username);
        patient.setCaregiver(null);
        this.patientRepository.delete(patient);
    }

}
