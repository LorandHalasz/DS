package com.example.springdemo.dto;

import java.util.Objects;

public class PatientDTO {

    private Integer patientID;
    private String medicalRecord;
    private String name;
    private String username;
    private String password;
    private String email;
    private String birthdate;
    private String gender;
    private String address;
    private String role;
    private String caregiverName;

    public PatientDTO() {
    }

    public PatientDTO(Integer patientID, String medicalRecord, String name, String username, String password, String email, String birthdate, String gender, String address, String caregiverName) {
        this.patientID = patientID;
        this.medicalRecord = medicalRecord;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.role = "patient";
        this.caregiverName = caregiverName;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
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

    public String getCaregiverName() {
        return caregiverName;
    }

    public void setCaregiverName(String caregiverName) {
        this.caregiverName = caregiverName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDTO that = (PatientDTO) o;
        return Objects.equals(patientID, that.patientID) &&
                Objects.equals(medicalRecord, that.medicalRecord) &&
                Objects.equals(name, that.name) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                Objects.equals(birthdate, that.birthdate) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(address, that.address) &&
                Objects.equals(role, that.role) &&
                Objects.equals(caregiverName, that.caregiverName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(patientID, medicalRecord, name, username, password, email, birthdate, gender, address, role, caregiverName);
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "patientID=" + patientID +
                ", medicalRecord='" + medicalRecord + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", caregiverName='" + caregiverName + '\'' +
                '}';
    }
}
