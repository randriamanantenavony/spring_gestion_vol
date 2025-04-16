package com.ticketing.vol.repository.client;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketing.vol.model.client.DetailReservation;

import java.util.List;

public interface DetailReservationRepository extends JpaRepository<DetailReservation, Integer> {
    List<DetailReservation> findByPassagerId(int passagerId);
}

