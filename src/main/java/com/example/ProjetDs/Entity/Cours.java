package com.example.ProjetDs.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String titre;

    @Column(length = 50)
    private String description;


    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
    @JsonManagedReference("cours-notes")

    private List<Note> notes;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Seance> seances = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    @JsonIgnoreProperties("cours")

    private Formateur formateur;

    @ManyToOne
    @JsonBackReference
    private SessionPedagogique sessionPedagogique;


    public Cours() {
    }

    public Cours(String titre, String description) {
        this.titre = titre;
        this.description = description;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public SessionPedagogique getSessionPedagogique() {
        return sessionPedagogique;
    }

    public void setSessionPedagogique(SessionPedagogique sessionPedagogique) {
        this.sessionPedagogique = sessionPedagogique;
    }

}
