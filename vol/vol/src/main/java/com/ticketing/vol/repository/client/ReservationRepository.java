package com.ticketing.vol.repository.client;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketing.vol.model.client.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

