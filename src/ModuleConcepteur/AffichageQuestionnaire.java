package ModuleConcepteur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import BaseDeDonnees.*;

public class AffichageQuestionnaire extends JPanel{
	Concepteur c;
	Questionnaire q;
	BDGeneral bd;
	private JPanel panelCentral;
	private int id;
	private String nom;
	private int panel;
	private int client;
	private int tauxReponse;
	private ArrayList<Question> listeQuestions;
	
	AffichageQuestionnaire(Concepteur c,Questionnaire q,BDGeneral bd){
		this.c = c;
		this.q = q;
		this.bd = bd;
		this.panelCentral = new JPanel();
		this.id = q.getIdQuestionnaire();
		this.nom = q.getTitreQuestionnaire();
		this.panel = q.getIdentifiantPanel();
		this.client = q.getNumClient();
		this.tauxReponse = 80;
		panelCentral();
		c.add(panelCentral);

	}
	public void majInfos(int id,String nom, int panel, int client,int tauxReponse){
		this.id = id;
		this.nom = nom;
		this.panel = panel;
		this.client = client;
		this.tauxReponse = tauxReponse;
	}
	public ArrayList<QuestionPanel> recupQuestions(){
		this.listeQuestions = bd.getListeQuestion(q.getIdQuestionnaire());
		ArrayList<QuestionPanel> liste = new ArrayList<QuestionPanel>();
		for(Question q : listeQuestions){
			liste.add(creerQuestion(q));
		}
		return liste;
	}
	private void panelCentral(){
		panelCentral.setLayout(new BorderLayout());
		afficherHeader();
		afficherPanelInfos();
		afficherListeQuestions();
		afficherBoutons();
	}
	private void afficherHeader(){
		JPanel panelHeader = new JPanel();
		panelHeader.setLayout(new FlowLayout(FlowLayout.CENTER,200,10));
		JButton bouton = new JButton("Créer questionnaire");
		bouton.setFont(new Font("Calibri",Font.BOLD,26));
		JLabel mesQuestionnaires = new JLabel("Mon questionnaire");
		mesQuestionnaires.setFont(new Font("Calibri", Font.BOLD, 40));
		ActionBoutonConcepteur act = new ActionBoutonConcepteur(this.c);
		bouton.addActionListener(act);
		panelHeader.add(mesQuestionnaires);
		panelHeader.add(bouton);;
		panelCentral.add(panelHeader,"North");
	}
	private void afficherPanelInfos(){
		Font police = new Font("Calibri",Font.BOLD,20);
		JPanel panelInfos = new JPanel();
		panelInfos.setLayout(new BoxLayout(panelInfos,BoxLayout.Y_AXIS));
		JLabel id = new JLabel("Id : "+this.id);
		id.setBorder(new EmptyBorder(40,30,20,10)); //top-left-bottom-right
		id.setFont(police);
		JLabel nom = new JLabel("Nom : "+this.nom);
		nom.setBorder(new EmptyBorder(20,30,20,10));
		nom.setFont(police);
		JLabel panel = new JLabel("Panel concerné : "+this.panel);
		panel.setBorder(new EmptyBorder(20,30,20,10));
		panel.setFont(police);
		JLabel client = new JLabel("Société concernée : "+this.client);
		client.setBorder(new EmptyBorder(20,30,20,10));
		client.setFont(police);
		JLabel tauxReponse = new JLabel("Taux de réponses minimum : "+this.tauxReponse);
		tauxReponse.setBorder(new EmptyBorder(20,30,20,10));
		tauxReponse.setFont(police);
		panelInfos.add(id);
		panelInfos.add(nom);
		panelInfos.add(panel);
		panelInfos.add(client);
		panelInfos.add(tauxReponse);
		panelCentral.add(panelInfos,"West");
		
		
	}
	private void afficherListeQuestions(){
		JPanel panelQuestions = new JPanel();
		panelQuestions.setLayout(new BoxLayout(panelQuestions,BoxLayout.Y_AXIS));
		JPanel panelQuestionsBorder = new JPanel();
		panelQuestionsBorder.setLayout(new BoxLayout(panelQuestionsBorder,BoxLayout.Y_AXIS));
		JLabel titrePanelQuestions = new JLabel("Liste questions");
		titrePanelQuestions.setPreferredSize(new Dimension(550,50));
		titrePanelQuestions.setFont(new Font("Calibri",Font.BOLD,26));
		titrePanelQuestions.setBorder(new EmptyBorder(20,20,20,20));
		JPanel panelPanelsQuestions = new JPanel();
		JPanel panelListeQuestions = new JPanel();
		panelListeQuestions.setLayout(new BoxLayout(panelListeQuestions,BoxLayout.Y_AXIS));
		ArrayList<QuestionPanel> listePanelsQuestion = recupQuestions();
		for(JPanel q : listePanelsQuestion){
			panelListeQuestions.add(q);
		}
		panelPanelsQuestions.add(panelListeQuestions);
		JScrollPane scrollQuestions = new JScrollPane(panelPanelsQuestions);
		scrollQuestions.setPreferredSize(getPreferredSize());
		panelQuestionsBorder.add(titrePanelQuestions);
		panelQuestionsBorder.add(scrollQuestions);
		panelQuestionsBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		panelQuestions.add(panelQuestionsBorder);
		panelQuestions.setBorder(new EmptyBorder(20,20,20,20));
		panelCentral.add(panelQuestions,"East");

	}
	private QuestionPanel creerQuestion(Question q){
		QuestionPanel panelQuestion = new QuestionPanel(q);
		JPanel panelQuestionBis = new JPanel(); 
		panelQuestionBis.setPreferredSize(new Dimension(500,40));
		//Permet d'avoir un second panel pour avoir à la fois un contour et un espacement
		JLabel nomQuestion = new JLabel(q.getTexteQuestion());
		nomQuestion.setBorder(new EmptyBorder(3,30,3,30));
		panelQuestionBis.setBorder(BorderFactory.createLineBorder(Color.black));
		panelQuestionBis.add(nomQuestion);
		panelQuestion.setBorder(new EmptyBorder(3,3,3,3));
		panelQuestion.add(panelQuestionBis);
		return panelQuestion;
	}
	private void afficherBoutons(){
		Font police = new Font("Calibri",Font.BOLD,18);
		JPanel panelBoutons = new JPanel();
		panelBoutons.setLayout(new FlowLayout(FlowLayout.CENTER,60,0));
		panelBoutons.setBorder(new EmptyBorder(50,10,50,10));
		ActBoutonAffichageQuestionnaire actBoutons = new ActBoutonAffichageQuestionnaire(this.c,this,this.q,this.bd);
		JButton boutonRetour = new JButton("Retour");
		boutonRetour.addActionListener(actBoutons);
		boutonRetour.setFont(police);
		JButton boutonModif = new JButton("Modifier informations");
		boutonModif.addActionListener(actBoutons);
		boutonModif.setFont(police);
		JButton boutonAjout = new JButton("Ajouter question");
		boutonAjout.addActionListener(actBoutons);
		boutonAjout.setFont(police);
		JButton boutonSupprimer = new JButton("Supprimer questionnaire");
		boutonSupprimer.addActionListener(actBoutons);
		boutonSupprimer.setFont(police);
		panelBoutons.add(boutonRetour);
		panelBoutons.add(boutonModif);
		panelBoutons.add(boutonAjout);
		panelBoutons.add(boutonSupprimer);
		panelCentral.add(panelBoutons,"South");
		
	}
	public int getId(){
		return this.id;
	}
	public String getNom(){
		return this.nom;
	}
	public int getPanel(){
		return this.panel;
	}
	public int getClient(){
		return this.client;
	}
	public int getTauxReponse(){
		return tauxReponse;
	}
}
