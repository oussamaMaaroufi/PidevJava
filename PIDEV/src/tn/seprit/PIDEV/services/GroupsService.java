/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.seprit.PIDEV.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.seprit.PIDEV.entities.Groups;
import tn.seprit.PIDEV.entities.user;
import tn.seprit.PIDEV.utils.MyConnection;

/**
 *
 * @author DELL
 */
public class GroupsService {
     private Connection cnx ;
   UserService us =new UserService();
  
  public GroupsService(){
      cnx = MyConnection.getInstance().getCnx();
      
  }
  
  
    public void ajouterGroup (Groups G){
      try {
          String req = "Insert Into groups (nom,description,idF) VALUES ('"+G.getNom()+"','"+G.getDescription()+"','"+G.getIdF().getId()+"');";
          Statement st = cnx.createStatement();
          st.executeUpdate(req);
          System.out.println("ajoute group  Reussie !");
      } catch (SQLException ex) {
          System.out.println(ex);
      }
      
  }
    
    
     public List<Groups> afficherAll(){
         List<Groups> listG = new ArrayList<>();
         Groups G;
       String req = "select * from groups where Enabled="+1;
       Statement st ;
      
          try {
          st = cnx.createStatement();
          ResultSet res = st.executeQuery(req);
          while (res.next()) {   
          G = new Groups();
          G.setId(res.getInt(1));
          G.setNom(res.getString(2));
          G.setDescription(res.getString(3));
          G.setIdF(us.findUserbyId(res.getInt(4)));
          listG.add(G);
          }
              System.out.println(listG);
          }catch(SQLException e){
              System.out.println(e.getMessage());
          }
       return listG;
     }
     
     public Groups FindGroupById(int id){
         Groups G = new Groups();
       String req = "select * from groups where id = "+id+" and Enabled="+1;
       Statement st ;
          try {
          st = cnx.createStatement();
          ResultSet res = st.executeQuery(req);
          while (res.next()) {    
        G.setId(res.getInt(1));
          G.setNom(res.getString(2));
          G.setDescription(res.getString(3));
          G.setIdF(us.findUserbyId(res.getInt(4)));
          }
              System.out.println(G);
          }catch(SQLException e){
              System.out.println(e.getMessage());
          }
       return G;
     }
     
     public void deleteGroup(int id){
          String req = "DELETE FROM `groups` WHERE id = "+id;
       Statement st ;
          try {
          st = cnx.createStatement();
          st.executeUpdate(req);
          }catch(SQLException E){
              System.out.println(E.getMessage());
               System.out.println("supprime group  Reussie !");
          }
         
     }
     
     public void  Updetegroup(int id, Groups g){
         
          String req = "UPDATE `groups` SET `nom`='"+g.getNom()+"',`description`='"+g.getDescription()+"' WHERE id = "+id;
       Statement st ;
          try {
          st = cnx.createStatement();
          st.executeUpdate(req);
          }catch(SQLException E){
              System.out.println(E.getMessage());
               System.out.println("Update  group  Reussie !");
          }
 
     }
     
     
     public void BlockGroup(Groups G){
          String req = "UPDATE `groups` SET `Enabled`="+0+" WHERE id = "+G.getId();
       Statement st ;
          try {
          st = cnx.createStatement();
          st.executeUpdate(req);
          
               System.out.println("Block  group  Reussie !");
          }catch(SQLException E){
              System.out.println(E.getMessage());
          }
     }
     
       public void DeblockGroup(Groups G){
          String req = "UPDATE `groups` SET `Enabled`="+1+" WHERE id = "+G.getId();
       Statement st ;
          try {
          st = cnx.createStatement();
          st.executeUpdate(req);          
               System.out.println("Deblock  group  Reussie !");
          }catch(SQLException E){
              System.out.println(E.getMessage());
          }
     }

     
    
    
    
    
}
