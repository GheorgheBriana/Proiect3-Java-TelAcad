package com.telacad.proiect3.service;

import com.telacad.proiect3.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void addReservation(int userID, int flightID, int adults, int children) {
        reservationRepository.addReservation(userID, flightID, adults, children);
    }
}
