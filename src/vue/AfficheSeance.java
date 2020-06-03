/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
        

public class AfficheSeance {
    
    private int crenaux ;
    private int jour;
    private int semaine;
    
    private String matiere;
    private String prof;
    private String année_class;
    private String salle;
    
    public AfficheSeance(int i,int j,int se,String m, String p, String a_c, String s){
        
        crenaux = i; // de 0 a 6
        jour = j; // de 0 a 5
        semaine = se;// de 1 a 52
        
        matiere = m;
        prof = p;
        année_class = a_c;
        salle = s; 
        
    }
     public void DessinerSeance(Graphics g) 
    {
        Random rand = new Random();
            float R = (float) (rand.nextFloat() / 2f + 0.5);
            float G = (float) (rand.nextFloat() / 2f + 0.5);
            float B = (float) (rand.nextFloat() / 2f + 0.5);
       
            Color randomColor = new Color(R, G, B);
            g.setColor(randomColor);
            
            g.fillRect((int) (34+206*getjour()), (int) (166+72*getcrenaux()),206,58);
            g.setColor(Color.BLACK); 
            
            g.drawString(getmatiere(),(int) (36+206*getjour()), (int) (180+72*getcrenaux()));
            g.drawString(getprof(),(int) (36+206*getjour()), (int) (193+72*getcrenaux()));
            g.drawString(geta_c(),(int) (36+206*getjour()), (int) (206+72*getcrenaux()));
            g.drawString(getsalle(),(int) (36+206*getjour()), (int) (219+72*getcrenaux()));
        
        
        
    }
    private int getcrenaux()
    {
        return crenaux;
    }
    
    private int getjour()
    {
        return jour;
    }
    
    private String getmatiere()
    {
        return matiere;
    }
    
    private String getprof()
    {
        return prof;
    }
    private String geta_c()
    {
        return année_class;
    }
    private String getsalle()
    {
        return salle;
    }
    
   
}