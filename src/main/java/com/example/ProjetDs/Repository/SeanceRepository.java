package com.example.ProjetDs.Repository;

import com.example.ProjetDs.Entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;


public interface SeanceRepository extends JpaRepository<Seance,Long> {
    // Recherche par date
//    List<Seance> findByDateSeance(Date date);
//
//    // Recherche par salle
//    List<Seance> findBySalle(String salle);

}
