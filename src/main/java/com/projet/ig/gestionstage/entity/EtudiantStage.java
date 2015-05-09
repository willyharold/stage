/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author pouemo
 */
@Entity
@Table(name = "EtudiantStage",
        uniqueConstraints = {
    @UniqueConstraint(columnNames = {"matricule", "Annee"})
})
public class EtudiantStage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String matricule;
    
    @Column
    private float note;
    
    @Column(name = "Cahier_remis")
    @Basic
    @Enumerated
    private Reponse cahierremis = Reponse.NON;
    
    @Column(name = "Annee")
    private String anneeAcademique;
    
    @ManyToOne
    private Stage stage;
    
    @ManyToOne
    private Etudiant etudiant;   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Reponse getCahierremis() {
        return cahierremis;
    }

    public void setCahierremis(Reponse cahierremis) {
        this.cahierremis = cahierremis;
    }

    

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(String anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
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
        if (!(object instanceof EtudiantStage)) {
            return false;
        }
        EtudiantStage other = (EtudiantStage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EtudiantStage{" + "matricule=" + matricule + ", note=" + note + ", cahierremis=" + cahierremis + ", annee=" + anneeAcademique + ", stage=" + stage + ", etudiant=" + etudiant + '}';
    }

    
}
