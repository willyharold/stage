/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Beans;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;
import com.projet.ig.gestionstage.entity.EtudiantStage;
import com.projet.ig.gestionstage.entity.Niveau;
import com.projet.ig.gestionstage.entity.Parcours;
import com.projet.ig.gestionstage.services.IEtudiantStageService;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author pouemo
 */
@ManagedBean
@RequestScoped
public class LettreBean {
    @ManagedProperty(value = "#{IEtudiantStageService}")
    private IEtudiantStageService etudiantStageService;
    private EtudiantStage etudiantStage = new EtudiantStage();
    private List<EtudiantStage> etudiantStages;
    
    // creation des getters et setters
    public IEtudiantStageService getEtudiantStageService() {
        return etudiantStageService;
    }

    public void setEtudiantStageService(IEtudiantStageService etudiantStageService) {
        this.etudiantStageService = etudiantStageService;
    }

    public EtudiantStage getEtudiantStage() {
        return etudiantStage;
    }

    public void setEtudiantStage(EtudiantStage etudiantStage) {
        this.etudiantStage = etudiantStage;
    }

    public List<EtudiantStage> getEtudiantStages() {
        return etudiantStages;
    }

    public void setEtudiantStages(List<EtudiantStage> etudiantStages) {
        this.etudiantStages = etudiantStages;
    }
    
    

    /**
     * Creates a new instance of LettreBean
     */
    public LettreBean() {
        
    }

  
}
