package vue;


import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;


public class Lafenetre extends JPanel
{
    
    public Lafenetre()
    {
        
    }
      public void paint(Graphics g)
    {
       
        
        try {
    			Image img = ImageIO.read(new File("C:\\Users\\Ilan\\Desktop\\Wireframe java project\\emploie_du_temps_dim.jpg" ));
			g.drawImage(img, 0, 0, 1280, 720, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        AfficheSeance cour1 = new AfficheSeance(0,0,5,"caca","caca","caca0","caca");
        AfficheSeance cour2 = new AfficheSeance(1,0,5,"caca","caca","caca0","caca");
        AfficheSeance cour3 = new AfficheSeance(0,1,5,"caca","caca","caca0","caca");
        AfficheSeance cour4 = new AfficheSeance(3,3,5,"caca","caca","caca0","caca");
        
        cour1.DessinerSeance(g);
        cour2.DessinerSeance(g);
        cour3.DessinerSeance(g);
        cour4.DessinerSeance(g);
      
       
        
    }
   }