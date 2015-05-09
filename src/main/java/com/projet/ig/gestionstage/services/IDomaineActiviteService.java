/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.DomaineActivite;
import java.util.List;

/**
 *
 * @author pouemo
 */
public interface IDomaineActiviteService {

    public void enregistrer(DomaineActivite da) throws DataAccessException;

    public DomaineActivite findById(Long id) throws DataAccessException;

    public void modifier(DomaineActivite da) throws DataAccessException;
    
    public List<String> listerDomaine() throws DataAccessException;
    
    public DomaineActivite findbyDomaineName(String nom);
}
