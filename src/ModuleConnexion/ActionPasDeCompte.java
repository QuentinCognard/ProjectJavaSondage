package ModuleConnexion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * ActionPasDeCompte est une classe qui va gerer le label "Vous n'avez pas de compte ? Creez en un" dans la VueConnexion
 * @author nathan
 *
 */
public class ActionPasDeCompte implements MouseListener {
	/**
	 * La classe principale de ce module
	 * @see Connexion
	 */
	Connexion connexion;
	/**
	 * Constructeur
	 * @param c
	 */
	public ActionPasDeCompte (Connexion c) {
		this.connexion = c;
	}
	
	/**
	 * Change la vue de la fenetre
	 */
	public void mouseClicked(MouseEvent arg0) {
		this.connexion.afficherVueInscription();
	}

	/**
	 * Va changer la couleur du JLabel et la forme du curseur quand l'utilisateur passe sur ce champ
	 */
	public void mouseEntered(MouseEvent arg0) {
		this.connexion.vueco.getLabelInscription().setForeground(Color.red);
		this.connexion.vueco.getLabelInscription().setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Redefinie a la normale la couleur du JLabel
	 */
	public void mouseExited(MouseEvent arg0) {
		this.connexion.vueco.getLabelInscription().setForeground(Color.blue);	
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}



