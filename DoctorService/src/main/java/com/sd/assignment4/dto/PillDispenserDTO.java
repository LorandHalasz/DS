package com.sd.assignment4.dto;

import java.util.Objects;

public class PillDispenserDTO {

    private Integer pillDispenserID;
    private String patient;
    private String medication;
    private String date;
    private String dosage;
    private String intakeInterval;
    private Integer taken;

    public PillDispenserDTO() {
    }

    public PillDispenserDTO(Integer pillDispenserID, String patient, String medication, String date, String dosage, String intakeInterval, Integer taken) {
        this.pillDispenserID = pillDispenserID;
        this.patient = patient;
        this.medication = medication;
        this.date = date;
        this.dosage = dosage;
        this.intakeInterval = intakeInterval;
        this.taken = taken;
    }

    public PillDispenserDTO(String patient, String medication, String date, String dosage, String intakeInterval, Integer taken) {
        this.patient = patient;
        this.medication = medication;
        this.date = date;
        this.dosage = dosage;
        this.intakeInterval = intakeInterval;
        this.taken = taken;
    }

    public Integer getPillDispenserID() {
        return pillDispenserID;
    }

    public void setPillDispenserID(Integer pillDispenserID) {
        this.pillDispenserID = pillDispenserID;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PillDispenserDTO that = (PillDispenserDTO) o;
        return Objects.equals(pillDispenserID, that.pillDispenserID) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(medication, that.medication) &&
                Objects.equals(date, that.date) &&
                Objects.equals(dosage, that.dosage) &&
                Objects.equals(intakeInterval, that.intakeInterval) &&
                Objects.equals(taken, that.taken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pillDispenserID, patient, medication, date, dosage, intakeInterval, taken);
    }

    @Override
    public String toString() {
        return "PillDispenserDTO{" +
                "pillDispenserID=" + pillDispenserID +
                ", patient='" + patient + '\'' +
                ", medication='" + medication + '\'' +
                ", date='" + date + '\'' +
                ", dosage='" + dosage + '\'' +
                ", intakeInterval='" + intakeInterval + '\'' +
                ", taken=" + taken +
                '}';
    }
}
