/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao.BD;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.projet.ig.gestionstage.Dao.IEntrepriseDao;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.entity.Stage;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author pouemo
 */
public class EntrepriseDaoBD extends GenericDao<Entreprise, Long> implements IEntrepriseDao {

    public List<String> findByVille(String ville) throws DataAccessException {
        try {
            return getManager().createQuery("select DISTINCT e.nomEntreprise from Entreprise e where e.nomVille = :statut").setParameter("statut", ville).getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }

    public List<Entreprise> findByType(String type) throws DataAccessException {
        try {
            return getManager().createQuery("select DISTINCT e from Entreprise e where e.type = :statut").setParameter("statut", type).getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }

    public List<Entreprise> findByReponse(String reponse) throws DataAccessException {
        try {
            return getManager().createQuery("select DISTINCT e from Entreprise e where e.reponse = :statut").setParameter("statut", reponse).getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }

    public List<Stage> listeStage(Entreprise e) throws DataAccessException {
        try {
            return getManager().createQuery("select DISTINCT s from Stage s where s.entreprise.id = :statut").setParameter("statut", e.getId()).getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }

    public List<String> listeNom() throws DataAccessException {
        try {
            return getManager().createQuery("select DISTINCT e.nomEntreprise from Entreprise e ").getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }

    public List<String> listeEntrepriseVille() throws DataAccessException {
        try {
            return getManager().createQuery("select DISTINCT e.nomVille from Entreprise e ").getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }

    public List<String> listeEntrepriseVille(String nom) throws DataAccessException {
        try {
            return getManager().createQuery("select DISTINCT e.nomVille from Entreprise e where e.nomEntreprise = :statut").setParameter("statut", nom).getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }

    public Entreprise findByNomVille(String nom, String ville) throws DataAccessException {
        try {
            return (Entreprise) getManager().createQuery("select DISTINCT e from Entreprise e where e.nomVille = :ville and e.nomEntreprise = :nom").setParameter("ville", ville).setParameter("nom", nom).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
