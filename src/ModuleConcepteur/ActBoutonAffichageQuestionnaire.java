package ModuleConcepteur;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import BaseDeDonnees.*;

public class ActBoutonAffichageQuestionnaire implements ActionListener {

	Concepteur concepteur;
	AffichageQuestionnaire vue;
	Questionnaire q;
	BDGeneral bd;
	
	public ActBoutonAffichageQuestionnaire(Concepteur concepteur,AffichageQuestionnaire vue,Questionnaire q,
			BDGeneral bd) {
		super();
		this.concepteur = concepteur;
		this.vue = vue;
		this.q = q;
		this.bd = bd;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (((JButton)arg0.getSource()).getText().equals("Retour")){
			this.concepteur.afficherConcepteur();
		}
		if (((JButton)arg0.getSource()).getText().equals("Modifier informations")){
			this.concepteur.afficherModifQuestionnaire(vue,q);
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
				this.bd.supprimerQuestionnaire(q.getIdQuestionnaire());
				this.concepteur.afficherConcepteur();
			}
		}
	}

}
