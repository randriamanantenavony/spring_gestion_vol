package com.ticketing.vol.model.admin;

public class Admin {

    int id;
    String mail;
    String mdp;

    // Constructeur par défaut (ajouté)
    public Admin() {
    }

    public Admin(String mail, String mdp) {
        this.mail = mail;
        this.mdp = mdp;
    }

    // Ajoutez les getters et setters ici !
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}

