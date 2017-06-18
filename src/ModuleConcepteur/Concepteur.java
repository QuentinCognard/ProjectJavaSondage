package ModuleConcepteur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import Commun.ModeleCommun;
import BaseDeDonnees.BDGeneral;
import BaseDeDonnees.Questionnaire;


public class Concepteur extends JPanel {
	
	private VueCreerQuestionnaire creerQuestionnaire;
	private JPanel base;
	private JPanel panelDuBas;
	private JPanel listeQuestionnaires;
	private BDGeneral bdgeneral;
	
	
	public Concepteur (ModeleCommun modele) {
		super();
		this.setLayout(new BorderLayout());
		this.bdgeneral = modele.getBdGeneral();
		afficherPanelHaut(); 
		afficherPanelMilieu();
		afficherPanelBas();
	}
	
	public ArrayList<QuestionnairePanel> recupQuestionnaires(){
		ArrayList <Questionnaire> listeQuestionnaires = this.bdgeneral.getListeQuestionnaire('C');
		ArrayList<QuestionnairePanel> liste = new ArrayList<QuestionnairePanel>();
		for(Questionnaire q : listeQuestionnaires){
			liste.add(creerQuestionnaire(q));
		}
		return liste;
	}
	
	public void afficherPanelHaut() {
		JPanel panelDuHaut = new JPanel();
		this.add(panelDuHaut, "North");
		panelDuHaut.setLayout(new BorderLayout());
		JPanel boiteImage = new JPanel();
		panelDuHaut.add(boiteImage,"Center");
		// creation de l'image
		JLabel labelImage = new JLabel();
		boiteImage.add(labelImage);
		Icon source = new ImageIcon("concepteur.png");
		ImageIcon imageconnexion = new ImageIcon(((ImageIcon) source).getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT));
		labelImage.setIcon(imageconnexion);
	}
	
	public void afficherPanelMilieu() {
		this.base = new JPanel();
		base.setLayout(new FlowLayout(FlowLayout.CENTER,200,10));
		JButton bouton = new JButton("Créer questionnaire");
		bouton.setFont(new Font("Calibri",Font.BOLD,26));
		JLabel mesQuestionnaires = new JLabel("Mes questionnaires");
		mesQuestionnaires.setFont(new Font("Calibri", Font.BOLD, 40));
		ActionBoutonConcepteur act = new ActionBoutonConcepteur(this);
		bouton.addActionListener(act);
		this.base.add(mesQuestionnaires);
		this.base.add(bouton);;
		this.base.setPreferredSize(getPreferredSize());
		this.add(this.base,"Center");
	}
	private void afficherPanelBas(){
		this.panelDuBas = new JPanel();
		JPanel panelSearch = new JPanel();
		JPanel panelListeQuestionnaire = new JPanel();
		this.listeQuestionnaires = new JPanel();
		listeQuestionnaires.setLayout(new BoxLayout(listeQuestionnaires,BoxLayout.Y_AXIS));
		panelListeQuestionnaire.setLayout(new BoxLayout(panelListeQuestionnaire, BoxLayout.Y_AXIS)); //Le panel principal
		panelDuBas.setLayout(new BoxLayout(panelDuBas,BoxLayout.Y_AXIS));
		panelDuBas.setBorder(BorderFactory.createLineBorder(Color.black));
		JTextField searchBar = new JTextField(30);
		searchBar.setText("search");
		searchBar.setMaximumSize(new Dimension(250,20));
		FocusSearchBar focusSearchBar = new FocusSearchBar(searchBar);
		searchBar.addFocusListener(focusSearchBar);
		panelSearch.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		panelSearch.add(searchBar);
		ArrayList<QuestionnairePanel> listePanelsQuestionnaires = recupQuestionnaires(); //la liste des panels
		for(JPanel panel : listePanelsQuestionnaires){
			listeQuestionnaires.add(panel);
		}
		JScrollPane scrollQuestionnaires = new JScrollPane(listeQuestionnaires);
		scrollQuestionnaires.setPreferredSize(getPreferredSize());
		panelListeQuestionnaire.add(scrollQuestionnaires);
		panelDuBas.add(panelSearch);
		panelDuBas.add(panelListeQuestionnaire);
		this.add(panelDuBas,"South");
		}
	private QuestionnairePanel creerQuestionnaire(Questionnaire q){
		Font police = new Font("Calibri",Font.BOLD,26);
		QuestionnairePanel panelQuestionnaire = new QuestionnairePanel(q);
		panelQuestionnaire.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		panelQuestionnaire.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel idQuestionnaire = new JLabel(""+q.getNumeroQuestionnaire());
		idQuestionnaire.setFont(police);
		idQuestionnaire.setBorder(BorderFactory.createLineBorder(Color.black));
		panelQuestionnaire.add(idQuestionnaire);
		JLabel titreQuestionnaire = new JLabel("Titre :");
		titreQuestionnaire.setFont(police);
		panelQuestionnaire.add(titreQuestionnaire);
		JLabel intituleTitre = new JLabel(q.getTitreQuestionnaire());
		intituleTitre.setFont(police);
		intituleTitre.setBorder(BorderFactory.createLineBorder(Color.black));
		panelQuestionnaire.add(intituleTitre);
		JLabel clientQuestionnaire = new JLabel("Client :");
		clientQuestionnaire.setFont(police);
		panelQuestionnaire.add(clientQuestionnaire);
		JLabel intituleClient = new JLabel(""+q.getNumClient());
		intituleClient.setBorder(BorderFactory.createLineBorder(Color.black));
		intituleClient.setFont(police);
		panelQuestionnaire.add(intituleClient);
		MouseListenerQuestionnaire mouseListener = new MouseListenerQuestionnaire(this,panelQuestionnaire);
		panelQuestionnaire.addMouseListener(mouseListener);
		return panelQuestionnaire;
	}
	
	public void afficherCreerQuestionnaire(){
		this.removeAll();
		this.afficherPanelHaut();
		this.creerQuestionnaire = new VueCreerQuestionnaire(this);
		this.add(this.creerQuestionnaire,"Center");
		this.validate();
		this.repaint();
	}
	public void afficherInfoQuestionnaire(Questionnaire q){
		this.removeAll();
		this.afficherPanelHaut();
		this.afficherPanelMilieu();
		new AffichageQuestionnaire(this,q);
		this.validate();
		this.repaint();
	}
	public void afficherConcepteur(){
		this.removeAll();
		afficherPanelHaut();
		afficherPanelMilieu();
		afficherPanelBas();
		this.validate();
		this.repaint();
	}
	public void afficherModifQuestionnaire(Questionnaire q){
		this.removeAll();
		this.afficherPanelHaut();
		this.afficherPanelMilieu();
		new ModificationQuestionnaire(this,q);
		this.validate();
		this.repaint();
	}
	public void afficherAjouterQuestion(AffichageQuestionnaire vue, Questionnaire q){
		this.removeAll();
		afficherPanelHaut();
		this.add(new VueAjouterQuestion(this,vue,q),"Center");
		this.validate();
		this.repaint();
	}
}
