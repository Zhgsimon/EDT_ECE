package dao;

import java.sql.*;
import java.util.ArrayList;

public class Connexion {
	
	private final Connection connection;
	
	//attribut pour r�cup les donn�es de la BDD
    private final Statement statement;
    
    //contient le r�sultat de la la requete SQL
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    
    
    /**
     * ArrayList public pour les tables
     */
    public ArrayList<String> tables = new ArrayList<>();
    /**
     * ArrayList public pour les requ�tes de s�lection
     */
    public ArrayList<String> requetes = new ArrayList<>();
    /**
     * ArrayList public pour les requ�tes de MAJ
     */
    public ArrayList<String> requetesMaj = new ArrayList<>();

    
    //Constructeur
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException{
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost:3308/" + nameDatabase;


        //cr�ation d'une connexion JDBC � la base 
        connection = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // cr�ation d'un ordre SQL (statement)
        statement = connection.createStatement();
    }
    
    
    /**
     * M�thode qui ajoute la table en parametre dans son ArrayList
     *
     * @param table
     */
    public void ajouterTable(String table) {
        tables.add(table);
    }

    /**
     * M�thode qui ajoute la requete de selection en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequete(String requete) {
        requetes.add(requete);
    }

    /**
     * M�thode qui ajoute la requete de MAJ en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequeteMaj(String requete) {
        requetesMaj.add(requete);
    }

    /**
     * M�thode qui retourne l'ArrayList des champs de la table en parametre
     *
     * @param table
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList remplirChampsTable(String table) throws SQLException {
        // r�cup�ration de l'ordre de la requete
        rset = statement.executeQuery("select * from " + table);

        // r�cup�ration du r�sultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<>();
        String champs = "";
        // Ajouter tous les champs du resultat dans l'ArrayList
        for (int i = 0; i < nbColonne; i++) {
            champs = champs + " " + rsetMeta.getColumnLabel(i + 1);
        }

        // ajouter un "\n" � la ligne des champs
        champs = champs + "\n";

        // ajouter les champs de la ligne dans l'ArrayList
        liste.add(champs);

        // Retourner l'ArrayList
        return liste;
    }

    /**
     * Methode qui retourne l'ArrayList des champs de la requete en parametre
     * @param requete
     * @return 
     * @throws java.sql.SQLException
     */
    public ArrayList remplirChampsRequete(String requete) throws SQLException {
        // r�cup�ration de l'ordre de la requete
        rset = statement.executeQuery(requete);

        // r�cup�ration du r�sultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<>();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            String champs;
            champs = rset.getString(1); // ajouter premier champ

            // Concatener les champs de la ligne separes par ,
            for (int i = 1; i < nbColonne; i++) {
                champs = champs + "," + rset.getString(i + 1);
            }

            // ajouter un "\n" � la ligne des champs
            champs = champs + "\n";

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(champs);
        }

        // Retourner l'ArrayList
        return liste;
    }

    /**
     * M�thode qui execute une requete de MAJ en parametre
     * @param requeteMaj
     * @throws java.sql.SQLException
     */
    public void executeUpdate(String requeteMaj) throws SQLException {
        statement.executeUpdate(requeteMaj);
    }
}
