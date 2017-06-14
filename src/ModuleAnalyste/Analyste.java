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

public class Analyste extends JFrame {
	
	public Analyste () {
		super("Module Analyste");
		this.setSize(1000,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont = this.getContentPane();
		cont.setLayout(new BorderLayout());
		afficherPanelDuHaut (cont);
		afficherPanelCentre(cont);
		afficherPanelGauche(cont);
		afficherPanelDroit(cont);
		new AnalysteModification(this);
		this.setVisible(true);
	}
	
	public void afficherPanelDroit(Container cont){
		JLabel l1 = new JLabel("                              ");
		cont.add(l1, "East");
	}
	
	public void afficherPanelGauche(Container cont){
		JLabel l2 = new JLabel("                              ");
		cont.add(l2, "West");
	}
	
	public void afficherPanelDuHaut (Container cont) {
		JPanel panelduhaut = new JPanel(new BorderLayout());
		cont.add(panelduhaut, "North");
		
		JPanel boiteImage = new JPanel ();
		panelduhaut.add(boiteImage, "Center");
			// creation de l'image
			JLabel labelImage = new JLabel ();
			boiteImage.add(labelImage);
			Icon source = new ImageIcon("analyste.png");
			ImageIcon imageconnexion = new ImageIcon(((ImageIcon) source).getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT));
			labelImage.setIcon(imageconnexion);	
			
			
	}
	
	public void afficherPanelCentre(Container cont){
		JPanel panelDuCentre = new JPanel();
		panelDuCentre.setLayout(new BoxLayout(panelDuCentre,BoxLayout.Y_AXIS));
		cont.add(panelDuCentre, "Center");
		
		//TITRE
		JPanel pTitre = new JPanel( new FlowLayout(FlowLayout.CENTER));
		panelDuCentre.add(pTitre);
		JLabel titre = new JLabel("Choix du questionnaire");
		pTitre.add(titre);
		titre.setFont(new Font("Arial", Font.PLAIN, 32));
		
		//RECHERCHE
		JPanel pRecherche = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelDuCentre.add(pRecherche);
		
		JTextField champRecherche = new JTextField(30);
		pRecherche.add(champRecherche);
		
		JButton bRecherche = new JButton("Rechercher");
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
		JTable tab = new JTable();
		tab.setModel(modele);
		tab.setFont(new Font("Arial", Font.PLAIN, 17));
		pTableau.setViewportView(tab);
		
		JPanel pValider = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelDuCentre.add(pValider);
		JButton bValider = new JButton("VALIDER");
		pValider.add(bValider);
		
	}
	
	public static void main (String [] args) {
		Analyste a = new Analyste();
	}
}