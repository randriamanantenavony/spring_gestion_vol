package com.ticketing.vol.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ticketing.vol.model.admin.Admin;
import com.ticketing.vol.repository.admin.AdminRepository;

@Service
public class AdminService {
    
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public Admin login(String mail,String mdp){
        return this.adminRepository.getAdmin(mail, mdp);
    }
}
