import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controleur.Run;
import modele.Utilisateur;
import vue.MainFrame;
import vue.VueConnect;
import dao.*;

public class EDT {
	public static void main(String [] args)
	{
		
		
		//MainFrame frame_principale= new MainFrame("EDT_ECE");
		
		Utilisateur utilisateur= new Utilisateur();
		utilisateur=utilisateur.connexion("tutu@gmail.com", "jesuistutu");
		System.out.println(utilisateur.Getemail()); 
            //Connexion connexion = new Connexion();
		
		//Run controlleur= new Run(frame_principale, utilisateur);

		
	}

}