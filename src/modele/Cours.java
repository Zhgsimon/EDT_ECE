package modele;
import java.util.*;

public class Cours {
	private int ID_cours;
	private String nom;
	 
	
	public Cours() {
		ID_cours=0;
		nom="";
	}
	public Cours(int ID, String nom) {
		ID_cours=0;
		nom="";
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
	
	
	
}
