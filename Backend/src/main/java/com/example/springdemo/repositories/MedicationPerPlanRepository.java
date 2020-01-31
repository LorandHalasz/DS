package com.example.springdemo.repositories;

import com.example.springdemo.entities.Medication;
import com.example.springdemo.entities.MedicationPerPlan;
import com.example.springdemo.entities.MedicationPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationPerPlanRepository extends JpaRepository<MedicationPerPlan, Integer> {

    @Query(value = "SELECT mp " +
            "FROM MedicationPerPlan mp " +
            "GROUP BY mp.medicationPerPlanID")
    List<MedicationPerPlan> getAllOrdered();

    MedicationPerPlan findMedicationPerPlanByMedicationPerPlanID(Integer medicationPerPlanID);
    List<MedicationPerPlan> findMedicationPerPlanByMedicationPlan(MedicationPlan medicationPlan);
    MedicationPerPlan findMedicationPerPlanByMedication(Medication medication);
}
