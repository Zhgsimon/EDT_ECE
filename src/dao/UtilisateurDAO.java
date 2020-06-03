package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.*;

import modele.*;

public class UtilisateurDAO extends DAO<Utilisateur>{
	
	
	public UtilisateurDAO(Connection conn) {
		super(conn);
	}

	//recherche dans la BDD les infos de l'utilisateur qui match avec l'email et le pwd
	  public Utilisateur find(String email,String password) {
		  Utilisateur utilisateur = new Utilisateur();  
		  Statement stmt = null;
	      String query ="SELECT * FROM utilisateur WHERE email = "+email+" AND password="+password;
	    try {
	    	//stmt = (Statement) this.connect.createStatement();
	    	
	    	
	      ResultSet result = this.connect.createStatement().executeQuery(query);
	      if(result.first())
	    	  utilisateur = new Utilisateur(result.getInt("ID_utilisateur"),result.getString("email"),result.getString("password"),result.getString("nom"),
	          result.getString("prenom"));
	      
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return utilisateur;
	  }

	@Override
	public boolean create(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
