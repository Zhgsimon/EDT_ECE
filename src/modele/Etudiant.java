package modele;

public class Etudiant extends Utilisateur{
	private int numero;
	
	public Etudiant ()
	{
		super();
		this.droit=3;
		numero=0;
	}
	public Etudiant (int id, String email, String password, String nom, String prenom)
	{
		super(id, email, password, nom, prenom);
		this.droit=3;
		numero=0;
	}

}
