/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.projet.ig.gestionstage.entity.AgentScolarite;

/**
 *
 * @author pouemo
 */
public interface IAgentScolariteDao extends IDao<AgentScolarite, Long>{
    
    AgentScolarite findByLogin(String login) throws DataAccessException;
}
