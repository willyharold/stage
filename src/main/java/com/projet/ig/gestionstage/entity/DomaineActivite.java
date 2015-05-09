
package com.projet.ig.gestionstage.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author pouemo
 */
@Entity
public class DomaineActivite implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true, nullable = false, name ="nom")
    private String nomDomaine;
    
    @ManyToMany(mappedBy = "domaines")
    private List<Entreprise> entreprises;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomDomaine() {
        return nomDomaine;
    }

    public void setNomDomaine(String nomDomaine) {
        this.nomDomaine = nomDomaine;
    }

    public List<Entreprise> getEntreprises() {
        return entreprises;
    }

    public void setEntreprises(List<Entreprise> entreprise) {
        this.entreprises =  entreprise;
    }

    @Override
    public String toString() {
        return "DomaineActivite{" + "id=" + id + ", nomDomaine=" + nomDomaine + '}';
    }

    
    
}
