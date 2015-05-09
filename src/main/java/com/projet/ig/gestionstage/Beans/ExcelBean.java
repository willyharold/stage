/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.ig.gestionstage.Beans;

import com.douwe.generic.dao.DataAccessException;
import com.projet.ig.gestionstage.entity.Entreprise;
import com.projet.ig.gestionstage.services.IEntrepriseService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author pouemo
 */
@ManagedBean
@RequestScoped
public class ExcelBean {

    @ManagedProperty(value = "#{IEntrepriseService}")
    private IEntrepriseService entrepriseService;
    private Entreprise entreprise = new Entreprise();
    
    public ExcelBean() {
        
    }

    public IEntrepriseService getEntrepriseService() {
        return entrepriseService;
    }

    public void setEntrepriseService(IEntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
    
    
//
    public  void test() throws DataAccessException {
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("/home/pouemo/Desktop/Reponses.xls"));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row = null;
            HSSFCell cell = null;
            String tel;
            
            for (int i = 2; i < 4; i++) {
                row = (HSSFRow) sheet.getRow(i);

                //HSSFCell cellA = row.getCell(0);
                //double num = cellA.getNumericCellValue();

                HSSFCell cellB = row.getCell(1);
                String structure = cellB.getStringCellValue();

                HSSFCell cellC = row.getCell(2);
                String sigle = cellC.getStringCellValue();

                HSSFCell cellD = row.getCell(3);
                String lieu = cellD.getStringCellValue();

                HSSFCell cellE = row.getCell(5);
                String genre = cellE.getStringCellValue();

                HSSFCell cellF = row.getCell(6);
                String respo = cellF.getStringCellValue();

                HSSFCell cellG = row.getCell(7);
                String bp = cellG.getStringCellValue();

                HSSFCell cellH = row.getCell(8);
                if(HSSFCell.CELL_TYPE_NUMERIC != cellH.getCellType()){
                    tel = cellH.getStringCellValue();
                } else {
                    tel = cellH.getNumericCellValue()+"";
                }

                HSSFCell cellI = row.getCell(9);
                String email = cellI.getStringCellValue();


                //System.out.println(" ++++++ +++++++++++++++++++++++ ");
                //System.out.println(" Structure * : " + structure + " * Sigle* : " + sigle + " * Lieu* : " + lieu +" * Genre* : " + genre + " * Responsable* : " + respo + " * Boit_P *: " + bp +" * Telephone* : " + tel + "* Email* : " + email);
                //System.out.println(" ++++++ +++++++++++++++++++++++ ");
                
                System.out.println(" la valeur de  ++++++++++++++++++++++++"+i);
                
                Entreprise en = new Entreprise();
                en.setNomEntreprise(structure);  en.setReponsable(respo);  
                en.setNomVille(lieu);  en.setE_mail(email);
                en.setGenre(genre);  en.setBoitePostale(bp); 
                en.setSigle(sigle); en.setNumeroTelephone(tel);
                
                entrepriseService.enregistrer(en);
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
