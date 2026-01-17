package com.example.ProjetDs.Repository;

import com.example.ProjetDs.Entity.Formateur;
import com.example.ProjetDs.Entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FormateurRepository extends JpaRepository<Formateur,Long> {



    Optional<Formateur> findByEmail(String email);

    // Recherche par nom
    List<Formateur> findByNom(String nom);

    // Recherche par spécialité
    List<Formateur> findBySpecialite(Specialite specialite);

    // Vérifier l'existence par email
    boolean existsByEmail(String email);

    // Recherche avec mot-clé (nom ou prénom)
    @Query("SELECT f FROM Formateur f WHERE " +
            "LOWER(f.nom) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(f.prenom) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Formateur> searchFormateurs(@Param("keyword") String keyword);
}
