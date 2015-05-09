/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author pouemo
 */
@Entity
@Table(name = "AgentEntreprise",
        uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Entreprise", "Annee_Academique"})
})
public class AgentEntreprise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeVisite;
    
    @ManyToOne
    @JoinColumn(name = "Entreprise", nullable = false, referencedColumnName = "id")
    private Entreprise entreprise;
    
    @ManyToOne
    @JoinColumn(name = "AgentDeSuivi", nullable = false, referencedColumnName = "id")
    private AgentDeSuivi agent;
    
    @ManyToOne
    @JoinColumn(name = "Annee_Academique", nullable = false, referencedColumnName = "id")
    private AnneeAcademique annee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDeVisite() {
        return dateDeVisite;
    }

    public void setDateDeVisite(Date dateDeVisite) {
        this.dateDeVisite = dateDeVisite;
    }

    public AgentDeSuivi getAgent() {
        return agent;
    }

    public void setAgent(AgentDeSuivi agent) {
        this.agent = agent;
    }

    public AnneeAcademique getAnnee() {
        return annee;
    }

    public void setAnnee(AnneeAcademique annee) {
        this.annee = annee;
    }

   

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgentEntreprise)) {
            return false;
        }
        AgentEntreprise other = (AgentEntreprise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    
}
