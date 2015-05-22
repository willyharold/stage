/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Beans;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.AgentDeSuivi;
import com.projet.ig.gestionstage.entity.AgentEntreprise;
import com.projet.ig.gestionstage.services.IAgentDeSuiviService;
import com.projet.ig.gestionstage.services.IAgentEntrepriseService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author pouemo
 */
@ManagedBean
@RequestScoped
public class AgentDeSuiviBean implements SelectableDataModel<AgentDeSuivi>{

    @ManagedProperty(value = "#{IAgentDeSuiviService}") 
    private IAgentDeSuiviService agentService;
    private AgentDeSuivi agent = new AgentDeSuivi();
    private AgentDeSuivi agentchoisi = new AgentDeSuivi();
    private List<AgentDeSuivi> agents; 
  
    @ManagedProperty(value = "#{IAgentEntrepriseService}")
    private IAgentEntrepriseService agentEntrepriseService;
    private AgentEntreprise agentEntreprise = new AgentEntreprise();
    private List<AgentEntreprise> agentEntreprises;
    private AgentEntreprise agentEntrepriseSelect = new AgentEntreprise();
    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AgentDeSuiviBean() {
    }

    public IAgentDeSuiviService getAgentService() {
        return agentService;
    }

    public void setAgentService(IAgentDeSuiviService agentService) {
        this.agentService = agentService;
    }

    public AgentDeSuivi getAgent() {
        return agent;
    }

    public void setAgent(AgentDeSuivi agent) {
        this.agent = agent;
    }

    public List<AgentDeSuivi> getAgents() {
        try {
            agents = agentService.findByAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(AgentDeSuiviBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agents;
    }

    public void setAgents(List<AgentDeSuivi> agents) {
        this.agents = agents;
    }

    public IAgentEntrepriseService getAgentEntrepriseService() {
        return agentEntrepriseService;
    }

    public void setAgentEntrepriseService(IAgentEntrepriseService agentEntrepriseService) {
        this.agentEntrepriseService = agentEntrepriseService;
    }

    public AgentEntreprise getAgentEntreprise() {
        return agentEntreprise;
    }

    public void setAgentEntreprise(AgentEntreprise agentEntreprise) {
        this.agentEntreprise = agentEntreprise;
    }

    public List<AgentEntreprise> getAgentEntreprises() {
        return agentEntreprises;
    }

    public void setAgentEntreprises(List<AgentEntreprise> agentEntreprises) {
        this.agentEntreprises = agentEntreprises;
    }

    public AgentEntreprise getAgentEntrepriseSelect() {
        return agentEntrepriseSelect;
    }

    public void setAgentEntrepriseSelect(AgentEntreprise agentEntrepriseSelect) {
        this.agentEntrepriseSelect = agentEntrepriseSelect;
    }
    public void enregistrer() throws DataAccessException{
        agent.setNom(nom);
        agent.setPremon(prenom);
        agent.setNumeroTelephone(telephone);
        agent.setEmail(email);
        // System.out.println(agent);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "l'enregistrement a été éffectué avec success!!"));
        agentService.Enregistrer(agent);
        
    }
    
     public void modifier() throws DataAccessException{
            //System.out.println(agent);
            agentService.Modifier(agent);
    }
     
     public void supprimer() throws DataAccessException{
         System.out.println(agentService.findById(agent.getId()));
        try {
            agentService.del(agent.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "la suppression a été éffectué avec success!!"));
        } catch (DataAccessException ex) {
        
        }
         System.out.println(agent);
    }
      public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
      @Override
    public AgentDeSuivi getRowData(String rowKey) {

        List<AgentDeSuivi> ag = getAgents();

        for (AgentDeSuivi entre : ag) {
            if (entre.getId().equals(rowKey)) {
                return entre;
            }
        }

        return null;

    }

    @Override
    public Object getRowKey(AgentDeSuivi ag) {
        return ag.getId();
    }

    public AgentDeSuivi getAgentchoisi() {
        return agentchoisi;
    }

    public void setAgentchoisi(AgentDeSuivi agentchoisi) {
        this.agentchoisi = agentchoisi;
    }
    
}
