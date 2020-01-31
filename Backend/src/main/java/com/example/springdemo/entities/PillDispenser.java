package com.example.springdemo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pill_dispenser")
public class PillDispenser  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pill_dispenser_id", unique = true, nullable = false)
    private Integer pillDispenserID;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "madication_ID")
    private Medication medication;

    @Column(name = "date")
    private String date;

    @Column(name = "intakeInterval", nullable = false)
    private String intakeInterval;

    @Column(name = "taken", nullable = false)
    private Integer taken;

    public PillDispenser() {

    }

    public PillDispenser(Integer pillDispenserID, Patient patient, Medication medication, String date, String intakeInterval, Integer taken) {
        this.pillDispenserID = pillDispenserID;
        this.patient = patient;
        this.medication = medication;
        this.date = date;
        this.intakeInterval = intakeInterval;
        this.taken = taken;
    }

    public PillDispenser(Patient patient, Medication medication, String date, String intakeInterval, Integer taken) {
        this.patient = patient;
        this.medication = medication;
        this.date = date;
        this.intakeInterval = intakeInterval;
        this.taken = taken;
    }

    public Integer getPillDispenserID() {
        return pillDispenserID;
    }

    public void setPillDispenserID(Integer pillDispenserID) {
        this.pillDispenserID = pillDispenserID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIntakeInterval() {
        return intakeInterval;
    }

    public void setIntakeInterval(String intakeInterval) {
        this.intakeInterval = intakeInterval;
    }

    public Integer getTaken() {
        return taken;
    }

    public void setTaken(Integer taken) {
        this.taken = taken;
    }

    @Override
    public String toString() {
        return "PillDispenser{" +
                "pillDispenserID=" + pillDispenserID +
                ", patient=" + patient +
                ", medication=" + medication +
                ", date='" + date + '\'' +
                ", intakeInterval='" + intakeInterval + '\'' +
                ", taken=" + taken +
                '}';
    }
}
