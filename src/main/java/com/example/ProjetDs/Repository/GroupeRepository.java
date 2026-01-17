package com.example.ProjetDs.Repository;

import com.example.ProjetDs.Entity.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupeRepository extends JpaRepository<Groupe,Long> {
    // Compter le nombre d'étudiants dans un groupe
    @Query("SELECT COUNT(e) FROM Etudiant e WHERE e.groupe.id = :groupeId")
    long countEtudiantsByGroupeId(@Param("groupeId") Long groupeId);

    // Groupes avec étudiants
    @Query("SELECT DISTINCT g FROM Groupe g WHERE SIZE(g.etudiants) > 0")
    List<Groupe> findGroupesWithEtudiants();
}
