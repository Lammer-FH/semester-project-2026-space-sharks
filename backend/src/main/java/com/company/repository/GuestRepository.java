package com.company.repository;

import com.company.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface GuestRepository extends JpaRepository<Guest, Integer> {

    Optional<Guest> findByFirstNameAndLastNameAndEmail(
        String firstName,
        String lastName,
        String email
    );

    boolean existsByEmail(String email);
}