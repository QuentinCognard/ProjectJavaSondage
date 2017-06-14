package Commun;
import java.awt.Container;
import javax.swing.JFrame;

import ModuleAnalyste.Analyste;
import ModuleConcepteur.Concepteur;
import ModuleConnexion.Connexion;
import ModuleSondeur.Sondeur;

public class Sondio extends JFrame {

	Container cont;
	
	ModeleCommun modelecommun;
	
	Connexion modconnexion;
	Concepteur modconcepteur;
	Sondeur modsondeur;
	Analyste modanalyste;
	
	public Sondio () {
		super("Application de sondage : Sondio");
		this.setSize(1000,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.cont = this.getContentPane();
		afficherConnexion();
		this.setVisible(true);
	}
	
	public void afficherConnexion () {
		this.cont.removeAll();
		
		this.modelecommun = new ModeleCommun (this);
		this.modconnexion = new Connexion (this.modelecommun);
		this.cont.add(modconnexion);
		
		this.cont.validate();
		this.cont.repaint();		
	}
	
	public void afficherConcepteur () {
		this.cont.removeAll();
		
		this.modconcepteur = new Concepteur ();
		this.cont.add(modconcepteur);
		
		this.cont.validate();
		this.cont.repaint();
	}

	public void afficherSondeur () {
		this.cont.removeAll();
		
		this.modsondeur = new Sondeur ();
		this.cont.add(modsondeur);
		
		this.cont.validate();
		this.cont.repaint();
	}
	
	public void afficherAnalyste () {
		this.cont.removeAll();
		
		this.modanalyste = new Analyste ();
		this.cont.add(modanalyste);
		
		this.cont.validate();
		this.cont.repaint();
	}

	public static void main (String [] args) {
		Sondio s = new Sondio ();
	}



}
