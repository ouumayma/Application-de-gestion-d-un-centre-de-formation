package com.example.ProjetDs.Service;
import com.example.ProjetDs.Entity.Cours;
import com.example.ProjetDs.Entity.Etudiant;
import com.example.ProjetDs.Entity.Inscription;
import com.example.ProjetDs.Repository.CoursRepository;
import com.example.ProjetDs.Repository.EtudiantRepository;
import com.example.ProjetDs.Repository.InscriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService {

    private  InscriptionRepository inscriptionRepository;
    private  EtudiantRepository etudiantRepository;
    private  CoursRepository coursRepository;

    public Inscription inscrireEtudiant(Long etudiantId, Long coursId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));

        Cours cours = coursRepository.findById(coursId)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé"));

        // Vérifier si l'étudiant est déjà inscrit
        if (inscriptionRepository.existsByEtudiantIdAndCoursId(etudiantId, coursId)) {
            throw new RuntimeException("L'étudiant est déjà inscrit à ce cours");
        }

        Inscription inscription = new Inscription();
        inscription.setEtudiant(etudiant);
        inscription.setCours(cours);

        return inscriptionRepository.save(inscription);
    }

    public void annulerInscription(Long inscriptionId) {
        if (!inscriptionRepository.existsById(inscriptionId)) {
            throw new RuntimeException("Inscription non trouvée");
        }
        inscriptionRepository.deleteById(inscriptionId);
    }

    public void annulerInscriptionParEtudiantEtCours(Long etudiantId, Long coursId) {
        Inscription inscription = inscriptionRepository
                .findByEtudiantIdAndCoursId(etudiantId, coursId)
                .orElseThrow(() -> new RuntimeException("Inscription non trouvée"));

        inscriptionRepository.delete(inscription);
    }

    @Transactional
    public Inscription getInscriptionById(Long id) {
        return inscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscription non trouvée"));
    }

    @Transactional
    public List<Inscription> getInscriptionsEtudiant(Long etudiantId) {
        if (!etudiantRepository.existsById(etudiantId)) {
            throw new RuntimeException("Étudiant non trouvé");
        }
        return inscriptionRepository.findByEtudiantIdWithCours(etudiantId);
    }

    @Transactional
    public List<Inscription> getInscriptionsCours(Long coursId) {
        if (!coursRepository.existsById(coursId)) {
            throw new RuntimeException("Cours non trouvé");
        }
        return inscriptionRepository.findByCoursId(coursId);
    }

    @Transactional
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

}
