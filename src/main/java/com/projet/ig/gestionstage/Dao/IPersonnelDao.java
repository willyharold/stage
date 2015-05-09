/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.entity.Personel;

/**
 *
 * @author pouemo
 */
public interface IPersonnelDao extends IDao<Personel, Long>{
    
    public Entreprise findByPersonelId(Long Id) throws DataAccessException;
}
