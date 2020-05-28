/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.seprit.PIDEV.test;

import java.sql.Date;
import tn.seprit.PIDEV.entities.Groups;
import tn.seprit.PIDEV.entities.Membre;
import tn.seprit.PIDEV.entities.user;
import tn.seprit.PIDEV.services.GroupsService;
import tn.seprit.PIDEV.services.MembreService;
import tn.seprit.PIDEV.services.UserService;

/**
 *
 * @author DELL
 */
public class mainClass {
    
 //   static String url="jdbc:mysql://localhost:3306/esprit";
  //  static String login="root";
  //  static String mdp ="";
   
    
    public static void main(String[] args) {
       // MyConnection cnx = MyConnection.getInstance();
        
        UserService Us =new UserService();
        MembreService Ms =new MembreService();
        GroupsService Gs =  new  GroupsService();
        
        user u =new user();  u.setId(2);
        Groups G = new Groups("group java", "test java ", u);
        Membre M =new Membre(new Date(12, 10, 2020), u, G);

      
    
  
    //   Ms.ajouterMembre(M);
    // Gs.ajouterMembre(G);
   // Us.afficherAll();
   u.setEmail("oussamama07@gmail.com");
   u.setPassword("pwd");
   u.setUsername("maaroufi");
   u.setAdresse("tn");
   u.setRoles("a:1:{i:0;s:10:\"ROLE_ADMIN\";}");
   
  // Us.ajouterMembre(u);
  // u = Us.findUserbyId(5);
  

  /* ------------ Groupe CRUD -----------------*/
  
   //Gs.afficherAll();
  //  Gs.ajouterGroup(G);
  // Gs.FindGroupById(9);
  // Gs.deleteGroup( ?? );
  // Gs.Updetegroup(10, G);
 // Groups G1 =new Groups();
 // G1.setId(4);
  Groups G2 =new Groups();
  G2.setId(2);
 // Gs.BlockGroup(G1);
  Gs.DeblockGroup(G2);
 
  /* -------------fin Groupe CRUD -------------- */
 
    /* ------------ Membre CRUD -----------------*/
    //   Ms.afficherAll();
    //   Ms.ajouterMembre(M);
    //  Ms.deleteByIdgroupIdMembre(6, 2);
    
    
    /* -------------fin Groupe CRUD -------------- */
 
    }
    
}
