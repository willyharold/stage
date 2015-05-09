/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.AgentScolarite;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IAgentScolariteService {

    public void enregistrer(AgentScolarite agent) throws DataAccessException;

    public void modifier(AgentScolarite agent) throws DataAccessException;

    public void supprimer(AgentScolarite agent) throws DataAccessException;

    public AgentScolarite agent(long l) throws DataAccessException;

    public AgentScolarite trouverAgentLogin(String login) throws DataAccessException;

    public List<AgentScolarite> listerTous() throws DataAccessException;
}
