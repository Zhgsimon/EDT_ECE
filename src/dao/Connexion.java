package dao;

import java.sql.*;
import java.util.ArrayList;
import java.lang.*;
//Singleton 
public class Connexion {
	
	
	
	  //URL de connexion
	  private String url = "jdbc:mysql://localhost:3306/edt?useSSL=false&useTimezone=true&serverTimezone=UTC";	  
	  //Nom du user
	  private String user = "root";
	  //Mot de passe de l'utilisateur
	  private String passwd = "";
	  //Objet Connection
	  private static Connection connect;
	   
	  //Constructeur prive
	  public Connexion() {
	    try {
	    	//Class.forName("com.mysql.cj.jdbc.Driver");
	    	//Connexion.forName("com.mysql.cj.jdbc.Driver");
	      connect = DriverManager.getConnection(url, user, passwd);
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	   
	 

	private static void forName(String Driver) {
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//M�thode qui va nous retourner notre instance et la cr�er si elle n'existe pas
	   public static Connection getInstance(){
	    if(connect == null){
	    	 new Connexion();
	    	 System.out.println("INSTANCIATION DE LA CONNEXION SQL ! ");
	    }
	    else{
	        System.out.println("CONNEXION SQL EXISTANTE ! ");
	    }
	    return connect;   
	  }
}
