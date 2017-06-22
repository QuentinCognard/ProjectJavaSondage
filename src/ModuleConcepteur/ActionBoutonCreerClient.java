package ModuleConcepteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ActionBoutonCreerClient implements ActionListener {
	ConcepteurAjouterClient vue;
	
	ActionBoutonCreerClient(ConcepteurAjouterClient vue){
		this.vue = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (((JButton)arg0.getSource()).getText().equals("Enregistrer")){
			try{
				Integer.parseInt(this.vue.getCodeP().getJTextField().getText());
				this.vue.creerClient();
			}catch (NumberFormatException e){
			
			}
		}else{
			this.vue.afficherInfoRetour();
		}
	}

}
