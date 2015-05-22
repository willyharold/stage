/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services.Imp;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.Dao.IAgentSuiviDeDao;
import com.projet.ig.gestionstage.entity.AgentDeSuivi;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.services.IAgentDeSuiviService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pouemo
 */
@Transactional
public class AgentDeSuiviServiceImp implements IAgentDeSuiviService {

    private IAgentSuiviDeDao agentdSuiviDao;

    public void Enregistrer(AgentDeSuivi e) throws DataAccessException {
        agentdSuiviDao.create(e);
    }
    public void Supprimer(AgentDeSuivi e) throws DataAccessException {
        
        agentdSuiviDao.delete(e);
       
    }
/*
    public void Supprimer(AgentDeSuivi e) throws DataAccessException {
        System.out.println(e);
        agentdSuiviDao.delete(e);
       
    }

     public void Supprimer(AgentDeSuivi e) throws DataAccessException {
        ArrayList <AgentDeSuivi> tmp  = (ArrayList <AgentDeSuivi>) this.findByAll();
        
       
    }
   */  
    public IAgentSuiviDeDao getAgentdSuiviDao() {
        return agentdSuiviDao;
    }

    public void setAgentdSuiviDao(IAgentSuiviDeDao agentdSuiviDao) {
        this.agentdSuiviDao = agentdSuiviDao;
    }

    public AgentDeSuivi findById(long id) throws DataAccessException {
        return agentdSuiviDao.findById(id);
    }

    public List<AgentDeSuivi> findByAll() throws DataAccessException {
        return agentdSuiviDao.findAll();
    }

    public void Modifier(AgentDeSuivi e) throws DataAccessException {
        agentdSuiviDao.update(e);
    }
    
    public List<Entreprise> entrepriseVisiter(AgentDeSuivi agent)throws DataAccessException {
        
        AgentDeSuivi agt = agentdSuiviDao.findById(agent.getId());
        return null;
    }

    public void del(long e) throws DataAccessException {
        AgentDeSuivi tmp = agentdSuiviDao.findById(e);
        agentdSuiviDao.delete(tmp);
    }

    
}
