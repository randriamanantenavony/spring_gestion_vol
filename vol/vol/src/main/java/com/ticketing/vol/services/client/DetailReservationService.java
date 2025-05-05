package com.ticketing.vol.services.client;

import org.springframework.stereotype.Service;

import com.ticketing.vol.model.client.DetailReservation;
import com.ticketing.vol.repository.client.DetailReservationRepository;

import java.util.List;

@Service
public class DetailReservationService {

    private final DetailReservationRepository repository;

    public DetailReservationService(DetailReservationRepository repository) {
        this.repository = repository;
    }

    public List<DetailReservation> getReservationsByPassagerId(int passagerId) {
        return repository.findByPassagerId(passagerId);
    }

    public DetailReservation getReservationById(int idReservationDetail) {
        return repository.findById(idReservationDetail).orElse(null);
    }
    
}

