package com.example.springdemo.repositories;

import com.example.springdemo.entities.Patient;
import com.example.springdemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value = "SELECT p " +
            "FROM Patient p " +
            "ORDER BY p.patientID")
    List<Patient> getAllOrdered();

    Patient findPatientByUser(User user);
    Patient findPatientByUserUsername(String username);
    List<Patient> findAllByCaregiverUserID (Integer id);

    void deletePatientByPatientID(Integer id);

}
