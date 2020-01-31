package com.example.springdemo.controller;

import com.example.springdemo.entities.Activity;
import com.sd.assignment4.services.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/soap")
public class SoapController {

    @GetMapping(value = "/getAllPillDispenser")
    public List<PillDispenserDTO> getAllPillDispenser(@RequestParam("patientUsername") String patientUsername, @RequestParam("date") String date) {

        DoctorServiceImpl doctorService = new DoctorServiceImplService().getDoctorServiceImplPort();

        System.out.println(patientUsername);
        return doctorService.getAllPillDispenser(patientUsername, date);
    }

    @GetMapping(value = "/getAllActivities")
    public List<ActivityDTO> getAllActivities(@RequestParam("patientUsername") String patientUsername, @RequestParam("date") String date) {

        DoctorServiceImpl doctorService = new DoctorServiceImplService().getDoctorServiceImplPort();

        return doctorService.getAllActivities(patientUsername, date);
    }

    @PostMapping(value = "/saveActivity")
    public void saveActivity(@RequestParam("activityID") String activityID) {

        DoctorServiceImpl doctorService = new DoctorServiceImplService().getDoctorServiceImplPort();

        doctorService.saveActivity(Integer.parseInt(activityID));
    }

    @PostMapping(value = "/saveRecommendation")
    public void saveRecommendation(@RequestParam("patientUsername") String patientUsername, @RequestParam("recommendation") String recommendation) {

        DoctorServiceImpl doctorService = new DoctorServiceImplService().getDoctorServiceImplPort();

        doctorService.saveRecommendation(patientUsername, recommendation);
    }

    @GetMapping(value = "/getAllActivitiesForChart")
    public MapDTO.Map getAllActivitiesForChart(@RequestParam("patientUsername") String patientUsername, @RequestParam("date") String date) {

        DoctorServiceImpl doctorService = new DoctorServiceImplService().getDoctorServiceImplPort();

        return doctorService.getMap(patientUsername, date).getMap();
    }
}
