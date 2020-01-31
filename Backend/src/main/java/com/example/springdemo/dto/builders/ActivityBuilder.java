package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.ActivityDTO;
import com.example.springdemo.entities.Activity;
import com.example.springdemo.repositories.PatientRepository;

public class ActivityBuilder {

    public  ActivityBuilder(){

    }

    public static ActivityDTO generateDTOFromEntity(Activity activity){
        return new ActivityDTO(
                activity.getActivityID(),
                activity.getPatient().getPatientID(),
                activity.getName(),
                activity.getStart(),
                activity.getEnd(),
                activity.getAnomalous()
        );
    }

    public static Activity generateEntityFromDTO(ActivityDTO activityDTO, PatientRepository patientRepository){
        return new Activity(
                activityDTO.getActivityID(),
                patientRepository.findById(activityDTO.getPatientId()).get(),
                activityDTO.getName(),
                activityDTO.getStart(),
                activityDTO.getEnd(),
                activityDTO.getAnomalous()
        );
    }
}
