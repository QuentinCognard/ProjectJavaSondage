package ModuleConcepteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

public class ActionRadioBoutonAjouterQuestion implements ActionListener {
	VuePanelAjouterQuestion vue;
	
	ActionRadioBoutonAjouterQuestion(VuePanelAjouterQuestion vue){
		this.vue = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (((JRadioButton)arg0.getSource()).getText().equals("Choix simple")){
			this.vue.afficherSimple();
		}else if (((JRadioButton)arg0.getSource()).getText().equals("Choix multiple")){
			this.vue.afficherMultiple();
		}else if (((JRadioButton)arg0.getSource()).getText().equals("Classement")){
			this.vue.afficherClassement();
		}else if (((JRadioButton)arg0.getSource()).getText().equals("Note")){
			this.vue.afficherNote();
		}else if (((JRadioButton)arg0.getSource()).getText().equals("Réponse libre")){
			this.vue.afficherLibre();
		}
	}
}
