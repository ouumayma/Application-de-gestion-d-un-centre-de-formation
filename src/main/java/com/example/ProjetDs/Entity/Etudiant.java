package com.example.ProjetDs.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Etudiant extends User{

    private String matricule;

    @ManyToOne
    private Groupe groupe;

    @ManyToOne
    private Specialite specialite;

    public Etudiant(String nom,String prenom,String email,String password,String matricule) {
        super(nom,prenom,password,email);
        this.matricule = matricule;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "matricule='" + matricule + '\'' +
                '}';
    }


}
