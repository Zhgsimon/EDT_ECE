package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modele.*;
import dao.*;

public class SeanceDAO extends DAO<Seance>{

    public SeanceDAO(Connection conn) {
        super(conn);
    }
    

    @Override
    public boolean create(Seance obj) {
        return false;
    }

    @Override
    public boolean delete(Seance obj) {
        return false;
    }

    @Override
    public boolean update(Seance obj) {
        return false;
    }

    @Override
    public Seance find(int ID) {
        Seance seance=new Seance();
        return seance;
    }

    @Override
    public Seance find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public ArrayList<Seance> findList_seance(int ID_utilisateur, int droit) {
        ArrayList<Seance> liste_seance= new ArrayList<Seance>();
        
        ArrayList<Groupe> liste_groupes= new ArrayList<Groupe>();
        ArrayList<Enseignant> liste_enseignants= new ArrayList<Enseignant>();
        ArrayList<Salle> liste_salles= new ArrayList<Salle>() ;
        String type_cours= new String();
        
        String query="";
        
        
        if (droit ==2)
        {
            //On récup les seances de l'enseignant
                query= "SELECT * FROM seance_enseignant INNER JOIN seance ON seance_enseignant.ID_seance=seance.ID_seance AND ID_enseignant="+ID_utilisateur;
        }
        if (droit==3)
        {
            //on recup les seance du groupe en question
            int ID_groupe=ID_utilisateur;
            query= "SELECT * FROM seance INNER JOIN seance_groupes ON seance_groupes.ID_seance=seance.ID_seance AND seance_groupes.ID_groupe="+ID_groupe;
        }
            
        System.out.println(query);
            
            try{
                if(this.connect==null)
                {
                    System.out.println("Connect=null");
                }
                else{                    
                    Statement stmt = this.connect.createStatement();          
                    ResultSet result=stmt.executeQuery(query);
                           

                    //On parcours chaque ligne
                    while(result.next()) {
	    		//On rajoute dans sa liste de cours chaque ligne
	    		liste_seance.add(new Seance (result.getInt("ID_seance"),result.getInt("Semaine"),result.getDate("Date").toLocalDate(),
                        result.getTime("Heure_debut").toLocalTime(),result.getTime("Heure_fin").toLocalTime(),result.getInt("Etat")));

                    }
                }
                
                
            }
            catch(SQLException e){
                
            }
            return liste_seance;
    }

    @Override
    public ArrayList<Seance> findList(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
