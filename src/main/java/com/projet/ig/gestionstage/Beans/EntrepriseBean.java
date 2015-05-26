/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Beans;

import com.douwe.generic.dao.DataAccessException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.ListItem;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.projet.ig.gestionstage.entity.DomaineActivite;
import com.projet.ig.gestionstage.services.IEntrepriseService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.entity.Stage;
import com.projet.ig.gestionstage.services.IDomaineActiviteService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author pouemo
 */
@ManagedBean
@SessionScoped
public class EntrepriseBean implements SelectableDataModel<Entreprise>, Serializable {

    @ManagedProperty(value = "#{IEntrepriseService}")
    private IEntrepriseService entrepriseService;
    private Entreprise entreprise = new Entreprise();
    private List<Entreprise> entreprises;
    private Entreprise entrepriseSelected = new Entreprise();
    private List<String> nomEntreprises;
    private List<String> nomVilles;
    private List<String> nomVillesEntreprises;
    private List<String> nomEntrepriseVilles;
    private List<String> reponses;
    private String reponse;
    private List<Entreprise> listEnt;
    @ManagedProperty(value = "#{IDomaineActiviteService}")
    private IDomaineActiviteService domaineActiviteService;
    private String nomDomaine;
    private List<String> nomDomaines;
    //
    private String nomVille = "";
    private String nomEntreprise = "";
    private Date dateDebut1;
    private Date dateFin1;
    private Date dateDebut3;
    private Date dateFin3;
    private Date dateDebut5;
    private Date dateFin5;
    private Date dateDebut24;
    private Date dateFin24;
    private Calendar cal = Calendar.getInstance();

    public Calendar getCal() {
        return cal;
    }

    public void setCal(Calendar cal) {
        this.cal = cal;
    }

    public List<Entreprise> getListEnt() throws DataAccessException {
        listEnt = new LinkedList<Entreprise>();
        if (!nomEntreprise.isEmpty() && !nomVille.isEmpty()) {
            Entreprise ent = entrepriseService.findByNomVille(nomEntreprise, nomVille);
            listEnt.add(ent);
            return listEnt;
        }
        return null;
    }

    public void setListEnt(List<Entreprise> listEnt) {
        this.listEnt = listEnt;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public List<String> getReponses() {
        reponses = new LinkedList<String>();
        reponses.add("OUI");
        reponses.add("NON");
        return reponses;
    }

    public void setReponses(List<String> reponses) {
        this.reponses = reponses;
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

    public IDomaineActiviteService getDomaineActiviteService() {
        return domaineActiviteService;
    }

    public void setDomaineActiviteService(IDomaineActiviteService domaineActiviteService) {
        this.domaineActiviteService = domaineActiviteService;
    }

    public String getNomDomaine() {
        return nomDomaine;
    }

    public void setNomDomaine(String nomDomaine) {
        this.nomDomaine = nomDomaine;
    }
    public List<String> getNomDomaines() {
        nomDomaines = new LinkedList<String>();
        try {
            nomDomaines = domaineActiviteService.listerDomaine();
        } catch (DataAccessException ex) {
            Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomDomaines;
    }

    public void setNomDomaines(List<String> nomDomaines) {
        this.nomDomaines = nomDomaines;
    }

    public Date getDateDebut1() {
        return dateDebut1;
    }

    public void setDateDebut1(Date dateDebut1) {
        this.dateDebut1 = dateDebut1;
    }

    public Date getDateFin1() {
        return dateFin1;
    }

    public void setDateFin1(Date dateFin1) {
        this.dateFin1 = dateFin1;
    }

    public Date getDateDebut3() {
        return dateDebut3;
    }

    public void setDateDebut3(Date dateDebut3) {
        this.dateDebut3 = dateDebut3;
    }

    public Date getDateFin3() {
        return dateFin3;
    }

    public void setDateFin3(Date dateFin3) {
        this.dateFin3 = dateFin3;
    }

    public Date getDateDebut5() {
        return dateDebut5;
    }

    public void setDateDebut5(Date dateDebut5) {
        this.dateDebut5 = dateDebut5;
    }

    public Date getDateFin5() {
        return dateFin5;
    }

    public void setDateFin5(Date dateFin5) {
        this.dateFin5 = dateFin5;
    }

    public Date getDateDebut24() {
        return dateDebut24;
    }

    public void setDateDebut24(Date dateDebut24) {
        this.dateDebut24 = dateDebut24;
    }

    public Date getDateFin24() {
        return dateFin24;
    }

    public void setDateFin24(Date dateFin24) {
        this.dateFin24 = dateFin24;
    }
    //

    public EntrepriseBean() {
    }

    public List<String> getNomEntrepriseVilles() {
        nomEntrepriseVilles = new LinkedList<String>();
        try {
            if (!(nomEntreprise.isEmpty())) {
                entreprise.setNomEntreprise(nomEntreprise);
                nomEntrepriseVilles = entrepriseService.listeEntrepriseVille(entreprise.getNomEntreprise());
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomEntrepriseVilles;
    }

    public void setNomEntrepriseVilles(List<String> nomEntrepriseVilles) {
        this.nomEntrepriseVilles = nomEntrepriseVilles;
    }

    public IEntrepriseService getEntrepriseService() {
        return entrepriseService;
    }

    public void setEntrepriseService(IEntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
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
            if (!(nomVille.isEmpty())) {
                entreprise.setNomVille(nomVille);
                nomVillesEntreprises = entrepriseService.findByVille(entreprise.getNomVille());
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomVillesEntreprises;
    }

    public void setNomVillesEntreprises(List<String> nomVillesEntreprises) {
        this.nomVillesEntreprises = nomVillesEntreprises;
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

    public List<Entreprise> getEntreprises() {
        entreprises = new LinkedList<Entreprise>();
        try {
            entreprises = entrepriseService.afficherTous();
        } catch (DataAccessException ex) {
            Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entreprises;
    }

    public void setEntreprises(List<Entreprise> entreprises) {
        this.entreprises = entreprises;
    }

    public Entreprise getEntrepriseSelected() {
        return entrepriseSelected;
    }

    public void setEntrepriseSelected(Entreprise entrepriseSelected) {
        this.entrepriseSelected = entrepriseSelected;
    }

    public void enregistrer() {
        try {
            entrepriseService.enregistrer(entreprise);
        } catch (DataAccessException ex) {
            Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void test() {
        System.out.println("Nous sommes deja ici les pots ");
        if ((entrepriseSelected.getNomEntreprise() != null) && (!entrepriseSelected.getNomEntreprise().isEmpty())) {
            System.out.println("la valeur de la ville " + entrepriseSelected.getNomVille());

        }
    }

    public void modifier() throws DataAccessException {
        entrepriseService.modifier(entrepriseSelected);
    }

    public List<Stage> listeStages() throws DataAccessException {
        System.out.println("bonjour");
        if ((entrepriseSelected.getNomEntreprise() != null) && (!entrepriseSelected.getNomEntreprise().isEmpty())) {
            Entreprise ent = entrepriseService.findByNomVille(entrepriseSelected.getNomEntreprise(), entrepriseSelected.getNomVille());
            System.out.println("la valeur de la ville " + entrepriseSelected.getNomVille());
            if (!entrepriseService.listeStage(ent).isEmpty()) {
                return entrepriseService.listeStage(ent);
            }
        }
        return null;

    }

    public List<DomaineActivite> listeDomaine() {
        try {
            if (entrepriseSelected.getNomEntreprise() != null) {
                Entreprise entr = entrepriseService.findByNomVille(entrepriseSelected.getNomEntreprise(), entrepriseSelected.getNomVille());
                List<DomaineActivite> domaines = entrepriseService.listeDomaine(entr);
                return domaines;
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public List<String> listDomaineName() {
        try {
            return domaineActiviteService.listerDomaine();
        } catch (DataAccessException ex) {
            Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public void addDomaine() {
        try {
            if ((entrepriseSelected.getNomEntreprise() != null) && (nomDomaine != null)) {
                Entreprise entr = entrepriseService.findByNomVille(entrepriseSelected.getNomEntreprise(), entrepriseSelected.getNomVille());
                DomaineActivite dom = domaineActiviteService.findbyDomaineName(nomDomaine);
                entrepriseService.addDomainToEnterprise(entr.getId(), dom.getId());
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Entreprise getRowData(String rowKey) {

        List<Entreprise> entreprise1 = getEntreprises();

        for (Entreprise entre : entreprise1) {
            if (entre.getId().equals(rowKey)) {
                return entre;
            }
        }

        return null;

    }

    @Override
    public Object getRowKey(Entreprise en) {
        return en.getId();
    }

    /*   Generons maintenant les pdf pour la gestion des stages       */
    public void demandeStageAll() throws IOException, DocumentException {
        System.out.println("la valeur de la date est " + dateDebut1);
        FacesContext context = FacesContext.getCurrentInstance();
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);


        if (!document.isOpen()) {
            document.open();
        }
        try {
            List<Entreprise> tousEN = new LinkedList<Entreprise>();
            tousEN = entrepriseService.afficherTous();
            for (Entreprise en : tousEN) {
                String nomville = en.getNomVille().toUpperCase();
                String nomEnt = en.getNomEntreprise().toUpperCase();

                String genre_res = en.getGenre() + " " + en.getReponsable();
                // ajout de l'image d'entete
                String path = context.getExternalContext().getRealPath("/images/sygeses.PNG");
                Image image = Image.getInstance(path);
                image.scaleAbsolute(520f, 160f);
                image.setAbsolutePosition(15f, 680f);
                document.add(image);

                // add a news paragraph 
                String extractsFromDavidCopperfield[] = {
                    //* 1 
                    "       Vous avez bien voulu accepter  recevoir nos étudiants dans votre entreprise l'année dernière, je saisis"
                    + " cette occasion pour vous remercier de votre engagement à accompagner l'Institut Supérieur du Sahel dans son"
                    + " effort de donner une formation adéquate relevant de son domaine d'expertise.",
                    //* 2 
                    "       Dans le même élan de solidarité, je viens par la présente solliciter une fois de plus votre concours pour"
                    + " l'accueil en stage de nos étudiants pour le compte de l'année académique " + anneeAc(dateFin1) + ".",
                    //* 3 
                    "       Les dites stages se dérouleront du : \n",
                    //* 4 
                    "       Pendant leur stage, les étudiants sont assurés par la police d'assurance de l'Université de Maroua, et"
                    + " leur prise en charge pour dépenses personnelles par leurs soins.",
                    //* 5 
                    "       Dans l'attente d'une suite favorable à notre demande, veuillez agréer, " + genre_res + ","
                    + " l'expression de ma parfaite consideration.",
                    //* 6 
                    " :- La fiche de prospection permettant d'indiquer le nombre de stages par vous, accordé.",
                    //* 7 
                    " Le Directeur"
                };
                for (int j = 0; j < 8; j++) {
                    document.add(new Paragraph(" "));
                }

                Paragraph paragraph = new Paragraph("A \n" + genre_res + "  \n" + nomEnt, new Font(Font.TIMES_ROMAN, 12, Font.BOLD));
                paragraph.setIndentationLeft(290);
                document.add(paragraph);
                paragraph = new Paragraph(nomville, new Font(Font.TIMES_ROMAN, 12, Font.UNDERLINE));
                paragraph.setIndentationLeft(290);
                document.add(paragraph);
                Paragraph paragraph1 = new Paragraph();
                paragraph1.add(new Chunk("Object:", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD)));
                paragraph1.add(new Chunk(" Demande de stages ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ITALIC)));
                document.add(new Paragraph(paragraph1));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("       " + genre_res + ",", new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(extractsFromDavidCopperfield[0], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[1], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[2], new Font(Font.TIMES_ROMAN)));
                com.lowagie.text.List list1 = new com.lowagie.text.List(com.lowagie.text.List.UNORDERED, 12);
                list1.add(new ListItem(dateEnlettre(dateDebut5, dateFin5) + " pour ceux de fin d'études Master II;", new Font(Font.TIMES_ROMAN, 12)));
                list1.add(new ListItem(dateEnlettre(dateDebut3, dateFin3) + " pour ceux de fin d'études Licence III;", new Font(Font.TIMES_ROMAN, 12)));
                list1.add(new ListItem(dateEnlettre(dateDebut1, dateFin1) + " pour ceux d'imprégnation de Licence I;", new Font(Font.TIMES_ROMAN, 12)));
                list1.add(new ListItem(dateEnlettre(dateDebut24, dateFin24) + " pour ceux d'agent de maîtrise Licence II et Master I.", new Font(Font.TIMES_ROMAN, 12)));
                //list1.add(new ListItem);
                document.add(list1);
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[3], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[4], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                paragraph1 = new Paragraph();
                paragraph1.add(new Chunk("P.j", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD)));
                paragraph1.add(new Chunk(extractsFromDavidCopperfield[5], FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ITALIC)));
                document.add(new Paragraph(paragraph1));
                document.add(new Paragraph(" "));
                paragraph = new Paragraph(extractsFromDavidCopperfield[6], new Font(Font.TIMES_ROMAN, 12, Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                document.add(paragraph);
                document.newPage();
            }
        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (DataAccessException ex) {
            Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        document.close();
        String fileName = "llettreDemandeStages";
        writePDFToResponse(context.getExternalContext(), baos, fileName);
        context.responseComplete();
    }

    public void lettreRemerciementAll() throws IOException, DocumentException {
        System.out.println("la valeur de la date est " + dateDebut1);
        FacesContext context = FacesContext.getCurrentInstance();
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);


        if (!document.isOpen()) {
            document.open();
        }
        try {
            List<Entreprise> tousEN = new LinkedList<Entreprise>();
            tousEN = entrepriseService.afficherTous();
            for (Entreprise en : tousEN) {
                String nomville = en.getNomVille().toUpperCase();
                String nomEnt = en.getNomEntreprise().toUpperCase();

                String genre_res = en.getGenre() + " " + en.getReponsable();
                // ajout de l'image d'entete
                String path = context.getExternalContext().getRealPath("/images/sygeses.PNG");
                Image image = Image.getInstance(path);
                image.scaleAbsolute(520f, 160f);
                image.setAbsolutePosition(15f, 680f);
                document.add(image);

                // add a news paragraph 
                String extractsFromDavidCopperfield[] = {
                    //* 1 
                    "       Faisant suite à votre accord d'encadrement des stages académiques de nos étudiants, nous"
                    + "  vous remercions de votre effort de nous accompagner dans la formation de nos jeunes et nous vous"
                    + " transmettons par la même occasion les noms des étudiants qui effectueront le stage pour l'année académique" + anneeAcad() + ".",
                    //* 2 
                    "       Les dites stages se dérouleront du : \n",
                    //* 3 
                    "       Nous restons à votre entiere disposition pour toutes informations concernant les modalités"
                    + " de déroulement du stage et comptons au renforcement de la collaboration entre nos deux structures.",
                    //* 4 
                    "     La liste  des étudiants est jointe en annexe.",
                    //* 5 
                    "       Veuillez agréer, " + genre_res + ", l'expression de ma parfaite consideration.",
                    //* 6 
                    " Le Directeur"
                };
                for (int j = 0; j < 8; j++) {
                    document.add(new Paragraph(" "));
                }

                Paragraph paragraph = new Paragraph("A \n" + genre_res + "  \n" + nomEnt, new Font(Font.TIMES_ROMAN, 12, Font.BOLD));
                paragraph.setIndentationLeft(290);
                document.add(paragraph);
                paragraph = new Paragraph(nomville, new Font(Font.TIMES_ROMAN, 12, Font.UNDERLINE));
                paragraph.setIndentationLeft(290);
                document.add(paragraph);
                Paragraph paragraph1 = new Paragraph();
                paragraph1.add(new Chunk("Object:", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD)));
                paragraph1.add(new Chunk(" Stage académique ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ITALIC)));
                document.add(new Paragraph(paragraph1));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("       " + genre_res + ",", new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(extractsFromDavidCopperfield[0], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[1], new Font(Font.TIMES_ROMAN)));
                com.lowagie.text.List list1 = new com.lowagie.text.List(com.lowagie.text.List.UNORDERED, 12);
                list1.add(new ListItem(dateEnlettre(dateDebut5, dateFin5) + " pour ceux de fin d'études Master II;", new Font(Font.TIMES_ROMAN, 12)));
                list1.add(new ListItem(dateEnlettre(dateDebut3, dateFin3) + " pour ceux de fin d'études Licence III;", new Font(Font.TIMES_ROMAN, 12)));
                list1.add(new ListItem(dateEnlettre(dateDebut1, dateFin1) + " pour ceux d'imprégnation de Licence I;", new Font(Font.TIMES_ROMAN, 12)));
                list1.add(new ListItem(dateEnlettre(dateDebut24, dateFin24) + " pour ceux d'agent de maîtrise Licence II et Master I.", new Font(Font.TIMES_ROMAN, 12)));
                //list1.add(new ListItem);
                document.add(list1);
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[2], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[3], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[4], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                paragraph = new Paragraph(extractsFromDavidCopperfield[5], new Font(Font.TIMES_ROMAN, 12, Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                document.add(paragraph);
                document.newPage();
            }
        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (DataAccessException ex) {
            Logger.getLogger(EntrepriseBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        document.close();
        String fileName = "lettreRemerciements";
        writePDFToResponse(context.getExternalContext(), baos, fileName);
        context.responseComplete();
    }

    //les lettres pour une seule entreprise
    public void demandeStage() throws IOException, DocumentException {
        System.out.println("la valeur de la date est " + dateDebut1);
        FacesContext context = FacesContext.getCurrentInstance();
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);


        if (!document.isOpen()) {
            document.open();
        }
        try {
            if (!entrepriseSelected.getNomEntreprise().isEmpty() && entrepriseSelected.getNomEntreprise() != null) {
                Entreprise en = entrepriseSelected;
                String nomville = en.getNomVille().toUpperCase();
                String nomEnt = en.getNomEntreprise().toUpperCase();

                String genre_res = en.getGenre() + " " + en.getReponsable();
                // ajout de l'image d'entete
                String path = context.getExternalContext().getRealPath("/images/sygeses.PNG");
                Image image = Image.getInstance(path);
                image.scaleAbsolute(520f, 160f);
                image.setAbsolutePosition(15f, 680f);
                document.add(image);

                // add a news paragraph 
                String extractsFromDavidCopperfield[] = {
                    //* 1 
                    "       Vous avez bien voulu accepter  recevoir nos étudiants dans votre entreprise l'année dernière, je saisis"
                    + " cette occasion pour vous remercier de votre engagement à accompagner l'Institut Supérieur du Sahel dans son"
                    + " effort de donner une formation adéquate relevant de son domaine d'expertise.",
                    //* 2 
                    "       Dans le même élan de solidarité, je viens par la présente solliciter une fois de plus votre concours pour"
                    + " l'accueil en stage de nos étudiants pour le compte de l'année académique " + anneeAc(dateFin1) + ".",
                    //* 3 
                    "       Les dites stages se dérouleront du : \n",
                    //* 4 
                    "       Pendant leur stage, les étudiants sont assurés par la police d'assurance de l'Université de Maroua, et"
                    + " leur prise en charge pour dépenses personnelles par leurs soins.",
                    //* 5 
                    "       Dans l'attente d'une suite favorable à notre demande, veuillez agréer, " + genre_res + ","
                    + " l'expression de ma parfaite consideration.",
                    //* 6 
                    " :- La fiche de prospection permettant d'indiquer le nombre de stages par vous, accordé.",
                    //* 7 
                    " Le Directeur"
                };
                for (int j = 0; j < 8; j++) {
                    document.add(new Paragraph(" "));
                }

                Paragraph paragraph = new Paragraph("A \n" + genre_res + "  \n" + nomEnt, new Font(Font.TIMES_ROMAN, 12, Font.BOLD));
                paragraph.setIndentationLeft(290);
                document.add(paragraph);
                paragraph = new Paragraph(nomville, new Font(Font.TIMES_ROMAN, 12, Font.UNDERLINE));
                paragraph.setIndentationLeft(290);
                document.add(paragraph);
                Paragraph paragraph1 = new Paragraph();
                paragraph1.add(new Chunk("Object:", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD)));
                paragraph1.add(new Chunk(" Demande de stages ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ITALIC)));
                document.add(new Paragraph(paragraph1));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("       " + genre_res + ",", new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(extractsFromDavidCopperfield[0], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[1], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[2], new Font(Font.TIMES_ROMAN)));
                com.lowagie.text.List list1 = new com.lowagie.text.List(com.lowagie.text.List.UNORDERED, 12);
                list1.add(new ListItem(dateEnlettre(dateDebut5, dateFin5) + " pour ceux de fin d'études Master II;", new Font(Font.TIMES_ROMAN, 12)));
                list1.add(new ListItem(dateEnlettre(dateDebut3, dateFin3) + " pour ceux de fin d'études Licence III;", new Font(Font.TIMES_ROMAN, 12)));
                list1.add(new ListItem(dateEnlettre(dateDebut1, dateFin1) + " pour ceux d'imprégnation de Licence I;", new Font(Font.TIMES_ROMAN, 12)));
                list1.add(new ListItem(dateEnlettre(dateDebut24, dateFin24) + " pour ceux d'agent de maîtrise Licence II et Master I.", new Font(Font.TIMES_ROMAN, 12)));
                //list1.add(new ListItem);
                document.add(list1);
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[3], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[4], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                paragraph1 = new Paragraph();
                paragraph1.add(new Chunk("P.j", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD)));
                paragraph1.add(new Chunk(extractsFromDavidCopperfield[5], FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ITALIC)));
                document.add(new Paragraph(paragraph1));
                document.add(new Paragraph(" "));
                paragraph = new Paragraph(extractsFromDavidCopperfield[6], new Font(Font.TIMES_ROMAN, 12, Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                document.add(paragraph);
                document.newPage();
            }
        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        document.close();
        String fileName = "llettreDemandeStage";
        writePDFToResponse(context.getExternalContext(), baos, fileName);
        context.responseComplete();
    }

    public void lettreRemerciement() throws IOException, DocumentException {
        System.out.println("la valeur de la date est " + dateDebut1);
        FacesContext context = FacesContext.getCurrentInstance();
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);


        if (!document.isOpen()) {
            document.open();
        }
        try {
            if (!entrepriseSelected.getNomEntreprise().isEmpty() && entrepriseSelected.getNomEntreprise() != null) {
                Entreprise en = entrepriseSelected;
                String nomville = en.getNomVille().toUpperCase();
                String nomEnt = en.getNomEntreprise().toUpperCase();

                String genre_res = en.getGenre() + " " + en.getReponsable();
                // ajout de l'image d'entete
                String path = context.getExternalContext().getRealPath("/images/sygeses.PNG");
                Image image = Image.getInstance(path);
                image.scaleAbsolute(520f, 160f);
                image.setAbsolutePosition(15f, 680f);
                document.add(image);

                // add a news paragraph 
                String extractsFromDavidCopperfield[] = {
                    //* 1 
                    "       Faisant suite à votre accord d'encadrement des stages académiques de nos étudiants, nous"
                    + "  vous remercions de votre effort de nous accompagner dans la formation de nos jeunes et nous vous"
                    + " transmettons par la même occasion les noms des étudiants qui effectueront le stage pour l'année académique" + anneeAcad() + ".",
                    //* 2 
                    "       Les dites stages se dérouleront du : \n",
                    //* 3 
                    "       Nous restons à votre entiere disposition pour toutes informations concernant les modalités"
                    + " de déroulement du stage et comptons au renforcement de la collaboration entre nos deux structures.",
                    //* 4 
                    "     La liste  des étudiants est jointe en annexe.",
                    //* 5 
                    "       Veuillez agréer, " + genre_res + ", l'expression de ma parfaite consideration.",
                    //* 6 
                    " Le Directeur"
                };
                for (int j = 0; j < 8; j++) {
                    document.add(new Paragraph(" "));
                }

                Paragraph paragraph = new Paragraph("A \n" + genre_res + "  \n" + nomEnt, new Font(Font.TIMES_ROMAN, 12, Font.BOLD));
                paragraph.setIndentationLeft(290);
                document.add(paragraph);
                paragraph = new Paragraph(nomville, new Font(Font.TIMES_ROMAN, 12, Font.UNDERLINE));
                paragraph.setIndentationLeft(290);
                document.add(paragraph);
                Paragraph paragraph1 = new Paragraph();
                paragraph1.add(new Chunk("Object:", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD)));
                paragraph1.add(new Chunk(" Stage académique ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ITALIC)));
                document.add(new Paragraph(paragraph1));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("       " + genre_res + ",", new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(extractsFromDavidCopperfield[0], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[1], new Font(Font.TIMES_ROMAN)));
                com.lowagie.text.List list1 = new com.lowagie.text.List(com.lowagie.text.List.UNORDERED, 12);
                list1.add(new ListItem(dateEnlettre(dateDebut5, dateFin5) + " pour ceux de fin d'études Master II;", new Font(Font.TIMES_ROMAN, 12)));
                list1.add(new ListItem(dateEnlettre(dateDebut3, dateFin3) + " pour ceux de fin d'études Licence III;", new Font(Font.TIMES_ROMAN, 12)));
                list1.add(new ListItem(dateEnlettre(dateDebut1, dateFin1) + " pour ceux d'imprégnation de Licence I;", new Font(Font.TIMES_ROMAN, 12)));
                list1.add(new ListItem(dateEnlettre(dateDebut24, dateFin24) + " pour ceux d'agent de maîtrise Licence II et Master I.", new Font(Font.TIMES_ROMAN, 12)));
                //list1.add(new ListItem);
                document.add(list1);
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[2], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[3], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[4], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                paragraph = new Paragraph(extractsFromDavidCopperfield[5], new Font(Font.TIMES_ROMAN, 12, Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                document.add(paragraph);
                document.newPage();
            }
        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        document.close();
        String fileName = "lettreRemerciement";
        writePDFToResponse(context.getExternalContext(), baos, fileName);
        context.responseComplete();
    }

    private void writePDFToResponse(ExternalContext externalContext,
            ByteArrayOutputStream baos, String fileName) {
        try {
            externalContext.responseReset();
            externalContext.setResponseContentType("application/pdf");
            externalContext.setResponseHeader("Expires", "0");
            externalContext.setResponseHeader("Cache-Control", "must-revalidate,post - check = 0, pre - check = 0 ");
            externalContext.setResponseHeader("Pragma", "public");
            externalContext.setResponseHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");
            externalContext.setResponseContentLength(baos.size());
            OutputStream out = externalContext.getResponseOutputStream();
            baos.writeTo(out);
            externalContext.responseFlushBuffer();
        } catch (Exception e) {
//e.printStackTrace();
        }
    }

    public String jour(int jour) {
        if (jour < 10) {
            return "0" + jour;
        }
        return jour + "";
    }

    public String anneeAc(Date date1) {
        Calendar cal3 = Calendar.getInstance();
        cal3.setTime(date1);
        int annee = cal3.get(1) - 1;
        return annee + "-" + cal3.get(1);
    }

    public String mois(int numero) {
        String mois = new String();
        switch (numero) {
            case 0:
                mois = "janvier";
                break;
            case 1:
                mois = "févier";
                break;
            case 2:
                mois = "mars";
                break;
            case 3:
                mois = "avril";
                break;
            case 4:
                mois = "mais";
                break;
            case 5:
                mois = "juin";
                break;
            case 6:
                mois = "juillet";
                break;
            case 7:
                mois = "août";
                break;
            case 8:
                mois = "septembre";
                break;
            case 9:
                mois = "octobre";
                break;
            case 10:
                mois = "novembre";
                break;
            case 11:
                mois = "decembre";
                break;
        }
        return mois;
    }

    public String dateEnlettre(Date date1, Date date2) {
        String date = "";
        Calendar cal2 = Calendar.getInstance();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        if (date1 != null && date2 != null) {
            if (cal1.get(2) != cal2.get(2)) {
                date = jour(cal1.get(5)) + " " + this.mois(cal1.get(2)) + " au " + jour(cal2.get(5)) + " " + this.mois(cal2.get(2)) + " " + cal2.get(1);
            } else {
                date = jour(cal1.get(5)) + " " + " au " + jour(cal2.get(5)) + " " + this.mois(cal2.get(2)) + " " + cal2.get(1);
            }
        }
        return date;
    }

    public String anneeAcad() {
        Date date = new Date();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        if (cal1.get(2) > 10) {
            int var = cal1.get(1) + 1;
            return "" + cal1.get(1) + " - " + var;
        } else {
            int var = cal1.get(1) - 1;
            return "" + var + " - " + cal1.get(1);
        }

    }
}
