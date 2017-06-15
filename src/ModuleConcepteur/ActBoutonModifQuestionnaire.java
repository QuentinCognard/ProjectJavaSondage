package ModuleConcepteur;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ActBoutonModifQuestionnaire implements ActionListener {
	
	Concepteur concepteur;
	ModificationQuestionnaire vue;
	
	public ActBoutonModifQuestionnaire(Concepteur concepteur, ModificationQuestionnaire vue) {
		super();
		this.concepteur = concepteur;
		this.vue = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (((JButton)arg0.getSource()).getText().equals("Annuler")){
			this.concepteur.afficherInfoQuestionnaire(vue.getIdAnnuler(),vue.getNomAnnuler(),
					vue.getPanelAnnuler(),vue.getSocieteAnnuler(),vue.getTauxReponseAnnuler());
		}
		if (((JButton)arg0.getSource()).getText().equals("Sauvegarder")){
			//Implémenter la sauvegarde
			
			this.concepteur.afficherInfoQuestionnaire(vue.getId(),vue.getNom(),
					vue.getPanel(),vue.getSociete(),vue.getTauxReponse());
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
