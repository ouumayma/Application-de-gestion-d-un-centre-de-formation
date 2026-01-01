package com.example.ProjetDs.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Note {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private double value;
}
