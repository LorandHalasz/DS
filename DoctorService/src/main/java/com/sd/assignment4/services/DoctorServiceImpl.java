package com.sd.assignment4.services;
import com.sd.assignment4.dto.ActivityDTO;
import com.sd.assignment4.dto.MapDTO;
import com.sd.assignment4.dto.PillDispenserDTO;
import com.sd.assignment4.dto.builders.ActivityBuilder;
import com.sd.assignment4.dto.builders.PillDispenserBuilder;
import com.sd.assignment4.entities.*;
import com.sd.assignment4.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@WebService
@Service
public class DoctorServiceImpl implements DoctorService {


    private PillDispenserRepository pillDispenserRepository;

    private PatientRepository patientRepository;

    private ActivityRepository activityRepository;

    private RecommendationRepository recommendationRepository;

    public DoctorServiceImpl(){

    }

    @Autowired
    public DoctorServiceImpl(PillDispenserRepository pillDispenserRepository, PatientRepository patientRepository, ActivityRepository activityRepository, RecommendationRepository recommendationRepository) {
        this.pillDispenserRepository = pillDispenserRepository;
        this.patientRepository = patientRepository;
        this.activityRepository = activityRepository;
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public List<PillDispenserDTO> getAllPillDispenser(String patientUsername, String date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<PillDispenserDTO> pillDispenserDTOList = new ArrayList<>();

        try {
            Date newDate = formatter.parse(date);
            Patient patient = patientRepository.findPatientByUserUsername(patientUsername);
            List<PillDispenser> pillDispenserList = pillDispenserRepository.findPillDispenserByPatient(patient);
            List<PillDispenserDTO> list = new ArrayList<>();

            for(PillDispenser pillDispenser : pillDispenserList){
                list.add(PillDispenserBuilder.generateDTOFromEntity(pillDispenser));
            }

            for(PillDispenserDTO pillDispenserDTO : list){
                if(formatter.parse(pillDispenserDTO.getDate()).equals(newDate))
                    pillDispenserDTOList.add(pillDispenserDTO);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return pillDispenserDTOList;
    }

    @Override
    public List<ActivityDTO> getAllActivities(String patientUsername, String date){

        List<ActivityDTO> activityDTOList = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date newDate = formatter.parse(date);

            Patient patient = patientRepository.findPatientByUserUsername(patientUsername);
            List<Activity> activityList = activityRepository.findActivitiesByPatient(patient);
            List<ActivityDTO> list = new ArrayList<>();

            for(Activity activity : activityList){
                list.add(ActivityBuilder.generateDTOFromEntity(activity));
            }

            LocalDate localDate = newDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year  = localDate.getYear();
            int month = localDate.getMonthValue();
            int day   = localDate.getDayOfMonth();

            for(ActivityDTO activityDTO : list){
                LocalDate localDate2 = activityDTO.getStart().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year2  = localDate2.getYear();
                int month2 = localDate2.getMonthValue();
                int day2   = localDate2.getDayOfMonth();
                if(year == year2 && month == month2 && day == day2)
                    activityDTOList.add(activityDTO);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return activityDTOList;
    }

    @Override
    @Transactional
    public void saveActivity(Integer activityID) {
        Activity activity = activityRepository.findActivitiesByActivityID(activityID);

        activity.setAnomalous(false);
        activityRepository.save(activity);
    }

    @Transactional
    @Override
    public void saveRecommendation(String patientUsername, String recommendation){

        Patient patient = patientRepository.findPatientByUserUsername(patientUsername);

        Recommendation rec = new Recommendation(patient, recommendation, patient.getUser().getName(), patient.getCaregiver().getName());

        recommendationRepository.save(rec);
    }

    @Override
    public MapDTO getMap(String patientUsername, String date) {
        MapDTO mapDTO = new MapDTO();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date newDate = formatter.parse(date);

            Patient patient = patientRepository.findPatientByUserUsername(patientUsername);
            List<Activity> activityList = activityRepository.findActivitiesByPatient(patient);

            LocalDate localDate = newDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year  = localDate.getYear();
            int month = localDate.getMonthValue();
            int day   = localDate.getDayOfMonth();

            for(Activity activity : activityList) {
                LocalDate localDate2 = new Date(activity.getStart()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year2  = localDate2.getYear();
                int month2 = localDate2.getMonthValue();
                int day2   = localDate2.getDayOfMonth();
                if(year == year2 && month == month2 && day == day2)
                    mapDTO.activityMap.put(activity.getName(), activity.getEnd() - activity.getStart());
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return mapDTO;
    }
}
