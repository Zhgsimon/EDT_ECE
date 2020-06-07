/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import modele.Enseignant;
import modele.Etudiant;
import modele.Groupe;
import modele.Salle;
import modele.Seance;

/**
 *
 * @author zhgsi
 */
public class VueEDTLigne extends JPanel{
    private JButton switchmode;
    private Etudiant etudiant;
    private Enseignant enseignant;
    private ArrayList<Seance>liste_seances;
    
    public VueEDTLigne(Etudiant etudiant, ArrayList<Seance> liste_seances){
        this.etudiant=etudiant;
        this.liste_seances=liste_seances;

    }
    public VueEDTLigne(Enseignant enseignant, ArrayList<Seance>liste_seances){
        this.enseignant=enseignant;
        this.liste_seances=liste_seances;
    }
    
    public void paint(Graphics g)
    {
        try {
                URL url = this.getClass().getResource("white.png");
                File file = new File(url.getPath());                
                Image img = ImageIO.read(file);
                
                switchmode= new JButton("Passer à la vue en grille");
                switchmode.setBounds(128, 115,200 ,20);
                switchmode.setVisible(true);
                this.add(switchmode);

		g.drawImage(img, 0, 0, 1280, 720, this);
                
                
        }
        catch (IOException e) 
        {
            e.printStackTrace();
	}
        //On Dessine chaque seance
        try {           
            this.DessinerSeance(g);
        } catch (ParseException ex) {
            Logger.getLogger(VueEDT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public void DessinerSeance(Graphics g) throws ParseException 
    {
            Color lightgrey = new Color(220,220,220);
             g.setColor(lightgrey);
             g.fillRect(50,50,1170,650);
             
             g.setColor(Color.BLACK);
             
             
            // Pour chaque seance
            for (int i=0; i<this.liste_seances.size();i++)
            {
                //on détermine la semaine de la seance
                
                
                
                //On détermine son créneaux horaire
                System.out.println("Heure debut: "+this.liste_seances.get(i).Getheure_debut().toString());
                String jour_string = "???";
                String creneaux = "???";
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("08:30"))
                {
                    creneaux="8h30-10h";;
                }
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("10:15"))
                {
                    creneaux="10h15-11h45";;
                }
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("12:00"))
                {
                    creneaux="12h-13h30";;
                }
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("13:45"))
                {
                    creneaux="13h45-15h15";;
                }
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("15:30"))
                {
                    creneaux="15h30-17h";;
                }
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("17:15"))
                {
                    creneaux="17h15-18h45";;
                }
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("19:00"))
                {
                    creneaux="19h-20h30";;
                }
                //On recupère son jour          
                System.out.println("Date:"+this.liste_seances.get(i).Getdate_seance().toString());
                Calendar c = Calendar.getInstance(Locale.FRANCE);
                
                c.setTime(new SimpleDateFormat("yyy-M-dd").parse(this.liste_seances.get(i).Getdate_seance().toString()));
                int jour = c.get(Calendar.DAY_OF_WEEK)-1;
                
                if(jour==0)
                {
                    jour_string="Lundi";;
                }
                if(jour==1)
                {
                    jour_string="Mardi";;
                }
                if(jour==2)
                {
                    jour_string="Mercredi";;
                }
                if(jour==3)
                {
                    jour_string="Jeudi";;
                }
                if(jour==4)
                {
                    jour_string="Vendredi";;
                }
                if(jour==5)
                {
                    jour_string="Samedi";;
                }
                System.out.println("Jour: "+jour);
                System.out.println("Creneau: "+ creneaux);
                //sa semaine
                int semaine=c.get(Calendar.WEEK_OF_YEAR);
                System.out.println("Semaine: "+semaine);
                //le cours
                String cours;
                cours=this.liste_seances.get(i).Getcours().Getnom();
                System.out.println("Cours: "+cours);
                String type_cours=this.liste_seances.get(i).Gettype_cours();
                System.out.println("Type Cours"+type_cours);
                
                
                
                
                
                g.drawString(jour_string, 60, 65+i*40);
                g.drawString(creneaux, 260,65+i*40);
                g.drawString(liste_seances.get(i).Getcours().Getnom(), 460, 65+i*40);
                g.drawString(liste_seances.get(i).Gettype_cours(), 660, 65+i*40);
                
                
                //pour chaque groupe concerne
                    ArrayList<Groupe> liste_groupes=liste_seances.get(i).Getliste_groupes();
                    for(int j=0;j<liste_groupes.size();j++)
                    {
                        g.drawString(liste_groupes.get(j).Getnom(),(int) (860+35*j), (int) (65+i*40));
                    }


                    ArrayList<Enseignant> liste_enseignants=liste_seances.get(i).Getliste_enseignants();
                    //pour chaque enseignant affecte        
                    for(int j=0; j<liste_enseignants.size(); j++)
                    {
                        g.drawString(liste_enseignants.get(j).Getnom(),(int) (1060+35*j), (int) (65+i*40));
                    }
                    ArrayList<Salle> liste_salles=liste_seances.get(i).Getliste_salles();
                    //pour chaque salle affecte
                    for(int j=0; j<liste_salles.size(); j++)
                    {
                        g.drawString(liste_salles.get(j).Getnom(),(int) (1260+35*j), (int) (65+i*40));
                    }
                /*
                g.drawString(liste_seances.get(i).getprof(), 660, 65+i*40);
                g.drawString(liste_seances.get(i).geta_c(), 860, 65+i*40);
                g.drawString(liste_seances.get(i).getsalle(), 1060, 65+i*40);*/
                
                    
                

            }
            
       
            g.setColor(Color.BLACK); 

     
    }
    
}
