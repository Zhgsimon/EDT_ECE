package dao;

import java.sql.*;
import modele.Cours;

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
	  
	  //trouver toutes les infos d'un cours � partir de son id
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

    @Override
    public Cours find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cours find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
