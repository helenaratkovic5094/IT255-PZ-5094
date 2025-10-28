package com.metropolitan.letovi.repository;

import com.metropolitan.letovi.entiteti.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findById(int id);
}
