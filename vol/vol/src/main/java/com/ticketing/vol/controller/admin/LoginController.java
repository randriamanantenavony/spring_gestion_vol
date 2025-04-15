package com.ticketing.vol.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ticketing.vol.model.admin.Admin;
import com.ticketing.vol.services.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    private final AdminService adminService;

    @Autowired
    public LoginController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        return "login"; 
    }
    

  @PostMapping("/login")
    public String login(@RequestParam String mail, @RequestParam String mdp, 
                        HttpSession session, RedirectAttributes redirectAttributes) {
        Admin admin = adminService.login(mail, mdp);

        if (admin != null) {
            System.out.println("Login réussi !!!");
            session.setAttribute("user", admin); 
            return "index";
        } else {
            System.out.println("Échec du login");
            redirectAttributes.addFlashAttribute("error", "Email ou mot de passe incorrect !");
            return "redirect:/admin/home";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/home";
    }


}