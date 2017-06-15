package ModuleConcepteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ActionBoutonInfoQuestionnaire  implements ActionListener {
	
	VueCreerQuestionnaire vue;
	
	public ActionBoutonInfoQuestionnaire(VueCreerQuestionnaire vue) {
		super();
		this.vue = vue;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (((JButton)arg0.getSource()).getText().equals("Annuler")){
			this.vue.afficherPagePrecedente();
		}else if (((JButton)arg0.getSource()).getText().equals("Suivant")){
			this.vue.afficherAjouterQuestion();
		}else if (((JButton)arg0.getSource()).getText().equals("Afficher les questions")){
			this.vue.afficherQuestionnaire();
		}else if (((JButton)arg0.getSource()).getText().equals("Ajouter la question")){
			this.vue.ajouterQuestionQuestionnaire();
		}else if (((JButton)arg0.getSource()).getText().equals("Terminer")){
			System.out.println("Terminer");
		}
	}
}
