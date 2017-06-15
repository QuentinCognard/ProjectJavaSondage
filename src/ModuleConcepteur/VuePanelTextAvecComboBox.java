package ModuleConcepteur;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VuePanelTextAvecComboBox extends JPanel{
	
	JComboBox jt;
	JLabel jl;

	public VuePanelTextAvecComboBox(String etiquette, String [] liste) {
		super();
		this.setLayout(new FlowLayout());
		jl = new JLabel(etiquette);
		jt = new JComboBox(liste);
		jt.addItem("");
		this.add(jl);
		this.add(jt);
	}


	public JComboBox getJComboBox(){
		return this.jt;
	}


	public void setValue(String val){
		this.jt.addItem(val);
	}

	
	public void setLabel(String label){
		this.jl.setText(label);
	}
}
