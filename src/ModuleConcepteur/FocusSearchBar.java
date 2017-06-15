package ModuleConcepteur;

import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;



public class FocusSearchBar implements FocusListener{
	JTextField champ;
	
	public FocusSearchBar(JTextField champ){
		super();
		this.champ = champ;
	}
	public void focusGained(FocusEvent arg0){
		String entree = this.champ.getText();
		if(entree.equals("search")){
			this.champ.setText("");
		}
	}
	public void focusLost(FocusEvent arg0){
		String entree = this.champ.getText();
		if(entree.equals("")){
			this.champ.setText("search");
		}
	}
}
