package controleur;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import static java.awt.PageAttributes.MediaType.C;
import javax.swing.JPanel;
import vue.Lafenetre;


public class Run {
	
	public static void main(String [] args)
	{
		JFrame frame = new JFrame();
        frame.setSize(1280, 750);
        frame.add(new Lafenetre());
        frame.setVisible(true);
        frame.setTitle("Fenêtre qui affiche du texte");
	}
}
