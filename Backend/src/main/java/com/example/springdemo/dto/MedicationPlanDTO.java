package com.example.springdemo.dto;

import java.util.Objects;

public class MedicationPlanDTO {

    private Integer planID;
    private String patientName;
    private String doctorName;

    public MedicationPlanDTO() {
    }

    public MedicationPlanDTO(Integer planID, String patientName, String doctorName) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicationPlanDTO that = (MedicationPlanDTO) o;
        return Objects.equals(planID, that.planID) &&
                Objects.equals(patientName, that.patientName) &&
                Objects.equals(doctorName, that.doctorName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(planID, patientName, doctorName);
    }
}
