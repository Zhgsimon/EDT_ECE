package modele;

public class Utilisateur {
	
	protected int ID_utilisateur;
	protected String email;
	protected String password;
	protected String nom;
	protected String prenom;
	protected int droit; //1-Admin    2-Enseignant  3-Etudiant 
	
	public Utilisateur() {
		ID_utilisateur=0;
		email="";
		password="";
		nom="";
		prenom="";
		droit=0;
	}
	
	public int GetID_utilisateur() {
		return ID_utilisateur;
	}
	public void SetID_utilisateur(int ID_utilisateur) {
		this.ID_utilisateur=ID_utilisateur;
	}
	
	public String Getemail() {
		return email;
	}
	public void Setemail(String email) {
		this.email=email;
	}
	
	public String getpassword() {
		return password;
	}
	public void Setpassword(String password) {
		this.password=password;
	}
	
	public String Getnom() {
		return nom;
	}
	public void Setnom(String nom) {
		this.nom=nom;	
	}
	
	public String Getprenom() {
		return prenom;
	}
	public void Setprenom(String prenom) {
		this.prenom=prenom;	
	}
	
	public int Getdroit() {
		return droit;
	}
	public void Setdroit(int droit) {
		this.droit=droit;	
	}
	

}
