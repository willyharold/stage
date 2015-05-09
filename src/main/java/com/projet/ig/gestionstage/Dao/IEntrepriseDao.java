/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.entity.Stage;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IEntrepriseDao extends IDao<Entreprise, Long>{
    
    public List<String> findByVille(String ville) throws DataAccessException;
    
    public List<Entreprise> findByType(String type) throws DataAccessException;
    
    public List<Entreprise> findByReponse(String reponse) throws DataAccessException;
    
    public List<Stage> listeStage(Entreprise e) throws DataAccessException; 
    
    public List<String> listeNom() throws DataAccessException;
    
    public List<String> listeEntrepriseVille() throws DataAccessException;
    
    public List<String> listeEntrepriseVille(String nom) throws DataAccessException;
    
     public Entreprise findByNomVille(String nom, String ville) throws DataAccessException;
    
}
