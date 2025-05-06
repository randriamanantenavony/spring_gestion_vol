package com.ticketing.vol.controller.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ticketing.vol.model.client.DetailReservation;
import com.ticketing.vol.services.client.DetailReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class DetailReservationController {

    private final DetailReservationService service;
    private DetailReservation reservationTemporaire; // stockage temporaire

    public DetailReservationController(DetailReservationService service) {
        this.service = service;
    }

    @GetMapping("/{passagerId}")
    public List<DetailReservation> getByPassagerId(@PathVariable int passagerId) {
        List<DetailReservation> listes = service.getReservationsByPassagerId(passagerId);
        System.out.println("Taille de la liste :" + listes.size());
        return listes;
    }

    @GetMapping("/export/{idReservationDetail}")
    public ResponseEntity<DetailReservation> exporterReservation(@PathVariable int idReservationDetail) {
        DetailReservation reservation = service.getReservationById(idReservationDetail);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }
        this.reservationTemporaire = reservation; 
        return ResponseEntity.ok(reservation);
    }

    @GetMapping("/temp")
    public ResponseEntity<DetailReservation> getReservationTemporaire() {
        if (reservationTemporaire == null) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(reservationTemporaire);
    }
}
