
package vue;

/*
import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import static java.awt.PageAttributes.MediaType.C;
import javax.swing.JPanel;

public class TEST{

    
    public static void main(String[] args) 
    {
        
        JFrame frame = new JFrame();
        frame.setSize(1280, 750);
        frame.add(new Lafenetre());
        frame.setVisible(true);
        frame.setTitle("Fenêtre qui affiche du texte");
        
        
     
      
      
    }
    
}

*/

import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import static java.awt.PageAttributes.MediaType.C;
import java.util.ArrayList;
import javax.swing.JPanel;

public class TEST{

    
    public static void main(String[] args) 
    {
        
        JFrame frame = new JFrame();
        frame.setSize(1280, 750);
        frame.add(new Lafenetre());
        frame.setVisible(true);
        frame.setTitle("l'emploie du temps");
        
        //31 a 52 puis 1 a 28 pour les semaines
        // g.fillRect((int)(4+s*23.66),85,19,22);
      
            
           // ajout des boutons à la fenêtre                
           
           // positionnement et dimensionnement manuel des boutons
           
        //   b1.setBorderPainted(false);
          // b1.setContentAreaFilled(false);
        //   b1.setFocusPainted(false);
           
       //    b1.setBounds(4, 85, 19, 22);
         
           int s = 31;
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
               
 
           }
           
        
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
    }
    
}