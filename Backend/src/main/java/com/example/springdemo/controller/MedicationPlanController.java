package com.example.springdemo.controller;

import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.dto.MedicationPlanViewDTO;
import com.example.springdemo.services.MedicationPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/medicationPlan")
public class MedicationPlanController {

    private final MedicationPlanService medicationPlanService;

    @Autowired
    public MedicationPlanController(MedicationPlanService medicationPlanService) {
        this.medicationPlanService = medicationPlanService;
    }

    @GetMapping(value = "/{id}")
    public MedicationPlanViewDTO findById(@PathVariable("id") Integer id){
        return medicationPlanService.findMedicationPlanById(id);
    }

    @GetMapping(value = "/findAll")
    public List<MedicationPlanViewDTO> findAll(){
        return medicationPlanService.findAll();
    }

    @PostMapping(value = "/insertMedicationPlan")
    public Integer insertMedicationDTO(@RequestBody MedicationPlanDTO medicationPlanDTO){
        return medicationPlanService.insert(medicationPlanDTO);
    }

    @PutMapping(value = "/updateMedicationPlan")
    public Integer updateMedication(@RequestBody MedicationPlanDTO medicationPlanDTO) {
        return medicationPlanService.update(medicationPlanDTO);
    }

    @DeleteMapping(value = "/deleteMedicationPlan")
    public void delete(@RequestBody MedicationPlanViewDTO medicationPlanViewDTO){
        medicationPlanService.delete(medicationPlanViewDTO);
    }
}