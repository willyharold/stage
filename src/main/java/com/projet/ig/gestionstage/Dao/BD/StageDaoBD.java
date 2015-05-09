/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao.BD;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.projet.ig.gestionstage.Dao.IStageDao;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.entity.Etudiant;
import com.projet.ig.gestionstage.entity.Niveau;
import com.projet.ig.gestionstage.entity.Parcours;
import com.projet.ig.gestionstage.entity.Prospecteur;
import com.projet.ig.gestionstage.entity.Reponse;
import com.projet.ig.gestionstage.entity.Stage;
import com.projet.ig.gestionstage.entity.Type;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author pouemo
 */
public class StageDaoBD extends GenericDao<Stage, Long> implements IStageDao {

    public List<Stage> findByprospecteur(Prospecteur prospecteur) throws DataAccessException {
        try {
            return getManager().createQuery("select DISTINCT s from Stage s where s.prospecteur = :statut").setParameter("statut", prospecteur).getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }

    public List<Stage> findByParcours(String parcours) throws DataAccessException {
        try {
            return getManager().createQuery("select DISTINCT s from Stage s where s.parcours = :statut").setParameter("statut", parcours).getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }

    public List<Stage> findByParcoursNiveau(String parcours, Niveau niveau) throws DataAccessException {
        try {
            return getManager().createQuery("select DISTINCT s from Stage s where s.niveau = :niveau1 and s.parcours = :parcours1").setParameter("niveau1", niveau).setParameter("parcours1", parcours).getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }

    public List<Stage> findByEntreprise(Entreprise entreprise) throws DataAccessException {
        try {
            return getManager().createQuery("select DISTINCT s from Stage s where s.entreprise.nomEntreprise = :statut").setParameter("statut", entreprise.getNomEntreprise()).getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }

    public Etudiant findEtudiantByStage(Stage s) throws DataAccessException {
        try {
            return (Etudiant) getManager().createQuery("SELECT DISTINCT e FROM Etudiant e JOIN Etudiant_Stage e_s  where e.id = e_s.etudiants_id AND e_s.stages_id= :id").setParameter("id", s.getId()).getSingleResult();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }

    public List<Stage> findByprospecteur(Prospecteur prospecteur, String annee) throws DataAccessException {
        try {
            return getManager().createQuery("select DISTINCT s from Stage s where s.prospecteur = :statut and s.anneeAcademic.anneeAcademique = :an").setParameter("statut", prospecteur).setParameter("an", annee).getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }

    public List<Long> findByEntrepriseNiveauYear(Entreprise entreprise, Niveau niveau, String annee, Parcours parcours) throws DataAccessException {
        try {
            Type type = Type.Ouvrier;
            if (niveau.equals(Niveau.Licence1)) {
                type = Type.Ouvrier;
            } else if (niveau.equals(Niveau.Licence2)) {
                type = Type.AgentdeMaitrise1;
            } else if (niveau.equals(Niveau.Licence3)) {
                type = Type.FindEtude1;
            } else if (niveau.equals(Niveau.Master1)) {
                type = Type.AgentdeMaitrise2;
            } else if (niveau.equals(Niveau.Master2)) {
                type = Type.FinDetude2;
            }

            return getManager().createQuery("select DISTINCT s.id from Stage s where s.entreprise.nomEntreprise = :statut and s.entreprise.nomVille = :statut2 and s.categorie = :statut3 and s.anneeAcademic.anneeAcademique = :statut4 and s.status = :statut5 and s.parcours = :statut6").setParameter("statut", entreprise.getNomEntreprise()).setParameter("statut2", entreprise.getNomVille()).setParameter("statut3", type).setParameter("statut4", annee).setParameter("statut5", Reponse.NON).setParameter("statut6", parcours).getResultList();
        } catch (NoResultException ex) {
            ex.getMessage();
            return null;

        }
    }
}
