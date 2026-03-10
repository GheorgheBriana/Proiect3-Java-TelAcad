package com.telacad.proiect3.controller;

import com.telacad.proiect3.pojo.Flight;
import com.telacad.proiect3.pojo.User;
import com.telacad.proiect3.service.FlightService;
import com.telacad.proiect3.service.ReservationService;
import com.telacad.proiect3.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String index(HttpSession session) {
        if (session.getAttribute("currentUserID") == null) {
            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

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

    @GetMapping("/login")
    public String showLoginPage() {
        return "loginPage";
    }

    @PostMapping("/login")
    public String login (
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model) {
        User user = userService.login(username, password);

        if(user == null) {
            model.addAttribute("error", "Invalid username or password");
            model.addAttribute("username", username);
            return "loginPage";
        }

        session.setAttribute("currentUserID", user.getId());
        session.setAttribute("currentUsername", user.getUsername());
        return "redirect:/";
    }

    @GetMapping("/searchFlights")
    public String searchFlights (@RequestParam String city,
                                @RequestParam("checkIn") String departureDate,
                                @RequestParam(defaultValue = "0") int adults,
                                @RequestParam(defaultValue = "0") int children,
                                HttpSession session,
                                Model model) {

        List<Flight> flights = flightService.findFlights(city, departureDate);

        if (flights.isEmpty()) {
            model.addAttribute("message", "No flights found for your selection.");
        }
        session.setAttribute("adults", adults);
        session.setAttribute("children", children);

        model.addAttribute("flights", flights);
        model.addAttribute("adults", adults);
        model.addAttribute("children", children);
        return "flights";
    }

    @PostMapping("/handleForm")
    public String handleForm(
            @RequestParam(value = "values", required = false) List<String> selectedIds,
            @RequestParam(defaultValue = "0") int adults,
            @RequestParam(defaultValue = "0") int children,
            HttpSession session) {

        Integer userId = (Integer) session.getAttribute("currentUserID");
        if (userId == null) {
            return "redirect:/login";
        }

        if(selectedIds != null) {
            for(String id : selectedIds) {
                System.out.println("User selected Flight ID " + id);
                reservationService.addReservation(userId, Integer.parseInt(id), adults, children);
            }
        }
        return "redirect:/";

    }

    @GetMapping("/profile")
    public String showProfile(HttpSession session, Model model) {
        // vedem daca userul e logat
        Integer userId = (Integer) session.getAttribute("currentUserID");
        String username = (String) session.getAttribute("currentUsername");

        if(userId == null) {
            return "redirect:/login";
        }

        // legatura intre controller si html
        model.addAttribute("userId", userId);
        model.addAttribute("username", username);
        return "profile";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // sterge tot din sesiune (userId, username, password
        return "redirect:/login";
    }






}
