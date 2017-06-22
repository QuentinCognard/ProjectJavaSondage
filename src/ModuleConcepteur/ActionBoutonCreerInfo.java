package ModuleConcepteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionBoutonCreerInfo implements ActionListener {
	VuePanelCreerInfoQuestionnaire vue;

	public ActionBoutonCreerInfo(VuePanelCreerInfoQuestionnaire vue) {
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.vue.afficherAjouterClient();

	}

}
