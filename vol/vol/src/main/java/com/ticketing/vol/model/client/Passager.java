package com.ticketing.vol.model.client;

import jakarta.persistence.*;

@Entity
@Table(name = "passager")
public class Passager {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mail;

    // Constructeurs
    public Passager() {}
    
    public Passager(String mail) {
        this.mail = mail;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
