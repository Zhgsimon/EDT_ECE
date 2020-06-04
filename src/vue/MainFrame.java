package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {
	private VueConnect vueConnect;
        
	
	public MainFrame (String titre)
	{
		super(titre);
		
		this.setSize(1280, 750);
		
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

}
