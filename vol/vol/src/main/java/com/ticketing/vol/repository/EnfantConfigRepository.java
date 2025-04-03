package com.ticketing.vol.repository;

import org.springframework.stereotype.Repository;

import com.ticketing.vol.model.EnfantConfig;

import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class EnfantConfigRepository {
    private final JdbcTemplate jdbcTemplate;

    public EnfantConfigRepository(JdbcTemplate j){
        this.jdbcTemplate = j;
    }

    public int save(EnfantConfig e){
        String sql = "INSERT INTO enfant(age_min,age_max,pourcentage_prix) values(?,?,?)";
        return jdbcTemplate.update(sql,e.getAgeMin(),e.getAgeMax(),e.getPourcentage());
    }
}
