package ModuleConcepteur;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import BaseDeDonnees.Questionnaire;

public class ActBoutonAffichageQuestionnaire implements ActionListener {

	Concepteur concepteur;
	AffichageQuestionnaire vue;
	Questionnaire q;
	
	public ActBoutonAffichageQuestionnaire(Concepteur concepteur,AffichageQuestionnaire vue, Questionnaire q) {
		super();
		this.concepteur = concepteur;
		this.vue = vue;
		this.q = q;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (((JButton)arg0.getSource()).getText().equals("Retour")){
			this.concepteur.afficherConcepteur();
		}
		if (((JButton)arg0.getSource()).getText().equals("Modifier informations")){
			this.concepteur.afficherModifQuestionnaire(q);
		}
		if (((JButton)arg0.getSource()).getText().equals("Ajouter question")){
			this.concepteur.afficherAjouterQuestion(vue,q);
		}
		if (((JButton)arg0.getSource()).getText().equals("Supprimer questionnaire")){
			int box = JOptionPane.showConfirmDialog(
					((Component) concepteur.getParent()),
				    "Voulez-vous vraiment supprimer ce questionnaire ?",
				    "Supprimer le questionnaire",
				    JOptionPane.YES_NO_OPTION);
			if(box == JOptionPane.YES_OPTION){
				//Implémenter la suppression du questionnaire
				this.concepteur.afficherConcepteur();
			}
		}
	}

}
