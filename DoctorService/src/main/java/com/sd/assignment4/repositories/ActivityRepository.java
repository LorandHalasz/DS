package com.sd.assignment4.repositories;

import com.sd.assignment4.entities.Activity;
import com.sd.assignment4.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    @Query(value = "SELECT a " +
            "FROM Activity a " +
            "ORDER BY a.activityID")
    List<Activity> getAllOrdered();
    List<Activity> findActivitiesByPatient(Patient patient);
    Activity findActivitiesByActivityID(Integer activityId);
}
