package com.projet.ig.gestionstage.services.Imp;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.Dao.IEtudiantDao;
import com.projet.ig.gestionstage.Dao.IStageDao;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.entity.Niveau;
import com.projet.ig.gestionstage.entity.Parcours;
import com.projet.ig.gestionstage.entity.Prospecteur;
import com.projet.ig.gestionstage.entity.Reponse;
import com.projet.ig.gestionstage.entity.Stage;
import com.projet.ig.gestionstage.services.IStageService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pouemo
 */
@Transactional
public class StageServiceImp implements IStageService {

    private IStageDao stagedao;
    private IEtudiantDao etudiantdao;

    public List<Stage> findByprospecteur(Prospecteur prosprecteur) throws DataAccessException {
        return stagedao.findByprospecteur(prosprecteur);
    }

    public List<Stage> findByParcours(String parcours) throws DataAccessException {
        return stagedao.findByParcours(parcours);
    }

    public List<Stage> findByParcoursNiveau(String Parcours, Niveau niveau) throws DataAccessException {
        return stagedao.findByParcoursNiveau(Parcours, niveau);
    }

    public List<Stage> findByEntreprise(Entreprise entreprise) throws DataAccessException {
        return stagedao.findByEntreprise(entreprise);
    }

    public IStageDao getStagedao() {
        return stagedao;
    }

    public void setStagedao(IStageDao stagedao) {
        this.stagedao = stagedao;
    }

    public List<Stage> findByAll() throws DataAccessException {
        return stagedao.findAll();
    }

    public void enregistrer(Stage stage) throws DataAccessException {
        String annee;
        Date date = new Date();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        if (cal1.get(2) > 10) {
            int var = cal1.get(1) + 1;
            annee = "" + cal1.get(1) + " - " + var;
        } else {
            int var = cal1.get(1) - 1;
            annee = "" + var + " - " + cal1.get(1);
        }
        stage.setAnneeAcademique(annee);
        stagedao.create(stage);
    }

    public void modifier(Stage stage) throws DataAccessException {
        Stage stg = stagedao.findById(stage.getId());
        stg.setCategorie(stage.getCategorie());
        stg.setDebut(stage.getDebut());
        stg.setFin(stage.getDebut());
        stg.setEntreprise(stage.getEntreprise());
        stg.setStatus(stage.getStatus());
        
        stagedao.update(stg);
    }

    public Stage findById(long id) throws DataAccessException {
        return stagedao.findById(id);
    }

    public void supprimer(Stage stage) throws DataAccessException {
        Stage stg = stagedao.findById(stage.getId());
        stagedao.delete(stg);
    }

    public IEtudiantDao getEtudiantdao() {
        return etudiantdao;
    }

    public void setEtudiantdao(IEtudiantDao etudiantdao) {
        this.etudiantdao = etudiantdao;
    }

    public List<Stage> findByprospecteurYear(Prospecteur prosprecteur, String annee) throws DataAccessException {
        return stagedao.findByprospecteur(prosprecteur, annee);
    }

    public List<Long> stageEntrepriseAnnee(Entreprise entreprise, Niveau niveau, String annee, Parcours parcours) throws DataAccessException {
        return stagedao.findByEntrepriseNiveauYear(entreprise, niveau, annee, parcours);
    }

    public void modifierStatut(Stage stage, Reponse reponse) throws DataAccessException {
        Stage stg = stagedao.findById(stage.getId()); 
        stg.setStatus(reponse);
        
        stagedao.update(stg);
    }
}
