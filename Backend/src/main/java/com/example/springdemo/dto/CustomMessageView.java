package com.example.springdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CustomMessageView implements Serializable {

    private final String message;
    private final Integer caregiver;

    public CustomMessageView(@JsonProperty("message") String message,
                         @JsonProperty("caregiver") Integer caregiver){
        this.message = message;
        this.caregiver = caregiver;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCaregiver() {
        return caregiver;
    }

    @Override
    public String toString() {
        return "CustomMessageView{" +
                "message='" + message + '\'' +
                ", caregiver=" + caregiver +
                '}';
    }
}
