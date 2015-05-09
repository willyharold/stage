/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.projet.ig.gestionstage.entity.AnneeAcademique;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.EtudiantStage;
import com.projet.ig.gestionstage.entity.Stage;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IEtudiantStageDao extends IDao<EtudiantStage, Long>{
    
    public List<Stage> listStages(String matricule) throws DataAccessException;
    
    public List<Etudiant> listeSansNoteStage(String parcours, AnneeAcademique annee) throws DataAccessException;
    
    public List<Etudiant> listeCahierNonRemis(String parcours, AnneeAcademique annee) throws DataAccessException;
    
    public List<EtudiantStage> listeStagiaire(String parcours, AnneeAcademique annee) throws DataAccessException;
    
}
