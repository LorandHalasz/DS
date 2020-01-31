package com.sd.assignment4.services;

import com.sd.assignment4.dto.ActivityDTO;
import com.sd.assignment4.dto.MapDTO;
import com.sd.assignment4.dto.PatientDTO;
import com.sd.assignment4.dto.PillDispenserDTO;
import com.sd.assignment4.entities.Patient;
import com.sd.assignment4.entities.PillDispenser;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface DoctorService {

    @WebMethod
    public List<PillDispenserDTO> getAllPillDispenser(String patientUsername, String date);

    @WebMethod
    public List<ActivityDTO> getAllActivities(String patientUsername, String date);

    @WebMethod
    public void saveActivity(Integer activityID);

    @WebMethod
    public MapDTO getMap(String patientUsername, String date);

    @WebMethod
    public void saveRecommendation(String patientUsername, String date);

}