package com.example.springdemo.controller;

import org.springframework.web.bind.annotation.*;
import org.tempuri.Caregiver;
import org.tempuri.CaregiverSoap;
import org.tempuri.Recommendation;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/tempuri")
public class SoapTempuriController {

    @GetMapping(value = "/getRecommendation")
    public List<Recommendation> getRecommendation(@RequestParam("caregiverName") String caregiverName) {

        CaregiverSoap caregiverSoap = new Caregiver().getCaregiverSoap();

        return caregiverSoap.getRecommendations(caregiverName).getRecommendation();
    }
}
