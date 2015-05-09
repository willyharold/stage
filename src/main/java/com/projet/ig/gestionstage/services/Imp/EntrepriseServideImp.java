package com.projet.ig.gestionstage.services.Imp;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.Dao.IAgentSuiviDeDao;
import com.projet.ig.gestionstage.Dao.IEntrepriseDao;
import com.projet.ig.gestionstage.Dao.IDomaineActiviteDao;
import com.projet.ig.gestionstage.Dao.IEtudiantDao;
import com.projet.ig.gestionstage.Dao.IStageDao;
import com.projet.ig.gestionstage.entity.DomaineActivite;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.Stage;
import com.projet.ig.gestionstage.services.IEntrepriseService;
import java.util.Calendar;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pouemo
 */
@Transactional
public class EntrepriseServideImp implements IEntrepriseService {

    private IEntrepriseDao entreprisedao;
    private IAgentSuiviDeDao agentdSuiviDao;
    private IDomaineActiviteDao domaineDao;
    private IEtudiantDao etudiantdao;
    private IStageDao stagedao;


    public List<Entreprise> findByType(String type) throws DataAccessException {
        return entreprisedao.findByType(type);
    }

    public List<Entreprise> findByReponse(String reponse) throws DataAccessException {
        return entreprisedao.findByReponse(reponse);
    }

    public IEntrepriseDao getEntreprisedao() {
        return entreprisedao;
    }

    public void setEntreprisedao(IEntrepriseDao entreprisedao) {
        this.entreprisedao = entreprisedao;
    }

    public IDomaineActiviteDao getDomaineDao() {
        return domaineDao;
    }

    public void setDomaineDao(IDomaineActiviteDao domaineDao) {
        this.domaineDao = domaineDao;
    }

    public void enregistrer(Entreprise e) throws DataAccessException {
        Calendar cal = Calendar.getInstance();
        e.setDateEnregistremet(cal.getTime());
        entreprisedao.create(e);
    }

    public IAgentSuiviDeDao getAgentdSuiviDao() {
        return agentdSuiviDao;
    }

    public void setAgentdSuiviDao(IAgentSuiviDeDao agentdSuiviDao) {
        this.agentdSuiviDao = agentdSuiviDao;
    }

    public void modifier(Entreprise e) throws DataAccessException {
        entreprisedao.update(e);
    }

    public Entreprise findById(Long id) throws DataAccessException {
        return entreprisedao.findById(id);
    }

    public IEtudiantDao getEtudiantdao() {
        return etudiantdao;
    }

    public void setEtudiantdao(IEtudiantDao etudiantdao) {
        this.etudiantdao = etudiantdao;
    }

    public IStageDao getiStageDao() {
        return stagedao;
    }

    public void setiStageDao(IStageDao iStageDao) {
        this.stagedao = iStageDao;
    }

    public IStageDao getStagedao() {
        return stagedao;
    }

    public void setStagedao(IStageDao stagedao) {
        this.stagedao = stagedao;
    }
    

    public Entreprise addDomainToEnterprise(Long enterpriseId, Long domaineId) throws DataAccessException {
        Entreprise ent = entreprisedao.findById(enterpriseId);
        DomaineActivite dom = domaineDao.findById(domaineId);
        if ((ent != null) && (dom != null)) {
            ent.getDomaines().add(dom);
            return entreprisedao.update(ent);
        }
        return null;
    }

    public List<Stage> listeStage(Entreprise e) throws DataAccessException {
        return entreprisedao.listeStage(e);
    }


    public List<DomaineActivite> listeDomaine(Entreprise entreprise) throws DataAccessException {

        Entreprise etp = entreprisedao.findById(entreprise.getId());
        int i = etp.getDomaines().size();
        return etp.getDomaines();
    }

    public void historique(Entreprise entreprise) throws DataAccessException {
        
        int i =20;
        i++;
    }

    public List<Etudiant> listeEtudiant(Entreprise e) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Entreprise> afficherTous() throws DataAccessException {
        return entreprisedao.findAll();
    }

    public List<String> listeNom() throws DataAccessException {
        return entreprisedao.listeNom();
    }

    public List<String> findByVille(String ville) throws DataAccessException {
        return entreprisedao.findByVille(ville);
    }

    public List<String> listeEntrepriseVille() throws DataAccessException {
        return entreprisedao.listeEntrepriseVille();
    }

    public List<String> listeEntrepriseVille(String nom) throws DataAccessException {
        return entreprisedao.listeEntrepriseVille(nom);
    }

    public Entreprise findByNomVille(String nom, String ville) throws DataAccessException {
        return entreprisedao.findByNomVille(nom, ville);
    }

   
}
