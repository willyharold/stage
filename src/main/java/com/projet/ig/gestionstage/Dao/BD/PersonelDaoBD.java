/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao.BD;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.projet.ig.gestionstage.Dao.IPersonnelDao;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.entity.Personel;

/**
 *
 * @author pouemo
 */
public class PersonelDaoBD extends GenericDao<Personel, Long> implements IPersonnelDao{

    public Entreprise findByPersonelId(Long Id) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
