/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 *
 * @author pouemo
 */
@Entity
public class AgentScolarite extends Personel{
   
    @Column(nullable = false)
    private String login;
    
    @Column(nullable = false)
    @Enumerated
    private Fonction fonction;
    
    @Column(nullable = false)
    private String motdePasse;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    public String getMotdePasse() {
        return motdePasse;
    }

    public void setMotdePasse(String motdePasse) {
        this.motdePasse = motdePasse;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 73 * hash + (this.fonction != null ? this.fonction.hashCode() : 0);
        hash = 73 * hash + (this.motdePasse != null ? this.motdePasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AgentScolarite other = (AgentScolarite) obj;
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        if (this.fonction != other.fonction) {
            return false;
        }
        if ((this.motdePasse == null) ? (other.motdePasse != null) : !this.motdePasse.equals(other.motdePasse)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AgentScolarite{" + "fonction=" + fonction + '}';
    }
    
    
}
