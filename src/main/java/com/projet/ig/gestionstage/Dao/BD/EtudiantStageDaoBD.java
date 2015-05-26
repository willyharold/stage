/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao.BD;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.projet.ig.gestionstage.Dao.IEtudiantStageDao;
import com.projet.ig.gestionstage.entity.AnneeAcademique;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.EtudiantStage;
import com.projet.ig.gestionstage.entity.Stage;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author pouemo
 */
public class EtudiantStageDaoBD extends GenericDao<EtudiantStage, Long> implements IEtudiantStageDao {

    public List<Stage> listStages(String matricule) throws DataAccessException {
        List<Stage> lisstage = new LinkedList<Stage>();
        List<EtudiantStage> listEtuStage = new LinkedList<EtudiantStage>();
       // System.out.println("je suis a la dao");
        listEtuStage = getManager().createNamedQuery("etudiantstage.findstage").setParameter("param", matricule).getResultList();
        for (EtudiantStage etudiantStage : listEtuStage) {
            lisstage.add(etudiantStage.getStage()); 
            
        }
        return lisstage;
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
}
