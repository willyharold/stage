/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.Niveau;
import com.projet.ig.gestionstage.entity.Parcours;
import com.projet.ig.gestionstage.entity.Stage;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IEtudiantService {

    public Etudiant findByMatricule(String matricule) throws DataAccessException;

    public Etudiant findById(Long id) throws DataAccessException;

    public void Noter(double note, Etudiant et) throws DataAccessException;

    public void Enregistrer(Etudiant etudiant) throws DataAccessException;

    public void Modifier(Etudiant etudiant) throws DataAccessException;

    public List<Etudiant> listeSansNote() throws DataAccessException;

    public List<Stage> listeStage(Etudiant etudiant) throws DataAccessException;
    
    public List<Etudiant> findByParcours(Parcours parcours) throws DataAccessException;

    public List<Etudiant> findByParcoursNiveau(Parcours Parcours, Niveau niveau) throws DataAccessException;
    
    public List<Etudiant> listeSansStagesParcours(Parcours Parcours) throws DataAccessException;
    
    public List<Etudiant> listeSansStagesParcoursNiveau(Parcours Parcours, int niveau) throws DataAccessException;
    
    public Void historiqueStage (Etudiant etudiant)throws DataAccessException;
    
    public List<Etudiant> rechercherTous() throws DataAccessException;
    
    public List<String> listeDesMatricule() throws DataAccessException;
}
