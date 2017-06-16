package ModuleConcepteur;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import BaseDeDonnees.Questionnaire;

public class ActBoutonModifQuestionnaire implements ActionListener {
	
	Concepteur concepteur;
	ModificationQuestionnaire vue;
	Questionnaire q;
	
	public ActBoutonModifQuestionnaire(Concepteur concepteur, ModificationQuestionnaire vue,Questionnaire q) {
		super();
		this.concepteur = concepteur;
		this.vue = vue;
		this.q = q;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (((JButton)arg0.getSource()).getText().equals("Annuler")){
			this.concepteur.afficherInfoQuestionnaire(this.q);
		}
		if (((JButton)arg0.getSource()).getText().equals("Sauvegarder")){
			//Implémenter la sauvegarde
			
			this.concepteur.afficherInfoQuestionnaire(this.q);
		}
		if (((JButton)arg0.getSource()).getText().equals("X")){
			JOptionPane.showConfirmDialog(
					((Component) concepteur.getParent()),
				    "Voulez-vous vraiment supprimer cette question ?",
				    "Supprimer une question",
				    JOptionPane.YES_NO_OPTION);
			//get la réponse
		}
	}
}
