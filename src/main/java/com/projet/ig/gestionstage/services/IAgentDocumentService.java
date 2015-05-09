/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.Documents;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IAgentDocumentService {
    
    public void enregistrer(Documents document) throws DataAccessException;
    
    public void supprimer(Documents document) throws DataAccessException;
    
    public void modifier(Documents document) throws DataAccessException;
    
    public List<Documents> listerTous() throws DataAccessException;
    
    public Documents rechercher(long id) throws DataAccessException;
}
