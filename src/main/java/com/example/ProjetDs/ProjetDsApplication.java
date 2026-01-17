package com.example.ProjetDs;

import com.example.ProjetDs.Entity.Admin;
import com.example.ProjetDs.Entity.Etudiant;

import com.example.ProjetDs.Repository.AdminRepository;
import com.example.ProjetDs.Repository.EtudiantRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class ProjetDsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetDsApplication.class, args);
	}


}
