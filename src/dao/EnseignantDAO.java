package dao;
import java.sql.*;
import modele.Enseignant;

public class EnseignantDAO extends DAO<Enseignant>{
	public EnseignantDAO(Connection connection) {
	    super(connection);
	  }

	  public boolean create(Enseignant enseignant) {
	    return false;
	  }

	  public boolean delete(Enseignant enseignant) {
	    return false;
	  }

	  public boolean update(Enseignant enseignant) {
	    return false;
	  }
	   
	  public Enseignant find(int id) {
		  Enseignant enseignant = new Enseignant();            
	    try {
	      ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE, 
	        ResultSet.CONCUR_READ_ONLY
	      ).executeQuery(
	        "SELECT * FROM enseignant WHERE ID_utilisateur="+id 
	      );
	      //pas fini de changer le code
	      if(result.first()){
	    	  enseignant = new Enseignant(id, result.getString("prof_nom"), result.getString("prof_prenom"));
	        result.beforeFirst();
	        MatiereDAO matDao = new MatiereDAO(this.connect);
	            
	        while(result.next())
	          professeur.addMatiere(matDao.find(result.getInt("mat_id")));
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return professeur;
	  }

}
