/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.projet.ig.gestionstage.entity.DomaineActivite;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IDomaineActiviteDao extends IDao<DomaineActivite, Long>{
    
    public List<String> listerDomaine() throws DataAccessException;
    
    public DomaineActivite findbyDomaineName(String nom) throws DataAccessException;
}
