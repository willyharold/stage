/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services.Imp;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.Dao.IAnneeAcademiqueDao;
import com.projet.ig.gestionstage.Dao.IEtudiantDao;
import com.projet.ig.gestionstage.Dao.IEtudiantStageDao;
import com.projet.ig.gestionstage.Dao.IStageDao;
import com.projet.ig.gestionstage.entity.AnneeAcademique;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.EtudiantStage;
import com.projet.ig.gestionstage.entity.Reponse;
import com.projet.ig.gestionstage.entity.Stage;
import com.projet.ig.gestionstage.services.IEtudiantStageService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pouemo
 */
@Transactional
public class EtudiantStageServiceImpl implements IEtudiantStageService {

    private IEtudiantStageDao etudiantStagedao;
    private IEtudiantDao etudiantdao;
    private IAnneeAcademiqueDao anneedao;
    private IStageDao stagedao;

    public IEtudiantStageDao getEtudiantStagedao() {
        return etudiantStagedao;
    }

    public void setEtudiantStagedao(IEtudiantStageDao etudiantStagedao) {
        this.etudiantStagedao = etudiantStagedao;
    }

    public IEtudiantDao getEtudiantdao() {
        return etudiantdao;
    }

    public void setEtudiantdao(IEtudiantDao etudiantdao) {
        this.etudiantdao = etudiantdao;
    }

    public IAnneeAcademiqueDao getAnneedao() {
        return anneedao;
    }

    public void setAnneedao(IAnneeAcademiqueDao anneedao) {
        this.anneedao = anneedao;
    }

    public IStageDao getStagedao() {
        return stagedao;
    }

    public void setStagedao(IStageDao stagedao) {
        this.stagedao = stagedao;
    }

    public List<Stage> listStages(String matricule) throws DataAccessException {
        return etudiantStagedao.listStages(matricule);
    }

    public void enregistrer(EtudiantStage etuStage) throws DataAccessException {

      
        Etudiant etd = etudiantdao.findByMatricule(etuStage.getMatricule());

        etuStage.setMatricule(etd.getMatricule());
        etuStage.setEtudiant(etd);
        etuStage.setStage(etuStage.getStage());
        etuStage.setAnneeAcademique(etuStage.getStage().getAnneeAcademique()); 

        etudiantStagedao.create(etuStage);
        
        Stage stg = stagedao.findById(etuStage.getStage().getId());
        stg.setStatus(Reponse.OUI);
        stagedao.update(stg);

    }

    public List<Etudiant> listeSansNoteStage(String parcours, AnneeAcademique annee) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Etudiant> listeCahierNonRemis(String parcours, AnneeAcademique annee) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<EtudiantStage> listeStagiaire(String parcours, AnneeAcademique annee) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void noter(String matricule, float note) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<EtudiantStage> listeStagiaire() throws DataAccessException {
        return etudiantStagedao.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
}
