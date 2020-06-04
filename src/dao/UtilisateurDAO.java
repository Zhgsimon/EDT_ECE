package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	    	    	
	      //ResultSet result = this.connect.createStatement().executeQuery(query);
              
              //ResultSet result= this.getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery(query);
              System.out.println("OKOK");
	      if(result.first())
              {
                  utilisateur = new Utilisateur(result.getInt("ID_utilisateur"),result.getString("Email"),result.getString("Password"),result.getString("Nom"),
	          result.getString("Prenom"));
                  System.out.println(utilisateur.Getemail());
                  System.out.println(utilisateur.getpassword());
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
    public Utilisateur find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
