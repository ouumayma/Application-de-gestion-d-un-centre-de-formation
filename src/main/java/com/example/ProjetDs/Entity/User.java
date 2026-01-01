package com.example.ProjetDs.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import javax.management.relation.Role;

// pour déclarer une classe mère (non entité)
@MappedSuperclass
public class User {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    protected Long id;

    @Column (length = 50)
    protected String nom;

    @Column (length = 50)
    protected String prenom;

    @Email
    @Column(unique = true)
    protected String email;

    protected String password ;

    @Enumerated(EnumType.STRING)
    protected Role role ;

    public User(String nom,String prenom,String email, String password) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
