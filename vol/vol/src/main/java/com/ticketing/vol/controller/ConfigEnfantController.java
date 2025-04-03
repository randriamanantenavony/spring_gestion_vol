package com.ticketing.vol.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ticketing.vol.model.EnfantConfig;
import com.ticketing.vol.repository.EnfantConfigRepository;

@Controller
public class ConfigEnfantController {

    private final EnfantConfigRepository enfantConfigRepository;

    @GetMapping("/index")
    public String afficherFormulaire() {
        return "config_enfant";
    }

    @Autowired
    public ConfigEnfantController(EnfantConfigRepository e){
        this.enfantConfigRepository = e;
    }

    
    @PostMapping("/save")
    public String saveEnfantConfig(@RequestParam int age_min,
                                   @RequestParam int age_max,
                                   @RequestParam int pourcentage,
                                   RedirectAttributes redirectAttributes) {
        EnfantConfig enfantConfig = new EnfantConfig();
        enfantConfig.setAgeMin(age_min);
        enfantConfig.setAgeMax(age_max);
        enfantConfig.setPourcentage(pourcentage);
        enfantConfig.setDateModif(new Date(System.currentTimeMillis()));
        
        int result = enfantConfigRepository.save(enfantConfig);
        
        if (result > 0) {
            redirectAttributes.addFlashAttribute("success", "Configuration enregistrée avec succès");
        } else {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de l'enregistrement");
        }
        
        return "redirect:/index"; 
    }

}

