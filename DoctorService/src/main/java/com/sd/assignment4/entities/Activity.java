package com.sd.assignment4.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "activity_id", unique = true, nullable = false)
    private Integer activityID;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start", nullable = false)
    private Long start;

    @Column(name = "end", nullable = false)
    private Long end;

    @Column(name = "isAnomalous")
    private Boolean isAnomalous;

    private Activity(){

    }

    public Activity(Integer activityID, Patient patient, String name, Long start, Long end, Boolean isAnomalous) {
        this.activityID = activityID;
        this.patient = patient;
        this.name = name;
        this.start = start;
        this.end = end;
        this.isAnomalous = isAnomalous;
    }

    public Activity(Patient patient, String name, Long start, Long end, Boolean isAnomalous) {
        this.patient = patient;
        this.name = name;
        this.start = start;
        this.end = end;
        this.isAnomalous = isAnomalous;
    }

    public Integer getActivityID() {
        return activityID;
    }

    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public Boolean getAnomalous() {
        return isAnomalous;
    }

    public void setAnomalous(Boolean anomalous) {
        this.isAnomalous = anomalous;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityID=" + activityID +
                ", patient=" + patient +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", isAnomalous=" + isAnomalous +
                '}';
    }
}
