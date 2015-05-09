/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services.Imp;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.Dao.IEtudiantDao;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.Niveau;
import com.projet.ig.gestionstage.entity.Parcours;
import com.projet.ig.gestionstage.entity.Stage;
import com.projet.ig.gestionstage.services.IEtudiantService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pouemo
 */
@Transactional
public class EtudiantServiceImp implements IEtudiantService {

    private IEtudiantDao etudiantdao;

    public Etudiant findByMatricule(String matricule) throws DataAccessException {

        return etudiantdao.findByMatricule(matricule);
    }

    public void Enregistrer(Etudiant etudiant) throws DataAccessException {

        etudiantdao.create(etudiant);
    }

    public void Modifier(Etudiant etudiant) throws DataAccessException {
        etudiantdao.update(etudiant);
    }

    public List<Etudiant> listeSansNote() throws DataAccessException {
        return etudiantdao.listeSansNote();
    }

    public IEtudiantDao getEtudiantdao() {
        return etudiantdao;
    }

    public void setEtudiantdao(IEtudiantDao etudiantdao) {
        this.etudiantdao = etudiantdao;
    }

    public Etudiant findById(Long id) throws DataAccessException {
        return etudiantdao.findById(id);
    }

    public List<Etudiant> findByParcours(Parcours parcours) throws DataAccessException {
        return etudiantdao.findByParcours(parcours);
    }

    public List<Etudiant> findByParcoursNiveau(Parcours Parcours, Niveau niveau) throws DataAccessException {
        return etudiantdao.findByParcoursNiveau(Parcours, niveau);
    }

    public List<Etudiant> listeSansStagesParcours(String Parcours) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Etudiant> listeSansStagesParcoursNiveau(String Parcours, int niveau) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Void historiqueStage(Etudiant etudiant) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Noter(double note, Etudiant et) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Stage> listeStage(Etudiant etudiant) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Etudiant> rechercherTous() throws DataAccessException {
        return etudiantdao.findAll();
    }

    public List<String> listeDesMatricule() throws DataAccessException {
        return etudiantdao.listeMatricule();
    }

    public List<Etudiant> listeSansStagesParcours(Parcours Parcours) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Etudiant> listeSansStagesParcoursNiveau(Parcours Parcours, int niveau) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
