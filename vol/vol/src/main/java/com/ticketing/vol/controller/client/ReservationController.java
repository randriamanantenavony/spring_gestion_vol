package com.ticketing.vol.controller.client;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ticketing.vol.model.client.DetailReservation;
import com.ticketing.vol.services.client.ReservationService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/annuler")
    public String annulerReservation(@RequestParam("idReservationDetail") Long idReservationDetail, HttpSession session, Model model) {
        reservationService.annulerReservation(idReservationDetail);
        return "redirect:/client/success";
    }
}

