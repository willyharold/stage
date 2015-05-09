/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

/**
 *
 * @author pouemo
 */
@Entity
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String matricule;
    
    @Column(nullable = false, name = "Nom")
    private String nom;
    
    @Column(name = "Prenom")
    private String premon;
    
    @Column(nullable = false, name = "Parcours")
    @Enumerated
    private Parcours parcours;
    
    @Column(nullable = false, name = "Niveau")
    @Enumerated
    private Niveau niveau;
    
    @Column(name = "Specialite")
    private String specialite;
    
    @Version
    private int version;
    @OneToMany(mappedBy = "etudiant")
    private List<EtudiantStage> etudiantStages;
    
    @OneToMany(mappedBy = "etudiant")
    private List<Documents> documents;

    public Etudiant() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPremon() {
        return premon;
    }

    public void setPremon(String premon) {
        this.premon = premon;
    }

    public Parcours getParcours() {
        return parcours;
    }

    public void setParcours(Parcours parcours) {
        this.parcours = parcours;
    }

    
    public Niveau getNiveau() {
        return niveau;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    
    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public List<EtudiantStage> getEtudiantStages() {
        return etudiantStages;
    }

    public void setEtudiantStages(List<EtudiantStage> etudiantStages) {
        this.etudiantStages = etudiantStages;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "matricule=" + matricule + ", nom=" + nom + ", premon=" + premon + ", parcours=" + parcours + ", niveau=" + niveau + ", specialite=" + specialite + '}';
    }
}
