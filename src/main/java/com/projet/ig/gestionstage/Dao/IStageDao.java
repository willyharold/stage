/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.entity.Etudiant;
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
public interface IStageDao extends IDao<Stage, Long> {

    public List<Stage> findByprospecteur(Prospecteur prosprecteur) throws DataAccessException;

    public List<Stage> findByParcours(String parcours) throws DataAccessException;

    public List<Stage> findByParcoursNiveau(String Parcours, Niveau niveau) throws DataAccessException;

    public List<Stage> findByEntreprise(Entreprise entreprise) throws DataAccessException;
    
    public Etudiant findEtudiantByStage(Stage s) throws DataAccessException;
    
    public List<Stage> findByprospecteur(Prospecteur prosprecteur, String annee) throws DataAccessException;
    
    public List<Long> findByEntrepriseNiveauYear(Entreprise entreprise, Niveau niveau, String annee, Parcours parcours) throws DataAccessException;
    
}
