package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modele.*;

public class UtilisateurDAO extends DAO<Utilisateur>{
	
	
	public UtilisateurDAO(Connection conn) {
		super(conn);
	}

	//recherche dans la BDD les infos de l'utilisateur qui match avec l'email et le pwd

    /**
     *
     * @param email
     * @param password
     * @return
     */
        @Override
	public Utilisateur find(String email,String password) {
            
            Utilisateur utilisateur = new Utilisateur();  

            //String query ="SELECT * FROM utilisateur";
            String query ="SELECT * FROM utilisateur WHERE Email=\""+email+"\" AND Password=\""+password+"\"";
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
                  utilisateur = new Utilisateur(result.getInt("ID_utilisateur"),result.getString("Email"),result.getString("Password"),result.getString("Nom"),
	          result.getString("Prenom"), result.getInt("Droit"));
                  
              }
	    	  
	      
	    } catch (SQLException e) {
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

    @Override
    public Utilisateur find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Utilisateur> findList(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Utilisateur> findList_seance(int ID_utilisateur, int droit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
