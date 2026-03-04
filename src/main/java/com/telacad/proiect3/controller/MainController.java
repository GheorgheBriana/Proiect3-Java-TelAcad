package com.telacad.proiect3.controller;

import com.telacad.proiect3.pojo.User;
import com.telacad.proiect3.service.FlightService;
import com.telacad.proiect3.service.ReservationService;
import com.telacad.proiect3.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MainController {

    private FlightService flightService ;
    private UserService userService;
    private ReservationService reservationService;

    public MainController(FlightService flightService, UserService userService, ReservationService reservationService) {
        this.flightService = flightService;
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    // post registe, add repository verify username.
    @PostMapping("/register")
    public String register(User user, Model model) {
        boolean created = userService.register(user);

        if(!created) {
            model.addAttribute("error", "Username already exists");
            model.addAttribute("username", user.getUsername());
            return "register";
        }

        System.out.println("Account created for: " + user.getUsername());
        return "redirect:/login";
    }

    @GetMapping("/flights")
    public String home(Model model) {
        model.addAttribute("flights", flightService.getAllFlights());
        return "flights";
    }

    @PostMapping("/handleForm")
    public String handleForm(
            @RequestParam(value = "values", required = false) List<String> selectedIds,
            @RequestParam int adults,
            @RequestParam int children,
            HttpSession session) {
        if(selectedIds != null) {
            for(String id : selectedIds) {
                System.out.println("User selected Flight ID " + id);
                reservationService.addReservation(1, Integer.parseInt(id), adults, children);
            }
        }
        return "redirect:/login";

    }






}
