package modele;
import java.util.*;

public class Cours {
	private int ID_cours;
	private String nom;
	private ArrayList<Enseignant> liste_enseignants; 
	
	public Cours() {
		ID_cours=0;
		nom="";
		liste_enseignants=null;
	}
	public Cours(int ID, String nom) {
		ID_cours=0;
		nom="";
		liste_enseignants=null;
	}
	
	public int GetID_cours() {
		return ID_cours;
	}
	public void SetID_cours(int ID_cours) {
		this.ID_cours=ID_cours;
	}
	
	public String Getnom() {
		return nom;
	}
	public void Setnom(String nom) {
		this.nom=nom;
		
	}
	
	public ArrayList<Enseignant> Getliste_enseignants() {
		return liste_enseignants;
	}
	public void Setliste_enseignants(ArrayList<Enseignant>liste_enseignants) {
		this.liste_enseignants=liste_enseignants;
	}
	
}
