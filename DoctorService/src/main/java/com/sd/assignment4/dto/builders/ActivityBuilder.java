package com.sd.assignment4.dto.builders;

import com.sd.assignment4.dto.ActivityDTO;
import com.sd.assignment4.entities.Activity;
import com.sd.assignment4.repositories.PatientRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityBuilder {

    public  ActivityBuilder(){

    }

    public static ActivityDTO generateDTOFromEntity(Activity activity){
        return new ActivityDTO(
                activity.getActivityID(),
                activity.getPatient().getPatientID(),
                activity.getName(),
                new Date(activity.getStart()),
                new Date(activity.getEnd()),
                activity.getAnomalous()
        );
    }

    public static Activity generateEntityFromDTO(ActivityDTO activityDTO, PatientRepository patientRepository){
        return new Activity(
                activityDTO.getActivityID(),
                patientRepository.findById(activityDTO.getPatientId()).get(),
                activityDTO.getName(),
                activityDTO.getStart().getTime(),
                activityDTO.getEnd().getTime(),
                activityDTO.getAnomalous()
        );
    }
}
