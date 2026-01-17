package com.example.ProjetDs.Repository;

import com.example.ProjetDs.Entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;


public interface SessionRepository extends JpaRepository<Session,Long> {
    // Recherche par date
    List<Session> findByDateSeance(Date date);

    // Recherche par salle
    List<Session> findBySalle(String salle);

    // Sessions entre deux dates
    @Query("SELECT s FROM Session s WHERE s.dateSeance BETWEEN :debut AND :fin")
    List<Session> findByDateSeanceBetween(@Param("debut") Date debut, @Param("fin") Date fin);

    // Vérifier conflit d'horaire dans une salle
    @Query("SELECT COUNT(s) > 0 FROM Session s WHERE " +
            "s.salle = :salle AND s.dateSeance = :date AND " +
            "((s.heureDebut <= :heureFin AND s.heureFin >= :heureDebut))")
    boolean hasConflict(@Param("salle") String salle,
                        @Param("date") Date date,
                        @Param("heureDebut") Date heureDebut,
                        @Param("heureFin") Date heureFin);
}
