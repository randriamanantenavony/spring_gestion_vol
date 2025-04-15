package com.ticketing.vol.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketing.vol.model.client.Passager;

import java.util.Optional;

public interface PassagerRepository extends JpaRepository<Passager, Long> {
    Optional<Passager> findByMail(String mail);
}
