package controleur;

import dao.Connexion;
import dao.DAO;
import dao.UtilisateurDAO;
import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import vue.VueEDT;
import static java.awt.PageAttributes.MediaType.C;

import modele.*;
import vue.*;

public class Run {
	
	private MainFrame frame_principale;
	private Utilisateur utilisateur;
	
	public Run (MainFrame frame_principale, Utilisateur utilisateur)
	{
		this.frame_principale=frame_principale;
		this.utilisateur=utilisateur;
		this.frame_principale.getvueConnect().addConnectListener(new ConnectListener ());
	}
	class ConnectListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
                    String email=frame_principale.getvueConnect().getemail_text().getText();
                    String password= String.valueOf(frame_principale.getvueConnect().getpassword_text().getPassword());
			
                    //connexion de l'utilisateur
                    utilisateur=utilisateur.connexion(email, password);
                    
                    System.out.println(utilisateur.Getdroit());
                    int droit=utilisateur.Getdroit();
                    if(droit==0);
                    {
                        
                        //frame_principale.getvueConnect().ErrorMessage("Email et Password incorrectes.");
                    }
                    if(droit==1) //admin
                    {
                
                    }
                    if(droit==2) //Enseignant
                    {
                        Enseignant enseignant=new Enseignant(utilisateur);
                        enseignant.recupListCours(utilisateur.GetID_utilisateur());
                        System.out.println("Size liste cours: "+enseignant.Getliste_cours().size());
                        
                        //on recup toutes ses seance
                        ArrayList<Seance> liste_seance_enseignant= new ArrayList<Seance>();
                        liste_seance_enseignant=enseignant.recupListSeance();
                        System.out.println("Size liste seance: "+liste_seance_enseignant.size());
                        
                        //Pour chaque seance on set la liste des salles, enseignants, groupes
                        for (int i=0; i<liste_seance_enseignant.size(); i++)
                        {
                            ArrayList<Salle> liste_salles= new ArrayList<Salle>();
                            liste_salles=liste_seance_enseignant.get(i).recupListSalle();
                            liste_seance_enseignant.get(i).Setliste_salles(liste_salles);
                            System.out.println("Size liste salle: "+liste_salles.size()+"de la seance: "+liste_seance_enseignant.get(i).GetID_seance());

                            ArrayList<Groupe> liste_groupes= new ArrayList<Groupe>();
                            liste_groupes=liste_seance_enseignant.get(i).recupListGroupe();
                            liste_seance_enseignant.get(i).Setliste_groupes(liste_groupes);
                            System.out.println("Size liste groupe: "+liste_groupes.size()+"de la seance: "+liste_seance_enseignant.get(i).GetID_seance());

                            ArrayList<Enseignant> liste_enseignants= new ArrayList<Enseignant>();
                            liste_enseignants=liste_seance_enseignant.get(i).recupListEnseignant();
                            //liste_seance_enseignant.get(i).Setliste_groupes(liste_groupes);
                            System.out.println("Size liste enseignants: "+liste_enseignants.size()+"de la seance: "+liste_seance_enseignant.get(i).GetID_seance());


                        }
                        
                    }
                    if(droit==3) //Etudiant
                    {
                        // On construi un nouveau etudiant
                        Etudiant etudiant= new Etudiant (utilisateur);
                        
                        //On recup ensuite son groupe 
                        Groupe groupe=etudiant.recupGroupe();
                        System.out.println("ID GROUPE: "+groupe.GetID_groupe());
                        
                        //on recup toutes ses seances du groupe
                        ArrayList<Seance> liste_seance_etudiant= new ArrayList<Seance>();
                        liste_seance_etudiant=etudiant.recupListSeance(groupe.GetID_groupe());
                        System.out.println("Size liste seance: "+liste_seance_etudiant.size());


                    }
                    //On enlève tout
                    frame_principale.getContentPane().removeAll();
                    //On change de view
                    //frame_principale.addVueEDT();
                    
                        
                        
                        
                    //frame_principale.getvueConnect().getmessage().setText("ok");
                    frame_principale.getvueConnect().getmessage().setText("email:"+ utilisateur.Getemail()+"   password:"+utilisateur.getpassword());

		}
		
	}
        
        public MainFrame getMainFrame ()
        {
            return this.frame_principale;
        }
	
	public static void main(String [] args)
	{
            MainFrame frame_principale= new MainFrame("EDT_ECE");
            Utilisateur utilisateur= new Utilisateur();
            
            Run run=new Run(frame_principale,utilisateur);
            
            
            
            frame_principale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
		
		//Affichage du form de connexion email:   pwd: 
		
        
        

        
        //frame.add(new Lafenetre());
        //frame.setVisible(true);
        //frame.setTitle("L'emploie du temps");

        //31 a 52 puis 1 a 28 pour les semaines
        // g.fillRect((int)(4+s*23.66),85,19,22);
      
            
           // ajout des boutons à la fenêtre                
           
           // positionnement et dimensionnement manuel des boutons
           
        //   b1.setBorderPainted(false);
          // b1.setContentAreaFilled(false);
        //   b1.setFocusPainted(false);
           
       //    b1.setBounds(4, 85, 19, 22);
         
           /*int s = 31;
           ArrayList <JButton> listesemaine = null;
           JLabel label = new JLabel("Bienvenue dans ma modeste application");
           
           
           for(int i=0;i<52;i++)
           {
                       
                   if(i==21)
                   {
                       s=1;
                   }

               
               JButton tampon = new JButton(Integer.toString(s));
             //  listesemaine.add(tampon);
               tampon.setBounds((int)(4+i*23.66), 85, 19, 22);
               tampon.setVisible(true);
               frame.add(tampon);
               
               s++;
               System.out.println("test");
               
 
           }*/
           
     //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     /*//fetch student record based on his roll no from the database
     Etudiant model  = retriveStudentFromDatabase();

     //Create a view : to write student details on console
     StudentView view = new StudentView();

     StudentController controller = new StudentController(model, view);

     controller.updateView();

     //update model data
     controller.setStudentName("John");

     controller.updateView();*/
      
      
    //}
	
}
