package com.ticketing.vol.repository.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.ticketing.vol.model.admin.Admin;

@Repository
public class AdminRepository{
    
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public AdminRepository(JdbcTemplate j){
        this.jdbcTemplate=j;
    }

    public Admin getAdmin(String mail, String mdp) {
        String sql = "SELECT id, mail, mdp FROM admin WHERE mail = ? AND mdp = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Admin.class), mail, mdp);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
     
}


