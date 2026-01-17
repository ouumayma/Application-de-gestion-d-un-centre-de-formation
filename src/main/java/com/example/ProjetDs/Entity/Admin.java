package com.example.ProjetDs.Entity;

import com.example.ProjetDs.Entity.enums.Role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User  {

        public Admin() {}

    public Admin(String nom, String prenom, String email, String password, Role role) {
        super(nom, prenom, email, password, role);
    }

    public Admin(String email, String password) {
            super( email, password);
        }

    public Admin(String email, String password, Role role) {
        super(email, password, role);
    }

}


