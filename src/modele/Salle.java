package modele;

public class Salle {
	private int ID_Salle;
	private String nom;
	private int capacite;
	
	public Salle() {
		ID_Salle=0;
		nom="";
		capacite=0;
	}
        public Salle(int ID_salle, String nom, int capacite) {
		this.ID_Salle=ID_salle;
		this.nom=nom;
		this.capacite=capacite;
	}
	
	public int GetID_Salle() {
		return ID_Salle;
	}
	public void SetID_Salle(int ID_Salle) {
		this.ID_Salle=ID_Salle;
	}
	
	public String Getnom() {
		return nom;
	}
	public void Setnom(String nom) {
		this.nom=nom;	
	}
	
	public int Getcapacite() {
		return capacite;
	}
	public void Setcapacite(int capacite) {
		this.capacite=capacite;	
	}
}
