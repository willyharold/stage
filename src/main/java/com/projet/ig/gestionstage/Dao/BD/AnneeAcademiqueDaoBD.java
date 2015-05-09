/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao.BD;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.projet.ig.gestionstage.Dao.IAnneeAcademiqueDao;
import com.projet.ig.gestionstage.entity.AnneeAcademique;
import java.util.List;

/**
 *
 * @author pouemo
 */
public class AnneeAcademiqueDaoBD extends GenericDao<AnneeAcademique, Long> implements IAnneeAcademiqueDao{

    public List<String> listAnneeAcademic() throws DataAccessException {
        return getManager().createQuery("select a.anneeAcademique from AnneeAcademique a ").getResultList();   

    }

    public AnneeAcademique rechercherparAnnee(String annee) throws DataAccessException {
        return (AnneeAcademique) getManager().createQuery("select a from AnneeAcademique a where a.anneeAcademique = :statut").setParameter("statut", annee).getSingleResult();   
    }
    
}
