package com.example.springdemo.entities;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Integer userID;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "role", nullable = false)
    private String role;

    public User() {
    }

    public User(Integer userID, String name, String username, String password, String email, LocalDate birthdate, String gender, String address, String role) {
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

    public User(Integer userID, String name, String username, String email, LocalDate birthdate, String gender, String address, String role) {
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
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
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
