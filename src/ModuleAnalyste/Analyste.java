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

public class Analyste extends JPanel {
	
	private JTable tab;
	private JTextField champRecherche;
	private AnalysteModele anaMod;
	private AnalysteModification anaModif;
	
	public Analyste (ModeleCommun modelecommun) {
		anaMod = new AnalysteModele(modelecommun);
		this.setLayout(new BorderLayout());
		afficherPanelBase();
		//new AnalysteModification(this);
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
	
	public void afficherPanelBase(){
		this.removeAll();
		afficherPanelDuHaut ();
		afficherPanelCentre();
		afficherPanelGauche();
		afficherPanelDroit();
	}
	
	public void afficherPanelDroit(){
		JLabel l1 = new JLabel("                              ");
		this.add(l1, "East");
	}
	
	public void afficherPanelGauche(){
		JLabel l2 = new JLabel("                              ");
		this.add(l2, "West");
	}
	
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
	
	public void afficherPanelCentre(){
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
	
	public String[][] creationListeQuestionnaires(){
		ArrayList<Questionnaire> listeQuestionnaire = anaMod.getQuestionnaireFini();
		String[][] values = new String[listeQuestionnaire.size()][3];
		for (int i = 0; i< listeQuestionnaire.size(); i++){
				values[i][0] = listeQuestionnaire.get(i).getIdQuestionnaire() + "";
				values[i][1] = listeQuestionnaire.get(i).getTitreQuestionnaire();
				values[i][2] = listeQuestionnaire.get(i).getNumClient() + "";
		}
			
		return values;
	}
	
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
	
	public void afficherAnalysteModification(){
		this.removeAll();
		anaModif  = new AnalysteModification(this);
		anaModif.afficherPanelCentre(this);
	}
}