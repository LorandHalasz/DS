package com.example.springdemo.controller;

import com.example.springdemo.dto.MedicationDTO;
import com.example.springdemo.dto.MedicationViewDTO;
import com.example.springdemo.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/medication")
public class MedicationController {

    private final MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping(value = "/{id}")
    public MedicationViewDTO findById(@PathVariable("id") Integer id){
        return medicationService.findMedicationById(id);
    }

    @GetMapping(value = "/findAll")
    public List<MedicationViewDTO> findAll(){
        return medicationService.findAll();
    }

    @PostMapping(value = "/insertMedication")
    public Integer insertMedicationDTO(@RequestBody MedicationDTO medicationDTO){
        return medicationService.insert(medicationDTO);
    }

    @PutMapping(value = "/updateMedication")
    public Integer updateMedication(@RequestBody MedicationDTO medicationDTO) {
        return medicationService.update(medicationDTO);
    }

    @DeleteMapping(value = "/deleteMedication/{name}")
    public void delete(@PathVariable("name") String username){
        medicationService.delete(username);
    }
}
