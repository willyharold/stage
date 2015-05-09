/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services.Imp;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.Dao.IAgentScolariteDao;
import com.projet.ig.gestionstage.entity.AgentScolarite;
import com.projet.ig.gestionstage.services.IAgentScolariteService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pouemo
 */
@Transactional
public class AgentScolariteServiceImpl implements IAgentScolariteService{

    private IAgentScolariteDao agentScolariteDao;

    public IAgentScolariteDao getAgentScolariteDao() {
        return agentScolariteDao;
    }

    public void setAgentScolariteDao(IAgentScolariteDao agentScolariteDao) {
        this.agentScolariteDao = agentScolariteDao;
    }

   

    public void enregistrer(AgentScolarite agent) throws DataAccessException {
       agentScolariteDao.create(agent);
    }

    public void modifier(AgentScolarite ag) throws DataAccessException {
        AgentScolarite agent = agentScolariteDao.findById(ag.getId());
                    agent.setMotdePasse(ag.getMotdePasse()); 
                    agent.setNom(ag.getNom());
                    agent.setPremon(ag.getPremon());
                    agent.setLogin(ag.getLogin());
                    agent.setNumeroTelephone(ag.getNumeroTelephone());
                    agent.setFonction(ag.getFonction());
                    agent.setEmail(ag.getEmail());
        agentScolariteDao.update(agent);
    }

    public List<AgentScolarite> listerTous() throws DataAccessException {
       return agentScolariteDao.findAll();
    }

    public void supprimer(AgentScolarite agent) throws DataAccessException {
        AgentScolarite ag = agentScolariteDao.findById(agent.getId());
       agentScolariteDao.delete(ag);
    }

    public AgentScolarite agent(long l) throws DataAccessException {
        return agentScolariteDao.findById(l); //To change body of generated methods, choose Tools | Templates.
    }

    public AgentScolarite trouverAgentLogin(String login) throws DataAccessException {
        return agentScolariteDao.findByLogin(login);
    }

    
    
}
