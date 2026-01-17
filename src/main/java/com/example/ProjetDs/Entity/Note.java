package com.example.ProjetDs.Entity;

import jakarta.persistence.*;

@Entity
public class Note {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private double valeur;

    @ManyToOne
    private Etudiant etudiant;

    @ManyToOne
    private Cours cours;

    public Note(){}

    public Note(double value) {
        this.valeur = value;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
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
