/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.Niveau;
import com.projet.ig.gestionstage.entity.Parcours;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IEtudiantDao extends IDao<Etudiant, Long>{
    

    public List<Etudiant> findByParcours(Parcours parcours) throws DataAccessException;

    public List<Etudiant> findByParcoursNiveau(Parcours Parcous, Niveau niveau) throws DataAccessException;

    public Etudiant findByMatricule(String matricule) throws DataAccessException;
    
    public List<Etudiant> findByOption(String option) throws DataAccessException;
    
    public List<Etudiant> listeSansNote() throws DataAccessException;
    
    public List<String> listeMatricule() throws DataAccessException;
    
}
