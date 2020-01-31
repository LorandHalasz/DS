package com.example.springdemo.dto;

public class MedicationPerPlanViewDTO {

    private Integer medicationPerPlanID;
    private String medicationName;
    private Double dosage;
    private Integer medicationPlanId;
    private String doctorName;
    private String treatmentStartTime;
    private String treatmentEndTime;
    private String remarks;
    private String patientName;

    public MedicationPerPlanViewDTO() {
    }

    public MedicationPerPlanViewDTO(Integer medicationPerPlanID, String medicationName, Double dosage, Integer medicationPlanId,
                                    String doctorName, String treatmentStartTime, String treatmentEndTime, String remarks, String patientName) {
        this.medicationPerPlanID = medicationPerPlanID;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.medicationPlanId = medicationPlanId;
        this.doctorName = doctorName;
        this.treatmentStartTime = treatmentStartTime;
        this.treatmentEndTime = treatmentEndTime;
        this.remarks = remarks;
        this.patientName = patientName;
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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
