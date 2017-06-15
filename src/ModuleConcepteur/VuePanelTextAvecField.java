package ModuleConcepteur;

import java.awt.FlowLayout;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VuePanelTextAvecField extends JPanel {

	JTextField jt;
	JLabel jl;

	public VuePanelTextAvecField(String etiquette, int size) {
		super();
		this.setLayout(new FlowLayout());
		jl = new JLabel(etiquette);
		jt = new JTextField(size);
		jt.setText("");
		this.add(jl);
		this.add(jt);
	}


	public JTextField getJTextField(){
		return this.jt;
	}


	public void setValue(String val){
		this.jt.setText(val);
	}

	
	public void setLabel(String label){
		this.jl.setText(label);
	}
}
