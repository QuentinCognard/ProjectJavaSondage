package ModuleConnexion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;


public class ActionMotDePasseOublie implements MouseListener {
	
	Connexion connexion;
	
	public ActionMotDePasseOublie (Connexion c) {
		this.connexion = c;
	}
	
	// @Override
	public void mouseClicked(MouseEvent arg0) {
		String mail = JOptionPane.showInputDialog(this.connexion.vueco,"Entrez votre e-mail","Reinitialisation du mot de passe", JOptionPane.INFORMATION_MESSAGE);
	}

	// @Override
	public void mouseEntered(MouseEvent arg0) {
		this.connexion.vueco.getLabelMotDePasseOublie().setForeground(Color.red);
		this.connexion.vueco.getLabelMotDePasseOublie().setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	// @Override
	public void mouseExited(MouseEvent arg0) {
		this.connexion.vueco.getLabelMotDePasseOublie().setForeground(Color.blue);	
	}

	// @Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	// @Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
