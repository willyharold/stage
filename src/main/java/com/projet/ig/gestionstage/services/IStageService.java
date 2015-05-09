/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.entity.Niveau;
import com.projet.ig.gestionstage.entity.Parcours;
import com.projet.ig.gestionstage.entity.Prospecteur;
import com.projet.ig.gestionstage.entity.Reponse;
import com.projet.ig.gestionstage.entity.Stage;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IStageService {
    
    public List<Stage> findByprospecteur(Prospecteur prosprecteur) throws DataAccessException;

    public List<Stage> findByParcours(String parcours) throws DataAccessException;

    public List<Stage> findByParcoursNiveau(String Parcours, Niveau niveau) throws DataAccessException;

    public List<Stage> findByEntreprise(Entreprise entreprise) throws DataAccessException;
    
    public List<Stage> findByAll() throws DataAccessException;
    
    public Stage findById(long id) throws DataAccessException ;
    
    public void enregistrer(Stage stage) throws DataAccessException;
    
    public void modifier(Stage stage) throws DataAccessException;
    
     public void modifierStatut(Stage stage, Reponse reponse) throws DataAccessException;
     
    public void supprimer(Stage stage) throws DataAccessException;
    
    public List<Stage> findByprospecteurYear(Prospecteur prosprecteur, String annee) throws DataAccessException;
    
     public List<Long> stageEntrepriseAnnee(Entreprise entreprise, Niveau niveau, String annee, Parcours parcours) throws DataAccessException;
    
    
}
