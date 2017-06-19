package ModuleConcepteur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BaseDeDonnees.Questionnaire;

public class AffichageQuestionnaire extends JPanel{
	Concepteur c;
	Questionnaire q;
	private JPanel panelCentral;
	private int id;
	private String nom;
	private int panel;
	private int client;
	private int tauxReponse;
	
	AffichageQuestionnaire(Concepteur c,Questionnaire q){
		this.c = c;
		this.q = q;
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
		titrePanelQuestions.setPreferredSize(new Dimension(320,50));
		titrePanelQuestions.setFont(new Font("Calibri",Font.BOLD,26));
		titrePanelQuestions.setBorder(new EmptyBorder(20,20,20,20));
		JPanel panelListeQuestions = new JPanel();
		JPanel listeQuestions = new JPanel();
		listeQuestions.setLayout(new BoxLayout(listeQuestions,BoxLayout.Y_AXIS));
		for(int i=0;i<20;i++){
			listeQuestions.add(creerQuestion("Quel âge avez-vous ?"));
		}
		panelListeQuestions.add(listeQuestions);
		JScrollPane scrollQuestions = new JScrollPane(panelListeQuestions);
		scrollQuestions.setPreferredSize(getPreferredSize());
		panelQuestionsBorder.add(titrePanelQuestions);
		panelQuestionsBorder.add(scrollQuestions);
		panelQuestionsBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		panelQuestions.add(panelQuestionsBorder);
		panelQuestions.setBorder(new EmptyBorder(20,20,20,20));
		panelCentral.add(panelQuestions,"East");

	}
	private JPanel creerQuestion(String intitule){
		JPanel panelQuestion = new JPanel();
		JPanel panelQuestionBis = new JPanel(); 
		//Permet d'avoir un second panel pour avoir à la fois un contour et un espacement
		JLabel nomQuestion = new JLabel(intitule);
		nomQuestion.setBorder(new EmptyBorder(3,60,3,60));
		panelQuestionBis.setBorder(BorderFactory.createLineBorder(Color.black));
		panelQuestionBis.add(nomQuestion);
		panelQuestion.setBorder(new EmptyBorder(3,10,3,10));
		panelQuestion.add(panelQuestionBis);
		return panelQuestion;
	}
	private void afficherBoutons(){
		Font police = new Font("Calibri",Font.BOLD,18);
		JPanel panelBoutons = new JPanel();
		panelBoutons.setLayout(new FlowLayout(FlowLayout.CENTER,60,0));
		panelBoutons.setBorder(new EmptyBorder(50,10,50,10));
		ActBoutonAffichageQuestionnaire actBoutons = new ActBoutonAffichageQuestionnaire(this.c,this,this.q);
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
