package com.example.springdemo.entities;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id", unique = true, nullable = false)
    private Integer patientID;

    @Column(name = "medical_record", nullable = false)
    private String medicalRecord;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "caregiver_id")
    private User caregiver;

    public Patient() {
    }

    public Patient(Integer patientID, String medicalRecord, User user, User caregiver) {
        this.patientID = patientID;
        this.medicalRecord = medicalRecord;
        this.user = user;
        this.caregiver = caregiver;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(User caregiver) {
        this.caregiver = caregiver;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", medicalRecord='" + medicalRecord + '\'' +
                ", user=" + user +
                ", caregiver=" + caregiver +
                '}';
    }
}
