package ModuleConcepteur;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import BaseDeDonnees.*;

public class ActBoutonModifQuestionnaireSup implements ActionListener {
	
	Concepteur concepteur;
	ModificationQuestionnaire vue;
	Questionnaire q;
	BDModuleConcepteur bdc;
	Question qt;
	
	public ActBoutonModifQuestionnaireSup(Concepteur concepteur, ModificationQuestionnaire vue,
			Questionnaire q,BDModuleConcepteur bdc,Question qt) {
		super();
		this.concepteur = concepteur;
		this.vue = vue;
		this.q = q;
		this.bdc = bdc;
		this.qt = qt;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (((JButton)arg0.getSource()).getText().equals("X")){
			int msgbox = JOptionPane.showConfirmDialog(
					((Component) concepteur.getParent()),
				    "Voulez-vous vraiment supprimer cette question ?",
				    "Supprimer une question",
				    JOptionPane.YES_NO_OPTION);
			if(msgbox == JOptionPane.YES_OPTION){
				this.bdc.supprimerQuestion(q.getIdQuestionnaire(),qt.getNumeroQuestion());
				this.vue.majAffichage();
			}
		}
	}
}
