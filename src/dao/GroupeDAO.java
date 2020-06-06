package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modele.*;

public class GroupeDAO extends DAO<Groupe>{

    public GroupeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Groupe find(int ID_etudiant) {
        Groupe groupe= new Groupe();
        
            String query ="SELECT * FROM groupe INNER JOIN etudiant ON groupe.ID_groupe=etudiant.ID_groupe AND etudiant.ID_utilisateur="+ID_etudiant;
            System.out.println(query);
	    try {
                if(this.connect==null)
                {
                    System.out.println("Connect=null");
                }
	    	Statement stmt = this.connect.createStatement();
                
                ResultSet result=stmt.executeQuery(query);
                
              if(!result.isBeforeFirst()){
                  System.out.println("No data retrieved");
              }
              else if(result.first())
              {
                  groupe = new Groupe(result.getInt("ID_groupe"),result.getString("Nom"));                  
              }
            }
            catch (SQLException e) {
            }
            
        return groupe;
    }

    @Override
    public Groupe find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Groupe> findList(int ID_seance) {
        ArrayList<Groupe> liste_groupes = new ArrayList<Groupe>();  

            String query ="SELECT * FROM `seance_groupes` INNER JOIN groupe ON seance_groupes.ID_groupe=groupe.ID_groupe AND seance_groupes.ID_seance="+ID_seance;
            
            System.out.println(query);
	    try {
                if(this.connect==null)
                {
                    System.out.println("Connect=null");
                }
	    	Statement stmt = this.connect.createStatement();
                
                ResultSet result=stmt.executeQuery(query);
                
                if(!result.isBeforeFirst()){
                  System.out.println("No data retrieved");
                }
                
                else{
                    
                    //on parcours chaque ligne
                    while(result.next()) {
                        //On rajoute dans sa liste de cours chaque ligne
                        liste_groupes.add(new Groupe (result.getInt("ID_groupe"),result.getString("Nom")));
                    }
                }    
	    	   
	    } catch (SQLException e) {
	    }
            
	    return liste_groupes;
    }

    @Override
    public ArrayList<Groupe> findList_seance(int ID_utilisateur, int droit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
