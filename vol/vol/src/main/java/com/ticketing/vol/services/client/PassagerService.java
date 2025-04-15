package com.ticketing.vol.services.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketing.vol.model.client.Passager;
import com.ticketing.vol.repository.client.PassagerRepository;

@Service
public class PassagerService {

    @Autowired
    private PassagerRepository passagerRepository;

    public Long login(String mail) {
        return passagerRepository.findByMail(mail)
                .map(Passager::getId)
                .orElseGet(() -> {
                    Passager nouveau = new Passager(mail);
                    return passagerRepository.save(nouveau).getId();
                });
    }
}
