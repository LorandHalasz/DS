package com.example.springdemo.repositories;

import com.example.springdemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u " +
            "FROM User u " +
            "ORDER BY u.name")
    List<User> getAllOrdered();

    Optional<User> findByUsername(String username);
    List<User> findAllUserByRole(String role);

    User findUserByUsername(String username);
    User findUserByName(String name);

    void deleteByName(String name);

}
