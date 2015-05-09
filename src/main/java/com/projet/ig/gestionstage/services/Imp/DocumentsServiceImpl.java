/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.services.Imp;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.Dao.IDocumentsDao;
import com.projet.ig.gestionstage.entity.Documents;
import com.projet.ig.gestionstage.services.IAgentDocumentService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DocumentsServiceImpl implements IAgentDocumentService{
    private IDocumentsDao documentsDao;

    public IDocumentsDao getDocumentsDao() {
        return documentsDao;
    }

    public void setDocumentsDao(IDocumentsDao documentsDao) {
        this.documentsDao = documentsDao;
    }

    public void enregistrer(Documents document) throws DataAccessException {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        document.setDateOpeartion(date); 
        documentsDao.create(document);
    }

    public void supprimer(Documents document) throws DataAccessException {
        documentsDao.delete(document);
    }

    public void modifier(Documents document) throws DataAccessException {
        documentsDao.update(document);
    }

    public List<Documents> listerTous() throws DataAccessException {
        return documentsDao.findAll();
    }

    public Documents rechercher(long id) throws DataAccessException {
        return documentsDao.findById(id);
    }
    
}
