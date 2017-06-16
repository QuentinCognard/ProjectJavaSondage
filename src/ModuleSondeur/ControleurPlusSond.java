package ModuleSondeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurPlusSond implements ActionListener {
	
	Vue_PlusSondes vuePlusSonde;

	public ControleurPlusSond(Vue_PlusSondes vuePlusSonde){
		this.vuePlusSonde=vuePlusSonde;
	}

	public void actionPerformed(ActionEvent arg0) {
		Sondeur fenetresondage=(Sondeur) vuePlusSonde.getRootPane().getParent();
		fenetresondage.afficherPlusDeSonde();
	}

}
