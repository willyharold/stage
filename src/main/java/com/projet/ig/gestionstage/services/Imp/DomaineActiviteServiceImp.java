/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services.Imp;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.Dao.IDomaineActiviteDao;
import com.projet.ig.gestionstage.entity.DomaineActivite;
import com.projet.ig.gestionstage.services.IDomaineActiviteService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pouemo
 */
@Transactional
public class DomaineActiviteServiceImp implements IDomaineActiviteService{
     private IDomaineActiviteDao domainedao;
     
     public void enregistrer(DomaineActivite da) throws DataAccessException{
         domainedao.create(da);
     }

    public IDomaineActiviteDao getDomainedao() {
        return domainedao;
    }

    public void setDomainedao(IDomaineActiviteDao domainedao) {
        this.domainedao = domainedao;
    }
    
    public List<String> listerDomaine() throws DataAccessException{
    
        return domainedao.listerDomaine();
    }

    public DomaineActivite findById(Long id) throws DataAccessException {
       return domainedao.findById(id);
    }

    public void modifier(DomaineActivite da) throws DataAccessException {
        domainedao.update(da); 
    }

    public DomaineActivite findbyDomaineName(String nom) {
         try {
             return domainedao.findbyDomaineName(nom);
         } catch (DataAccessException ex) {
             Logger.getLogger(DomaineActiviteServiceImp.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
     
}
