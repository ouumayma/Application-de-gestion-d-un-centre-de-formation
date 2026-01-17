package com.example.ProjetDs.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)

    private String nom;

    @OneToMany(mappedBy = "specialite", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Formateur formateur;
    @JsonIgnore
    private List<Formateur> formateurs = new ArrayList<>();

    public Specialite() {
    }

    public Specialite(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Formateur> getFormateurs() {
        return formateurs;
    }

    public void setFormateurs(List<Formateur> formateurs) {
        this.formateurs = formateurs;
    }}
