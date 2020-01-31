package com.example.springdemo.services;

import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.dto.UserViewDTO;
import com.example.springdemo.dto.builders.UserBuilder;
import com.example.springdemo.dto.builders.UserViewBuilder;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.entities.User;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.PatientRepository;
import com.example.springdemo.repositories.UserRepository;
import com.example.springdemo.validators.UserFieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public UserService(UserRepository userRepository, PatientRepository patientRepository) {
        this.userRepository = userRepository;
        this.patientRepository = patientRepository;
    }

    public UserViewDTO findUserById(Integer id){
        Optional<User> user  = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new ResourceNotFoundException("User", "user id", id);
        }
        return UserViewBuilder.generateDTOFromEntity(user.get());
    }

    public UserViewDTO findUserByUsername(String username){
        Optional<User> user  = userRepository.findByUsername(username);

        if (!user.isPresent()) {
            throw new ResourceNotFoundException("User", "username", username);
        }
        return UserViewBuilder.generateDTOFromEntity(user.get());
    }

    public UserViewDTO loginUser(String username, String password) {
        User user = userRepository.findUserByUsername(username);

        if (user == null)
            throw new ResourceNotFoundException("User", "username", username);
        else
            if(!user.getPassword().equals(password)){
                throw new ResourceNotFoundException("User", "password", password);
            }

        return UserViewBuilder.generateDTOFromEntity(user);
    }

    public List<UserViewDTO> findAll(){
        List<User> users = userRepository.getAllOrdered();

        return users.stream()
                .map(UserViewBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public List<UserViewDTO> findAllCaregivers(){
        List<User> users = userRepository.findAllUserByRole("caregiver");

        return users.stream()
                .map(UserViewBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Integer insert(UserDTO userDTO) {

        UserFieldValidator.validateInsertOrUpdate(userDTO);

        userDTO.setRole("caregiver");

        return userRepository
                .save(UserBuilder.generateEntityFromDTO(userDTO))
                .getUserID();
    }

    @Transactional
    public Integer update(UserDTO userDTO) {

        Optional<User> user = userRepository.findByUsername(userDTO.getUsername());

        if(!user.isPresent()){
            throw new ResourceNotFoundException("User", "user id", userDTO.getUserID().toString());
        }
        UserFieldValidator.validateInsertOrUpdate(userDTO);

        user.get().setName(userDTO.getName());
        user.get().setEmail(userDTO.getEmail());
        user.get().setBirthdate(LocalDate.parse(userDTO.getBirthdate()));
        user.get().setGender(userDTO.getGender());
        user.get().setAddress(userDTO.getAddress());

        return user.get().getUserID();
    }

    @Transactional
    public void delete(String username){

        UserFieldValidator.validateDelete(username);
        User user = userRepository.findUserByUsername(username);
        if(user.getRole().equals("caregiver")){
            List<Patient> patients = patientRepository.findAllByCaregiverUserID(user.getUserID());

            for(Patient patient: patients){
                patient.setCaregiver(null);
            }
        }
        this.userRepository.delete(user);

    }

}
