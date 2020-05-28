/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.seprit.PIDEV.entities;

/**
 *
 * @author DELL
 */
public class Groups {
    private int id;
    private String nom;
    private String description;
    private user idF ;

    public Groups(String nom, String description, user idF) {
        this.nom = nom;
        this.description = description;
        this.idF = idF;
    }

    public Groups() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public user getIdF() {
        return idF;
    }

    public void setIdF(user idF) {
        this.idF = idF;
    }

    @Override
    public String toString() {
        return "groups{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", idF=" + idF + '}';
    }

    
    
    
}
