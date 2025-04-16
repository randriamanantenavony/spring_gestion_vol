package com.ticketing.vol.services.client;

import com.ticketing.vol.model.client.Reservation;
import com.ticketing.vol.repository.client.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void annulerReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
            .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));

        // On suppose que le statut "Annulée" a l'ID 3 par exemple
        reservation.setEtatReservationId(2L); 

        reservationRepository.save(reservation);
    }
}

