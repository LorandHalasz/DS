package com.example.springdemo.dto;

import java.util.Objects;

public class MedicationDTO {

    private Integer drugID;
    private String name;
    private String sideEffects;
    private Double dosage;

    public MedicationDTO() {
    }

    public MedicationDTO(Integer drugID, String name, String sideEffects, Double dosage) {
        this.drugID = drugID;
        this.name = name;
        this.sideEffects = sideEffects;
        this.dosage = dosage;
    }

    public Integer getDrugID() {
        return drugID;
    }

    public void setDrugID(Integer drugID) {
        this.drugID = drugID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public Double getDosage() {
        return dosage;
    }

    public void setDosage(Double dosage) {
        this.dosage = dosage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicationDTO that = (MedicationDTO) o;
        return Objects.equals(drugID, that.drugID) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sideEffects, that.sideEffects) &&
                Objects.equals(dosage, that.dosage);
    }

    @Override
    public int hashCode() {

        return Objects.hash(drugID, name, sideEffects, dosage);
    }
}
