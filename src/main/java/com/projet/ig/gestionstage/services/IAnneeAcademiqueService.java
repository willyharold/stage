/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.AnneeAcademique;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IAnneeAcademiqueService {
    
    public void enregistrer(AnneeAcademique anneeAc) throws DataAccessException;
    
    public void modifier(AnneeAcademique anneeAc) throws DataAccessException;
    
    public AnneeAcademique rechercher(long id) throws DataAccessException;
    
    public AnneeAcademique rechercherparAnnee(String annee) throws DataAccessException;
    
     public List<String> listAnneeAcademic() throws DataAccessException;
    
    public List<AnneeAcademique> rechercherTous() throws DataAccessException;
}
