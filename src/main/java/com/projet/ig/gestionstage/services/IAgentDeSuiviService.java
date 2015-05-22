/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.AgentDeSuivi;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IAgentDeSuiviService {

    public void Enregistrer(AgentDeSuivi e) throws DataAccessException;

    public void Supprimer(AgentDeSuivi e) throws DataAccessException;

    public AgentDeSuivi findById(long id) throws DataAccessException;

    public List<AgentDeSuivi> findByAll() throws DataAccessException;

    public void Modifier(AgentDeSuivi e) throws DataAccessException;
    
    public void del(long e) throws DataAccessException;
}
