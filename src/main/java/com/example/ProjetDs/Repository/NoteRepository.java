package com.example.ProjetDs.Repository;

import com.example.ProjetDs.Entity.Cours;
import com.example.ProjetDs.Entity.Etudiant;
import com.example.ProjetDs.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface NoteRepository extends JpaRepository<Note,Long> {

    // Recherche par étudiant
    List<Note> findByEtudiant(Etudiant etudiant);

    // Recherche par cours
    List<Note> findByCours(Cours cours);

    // Recherche note spécifique étudiant-cours
    Optional<Note> findByEtudiantAndCours(Etudiant etudiant, Cours cours);

    List<Note> findByEtudiantId(Long etudiantId);
    List<Note> findByCoursId(Long coursId);
    Optional<Note> findByEtudiantIdAndCoursId(Long etudiantId, Long coursId);

    @Query("SELECT AVG(n.valeur) FROM Note n WHERE n.etudiant.id = :etudiantId")
    Double findMoyenneByEtudiantId(@Param("etudiantId") Long etudiantId);

    @Query("SELECT AVG(n.valeur) FROM Note n WHERE n.cours.id = :coursId")
    Double findMoyenneByCoursId(@Param("coursId") Long coursId);







//    // Calculer la moyenne d'un étudiant
//    @Query("SELECT AVG(n.valeur) FROM Note n WHERE n.etudiant = :etudiant")
//    Double calculateMoyenneByEtudiant(@Param("etudiant") Etudiant etudiant);
//
//    // Calculer la moyenne d'un cours
//    @Query("SELECT AVG(n.valeur) FROM Note n WHERE n.cours = :cours")
//    Double calculateMoyenneByCours(@Param("cours") Cours cours);
//
//    // Notes supérieures à une valeur
//    @Query("SELECT n FROM Note n WHERE n.valeur >= :valeur")
//    List<Note> findByValeurGreaterThanEqual(@Param("valeur") double valeur);
//
//    // Notes inférieures à une valeur
//    @Query("SELECT n FROM Note n WHERE n.valeur < :valeur")
//    List<Note> findByValeurLessThan(@Param("valeur") double valeur);
}
