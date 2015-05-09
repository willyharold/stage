/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author pouemo
 */
@ManagedBean
@RequestScoped
public class AccueilBean {

    /**
     * Creates a new instance of AccueilBean
     */
    public AccueilBean() {
    }
    
    public String accueil(){
        return "accueil";
    }
    
    public String etudiant(){
        return "etudiants";
    }
    
    public String stage(){
        return "stages";
    }
    
    public String document(){
        return "document";
    }
    
    public String statistique(){
        return "statistique";
    }
    
    public String entreprise(){
        return "entreprise";
    }
    
    public String deconnexion(){
        return "deconnexion";
    }
    
    public String compte(){
        return "compte";
    }
    
    public String agent(){
        return "agent";
    }
    
}
