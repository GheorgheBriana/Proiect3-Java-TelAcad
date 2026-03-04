package com.telacad.proiect3.controller;

import com.sun.tools.javac.Main;
import com.telacad.proiect3.pojo.Flight;
import com.telacad.proiect3.repository.FlightRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private FlightRepository flightRepository;

    public MainController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("flights", flightRepository.getAllFlights());
        return "index";
    }
}
