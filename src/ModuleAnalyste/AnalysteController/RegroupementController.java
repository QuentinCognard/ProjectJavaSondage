package ModuleAnalyste.AnalysteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import BaseDeDonnees.Question;
import ModuleAnalyste.Analyste;

public class RegroupementController implements ActionListener {
	
	private Analyste ana;
	
	public RegroupementController(Analyste ana){
		super();
		this.ana = ana;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(((JComboBox)arg0.getSource()).getSelectedItem());
		System.out.println(((JComboBox)arg0.getSource()).getName());
		String regroupement = (String) ((JComboBox)arg0.getSource()).getSelectedItem();
		int numQuest = Integer.parseInt(((JComboBox)arg0.getSource()).getName());
		DefaultTableModel modele = ana.getModeleAnalyste().createTableModel(regroupement, numQuest);
		ana.getAnalysteModification().majTab(modele, numQuest);

	}

}
