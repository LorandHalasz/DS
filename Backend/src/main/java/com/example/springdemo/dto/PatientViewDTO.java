package com.example.springdemo.dto;

public class PatientViewDTO {

    private Integer patientID;
    private String medicalRecord;
    private String name;
    private String username;
    private String email;
    private String birthdate;
    private String gender;
    private String address;
    private String role;
    private String caregiverName;

    public PatientViewDTO() {
    }

    public PatientViewDTO(Integer patientID, String medicalRecord, String name, String username, String email, String birthdate, String gender, String address, String role, String caregiverName) {
        this.patientID = patientID;
        this.medicalRecord = medicalRecord;
        this.name = name;
        this.username = username;
        this.email = email;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.role = role;
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
}
