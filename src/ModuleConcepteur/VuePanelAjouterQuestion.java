package ModuleConcepteur;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VuePanelAjouterQuestion extends JPanel {
	JPanel panelTitre;
	JPanel reponse;
	VueConcepteurReponseSimple simple;
	VueConcepteurReponseMultiple multiple;
	VueConcepteurReponseClassement classement;
	VueConcepteurReponseNote note;
	VueConcepteurReponseLibre libre;
	
	VuePanelAjouterQuestion(){
		super();
		this.setPreferredSize(new Dimension(600,450));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.panelTitre = new JPanel();
		this.reponse = new JPanel();
		this.reponse.add(new VueConcepteurReponseLibre());
		this.reponse.setPreferredSize(new Dimension(600,300));
		init();
		initVueReponse();
	}
	
	private void init(){
		this.add(new JLabel("Ajouter question"));
		this.panelTitre.add(new VuePanelTextAvecField("Intitulé question",30));
		ActionRadioBoutonAjouterQuestion act = new ActionRadioBoutonAjouterQuestion(this);
		JRadioButton r1 = new JRadioButton("Choix simple");
		JRadioButton r2 = new JRadioButton("Choix multiple");
		JRadioButton r3 = new JRadioButton("Classement");
		JRadioButton r4 = new JRadioButton("Note");
		JRadioButton r5 = new JRadioButton("Réponse libre");
		r1.addActionListener(act);
		r2.addActionListener(act);
		r3.addActionListener(act);
		r4.addActionListener(act);
		r5.addActionListener(act);
		ButtonGroup group=new ButtonGroup ();
		group.add(r1);
		group.add(r2);
		group.add(r3);
		group.add(r4);
		group.add(r5);
		JPanel groupBouton = new JPanel();
		groupBouton.setLayout(new BoxLayout(groupBouton,BoxLayout.Y_AXIS));
		groupBouton.add(r1);
		groupBouton.add(r2);
		groupBouton.add(r3);
		groupBouton.add(r4);
		groupBouton.add(r5);
		this.panelTitre.add(groupBouton);
		this.add(this.panelTitre);
		this.add(this.reponse);
	}
	
	private void initVueReponse(){
		this.simple = new VueConcepteurReponseSimple();
		this.multiple = new VueConcepteurReponseMultiple();
		this.classement = new VueConcepteurReponseClassement();
		this.note = new VueConcepteurReponseNote();
		this.libre = new VueConcepteurReponseLibre();
	}	
	
	public void afficherSimple(){
		this.reponse.removeAll();
		this.reponse.add(this.simple);
		this.validate();
		this.repaint();
	}
	
	public void afficherMultiple(){
		this.reponse.removeAll();
		this.reponse.add(this.multiple);
		this.validate();
		this.repaint();
	}

	public void afficherClassement(){
		this.reponse.removeAll();
		this.reponse.add(this.classement);
		this.validate();
		this.repaint();
	}
	
	public void afficherNote(){
		this.reponse.removeAll();
		this.reponse.add(this.note);
		this.validate();
		this.repaint();
	}
	
	public void afficherLibre(){
		this.reponse.removeAll();
		this.reponse.add(this.libre);
		this.validate();
		this.repaint();
	}
}
