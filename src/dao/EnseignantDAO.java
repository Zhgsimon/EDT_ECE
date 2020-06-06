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
	  //Pour un enseignant donn� (recherche possible avec son nom ou parmi une liste d enseignants) 
	  //et pour une semaine donnee, consulter tous les cours. Pour chaque jour de la semaine et pour chaque seance de cours, 
	  //indiquer les informations suivantes : la date, le creneau horaire, la (les) salle(s), 
	  //le site, le nom et le type du cours, le(s) enseignant(s), le(s) groupe(s).

    @Override
    public Enseignant find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Enseignant find_id(int ID_enseignant) {
		  Enseignant enseignant = new Enseignant();
                  String query ="SELECT * FROM utilisateur WHERE ID_utilisateur="+ID_enseignant;
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
              
                if(result.first())
                {
                    //On cherche a recuperer les cours qu'il enseigne
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

    @Override
    public ArrayList<Enseignant> findList(int ID_seance) {
        ArrayList<Enseignant> liste_enseignant = new ArrayList<Enseignant>();  
            
            //On récupère les ID des enseignant de ce cours
            String query_enseignant_id ="SELECT DISTINCT seance_enseignant.ID_enseignant FROM `seance_enseignant` INNER JOIN enseignant ON seance_enseignant.ID_enseignant=enseignant.ID_utilisateur AND seance_enseignant.ID_seance="+ID_seance;
            
            System.out.println(query_enseignant_id);
	    try {
                if(this.connect==null)
                {
                    System.out.println("Connect=null");
                }
	    	Statement stmt = this.connect.createStatement();
                
                ResultSet result=stmt.executeQuery(query_enseignant_id);
                
                if(!result.isBeforeFirst()){
                  System.out.println("No data retrieved");
                }
                
                else{
                    //on parcours chaque ligne
                    while(result.next()) {
                        //en parcourant chaque ID on récupère chaque Enseignant
                        Enseignant enseignant=this.find_id(result.getInt("ID_enseignant")) ;
                        
                        //On rajoute dans la liste d'enseignant de la seance
                        liste_enseignant.add(enseignant);
                    }
                }    
	    	   
	    } catch (SQLException e) {
	    }
	    return liste_enseignant;
    }

    @Override
    public ArrayList<Enseignant> findList_seance(int ID_utilisateur, int droit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	  
	  
}
