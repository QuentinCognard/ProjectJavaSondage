package ModuleConcepteur;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VueConcepteurReponseSimple extends JPanel implements TypeReponse{
	VuePanelTextAvecField nb;
	JButton valider;
	JScrollPane reponse;
	JPanel listeRep;
	JPanel panel;
	
	VueConcepteurReponseSimple(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		ActionListenerReponse act = new ActionListenerReponse(this);
		this.nb = new VuePanelTextAvecField("Nombre de réponse",5);
		this.nb.setValue("1");
		this.panel = new JPanel();
		this.panel.add(this.nb);
		this.valider = new JButton("Valider");
		this.valider.addActionListener(act);
		this.panel.add(this.valider);
		this.setPreferredSize(new Dimension(600,235));
		this.listeRep = new JPanel();
		this.listeRep.setLayout(new BoxLayout(this.listeRep,BoxLayout.Y_AXIS));
		this.reponse = new JScrollPane(this.listeRep);
		this.reponse.setPreferredSize(new Dimension(300,150)); // x, y
		majReponse();
	}
	
	public void majReponse(){
		this.removeAll();
		this.add(this.panel);
		this.panel.removeAll();
		this.panel.add(this.nb);
		this.panel.add(this.valider);
		try{
			if (this.listeRep.getComponentCount()<Integer.parseInt(this.nb.getJTextField().getText())){
				int a = this.listeRep.getComponentCount();
				for (int i = 0;i<Integer.parseInt(this.nb.getJTextField().getText())-a; i++){
					this.listeRep.add(new VuePanelTextAvecField("Réponse "+(a+i+1)+": ",30));
				}
			}else if (this.listeRep.getComponentCount()>Integer.parseInt(this.nb.getJTextField().getText())){
				int a = this.listeRep.getComponentCount();
				for (int i = 0;i<a-Integer.parseInt(this.nb.getJTextField().getText()); i++){
					this.listeRep.remove(a-1-i);
				}
			}
			this.add(this.reponse);
		}catch (NumberFormatException e){
			this.panel.add(new JLabel("Erreur dans les champs"));
		}
		this.validate();
		this.repaint();
	}
	
	public JButton getJButton(){
		return this.valider;
	}
	
	public int getNbMax() {
		return 0;
	}
	
	public ArrayList<String> getReponse(){
		ArrayList<String> res = new ArrayList<String>();
		for (int i=0;i<this.listeRep.getComponents().length;i++){
			res.add(((VuePanelTextAvecField) this.listeRep.getComponents()[i]).getJTextField().getText());
		}
		return res;
	}
}
