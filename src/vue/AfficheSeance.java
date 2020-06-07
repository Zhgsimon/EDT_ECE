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
    
    private int creneaux ;
    private int jour;
    private int semaine;
    
    private String cours;
    private String enseignant;
    private String promotion;
    private String salle;
    
    public AfficheSeance(int creneau,int jour,int semaine,String cours, String enseignant, String promotion, String salle){
        
        this.creneaux = creneau; // de 0 a 6
        this.jour = jour; // de 0 a 5
        this.semaine = semaine;// de 1 a 52
        
        this.cours = cours;
        this.enseignant = enseignant;
        this.promotion = promotion;
        this.salle = salle; 
        
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
            
            g.drawString(getcours(),(int) (36+206*getjour()), (int) (180+72*getcrenaux()));
            g.drawString(getenseignant(),(int) (36+206*getjour()), (int) (193+72*getcrenaux()));
            g.drawString(geta_c(),(int) (36+206*getjour()), (int) (206+72*getcrenaux()));
            g.drawString(getsalle(),(int) (36+206*getjour()), (int) (219+72*getcrenaux()));
        
        
        
    }
    private int getcrenaux()
    {
        return creneaux;
    }
    
    private int getjour()
    {
        return jour;
    }
    
    private String getcours()
    {
        return cours;
    }
    
    private String getenseignant()
    {
        return enseignant;
    }
    private String geta_c()
    {
        return promotion;
    }
    private String getsalle()
    {
        return salle;
    }
    
   
}