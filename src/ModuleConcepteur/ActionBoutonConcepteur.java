package ModuleConcepteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ActionBoutonConcepteur implements ActionListener {

	Concepteur concepteur;
	
	public ActionBoutonConcepteur(Concepteur concepteur) {
		super();
		this.concepteur = concepteur;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (((JButton)arg0.getSource()).getText().equals("Créer questionnaire")){
			this.concepteur.afficherCreerQuestionnaire();
		}
	}
}
