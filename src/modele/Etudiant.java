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
            for(int i=0; i<liste_seance.size(); i++)
            {
                DAO<Cours> coursdao= new CoursDAO(Connexion.getInstance());
                Cours cours=coursdao.find(liste_seance.get(i).GetID_seance());
                String type_cours=coursdao.find_type_cours(liste_seance.get(i).GetID_seance());
                //System.out.println("Cours: "+cours.Getnom());
                //System.out.println("Type_Cours: "+type_cours);
                liste_seance.get(i).Settype_cours(type_cours);
                liste_seance.get(i).Setcours(cours);
            }
            
            return liste_seance;
        }
        
        
}
