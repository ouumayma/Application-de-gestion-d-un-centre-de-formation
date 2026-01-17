package com.example.ProjetDs.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private java.util.Date dateSeance;

    @Temporal(TemporalType.TIME)
    private java.util.Date heureDebut;

    @Temporal(TemporalType.TIME)
    private java.util.Date heureFin;

    @Column (length = 50)
    private String Salle ;


    @OneToMany(mappedBy = "cours")
    private List<Cours> cours = new ArrayList<Cours>();


    public Session() {
    }

    public Date getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(Date dateSeance) {
        this.dateSeance = dateSeance;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public String getSalle() {
        return Salle;
    }

    public void setSalle(String salle) {
        Salle = salle;
    }

    public Session(Date dateSeance, Date heureDebut, Date heureFin, String salle) {
        this.dateSeance = dateSeance;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        Salle = salle;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }
}


