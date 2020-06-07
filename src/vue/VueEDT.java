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
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import modele.*;
/**
 *
 * @author zhgsi
 */
public class VueEDT extends JPanel{
    private ArrayList<Integer> creneaux ;
    private ArrayList<Integer> jour;
    private ArrayList<Integer> semaine;
    
    private ArrayList<String> cours;
    private ArrayList<String> type_cours;
    
    private ArrayList<ArrayList<String>> liste_enseignants;
    private String promotion;
    private ArrayList<ArrayList<String>> liste_groupes;
    private ArrayList<ArrayList<String>> liste_salles;
    /*this.creneaux = creneau; // de 0 a 6
        this.jour = jour; // de 0 a 5
        this.semaine = semaine;// de 1 a 52
        
        this.cours = cours;
        this.enseignant = enseignant;
        this.promotion = promotion;
        this.salle = salle;
*/
    private Etudiant etudiant;
    private Enseignant enseignant;
    private ArrayList<Seance>liste_seances;
    
    public VueEDT(Etudiant etudiant, ArrayList<Seance> liste_seances){
        this.etudiant=etudiant;
        this.liste_seances=liste_seances;

    }
    public VueEDT(Enseignant enseignant, ArrayList<Seance>liste_seances){
        this.enseignant=enseignant;
        this.liste_seances=liste_seances;
    }


    public void paint(Graphics g)
    {
       super.paintComponent(g);
       this.setBackground(Color.WHITE);
        try {
                URL url = this.getClass().getResource("emploie_du_temps_dim.jpg");
                File file = new File(url.getPath());                
                Image img = ImageIO.read(file);
                //System.out.println("Width: "+img.getWidth(this));

		g.drawImage(img, 0, 0, 1280, 720, this);
	} 
        catch (IOException e) 
        {
            e.printStackTrace();
	}
        //On Dessine chaque seance
        try {
            //AfficheSeance cour4 = new AfficheSeance(3,3,5,"caca","caca","caca0","caca");
            
            this.DessinerSeance(g);
            //cour4.DessinerSeance(g);
        } catch (ParseException ex) {
            Logger.getLogger(VueEDT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void DessinerSeance(Graphics g) throws ParseException 
    {
            // Pour chaque seance
            for (int i=0; i<this.liste_seances.size();i++)
            {
                //On choisit une nouvelle couleur
                Random rand = new Random();
                float R = (float) (rand.nextFloat() / 2f + 0.5);
                float G = (float) (rand.nextFloat() / 2f + 0.5);
                float B = (float) (rand.nextFloat() / 2f + 0.5);
                Color randomColor = new Color(R, G, B);
                g.setColor(randomColor);
                //On détermine son créneaux horaire
                System.out.println("Heure debut: "+this.liste_seances.get(i).Getheure_debut().toString());
                int creneaux=0;
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("08:30"))
                {
                    creneaux=0;
                }
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("10:15"))
                {
                    creneaux=1;
                }
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("12:00"))
                {
                    creneaux=2;
                }
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("13:45"))
                {
                    creneaux=3;
                }
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("15:30"))
                {
                    creneaux=4;
                }
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("17:15"))
                {
                    creneaux=5;
                }
                if(this.liste_seances.get(i).Getheure_debut().toString().equals("19:00"))
                {
                    creneaux=6;
                }
                //On recupère son jour
                 System.out.println("Date:"+this.liste_seances.get(i).Getdate_seance().toString());
                Calendar c = Calendar.getInstance(Locale.FRANCE);
                
                c.setTime(new SimpleDateFormat("yyy-M-dd").parse(this.liste_seances.get(i).Getdate_seance().toString()));
                int jour = c.get(Calendar.DAY_OF_WEEK)-1;
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
                g.fillRect((int) (33+205*jour), (int) (156+72*creneaux),206,58);
                g.setColor(Color.BLACK);
                g.drawString(cours,(int) (36+206*jour), (int) (180+72*creneaux));
                g.drawString(type_cours,(int) (36+206*jour), (int) (193+72*creneaux));
                
                
                //pour chaque groupe concerne
                ArrayList<Groupe> liste_groupes=liste_seances.get(i).Getliste_groupes();
                for(int j=0;j<liste_groupes.size();j++)
                {
                    g.drawString(liste_groupes.get(j).Getnom(),(int) (135+206*jour+32*j), (int) (193+72*creneaux));
                }
                
                
                ArrayList<Enseignant> liste_enseignants=liste_seances.get(i).Getliste_enseignants();
                //pour chaque enseignant affecte        
                for(int j=0; j<liste_enseignants.size(); j++)
                {
                    g.drawString(liste_enseignants.get(j).Getnom(),(int) (135+206*jour+32*j), (int) (180+72*creneaux));
                }
                ArrayList<Salle> liste_salles=liste_seances.get(i).Getliste_salles();
                //pour chaque salle affecte
                for(int j=0; j<liste_salles.size(); j++)
                {
                    g.drawString(liste_salles.get(j).Getnom(),(int) (60+206*jour+32*j), (int) (205+72*creneaux));
                }
                /*g.drawString(getenseignant(),(int) (36+206*getjour()), (int) (193+72*getcrenaux()));
                g.drawString(geta_c(),(int) (36+206*getjour()), (int) (206+72*getcrenaux()));
                g.drawString(getsalle(),(int) (36+206*getjour()), (int) (219+72*getcrenaux()));*/
            }
            
       
            
            
            //g.fillRect((int) (34+206*this.jour), (int) (166+72*this.creneaux),206,58);
            g.setColor(Color.BLACK); 
            
            //g.drawString(getcours(),(int) (36+206*getjour()), (int) (180+72*getcrenaux()));
            //g.drawString(getenseignant(),(int) (36+206*getjour()), (int) (193+72*getcrenaux()));
            //g.drawString(geta_c(),(int) (36+206*getjour()), (int) (206+72*getcrenaux()));
            //g.drawString(getsalle(),(int) (36+206*getjour()), (int) (219+72*getcrenaux()));
        
        
        
    }
    /*public int getcrenaux()
    {
        return creneaux;
    }
    
    public int getjour()
    {
        return jour;
    }
    public int getsemaine()
    {
        return semaine;
    }
    
    
    
    public String getcours()
    {
        return cours;
    }
    public String typecours()
    {
        return type_cours;
    }
    public ArrayList<String> getenseignant()
    {
        return liste_enseignants;
    }
    public ArrayList<String> getgroupe(){
        return liste_groupes;
    }
    public String getpromotion()
    {
        return promotion;
    }
    public ArrayList<String> getsalle()
    {
        return liste_salles;
    }
    
    
    
    
    
    
    
    //SETTERS
    
    public void setcrenaux(int creneaux)
    {
        this.creneaux=creneaux;
    }
    
    public void setjour(int jour)
    {
         this.jour=jour;
    }
    public void setsemaine(int semaine)
    {
        this.semaine=semaine;
    }
    
    public void setcours(String cours)
    {
        this.cours=cours;
    }
    public void settypecours(String type_cours)
    {
        this.type_cours=type_cours;
    }
    
    public void setenseignant(ArrayList<String>liste_enseignants)
    {
        this.liste_enseignants=liste_enseignants;
    }
    public void setpromotion(String promotion)
    {
        this.promotion=promotion;
    }
    public void setsalle(ArrayList<String>liste_salle)
    {
        this.liste_salles=liste_salles;
    }
    public void setgroupes(ArrayList<String>liste_groupes)
    {
        this.liste_groupes=liste_groupes;
    }*/
    
}
