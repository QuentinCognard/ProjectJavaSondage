package ModuleAnalyste.AnalysteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

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
		//TODO : on peut rajouter un if pour ne mettre à jour que la vue directe et rajouter un listener sur le tabbedPane quand on change de vue
		//MAJ du tableau
		DefaultTableModel modele = ana.getModeleAnalyste().createTableModel(regroupement, numQuest);
		ana.getAnalysteModification().majTab(modele, numQuest);
		//MAJ du camembert
		DefaultPieDataset data = ana.getModeleAnalyste().createPieChartData(regroupement,numQuest);
		ana.getAnalysteModification().majPieChart(data, numQuest);
		//MAJ du diag. en bar
		DefaultCategoryDataset dataset = ana.getModeleAnalyste().createBarChartData(regroupement, numQuest);
		ana.getAnalysteModification().majBarChart(dataset, numQuest);

	}

}
