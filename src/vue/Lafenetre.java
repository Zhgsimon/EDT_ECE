package vue;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;


public class Lafenetre extends JPanel
{
    
    public Lafenetre()
    {
        
    }
      public void paint(Graphics g)
    {
        
              
    
      
        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int h = (int)tailleEcran.getHeight();
        int w = (int)tailleEcran.getWidth();
        
        try {
    			Image img = ImageIO.read(new File("C:\\Users\\Ilan\\Desktop\\Wireframe java project\\emploie_du_temps_dim.jpg" ));
			g.drawImage(img, 0, 0, 1280, 720, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
      
        // alors ! les i c'est les heures de la journée, j les jours de la semaine 
        //i = 0 c'est le premier crénaux de la journé i = 6 le dernier
        //j = 0 c'est lundi , j = 5 c'est samedi
        
        
        
       for(int s=0;s<42;s++)
       {
           g.fillRect((int)(2),84,24,27);
       }
        
        

        for(int i=0;i<7;i++){
            
        
        
        for(int j=0;j<6;j++){
            
       Random rand = new Random();
       float R = (float) (rand.nextFloat() / 2f + 0.5);
       float G = (float) (rand.nextFloat() / 2f + 0.5);
       float B = (float) (rand.nextFloat() / 2f + 0.5);
       
            Color randomColor = new Color(R, G, B);
            g.setColor(randomColor);
            
            g.fillRect((int) (34+206*j), (int) (166+72*i),206,58);
          //   g.fillRect((int) (34+206*j),166,206,58);
            
            g.setColor(Color.BLACK); 
            g.drawString("Cour",(int) (36+206*j), (int) (180+72*i));
            g.drawString("prof",(int) (36+206*j), (int) (193+72*i));
            g.drawString("année/classe",(int) (36+206*j), (int) (206+72*i));
            g.drawString("salle",(int) (36+206*j), (int) (219+72*i));
            
            
            
        
                  
         
       
        
    }
   }

    }
   
       
}