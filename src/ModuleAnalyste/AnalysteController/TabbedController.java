package ModuleAnalyste.AnalysteController;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ModuleAnalyste.Analyste;

public class TabbedController implements ChangeListener {
	
	private Analyste ana;
	
	public TabbedController(Analyste ana) {
		super();
		this.ana = ana;
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		JTabbedPane tabGeneral = ((JTabbedPane)arg0.getSource());
		int tabIndex = tabGeneral.getSelectedIndex();
		String tabName = tabGeneral.getTitleAt(tabIndex);
		System.out.println(tabName);
		for (JComboBox<String> br : ana.getAnalysteModification().getListeBoutonsRegroupement())
		{
			if (tabGeneral.getName().equals(br.getName()))
			{
				if (tabName.equals("Camembert"))
					br.setEnabled(false);
				else if (tabName.equals("Bar"))
				{
					br.setEnabled(true);
					if (br.getItemCount() == 2)
						br.addItem("Reponses donnees");
				}
				else
				{
					br.setEnabled(true);
					if (br.getItemCount() == 3)
						br.removeItemAt(2); //on sup le 3ème qui a pour indice 2
				}
				return;
			}
		}
	}

}
