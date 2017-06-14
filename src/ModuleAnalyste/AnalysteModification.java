package ModuleAnalyste;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;


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





public class AnalysteModification extends JPanel {
	
	public AnalysteModification(Analyste ana){
		Container cont = ana.getContentPane();
		cont.removeAll();
		ana.afficherPanelDuHaut(cont);
		MofifierPanelDuHaut(cont);
		afficherPanelCentre(cont);
		afficherPanelBas(cont);
	}
	
	public void MofifierPanelDuHaut(Container cont){
		JPanel pHaut = (JPanel) cont.getComponent(0);
		afficherPanelModif(pHaut);
		afficherPanelEnregistrerEtDeco(pHaut);
		afficherPanelRetour(pHaut);
	}
	
	public void afficherPanelModif(JPanel pHaut){
		JPanel pGeneGauche = new JPanel(new BorderLayout());
		pHaut.add(pGeneGauche,"West");
		JPanel pBouttonModifSup = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pGeneGauche.add(pBouttonModifSup,"South");
		
		JButton modif = new JButton("Modifier");
		pBouttonModifSup.add(modif);
		
		JButton supp = new JButton("Supprimer");
		pBouttonModifSup.add(supp);
	}
	
	public void afficherPanelEnregistrerEtDeco(JPanel pHaut){
		JPanel pGeneDroit = new JPanel(new BorderLayout());
		pHaut.add(pGeneDroit,"East");
		JPanel pBouttonAnnuleSave = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pGeneDroit.add(pBouttonAnnuleSave,"South");
		
		JButton annule = new JButton("Annuler");
		pBouttonAnnuleSave.add(annule);
		
		JButton save = new JButton("Enregistrer");
		pBouttonAnnuleSave.add(save);
		
		afficherPanelDeconnexion(pGeneDroit);
	}
	
	public void afficherPanelRetour(JPanel pHaut){
		JPanel pRetour = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pHaut.add(pRetour,"South");
		
		JButton retour = new JButton("<== Retour");
		pRetour.add(retour);
	}
	
	public void afficherPanelDeconnexion(JPanel pGeneDroit){
		JPanel pDeconnexion = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pGeneDroit.add(pDeconnexion,"East");
		
		JButton deco = new JButton("Se deconnecter");
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
		pPDF.add(bPDF);
	}
	
	public void afficherResultats(JScrollPane jsp){
		JPanel pResultats = new JPanel();
		pResultats.setLayout(new BoxLayout(pResultats, BoxLayout.Y_AXIS));
		jsp.setViewportView(pResultats);
		for (int i = 0; i< 20; i++){ //TODO: � modifier
				afficherQuestion(pResultats,i+1,"Quel est le plus grand con de tout les temps ?");
				JPanel pvide = new JPanel();
				pvide.setLayout(new BoxLayout(pvide, BoxLayout.Y_AXIS));
				for ( int j = 0; j<5;j++){
					pvide.add(new JLabel("                    "));
				}
				pResultats.add(pvide);
		}
	}

	public void afficherQuestion(JPanel pResultats, int i, String titreQuestion){
		JPanel pReponse = new JPanel(new BorderLayout());
		pResultats.add(pReponse);
		
		//PANEL TITRE Question
			JPanel pTitreQuestion = new JPanel(new FlowLayout(FlowLayout.CENTER));
			pReponse.add(pTitreQuestion, "North");
			
			JLabel titre = new JLabel("Question "+i+" : "+titreQuestion);
			pTitreQuestion.add(titre);
			titre.setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		//PANEL GRAPH
			JTabbedPane pGraph = new JTabbedPane();
			Dimension dim1 = new Dimension(510,315);
			pGraph.setPreferredSize(dim1);
			pReponse.add(pGraph,"West");
			
			//Tableau
			String[] ColumnNames = new String[]{"Regpmt/Rep","Moi", "Lui", "Trump"};
			String[][] values = new String[][]{{"18-25 ans","25","12","85"},{"25-35 ans","2","12","952"}};
			DefaultTableModel modele = new DefaultTableModel(values,ColumnNames){
				@Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			};
			JTable tab = new JTable();
			tab.setModel(modele);
			tab.setFont(new Font("Arial", Font.PLAIN, 14));
			pGraph.add(tab,"Tableau");
			
			//Graphique Camembert
			DefaultPieDataset data = new DefaultPieDataset();
	        data.setValue("Java", new Double(43.2));
	        data.setValue("Visual Basic", new Double(2.0));
	        data.setValue("C/C++", new Double(17.5));
			
			JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", data);
			
			ChartPanel chartPan  = new ChartPanel(pieChart);
			//Dimension dim = new Dimension(408,252);
			//chartPan.setPreferredSize(dim);
			pGraph.add(chartPan,"Camembert");

			//Graphique en bar #IL FAUDRAIT FAIRE LES REGROUPEMENT PANEL et REPONSES
			final DefaultCategoryDataset dataset = 
				      new DefaultCategoryDataset( );  

				      dataset.addValue( 1.0 , "moi" , "18-25 ans" );        
				      dataset.addValue( 3.0 , "lui" , "18-25 ans" );        
				      dataset.addValue( 5.0 , "trump" , "18-25 ans" );           

				      dataset.addValue( 5.0 , "moi" , "25-35 ans" );        
				      dataset.addValue( 6.0 , "lui" , "25-35 ans" );       
				      dataset.addValue( 10.0 , "trump" , "25-35 ans" );        
				      			
			JFreeChart barChart = ChartFactory.createBarChart("Line Chart", "Domain", "Range",
	                dataset);
			
			ChartPanel chartPan2  = new ChartPanel(barChart);
			//Dimension dim = new Dimension(408,252);
			//chartPan.setPreferredSize(dim);
			chartPan.setVisible(true);
			pGraph.add(chartPan2,"Bar");
			
			
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
			sousPanelR.add(labelRegroupement);
			sousPanelR2.add(regroupement);
			
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
		
	}
	
}
