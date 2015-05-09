/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao.BD;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.projet.ig.gestionstage.Dao.IEtudiantDao;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.Niveau;
import com.projet.ig.gestionstage.entity.Parcours;
import java.util.List;

/**
 *
 * @author pouemo
 */
public class EtudiantDaoBD extends GenericDao<Etudiant, Long> implements IEtudiantDao{

    public List<Etudiant> findByParcours(Parcours parcours) throws DataAccessException {
        return getManager().createQuery("select e from Etudiant e where e.parcours = :statut").setParameter("statut", parcours).getResultList();   
    }

    public List<Etudiant> findByParcoursNiveau(Parcours parcours, Niveau niveau) throws DataAccessException {
        return getManager().createQuery("select e from Etudiant e where e.parcours = :statut and e.niveau = :statut2").setParameter("statut", parcours).setParameter("statut2", niveau).getResultList();   
    }

    public Etudiant findByMatricule(String matricule) throws DataAccessException {
        return (Etudiant) getManager().createQuery("select e from Etudiant e where e.matricule = :statut").setParameter("statut", matricule).getSingleResult();   
    }

    public List<Etudiant> findByOption(String option) throws DataAccessException {
        return getManager().createQuery("select e from Etudiant e where e.specialite = :statut").setParameter("statut", option).getResultList();   
    }  

    public List<Etudiant> listeSansNote() throws DataAccessException {
        return getManager().createQuery("select e from Etudiant e where e.note = :statut").setParameter("statut", 0).getResultList();   
    }

    public List<String> listeMatricule() throws DataAccessException {
        return getManager().createQuery("select e.matricule from Etudiant e ").getResultList();   
    }
  
}
