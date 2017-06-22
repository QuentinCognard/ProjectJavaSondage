package ModuleConcepteur;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import BaseDeDonnees.*;

public class VueAjouterQuestion extends JPanel{
	Concepteur c;
	Questionnaire q;
	VuePanelAjouterQuestion vue;
	AffichageQuestionnaire vueQuestionnaire;
	BDModuleConcepteur bdc;
	
	VueAjouterQuestion(Concepteur c,AffichageQuestionnaire vueQuestionnaire,Questionnaire q, BDModuleConcepteur bdc){
		super();
		this.c = c;
		this.q = q;
		this.bdc = bdc;
		this.vueQuestionnaire = vueQuestionnaire;
		this.vue = new VuePanelAjouterQuestion();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		init();
		
	}
	private void init(){
		this.add(this.vue);
		this.add(this.boutons());
	}
	private JPanel boutons(){
		Font police = new Font("Calibri",Font.BOLD,20);
		JPanel panelBoutons = new JPanel();
		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.setFont(police);
		JButton boutonCreer = new JButton("Créer");
		boutonCreer.setFont(police);
		ActBoutonInfoAjouterQuestion actBouton = new ActBoutonInfoAjouterQuestion(c,this,vueQuestionnaire,this.q,this.bdc,this.vue);
		boutonAnnuler.addActionListener(actBouton);
		boutonCreer.addActionListener(actBouton);
		panelBoutons.add(boutonAnnuler);
		panelBoutons.add(boutonCreer);
		return panelBoutons;
	}
}
