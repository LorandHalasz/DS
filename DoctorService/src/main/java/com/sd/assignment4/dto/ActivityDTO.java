package com.sd.assignment4.dto;

import java.util.Date;
import java.util.Objects;

public class ActivityDTO {

    private Integer activityID;
    private Integer patientId;
    private String name;
    private Date start;
    private Date end;
    private Boolean isAnomalous;

    public ActivityDTO(){

    }

    public ActivityDTO(Integer patientId, String name, Date start, Date end, Boolean isAnomalous) {
        this.patientId = patientId;
        this.name = name;
        this.start = start;
        this.end = end;
        this.isAnomalous = isAnomalous;
    }

    public ActivityDTO(Integer activityID, Integer patientId, String name, Date start, Date end, Boolean isAnomalous) {
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
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
