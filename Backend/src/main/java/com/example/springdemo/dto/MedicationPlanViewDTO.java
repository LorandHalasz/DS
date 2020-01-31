package com.example.springdemo.dto;

public class MedicationPlanViewDTO {

    private Integer planID;
    private String patientName;
    private String doctorName;

    public MedicationPlanViewDTO() {
    }

    public MedicationPlanViewDTO(Integer planID, String patientName, String doctorName) {
        this.planID = planID;
        this.patientName = patientName;
        this.doctorName = doctorName;
    }

    public Integer getPlanID() {
        return planID;
    }

    public void setPlanID(Integer planID) {
        this.planID = planID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

}