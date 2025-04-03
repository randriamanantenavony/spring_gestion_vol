package com.ticketing.vol.model;

import java.sql.Date;

public class EnfantConfig {
    int id;
    int age_min;
    int age_max;
    int pourcentage;
    Date date_modif;

    public int getId(){return this.id;}
    public int getAgeMin(){return this.age_min;}
    public int getAgeMax(){return this.age_max;}
    public int getPourcentage(){return this.pourcentage;}
    public Date getDateModif(){return this.date_modif;}

    public void setId(int id){this.id=id;}
    public void setAgeMin(int a){this.age_min=a;}
    public void setAgeMax(int a){this.age_max=a;}
    public void setDateModif(Date d){this.date_modif=d;}
    public void setPourcentage(int p){this.pourcentage=p;}


}
