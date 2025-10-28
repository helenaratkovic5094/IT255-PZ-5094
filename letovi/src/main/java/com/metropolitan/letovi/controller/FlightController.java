package com.metropolitan.letovi.controller;

import com.metropolitan.letovi.entiteti.Flight;
import com.metropolitan.letovi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable int id, @RequestBody Flight flightDetails) {
        System.out.println("Update flight with ID: " + id);
        System.out.println("Flight details: " + flightDetails.toString());
        return flightService.updateFlight(id, flightDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable int id) {
        flightService.deleteFlight(id);
    }

    @GetMapping("/redirect/{id}")
    public RedirectView redirectToBuyTicket(@PathVariable int id) {
        String url = "/kupovanje-karte/" + id;
        return new RedirectView(url);
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable int id) {
        return flightService.getFlightById(id);
    }
}
