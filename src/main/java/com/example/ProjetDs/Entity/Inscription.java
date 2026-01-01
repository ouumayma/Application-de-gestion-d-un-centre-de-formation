package com.example.ProjetDs.Entity;

import jakarta.persistence.*;

@Entity
public class Inscription {

    @Id
    @GeneratedValue
    private Long id;


    @Temporal(TemporalType.DATE)
    java.util.Date dateInscription;
}
