package ModuleConcepteur;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class VuePanelCreerInfoQuestionnaire extends JPanel {
	VuePanelTextAvecField titre;
	VuePanelTextAvecField societe;
	VuePanelTextAvecComboBox panel;
	VuePanelTextAvecField taux;
	
	VuePanelCreerInfoQuestionnaire(){
		super();
		
		this.init();
	}
	
	private void init(){
		this.setLayout(new GridLayout(2,2));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		String [] liste = {"panel 1","panel 2","panel 3"};
		this.titre = new VuePanelTextAvecField("Titre",20);
		this.societe = new VuePanelTextAvecField("Société cliente",20);
		this.panel = new VuePanelTextAvecComboBox("Panel",liste);
		this.taux = new VuePanelTextAvecField("Taux de réponse",20);
		this.add(this.titre);
		this.add(this.societe);
		this.add(this.panel);
		this.add(this.taux);
	}
	
	public ArrayList<String> getInfo(){
		ArrayList<String> liste = new ArrayList<String>();
		System.out.println(this.titre.getJTextField().getText());
		liste.add(this.titre.getJTextField().getText());
		liste.add(this.societe.getJTextField().getText());
		liste.add((String) this.panel.getJComboBox().getSelectedItem());
		liste.add(this.taux.getJTextField().getText());
		return liste;
	}

}
