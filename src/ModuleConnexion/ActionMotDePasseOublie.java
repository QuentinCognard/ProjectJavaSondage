package ModuleConnexion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

/**
 * ActionMotDePasseOublie est une classe qui va gerer le label "Mot de passe Oublie" dans la VueConnexion
 * @author nathan
 *
 */
public class ActionMotDePasseOublie implements MouseListener {
	/**
	 * La classe principale de ce module
	 * @see Connexion
	 */
	Connexion connexion;
	/**
	 * Constructeur
	 * @param c
	 */
	public ActionMotDePasseOublie (Connexion c) {
		this.connexion = c;
	}
	
	/**
	 * Va afficher une pop-up demandant une adresse email 
	 */
	public void mouseClicked(MouseEvent arg0) {
		String mail = JOptionPane.showInputDialog(this.connexion.vueco,"Entrez votre e-mail","Reinitialisation du mot de passe", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Va changer la couleur du JLabel et la forme du curseur quand l'utilisateur passe sur ce champ
	 */
	public void mouseEntered(MouseEvent arg0) {
		this.connexion.vueco.getLabelMotDePasseOublie().setForeground(Color.red);
		this.connexion.vueco.getLabelMotDePasseOublie().setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Redefinie a la normale la couleur du JLabel
	 */
	public void mouseExited(MouseEvent arg0) {
		this.connexion.vueco.getLabelMotDePasseOublie().setForeground(Color.blue);	
	}


	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
