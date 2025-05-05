package com.ticketing.vol.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ticketing.vol.model.client.DetailReservation;
import com.ticketing.vol.services.client.DetailReservationService;
import com.ticketing.vol.services.client.PassagerService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/client")
public class PassagerController {

    @Autowired
    private PassagerService passagerService;

    @Autowired
    private DetailReservationService service;

    
    @GetMapping("/index")
    public String login(Model model) {
        return "client/login"; // Fichier login.html (à créer)
    }

    @PostMapping("/login")
    public String loginClient(@RequestParam("mail") String mail, HttpSession session, Model model) {
        try {
            Long id = passagerService.login(mail);  // Appel du service
            session.setAttribute("passagerId", id); // Stockage en session
            return "redirect:/client/success";      // Redirection vers la page de succès
        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors de la connexion. Veuillez réessayer.");
            return "login"; // Reviens à la page login.html avec message d'erreur
        }
    }

   @GetMapping("/success")
    public String successPage(HttpSession session, Model model) {
        Long passagerId = (Long) session.getAttribute("passagerId");
        if (passagerId != null) {
            List<DetailReservation> listes = service.getReservationsByPassagerId(passagerId.intValue());
            model.addAttribute("reservations", listes);
        } else {
            model.addAttribute("error", "Aucun utilisateur connecté.");
        }
        return "client/success";
    }


 

}

