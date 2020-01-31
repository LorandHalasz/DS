package com.example.springdemo.dto;

import java.util.Objects;

public class MedicationPerPlanDTO {

    private Integer medicationPerPlanID;
    private String medicationName;
    private Double dosage;
    private Integer medicationPlanId;
    private String doctorName;
    private String treatmentStartTime;
    private String treatmentEndTime;
    private String remarks;

    public MedicationPerPlanDTO() {
    }

    public MedicationPerPlanDTO(Integer medicationPerPlanID, String medicationName, Double dosage, Integer medicationPlanId, String doctorName, String treatmentStartTime, String treatmentEndTime, String remarks) {
        this.medicationPerPlanID = medicationPerPlanID;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.medicationPlanId = medicationPlanId;
        this.doctorName = doctorName;
        this.treatmentStartTime = treatmentStartTime;
        this.treatmentEndTime = treatmentEndTime;
        this.remarks = remarks;
    }

    public Integer getMedicationPerPlanID() {
        return medicationPerPlanID;
    }

    public void setMedicationPerPlanID(Integer medicationPerPlanID) {
        this.medicationPerPlanID = medicationPerPlanID;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public Double getDosage() {
        return dosage;
    }

    public void setDosage(Double dosage) {
        this.dosage = dosage;
    }

    public Integer getMedicationPlanId() {
        return medicationPlanId;
    }

    public void setMedicationPlanId(Integer medicationPlanId) {
        this.medicationPlanId = medicationPlanId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getTreatmentStartTime() {
        return treatmentStartTime;
    }

    public void setTreatmentStartTime(String treatmentStartTime) {
        this.treatmentStartTime = treatmentStartTime;
    }

    public String getTreatmentEndTime() {
        return treatmentEndTime;
    }

    public void setTreatmentEndTime(String treatmentEndTime) {
        this.treatmentEndTime = treatmentEndTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicationPerPlanDTO that = (MedicationPerPlanDTO) o;
        return Objects.equals(medicationPerPlanID, that.medicationPerPlanID) &&
                Objects.equals(medicationName, that.medicationName) &&
                Objects.equals(dosage, that.dosage) &&
                Objects.equals(medicationPlanId, that.medicationPlanId) &&
                Objects.equals(doctorName, that.doctorName) &&
                Objects.equals(treatmentStartTime, that.treatmentStartTime) &&
                Objects.equals(treatmentEndTime, that.treatmentEndTime) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {

        return Objects.hash(medicationPerPlanID, medicationName, dosage, medicationPlanId, doctorName, treatmentStartTime, treatmentEndTime, remarks);
    }
}
