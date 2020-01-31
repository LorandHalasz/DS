package com.example.springdemo.entities;

import javax.persistence.*;

@Entity
@Table(name = "medication_plan")
public class MedicationPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id", unique = true, nullable = false)
    private Integer planID;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "doctor_id", nullable = false)
    private User doctor;

    public MedicationPlan() {
    }

    public MedicationPlan(Integer planID, Patient patient, User doctor) {
        this.planID = planID;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Integer getPlanID() {
        return planID;
    }

    public void setPlanID(Integer planID) {
        this.planID = planID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "MedicationPlan{" +
                "planID=" + planID +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}
