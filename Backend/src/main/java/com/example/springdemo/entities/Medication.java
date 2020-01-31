package com.example.springdemo.entities;

import javax.persistence.*;

@Entity
@Table(name = "medication")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_id", nullable = false)
    private Integer drugID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sideEffects", nullable = false)
    private String sideEffects;

    @Column(name = "dosage", nullable = false)
    private Double dosage;

    public Medication() {
    }

    public Medication(Integer drugID, String name, String sideEffects, Double dosage) {
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
    public String toString() {
        return "Medication{" +
                "drugID=" + drugID +
                ", name='" + name + '\'' +
                ", sideEffects='" + sideEffects + '\'' +
                ", dosage=" + dosage +
                '}';
    }
}
