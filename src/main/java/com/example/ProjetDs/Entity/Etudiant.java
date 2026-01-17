package com.example.ProjetDs.Entity;

import com.example.ProjetDs.Entity.enums.Role;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Etudiant extends User{

    @Column(unique = true, nullable = false)
    private String matricule;

    @ManyToOne(fetch = FetchType.EAGER)
    private Groupe groupe;

    @ManyToOne(fetch = FetchType.EAGER)
    private Specialite specialite;


    @OneToMany(mappedBy = "etudiant",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Collection<Inscription> inscriptions =new ArrayList<Inscription>();


    public Etudiant(){}

    public Etudiant(String nom,String prenom,String email,String password,String matricule) {
        super(nom,prenom,email,password, Role.ETUDIANT);
        this.matricule = matricule;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Collection<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Collection<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", groupe=" + groupe +
                ", specialite=" + specialite +
                '}';
    }
}
