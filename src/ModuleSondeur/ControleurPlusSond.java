package ModuleSondeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurPlusSond implements ActionListener {
	
	Vue_PlusSondes vuePlusSonde;
	private Sondeur s;


	public ControleurPlusSond(Vue_PlusSondes vuePlusSonde){
		this.vuePlusSonde=vuePlusSonde;
		this.s=vuePlusSonde.s;

	}

	public void actionPerformed(ActionEvent arg0) {
		this.s.afficherPlusDeSonde();
	}

}
