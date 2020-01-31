package com.example.springdemo.services;

import com.example.springdemo.dto.MedicationDTO;
import com.example.springdemo.dto.MedicationViewDTO;
import com.example.springdemo.dto.builders.MedicationBuilder;
import com.example.springdemo.dto.builders.MedicationViewBuilder;
import com.example.springdemo.entities.Medication;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.MedicationRepository;
import com.example.springdemo.validators.MedicationFieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public MedicationViewDTO findMedicationById(Integer id) {
        Optional<Medication> medication  = medicationRepository.findById(id);

        if (!medication.isPresent()) {
            throw new ResourceNotFoundException("Medication", "medication id", id);
        }
        return MedicationViewBuilder.generateDTOFromEntity(medication.get());
    }

    public List<MedicationViewDTO> findAll() {
        List<Medication> medications = medicationRepository.getAllOrdered();

        return medications.stream()
                .map(MedicationViewBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Integer insert(MedicationDTO medicationDTO) {

        MedicationFieldValidator.validateInsertOrUpdate(medicationDTO);

        return medicationRepository
                .save(MedicationBuilder.generateEntityFromDTO(medicationDTO))
                .getDrugID();
    }

    @Transactional
    public Integer update(MedicationDTO medicationDTO) {

        Optional<Medication> medication = medicationRepository.findOptMedicationByName(medicationDTO.getName());

        if(!medication.isPresent()) {
            throw new ResourceNotFoundException("Medication", "medication id", medication.get().getDrugID().toString());
        }
        MedicationFieldValidator.validateInsertOrUpdate(medicationDTO);

        medication.get().setDosage(medicationDTO.getDosage());
        medication.get().setSideEffects(medicationDTO.getSideEffects());

        return medication.get().getDrugID();
    }

    @Transactional
    public void delete(String name){
        MedicationFieldValidator.validateName(name);

        List<Medication> medications = medicationRepository.findMedicationsByName(name);
        this.medicationRepository.deleteAll(medications);
    }
}
