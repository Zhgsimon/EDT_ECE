/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
/**
 *
 * @author zhgsi
 */
public class VueEDT extends JPanel{
    
    public VueEDT(Graphics g)
    {
        //On affiche le background
        try {
                Image img = ImageIO.read(new File("C:\\Users\\Ilan\\Desktop\\Wireframe java project\\emploie_du_temps_dim.jpg" ));
                //URL url = getClass().getResource("emploie_du_temps_dim.jpg");
                //File file = new File(url.getPath());
               // Image img = ImageIO.read(file);
		g.drawImage(img, 0, 0, 1280, 720, this);
	} 
        catch (IOException e) 
        {
            e.printStackTrace();
	}
    }
    
    
    public void paint(Graphics g)
    {
       
        
        try {
                Image img = ImageIO.read(new File("C:\\Users\\Ilan\\Desktop\\Wireframe java project\\emploie_du_temps_dim.jpg" ));
		g.drawImage(img, 0, 0, 1280, 720, this);
	} 
        catch (IOException e) 
        {
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
