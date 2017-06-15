package ModuleConcepteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ActBoutonInfoAjouterQuestion  implements ActionListener {
	Concepteur c;
	VueAjouterQuestion vue;
	AffichageQuestionnaire vueQuestionnaire;
	
	public ActBoutonInfoAjouterQuestion(Concepteur c,VueAjouterQuestion vue,AffichageQuestionnaire vueQuestionnaire) {
		super();
		this.c = c;
		this.vue = vue;
		this.vueQuestionnaire = vueQuestionnaire;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (((JButton)arg0.getSource()).getText().equals("Annuler")){
			c.afficherInfoQuestionnaire(vueQuestionnaire.getId(),vueQuestionnaire.getNom(),vueQuestionnaire.getPanel(),
					vueQuestionnaire.getSociete(),vueQuestionnaire.getTauxReponse());
		}
		if (((JButton)arg0.getSource()).getText().equals("Créer")){
			c.afficherInfoQuestionnaire(vueQuestionnaire.getId(),vueQuestionnaire.getNom(),vueQuestionnaire.getPanel(),
					vueQuestionnaire.getSociete(),vueQuestionnaire.getTauxReponse());
			//Implémenter l'ajout d'une question
		}
	}
}
