package com.telacad.proiect3.repository;

import com.telacad.proiect3.pojo.Flight;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightRepository {
    private JdbcTemplate jdbcTemplate;

    public FlightRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Flight> getAllFlights() {
        String sql = "SELECT * FROM FLIGHTS";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Flight.class));
    }

    public List<Flight> findFlights(String city, String departureDate) {
        String sql = " SELECT * FROM FLIGHTS WHERE city LIKE ? AND departure_date = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Flight.class),
                "%" + city + "%", departureDate);
    }
}
