package modele;

import java.util.*;

public class Groupe {
	private int ID_groupe;
	private String nom;
	private ArrayList<Etudiant> liste_etudiants;
	
	public Groupe()
	{
		ID_groupe=0;
		nom="";
		liste_etudiants=null;
	}
        public Groupe(int ID_groupe, String nom)
	{
		this.ID_groupe=ID_groupe;
		this.nom=nom;
		liste_etudiants=null;
	}
	
	public int GetID_groupe() {
		return ID_groupe;
	}
	public void SetID_groupe(int ID_groupe) {
		this.ID_groupe=ID_groupe;
	}
	
	public String Getnom() {
		return nom;
	}
	public void Setnom(String nom) {
		this.nom=nom;
		
	}
	
	
	public ArrayList<Etudiant> Getliste_etudiants() {
		return liste_etudiants;
	}
	
	public void Setliste_etudiants(ArrayList<Etudiant> liste_etudiants) {
		this.liste_etudiants=liste_etudiants;
	}
	
	//Ajoute un etudiant au groupe
	public void addEtudiant(Etudiant etudiant){
	  if(!this.liste_etudiants.contains(etudiant))
	    this.liste_etudiants.add(etudiant);
	}

	//Retire un etudiant du groupe
	public void removeEtudiant(Etudiant etudiant){
	  this.liste_etudiants.remove(etudiant);
	}
	
	
	
}
