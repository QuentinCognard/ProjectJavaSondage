package ModuleConcepteur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BaseDeDonnees.Questionnaire;

public class ModificationQuestionnaire extends JPanel{
	Concepteur c;
	Questionnaire q;
	private JPanel panelCentral;
	private JTextField valId;
	private JTextField valNom;
	private JTextField valPanel;
	private JTextField valClient;
	private JTextField valTauxReponse;
	private int id;
	private String nom;
	private int panel;
	private int client;
	private int tauxReponse;
	ModificationQuestionnaire(Concepteur c,Questionnaire q){
		this.c = c;
		this.q = q;
		this.panelCentral = new JPanel();
		this.id = q.getIdQuestionnaire();
		this.nom = q.getTitreQuestionnaire();
		this.panel = q.getIdentifiantPanel();
		this.client = q.getNumClient();
		this.tauxReponse = 80;
		panelCentral();
		c.add(this.panelCentral);

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
		//panelHeader.setLayout(new BoxLayout(panelHeader,BoxLayout.Y_AXIS));
		JPanel panelTitre = new JPanel();
		panelTitre.setLayout(new FlowLayout(FlowLayout.LEFT,110,0));
		JLabel monQuestionnaire = new JLabel("Mon questionnaire");
		monQuestionnaire.setFont(new Font("Calibri", Font.BOLD, 40));
		panelTitre.add(monQuestionnaire);
		JPanel panelSousTitre = new JPanel();
		panelSousTitre.setLayout(new FlowLayout(FlowLayout.LEFT,110,0));
		JLabel modifier = new JLabel("Modification des informations");
		modifier.setFont(new Font("Calibri", Font.BOLD, 26));
		panelTitre.add(monQuestionnaire);
		panelSousTitre.add(modifier);
		panelHeader.add(panelTitre);
		panelHeader.add(panelSousTitre);
		panelCentral.add(panelHeader,"North");
	}
	private void afficherPanelInfos(){
		Font police = new Font("Calibri",Font.BOLD,20);
		JPanel panelInfos = new JPanel();
		panelInfos.setLayout(new BoxLayout(panelInfos,BoxLayout.Y_AXIS));
		JPanel panelId = new JPanel();
		panelId.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		JLabel labId = new JLabel("Id : ");
		labId.setBorder(new EmptyBorder(10,30,10,10)); //top-left-bottom-right
		labId.setFont(police);
		this.valId = new JTextField(""+this.id);
		valId.setEnabled(false);
		valId.setFont(police);
		panelId.add(labId);
		panelId.add(valId);
		JPanel panelNom = new JPanel();
		panelNom.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		JLabel nom = new JLabel("Nom : ");
		nom.setBorder(new EmptyBorder(10,30,10,10));
		nom.setFont(police);
		this.valNom = new JTextField(this.nom);
		valNom.setFont(police);
		panelNom.add(nom);
		panelNom.add(valNom);
		JPanel panelPanel = new JPanel();
		panelPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		JLabel panel = new JLabel("Panel concerné : ");
		panel.setBorder(new EmptyBorder(10,30,10,10));
		panel.setFont(police);
		this.valPanel = new JTextField(""+this.panel);
		valPanel.setFont(police);
		panelPanel.add(panel);
		panelPanel.add(valPanel);
		JPanel panelSociete = new JPanel();
		panelSociete.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		JLabel labClient = new JLabel("Société concernée : ");
		labClient.setBorder(new EmptyBorder(10,30,10,10));
		labClient.setFont(police);
		this.valClient = new JTextField(""+this.client);
		valClient.setFont(police);
		panelSociete.add(labClient);
		panelSociete.add(valClient);
		JPanel panelTauxReponse = new JPanel();
		panelTauxReponse.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		JLabel tauxReponse = new JLabel("Taux de réponses minimum : ");
		tauxReponse.setBorder(new EmptyBorder(10,30,10,10));
		tauxReponse.setFont(police);
		this.valTauxReponse = new JTextField(""+this.tauxReponse);
		valTauxReponse.setFont(police);
		panelTauxReponse.add(tauxReponse);
		panelTauxReponse.add(valTauxReponse);
		panelInfos.add(panelId);
		panelInfos.add(panelNom);
		panelInfos.add(panelPanel);
		panelInfos.add(panelSociete);
		panelInfos.add(panelTauxReponse);
		panelInfos.setBorder(new EmptyBorder(20,10,0,10));
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
		nomQuestion.setBorder(new EmptyBorder(3,0,3,0));
		panelQuestionBis.setBorder(BorderFactory.createLineBorder(Color.black));
		panelQuestionBis.add(nomQuestion);
		JButton modifier = new JButton("Modifier");
		panelQuestionBis.add(modifier);
		JButton supprimer = new JButton("X");
		ActBoutonModifQuestionnaire actBouton = new ActBoutonModifQuestionnaire(this.c,this,this.q);
		supprimer.addActionListener(actBouton);
		panelQuestionBis.add(supprimer);
		panelQuestion.setBorder(new EmptyBorder(3,10,3,10));
		panelQuestion.add(panelQuestionBis);
		return panelQuestion;
	}
	private void afficherBoutons(){
		Font police = new Font("Calibri",Font.BOLD,18);
		JPanel panelBoutons = new JPanel();
		panelBoutons.setLayout(new FlowLayout(FlowLayout.CENTER,120,0));
		panelBoutons.setBorder(new EmptyBorder(50,10,50,10));
		ActBoutonModifQuestionnaire actBoutons = new ActBoutonModifQuestionnaire(this.c,this,this.q);
		JButton boutonRetour = new JButton("Annuler");
		boutonRetour.addActionListener(actBoutons);
		boutonRetour.setFont(police);
		JButton boutonSave = new JButton("Sauvegarder");
		boutonSave.addActionListener(actBoutons);
		boutonSave.setFont(police);
		panelBoutons.add(boutonRetour);
		panelBoutons.add(boutonSave);
		panelCentral.add(panelBoutons,"South");
	}
	public int getId(){
		return Integer.parseInt(this.valId.getText());
	}
	public String getNom(){
		return this.valNom.getText();
	}
	public int getPanel(){
		return Integer.parseInt(this.valPanel.getText());
	}
	public int getClient(){
		return Integer.parseInt(this.valClient.getText());
	}
	public int getTauxReponse(){
		return Integer.parseInt(this.valTauxReponse.getText());
	}
	public int getIdAnnuler(){
		return this.id;
	}
	public String getNomAnnuler(){
		return this.nom;
	}
	public int getPanelAnnuler(){
		return this.panel;
	}
	public int getClientAnnuler(){
		return this.client;
	}
	public int getTauxReponseAnnuler(){
		return this.tauxReponse;
	}
}
