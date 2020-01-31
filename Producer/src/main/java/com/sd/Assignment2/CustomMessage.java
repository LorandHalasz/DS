package com.sd.Assignment2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public final class CustomMessage implements Serializable {

    private final Integer patient;
    private final String activity;
    private final Long start;
    private final Long end;

    public CustomMessage(@JsonProperty("patient") Integer patient,
                         @JsonProperty("activity") String activity,
                         @JsonProperty("start") Long start,
                         @JsonProperty("end") Long end){
        this.patient = patient;
        this.activity = activity;
        this.start = start;
        this.end = end;
    }

    public Integer getPatient() {
        return patient;
    }

    public String getActivity() {
        return activity;
    }

    public Long getStart() {
        return start;
    }

    public Long getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "CustomMessage{" +
                "activity='" + activity + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
