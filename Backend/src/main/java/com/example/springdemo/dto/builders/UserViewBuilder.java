package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.UserViewDTO;
import com.example.springdemo.entities.User;

import java.time.LocalDate;

public class UserViewBuilder {
    public static UserViewDTO generateDTOFromEntity(User user){
        return new UserViewDTO(
                user.getUserID(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getBirthdate().toString(),
                user.getGender(),
                user.getAddress(),
                user.getRole());
    }

    public static User generateEntityFromDTO(UserViewDTO userViewDTO){
        return new User(
                userViewDTO.getUserID(),
                userViewDTO.getName(),
                userViewDTO.getUsername(),
                userViewDTO.getEmail(),
                LocalDate.parse(userViewDTO.getBirthdate()),
                userViewDTO.getGender(),
                userViewDTO.getAddress(),
                userViewDTO.getRole());
    }
}
