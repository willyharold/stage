/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Beans;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.AgentScolarite;
import com.projet.ig.gestionstage.services.IAgentScolariteService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pouemo
 */
@ManagedBean
@SessionScoped
public class ConnexionBean {

    @ManagedProperty(value = "#{IAgentScolariteService}")
    private IAgentScolariteService agentService;
    private AgentScolarite agent = new AgentScolarite();
    
    
    private String message = "";

    public ConnexionBean() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public IAgentScolariteService getAgentService() {
        return agentService;
    }

    public void setAgentService(IAgentScolariteService agentService) {
        this.agentService = agentService;
    }

    public AgentScolarite getAgent() {
        return agent;
    }

    public void setAgent(AgentScolarite agent) {
        this.agent = agent;
    }

    public String connexion() {
        AgentScolarite ag;
        try {
            ag = agentService.trouverAgentLogin(agent.getLogin());
            if (ag != null) {
                if (ag.getMotdePasse().equals(agent.getMotdePasse())) {
                    message = "";
                    return "connexion";
                }
            }   

        } catch (DataAccessException ex) {
            Logger.getLogger(ConnexionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        message = "Login ou Mot de passe incorrecte";
        return "deconnexion";
    }
}
