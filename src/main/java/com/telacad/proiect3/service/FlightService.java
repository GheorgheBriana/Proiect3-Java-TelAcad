package com.telacad.proiect3.service;

import com.telacad.proiect3.pojo.Flight;
import com.telacad.proiect3.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.getAllFlights();
    }
}
