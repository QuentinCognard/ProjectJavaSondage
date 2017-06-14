package ModuleAnalyste;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

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

import Commun.Sondio;
import ModuleAnalyste.AnalysteController.RechercherController;
import ModuleAnalyste.AnalysteController.ValiderController;

public class Analyste extends JPanel {
	
	private JTable tab;
	private JTextField champRecherche;
	
	public Analyste () {
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
		
		String[] ColumnNames = new String[]{"ID", "NOM", "Prenom"};
		String[][] values = new String[][]{{"001","Lee","Charles"},{"002","La Chouette","Jean-Charles"}};
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
		pTableau.setViewportView(tab);
		
		//validation
		JPanel pValider = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelDuCentre.add(pValider);
		JButton bValider = new JButton("VALIDER");
		bValider.addActionListener(new ValiderController(this));
		pValider.add(bValider);
		
	}
	
	public void afficherAnalysteModification(){
		this.removeAll();
		new AnalysteModification(this);
	}
}