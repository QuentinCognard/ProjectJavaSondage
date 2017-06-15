package ModuleConcepteur;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueCreerQuestionnaire extends JPanel{
	JPanel panelInfo;
	JPanel panelAddQuestion;
	JPanel bouton;
	JPanel panelAfficherQuestion;
	Concepteur concepteur;
	JButton suivant;
	JButton annuler;
	JButton afficher;
	JButton terminer;
	JButton ajouter;
	int page;
	QuestionnnaireMethode questionnaire;
	
	public VueCreerQuestionnaire(Concepteur concepteur){
		super();
		this.page = 1;
		this.questionnaire = new QuestionnnaireMethode();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(new JLabel("Création du questionnaire"));
		this.concepteur = concepteur;
		this.suivant = new JButton("Suivant");
		this.annuler = new JButton("Annuler");
		this.afficher = new JButton("Afficher les questions");
		this.terminer = new JButton("Terminer");
		this.ajouter = new JButton("Ajouter la question");
		
		this.panelInfo = new JPanel();
		this.panelAddQuestion = new JPanel();
		this.panelAfficherQuestion = new JPanel();
		this.bouton = new JPanel();
		
		panelInfoQuestionnaire();
		
		panelBouton();
		
		panelAjouterQuestion();
		
		panelAfficherQuestionnaire();
	}
	
	
	private void panelInfoQuestionnaire(){
		this.panelInfo.add(new VuePanelCreerInfoQuestionnaire());
		this.add(this.panelInfo);
		
	}
	
	private void panelBouton(){
		ActionBoutonInfoQuestionnaire act = new ActionBoutonInfoQuestionnaire(this);
		annuler.addActionListener(act);
		suivant.addActionListener(act);
		afficher.addActionListener(act);
		terminer.addActionListener(act);
		ajouter.addActionListener(act);
		this.bouton.add(this.annuler);
		this.bouton.add(this.suivant);
		this.add(this.bouton);
	}
	
	public void ajouterQuestion(){
		
	}
	
	private void panelAjouterQuestion(){
		VuePanelCreerQuestion vue = new VuePanelCreerQuestion(this);
		this.panelAddQuestion.add(vue);
	}
	
	private void panelAfficherQuestionnaire(){
		this.panelAfficherQuestion.add(new VueCreerQuestionnaireAfficher());
	}
	
	public void afficherAjouterQuestion(){
		this.questionnaire.setTitre(((VuePanelCreerInfoQuestionnaire) this.panelInfo.getComponents()[0]).getInfo().get(0));
		this.questionnaire.setPanel(((VuePanelCreerInfoQuestionnaire) this.panelInfo.getComponents()[0]).getInfo().get(2));
		this.questionnaire.setSociete(((VuePanelCreerInfoQuestionnaire) this.panelInfo.getComponents()[0]).getInfo().get(1));
		this.questionnaire.setTaux(((VuePanelCreerInfoQuestionnaire) this.panelInfo.getComponents()[0]).getInfo().get(3));
		this.removeAll();
		this.add(new JLabel("Création du questionnaire"));
		this.add(this.panelAddQuestion);
		majBoutonCreerQuestion();
		this.validate();
		this.repaint();
		this.page = 2;
	}
	
	public void afficherPagePrecedente(){
		if (this.page==1){
			this.concepteur.afficherConcepteur();
		}else if (this.page==2){
			this.removeAll();
			this.add(new JLabel("Création du questionnaire"));
			this.add(this.panelInfo);
			majBoutonInfo();
			this.page = 1;
		}else{
			afficherAjouterQuestion();
		}
	}
	
	public void afficherQuestionnaire(){
		((VueCreerQuestionnaireAfficher) this.panelAfficherQuestion.getComponents()[0]).setId(0);
		((VueCreerQuestionnaireAfficher) this.panelAfficherQuestion.getComponents()[0]).setNom(this.questionnaire.getTitre());
		((VueCreerQuestionnaireAfficher) this.panelAfficherQuestion.getComponents()[0]).setSociete(this.questionnaire.getSociete());
		((VueCreerQuestionnaireAfficher) this.panelAfficherQuestion.getComponents()[0]).setPanel(this.questionnaire.getPanel());
		((VueCreerQuestionnaireAfficher) this.panelAfficherQuestion.getComponents()[0]).setTaux(this.questionnaire.getTaux());
		this.removeAll();
		this.add(new JLabel("Création du questionnaire"));
		this.add(new JLabel("Afficher les questions"));
		this.add(this.panelAfficherQuestion);
		majBoutonAfficher();
		this.validate();
		this.repaint();
		this.page = 3;
	}
	
	public void ajouterQuestionQuestionnaire(){
		ArrayList<String> liste = new ArrayList<String>();
		liste.add("reponse");
		this.questionnaire.ajouterQuestion("coucou",liste);
		((VueCreerQuestionnaireAfficher) this.panelAfficherQuestion.getComponents()[0]).ajouterQuestion("coucou",liste);
		this.panelAddQuestion.removeAll();
		panelAjouterQuestion();
		afficherAjouterQuestion();
	}
	
	public void majBoutonCreerQuestion(){
		this.bouton.removeAll();
		this.bouton.add(this.annuler);
		this.bouton.add(this.afficher);
		this.bouton.add(this.terminer);
		this.add(this.bouton);
		this.validate();
		this.repaint();
	}
	
	public void majBoutonCreerReponse(){
		this.bouton.removeAll();
		this.bouton.add(this.annuler);
		this.bouton.add(this.ajouter);
		this.add(this.bouton);
		this.validate();
		this.repaint();
	}
	
	public void majBoutonInfo(){
		this.bouton.removeAll();
		this.bouton.add(this.annuler);
		this.bouton.add(this.suivant);
		this.add(this.bouton);
		this.validate();
		this.repaint();
	}
	
	public void majBoutonAfficher(){
		this.bouton.removeAll();
		this.bouton.add(this.annuler);
		this.bouton.add(this.terminer);
		this.add(this.bouton);
		this.validate();
		this.repaint();
	}
	
	
}
