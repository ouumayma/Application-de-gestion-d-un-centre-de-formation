package com.example.ProjetDs.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Groupe(){}



    @OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL)
    private Collection<Etudiant> etudiants = new ArrayList<>();

    public Collection<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }



}
