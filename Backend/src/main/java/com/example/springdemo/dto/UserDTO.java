package com.example.springdemo.dto;

import java.time.LocalDate;
import java.util.Objects;

public class UserDTO {

    private Integer userID;
    private String name;
    private String username;
    private String password;
    private String email;
    private String birthdate;
    private String gender;
    private String address;
    private String role;

    public UserDTO() {
    }

    public UserDTO(Integer userID, String name, String username, String password,
                   String email, String birthdate, String gender, String address, String role) {
        this.userID = userID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.role = role;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(userID, userDTO.userID) &&
                Objects.equals(name, userDTO.name) &&
                Objects.equals(username, userDTO.username) &&
                Objects.equals(password, userDTO.password) &&
                Objects.equals(email, userDTO.email) &&
                Objects.equals(birthdate, userDTO.birthdate) &&
                Objects.equals(gender, userDTO.gender) &&
                Objects.equals(address, userDTO.address) &&
                Objects.equals(role, userDTO.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userID, name, username, password, email, birthdate, gender, address, role);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
