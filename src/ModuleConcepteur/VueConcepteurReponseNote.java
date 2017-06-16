package ModuleConcepteur;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueConcepteurReponseNote extends JPanel implements TypeReponse{
	VuePanelTextAvecField min;
	VuePanelTextAvecField max;
	JButton valider;
	JPanel panel;
	
	VueConcepteurReponseNote(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		ActionListenerReponse act = new ActionListenerReponse(this);
		this.panel = new JPanel();
		this.min = new VuePanelTextAvecField("Valeur minimal",10);
		this.max = new VuePanelTextAvecField("Valeur maximal",10);
		this.min.setValue("0");
		this.min.setValue("10");
		this.panel.add(this.min);
		this.panel.add(this.max);
		this.valider = new JButton("Valider");
		this.valider.addActionListener(act);
		this.panel.add(this.valider);
		this.setPreferredSize(new Dimension(600,300));
		majReponse();
	}
	
	public void majReponse(){
		this.removeAll();
		this.add(this.panel);
		this.panel.removeAll();
		this.panel.add(this.min);
		this.panel.add(this.max);
		this.panel.add(this.valider);
		try{
			if (Integer.parseInt(this.max.getJTextField().getText())<=Integer.parseInt(this.min.getJTextField().getText())){
				this.panel.add(new JLabel("Valeur maximal inférieur ou egal au minimum"));
			}
		}catch (NumberFormatException e){
			this.panel.add(new JLabel("Erreur dans les champs"));
		}
		this.validate();
		this.repaint();
	}
	
	public JButton getJButton(){
		return this.valider;
	}
}
