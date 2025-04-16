package com.ticketing.vol.model.client;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateheure")
    private LocalDateTime dateHeure;

    @Column(name = "id_passager")
    private Long passagerId;

    private String passeportImg;

    @Column(name = "id_etat_reservation")
    private Long etatReservationId;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDateHeure() { return dateHeure; }
    public void setDateHeure(LocalDateTime dateHeure) { this.dateHeure = dateHeure; }

    public Long getPassagerId() { return passagerId; }
    public void setPassagerId(Long passagerId) { this.passagerId = passagerId; }

    public String getPasseportImg() { return passeportImg; }
    public void setPasseportImg(String passeportImg) { this.passeportImg = passeportImg; }

    public Long getEtatReservationId() { return etatReservationId; }
    public void setEtatReservationId(Long etatReservationId) { this.etatReservationId = etatReservationId; }
}

