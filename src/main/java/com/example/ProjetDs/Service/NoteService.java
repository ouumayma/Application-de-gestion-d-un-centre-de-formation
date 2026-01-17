package com.example.ProjetDs.Service;


import com.example.ProjetDs.Entity.Cours;
import com.example.ProjetDs.Entity.Etudiant;
import com.example.ProjetDs.Entity.Note;
import com.example.ProjetDs.Repository.CoursRepository;
import com.example.ProjetDs.Repository.EtudiantRepository;
import com.example.ProjetDs.Repository.InscriptionRepository;
import com.example.ProjetDs.Repository.NoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private NoteRepository noteRepository;
    private EtudiantRepository etudiantRepository;
    private CoursRepository coursRepository;
    private InscriptionRepository inscriptionRepository;

    public Note attribuerNote(Long etudiantId, Long coursId, Double valeur, String commentaire) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));

        Cours cours = coursRepository.findById(coursId)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé"));

        // Vérifier que l'étudiant est inscrit au cours
        if (!inscriptionRepository.existsByEtudiantIdAndCoursId(etudiantId, coursId)) {
            throw new RuntimeException("L'étudiant n'est pas inscrit à ce cours");
        }

        // Vérifier la validité de la note
        if (valeur < 0 || valeur > 20) {
            throw new RuntimeException("La note doit être entre 0 et 20");
        }

        // Vérifier si une note existe déjà
        Note note = noteRepository.findByEtudiantIdAndCoursId(etudiantId, coursId)
                .orElse(new Note());

        note.setEtudiant(etudiant);
        note.setCours(cours);
        note.setValeur(valeur);


        return noteRepository.save(note);
    }

    public Note modifierNote(Long noteId, Double valeur) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note non trouvée"));

        if (valeur < 0 || valeur > 20) {
            throw new RuntimeException("La note doit être entre 0 et 20");
        }

        note.setValeur(valeur);


        return noteRepository.save(note);
    }

    public void supprimerNote(Long noteId) {
        if (!noteRepository.existsById(noteId)) {
            throw new RuntimeException("Note non trouvée");
        }
        noteRepository.deleteById(noteId);
    }

    @Transactional
    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note non trouvée"));
    }

    @Transactional
    public List<Note> getNotesEtudiant(Long etudiantId) {
        if (!etudiantRepository.existsById(etudiantId)) {
            throw new RuntimeException("Étudiant non trouvé");
        }
        return noteRepository.findByEtudiantId(etudiantId);
    }

    @Transactional
    public List<Note> getNotesCours(Long coursId) {
        if (!coursRepository.existsById(coursId)) {
            throw new RuntimeException("Cours non trouvé");
        }
        return noteRepository.findByCoursId(coursId);
    }

    @Transactional
    public Double getMoyenneEtudiant(Long etudiantId) {
        if (!etudiantRepository.existsById(etudiantId)) {
            throw new RuntimeException("Étudiant non trouvé");
        }
        Double moyenne = noteRepository.findMoyenneByEtudiantId(etudiantId);
        return moyenne != null ? moyenne : 0.0;
    }

    @Transactional
    public Double getMoyenneCours(Long coursId) {
        if (!coursRepository.existsById(coursId)) {
            throw new RuntimeException("Cours non trouvé");
        }
        Double moyenne = noteRepository.findMoyenneByCoursId(coursId);
        return moyenne != null ? moyenne : 0.0;
    }
}
