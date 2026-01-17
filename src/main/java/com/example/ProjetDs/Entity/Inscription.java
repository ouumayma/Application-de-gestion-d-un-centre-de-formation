package com.example.ProjetDs.Entity;

import jakarta.persistence.*;

import java.util.Date;



@Entity
public class Inscription {

    @Id
    @GeneratedValue
    private Long id;


    @Temporal(TemporalType.DATE)
    java.util.Date dateInscription;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;

    public Inscription(){}

    public Inscription(Date dateInscription, Etudiant etudiant, Cours cours) {
        this.dateInscription = dateInscription;
        this.etudiant = etudiant;
        this.cours = cours;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
