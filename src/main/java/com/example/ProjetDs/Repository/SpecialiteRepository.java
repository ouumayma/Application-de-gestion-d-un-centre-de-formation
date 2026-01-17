package com.example.ProjetDs.Repository;

import com.example.ProjetDs.Entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpecialiteRepository extends JpaRepository<Specialite,Long> {
    // Recherche par nom
    Optional<Specialite> findByNom(String nom);

    // Vérifier l'existence par nom
    boolean existsByNom(String nom);

    // Compter les formateurs par spécialité
    @Query("SELECT COUNT(f) FROM Formateur f WHERE f.specialite.id = :specialiteId")
    long countFormateursBySpecialiteId(@Param("specialiteId") Long specialiteId);

    // Spécialités avec formateurs
    @Query("SELECT DISTINCT s FROM Specialite s WHERE SIZE(s.formateurs) > 0")
    List<Specialite> findSpecialitesWithFormateurs();

}
