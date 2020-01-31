package com.example.springdemo.repositories;

import com.example.springdemo.entities.Activity;
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

}
