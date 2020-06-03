package modele;

import java.util.ArrayList;

public class Enseignant extends Utilisateur{
	private ArrayList<Cours> liste_cours;
	
	 public Enseignant(){
		super();
		this.droit=2;
		liste_cours=null;
	}
	 public Enseignant(int id, String email, String password, String nom, String prenom, ArrayList<Cours> liste_cours)
	 {
		 super(id, email, password, nom, prenom);
		 this.droit=2;
		 this.liste_cours=liste_cours;
	 }

	 public ArrayList<Cours> Getliste_cours() {
			return liste_cours;
	}
	 
	public void Setliste_cours(ArrayList<Cours>liste_cours) {
		this.liste_cours=liste_cours;
	}
}
