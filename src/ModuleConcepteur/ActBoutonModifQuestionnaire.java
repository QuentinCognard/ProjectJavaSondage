package ModuleConcepteur;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import BaseDeDonnees.*;

public class ActBoutonModifQuestionnaire implements ActionListener {
	
	Concepteur concepteur;
	ModificationQuestionnaire vue;
	Questionnaire q;
	BDModuleConcepteur bdc;
	
	public ActBoutonModifQuestionnaire(Concepteur concepteur, ModificationQuestionnaire vue,
			Questionnaire q,BDModuleConcepteur bdc) {
		super();
		this.concepteur = concepteur;
		this.vue = vue;
		this.q = q;
		this.bdc = bdc;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (((JButton)arg0.getSource()).getText().equals("Annuler")){
			this.concepteur.afficherInfoQuestionnaire(this.q);
		}
		if (((JButton)arg0.getSource()).getText().equals("Sauvegarder")){
			q.setTitreQuestionnaire(vue.getNom());
			bdc.modifierQuestionnaire(new Questionnaire(q.getIdQuestionnaire(),
					q.getTitreQuestionnaire(),q.getEtatQuestionnaire(),q.getNumClient(),
					q.getIdentifiantUtilisateur(),q.getIdentifiantPanel()));
			this.concepteur.afficherInfoQuestionnaire(this.q);
		}
	}
}
