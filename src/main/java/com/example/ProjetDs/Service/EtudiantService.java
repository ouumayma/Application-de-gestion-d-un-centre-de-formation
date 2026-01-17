package com.example.ProjetDs.Service;


import com.example.ProjetDs.Entity.Etudiant;
import com.example.ProjetDs.Entity.Groupe;
import com.example.ProjetDs.Entity.Specialite;
import com.example.ProjetDs.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtudiantService {


    @Autowired
    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository){
        this.etudiantRepository=etudiantRepository;
    }
//

    // CREATE
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    // READ ALL
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    // READ BY ID
    public Etudiant findById(Long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant non trouvé avec l'ID: " + id));
    }

    // READ BY MATRICULE
    public boolean findByMatricule(String matricule) {
        return etudiantRepository.findByMatricule(matricule);
    }

    // READ BY EMAIL
    public Etudiant findByEmail(String email) {
        return etudiantRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Etudiant non trouvé avec l'email: " + email));
    }

    // READ BY NOM
    public List<Etudiant> findByNom(String nom) {
        return etudiantRepository.findByNom(nom);
    }

    // READ BY GROUPE
    public List<Etudiant> findByGroupe(Groupe groupe) {
        return etudiantRepository.findByGroupe(groupe);
    }

    // READ BY SPECIALITE
    public List<Etudiant> findBySpecialite(Specialite specialite) {
        return etudiantRepository.findBySpecialite(specialite);
    }

    // SEARCH
//    public List<Etudiant> search(String keyword) {
//        return etudiantRepository.searchEtudiants(keyword);
//    }



    // DELETE
    public void delete(Long id) {
        if (!etudiantRepository.existsById(id)) {
            throw new RuntimeException("Etudiant non trouvé avec l'ID: " + id);
        }
        etudiantRepository.deleteById(id);
    }

    // EXISTS
    public boolean existsByMatricule(String matricule) {
        return etudiantRepository.findByMatricule(matricule);
    }
}
