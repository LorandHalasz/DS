package com.sd.assignment4.repositories;

import com.sd.assignment4.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Integer> {

    @Query(value = "SELECT r " +
            "FROM Recommendation r " +
            "ORDER BY r.recommendationID")
    List<Recommendation> getAllOrdered();
}
