package modele;

import java.util.*;

public class Promotion {
	private int ID_promotion;
	private String nom;
	private ArrayList<Groupe> liste_groupes;
	
	public Promotion () {
		ID_promotion=0;
		nom="";
		liste_groupes=null;
	}
	
	public int GetID_promotion() {
		return ID_promotion;
	}
	public void SetID_promotion(int ID_promotion) {
		this.ID_promotion=ID_promotion;
	}
	
	
	public String Getnom() {
		return nom;
	}
	public void Setnom(String nom) {
		this.nom=nom;	
	}
	
	
	public ArrayList<Groupe> Getliste_groupes() {
		return liste_groupes;
	}
	public void Setliste_groupes(ArrayList<Groupe> liste_groupes) {
		this.liste_groupes=liste_groupes;	
	}
	
	//Ajoute un groupe à la promo
	public void addGroupe(Groupe groupe){
		if(!this.liste_groupes.contains(groupe))
			this.liste_groupes.add(groupe);
	}

	//Retire un groupe de la promo
	public void removeGroupe(Groupe groupe){
		 this.liste_groupes.remove(groupe);
	}
}
