/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author pouemo
 */
@Entity
public class AgentDeSuivi extends Personel {

    @Column(name = "Fonction", nullable = false)
    private String fonction;
    
    @Column(name = "enServiceAu", nullable = false)
    private String enService;
    
    @OneToMany(mappedBy = "agent")
    private List<AgentEntreprise> agentEntreprise;
    
    

    public AgentDeSuivi() {
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getEnService() {
        return enService;
    }

    public void setEnService(String enService) {
        this.enService = enService;
    }

    public List<AgentEntreprise> getAgentEntreprise() {
        return agentEntreprise;
    }

    public void setAgentEntreprise(List<AgentEntreprise> agentEntreprise) {
        this.agentEntreprise = agentEntreprise;
    }

    
    @Override
    public String toString() {
        return "AgentDeSuivi{" + " fonction=" + fonction + ", enServiceAu=" + enService + '}';
    }
}
