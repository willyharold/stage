/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author root
 */
@ManagedBean
public class FileUploadView {
    public void handleFileUpload() {
        FacesMessage message = new FacesMessage("Succesful is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        System.out.println("reussit");
    }
}
