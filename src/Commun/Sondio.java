package Commun;

import java.awt.Container;
import javax.swing.JFrame;
import ModuleAnalyste.Analyste;
import ModuleConcepteur.Concepteur;
import ModuleConnexion.Connexion;
import ModuleSondeur.Sondeur;
/**
 * Sondio est la classe de la JFrame principale
 * @author nathan
 *
 */
public class Sondio extends JFrame {
	/**
	 * Le container principal
	 */
	Container cont;
	/**
	 * Le modele commun
	 * @see ModeleCommun
	 */
	ModeleCommun modelecommun;
	/**
	 * La vue du module Connexion
	 * @see Connexion
	 */
	Connexion modconnexion;
	/**
	 * La vue du module Concepteur
	 * @see Concepteur
	 */
	Concepteur modconcepteur;
	/**
	 * La vue du module Sondeur
	 * @see Sondeur
	 */
	Sondeur modsondeur;
	/**
	 * La vue du module Analyste
	 * @see Analyste
	 */
	Analyste modanalyste;
	
	/**
	 * Constructeur
	 * Initialise avec le module Connexion
	 */
	public Sondio () {
		super("Application de sondage : Sondio");
		this.setSize(1000,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.cont = this.getContentPane();
		afficherConnexion();
		this.setVisible(true);
	}
	
	/**
	 * Affiche le module Connexion
	 */
	public void afficherConnexion () {
		this.cont.removeAll();
		
		this.modelecommun = new ModeleCommun (this);
		this.modconnexion = new Connexion (this.modelecommun);
		this.cont.add(modconnexion);
		
		this.cont.validate();
		this.cont.repaint();		
	}
	
	/**
	 * Affiche le module Concepteur
	 */
	public void afficherConcepteur () {
		this.cont.removeAll();
		
		this.modconcepteur = new Concepteur(modelecommun);
		this.cont.add(modconcepteur);
		
		this.cont.validate();
		this.cont.repaint();
	}

	/**
	 * Affiche le module Sondeur
	 */
	public void afficherSondeur () {
		this.cont.removeAll();
		
		this.modsondeur = new Sondeur (modelecommun);
		this.cont.add(modsondeur);
		
		this.cont.validate();
		this.cont.repaint();
	}
	
	/**
	 * Affiche le module Analyste
	 */
	public void afficherAnalyste () {
		this.cont.removeAll();
		
		this.modanalyste = new Analyste (modelecommun);
		this.cont.add(modanalyste);
		
		this.cont.validate();
		this.cont.repaint();
	}
	
	/**
	 * Lacement de l'appli
	 * @param args
	 */
	public static void main (String [] args) {
		Sondio s = new Sondio ();
	}
}