package ModuleSondeur;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sondeur extends JPanel {
	
	public Sondeur () {
		super();
		
		afficherPanelDuHaut();
	}
	
	public void afficherPanelDuHaut () {
		JPanel panelduhaut = new JPanel();
		this.add(panelduhaut, "North");
		panelduhaut.setLayout(new BorderLayout());
		
		JPanel boiteImage = new JPanel ();
		panelduhaut.add(boiteImage,"Center");
			// creation de l'image
			JLabel labelImage = new JLabel ();
			boiteImage.add(labelImage);
			Icon source = new ImageIcon("sondeur.png");
			ImageIcon imageconnexion = new ImageIcon(((ImageIcon) source).getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT));
			labelImage.setIcon(imageconnexion);	
	}
}

