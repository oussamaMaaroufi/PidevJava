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
import tn.seprit.PIDEV.entities.Groups;
import tn.seprit.PIDEV.entities.Membre;
import tn.seprit.PIDEV.entities.user;
import tn.seprit.PIDEV.utils.MyConnection;

/**
 *
 * @author DELL
 */
public class MembreService {
    
    
    private Connection cnx ;
  UserService Su = new UserService();
  GroupsService Sg = new GroupsService();
  
  public MembreService(){
      cnx = MyConnection.getInstance().getCnx();
      
  }
  
    public void ajouterMembre(Membre M){
      try {
          String req = "Insert Into membre (DateJoin,idG,idM) VALUES ('"+M.getDateJoin()+"','"+M.getIdG().getId()+"','"+M.getIdM().getId()+"');";
          Statement st = cnx.createStatement();
          st.executeUpdate(req);
          System.out.println("insertion Reussie !");
      } catch (SQLException ex) {
          System.out.println(ex);
      }
  }
  
  
    
    public List<Membre> afficherAll(){
       List<Membre> listM = new ArrayList<>();
       String req = "select * from membre";
       Statement st ;
       
      try {
          st = cnx.createStatement();
          ResultSet res = st.executeQuery(req);
          while (res.next()) {              
              Membre  M = new Membre();
              M.setId(res.getInt("id"));
              M.setDateJoin(res.getDate(2));
              M.setIdM(Su.findUserbyId(res.getInt("idM")));
              M.setIdG(Sg.FindGroupById(res.getInt("idG")));
              listM.add(M);
              }
          System.out.println(listM);
          
      } catch (SQLException ex) {
          Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
      }
       return listM;
   }
    
    public void deleteMembre(int id){
          String req = "DELETE FROM `membre` WHERE id = "+id;
       Statement st ;
          try {
          st = cnx.createStatement();
          st.executeUpdate(req);
          }catch(SQLException E){
              System.out.println(E.getMessage());
               System.out.println("supprime membre  Reussie !");
          }
         
    }
    
    public void deleteByIdgroupIdMembre(int idG,int idM){
          String req = "DELETE FROM `membre` WHERE idG = "+idG+" and idM="+idM+";";
       Statement st ;
          try {
          st = cnx.createStatement();
          st.executeUpdate(req);
          }catch(SQLException E){
              System.out.println(E.getMessage());
               System.out.println("supprime membre  Reussie !");
          }
         
    }
    
    
    
}
