/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Beans;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.AnneeAcademique;
import com.projet.ig.gestionstage.entity.Prospecteur;
import com.projet.ig.gestionstage.entity.Stage;
import com.projet.ig.gestionstage.services.IAnneeAcademiqueService;
import com.projet.ig.gestionstage.services.IStageService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.event.ItemSelectEvent;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author pouemo
 */
@ManagedBean
@RequestScoped
public class StatistiqueBean implements Serializable {

    @ManagedProperty(value = "#{IStageService}")
    private IStageService stageService;
    private Stage stage = new Stage();
    private Stage selectedStage = new Stage();
    private List<Stage> stages;
    @ManagedProperty(value = "#{IAnneeAcademiqueService}")
    private IAnneeAcademiqueService anneeService;
    private AnneeAcademique annee = new AnneeAcademique();
    private List<AnneeAcademique> anneeAcademiques;
    private List<String> annees;
    
    ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-conf.xml");
    IAnneeAcademiqueService anneeService2 = (IAnneeAcademiqueService) ctx.getBean("IAnneeAcademiqueService");
    private  IStageService stageservice = (IStageService) ctx.getBean("IStageService");
   
    private CartesianChartModel linearModel;
    private CartesianChartModel categoryModel;
    private PieChartModel pieModel;

    public StatistiqueBean() {
        createLinearModel();
        createCategoryModel();
        createPieModel();
    }

    public CartesianChartModel getLinearModel() {
        return linearModel;
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

    public Stage getSelectedStage() {
        return selectedStage;
    }

    public void setSelectedStage(Stage selectedStage) {
        this.selectedStage = selectedStage;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
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

    public List<String> getAnnees() throws DataAccessException {

        annees = anneeService2.listAnneeAcademic();
        return annees;
    }

    public void setAnnees(List<String> annees) {
        this.annees = annees;
    }

    private void createLinearModel() {
        linearModel = new CartesianChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");

        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
        series2.setMarkerStyle("diamond");

        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);

        linearModel.addSeries(series1);
        linearModel.addSeries(series2);
    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    private void createCategoryModel() {
        try {
            categoryModel = new CartesianChartModel();

            ChartSeries etudiant = new ChartSeries();
            etudiant.setLabel("Etudiant");

            ChartSeries enseignant = new ChartSeries();
            enseignant.setLabel("Enseignant");

            ChartSeries service = new ChartSeries();
            service.setLabel("Service");

            for (String an : getAnnees()) {

                etudiant.set(an, stageservice.findByprospecteurYear(Prospecteur.Etudiant, an).size());
                enseignant.set(an, stageservice.findByprospecteurYear(Prospecteur.Enseignant, an).size());
                service.set(an, stageservice.findByprospecteurYear(Prospecteur.ServiceDeStage, an).size());
            }

            categoryModel.addSeries(etudiant);
            categoryModel.addSeries(service);
            categoryModel.addSeries(enseignant);
        } catch (DataAccessException ex) {
            Logger.getLogger(StatistiqueBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void createPieModel() {
        pieModel = new PieChartModel();

        pieModel.set("Enseignant", 540);
        pieModel.set("Etudiant", 325);
        pieModel.set("Service", 702);
    }
}
