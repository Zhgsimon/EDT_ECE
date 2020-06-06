package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import vue.*;

import javax.swing.*;

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
        
        public void addVueEDT(){
            this.setTitle("Emploi du temps");
            Graphics g = null;
            VueEDT vueEDT= new VueEDT(g);
            this.getContentPane().add(vueEDT);
        } 
        
        /*public VueEDT getVueEDT(){
            this.setTitle("Emploi du temps");
            VueEDT vueEDT= new VueEDT();
            
            return vueEDT;
        }*/

}
