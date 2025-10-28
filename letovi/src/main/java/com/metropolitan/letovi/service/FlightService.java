package com.metropolitan.letovi.service;

import com.metropolitan.letovi.entiteti.Flight;
import com.metropolitan.letovi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

public Flight updateFlight(int id, Flight flightDetails) {
    Flight flight = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));

    flight.setOd(flightDetails.getOd());
    flight.setDestinacija(flightDetails.getDestinacija());
    flight.setVreme(flightDetails.getVreme());
    flight.setBrojPutnika(flightDetails.getBrojPutnika()); // Ovdje nije problem sa null jer je int
    flight.setCena(flightDetails.getCena());

    return flightRepository.save(flight);
}
    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }

    public Flight getFlightById(int id) {
        return flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
    }
}
