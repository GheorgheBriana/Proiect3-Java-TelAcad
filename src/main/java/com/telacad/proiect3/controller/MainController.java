package com.telacad.proiect3.controller;

import com.telacad.proiect3.pojo.Flight;
import com.telacad.proiect3.pojo.User;
import com.telacad.proiect3.repository.FlightRepository;
import com.telacad.proiect3.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private FlightRepository flightRepository;
    private UserRepository userRepository;

    public MainController(FlightRepository flightRepository, UserRepository userRepository) {
        this.flightRepository = flightRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/flights")
    public String home(Model model) {
        model.addAttribute("flights", flightRepository.getAllFlights());
        return "flights";
    }

    @PostMapping("/register")
    public String register(User user) {

        // save 'user' object in MySQL
        userRepository.addUser(user);
        System.out.println("Account created for: " + user.getUsername());
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }


}
