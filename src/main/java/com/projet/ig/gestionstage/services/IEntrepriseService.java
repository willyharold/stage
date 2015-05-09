/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.DomaineActivite;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.Stage;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IEntrepriseService {
    
    public List<String> findByVille(String ville) throws DataAccessException;
    
    public List<Entreprise> findByType(String type) throws DataAccessException;
    
    public List<Entreprise> findByReponse(String reponse) throws DataAccessException;
    
    public void enregistrer(Entreprise e) throws DataAccessException;
    
    public void modifier(Entreprise e) throws DataAccessException;
    
    public Entreprise findById(Long id) throws DataAccessException;
    
    public List<Stage> listeStage(Entreprise e) throws DataAccessException;
    
    public List<Etudiant> listeEtudiant(Entreprise e) throws DataAccessException;
    
    public Entreprise addDomainToEnterprise(Long enterpriseId, Long domaineId) throws DataAccessException;
    
    public List<DomaineActivite> listeDomaine(Entreprise entreprise) throws DataAccessException;
    
    public void historique(Entreprise entreprise) throws DataAccessException;
    
    public List<Entreprise> afficherTous()throws DataAccessException;
    
    public List<String> listeNom() throws DataAccessException;
    
    public List<String> listeEntrepriseVille() throws DataAccessException;
    
    public List<String> listeEntrepriseVille(String nom) throws DataAccessException;
    
     public Entreprise findByNomVille(String nom, String ville) throws DataAccessException;
    
}
