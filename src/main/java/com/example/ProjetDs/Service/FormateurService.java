package com.example.ProjetDs.Service;


import com.example.ProjetDs.Entity.Cours;
import com.example.ProjetDs.Entity.Formateur;
import com.example.ProjetDs.Entity.Specialite;
import com.example.ProjetDs.Repository.CoursRepository;
import com.example.ProjetDs.Repository.EtudiantRepository;
import com.example.ProjetDs.Repository.FormateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormateurService {

    private  FormateurRepository formateurRepository;
    private  CoursRepository coursRepository;

    public Formateur creerFormateur(Formateur formateur) {
        if (formateurRepository.existsByEmail(formateur.getEmail())) {
            throw new RuntimeException("Un formateur avec cet email existe déjà");
        }
        return formateurRepository.save(formateur);
    }

    public Formateur modifierFormateur(Long id, Formateur formateurDetails) {
        Formateur formateur = formateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formateur non trouvé"));

        // Vérifier l'unicité de l'email si changé
        if (!formateur.getEmail().equals(formateurDetails.getEmail())) {
            if (formateurRepository.existsByEmail(formateurDetails.getEmail())) {
                throw new RuntimeException("Cet email est déjà utilisé");
            }
            formateur.setEmail(formateurDetails.getEmail());
        }

        formateur.setNom(formateurDetails.getNom());
        formateur.setPrenom(formateurDetails.getPrenom());
        formateur.setSpecialite(formateurDetails.getSpecialite());

        return formateurRepository.save(formateur);
    }

    public Formateur associerCours(Long formateurId, Long coursId) {
        Formateur formateur = formateurRepository.findById(formateurId)
                .orElseThrow(() -> new RuntimeException("Formateur non trouvé"));

        Cours cours = coursRepository.findById(coursId)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé"));

        cours.setFormateur(formateur);
        coursRepository.save(cours);

        return formateur;
    }

    @Transactional
    public Formateur getFormateurById(Long id) {
        return formateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formateur non trouvé"));
    }

    @Transactional
    public List<Formateur> getAllFormateurs() {
        return formateurRepository.findAll();
    }

    @Transactional
    public List<Formateur> getFormateursBySpecialite(String specialite) {
        return formateurRepository.findBySpecialite(specialite);
    }

    @Transactional
    public List<Cours> getCoursFormateur(Long formateurId) {
        if (!formateurRepository.existsById(formateurId)) {
            throw new RuntimeException("Formateur non trouvé");
        }
        return coursRepository.findByFormateurId(formateurId);
    }
}
