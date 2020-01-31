package com.example.springdemo.repositories;

import com.example.springdemo.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Integer> {

    @Query(value = "SELECT m " +
            "FROM Medication m " +
            "GROUP BY m.name")
    List<Medication> getAllOrdered();

    Optional<Medication> findOptMedicationByName(String name);
    Medication findMedicationByName(String name);
    List<Medication> findMedicationsByName(String name);
    Medication findMedicationByNameAndDosage(String name, Double dosage);

}
