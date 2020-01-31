package com.example.springdemo.controller;

import com.example.springdemo.dto.MedicationPerPlanDTO;
import com.example.springdemo.dto.MedicationPerPlanViewDTO;
import com.example.springdemo.services.MedicationPerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/medicationPerPlan")
public class MedicationPerPlanController {

    private MedicationPerPlanService medicationPerPlanService;

    @Autowired
    public MedicationPerPlanController(MedicationPerPlanService medicationPerPlanService) {
        this.medicationPerPlanService = medicationPerPlanService;
    }

    @GetMapping(value = "/{id}")
    public MedicationPerPlanViewDTO findById(@PathVariable("id") Integer id){
        return medicationPerPlanService.findMedicationPerPlanById(id);
    }

    @GetMapping(value = "/findAll")
    public List<MedicationPerPlanViewDTO> findAll(){
        return medicationPerPlanService.findAll();
    }

    ////////////////////////////////////////////////////////////////////////////////////
    @GetMapping(value = "/findAllPlans/{username}")
    public List<MedicationPerPlanViewDTO> findAllPlans(@PathVariable("username") String username){
        return medicationPerPlanService.findAllPlans(username);
    }

    @GetMapping(value = "/findAll/{username}")
    public List<MedicationPerPlanViewDTO> findAllById(@PathVariable("username") String username){
        return medicationPerPlanService.findAllMedicationPerPlanById(username);
    }

    @PostMapping(value = "/insertMedicationPerPlan")
    public Integer insertMedicationDTO(@RequestBody MedicationPerPlanDTO medicationPerPlanDTO){
        return medicationPerPlanService.insert(medicationPerPlanDTO);
    }

    @PutMapping(value = "/updateMedicationPerPlan")
    public Integer updateMedication(@RequestBody MedicationPerPlanDTO medicationPerPlanDTO) {
        return medicationPerPlanService.update(medicationPerPlanDTO);
    }

    @DeleteMapping(value = "/deleteMedicationPerPlan")
    public void delete(@RequestBody MedicationPerPlanViewDTO medicationPerPlanViewDTO){
        medicationPerPlanService.delete(medicationPerPlanViewDTO);
    }
}
