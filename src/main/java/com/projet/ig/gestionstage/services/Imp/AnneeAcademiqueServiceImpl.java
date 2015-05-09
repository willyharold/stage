/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services.Imp;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.Dao.IAnneeAcademiqueDao;
import com.projet.ig.gestionstage.entity.AnneeAcademique;
import com.projet.ig.gestionstage.services.IAnneeAcademiqueService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pouemo
 */
@Transactional
public class AnneeAcademiqueServiceImpl implements IAnneeAcademiqueService{

    private IAnneeAcademiqueDao anneeDao;

    public IAnneeAcademiqueDao getAnneeDao() {
        return anneeDao;
    }

    public void setAnneeDao(IAnneeAcademiqueDao anneeDao) {
        this.anneeDao = anneeDao;
    }
    
    
    public void enregistrer(AnneeAcademique anneeAcademique) throws DataAccessException {
       anneeDao.create(anneeAcademique);
    }

    public void modifier(AnneeAcademique anneeAc) throws DataAccessException {
        anneeDao.update(anneeAc);
    }

    public AnneeAcademique rechercher(long id) throws DataAccessException {
        return anneeDao.findById(id);
    }

    public List<AnneeAcademique> rechercherTous() throws DataAccessException {
       return anneeDao.findAll();
    }

    public AnneeAcademique rechercherparAnnee(String annee) throws DataAccessException {
        return anneeDao.rechercherparAnnee(annee);
    }

    public List<String> listAnneeAcademic() throws DataAccessException {
        return anneeDao.listAnneeAcademic();
    }
    
}
