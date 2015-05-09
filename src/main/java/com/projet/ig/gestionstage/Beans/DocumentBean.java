/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Beans;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.AnneeAcademique;
import com.projet.ig.gestionstage.entity.Documents;
import com.projet.ig.gestionstage.services.IAgentDocumentService;
import com.projet.ig.gestionstage.services.IAnneeAcademiqueService;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author pouemo
 */
@ManagedBean
@RequestScoped
public class DocumentBean implements SelectableDataModel<Documents> {

    @ManagedProperty(value = "#{IDocumentsService}")
    private IAgentDocumentService documentsService;
    private Documents document = new Documents();
    private List<Documents> documents;
    private Documents documensSelect = new Documents();
    @ManagedProperty(value = "#{IAnneeAcademiqueService}")
    private IAnneeAcademiqueService anneeService;
    private AnneeAcademique annee = new AnneeAcademique();
    private List<AnneeAcademique> anneeAcademiques;
    private List<String> annees;

    public DocumentBean() {
    }

    public IAgentDocumentService getDocumentsService() {
        return documentsService;
    }

    public void setDocumentsService(IAgentDocumentService documentsService) {
        this.documentsService = documentsService;
    }

    public Documents getDocument() {
        return document;
    }

    public void setDocument(Documents document) {
        this.document = document;
    }

    public List<Documents> getDocuments() {
        try {
            documents = documentsService.listerTous();
        } catch (DataAccessException ex) {
            Logger.getLogger(DocumentBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return documents;
    }

    public void setDocuments(List<Documents> documents) {
        this.documents = documents;
    }

    public Documents getDocumensSelect() {
        return documensSelect;
    }

    public void setDocumensSelect(Documents documensSelect) {
        this.documensSelect = documensSelect;
    }

    public IAnneeAcademiqueService getAnneeService() {
        return anneeService;
    }

    public void setAnneeService(IAnneeAcademiqueService anneeService) {
        this.anneeService = anneeService;
    }

    public AnneeAcademique getAnnee() {
        return annee;
    }

    public void setAnnee(AnneeAcademique annee) {
        this.annee = annee;
    }

    public List<AnneeAcademique> getAnneeAcademiques() {
        return anneeAcademiques;
    }

    public void setAnneeAcademiques(List<AnneeAcademique> anneeAcademiques) {
        this.anneeAcademiques = anneeAcademiques;
    }

    public List<String> getAnnees() {
        annees = new LinkedList<String>();
        try {
            annees = anneeService.listAnneeAcademic();
        } catch (DataAccessException ex) {
            Logger.getLogger(StageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return annees;
    }

    public void setAnnees(List<String> annees) {
        this.annees = annees;
    }

    public void enregistrer() {
        try {
//            document.setAnnee(anneeService.rechercherparAnnee(annee.getAnneeAcademique()));
            documentsService.enregistrer(document);
        } catch (DataAccessException ex) {
            Logger.getLogger(DocumentBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifier() {
        try {
            documentsService.modifier(document);
        } catch (DataAccessException ex) {
            Logger.getLogger(DocumentBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimer() {
        try {
            documentsService.supprimer(document);
        } catch (DataAccessException ex) {
            Logger.getLogger(DocumentBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ajouterAnnee(String annee){
    
        AnneeAcademique an = new AnneeAcademique();
        an.setAnneeAcademique(annee);
        try {
            anneeService.enregistrer(an);
        } catch (DataAccessException ex) {
            Logger.getLogger(DocumentBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    @Override
    public Documents getRowData(String rowKey) {

        List<Documents> doc = getDocuments();

        for (Documents entre : doc) {
            if (entre.getId().equals(rowKey)) {
                return entre;
            }
        }

        return null;

    }

    @Override
    public Object getRowKey(Documents doc) {
        return doc.getId();
    }
}
