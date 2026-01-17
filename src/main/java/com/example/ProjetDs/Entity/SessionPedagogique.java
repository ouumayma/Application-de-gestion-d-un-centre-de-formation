package com.example.ProjetDs.Entity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SessionPedagogique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String annee;

    private String semestre;

    @OneToMany(mappedBy = "sessionPedagogique", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cours> cours = new ArrayList<>();

    public SessionPedagogique() {
    }

    public SessionPedagogique(String annee, String semestre) {
        this.annee = annee;
        this.semestre = semestre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }}