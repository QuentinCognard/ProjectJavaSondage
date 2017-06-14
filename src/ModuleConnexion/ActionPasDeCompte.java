package ModuleConnexion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionPasDeCompte implements MouseListener {
	
	Connexion connexion;
	
	public ActionPasDeCompte (Connexion c) {
		this.connexion = c;
	}
	
	// @Override
	public void mouseClicked(MouseEvent arg0) {
		this.connexion.afficherVueInscription();
	}

	// @Override
	public void mouseEntered(MouseEvent arg0) {
		this.connexion.vueco.getLabelInscription().setForeground(Color.red);
		this.connexion.vueco.getLabelInscription().setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	// @Override
	public void mouseExited(MouseEvent arg0) {
		this.connexion.vueco.getLabelInscription().setForeground(Color.blue);	
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



