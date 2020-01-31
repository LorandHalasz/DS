package com.example.springdemo.controller;

import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.dto.PatientViewDTO;
import com.example.springdemo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/{id}")
    public PatientViewDTO findById(@PathVariable("id") Integer id){
        return patientService.findPatientById(id);
    }

    @GetMapping(value = "/findAll")
    public List<PatientViewDTO> findAll(){
        return patientService.findAll();
    }

    @GetMapping(value = "/findAll/{username}")
    public List<PatientViewDTO> findAllPatientsForACaregiver(@PathVariable("username") String username){
        return patientService.findAllPatientsForACaregiver(username);
    }

    @PostMapping(value = "/insertPatient")
    public Integer insertPatientDTO(@RequestBody PatientDTO patientDTO){
        return patientService.insert(patientDTO);
    }

    @PutMapping(value = "/updatePatient")
    public Integer updatePatient(@RequestBody PatientDTO patientDTO) {
        return patientService.update(patientDTO);
    }

    @DeleteMapping(value = "/deletePatient/{username}")
    public void delete(@PathVariable("username") String username){
        patientService.delete(username);
    }
}
