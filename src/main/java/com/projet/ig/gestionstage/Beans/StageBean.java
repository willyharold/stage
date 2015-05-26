/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Beans;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.AnneeAcademique;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.EtudiantStage;
import com.projet.ig.gestionstage.entity.Parcours;
import com.projet.ig.gestionstage.entity.Prospecteur;
import com.projet.ig.gestionstage.entity.Stage;
import com.projet.ig.gestionstage.entity.Type;
import com.projet.ig.gestionstage.services.IAnneeAcademiqueService;
import com.projet.ig.gestionstage.services.IEntrepriseService;
import com.projet.ig.gestionstage.services.IEtudiantService;
import com.projet.ig.gestionstage.services.IEtudiantStageService;
import com.projet.ig.gestionstage.services.IStageService;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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
@SessionScoped
public class StageBean implements SelectableDataModel<Stage>, Serializable {

    @ManagedProperty(value = "#{IStageService}")
    private IStageService stageService;
    private Stage stage = new Stage();
    private Stage selectedStage = new Stage();
    private List<Stage> stages;
    private List<Long> stagesId;
    private Type categories;

    public Type getCategories() {
        return categories;
    }

    public void setCategories(Type categories) {
        this.categories = categories;
    }
    private List<String> nomEntrepriseVilles;
    private List<String> nomEntreprises;
    private List<String> nomVilles;
    private List<String> nomVillesEntreprises;
    @ManagedProperty(value = "#{IEntrepriseService}")
    private IEntrepriseService entrepriseService;
    private Entreprise entreprise = new Entreprise();
    @ManagedProperty(value = "#{IEtudiantStageService}")
    private IEtudiantStageService etudiantStageService;
    private EtudiantStage etudiantStage = new EtudiantStage();
    private List<EtudiantStage> etudiantStages;
    @ManagedProperty(value = "#{IAnneeAcademiqueService}")
    private IAnneeAcademiqueService anneeService;
    private AnneeAcademique annee = new AnneeAcademique();
    private List<AnneeAcademique> anneeAcademiques;
    private List<String> annees;
    @ManagedProperty(value = "#{IEtudiantService}")
    private IEtudiantService etudiantService;
    private Etudiant etudiant = new Etudiant();
    private List<String> matricules;
    private String nomVille = "";
    private String nomEntreprise = "";
    private String matricule = "";
    private String anneeAc = "";
    private String nomDeEntreprise = "";
    private String nomDeVilleEntreprise = "";
    private Long id;

    public String getNomDeEntreprise() {
        return nomDeEntreprise;
    }

    public void setNomDeEntreprise(String nomDeEntreprise) {
        this.nomDeEntreprise = nomDeEntreprise;
    }

    public String getNomDeVilleEntreprise() {
        return nomDeVilleEntreprise;
    }

    public void setNomDeVilleEntreprise(String nomDeVilleEntreprise) {
        this.nomDeVilleEntreprise = nomDeVilleEntreprise;
    }
    
    

    public String getAnneeAc() {
        return anneeAc;
    }

    public void setAnneeAc(String anneeAc) {
        this.anneeAc = anneeAc;
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

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public StageBean() {
    }

    public IEntrepriseService getEntrepriseService() {
        return entrepriseService;
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

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setAnnee(AnneeAcademique annee) {
        this.annee = annee;
    }

    public IEtudiantService getEtudiantService() {
        return etudiantService;
    }

    public void setEtudiantService(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    public List<String> getMatricules() throws DataAccessException {
        matricules = new LinkedList<String>();
        matricules = etudiantService.listeDesMatricule();
        return matricules;
    }

    public void setMatricules(List<String> matricules) {
        this.matricules = matricules;
    }

    public List<String> getNomVilles() {
        nomVilles = new LinkedList<String>();
        try {
            nomVilles = entrepriseService.listeEntrepriseVille();
        } catch (DataAccessException ex) {
            Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomVilles;
    }

    public void setNomVilles(List<String> nomVilles) {
        this.nomVilles = nomVilles;
    }

    public List<String> getNomVillesEntreprises() {
        nomVillesEntreprises = new LinkedList<String>();
        try {
            nomVillesEntreprises = entrepriseService.findByVille(nomVille);
        } catch (DataAccessException ex) {
            Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomVillesEntreprises;
    }

    public void setNomVillesEntreprises(List<String> nomVillesEntreprises) {
        this.nomVillesEntreprises = nomVillesEntreprises;
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

    public List<AnneeAcademique> getAnneeAcademiques() {
        return anneeAcademiques;
    }

    public void setAnneeAcademiques(List<AnneeAcademique> anneeAcademiques) {
        this.anneeAcademiques = anneeAcademiques;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public void setEntrepriseService(IEntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    public Stage getSelectedStage() {
        return selectedStage;
    }

    public void setSelectedStage(Stage selectedStage) {
        this.selectedStage = selectedStage;
    }

    public IStageService getStageService() {
        return stageService;
    }

    public void setStageService(IStageService stageService) {
        this.stageService = stageService;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public List<Stage> getStages() throws DataAccessException {

        stages = new LinkedList<Stage>();
        stages = stageService.findByAll();
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    public List<Long> getStagesId() throws DataAccessException {

        stagesId = new LinkedList<Long>();

        System.out.println("  la ville est  " + nomVille + "le nom de l'enreprise est " + nomEntreprise + " le matricule est " + matricule + " l'annee est " + anneeAc);
        if (!nomEntreprise.isEmpty() && !nomVille.isEmpty() && !matricule.isEmpty() && !anneeAc.isEmpty()) {
            Entreprise ent = entrepriseService.findByNomVille(nomEntreprise, nomVille);
            Etudiant etd = etudiantService.findByMatricule(matricule);
            stagesId = stageService.stageEntrepriseAnnee(ent, etd.getNiveau(), anneeAc, etd.getParcours());
            return stagesId;
        }
        return null;
    }

    public void setStagesId(List<Long> stagesId) {
        this.stagesId = stagesId;
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

    public List<EtudiantStage> getEtudiantStages() {
        return etudiantStages;
    }

    public void setEtudiantStages(List<EtudiantStage> etudiantStages) {
        this.etudiantStages = etudiantStages;
    }

    public void enregister() throws DataAccessException {
          //stageService.enregistrer(stage);
        System.out.println("--------------  je suis ici -----------");
        try {
            if ((!nomDeEntreprise.isEmpty()) && (!nomDeVilleEntreprise.isEmpty() ) ) {
                //System.out.println("---Ville----"+nomDeVilleEntreprise);
                Entreprise ent = entrepriseService.findByNomVille(nomDeEntreprise, nomDeVilleEntreprise);
                stage.setEntreprise(ent);
                stageService.enregistrer(stage);
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(StageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void affecter() throws DataAccessException {

        if (!matricule.isEmpty()) {

            Etudiant etd = etudiantService.findByMatricule(matricule);
            Stage stg = stageService.findById(selectedStage.getId());
            etudiantStage.setMatricule(matricule);
            etudiantStage.setEtudiant(etd);
            etudiantStage.setStage(stg);

            etudiantStageService.enregistrer(etudiantStage);
        }

    }

    public void afficher() throws DataAccessException {

        System.out.println(" ==========================" + selectedStage.getStatus());

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

    public List<Type> listeTypeStage() {
        List<Type> list = new LinkedList<Type>();
        list.add(Type.Ouvrier);
        list.add(Type.AgentdeMaitrise1);
        list.add(Type.FindEtude1);
        list.add(Type.AgentdeMaitrise2);
        list.add(Type.FinDetude2);
        return list;
    }

    public List<Prospecteur> listerProspecteur() {
        List<Prospecteur> list = new LinkedList<Prospecteur>();
        list.add(Prospecteur.Etudiant);
        list.add(Prospecteur.Enseignant);
        list.add(Prospecteur.ServiceDeStage);
        return list;

    }

    @Override
    public Stage getRowData(String rowKey) {
        try {
            List<Stage> stages1 = getStages();

            for (Stage st : stages1) {
                if (st.getId().equals(rowKey)) {
                    return st;
                }
            }

            return null;
        } catch (DataAccessException ex) {
            Logger.getLogger(StageBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Object getRowKey(Stage stage) {
        return stage.getId();
    }

    public List<String> getNomEntrepriseVilles() {
        nomEntrepriseVilles = new LinkedList<String>();
        if (!nomDeEntreprise.isEmpty()) {
            //System.out.println(" ++++ in in in +++  "+nomDeEntreprise);
            try {
                nomEntrepriseVilles = entrepriseService.listeEntrepriseVille(nomDeEntreprise);
            } catch (DataAccessException ex) {
                Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            return nomEntrepriseVilles;
        }
        //nomEntrepriseVilles.add("ville");
        return nomEntrepriseVilles;
    }

    public void setNomEntrepriseVilles(List<String> nomEntrepriseVilles) {
        this.nomEntrepriseVilles = nomEntrepriseVilles;
    }

    public List<String> getNomEntreprises() {
        nomEntreprises = new LinkedList<String>();
        try {
            nomEntreprises = entrepriseService.listeNom();
        } catch (DataAccessException ex) {
            Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomEntreprises;
    }

    public void setNomEntreprises(List<String> nomEntreprises) {
        this.nomEntreprises = nomEntreprises;
    }

    // Les methodes pour la gestion des notifications
    public void save(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Enregistrement", "OK "));
    }

    public void update(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("modifier ok", "OK "));
    }
    /*   Generons maintenant les pdf pour la gestion des stages       */
    JasperPrint jasperPrint;

    public void init() throws JRException {
        System.out.println("la taille des elements est de " + etudiantStages.size());
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantStages);
        jasperPrint = JasperFillManager.fillReport("/home/pouemo/projetTutore/GestionStage/src/main/webapp/reports/miseEnStage.jasper", new HashMap(), beanCollectionDataSource);
    }

    public void pdf(ActionEvent actionEvent) throws JRException, IOException {

        init();

        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=miseEnStage.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    }
}
