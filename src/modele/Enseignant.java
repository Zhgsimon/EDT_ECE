package modele;

import java.util.ArrayList;
import dao.*;

public class Enseignant extends Utilisateur{
	private ArrayList<Cours> liste_cours;
	
	 public Enseignant(){
		super();
		this.droit=2;
		liste_cours=null;
	}
	 public Enseignant(int id, String email, String password, String nom, String prenom, ArrayList<Cours> liste_cours)
	 {
		 super(id, email, password, nom, prenom, 2);
		 this.liste_cours=liste_cours;
	 }
         
         public Enseignant (Utilisateur utilisateur)
	{
		super(utilisateur.GetID_utilisateur(),utilisateur.Getemail(),utilisateur.getpassword(), utilisateur.Getnom(), utilisateur.Getprenom(), utilisateur.Getdroit());
		this.droit=2;
                
	}
        public Enseignant(Enseignant enseignant)
        {
             super (enseignant.GetID_utilisateur(), enseignant.Getemail(), enseignant.getpassword(), enseignant.Getnom(), enseignant.Getprenom(), enseignant.Getdroit());
             this.droit=2;
        }

	 public ArrayList<Cours> Getliste_cours() {
			return liste_cours;
	}
        
	public void Setliste_cours(ArrayList<Cours>liste_cours) {
		this.liste_cours=liste_cours;
	}
        
        public void recupListCours (int ID_enseignant){
            
            //connexion à la bdd
            DAO<Cours> coursdao= new CoursDAO(Connexion.getInstance());
            
            this.Setliste_cours(coursdao.findList(ID_enseignant));
        }
        public ArrayList<Seance> recupListSeance(){
            ArrayList<Seance> liste_seance= new ArrayList<Seance>();
            
            //connexion à la bdd
            DAO<Seance> seancedao= new SeanceDAO(Connexion.getInstance());
            liste_seance=seancedao.findList_seance(ID_utilisateur, droit);

            return liste_seance;
        }
        

        
        

    
}
