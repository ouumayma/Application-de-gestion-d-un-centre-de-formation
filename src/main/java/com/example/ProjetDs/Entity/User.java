package com.example.ProjetDs.Entity;

import com.example.ProjetDs.Entity.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;


// pour déclarer une classe mère (non entité)

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "utilisateur")
@DiscriminatorColumn(name = "TYPE_USER")
public abstract class User {

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

    public User (){}

    public User(String nom,String prenom,String email, String password, Role role) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.role=role;
    }
    public User(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
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

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
