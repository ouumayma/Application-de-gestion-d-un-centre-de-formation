package com.example.ProjetDs.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Formateur extends User{

public Formateur(String nom,String prenom,String email,String password){
    super(nom,prenom,email,password);
}
    @OneToMany(mappedBy = "formateur")
    private List<Cours> cours = new ArrayList<>();


}
