package com.example.springdemo.repositories;

import com.example.springdemo.entities.MedicationPlan;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationPlanRepository extends JpaRepository<MedicationPlan, Integer> {

    @Query(value = "SELECT mp " +
            "FROM MedicationPlan mp " +
            "GROUP BY mp.planID")
    List<MedicationPlan> getAllOrdered();

    MedicationPlan findMedicationPlanByPatient(Patient patient);
    List<MedicationPlan> findAllMedicationPlansByPatient(Patient patient);
    MedicationPlan findMedicationPlanByDoctor(User doctor);
    MedicationPlan findMedicationPlanByPlanID(Integer medicationPlanId);
}
