package ModuleConnexion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Commun.ModeleCommun;

/**
 * Connexion est la classe principale du ModuleConnexion. 
 * Elle va nous servir de lien entre les vues de ce module
 * @author nathan
 */
public class Connexion extends JPanel {
	
	ModeleCommun modelecommun;
	ModeleConnexion modeleconnexion;
	VueConnexion vueco;
	VueInscription vuein;
	
	
	public Connexion (ModeleCommun mc) {
		super();
		this.setLayout(new BorderLayout());
		this.modelecommun = mc;
		this.modeleconnexion = new ModeleConnexion(this);
		afficherVueConnexion();
	}
	
	
	
	public void afficherVueConnexion() {
		removeAll();
		afficherPanelDuHaut();
		this.vueco = new VueConnexion(this);
		add(this.vueco, "Center");
		validate();
		repaint();
	}
	
	public void afficherVueInscription () {
		removeAll();
		afficherPanelDuHaut();
		this.vuein = new VueInscription (this);
		add(this.vuein, "Center");
		validate();
		repaint();
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
			Icon source = new ImageIcon("connexion.png");
			ImageIcon imageconnexion = new ImageIcon(((ImageIcon) source).getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT));
			labelImage.setIcon(imageconnexion);	
	}


}
