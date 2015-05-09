/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.AgentEntreprise;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IAgentEntrepriseService {
    
    public void enregistrer(AgentEntreprise agent) throws DataAccessException;
    
     public void modifier(AgentEntreprise agent) throws DataAccessException;
     
     public void supprimer(AgentEntreprise agent) throws DataAccessException;
     
      public List<AgentEntreprise> lister(AgentEntreprise agent) throws DataAccessException;
      
      public AgentEntreprise rechercher(long id) throws DataAccessException;
      
}
