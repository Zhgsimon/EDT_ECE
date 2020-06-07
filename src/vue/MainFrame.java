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
	
	
	public VueConnect getvueConnect()
	{
		return this.vueConnect;
	}
        
        public void addVueEDT(Etudiant etudiant, ArrayList<Seance> liste_seances){
            this.setTitle("Emploi du temps");
            this.setSize(1280, 750);
            VueEDT vueEDT= new VueEDT(etudiant,liste_seances);
            this.getContentPane().add(vueEDT);
        }
        public void addVueEDT(Enseignant enseignant, ArrayList<Seance> liste_seances){
            this.setTitle("Emploi du temps");
            this.setSize(1280, 750);
            
            VueEDT vueEDT= new VueEDT(enseignant,liste_seances);
            
            this.getContentPane().add(vueEDT);
        } 

}
