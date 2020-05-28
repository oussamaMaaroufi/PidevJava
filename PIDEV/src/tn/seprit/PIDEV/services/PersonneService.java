/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.seprit.PIDEV.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.seprit.PIDEV.entities.Personne;
import tn.seprit.PIDEV.utils.MyConnection;

/**
 *
 * @author DELL
 */
public class PersonneService {
  private Connection cnx ;
  
  
  public PersonneService(){
      cnx = MyConnection.getInstance().getCnx();
      
  }
    
  public void ajouterPersonne(Personne p ){
      try {
          String req = "Insert Into personne (nom,prenom) VALUES ('"+p.getNom()+"','"+p.getPrenom()+"');";
          
          Statement st = cnx.createStatement();
          st.executeUpdate(req);
          System.out.println("insertion Reussie !");
      } catch (SQLException ex) {
          System.out.println(ex);
      }
  }
  
   public void ajouterPersonne1(Personne p ){
      try {
          String req = "Insert Into personne (nom,prenom) VALUES (?,?);";
          PreparedStatement pre= cnx.prepareStatement(req);
          pre.setString(1, p.getNom());
          pre.setString(2,p.getNom());
          
          pre.executeUpdate();
          
          System.out.println("insertion 2 Reussie !");
      } catch (SQLException ex) {
          System.out.println(ex);
      }
  }
   
   public List<Personne> afficherAll(){
       List<Personne> listP = new ArrayList<>();
       String req = "select * from personne";
       Statement st ;
       
      try {
          st = cnx.createStatement();
          ResultSet res = st.executeQuery(req);
          while (res.next()) {              
              Personne  p = new Personne();
              
              p.setId(res.getInt("id"));
              p.setNom(res.getString(2));
              p.setPrenom(res.getString("prenom"));
              listP.add(p);
              }
          System.out.println(listP);
          
      } catch (SQLException ex) {
          Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
      }
       return listP;
   }
}




