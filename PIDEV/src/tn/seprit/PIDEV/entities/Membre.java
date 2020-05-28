/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.seprit.PIDEV.entities;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Membre {
    private int id ;
    private Date DateJoin;
    private user idM ;
    private Groups idG ;

    public Membre(int id, Date DateJoin, user idM, Groups idG) {
        this.id = id;
        this.DateJoin = DateJoin;
        this.idM = idM;
        this.idG = idG;
    }

    public Membre() {
    }

    public Membre(Date DateJoin, user idM, Groups idG) {
        this.DateJoin = DateJoin;
        this.idM = idM;
        this.idG = idG;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateJoin() {
        return DateJoin;
    }

    public void setDateJoin(Date DateJoin) {
        this.DateJoin = DateJoin;
    }

    public user getIdM() {
        return idM;
    }

    public void setIdM(user idM) {
        this.idM = idM;
    }

    public Groups getIdG() {
        return idG;
    }

    public void setIdG(Groups idG) {
        this.idG = idG;
    }
    

   
    @Override
    public String toString() {
        return "membre{" + "id=" + id + ", DateJoin=" + DateJoin + ", idM=" + idM + ", idG=" + idG + '}'; 
    }

    
    
}
