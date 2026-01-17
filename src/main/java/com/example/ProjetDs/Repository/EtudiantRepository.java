package com.example.ProjetDs.Repository;

import com.example.ProjetDs.Entity.Etudiant;
import com.example.ProjetDs.Entity.Groupe;
import com.example.ProjetDs.Entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

//    List<Etudiant> findByMatricule(String matricule);
//    List<Etudiant> findByGroupe(Groupe groupe);
//    List<Etudiant> findBySpecialite(Specialite specialite);
//
//    Optional<Etudiant> findByMatricule(String matricule);

    // Recherche par email (unique)
    Optional<Etudiant> findByEmail(String email);

    // Recherche par nom
    List<Etudiant> findByNom(String nom);

    // Recherche par groupe
    List<Etudiant> findByGroupe(Groupe groupe);

    // Recherche par spécialité
    List<Etudiant> findBySpecialite(Specialite specialite);

    // Vérifier l'existence par matricule
    boolean findByMatricule(String matricule);

    // Vérifier l'existence par email
    boolean existsByEmail(String email);
//
//    // Recherche avec mot-clé (nom, prénom ou matricule)
//    @Query("SELECT e FROM Etudiant e WHERE " +
//            "LOWER(e.nom) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//            "LOWER(e.prenom) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//            "LOWER(e.matricule) LIKE LOWER(CONCAT('%', :keyword, '%'))")
//    List<Etudiant> searchEtudiants(@Param("keyword") String keyword);

}
