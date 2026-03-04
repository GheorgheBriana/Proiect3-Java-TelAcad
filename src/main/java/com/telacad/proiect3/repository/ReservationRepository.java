package com.telacad.proiect3.repository;

import com.telacad.proiect3.pojo.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    private JdbcTemplate jdbcTemplate;

    public ReservationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addReservation(Reservation reservation) {
        String sql = "INSERT INTO RESERVATIONS(id_user, id_zbor, number_of_childrens, number_of_adults) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, reservation.getIdUser(), reservation.getIdZbor(), reservation.getNumberOfChildrens(), reservation.getNumberOfAdults());
    }
}
