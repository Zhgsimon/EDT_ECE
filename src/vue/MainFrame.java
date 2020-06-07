package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import vue.*;

import javax.swing.*;
import modele.Enseignant;
import modele.Etudiant;
import modele.Seance;

public class MainFrame extends JFrame {
	private VueConnect vueConnect;
        private VueEDT vueEDT;
        private VueEDTLigne vueEDTLigne;
        
        private Etudiant etudiant;
        private ArrayList<Seance> liste_seances;
	private Enseignant enseignant;
        
	public MainFrame (String titre)
	{
		super(titre);
		
		this.setSize(1280, 750);
		setLocationRelativeTo(null);//On centre la fenêtre sur l'écran
                setResizable(true); //On permet le redimensionnement
		vueConnect=new VueConnect();

		//ajout de la vue
		this.getContentPane().add(vueConnect);
		
		this.pack();
		this.setVisible(true);
		
		
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public MainFrame() {
        super("En Liste");
		
		this.setSize(1280, 750);
		setLocationRelativeTo(null);//On centre la fenêtre sur l'écran
                setResizable(true); //On permet le redimensionnement
                
                //ajout de la vue
		
		this.pack();
		this.setVisible(true);
    }
	
	
	public VueConnect getvueConnect()
	{
		return this.vueConnect;
	}
        public VueEDT getVueEDT(){
            return this.vueEDT;
        }
        
        
        public void addVueEDT(Etudiant etudiant, ArrayList<Seance> liste_seances){
            this.seEtudiant(etudiant);
            this.setListeSeances(liste_seances);
            this.setTitle("Emploi du temps");
            this.setSize(1280, 750);
            vueEDT= new VueEDT(etudiant,liste_seances);
            vueEDT.build();
            this.getContentPane().add(vueEDT);
        }
        public void addVueEDT(Enseignant enseignant, ArrayList<Seance> liste_seances){
            this.setEnseignant(enseignant);
            this.setListeSeances(liste_seances);
            this.setTitle("Emploi du temps");
            this.setSize(1280, 750);
            
            vueEDT= new VueEDT(enseignant,liste_seances);
            vueEDT.build();
            //System.out.println("Il y a tant de boutons: "+vueEDT.getButtonSemaine().size());
            /*for (int i=0; i<vueEDT.getButtonSemaine().size();i++)
            {
                System.out.println("Bouton : "+i+" son texte: "+vueEDT.getButtonSemaine().get(i).getText());
            }*/
            this.getContentPane().add(vueEDT);
        }
        public void addSemaineListener()
        {
            this.getVueEDT().addSemaineListener(new SemaineListener());
        }
        
        class SemaineListener implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                //on recup la liste de boutons
                java.util.List<JButton> listesemaine = new ArrayList<>();
                listesemaine=vueEDT.getButtonSemaine();
                Object source = e.getSource();
                System.out.println("OKKKKKKKKKKKKKKKKKKKK");
                for(int j=0;j<50;j++)
                {
                    if( source == listesemaine.get(j)){

                                    String txt = listesemaine.get(j).getText();
                                    System.out.println(txt);
                                    int semaine_selec = Integer.parseInt(txt);
                                    System.out.println(semaine_selec);
                                    //On affiche l'edt correspondant a la semaine selectionné
                                    vueEDT.setSemaineSelec(semaine_selec);

                    }
                }

            }
        }
        public void addSwitchModeListener()
        {
            this.getVueEDT().addSwitchModeListener(new SwitchModeListener(this));
        }
        
        class SwitchModeListener implements ActionListener{
            MainFrame mainframe;
            public SwitchModeListener (MainFrame mainframe) {
            this.mainframe = mainframe;
            }
            
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("OKKKKKKKKKKKKKKKKKKKK");
                
                //On affiche l'edt en liste
                this.mainframe.getContentPane().removeAll();
                
                
                
                this.mainframe.setTitle("Emploi du temps en liste");
                this.mainframe.setSize(1280, 750);
                
                if(this.mainframe.enseignant.Getdroit()==2)
                {
                    this.mainframe.vueEDTLigne= new VueEDTLigne(this.mainframe.enseignant,this.mainframe.liste_seances);
                }
                
                //si c'est 1 etudiant
                if(this.mainframe.etudiant.Getdroit()==3)
                {
                    this.mainframe.vueEDTLigne= new VueEDTLigne(this.mainframe.etudiant,this.mainframe.liste_seances);
                }
                

                this.mainframe.getContentPane().add(this.mainframe.vueEDTLigne);

                                    


            }
        }
        
        public void setListeSeances(ArrayList<Seance> liste_seances)
        {
            this.liste_seances=liste_seances;
        }
        public void setEnseignant(Enseignant enseignant)
        {
            this.enseignant=enseignant;
        }
        public void seEtudiant(Etudiant etudiant)
        {
            this.etudiant=etudiant;
        }
        public VueEDTLigne getVueEDTLigne()
        {
            return vueEDTLigne;
        }
        
        
}
