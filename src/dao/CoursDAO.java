package dao;

import java.sql.*;
import modele.Cours;
import java.util.*;


public class CoursDAO extends DAO<Cours>{
	
	public CoursDAO(Connection connection) {
	    super(connection);
	  }

	  public boolean create(Cours cours) {
	    return false;
	  }

	  public boolean delete(Cours cours) {
	    return false;
	  }
	   
	  public boolean update(Cours cours) {
	    return false;
	  }
	  
	  //trouver toutes les infos d'un cours a partir de son id
	  public Cours find(int id) {
		  Cours cours = new Cours();      
		      
		    try {
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Cours WHERE ID_cours = " + id);
		      
		      if(result.first())
		    	  cours = new Cours(id,result.getString("Nom"));         
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return cours;
	  }
          
          
          public ArrayList<Cours> findList(int ID_enseignant){
              
            ArrayList<Cours> liste_cours= new ArrayList<Cours>();
            String query= "SELECT cours.ID_cours, cours.Nom FROM cours INNER JOIN enseignant ON cours.ID_cours=enseignant.ID_cours AND enseignant.ID_utilisateur=\""+ID_enseignant+"\"";
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
	    		liste_cours.add(new Cours (result.getInt("ID_cours"),result.getString("Nom")));
                    }
                }
                
                
            }
            catch(SQLException e){
                
            }
              
              return liste_cours;
          }
 

    public Cours find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cours find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cours> findList_seance(int ID_utilisateur, int droit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
