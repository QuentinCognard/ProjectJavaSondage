package ModuleAnalyste.AnalysteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ModuleAnalyste.Analyste;
import ModuleAnalyste.AnalysteModele;
import ModuleAnalyste.AnalysteModification;

/**
 * ValiderController est une classe (controller) qui gère le bouton valider du panel de base
 * @author Julien Revaud
 *
 */

public class ValiderController implements ActionListener {
	
	/**
	 * La classe (vue) de base du module analyste
	 */
	private Analyste ana;
	
	/**
	 * Le modele du module analyste
	 */
	private AnalysteModele anaModele;
	
	/**
	   * cré la classe controller
	   * @param a
	   * 	 la classe analyste
	   */
	public ValiderController(Analyste a){
		super();
		this.ana = a;
		this.anaModele = a.getModeleAnalyste();
	}
	
	/**
	   * charge la vue suivante lors du clique sur le bouton valider
	   * @param e
	   * 	 l'ActioEvent qui permet de retrouver quel bouton a été cliqué
	   */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (ana.getTableau().getSelectedRow() == -1)
			JOptionPane.showMessageDialog(ana,"Aucune ligne selectionnée","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
		else{
			/*TODO: charger la page AnalysteModification avec le questionnaire appropri� en allant
			 * le chercher dans la BD
			 */
			int idQuestionnaire = Integer.parseInt((String) ana.getTableau().getValueAt(ana.getTableau().getSelectedRow(), 0));
			anaModele.createListesQuestions(idQuestionnaire);
			anaModele.createListesQuestionsValPossible(idQuestionnaire);
			anaModele.createListesQuestionsReponses(idQuestionnaire);
			anaModele.createListeTranchesPresentes(idQuestionnaire);
			anaModele.createListeCategoriesPresentes(idQuestionnaire);
			ana.afficherAnalysteModification();
		}
	}

}
