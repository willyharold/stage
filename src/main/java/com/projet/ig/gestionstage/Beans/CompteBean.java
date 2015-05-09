/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Beans;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.AgentScolarite;
import com.projet.ig.gestionstage.entity.Fonction;
import com.projet.ig.gestionstage.services.IAgentScolariteService;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author pouemo
 */
@ManagedBean
@RequestScoped
public class CompteBean implements SelectableDataModel<AgentScolarite> {

    @ManagedProperty(value = "#{IAgentScolariteService}")
    private IAgentScolariteService agentService;
    private AgentScolarite agent = new AgentScolarite();
    private List<AgentScolarite> agents;
    private AgentScolarite agentSelect = new AgentScolarite();
    String motdePass;
    
    private SelectItem[] fonctionOptions = new SelectItem[5];

    public String getMotdePass() {
        return motdePass;
    }

    public void setMotdePass(String motdePass) {
        this.motdePass = motdePass;
    }

    public AgentScolarite getAgentSelect() {
        return agentSelect;
    }

    public void setAgentSelect(AgentScolarite agentSelect) {
        this.agentSelect = agentSelect;
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

    public List<AgentScolarite> getAgents() throws DataAccessException {
        agents = new LinkedList<AgentScolarite>();
        agents = agentService.listerTous();
        return agents;
    }

    public void setAgents(List<AgentScolarite> agents) {
        this.agents = agents;
    }

    public CompteBean() {
        
    }

    public SelectItem[] getFonctionOptions() {
        fonctionOptions[0] = new SelectItem("", "Select");
        fonctionOptions[1] = new SelectItem(Fonction.Secretaire, "Secretaire");
        fonctionOptions[2] = new SelectItem(Fonction.Chef, "Chef");
        fonctionOptions[3] = new SelectItem(Fonction.Agent, "Agent");
        fonctionOptions[4] = new SelectItem(Fonction.Dees, "Dees");
        return fonctionOptions;
    }

    
    
    
    
    public void enregistrer() {
        try {
            agentService.enregistrer(agent);
        } catch (DataAccessException ex) {
            Logger.getLogger(CompteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Enregistrement", "OK "));
    }
    
    public void update(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Modification du mot de passe", "OK "));
    }
    
    public void delete(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Suppresion", "OK "));
    }

    public void modifierCompte() {
        AgentScolarite ag;
        try {
            ag = agentService.trouverAgentLogin(agent.getLogin());
            // System.out.println("  blabla  " + agent.getLogin() + " mot pass " + motdePass);
            if (ag != null) {
                if (ag.getMotdePasse().equals(agent.getMotdePasse())) {
                   // ag2 = agentService.agent(ag.getId());
                    ag.setMotdePasse(motdePass);
                    agentService.modifier(ag);
                }
            }

        } catch (DataAccessException ex) {
            Logger.getLogger(ConnexionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimer() {
        try {
            agentService.supprimer(agentSelect);
        } catch (DataAccessException ex) {
            Logger.getLogger(CompteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Fonction> listeFonction() {

        List<Fonction> list = new LinkedList<Fonction>();

        list.add(Fonction.Secretaire);
        list.add(Fonction.Agent);
        list.add(Fonction.Dees);
        list.add(Fonction.Chef);
        return list;
    }

          
    @Override
    public AgentScolarite getRowData(String rowKey) {
        try {
            List<AgentScolarite> agent1 = getAgents();

            for (AgentScolarite ag : agent1) {
                if (ag.getId().equals(rowKey)) {
                    return ag;
                }
            }

            return null;
        } catch (DataAccessException ex) {
            Logger.getLogger(StageBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Object getRowKey(AgentScolarite age) {
        return age.getId();
    }
}
