/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao.BD;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.projet.ig.gestionstage.Dao.IAgentScolariteDao;
import com.projet.ig.gestionstage.entity.AgentScolarite;

/**
 *
 * @author pouemo
 */
public class AgentScolariteDaoDB extends GenericDao<AgentScolarite, Long> implements IAgentScolariteDao{

    public AgentScolarite findByLogin(String login) throws DataAccessException {
        return (AgentScolarite) getManager().createQuery("select a from  AgentScolarite a where a.login = :statut").setParameter("statut", login).getSingleResult();
    }
    
    
}
