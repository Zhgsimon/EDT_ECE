package dao;
import java.sql.*;
import modele.*;
import java.util.*;


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
	   
	//recherche dans la BDD les infos de l'utilisateur qui match avec l'email et le pwd
	  public Enseignant find(String email,String password) {
		  Enseignant enseignant = new Enseignant();      
	      
	    try {
	      ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE email = "+email+" AND password="+password);
	      if(result.first())
	      {
	    	  //On cherche � r�cup�rer les cours qu'il enseigne
	    	  ArrayList<Cours> liste_cours=new ArrayList<Cours>();
	    	  ResultSet result_cours = this.connect.createStatement(
	    	  ResultSet.TYPE_SCROLL_INSENSITIVE,
	    	  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT* FROM cours JOIN enseignant ON cours.ID_cours=enseignant.ID_cours AND enseignant.ID_utilisateur="+result.getInt("ID_utilisateur"));
	    	  
	    	  //on parcours chaque ligne
	    	  while(result_cours.next()) {
	    		  //On rajoute dans sa liste de cours chaque ligne
	    		  liste_cours.add(new Cours (result_cours.getInt("ID_cours"),result_cours.getString("Nom")));
	    		}	
	    	  enseignant = new Enseignant(result.getInt("ID_utilisateur"),result.getString("Email"),result.getString("Password"),result.getString("Nom"),
	    	          result.getString("Prenom"), liste_cours);
	      }
	        
	      
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return enseignant;
	  }
	  //Pour un enseignant donn� (recherche possible avec son nom ou parmi une liste d�enseignants) 
	  //et pour une semaine donn�e, consulter tous les cours. Pour chaque jour de la semaine et pour chaque s�ance de cours, 
	  //indiquer les informations suivantes : la date, le cr�neau horaire, la (les) salle(s), 
	  //le site, le nom et le type du cours, le(s) enseignant(s), le(s) groupe(s).

    @Override
    public Enseignant find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	  
	  
}
