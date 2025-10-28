package com.metropolitan.letovi.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metropolitan.letovi.entiteti.Flight;
import com.metropolitan.letovi.controller.FlightController;
import com.metropolitan.letovi.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightControllerTest {

    @Mock
    private FlightService flightService;

    @InjectMocks
    private FlightController flightController;

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testGetAllFlights() throws Exception {
//        // Kreiramo primer letova koji se očekuju kao odgovor
//        Flight flight1 = new Flight(1, "Belgrade", "Paris", "12:00", 150, 200);
//        Flight flight2 = new Flight(2, "Belgrade", "London", "14:00", 200, 250);
//        List<Flight> flights = Arrays.asList(flight1, flight2);
//
//        // Mock-ujemo poziv servisa koji vraća listu letova
//        when(flightService.getAllFlights()).thenReturn(flights);
//
//        // Izvršavamo GET zahtev na /api/flights
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/flights"))
//                .andExpect(MockMvcResultMatchers.status().isOk())  // Očekujemo status 200 OK
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))  // Očekujemo JSON kao odgovor
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].od").value("Belgrade"))  // Proveravamo prvi let: polazna tačka
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].destinacija").value("Paris"))  // Proveravamo prvi let: destinacija
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].od").value("Belgrade"))  // Proveravamo drugi let: polazna tačka
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].destinacija").value("London"));  // Proveravamo drugi let: destinacija
//    }


    @Test
    public void testCreateFlight() throws Exception {
        Flight flight = new Flight(1, "Belgrade", "Paris", "12:00", 150, 200);

        when(flightService.saveFlight(any(Flight.class))).thenReturn(flight);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(flight)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.od").value("Belgrade"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.destinacija").value("Paris"));

    }

}

