package ModuleAnalyste;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;
import BaseDeDonnees.Questionnaire;
import Commun.ModeleCommun;
import Commun.Sondio;
import ModuleAnalyste.AnalysteController.RechercherController;
import ModuleAnalyste.AnalysteController.ValiderController;

/**
 * Analyste est une classe (vue) qui étend JPanel qui sert de support pour afficher le module analyste
 * @author Julien Revaud
 *
 */

public class Analyste extends JPanel {
	
	/**
	 * La classe principale
	 */
	private Sondio sondio;
	
	/**
	 * Le tableau regroupant les infos des questionnaires
	 */
	private JTable tab;
	
	/**
	 * Le champs de recherche
	 */
	private JTextField champRecherche;
	
	/**
	 * La classe modele du module analyste
	 */
	private AnalysteModele anaMod;
	
	/**
	 * L'autre vue du module analyste
	 */
	private AnalysteModification anaModif;
	
	/**
	   * Constructeur de l'Affichage de base du module analyste
	   * @param modelecommun
	   * 	 permet d'obtenir les classes principales
	   */
	public Analyste (ModeleCommun modelecommun) {
		anaMod = new AnalysteModele(modelecommun);
		sondio = modelecommun.getSondio();
		this.setLayout(new BorderLayout());
		afficherPanelBase();
		//new AnalysteModification(this);
	}
	
	public Sondio getSondio(){
		return sondio;
	}
	
	public JTable getTableau(){
		return tab;
	}
	
	public String getTexteRecherche(){
		return champRecherche.getText();
	}
	
	public AnalysteModele getModeleAnalyste(){
		return anaMod;
	}
	
	public AnalysteModification getAnalysteModification(){
		return anaModif;
	}
	
	/**
	   * Affiche le panel de base du module analyste
	   */
	public void afficherPanelBase(){
		this.removeAll();
		afficherPanelDuHaut ();
		afficherPanelCentre();
		afficherPanelGauche();
		afficherPanelDroit();
	}
	
	/**
	   * Affiche le panel droit du panel de base du module analyste
	   */
	private void afficherPanelDroit(){
		JLabel l1 = new JLabel("                              ");
		this.add(l1, "East");
	}
	
	/**
	   * Affiche le panel gauche du panel de base du module analyste
	   */
	private void afficherPanelGauche(){
		JLabel l2 = new JLabel("                              ");
		this.add(l2, "West");
	}
	
	/**
	   * Affiche le panel du haut du module analyste
	   */
	public void afficherPanelDuHaut () {
		JPanel panelduhaut = new JPanel(new BorderLayout());
		this.add(panelduhaut, "North");
		
		JPanel boiteImage = new JPanel ();
		panelduhaut.add(boiteImage, "Center");
			// creation de l'image
			JLabel labelImage = new JLabel ();
			boiteImage.add(labelImage);
			Icon source = new ImageIcon("analyste.png");
			ImageIcon imageconnexion = new ImageIcon(((ImageIcon) source).getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT));
			labelImage.setIcon(imageconnexion);		
	}
	
	/**
	   * Affiche le panel du centre du panel de base du module analyste
	   */
	private void afficherPanelCentre(){
		JPanel panelDuCentre = new JPanel();
		panelDuCentre.setLayout(new BoxLayout(panelDuCentre,BoxLayout.Y_AXIS));
		this.add(panelDuCentre, "Center");
		
		//TITRE
		JPanel pTitre = new JPanel( new FlowLayout(FlowLayout.CENTER));
		panelDuCentre.add(pTitre);
		JLabel titre = new JLabel("Choix du questionnaire");
		pTitre.add(titre);
		titre.setFont(new Font("Arial", Font.PLAIN, 32));
		
		//RECHERCHE
		JPanel pRecherche = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelDuCentre.add(pRecherche);
		
		champRecherche = new JTextField(30);
		pRecherche.add(champRecherche);
		
		JButton bRecherche = new JButton("Rechercher");
		bRecherche.addActionListener(new RechercherController(this));
		pRecherche.add(bRecherche);
		
		//TABLEAU et VALIDATION
		JScrollPane pTableau = new JScrollPane();
		pTableau.setLayout(new ScrollPaneLayout());
		panelDuCentre.add(pTableau);
		

		try{
			pTableau.setViewportView(creationTableau());
		}
		catch (TableauVideExeption e){
			JPanel tabVide = new JPanel(new FlowLayout(FlowLayout.CENTER));
			tabVide.add(new JLabel("Aucun élément trouvé"));
			pTableau.setViewportView(tabVide);
		}
		
		//validation
		JPanel pValider = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelDuCentre.add(pValider);
		JButton bValider = new JButton("VALIDER");
		bValider.addActionListener(new ValiderController(this));
		pValider.add(bValider);
		
	}
	
	/**
	   * créer la liste de l'id, du nom et du numéro client des questionnaires pret à être analysé
	   * @return une Array d'Array (liste de liste) contenant l'id le nom et le numéro client de chaque questionnaire pret à etre analysé
	   */
	private String[][] creationListeQuestionnaires(){
		ArrayList<Questionnaire> listeQuestionnaire = anaMod.getQuestionnaireFini();
		String[][] values = new String[listeQuestionnaire.size()][3];
		for (int i = 0; i< listeQuestionnaire.size(); i++){
				values[i][0] = listeQuestionnaire.get(i).getIdQuestionnaire() + "";
				values[i][1] = listeQuestionnaire.get(i).getTitreQuestionnaire();
				values[i][2] = listeQuestionnaire.get(i).getNumClient() + "";
		}
			
		return values;
	}
	
	/**
	   * créer un tableau de questionnaire pret à être analysé
	   * @throws TableauVideExeption
	   * @return un tableau de type JTable
	   */
	public JTable creationTableau() throws TableauVideExeption{
		String[] ColumnNames = new String[]{"ID", "NOM QUESTIONNAIRE", "NUM CLIENT"};
		String[][] values = creationListeQuestionnaires();
		DefaultTableModel modele = new DefaultTableModel(values,ColumnNames){
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tab = new JTable();
		tab.setModel(modele);
		tab.setFont(new Font("Arial", Font.PLAIN, 17));
		
		if (tab.getRowCount() == 0)
			throw new TableauVideExeption();
		
		return tab;
	}
	
	/**
	   * affiche la deuxième vue qui permet d'analyser un questionnaire
	   */
	public void afficherAnalysteModification(){
		this.removeAll();
		anaModif  = new AnalysteModification(this);
		anaModif.afficherPanelCentre(this);
	}
}