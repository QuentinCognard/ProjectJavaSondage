package ModuleAnalyste.AnalysteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ModuleAnalyste.Analyste;

public class RechercherController implements ActionListener {
	
	private Analyste ana;
	
	public RechercherController(Analyste ana){
		super();
		this.ana = ana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* TODO: en fonction de ce qui est donner dans le jTextField, appliquer un filtre
		 * Si aucun champ trouvé, afficher à la place du tableau "Aucun Questionnaire
		 * ne correspond à votre requete"
		 */
		String texte = ana.getTexteRecherche();
		System.out.println(texte);
	}

}
