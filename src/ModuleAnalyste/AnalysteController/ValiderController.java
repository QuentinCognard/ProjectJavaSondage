package ModuleAnalyste.AnalysteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ModuleAnalyste.Analyste;
import ModuleAnalyste.AnalysteModification;

public class ValiderController implements ActionListener {
	Analyste ana;
	
	public ValiderController(Analyste a){
		super();
		this.ana = a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (ana.getTableau().getSelectedRow() == -1)
			JOptionPane.showMessageDialog(ana,"Aucune ligne selectionner","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
		else{
			/*TODO: charger la page AnalysteModification avec le questionnaire appropri� en allant
			 * le chercher dans la BD
			 */
			ana.afficherAnalysteModification();
		}
	}

}
