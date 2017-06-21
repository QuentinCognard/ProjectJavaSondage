package ModuleAnalyste.AnalysteController;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ModuleAnalyste.Analyste;

/**
 * TabbedController est une classe (controller) qui gère les Panels d'affichage des tableaux/Graphs
 * @author Julien Revaud
 *
 */

public class TabbedController implements ChangeListener {
	
	/**
	 * La classe (vue) de base du module analyste
	 */
	private Analyste ana;
	
	/**
	   * cré la classe controller
	   * @param ana
	   * 	 la classe analyste
	   */
	public TabbedController(Analyste ana) {
		super();
		this.ana = ana;
	}
	/**
	   * execute une instruction sur le bouton Regroupement associé au panel lors du changement de graph
	   * @param e
	   * 	 l'ActioEvent qui permet de retrouver quel panel a été changé
	   */
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
				else //if (tabName.equals("Tableau"))
				{
					br.setEnabled(true);
					if (br.getItemCount() == 3)
						br.removeItemAt(2); //on sup le 3ème qui a pour indice 2
				}
				System.out.println("idTypequestion :" + ana.getModeleAnalyste().getListeQuestions().get(Integer.parseInt(tabGeneral.getName())-1).getIdTypeQuestion());
				if (ana.getModeleAnalyste().getListeQuestions().get(Integer.parseInt(tabGeneral.getName())-1).getIdTypeQuestion() == 'm' || ana.getModeleAnalyste().getListeQuestions().get(Integer.parseInt(tabGeneral.getName())-1).getIdTypeQuestion() == 'c')
					br.setEnabled(false);
				return;
			}
		}
	}

}
