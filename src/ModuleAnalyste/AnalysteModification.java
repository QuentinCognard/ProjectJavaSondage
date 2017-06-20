package ModuleAnalyste;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import BaseDeDonnees.Question;
import BaseDeDonnees.Repondre;
import ModuleAnalyste.AnalysteController.ModifController;
import ModuleAnalyste.AnalysteController.RegroupementController;
import ModuleAnalyste.AnalysteController.TabbedController;





public class AnalysteModification {
	
	private ModifController mc;
	private Analyste ana;
	private JTextArea fieldCommentaireFinal;
	private ArrayList<JTabbedPane> listepGraphs;
	private ArrayList<JComboBox<String>> listeBoutonsRegroupement;
	//private ArrayList<JPanel> listePanelQuestions;
	
	
	public AnalysteModification(Analyste ana){
		this.ana = ana;
		mc = new ModifController(ana);//controller des boutons
		listepGraphs = new ArrayList<JTabbedPane>();
		listeBoutonsRegroupement = new ArrayList<JComboBox<String>>();
		ana.afficherPanelDuHaut();
		MofifierPanelDuHaut(ana);
		afficherPanelBas(ana);
	}
	
	public boolean isComment(){
		if (!fieldCommentaireFinal.getText().equals(""))
			return true;
		return false;
	}
	
	public ArrayList<JComboBox<String>> getListeBoutonsRegroupement(){
		return listeBoutonsRegroupement;
	}
	
	public void MofifierPanelDuHaut(Container cont){
		JPanel pHaut = (JPanel) cont.getComponent(0);
		afficherPanelSupp(pHaut);
		afficherPanelEnregistrerEtDeco(pHaut);
	}
	
	public void afficherPanelSupp(JPanel pHaut){
		JPanel pGeneGauche = new JPanel(new BorderLayout());
		pHaut.add(pGeneGauche,"West");
		JPanel pBouttonSupRetour = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pGeneGauche.add(pBouttonSupRetour,"South");
		
		JButton retour = new JButton("<== Retour");
		retour.addActionListener(mc);
		pBouttonSupRetour.add(retour);
		
		JButton supp = new JButton("Supprimer");
		supp.addActionListener(mc);
		pBouttonSupRetour.add(supp);
	}
	
	public void afficherPanelEnregistrerEtDeco(JPanel pHaut){
		JPanel pGeneDroit = new JPanel(new BorderLayout());
		pHaut.add(pGeneDroit,"East");
		JPanel pBouttonAnnuleSave = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pGeneDroit.add(pBouttonAnnuleSave,"South");
		
		JButton annule = new JButton("Annuler");
		annule.addActionListener(mc);
		pBouttonAnnuleSave.add(annule);
		
		JButton save = new JButton("Enregistrer");
		save.addActionListener(mc);
		pBouttonAnnuleSave.add(save);
		
		afficherPanelDeconnexion(pGeneDroit);
	}
	
	public void afficherPanelDeconnexion(JPanel pGeneDroit){
		JPanel pDeconnexion = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pGeneDroit.add(pDeconnexion,"East");
		
		JButton deco = new JButton("Se deconnecter");
		deco.addActionListener(mc);
		pDeconnexion.add(deco);
	}
	
	public void afficherPanelCentre(Container cont){
		JPanel panelDuCentre = new JPanel();
		panelDuCentre.setLayout(new BoxLayout(panelDuCentre,BoxLayout.Y_AXIS));
		cont.add(panelDuCentre, "Center");
		
		
		//FENETRE DU MILIEU
		JScrollPane f = new JScrollPane();
		f.setLayout(new ScrollPaneLayout());
		Dimension size = new Dimension(200,300);
		f.setPreferredSize(size);
		panelDuCentre.add(f);
		f.getVerticalScrollBar().setUnitIncrement(16);
		
		//AFFICHAGE DES RESULTATS
		afficherResultats(f);
		
	}
	
	public void afficherPanelBas(Container cont){
		JPanel panelDuBas = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cont.add(panelDuBas, "South");
		
		
		//BOUTON PDF
		JPanel pPDF = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelDuBas.add(pPDF);
		JButton bPDF = new JButton("Generer un PDF");
		bPDF.addActionListener(mc);
		pPDF.add(bPDF);
	}
	
	public void afficherResultats(JScrollPane jsp){
		JPanel pResultats = new JPanel();
		pResultats.setLayout(new BoxLayout(pResultats, BoxLayout.Y_AXIS));
		jsp.setViewportView(pResultats);
		//ana.getModeleAnalyste().getListeQuestionsReponses();int i = 0; i< ana.getModeleAnalyste().getListeQuestionsReponses().size(); i++
		for (Question q : ana.getModeleAnalyste().getListeQuestions()){
				afficherQuestion(pResultats,q);
				JPanel pvide = new JPanel();
				pvide.setLayout(new BoxLayout(pvide, BoxLayout.Y_AXIS));
				for ( int j = 0; j<5;j++){
					pvide.add(new JLabel("                    "));
				}
				pResultats.add(pvide);
		}
		//PANEL COMMENTAIRE FINAL
			JPanel pCommentaireFinal = new JPanel();
			pCommentaireFinal.setLayout(new BoxLayout(pCommentaireFinal, BoxLayout.Y_AXIS));
			pResultats.add(pCommentaireFinal);
			
			JPanel pLabelCommentaire = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel labelCommentaire = new JLabel("Commentaire final (obligatoire) : ");
			pLabelCommentaire.add(labelCommentaire);
			pCommentaireFinal.add(pLabelCommentaire);
			
			JPanel gpFieldCF = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JScrollPane pFieldCommentaireFinal = new JScrollPane();
			pFieldCommentaireFinal.setLayout(new ScrollPaneLayout());
			gpFieldCF.add(pFieldCommentaireFinal);
			pCommentaireFinal.add(gpFieldCF);
			fieldCommentaireFinal = new JTextArea(10,80);
			pFieldCommentaireFinal.setViewportView(fieldCommentaireFinal);
	}

	public void afficherQuestion(JPanel pResultats,Question q){
		JPanel pReponse = new JPanel(new BorderLayout());
		//pReponse.setName(q.getNumeroQuestion() + "");
		//listePanelQuestions.add(pReponse);
		pResultats.add(pReponse);
		
		//PANEL TITRE Question
			JPanel pTitreQuestion = new JPanel(new FlowLayout(FlowLayout.CENTER));
			pReponse.add(pTitreQuestion, "North");
			
			JLabel titre = new JLabel("Question "+q.getNumeroQuestion()+" : "+q.getTexteQuestion());
			pTitreQuestion.add(titre);
			titre.setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		//PANEL GRAPH
			JTabbedPane pGraph = new JTabbedPane();
			listepGraphs.add(pGraph);
			pGraph.setName(q.getNumeroQuestion()+"");
			pGraph.addChangeListener(new TabbedController(ana));
			Dimension dim1 = new Dimension(510,315);
			pGraph.setPreferredSize(dim1);
			pReponse.add(pGraph,"West");
			
			//Tableau INITIALISATION
			JPanel vide = new JPanel();
			pGraph.add("Tableau",vide);
			
			//Graphique Camembert INITIALISATION
			JPanel vide2 = new JPanel();
			pGraph.add("Camembert", vide2);
			

			//Graphique en bar INITIALISATION
			JPanel vide3 = new JPanel();
			pGraph.add("Bar", vide3);
				      			
			
			
			
		//PANEL REGROUPEMENT
			JPanel pRegroupement = new JPanel(new BorderLayout());
			pReponse.add(pRegroupement,"Center");
			
			JPanel sousPanelR = new JPanel(new FlowLayout(FlowLayout.CENTER));
			pRegroupement.add(sousPanelR,"North");
			
			JPanel sousPanelR2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			pRegroupement.add(sousPanelR2,"Center");
			
			JLabel labelRegroupement = new JLabel("Regroupement : ");
			String[] dataRegroupement = new String[]{"Categorie socio-professionnel","Age","Reponses donnees"};
			JComboBox<String> regroupement = new JComboBox<String>(dataRegroupement);
			regroupement.setName(q.getNumeroQuestion()+"");
			regroupement.addActionListener(new RegroupementController(ana));
			listeBoutonsRegroupement.add(regroupement);
			sousPanelR.add(labelRegroupement);
			sousPanelR2.add(regroupement);
			regroupement.setSelectedIndex(0);
			
		//PANEL COMMENTAIRE
			JPanel pCommentaire = new JPanel();
			pCommentaire.setLayout(new FlowLayout(FlowLayout.LEFT));
			pReponse.add(pCommentaire,"South");
			
			JLabel labelCommentaire = new JLabel("Commentaire (facultatif) : ");
			pCommentaire.add(labelCommentaire);
			
			JScrollPane pFieldCommentaire = new JScrollPane();
			pFieldCommentaire.setLayout(new ScrollPaneLayout());
			pCommentaire.add(pFieldCommentaire);
			JTextArea fieldCommentaire = new JTextArea(5,50);
			pFieldCommentaire.setViewportView(fieldCommentaire);
			
		//SELECTION DE BASE
			System.out.println("Index Selectioné :"+pGraph.getSelectedIndex());
			pGraph.setSelectedIndex(1);
			pGraph.setSelectedIndex(0);
			System.out.println("Index Selectioné :"+pGraph.getSelectedIndex());
		
	}
	
	public void majTab(DefaultTableModel modele, int numQuest){ //a mettre dans le controller après la fct du modèleAnalyste de création du modèle tab
		JScrollPane pTab = new JScrollPane();
		JTable tab = new JTable();
		tab.setModel(modele);
		tab.setFont(new Font("Arial", Font.PLAIN, 14));
		pTab.setViewportView(tab);
		for (JTabbedPane g : listepGraphs){
			if (g.getName().equals(numQuest + "")){
				//g.add(pTab,"Tableau");
				g.setComponentAt(0,pTab);
				return;
			}
		}
	}
	
	public void majPieChart(DefaultPieDataset data, int numQuest){ //a mettre dans le controller après la fct du modèleAnalyste du DATA PieChart
		JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", data);
		ChartPanel chartPan  = new ChartPanel(pieChart);
		//Dimension dim = new Dimension(408,252);
		//chartPan.setPreferredSize(dim);
		chartPan.setVisible(true);
		for (JTabbedPane g : listepGraphs){
			if (g.getName().equals(numQuest + "")){
				//g.add(chartPan,"Camembert");
				g.setComponentAt(1,chartPan);
				return;
			}
		}
	}
	
	public void majBarChart(DefaultCategoryDataset dataset, int numQuest){ //a mettre dans le controller après la fct du modèleAnalyste du DATA BarChart
		JFreeChart barChart = ChartFactory.createBarChart("Line Chart", "Domain", "Range", dataset);
		ChartPanel chartPan2  = new ChartPanel(barChart);
		//Dimension dim = new Dimension(408,252);
		//chartPan.setPreferredSize(dim);
		chartPan2.setVisible(true);
		for (JTabbedPane g : listepGraphs){
			if (g.getName().equals(numQuest + "")){
				g.add(chartPan2,"Bar");
				g.setComponentAt(2,chartPan2);
				return;
			}
		}
	}
}
