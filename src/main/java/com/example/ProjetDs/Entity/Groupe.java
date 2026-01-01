package com.example.ProjetDs.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants = new ArrayList<>();
}
