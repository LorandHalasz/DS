package com.sd.assignment4.entities;

import javax.persistence.*;

@Entity
@Table(name = "recommendation")
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recommendation_id", unique = true, nullable = false)
    private Integer recommendationID;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "recommendationName")
    private String recommendation;

    @Column(name = "patientName")
    private String patientName;

    @Column(name = "caregiverName")
    private String caregiverName;

    public Recommendation() {
    }

    public Recommendation(Patient patient, String recommendation, String patientName, String caregiverName) {
        this.patient = patient;
        this.recommendation = recommendation;
        this.patientName = patientName;
        this.caregiverName = caregiverName;
    }

    public Recommendation(Integer recommendationID, Patient patient, String recommendation, String patientName, String caregiverName) {
        this.recommendationID = recommendationID;
        this.patient = patient;
        this.recommendation = recommendation;
        this.patientName = patientName;
        this.caregiverName = caregiverName;
    }

    public Integer getRecommendationID() {
        return recommendationID;
    }

    public void setRecommendationID(Integer recommendationID) {
        this.recommendationID = recommendationID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getCaregiverName() {
        return caregiverName;
    }

    public void setCaregiverName(String caregiverName) {
        this.caregiverName = caregiverName;
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "recommendationID=" + recommendationID +
                ", patient=" + patient +
                ", recommendation='" + recommendation + '\'' +
                ", patientName='" + patientName + '\'' +
                ", caregiverName='" + caregiverName + '\'' +
                '}';
    }
}
