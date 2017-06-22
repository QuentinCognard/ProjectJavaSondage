package ModuleConcepteur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VuePanelCreerQuestion extends JPanel {
	JPanel panelTitre;
	JPanel reponse;
	VueConcepteurReponseSimple simple;
	VueConcepteurReponseMultiple multiple;
	VueConcepteurReponseClassement classement;
	VueConcepteurReponseNote note;
	VueConcepteurReponseLibre libre;
	VueCreerQuestionnaire vue;
	CreationQuestion question;
	
	VuePanelCreerQuestion(VueCreerQuestionnaire vue){
		super();
		this.setPreferredSize(new Dimension(600,400));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		this.vue = vue;
		this.question = new CreationQuestion(this.vue.getQuestionnaire().getIdQuestionnaire());
		
		this.panelTitre = new JPanel();
		this.reponse = new JPanel();
		this.reponse.add(new VueConcepteurReponseLibre());
		this.reponse.setPreferredSize(new Dimension(600,250));
		
		
		init();
		initVueReponse();
	}
	
	private void init(){
		
		JLabel label = new JLabel("Ajouter question");
		label.setFont(new Font("Calibri", Font.BOLD, 25));
		this.add(label);
		
		this.panelTitre.add(new VuePanelTextAvecField("Intitulé question",30));
		ActionRadioBouton act = new ActionRadioBouton(this);
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
	
	public void majBouton(){
		this.vue.majBoutonCreerReponse();
	}

	
	
	public void afficherSimple(){
		this.question.setTypeQuestion('u');
		this.reponse.removeAll();
		this.reponse.add(this.simple);
		this.validate();
		this.repaint();
	}
	
	public void afficherMultiple(){
		this.question.setTypeQuestion('m');
		this.reponse.removeAll();
		this.reponse.add(this.multiple);
		this.validate();
		this.repaint();
	}

	public void afficherClassement(){
		this.question.setTypeQuestion('c');
		this.reponse.removeAll();
		this.reponse.add(this.classement);
		this.validate();
		this.repaint();
	}
	
	public void afficherNote(){
		this.question.setTypeQuestion('n');
		this.reponse.removeAll();
		this.reponse.add(this.note);
		this.validate();
		this.repaint();
	}
	
	public void afficherLibre(){
		this.question.setTypeQuestion('l');
		this.reponse.removeAll();
		this.reponse.add(this.libre);
		this.validate();
		this.repaint();
	}
	
	public void majQuestion(){
		this.question.setIntitule(((VuePanelTextAvecField) this.panelTitre.getComponents()[0]).getJTextField().getText());
		switch (this.question.getTypeQuestion()){
		case 'l': 
			break;
		case 'u': 
			for (String s:((TypeReponse) this.reponse.getComponents()[0]).getReponse()){
				this.question.addReponse(s);
			}
			break;
		case 'm': 
			for (String s:((TypeReponse) this.reponse.getComponents()[0]).getReponse()){
				this.question.addReponse(s);
			}
			this.question.setMaxValeur(((TypeReponse) this.reponse.getComponents()[0]).getNbMax());
			break;
		case 'c': 
			for (String s:((TypeReponse) this.reponse.getComponents()[0]).getReponse()){
				this.question.addReponse(s);
			}
			this.question.setMaxValeur(((TypeReponse) this.reponse.getComponents()[0]).getNbMax());
			break;
		case 'n': 
			this.question.setMaxValeur(((TypeReponse) this.reponse.getComponents()[0]).getNbMax());
			break;
		}
	}
	
	public CreationQuestion getQuestion(){
		return this.question;
	}
}
