package com.example.ProjetDs.Repository;

import com.example.ProjetDs.Entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface CoursRepository extends JpaRepository<Cours,Long> {
    Optional<Cours> findByCode(String code);
    List<Cours> findByFormateurId(Long formateurId);
    List<Cours> findBySpecialiteId(Long specialiteId);
    List<Cours> findBySessionId(Long sessionId);
    List<Cours> findByActifTrue();

    @Query("SELECT c FROM Cours c JOIN c.groupes g WHERE g.id = :groupeId")
    List<Cours> findCoursByGroupe(@Param("groupeId") Long groupeId);

    @Query("SELECT c FROM Cours c WHERE " +
            "LOWER(c.titre) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(c.code) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Cours> searchCours(@Param("keyword") String keyword);

    @Query("SELECT c FROM Cours c JOIN c.inscriptions i WHERE i.etudiant.id = :etudiantId AND i.statut = 'ACTIVE'")
    List<Cours> findCoursByEtudiant(@Param("etudiantId") Long etudiantId);
}
