package vue;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VueConnect extends JPanel{
	
    Panel panel;
    JLabel email_label, password_label, message;
    JTextField email_text;
    JPasswordField password_text;
    JButton submit;

	public VueConnect()
	{
            /*
            setTitle("Connextion"); //On donne un titre à l'application
            setSize(320,240); //On donne une taille à notre fenêtre
            setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
            setResizable(true); //On permet le redimensionnement
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
            */
            
            
            
            
            setPreferredSize(new Dimension(1280, 750));
            setLayout(new GridLayout(10,10));
		
            // User Label
            email_label = new JLabel();
            email_label.setText("Email :");
            email_text = new JTextField();
        
             // Password

            password_label = new JLabel();
            password_label.setText("Password :");
            password_text = new JPasswordField();

            // Submit

            this.add(email_label);
            this.add(email_text);
            this.add(password_label);
            this.add(password_text);

            message = new JLabel();
            this.add(message);
            submit=new JButton();
            this.add(submit);
	}
    
    public JPasswordField getpassword_text()
    {
    	return password_text;
    }
    public JTextField getemail_text()
    {
    	return email_text;
    }
    public JLabel getmessage()
    {
    	return message;
    }
	
	public void addConnectListener(ActionListener listenForSubmit)
	{
		submit.addActionListener(listenForSubmit);
	}
	
	public void ErrorMessage(String errorMessage) {
		
		JOptionPane.showMessageDialog (this, errorMessage);
	}

}
