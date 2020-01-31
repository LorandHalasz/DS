package com.example.springdemo.medicationDispenser;

public class ReplyDTO {
    private String name;
    private String medicationName;
    private String startDate;
    private String endDate;
    private String dosage;
    private String intakeInterval;

    public ReplyDTO(String name, String medicationName, String startDate, String endDate, String dosage, String intakeInterval) {
        this.name = name;
        this.medicationName = medicationName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dosage = dosage;
        this.intakeInterval = intakeInterval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    @Override
    public String toString() {
        return "ReplyDTO{" +
                "name='" + name + '\'' +
                ", medicationName='" + medicationName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", dosage='" + dosage + '\'' +
                ", intakeInterval='" + intakeInterval + '\'' +
                '}';
    }
}
