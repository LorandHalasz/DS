package com.example.springdemo.services;

import com.example.springdemo.controller.ActivityController;
import com.example.springdemo.dto.ActivityDTO;
import com.example.springdemo.dto.CustomMessageView;
import com.example.springdemo.dto.builders.ActivityBuilder;
import com.example.springdemo.entities.Activity;
import com.example.springdemo.entities.CustomMessage;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.repositories.ActivityRepository;
import com.example.springdemo.repositories.PatientRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private final ActivityRepository activityRepository;
    private final PatientRepository patientRepository;
    private ActivityController activityController;

    @Autowired
    public Consumer(ActivityRepository activityRepository, PatientRepository patientRepository, ActivityController activityController){
        this.activityRepository = activityRepository;
        this.patientRepository = patientRepository;
        this.activityController = activityController;
    }

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receiveMessage(final CustomMessage message) {
        System.out.println("Received Patient: " + message.getPatient());
        System.out.println("Received Message: " + message.getActivity());
        System.out.println("Received Start: " + message.getStart());
        System.out.println("Received End: " + message.getEnd());
        Boolean isAnomalous;
        if(message.getActivity().equals("Sleeping") && message.getEnd() - message.getStart() > 43200000) {
            isAnomalous = true;
        }
        else
            if((message.getActivity().equals("Grooming") || message.getActivity().equals("Toileting") || message.getActivity().equals("Showering"))
                    && message.getEnd() - message.getStart() > 3600000) {
                isAnomalous = true;
            }
            else
                isAnomalous = message.getActivity().equals("Leaving") && message.getEnd() - message.getStart() > 43200000;
        System.out.println("Received is anomalous: " + isAnomalous);
        activityRepository.save(ActivityBuilder.generateEntityFromDTO(new ActivityDTO(message.getPatient(), message.getActivity(), message.getStart(), message.getEnd(), isAnomalous), patientRepository));

        Patient patient = patientRepository.findById(message.getPatient()).get();

        Double t = ((message.getEnd() - message.getStart()) / 3600000.0);

        Integer hours = t.intValue();

        Integer minutes = (int)((t - hours) * 60);
        if(isAnomalous)
            activityController.send(new CustomMessageView("Alert! " + patient.getUser().getName() +
                    " " + message.getActivity() + " " + hours + " hours and " + minutes + " minutes.", patient.getCaregiver().getUserID()));
    }
}
