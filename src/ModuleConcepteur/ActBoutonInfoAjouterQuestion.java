package ModuleConcepteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import BaseDeDonnees.Questionnaire;

public class ActBoutonInfoAjouterQuestion  implements ActionListener {
	Concepteur c;
	VueAjouterQuestion vue;
	AffichageQuestionnaire vueQuestionnaire;
	Questionnaire q;
	
	public ActBoutonInfoAjouterQuestion(Concepteur c,VueAjouterQuestion vue,
			AffichageQuestionnaire vueQuestionnaire,Questionnaire q) {
		super();
		this.c = c;
		this.vue = vue;
		this.vueQuestionnaire = vueQuestionnaire;
		this.q = q;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (((JButton)arg0.getSource()).getText().equals("Annuler")){
			c.afficherInfoQuestionnaire(this.q);
		}
		if (((JButton)arg0.getSource()).getText().equals("Créer")){
			c.afficherInfoQuestionnaire(this.q);
			//Implémenter l'ajout d'une question
		}
	}
}
