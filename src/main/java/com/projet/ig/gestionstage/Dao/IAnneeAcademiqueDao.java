/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.projet.ig.gestionstage.entity.AnneeAcademique;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IAnneeAcademiqueDao extends IDao<AnneeAcademique, Long>{
    
    public List<String> listAnneeAcademic() throws DataAccessException;
    
     public AnneeAcademique rechercherparAnnee(String annee) throws DataAccessException;
}
