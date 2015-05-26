/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Beans;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.EtudiantStage;
import com.projet.ig.gestionstage.entity.Niveau;
import com.projet.ig.gestionstage.entity.Parcours;
import com.projet.ig.gestionstage.entity.Stage;
import com.projet.ig.gestionstage.services.IEtudiantService;
import com.projet.ig.gestionstage.services.IEtudiantStageService;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author pouemo
 */
@ManagedBean
@RequestScoped
public class EtudiantBean implements SelectableDataModel<Etudiant> {

    @ManagedProperty(value = "#{IEtudiantService}")
    private IEtudiantService etudiantService;
    private Etudiant etudiant = new Etudiant();
    private Etudiant etudiantSelect = new Etudiant();
    private Etudiant etudianUpdate;
    private List<Etudiant> etudiants;
    @ManagedProperty(value = "#{IEtudiantStageService}")
    private IEtudiantStageService etudiantStageService;
    private EtudiantStage etudiantStage = new EtudiantStage();
    private List<EtudiantStage> etudiantStages;
    private List<String> matricules;
    private List<Stage> stagesEtudiant;
    // private Parcours parcoursEtudiant;
    private Niveau niveauEtudiant;
    private EtudiantStage etudiantStageSelected;
    private SelectItem[] parcoursOptions = new SelectItem[11];
    private String matricule = "";

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    //generation des getters et setter
    public EtudiantStage getEtudiantStageSelected() {
        return etudiantStageSelected;
    }

    public void setEtudiantStageSelected(EtudiantStage etudiantStageSelected) {
        this.etudiantStageSelected = etudiantStageSelected;
    }

    public Etudiant getEtudianUpdate() {
        etudianUpdate = getEtudiantSelect();
        return etudianUpdate;
    }

    public void setEtudianUpdate(Etudiant etudianUpdate) {
        this.etudianUpdate = etudianUpdate;
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }

    public void setJasperPrint(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }
    
        public List<Stage> listStagesEtudiant() throws DataAccessException {
        if (!(etudiant.getMatricule() == null) && !(etudiant.getMatricule().compareTo("") == 0)) {
           // System.out.println(etudiant.getMatricule());
            stagesEtudiant = etudiantStageService.listStages("12x079s");
            for (Stage etudiantStage1 : stagesEtudiant) {
                System.out.println(etudiantStage1);
            }
            return stagesEtudiant;
        }
        return null;
    }

    public List<Stage> getStagesEtudiant() {
        return stagesEtudiant;
    }
        
        
    public Niveau getNiveauEtudiant() {
        niveauEtudiant = etudiant.getNiveau();
        return niveauEtudiant;
    }

    public void setNiveauEtudiant(Niveau niveauEtudiant) {
        this.niveauEtudiant = niveauEtudiant;
    }

    public IEtudiantService getEtudiantService() {
        return etudiantService;
    }

    public void setEtudiantService(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Etudiant getEtudiantSelect() {
        return etudiantSelect;
    }

    public void setEtudiantSelect(Etudiant etudiantSelect) {
        this.etudiantSelect = etudiantSelect;
    }

    public List<Etudiant> getEtudiants() throws DataAccessException {
        etudiants = new LinkedList<Etudiant>();
        etudiants = etudiantService.rechercherTous();
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

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

    public List<EtudiantStage> getEtudiantStages() throws DataAccessException {

        etudiantStages = new LinkedList<EtudiantStage>();
        etudiantStages = etudiantStageService.listeStagiaire();
        return etudiantStages;
    }

    public void setEtudiantStages(List<EtudiantStage> etudiantStages) {
        this.etudiantStages = etudiantStages;
    }

    public List<String> getMatricules() throws DataAccessException {
        matricules = new LinkedList<String>();
        matricules = etudiantService.listeDesMatricule();
        return matricules;
    }

    public void setMatricules(List<String> matricules) {
        this.matricules = matricules;
    }

    //le constructeur
    public EtudiantBean() {
    }

    public void enregistrer() throws DataAccessException {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "l'enregistrement a été éffectué avec success!!"));
        etudiantService.Enregistrer(etudiant);

    }

    public void modifier() throws DataAccessException {
        etudiantSelect = etudiantService.findById(etudiant.getId());
        etudiantSelect.setNom(etudiant.getNom());
        etudiantSelect.setPremon(etudiant.getPremon());
        etudiantSelect.setNiveau(etudiant.getNiveau());
        etudiantSelect.setParcours(etudiant.getParcours());
        etudiantSelect.setMatricule(etudiant.getMatricule());
        etudiantService.Modifier(etudiantSelect);
    }

    public List<Niveau> listerNiveau() {

        List<Niveau> list = new LinkedList<Niveau>();
        list.add(Niveau.Licence1);
        list.add(Niveau.Licence2);
        list.add(Niveau.Licence3);
        list.add(Niveau.Master1);
        list.add(Niveau.Master2);
        return list;
    }

    public List<Parcours> listerParcours() {

        List<Parcours> list = new LinkedList<Parcours>();
        list.add(Parcours.AGEPD);
        list.add(Parcours.BEARSPA);
        list.add(Parcours.CLIHYPE);
        list.add(Parcours.ENREN);
        list.add(Parcours.GTC);
        list.add(Parcours.HYMAE);
        list.add(Parcours.INFOTEL);
        list.add(Parcours.SCIENV);
        list.add(Parcours.SCISOD);
        list.add(Parcours.TRAMARH);

        return list;
    }

    public SelectItem[] getParcoursOptions() {
        parcoursOptions[0] = new SelectItem("", "Select");
        parcoursOptions[1] = new SelectItem(Parcours.AGEPD, "AGEPD");
        parcoursOptions[2] = new SelectItem(Parcours.BEARSPA, "BEARSPA");
        parcoursOptions[3] = new SelectItem(Parcours.CLIHYPE, "CLIHYPE");
        parcoursOptions[4] = new SelectItem(Parcours.ENREN, "ENREN");
        parcoursOptions[5] = new SelectItem(Parcours.GTC, "GTC");
        parcoursOptions[6] = new SelectItem(Parcours.HYMAE, "HYMAE");
        parcoursOptions[7] = new SelectItem(Parcours.INFOTEL, "INFOTEL");
        parcoursOptions[8] = new SelectItem(Parcours.SCIENV, "SCIENV");
        parcoursOptions[9] = new SelectItem(Parcours.SCISOD, "SCISOD");
        parcoursOptions[10] = new SelectItem(Parcours.TRAMARH, "TRAMARH");

        return parcoursOptions;
    }

    @Override
    public Etudiant getRowData(String rowKey) {
        try {
            List<Etudiant> etudiants1 = getEtudiants();
            for (Etudiant entre : etudiants1) {
                if (entre.getId().equals(rowKey)) {
                    return entre;
                }
            }

            return null;
        } catch (DataAccessException ex) {
            Logger.getLogger(EtudiantBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public Object getRowKey(Etudiant en) {
        return en.getId();
    }
    /*   Generons maintenant les pdf pour la gestion des etudiants       */
    JasperPrint jasperPrint;

    public void init() throws JRException {
        System.out.println("la taille des elements est de " + etudiants.size());
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(etudiants);
        jasperPrint = JasperFillManager.fillReport("/home/pouemo/projetTutore/GestionStage/src/main/webapp/reports/report.jasper", new HashMap(), beanCollectionDataSource);
    }

    public void pdf(ActionEvent actionEvent) throws JRException, IOException {

        init();

        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=liste_etudiant.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    }

    //JasperPrint jasperPrint;
    public void init1() throws JRException {
        System.out.println("la taille des elements est de " + etudiantStages.size());
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantStages);
        jasperPrint = JasperFillManager.fillReport("/home/pouemo/projetTutore/GestionStage/src/main/webapp/reports/miseEnStage.jasper", new HashMap(), beanCollectionDataSource);
    }

    public void miseEnStagePdf(ActionEvent actionEvent) throws JRException, IOException {

        init1();

        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=miseEnStage.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    }

    public void setStagesEtudiant(List<Stage> stagesEtudiant) {
        this.stagesEtudiant = stagesEtudiant;
    }
    
}
