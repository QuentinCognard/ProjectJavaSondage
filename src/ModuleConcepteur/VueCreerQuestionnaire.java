package ModuleConcepteur;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import BaseDeDonnees.*;
import Commun.ModeleCommun;

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
	ArrayList<CreationQuestion> listeQuestion;
	Questionnaire questionnaire;
	ModeleCommun modeleC;
	BDModuleConcepteur bdC;
	
	public VueCreerQuestionnaire(Concepteur concepteur,ModeleCommun modele,BDModuleConcepteur bdC){
		super();
		this.page = 1;
		this.bdC = bdC;
		this.modeleC = modele;
		
		int id = this.bdC.maxIdentifiantQuestionnaire()+1;
		int idUtil = this.modeleC.getUser().getIdentifiantUtilisateur();
		this.questionnaire = new Questionnaire(id,"",'C',0,idUtil,0);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		JLabel label = new JLabel("Création du questionnaire");
		label.setFont(new Font("Calibri", Font.BOLD, 40));
		this.add(label);
		
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
		
		this.listeQuestion = new ArrayList<CreationQuestion>();
	}
	
	
	private void panelInfoQuestionnaire(){
		this.panelInfo.add(new VuePanelCreerInfoQuestionnaire(this.bdC));
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
	
	
	private void panelAjouterQuestion(){
		VuePanelCreerQuestion vue = new VuePanelCreerQuestion(this);
		this.panelAddQuestion.add(vue);
	}
	
	private void panelAfficherQuestionnaire(){
		VueCreerQuestionnaireAfficher vue = new VueCreerQuestionnaireAfficher(this);
		this.panelAfficherQuestion.add(vue);
	}
	
	
	public void afficherAjouterQuestion(){
		this.questionnaire.setTitreQuestionnaire(((VuePanelCreerInfoQuestionnaire) this.panelInfo.getComponents()[0]).getTitre());
		this.questionnaire.setIdentifiantPanel(((VuePanelCreerInfoQuestionnaire) this.panelInfo.getComponents()[0]).getPanel().getIdentifiantPanel());
		this.questionnaire.setNumClient(((VuePanelCreerInfoQuestionnaire) this.panelInfo.getComponents()[0]).getClient().getNumeroClient());
		this.removeAll();
		JLabel label = new JLabel("Création du questionnaire");
		label.setFont(new Font("Calibri", Font.BOLD, 40));
		this.add(label);
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
			JLabel label = new JLabel("Création du questionnaire");
			label.setFont(new Font("Calibri", Font.BOLD, 40));
			this.add(label);
			this.add(this.panelInfo);
			majBoutonInfo();
			this.page = 1;
		}else{
			afficherAjouterQuestion();
		}
	}
	
	public void afficherQuestionnaire(){
		((VueCreerQuestionnaireAfficher) this.panelAfficherQuestion.getComponents()[0]).setId(this.questionnaire.getIdQuestionnaire());
		((VueCreerQuestionnaireAfficher) this.panelAfficherQuestion.getComponents()[0]).setNom(this.questionnaire.getTitreQuestionnaire());
		((VueCreerQuestionnaireAfficher) this.panelAfficherQuestion.getComponents()[0]).setSociete(((VuePanelCreerInfoQuestionnaire) this.panelInfo.getComponents()[0]).getClient().getRaisonSociale());
		((VueCreerQuestionnaireAfficher) this.panelAfficherQuestion.getComponents()[0]).setPanel(((VuePanelCreerInfoQuestionnaire) this.panelInfo.getComponents()[0]).getPanel().getNomPanel());
		this.removeAll();
		JLabel label = new JLabel("Création du questionnaire");
		label.setFont(new Font("Calibri", Font.BOLD, 40));
		this.add(label);
		JLabel label2 = new JLabel("Afficher les questions");
		label2.setFont(new Font("Calibri", Font.BOLD, 25));
		this.add(label2);
		this.add(this.panelAfficherQuestion);
		majBoutonAfficher();
		this.validate();
		this.repaint();
		this.page = 3;
	}
	
	public void ajouterQuestionQuestionnaire(){
		((VuePanelCreerQuestion) this.panelAddQuestion.getComponents()[0]).majQuestion();
		((VueCreerQuestionnaireAfficher) this.panelAfficherQuestion.getComponents()[0]).ajouterQuestion(((VuePanelCreerQuestion) this.panelAddQuestion.getComponents()[0]).getQuestion());
		this.listeQuestion.add(((VuePanelCreerQuestion) this.panelAddQuestion.getComponents()[0]).getQuestion());
		this.panelAddQuestion.removeAll();
		panelAjouterQuestion();
		afficherAjouterQuestion();
	}
	
	public void enregistrerQuestionnaire(){
		int i = 1;
		this.bdC.insererQuestionnaire(this.questionnaire);
		for (CreationQuestion q:this.listeQuestion){
			q.setNumQuestion(i);
			i+=1;
			this.bdC.insererQuestion(q.getQuestion());
			for (ValeurPossible r:q.getReponse()){
				this.bdC.insererValeurPossible(r);
			}
		}
		this.concepteur.afficherConcepteur();
	}
	
	public Questionnaire getQuestionnaire(){
		return this.questionnaire;
	}
	
	public ArrayList<CreationQuestion> getListeQuestion(){
		return this.listeQuestion;
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
