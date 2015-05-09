/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author pouemo
 */
@Entity
public class Encardreur extends Personel{
    
    @Column(name = "Fonction", nullable = false)
    private String fonction;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="Id_Entreprise", nullable = false ,referencedColumnName = "id")
    private Entreprise entreprise;

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
    
    
}
