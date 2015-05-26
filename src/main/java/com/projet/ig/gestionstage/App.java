package com.projet.ig.gestionstage;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.AgentDeSuivi;
import com.projet.ig.gestionstage.entity.AgentEntreprise;
import com.projet.ig.gestionstage.entity.AgentScolarite;
import com.projet.ig.gestionstage.entity.AnneeAcademique;
import com.projet.ig.gestionstage.entity.DomaineActivite;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.EtudiantStage;
import com.projet.ig.gestionstage.entity.Fonction;
import com.projet.ig.gestionstage.entity.Niveau;
import com.projet.ig.gestionstage.entity.Parcours;
import com.projet.ig.gestionstage.entity.Prospecteur;
import com.projet.ig.gestionstage.entity.Reponse;
import com.projet.ig.gestionstage.entity.Stage;
import com.projet.ig.gestionstage.entity.Type;
import com.projet.ig.gestionstage.services.IAgentDeSuiviService;
import com.projet.ig.gestionstage.services.IAgentEntrepriseService;
import com.projet.ig.gestionstage.services.IAgentScolariteService;
import com.projet.ig.gestionstage.services.IAnneeAcademiqueService;
import com.projet.ig.gestionstage.services.IDomaineActiviteService;
import com.projet.ig.gestionstage.services.IEntrepriseService;
import com.projet.ig.gestionstage.services.IEtudiantService;
import com.projet.ig.gestionstage.services.IEtudiantStageService;
import com.projet.ig.gestionstage.services.IStageService;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    private static IEntrepriseService entrepriseservice;
    private static IAgentDeSuiviService agentDeSuiviservice;
    private static IDomaineActiviteService domaineactiviteservice;
    private static IStageService stageservice;
    private static IEtudiantService etudiantservice;
    private static IAgentScolariteService agentService;
     private static IAgentEntrepriseService agentEnService;

    public static void main(String[] args) throws DataAccessException{
            ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-conf.xml");
//
//            /* le teste de la couhe service du domaine Activite*/
//            domaineactiviteservice = (IDomaineActiviteService) ctx.getBean("IDomaineActiviteService");
//
//            List<Entreprise> liste = new LinkedList<Entreprise>();
//
//            DomaineActivite domaine = new DomaineActivite();
//            domaine.setNomDomaine("Reseaux");
//            domaine.setEntreprises(liste);
//            
//            domaineactiviteservice.enregistrer(domaine);

            

            // domaineactiviteservice.enregistrer(domaine);
     
            /* Le teste de la couche service de l'agent de suivi*/
//            agentDeSuiviservice = (IAgentDeSuiviService) ctx.getBean("IAgentDeSuiviService");
//
//            AgentDeSuivi agent = new AgentDeSuivi();
//            agent.setEmail("tramarh@gmail.com");
//            agent.setEnService("Departement tramah");
//            agent.setFonction("enseignant");
//            agent.setNom("Koki");
//            agent.setNumeroTelephone("95023321");
//            agent.setPremon("piere");
//
//             agentDeSuiviservice.Enregistrer(agent);

//            /* Le teste de la couche service de l' Entreprise*/
//            entrepriseservice = (IEntrepriseService) ctx.getBean("IEntrepriseService");
//
//            Entreprise entreprise = new Entreprise();
//            entreprise.setBoitePostale("BP 17");
//            entreprise.setNomEntreprise("Matrix");
//            entreprise.setNomVille("Bafoussam");
//            entreprise.setNumeroTelephone("78164234");
//            entreprise.setSigle("Mt");
//            entreprise.setE_mail("matrix@yaoo.fr");
//
//
//            entreprise = entrepriseservice.findById(1L);
//
//            entrepriseservice.enregistrer(entreprise);

//
//
//
//            IAnneeAcademiqueService anneeService = (IAnneeAcademiqueService)ctx.getBean("IAnneeAcademiqueService"); 
//            AnneeAcademique annee = new AnneeAcademique();
//            annee.setAnneeAcademique("2011/2012");
//
//            anneeService.enregistrer(annee);
//
//            System.out.println("la tailles des aneees est "+anneeService.listAnneeAcademic().size());
//
//           // annee = anneeService.rechercher(1l);
//
//            Calendar cal = Calendar.getInstance();
//            cal.set(Calendar.YEAR, 2014);
//            cal.set(Calendar.MONTH, 7);
//            cal.set(Calendar.DAY_OF_MONTH, 26);
//            Date debut = cal.getTime();
//
//            cal.set(Calendar.YEAR, 2014);
//            cal.set(Calendar.MONTH, 9);
//            cal.set(Calendar.DAY_OF_MONTH, 12);
//            Date fin = cal.getTime();
//            int i = cal.get(3);
//            System.out.println("la valeur de i  "+i);
//
//            agentEnService = (IAgentEntrepriseService)ctx.getBean("IAgentEntrepriseService");
//
//            AgentEntreprise ae = new AgentEntreprise();
//            ae.setAgent(agent);
//            ae.setAnnee(annee);
//            ae.setEntreprise(entreprise);
//            ae.setDateDeVisite(debut);
//
//            agentEnService.enregistrer(ae);
//
//            stageservice = (IStageService) ctx.getBean("IStageService");
//
//            Stage stage = new Stage();
//            stage.setCathegorie(Type.FindEtude1);
//            stage.setDebut(debut);
//            stage.setEntreprise(entreprise);
//            stage.setFin(fin);
//            stage.setStatus(Reponse.NON);
//            stage.setParcours(Parcours.INFOTEL);
//            stage.setProspecteur(Prospecteur.Enseignant);
//            stage.setAnneeAcademique("2014-2015");
//            stage.setTheme("installation d'un portail captif");
//
//            //stage = stageservice.findById(1L);
//
//            stageservice.enregistrer(stage);
//
//
//            /*   pour un etudiant   */
//            etudiantservice = (IEtudiantService) ctx.getBean("IEtudiantService");
//            Etudiant etudiant = new Etudiant();
//            etudiant= etudiantservice.findById(4L);
//            System.out.println(etudiant);  
//            etudiant.setPremon("willy");
//            etudiantservice.Modifier(etudiant);
            //etudiantservice.Enregistrer(etudiant);
//
//           // etudiant = etudiantservice.findByMatricule("11x322l");
//
//            //IAnneeAcademiqueService
//
//            /* la gestion des annee academique*/
//
//
//
//           //la gestion des etudiant Stage
//          IEtudiantStageDao etudiantStage = ctx.getBean(IEtudiantStageDao.class);
//            agentService = (IAgentScolariteService)ctx.getBean("IAgentScolariteService");
//
//            AgentScolarite ag = new AgentScolarite();
//            ag.setEmail("pouemo@gmail.fr");
//            ag.setFonction(Fonction.Agent);
//            ag.setLogin("admin");
//            ag.setMotdePasse("admin");
//            ag.setNom("pouemo");
//            ag.setNumeroTelephone("76324361");
//            ag.setPremon("Adrien");
//
//            agentService.enregistrer(ag);
            
//           IAgentDeSuiviService agentsuivi = (IAgentDeSuiviService)ctx.getBean("IAgentDeSuiviService");
//
//           AgentDeSuivi agentDeSuivi= new AgentDeSuivi();
//           agentsuivi.del(131072);
           //agentDeSuivi = agentsuivi.findById(98304);
            //System.out.println(agentDeSuivi);
            //agentsuivi.Supprimer(agentDeSuivi);
           //
            IEtudiantStageService etudiantStage = (IEtudiantStageService)ctx.getBean("IEtudiantStageService");

            EtudiantStage ets = new EtudiantStage();
            List<Stage> lisstage = new LinkedList<Stage>();
            lisstage= etudiantStage.listStages("12x079s");
            for (Stage etudiantStage1 : lisstage) {
                System.out.println(etudiantStage1);
            
        }
//            ets.setMatricule(etudiant.getMatricule());
//            ets.setNote((float) 16.5);
//            ets.setEtudiant(etudiant);
//            ets.setStage(stage);
//            ets.setAnneeAcademique(stage.getAnneeAcademique()); 
//
//
//            etudiantStage.enregistrer(ets);
//
//
//
//
//            //  stageservice.affecterStage(etudiant, stage);
//
//
//
//            /**
//             * * Teste des des methodes particulieres*
//    //         */
//    //        List<Etudiant> listEtu = entrepriseservice.listeEtudiant(entreprise);
//    //        System.out.println("\n---- Les etudiants ayant fait leur stage dans l'entreprise " + entreprise.getNomEntreprise() + " sont ----");
//    //        for (Etudiant etd : listEtu) {
//    //            System.err.println(" \n " + etd);
//    //        }
//    //
//    //        List<Stage> listStg = entrepriseservice.listeStage(entreprise);
//    //        System.out.println("\n----Les Stages offert par l'entreprise " + entreprise.getNomEntreprise() + "  sont ----");
    //        for (Stage stg : listStg) {
    //            System.err.println(" \n " + stg);
    //        }
    //        
    //        etudiant = etudiantservice.findById(1l);
    //        listStg = etudiantservice.listeStage(etudiant);
    //        System.out.println("\n----Les Stages fait par l'etudiant " + etudiant.getNom() + "  sont ----");
    //        for (Stage stg : listStg) {
    //            System.err.println(" \n " + stg);
    //        }
    //        
    //        stage = stageservice.findById(1L);
           // stageservice.supprimer(stage);
    }
}
