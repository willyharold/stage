/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.AnneeAcademique;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.EtudiantStage;
import com.projet.ig.gestionstage.entity.Stage;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IEtudiantStageService {
    
     public List<Stage> listStages(String matricule) throws DataAccessException;
    
    public List<Etudiant> listeSansNoteStage(String parcours, AnneeAcademique annee) throws DataAccessException;
    
    public List<Etudiant> listeCahierNonRemis(String parcours, AnneeAcademique annee) throws DataAccessException;
    
    public List<EtudiantStage> listeStagiaire(String parcours, AnneeAcademique annee) throws DataAccessException;
    
    public void noter(String matricule, float note) throws DataAccessException;
    
    public void enregistrer (EtudiantStage etuStage) throws DataAccessException;
    
    public List<EtudiantStage> listeStagiaire() throws DataAccessException;
    
}
