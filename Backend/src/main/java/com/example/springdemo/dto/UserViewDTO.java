package com.example.springdemo.dto;

public class UserViewDTO {
    private Integer userID;
    private String name;
    private String username;
    private String email;
    private String birthdate;
    private String gender;
    private String address;
    private String role;

    public UserViewDTO() {
    }

    public UserViewDTO(Integer userID, String name, String username, String email,
                       String birthdate, String gender, String address, String role) {
        this.userID = userID;
        this.name = name;
        this.username = username;
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
    public String toString() {
        return "UserDTO{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
