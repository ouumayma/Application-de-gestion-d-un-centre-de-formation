package com.example.ProjetDs.Repository;

import com.example.ProjetDs.Entity.Cours;
import com.example.ProjetDs.Entity.Formateur;
import com.example.ProjetDs.Entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {

    List<Inscription> findByEtudiantId(Long etudiantId);
    List<Inscription> findByCoursId(Long coursId);
    Optional<Inscription> findByEtudiantIdAndCoursId(Long etudiantId, Long coursId);
    boolean existsByEtudiantIdAndCoursId(Long etudiantId, Long coursId);

    @Query("SELECT i FROM Inscription i JOIN FETCH i.cours WHERE i.etudiant.id = :etudiantId")
    List<Inscription> findByEtudiantIdWithCours(@Param("etudiantId") Long etudiantId);
}