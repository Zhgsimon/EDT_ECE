package dao;
import java.sql.*;
import modele.Etudiant;

public class EtudiantDAO extends DAO<Etudiant>{
	
	
	public EtudiantDAO(Connection conn) {
	    super(conn);
	  }

	  public boolean create(Etudiant obj) {
	    return false;
	  }

	  public boolean delete(Etudiant obj) {
	    return false;
	  }
	   
	  public boolean update(Etudiant obj) {
	    return false;
	  }
	   
	  
	  
	  //recherche dans la BDD les infos de l'utilisateur qui match avec l'email et le pwd
	  public Etudiant find(String email,String password) {
		  Etudiant etudiant = new Etudiant();      
	      
	    try {
	      ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE email = "+email+" AND password="+password);
	      if(result.first())
	        etudiant = new Etudiant(result.getInt("ID_utilisateur"),result.getString("email"),result.getString("password"),result.getString("nom"),
	          result.getString("prenom"));
	      
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return etudiant;
	  }

}
