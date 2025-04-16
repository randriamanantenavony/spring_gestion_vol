package com.ticketing.vol.model.client;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "v_detail_reservation")
public class DetailReservation {

    @Id
    @Column(name = "id_reservation_detail")
    private int idReservationDetail;

    @Column(name = "reservation_id")
    private int reservationId;

    @Column(name = "date_reservation")
    private LocalDateTime dateReservation;

    @Column(name = "passager_id")
    private int passagerId;

    @Column(name = "mail_passager")
    private String mailPassager;

    @Column(name = "passeport_img")
    private String passeportImg;

    @Column(name = "statut_reservation")
    private String statutReservation;

    @Column(name = "siege_adulte")
    private int siegeAdulte;

    @Column(name = "siege_enfant")
    private int siegeEnfant;

    @Column(name = "type_siege")
    private String typeSiege;

    @Column(name = "prix")
    private double prix;

    public int getIdReservationDetail() {
        return idReservationDetail;
    }

    public void setIdReservationDetail(int idReservationDetail) {
        this.idReservationDetail = idReservationDetail;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDateTime getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDateTime dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getPassagerId() {
        return passagerId;
    }

    public void setPassagerId(int passagerId) {
        this.passagerId = passagerId;
    }

    public String getMailPassager() {
        return mailPassager;
    }

    public void setMailPassager(String mailPassager) {
        this.mailPassager = mailPassager;
    }

    public String getPasseportImg() {
        return passeportImg;
    }

    public void setPasseportImg(String passeportImg) {
        this.passeportImg = passeportImg;
    }

    public String getStatutReservation() {
        return statutReservation;
    }

    public void setStatutReservation(String statutReservation) {
        this.statutReservation = statutReservation;
    }

    public int getSiegeAdulte() {
        return siegeAdulte;
    }

    public void setSiegeAdulte(int siegeAdulte) {
        this.siegeAdulte = siegeAdulte;
    }

    public int getSiegeEnfant() {
        return siegeEnfant;
    }

    public void setSiegeEnfant(int siegeEnfant) {
        this.siegeEnfant = siegeEnfant;
    }

    public String getTypeSiege() {
        return typeSiege;
    }

    public void setTypeSiege(String typeSiege) {
        this.typeSiege = typeSiege;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getVolId() {
        return volId;
    }

    public void setVolId(int volId) {
        this.volId = volId;
    }

    @Column(name = "vol_id")
    private int volId;


}
