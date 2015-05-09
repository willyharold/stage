package com.projet.ig.gestionstage.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Version;

/**
 *
 * @author pouemo
 */
@Entity
public class Stage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "categorie", nullable = false)
    @Basic
    @Enumerated
    private Type categorie;

    @Column(name = "Theme", nullable = true)
    private String theme;

    @Column(name = "Prospecteur", nullable = false)
    @Enumerated
    private Prospecteur prospecteur;

    @Column(name = "DateDebut", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date debut;

    @Column(name = "DateFin", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fin;

    @Column(nullable = false)
    @Enumerated
    private Parcours parcours;

    @Column(nullable = false, name = "affecter")
    Reponse status = Reponse.NON;

    @Column(nullable = false, name = "Annee")
    String anneeAcademique;

    @OneToMany(mappedBy = "stage")
    private List<EtudiantStage> etudiantStage;
    
    @ManyToOne()
    private AnneeAcademique annee;

    @ManyToOne()
    @JoinColumn(name = "Id_Entreprise", nullable = false, referencedColumnName = "id")
    private Entreprise entreprise;

    @Version
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Type getCathegorie() {
        return categorie;
    }

    public void setCathegorie(Type cathegorie) {
        this.categorie = cathegorie;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Prospecteur getProspecteur() {
        return prospecteur;
    }

    public void setProspecteur(Prospecteur prospecteur) {
        this.prospecteur = prospecteur;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Type getCategorie() {
        return categorie;
    }

    public void setCategorie(Type categorie) {
        this.categorie = categorie;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public List<EtudiantStage> getEtudiantStage() {
        return etudiantStage;
    }

    public void setEtudiantStage(List<EtudiantStage> etudiantStage) {
        this.etudiantStage = etudiantStage;
    }

    public Parcours getParcours() {
        return parcours;
    }

    public void setParcours(Parcours parcours) {
        this.parcours = parcours;
    }

    public String getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(String anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }

    public Reponse getStatus() {
        return status;
    }

    public void setStatus(Reponse status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Stage{" + "  Annee Academique = " + anneeAcademique + " cathegorie=" + categorie + ", theme=" + theme + ", prospecteur=" + prospecteur + ", debut=" + debut + ", fin=" + fin + ", parcours=" + parcours + '}';
    }

}
