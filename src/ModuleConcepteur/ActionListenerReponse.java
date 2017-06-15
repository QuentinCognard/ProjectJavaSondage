package ModuleConcepteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

public class ActionListenerReponse implements ActionListener {
	TypeReponse vue;
	
	ActionListenerReponse(TypeReponse vue){
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.vue.majReponse();
	}

}
