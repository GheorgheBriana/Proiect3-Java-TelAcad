package com.telacad.proiect3.repository;

import com.telacad.proiect3.pojo.Reservation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepository {
    private JdbcTemplate jdbcTemplate;

    public ReservationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addReservation(int userID, int flightID, int adults, int children) {
        String sql = "INSERT INTO RESERVATIONS(id_user, id_zbor, number_of_childrens, number_of_adults) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, userID, flightID, adults, children);
    }

    public List<Reservation> findReservationByUserId(int userId) {
        String sql = "SELECT * FROM RESERVATIONS WHERE id_user = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Reservation.class), userId);
    }
}
