/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao.BD;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.projet.ig.gestionstage.Dao.IDomaineActiviteDao;
import com.projet.ig.gestionstage.entity.DomaineActivite;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author pouemo
 */
public class DomaineActiviteDaoBD extends GenericDao<DomaineActivite, Long> implements IDomaineActiviteDao{

    public List<String> listerDomaine() throws DataAccessException{
        try {
            return getManager().createQuery("select DISTINCT d.nomDomaine from DomaineActivite d").getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;
        }
    }

    public DomaineActivite findbyDomaineName(String nom) throws DataAccessException {
        try {
            return (DomaineActivite) getManager().createQuery("select* DISTINCT  from DomaineActivite d where d.nomDomaine = :statut").setParameter("statut", nom).getSingleResult();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;
        }
    }

    }
