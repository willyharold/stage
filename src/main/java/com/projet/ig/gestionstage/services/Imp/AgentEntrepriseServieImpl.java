/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services.Imp;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.Dao.IAgentEntrepriseDao;
import com.projet.ig.gestionstage.entity.AgentEntreprise;
import com.projet.ig.gestionstage.services.IAgentEntrepriseService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AgentEntrepriseServieImpl implements IAgentEntrepriseService{
    
    private IAgentEntrepriseDao agentEntrepriseDao;

    public IAgentEntrepriseDao getAgentEntrepriseDao() {
        return agentEntrepriseDao;
    }

    public void setAgentEntrepriseDao(IAgentEntrepriseDao agentEntrepriseDao) {
        this.agentEntrepriseDao = agentEntrepriseDao;
    }

    public void enregistrer(AgentEntreprise agent) throws DataAccessException {
        agentEntrepriseDao.create(agent);
    }

    public void modifier(AgentEntreprise agent) throws DataAccessException {
        agentEntrepriseDao.update(agent);
    }

    public void supprimer(AgentEntreprise agent) throws DataAccessException {
        agentEntrepriseDao.delete(agent);
    }

    public List<AgentEntreprise> lister(AgentEntreprise agent) throws DataAccessException {
       return agentEntrepriseDao.findAll();
    }

    public AgentEntreprise rechercher(long id) throws DataAccessException {
       return agentEntrepriseDao.findById(id);
    }
    
}
