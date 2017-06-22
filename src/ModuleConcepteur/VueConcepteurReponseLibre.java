/**
 * 
 */
package ModuleConcepteur;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author DAMIEN
 *
 */
public class VueConcepteurReponseLibre extends JPanel implements TypeReponse{
	
	VueConcepteurReponseLibre(){
		this.setPreferredSize(new Dimension(600,235));
	}

	public void majReponse() {
	}

	public JButton getJButton() {
		return null;
	}
	
	public int getNbMax(){
		return 0;
	}
	
	public ArrayList<String> getReponse(){
		return null;
	}
}
