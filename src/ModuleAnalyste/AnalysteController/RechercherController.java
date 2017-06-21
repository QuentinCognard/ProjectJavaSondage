package ModuleAnalyste.AnalysteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ModuleAnalyste.Analyste;

/**
 * RechercherController est une classe (controller) qui gère le bouton rechercher de la vue de base (NON IMPLEMENTER POUR LE MOMENT)
 * @author Julien Revaud
 *
 */

public class RechercherController implements ActionListener {
	
	/**
	 * La classe (vue) de base du module analyste
	 */
	private Analyste ana;
	
	
	/**
	   * cré la classe controller
	   * @param ana
	   * 	 la classe analyste
	   */
	public RechercherController(Analyste ana){
		super();
		this.ana = ana;
	}
	
	/**
	   * execute une instruction lorsque le bouton Rechercher est enclenché
	   * @param e
	   * 	 l'ActioEvent qui permet de retrouver quel bouton a été cliqué
	   */
	@Override
	public void actionPerformed(ActionEvent e) {
		/* TODO: en fonction de ce qui est donner dans le jTextField, appliquer un filtre
		 * Si aucun champ trouv�, afficher � la place du tableau "Aucun Questionnaire
		 * ne correspond � votre requete"
		 */
		String texte = ana.getTexteRecherche();
		System.out.println(texte);
	}

}
