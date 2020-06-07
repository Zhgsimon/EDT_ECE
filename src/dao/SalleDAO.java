package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modele.Salle;


public class SalleDAO extends DAO<Salle>{

    public SalleDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Salle find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Salle find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Salle> findList(int ID_seance) {
        ArrayList<Salle> liste_salles = new ArrayList<Salle>();  

            String query ="SELECT DISTINCT * FROM `seance_salle` INNER JOIN salle ON seance_salle.ID_seance=salle.ID_salle AND seance_salle.ID_seance="+ID_seance;
            
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
                
                else{
                    
                    //on parcours chaque ligne
                    while(result.next()) {
                        //On rajoute dans sa liste de cours chaque ligne
                        liste_salles.add(new Salle (result.getInt("ID_salle"),result.getString("Nom"),result.getInt("Capacite")));
                    }
                }    
	    	   
	    } catch (SQLException e) {
	    }
            
	    return liste_salles;
    }

    @Override
    public ArrayList<Salle> findList_seance(int ID_utilisateur, int droit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
