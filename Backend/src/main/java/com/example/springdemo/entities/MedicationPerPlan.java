package com.example.springdemo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "medication_per_plan")
public class MedicationPerPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "madication_per_plan_ID")
    private Integer medicationPerPlanID;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "madication_ID")
    private Medication medication;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "madication_plan_ID")
    private MedicationPlan medicationPlan;

    @Column(name = "startTime", nullable = false)
    private LocalDate startTime;

    @Column(name = "endTime", nullable = false)
    private LocalDate endTime;

    @Column(name = "remarks")
    private String remarks;

    public MedicationPerPlan() {
    }

    public MedicationPerPlan(Integer medicationPerPlanID, Medication medication, MedicationPlan medicationPlan, LocalDate startTime, LocalDate endTime, String remarks) {
        this.medicationPerPlanID = medicationPerPlanID;
        this.medication = medication;
        this.medicationPlan = medicationPlan;
        this.startTime = startTime;
        this.endTime = endTime;
        this.remarks = remarks;
    }

    public Integer getMedicationPerPlanID() {
        return medicationPerPlanID;
    }

    public void setMedicationPerPlanID(Integer medicationPerPlanID) {
        this.medicationPerPlanID = medicationPerPlanID;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public MedicationPlan getMedicationPlan() {
        return medicationPlan;
    }

    public void setMedicationPlan(MedicationPlan medicationPlan) {
        this.medicationPlan = medicationPlan;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "MedicationPerPlan{" +
                "medicationPerPlanID=" + medicationPerPlanID +
                ", medication=" + medication +
                ", medicationPlan=" + medicationPlan +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", remarks=" + remarks +
                '}';
    }
}
