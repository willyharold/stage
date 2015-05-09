/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Beans;

import com.douwe.generic.dao.DataAccessException;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.EtudiantStage;
import com.projet.ig.gestionstage.entity.Niveau;
import com.projet.ig.gestionstage.entity.Parcours;
import com.projet.ig.gestionstage.services.IEtudiantStageService;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class EtudiantStageBean {

    @ManagedProperty(value = "#{IEtudiantStageService}")
    private IEtudiantStageService etudiantStageService;
    private EtudiantStage etudiantStage;
    private List<EtudiantStage> etudiantStages;
    private EtudiantStage etudiantStageSelected;

    public EtudiantStageBean() {
    }

    // Genetation des getters et setters
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
        etudiantStages = new LinkedList<EtudiantStage>();
        try {
            etudiantStages = etudiantStageService.listeStagiaire();
        } catch (DataAccessException ex) {
            Logger.getLogger(EtudiantStageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return etudiantStages;
    }

    public void setEtudiantStages(List<EtudiantStage> etudiantStages) {
        this.etudiantStages = etudiantStages;
    }

    public EtudiantStage getEtudiantStageSelected() {
        return etudiantStageSelected;
    }

    public void setEtudiantStageSelected(EtudiantStage etudiantStageSelected) {
        this.etudiantStageSelected = etudiantStageSelected;
    }

//implementations des methodes
    public EtudiantStage getRowData(String rowKey) {
        List<EtudiantStage> etudiants1 = getEtudiantStages();
        for (EtudiantStage entre : etudiants1) {
            if (entre.getId().equals(rowKey)) {
                return entre;
            }
        }
        return null;

    }

    public Object getRowKey(EtudiantStage est) {
        return est.getId();
    }

    // implementations des merthodes specifiques
    public void lettreMiseEnstageAll() {
        try { //catch better your exceptions, this is just an example
            FacesContext context = FacesContext.getCurrentInstance();
            Document document = new Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            if (!document.isOpen()) {
                document.open();
            }
            // generation des lettres de mise en stages

            List<EtudiantStage> tousEN = new LinkedList<EtudiantStage>();
            tousEN = etudiantStageService.listeStagiaire();
            for (EtudiantStage en : tousEN) {
                String nom = en.getEtudiant().getNom().toUpperCase();
                String prenom = en.getEtudiant().getPremon().toUpperCase();
                String mat = en.getEtudiant().getMatricule().toUpperCase();
                Parcours parcours = en.getEtudiant().getParcours();
                String entreprise = en.getStage().getEntreprise().getNomEntreprise().toUpperCase();
                String ville = en.getStage().getEntreprise().getNomVille().toUpperCase();
                Niveau niveau = en.getEtudiant().getNiveau();
                Date debut = en.getStage().getDebut();
                Date fin = en.getStage().getFin();
                /* ajout de l'image d'entete*/
                String path = context.getExternalContext().getRealPath("/images/sygeses.PNG");
                Image image = Image.getInstance(path);
                image.scaleAbsolute(520f, 160f);
                image.setAbsolutePosition(15f, 680f);
                document.add(image);

                Phrase ch = new Phrase(nom + " " + prenom, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD));

                /* add a news paragraph */
                String extractsFromDavidCopperfield[] = {
                    /* 1 */
                    "           Je, soussigné Directeur de l'Institut Superieur de Sahel de l'Université de Maroua "
                    + " atteste que,",
                    /* 2 */
                    "           Monsieur/Madame/Mademoiselle  " + nom + " " + prenom + "  inscrit(e) en " + niveau + " du parcours " + nomsprours(parcours) + " sous le numéro "
                    + " matricule " + mat + "  est autorisé(e) à suivre un stage de la periode du " + entreprise + " - " + ville,
                    /* 3 */
                    "           Ce stage d'agent de maîtrise permet d'adapter les apprentissage pédagogiques aquise"
                    + " l'Institut a celles d'un milieu concret d'ingenierie et d'apprendre a identifier et a utiliser."
                    + " efficacement les methodes scientifiques a la resolution des problemes de terrain.",
                    /* 4 */
                    "           Nous le recommandons aupres du responsable de la structure pour son acceuil et son"
                    + " encadrement. Le cahier de stage et le bareme de notation ci-joint devont etre signés par"
                    + " l'encadreur au sein de la structure et remis a l'étudiant en vue de la transmission a l'ISS. Le"
                    + " bareme de notation devra etre sous pli fermé.",
                    /* 5 */
                    " Le Directeur"
                };
                document.add(new Paragraph(" "));
                Paragraph paragraph = new Paragraph("ATTESTATION DE MISE EN STAGE ", new Font(Font.TIMES_ROMAN, 14, Font.BOLDITALIC));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                document.add(paragraph);
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[0], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[1], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[2], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[3], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                paragraph = new Paragraph(extractsFromDavidCopperfield[4], new Font(Font.TIMES_ROMAN, 12, Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                document.add(paragraph);
                document.newPage();
                System.out.println("la valeur est des tests est" + nom);
            }
            document.close();
            String fileName = "lettremiseEnStages";
            writePDFToResponse(context.getExternalContext(), baos, fileName);
            context.responseComplete();

        } catch (Exception e) {
        }
    }

     public void lettreMiseEnstage(){
        try { //catch better your exceptions, this is just an example
            FacesContext context = FacesContext.getCurrentInstance();
            Document document = new Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            if (!document.isOpen()) {
                document.open();
            }
            
            /* ajout de l'image d'entete*/
                String path = context.getExternalContext().getRealPath("/images/sygeses.PNG");
                Image image = Image.getInstance(path);
                image.scaleAbsolute(520f, 160f);
                document.add(image);
            // generation de la lettre de stage d'un etudiant
            
            if(!etudiantStageSelected.getMatricule().isEmpty() && etudiantStageSelected.getMatricule() != null){
                EtudiantStage en = etudiantStageSelected; 
                String nom = en.getEtudiant().getNom().toUpperCase();
                String prenom = en.getEtudiant().getPremon().toUpperCase();
                String mat = en.getEtudiant().getMatricule().toUpperCase();
                Parcours parcours = en.getEtudiant().getParcours();
                String entreprise = en.getStage().getEntreprise().getNomEntreprise().toUpperCase();
                String ville = en.getStage().getEntreprise().getNomVille().toUpperCase();
                Niveau niveau = en.getEtudiant().getNiveau();
                Date debut = en.getStage().getDebut();
                Date fin = en.getStage().getFin();

                Phrase ch = new Phrase(nom + " " + prenom, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD));

                /* add a news paragraph */
                String extractsFromDavidCopperfield[] = {
                    /* 1 */
                    "           Je, soussigné Directeur de l'Institut Superieur de Sahel de l'Université de Maroua "
                    + " atteste que,",
                    /* 2 */
                    "           Monsieur/Madame/Mademoiselle  " + nom + " " + prenom + "  inscrit(e) en " + niveau + " du parcours " + nomsprours(parcours) + " sous le numéro "
                    + " matricule " + mat + "  est autorisé(e) à suivre un stage de la periode du " + entreprise + " - " + ville,
                    /* 3 */
                    "           Ce stage d'agent de maîtrise permet d'adapter les apprentissage pédagogiques aquise"
                    + " l'Institut a celles d'un milieu concret d'ingenierie et d'apprendre a identifier et a utiliser."
                    + " efficacement les methodes scientifiques a la resolution des problemes de terrain.",
                    /* 4 */
                    "           Nous le recommandons aupres du responsable de la structure pour son acceuil et son"
                    + " encadrement. Le cahier de stage et le bareme de notation ci-joint devont etre signés par"
                    + " l'encadreur au sein de la structure et remis a l'étudiant en vue de la transmission a l'ISS. Le"
                    + " bareme de notation devra etre sous pli fermé.",
                    /* 5 */
                    " Le Directeur"
                };
                document.add(new Paragraph(" "));
                Paragraph paragraph = new Paragraph("ATTESTATION DE MISE EN STAGE ", new Font(Font.TIMES_ROMAN, 14, Font.BOLDITALIC));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                document.add(paragraph);
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[0], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[1], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[2], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(extractsFromDavidCopperfield[3], new Font(Font.TIMES_ROMAN)));
                document.add(new Paragraph(" "));
                paragraph = new Paragraph(extractsFromDavidCopperfield[4], new Font(Font.TIMES_ROMAN, 12, Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                document.add(paragraph);
                document.newPage();
                System.out.println("la valeur est des tests est" + nom);
            }
            document.close();
            String fileName = "lettremiseEnStage";
            writePDFToResponse(context.getExternalContext(), baos, fileName);
            context.responseComplete();

        } catch (Exception e) {
        }
    }
    
    private void writePDFToResponse(ExternalContext externalContext, ByteArrayOutputStream baos, String fileName) {
        try {
            externalContext.responseReset();
            externalContext.setResponseContentType("application/pdf");
            externalContext.setResponseHeader("Expires", "0");
            externalContext.setResponseHeader("Cache-Control", "must-revalidate,post - check = 0, pre - check = 0");
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

    public String nomsprours(Parcours nom) {

        if (Parcours.INFOTEL.equals(nom)) {

            return "Informatique et Télecommunications".toUpperCase();
        } else if (Parcours.SCIENV.equals(nom)) {

            return "Sciences Environnementales".toUpperCase();
        } else if (Parcours.TRAMARH.equals(nom)) {

            return "Traitement Des Matériaux, Architecture Et Habitat".toUpperCase();
        } else if (Parcours.AGEPD.equals(nom)) {

            return "Agriculture, élevage Et Produits Dérivés".toUpperCase();
        } else if (Parcours.ENREN.equals(nom)) {
            return "Energies Renouvelables".toUpperCase();
        } else if (Parcours.BEARSPA.equals(nom)) {
            return "Beaux arts et science du patrimoine".toUpperCase();
        } else if (Parcours.CLIHYPE.equals(nom)) {

            return "Climatologie, Hydrologie et Pédologie".toUpperCase();
        } else if (Parcours.HYMAE.equals(nom)) {

            return "Hydrolique et Maîtrise des eaux".toUpperCase();
        } else if (Parcours.GTC.equals(nom)) {

            return "Genie du textile et Cuir".toUpperCase();
        }

        return " null";
    }
}