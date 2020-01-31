package com.sd.assignment4.config;

import com.sd.assignment4.repositories.*;
import com.sd.assignment4.services.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class SOAPPublisher {

    @Autowired
    private PillDispenserRepository pillDispenserRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Bean
    public void startPublisher(){
       new Thread(() -> {

           Endpoint.publish("http://localhost:9557/ws/doctor", new DoctorServiceImpl(pillDispenserRepository, patientRepository, activityRepository, recommendationRepository));
       }).start();
    }

}
