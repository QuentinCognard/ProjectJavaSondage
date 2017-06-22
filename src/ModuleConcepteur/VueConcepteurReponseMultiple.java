package ModuleConcepteur;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VueConcepteurReponseMultiple extends JPanel implements TypeReponse{
	VuePanelTextAvecField nb;
	VuePanelTextAvecField nbCocher;
	JButton valider;
	JScrollPane reponse;
	JPanel listeRep;
	JPanel haut;
	
	VueConcepteurReponseMultiple(){
		this.setPreferredSize(new Dimension(300,350));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		ActionListenerReponse act = new ActionListenerReponse(this);
		this.nb = new VuePanelTextAvecField("Nombre de réponse",5);
		this.nb.setValue("1");
		this.nbCocher = new VuePanelTextAvecField("Nombre de réponse à cocher",5);
		this.nbCocher.setValue("1");
		this.haut = new JPanel();
		this.haut.add(this.nb);
		this.haut.add(this.nbCocher);
		this.valider = new JButton("Valider");
		this.valider.addActionListener(act);
		this.haut.add(this.valider);
		this.setPreferredSize(new Dimension(600,235));
		this.listeRep = new JPanel();
		this.listeRep.setLayout(new BoxLayout(this.listeRep,BoxLayout.Y_AXIS));
		this.reponse = new JScrollPane(this.listeRep);
		this.reponse.setPreferredSize(new Dimension(300,150)); // x, y
		majReponse();
	}
	
	public void majReponse(){
		this.removeAll();
		this.add(this.haut);
		this.haut.removeAll();
		this.haut.add(this.nb);
		this.haut.add(this.nbCocher);
		this.haut.add(this.valider);
		try{
			Integer.parseInt(this.nbCocher.getJTextField().getText());
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
			this.haut.add(new JLabel("Erreur dans les champs"));
		}
		this.validate();
		this.repaint();
	}
	
	public JButton getJButton(){
		return this.valider;
	}
	
	public int getNbMax(){
		return Integer.parseInt(this.nbCocher.getJTextField().getText());
	}
	
	public ArrayList<String> getReponse(){
		ArrayList<String> res = new ArrayList<String>();
		for (int i=0;i<this.listeRep.getComponents().length;i++){
			res.add(((VuePanelTextAvecField) this.listeRep.getComponents()[i]).getJTextField().getText());
		}
		return res;
	}
}
