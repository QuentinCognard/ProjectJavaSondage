package ModuleConcepteur;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;


public class MouseListenerQuestionnaire implements MouseListener{
	Concepteur c;
	JPanel panel;
	MouseListenerQuestionnaire(Concepteur c,JPanel panel){
		this.c = c;
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		c.afficherInfoQuestionnaire("7","Le questionnaire de Babouche","-50 ans","Société couckecouckecoucke","80%");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		panel.setBackground(Color.WHITE);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		panel.setBackground(null);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
}
