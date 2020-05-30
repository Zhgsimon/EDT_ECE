package modele;
import java.util.*;

public class Site {
	private String nom;
	private ArrayList <Salle> liste_salles;
	
	public Site () {
		nom="";
		liste_salles=null;
	}
	
	public String Getnom() {
		return nom;
	}
	public void Setnom(String nom) {
		this.nom=nom;	
	}
	
	public ArrayList <Salle> Getliste_salles() {
		return liste_salles;
	}
	public void Setliste_salles(ArrayList <Salle> liste_salles) {
		this.liste_salles=liste_salles;	
	}
	
	//Ajoute une salle au site
	public void addSalle(Salle salle){
		if(!this.liste_salles.contains(salle))
			this.liste_salles.add(salle);
	}

	//Retire une salle du site
	public void removeSalle(Salle salle){
		 this.liste_salles.remove(salle);
	}
	
}
