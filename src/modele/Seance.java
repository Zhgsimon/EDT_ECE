package modele;
import java.util.*;
import java.time.*;

public class Seance {
	private int ID_seance;
	
	private int semaine;
	private LocalDate date_seance;
	private LocalTime heure_debut;
	private LocalTime heure_fin;
	
	private int Etat; //1- En cours   2- Annulé    3- Plannifié   
	private String  type_cours;
	
	private ArrayList<Groupe> liste_groupes;
	private ArrayList<Enseignant> liste_enseignants;
	private ArrayList<Salle> liste_salles;
	
	public Seance () {
		ID_seance=0;
		
		semaine=0;
		date_seance=LocalDate.parse("8888-88-88");
		heure_debut=LocalTime.parse("77:77:77");
		heure_fin=LocalTime.parse("66:66:66");
		
		Etat=0;
		type_cours="";
		
		liste_groupes=null;
		liste_enseignants=null;
		liste_salles=null;

	}
	
	public int GetID_seance() {
		return ID_seance;
	}
	public void SetID_seance(int ID_seance) {
		this.ID_seance=ID_seance;
	}
	
	public int Getsemaine() {
		return semaine;
	}
	public void Setsemaine(int semaine) {
		this.semaine=semaine;
	}
	
	public LocalDate Getdate_seance() {
		return date_seance;
	}
	public void Setdate_seance(LocalDate date_seance) {
		this.date_seance=date_seance;
	}
	
	public LocalTime Getheure_debut() {
		return heure_debut;
	}
	public void Setheure_debut(LocalTime heure_debut) {
		this.heure_debut=heure_debut;
	}
	
	public LocalTime Getheure_fin() {
		return heure_fin;
	}
	public void Setheure_fin(LocalTime heure_fin) {
		this.heure_fin=heure_fin;
	}
	
	public int GetEtat() {
		return Etat;
	}
	public void SetEtat(int Etat) {
		this.Etat=Etat;
	}
	
	public String Gettype_cours() {
		return type_cours;
	}
	public void Settype_cours(String  type_cours) {
		this.type_cours=type_cours;
	}
	
	
	
	
	public ArrayList<Groupe> Getliste_groupes() {
		return liste_groupes;
	}
	public void Setliste_groupes(ArrayList<Groupe> liste_groupes ) {
		this.liste_groupes=liste_groupes;	
	}
	
	
	public ArrayList<Enseignant> Getliste_enseignants() {
		return liste_enseignants;
	}
	public void Setliste_enseignants(ArrayList<Enseignant> liste_enseignants) {
		this.liste_enseignants=liste_enseignants;	
	}
	
	
	public ArrayList <Salle> Getliste_salles() {
		return liste_salles;
	}
	public void Setliste_salles(ArrayList<Salle> liste_salles) {
		this.liste_salles=liste_salles;	
	}
	
	
	//Ajoute un groupe a la séance
	public void addGroupe(Groupe groupe){
		if(!this.liste_groupes.contains(groupe))
			this.liste_groupes.add(groupe);
	}

	//Retire un groupe de la séance
	public void removeGroupe(Groupe groupe){
		this.liste_groupes.remove(groupe);
	}
	
	
	
	//Ajoute un enseignant à la séance
	public void addEnseignant(Enseignant enseignant){
		if(!this.liste_enseignants.contains(enseignant))
			this.liste_enseignants.add(enseignant);
	}

	//Retire un enseignant de la séance
	public void removeEnseignant(Enseignant enseignant){
		this.liste_enseignants.remove(enseignant);
	}
		
	
		
	//Ajoute un enseignant à la séance
	public void addSalle(Salle salle){
		if(!this.liste_salles.contains(salle))
			this.liste_salles.add(salle);
	}

	//Retire un enseignant de la séance
	public void removeSalle(Salle salle){
			this.liste_salles.remove(salle);
	}
	
	
}
