package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.entities.User;

import java.time.LocalDate;

public class UserBuilder {

    public UserBuilder() {
    }

    public static UserDTO generateDTOFromEntity(User user){
        return new UserDTO(
                user.getUserID(),
                user.getName(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getBirthdate().toString(),
                user.getGender(),
                user.getAddress(),
                user.getRole());
    }

    public static User generateEntityFromDTO(UserDTO userDTO){
        return new User(
                userDTO.getUserID(),
                userDTO.getName(),
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getEmail(),
                LocalDate.parse(userDTO.getBirthdate()),
                userDTO.getGender(),
                userDTO.getAddress(),
                userDTO.getRole());
    }
}
