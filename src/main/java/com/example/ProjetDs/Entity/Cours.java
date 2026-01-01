package com.example.ProjetDs.Entity;

import jakarta.persistence.*;

@Entity
public class Cours {


    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String code;

    @Column(length = 50)
    private String titre;

    @Column(length = 50)
    private String description;

    @ManyToOne
    private Formateur formateur;

    public String getCode() {
        return code;
    }



    public Cours(String code, String titre, String description) {
        this.code = code;
        this.titre = titre;
        this.description = description;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
