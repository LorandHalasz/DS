package com.example.springdemo.dto;

public class MedicationViewDTO {

    private Integer drugID;
    private String name;
    private String sideEffects;
    private Double dosage;

    public MedicationViewDTO() {
    }

    public MedicationViewDTO(Integer drugID, String name, String sideEffects, Double dosage) {
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

}
