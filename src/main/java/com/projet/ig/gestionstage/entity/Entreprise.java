
package com.projet.ig.gestionstage.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 *
 * @author pouemo
 */
@Entity
@Table(name = "Entreprise",
        uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Nom", "Ville"})
})
public class Entreprise implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, name ="Nom")
    private String nomEntreprise;
    
    @Column(name ="Sigle")
    private String sigle;
    
    @Column(nullable = false, name ="Type")
    private String type;
    
    @Column(name ="E_mail")
    private String e_mail;
    
    @Column(name ="Telephone")
    private String numeroTelephone;
    
    @Column(nullable = false, name ="Ville")
    private String nomVille;
     
    @Column( name ="Bp")
    private String boitePostale;
    
    @Column( name ="Fax")
    private String fax;
    
    @Column( name ="Localisation")
    private String localisation;
    
    @Column( name ="Genre")
    private String genre;
    
    @Column( name ="Reponsable")
    private String reponsable;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEnregistremet;
    
    @Version
    private int version;
    
    @OneToMany(mappedBy = "entreprise")
    private List<AgentEntreprise> agentDeSuivi;
    
    @OneToMany(mappedBy = "entreprise")
    private List<Stage> stage;
    
    @OneToMany(mappedBy = "entreprise")
    private List<Encardreur> encardreur;
    
    @ManyToMany()
    private List<DomaineActivite> domaines;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getDateEnregistremet() {
        return dateEnregistremet;
    }

    public void setDateEnregistremet(Date dateEnregistremet) {
        this.dateEnregistremet = dateEnregistremet;
    }

    
    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public List<DomaineActivite> getDomaines() {
        return domaines;
    }

    public void setDomaines(List<DomaineActivite> domaines) {
        this.domaines = domaines;
    }
    

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getNomVille() {
        return nomVille;
    }

    public List<AgentEntreprise> getAgentDeSuivi() {
        return agentDeSuivi;
    }

    public void setAgentDeSuivi(List<AgentEntreprise> agentDeSuivi) {
        this.agentDeSuivi = agentDeSuivi;
    }
    
    
    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public String getBoitePostale() {
        return boitePostale;
    }

    public void setBoitePostale(String boitePostale) {
        this.boitePostale = boitePostale;
    }

    public List<Stage> getStage() {
        return stage;
    }

    public void setStage(List<Stage> stage) {
        this.stage = stage;
    }

    public List<Encardreur> getEncardreur() {
        return encardreur;
    }

    public void setEncardreur(List<Encardreur> encardreur) {
        this.encardreur = encardreur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReponsable() {
        return reponsable;
    }

    public void setReponsable(String reponsable) {
        this.reponsable = reponsable;
    }
    
    
}
