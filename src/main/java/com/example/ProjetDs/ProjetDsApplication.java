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
	@Bean
	CommandLineRunner init(
			EtudiantRepository etudiantRepo,
			AdminRepository adminRepo
	) {
		return args -> {

			Admin admin = new Admin(
					"admin@gmail.com",
					"1234"
			);

			adminRepo.save(admin);

			Etudiant e1 = new Etudiant(
					"Ali",
					"Ben Salah",
					"ali@gmail.com",
					"1234",
					"12"
			);

			etudiantRepo.save(e1);

			Etudiant etudiant = new Etudiant(
					"Ali",
					"Ben Salah",
					"ali@gmail.com",
					"1234",
					"MAT2026"
			);

			etudiantRepo.save(etudiant);
		};
	}



}
