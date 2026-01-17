package com.example.ProjetDs.Entity;

import com.example.ProjetDs.Entity.enums.Role;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Formateur extends User{


    public Formateur(){}

public Formateur(String nom,String prenom,String email,String password){

    super(nom,prenom,email,password, Role.FORMATEUR);
}
    @OneToMany(mappedBy = "formateur",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Collection<Cours> cours = new ArrayList<Cours>();

    @ManyToOne
    private Specialite specialite;

    public Collection<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }
}
