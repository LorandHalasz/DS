package com.example.springdemo.dto;

import java.util.Objects;

public class ActivityDTO {

    private Integer activityID;
    private Integer patientId;
    private String name;
    private Long start;
    private Long end;
    private Boolean isAnomalous;

    ActivityDTO(){

    }

    public ActivityDTO(Integer patientId, String name, Long start, Long end, Boolean isAnomalous) {
        this.patientId = patientId;
        this.name = name;
        this.start = start;
        this.end = end;
        this.isAnomalous = isAnomalous;
    }

    public ActivityDTO(Integer activityID, Integer patientId, String name, Long start, Long end, Boolean isAnomalous) {
        this.activityID = activityID;
        this.patientId = patientId;
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

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
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
        isAnomalous = anomalous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityDTO that = (ActivityDTO) o;
        return Objects.equals(activityID, that.activityID) &&
                Objects.equals(patientId, that.patientId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(start, that.start) &&
                Objects.equals(end, that.end) &&
                Objects.equals(isAnomalous, that.isAnomalous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityID, patientId, name, start, end, isAnomalous);
    }

    @Override
    public String toString() {
        return "ActivityDTO{" +
                "activityID=" + activityID +
                ", patientId=" + patientId +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", isAnomalous=" + isAnomalous +
                '}';
    }
}
