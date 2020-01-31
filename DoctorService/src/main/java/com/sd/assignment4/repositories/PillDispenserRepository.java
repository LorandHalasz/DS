package com.sd.assignment4.repositories;

import com.sd.assignment4.entities.Patient;
import com.sd.assignment4.entities.PillDispenser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PillDispenserRepository extends JpaRepository<PillDispenser, Integer> {

    @Query(value = "SELECT p " +
            "FROM PillDispenser p " +
            "ORDER BY p.pillDispenserID")
    List<PillDispenser> getAllOrdered();

    List<PillDispenser> findPillDispenserByDateAndPatient(String date, Patient patient);
    List<PillDispenser> findPillDispenserByPatient(Patient patient);

}
