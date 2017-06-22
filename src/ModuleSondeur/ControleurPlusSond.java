package ModuleSondeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurPlusSond implements ActionListener {
	
	Vue_PlusSondes vuePlusSonde;
	private Sondeur s;
	/**
 	*Controlleur pour la vue PlusSondes
	*@param vuePlusSonde
		*La vue que l'on va utiliser pour ce controleur
	*/

	public ControleurPlusSond(Vue_PlusSondes vuePlusSonde){
		this.vuePlusSonde=vuePlusSonde;
		this.s=vuePlusSonde.s;

	}

	public void actionPerformed(ActionEvent arg0) {
		this.s.afficherPlusDeSonde();
	}

}
