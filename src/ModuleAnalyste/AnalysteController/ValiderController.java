package ModuleAnalyste.AnalysteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ModuleAnalyste.Analyste;
import ModuleAnalyste.AnalysteModele;
import ModuleAnalyste.AnalysteModification;

public class ValiderController implements ActionListener {
	private Analyste ana;
	private AnalysteModele anaModele;
	
	public ValiderController(Analyste a){
		super();
		this.ana = a;
		this.anaModele = a.getModeleAnalyste();
	}

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
