package modele;
import dao.*;
import java.util.ArrayList;
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
		super(id, email, password, nom, prenom,3);
		numero=0;
	}
        
        public Etudiant (Utilisateur utilisateur)
	{
		super(utilisateur.GetID_utilisateur(),utilisateur.Getemail(),utilisateur.getpassword(), utilisateur.Getnom(), utilisateur.Getprenom(), utilisateur.Getdroit());
		this.droit=3;
		numero=0;
	}
        //recup le groupe ds lequel il appartient
        public Groupe recupGroupe(){
            Groupe groupe=new Groupe();
            DAO<Groupe> groupedao= new GroupeDAO(Connexion.getInstance());
            groupe=groupedao.find(this.ID_utilisateur);
            return groupe;
        }
        
        public ArrayList<Seance> recupListSeance(int ID_groupe){
        ArrayList<Seance> liste_seance= new ArrayList<Seance>();
            
            //connexion à la bdd
            DAO<Seance> seancedao= new SeanceDAO(Connexion.getInstance());

            liste_seance=seancedao.findList_seance(ID_groupe, droit);
            
            return liste_seance;
        }
        
        
}
