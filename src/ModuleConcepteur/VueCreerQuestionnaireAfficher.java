package ModuleConcepteur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class VueCreerQuestionnaireAfficher extends JPanel {
	private int id;
	private String nom;
	private String panel;
	private String societe;
	private String tauxReponse;
	ArrayList<AjouterQuestion> ajouterQuestion;
	private JLabel JLid;
	private JLabel JLnom;
	private JLabel JLpanel;
	private JLabel JLsociete;
	private JLabel JLtaux;
	private JPanel listeQuestions;
	
	VueCreerQuestionnaireAfficher(){
		this.id = 0;
		this.nom = "";
		this.panel = "";
		this.societe = "";
		this.tauxReponse = "";
		this.ajouterQuestion = new ArrayList<AjouterQuestion>();
		panelCentral();
	}
	
	public void setId(int id){
		this.id = id;
		JLid.setText("Id : "+this.id);
	}
	
	public void setNom(String nom){
		this.nom = nom;
		JLnom.setText("Nom : "+this.nom);
	}
	
	public void setPanel(String panel){
		this.panel = panel;
		JLpanel.setText("Panel concerné : "+this.panel);
	}

	public void setSociete(String societe){
		this.societe = societe;
		JLsociete.setText("Société concernée : "+this.societe);
	}

	public void setTaux(String taux){
		this.tauxReponse = taux;
		JLtaux.setText("Taux de réponses minimum : "+this.tauxReponse);
	}
	
	public void ajouterQuestion(String in,ArrayList<String> lis){
		AjouterQuestion q = new AjouterQuestion(in,lis);
		this.ajouterQuestion.add(q);
		listeQuestions.add(creerQuestion(q.getIntitule()));
	}
	
	private void panelCentral(){
		this.setLayout(new BorderLayout());
		afficherPanelInfos();
		afficherListeQuestions();
	}
	
	private void afficherPanelInfos(){
		Font police = new Font("Calibri",Font.BOLD,20);
		JPanel panelInfos = new JPanel();
		panelInfos.setLayout(new BoxLayout(panelInfos,BoxLayout.Y_AXIS));
		JLid = new JLabel("Id : "+this.id);
		JLid.setBorder(new EmptyBorder(40,30,20,10)); //top-left-bottom-right
		JLid.setFont(police);
		JLnom = new JLabel("Nom : "+this.nom);
		JLnom.setBorder(new EmptyBorder(20,30,20,10));
		JLnom.setFont(police);
		JLpanel = new JLabel("Panel concerné : "+this.panel);
		JLpanel.setBorder(new EmptyBorder(20,30,20,10));
		JLpanel.setFont(police);
		JLsociete = new JLabel("Société concernée : "+this.societe);
		JLsociete.setBorder(new EmptyBorder(20,30,20,10));
		JLsociete.setFont(police);
		JLtaux = new JLabel("Taux de réponses minimum : "+this.tauxReponse);
		JLtaux.setBorder(new EmptyBorder(20,30,20,10));
		JLtaux.setFont(police);
		panelInfos.add(JLid);
		panelInfos.add(JLnom);
		panelInfos.add(JLpanel);
		panelInfos.add(JLsociete);
		panelInfos.add(JLtaux);
		this.add(panelInfos,"West");
		
		
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
		listeQuestions = new JPanel();
		listeQuestions.setLayout(new BoxLayout(listeQuestions,BoxLayout.Y_AXIS));
		panelListeQuestions.add(listeQuestions);
		JScrollPane scrollQuestions = new JScrollPane(panelListeQuestions);
		scrollQuestions.setPreferredSize(getPreferredSize());
		panelQuestionsBorder.add(titrePanelQuestions);
		panelQuestionsBorder.add(scrollQuestions);
		panelQuestionsBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		panelQuestions.add(panelQuestionsBorder);
		panelQuestions.setBorder(new EmptyBorder(20,20,20,20));
		this.add(panelQuestions,"East");

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
	
}
