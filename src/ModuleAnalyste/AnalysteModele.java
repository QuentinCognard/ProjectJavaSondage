package ModuleAnalyste;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

import BaseDeDonnees.BDGeneral;
import BaseDeDonnees.BDModuleAnalyste;
import BaseDeDonnees.Categorie;
import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Repondre;
import BaseDeDonnees.Tranche;
import BaseDeDonnees.ValeurPossible;
import Commun.ModeleCommun;
import Commun.Sondio;

/**
 * AnalysteModele est une classe (modele) qui fait tout les calculs necessaire au module analyste
 * @author Julien Revaud
 *
 */

public class AnalysteModele {
	
	private ModeleCommun modelecommun;
	
	private int idQuestionnaireChoisi;
	/**
	 * La classe generale qui fait le lien avec la Base de données
	 */
	private BDGeneral BDGen;
	
	/**
	 * La classe spéciale analyste qui fait le lien avec la Base de données
	 */
	private BDModuleAnalyste BDAnalyste;
	
	/**
	 * La liste des questions du questionnaire choisit
	 */
	private ArrayList<Question> listeQuestions;
	
	/**
	 * Le dico reliant pour chaque question la liste des réponses données
	 */
	private HashMap<Question,ArrayList<Repondre>> listeQuestionsReponses;
	
	/**
	 * Le dico reliant pour chaque question la liste des valeurs possible
	 */
	private HashMap<Question,ArrayList<ValeurPossible>> listeQuestionsValPossible;
	
	/**
	 * La liste des tranches d'ages présentes dans le questionnaire
	 */
	private ArrayList<Tranche> listeTranchesPresentes;
	
	/**
	 * La liste des catégories présentes dans le questionnaire
	 */
	private ArrayList<Categorie> listeCategoriesPresentes;
	
	/**
	   * Cré le modèle pour le module analyste
	   * @param modelecommun
	   * 	 permet d'obtenir les classes principales
	   */
	public AnalysteModele( ModeleCommun modCommun){
		this.modelecommun = modCommun;
		this.BDGen = modCommun.getBdGeneral();
		this.BDAnalyste = new BDModuleAnalyste(modCommun.getBdConnexion());
		this.listeQuestionsReponses = new HashMap<Question,ArrayList<Repondre>>();
		this.listeQuestionsValPossible = new HashMap<Question,ArrayList<ValeurPossible>>();
	}
	
	public void setIdQuestionnaire(int idQ){
		this.idQuestionnaireChoisi = idQ;
	}
	
	public int getIdQuestionnaire(){
		return this.idQuestionnaireChoisi;
	}
	
	public HashMap<Question,ArrayList<Repondre>> getListeQuestionsReponses(){
		return listeQuestionsReponses;
	}
	
	public ArrayList<Question> getListeQuestions(){
		return listeQuestions;
	}
	
	public HashMap<Question,ArrayList<ValeurPossible>> getListeQuestionsValPossible(){
		return listeQuestionsValPossible;
	}
	
	/**
	   * cré la liste des questions en fonction du questionnaire choisi
	   */
	public void createListesQuestions(){
		listeQuestions = getListeQuestionsBD();
	}
	
	/**
	   * cré la liste des questions associé aux valeurs possibles en fonction du questionnaire choisi
	   */
	public void createListesQuestionsValPossible(){
		for(int i = 0; i<listeQuestions.size(); i++){
			listeQuestionsValPossible.put(listeQuestions.get(i), getListeValPossible(i+1) );
		}
	}
	
	/**
	   * cré la liste des questions associé aux réponses données en fonction du questionnaire choisi
	   */
	public void createListesQuestionsReponses(){
		for(int i = 0; i<listeQuestions.size(); i++){
			listeQuestionsReponses.put(listeQuestions.get(i), getReponsesQuestion(i+1) );
		}
	}
	/**
	   * cré la liste des tranches d'ages présente dans le questionnaire choisi
	   */
	public void createListeTranchesPresentes(){
		listeTranchesPresentes = BDAnalyste.getTranchesQuestionnaire(idQuestionnaireChoisi);
	}
	
	/**
	   * cré la liste des catégories présente dans le questionnaire choisi
	   */
	public void createListeCategoriesPresentes(){
		listeCategoriesPresentes = BDAnalyste.getCategoriesQuestionnaire(idQuestionnaireChoisi);
	}
	
	/**
	   * Retourne la liste de questionnaires pret à etre analysé
	   * @return une ArrayList de questionnaire
	   */
	public ArrayList<Questionnaire> getQuestionnaireFini(){
		return BDGen.getListeQuestionnaire('A');
	}
	/**
	   * Retourne la liste des questions associé à un questionnaire
	   * @return une ArrayList de question
	   */
	public ArrayList<Question> getListeQuestionsBD(){
		return BDGen.getListeQuestion (idQuestionnaireChoisi);
	}
	/**
	   * Retourne la liste des reponses selon une question d'un questionnaire
	   * @param numeroQuestion
	   * 	 numero de la question
	   * @return une ArrayList de Repondre
	   */
	public ArrayList<Repondre> getReponsesQuestion(int numeroQuestion){
		return BDAnalyste.getReponsesQuestion(idQuestionnaireChoisi, numeroQuestion);
	}
	
	/**
	   * Retourne la liste des valeurs possible selon une question d'un questionnaire
	   * @param numeroQuestion
	   * 	 numero de la question
	   * @return une ArrayList de ValeurPossible
	   */
	public ArrayList<ValeurPossible> getListeValPossible(int numQuestion){
		return BDGen.getListeValPossible (idQuestionnaireChoisi, numQuestion);
	}
	
	/**
	   * Permet de revenir à l'écran de connexion de l'application
	   */
	public void deconnexion(){
		modelecommun.deconnexion();
	}
	
	public ArrayList<Questionnaire> trieQuestionnaires(int idQuestionnaire, String NomQuestionnaire){
		//TODO: utiliser le getQuestionnaireFini précédent et appliquer des conditions
		return null;
	}
	/**
	   * Supprime le questionnaire en cours
	   */
	public void supprimerQuestionnaire(){
		BDGen.supprimerQuestionnaire(idQuestionnaireChoisi);
	}
	
	public void enregistrerModifQuestion(Question q, String RepresentationChoisi, String regroupement, String commentaire){
		/*TODO: la question la représentation et le regroupement pour charger legraphe que l'on a choisi
		 * on l'enregistre dans un fichier
		 */
	}
	
	public void enregistrerModifQuestionnaire(Questionnaire questionnaire, String[] ListeRepresentationChoisi, String[] listeRegroupement, String[] listeCommentaire){
		/*TODO: enrgistrer le Questionnaire en utilisant la methode precedente avec un FOR
		 * on l'enregistre dans un fichier
		 * ATTENTION, on ne récrit pas par dessus l'enregistrement précédent, pour pouvoir annuler les modifs en cas de besoin
		 * On ne garde que 2 enregistrement en meme temps
		 */
	}
	
	public ArrayList<String> annulerModifQuestion(Question q){
		/*TODO: renvoie les infos de la question AVANT l'enregistrement (RepresentationChoisi,regroupement,commentaire)
		 * on va les chercher dans un fichier
		 */
		return null;
	}
	
	public ArrayList<ArrayList<String>> annulerModifQuestionnaire(Questionnaire questionnaire){
		/*TODO:renvoiela liste des infos des questions avec un FOR
		 * on va les chercher dans un fichier
		 */
		return null;
	}
	
	public void createPDF(String dest, ArrayList<JTabbedPane> listepGraphs, String commentaireFinal) throws IOException{
		//TODO: crée pdf et le renvoie pour enregistrement
		//Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);
 
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
 
        // Initialize document
        Document document = new Document(pdf);
        
        //Add paragraph HEADER to the document
        document.add(new Paragraph("ref 15789\nNom de la société\n1 rue de la merde\n4800 St Jean de Braye\ntel : 02 38 56 98 78\nemail : truc@gmail.com\n\n\n"));
        
        // Add a Paragraph TITLE
        document.add(new Paragraph("Questionnaire n°1547 : Des gouts et des couleurs").setFontSize(18).setTextAlignment(TextAlignment.CENTER));
        
        String destChart = "./temp/temp.png";
        int cpt = 0;
		for (int i=0; i < listeQuestions.size(); i++)
		{
			// Add a Paragraph NAME QUESTION
	        document.add(new Paragraph("Question n°"+listeQuestions.get(i).getNumeroQuestion()+": "+listeQuestions.get(i).getTexteQuestion()).setFontSize(14).setTextAlignment(TextAlignment.LEFT));
	        
	        //Add the CHART
	        File f = new File(destChart);
	        f.getParentFile().mkdirs();
	        JFreeChart chart = ((ChartPanel)listepGraphs.get(i).getSelectedComponent()).getChart();
			ChartUtilities.saveChartAsPNG(f,chart,250,250);
	        document.add(new Image(ImageDataFactory.create(destChart)));
	        
	        // Add a Paragraph COMMENT
	        document.add(new Paragraph("Commentaire :\n blablablabla").setFontSize(12).setTextAlignment(TextAlignment.LEFT));//TODO: rajouter une liste dans analysteModification qui garde en memoir le commentaire de chaque question 
		}
		// Add a Paragraph COMMENT
        document.add(new Paragraph("Commentaire Global :\n"+commentaireFinal).setFontSize(12).setTextAlignment(TextAlignment.LEFT));
        
      //Close document
        document.close();
	}
	
	/**
	   * Retourne le modele d'un tableau en fonction du regroupement choisi et le la question (et donc de ses données)
	   * @param regroupement
	   * 	 nom du regroupement choisi
	   * @param numQuest
	   * 	 numero de la question
	   * @return un modele pour la creation d'un tableau
	   */
	public DefaultTableModel createTableModel(String regroupement, int numQuest){
		Question quest = listeQuestions.get(numQuest-1);
		ArrayList<String> ReponsesPossible = new ArrayList<String>();
		String[] ColumnNames;
		String[][] values;
		if (quest.getIdTypeQuestion() == 'u' || quest.getIdTypeQuestion() == 'm' || quest.getIdTypeQuestion() == 'c')
		{
			int nbReponsesPossible  = listeQuestionsValPossible.get(quest).size();
			ColumnNames = new String[nbReponsesPossible + 1];
			ColumnNames[0] = "Regpmt/Rep";
			for (int i = 1; i<nbReponsesPossible+1; i++)
			{
				ColumnNames[i] = listeQuestionsValPossible.get(quest).get(i-1).getValeur();
				ReponsesPossible.add(listeQuestionsValPossible.get(quest).get(i-1).getIdValeur()+"");
			}
			
		}
		else if (quest.getIdTypeQuestion() == 'n')
		{ 
			int nbReponsesPossible  = quest.getMaxValeur()+1;
			ColumnNames = new String[nbReponsesPossible + 1];
			ColumnNames[0] = "Regpmt/Rep";
			for (int i = 1; i<nbReponsesPossible+1; i++)
			{
				ColumnNames[i] = i-1 +"";
				ReponsesPossible.add(i-1 +"");
			}
			
		}
		else //si quest.getIdTypeQuestion() == 'l'
		{
			for (Repondre rep : listeQuestionsReponses.get(quest))
			{
				if (!ReponsesPossible.contains(rep.getValeur()))
					ReponsesPossible.add(rep.getValeur());
			}
			int nbReponsesPossible  = ReponsesPossible.size();
			ColumnNames = new String[nbReponsesPossible + 1];
			ColumnNames[0] = "Regpmt/Rep";
			for (int i = 1; i<nbReponsesPossible+1; i++)
				ColumnNames[i] = ReponsesPossible.get(i-1);
		}
		if (quest.getIdTypeQuestion() == 'm' || quest.getIdTypeQuestion() == 'c')
		{
			values = new String[quest.getMaxValeur()][Array.getLength(ColumnNames)];
			for (int l = 0; l<quest.getMaxValeur(); l++){
				values[l][0] = l+1 +"";
				ArrayList<Integer> listeNbRep = BDAnalyste.getNbPersParReponseParTranche(idQuestionnaireChoisi, numQuest, listeTranchesPresentes.get(l), ReponsesPossible);
				for (int c = 1; c-1<listeNbRep.size(); c++){
					System.out.println(listeNbRep.get(c-1));
					values[l][c] = listeNbRep.get(c-1)+"";//TODO : a changer quand on aura la fct correcte
					//TODO: c'est absolument pas bon, il faudrait recréer une fct qui prenne en paramètre non pas les tranche mais les position des réponses...
				}
			}
		}
		else{
			if (regroupement.equals("Categorie socio-professionnel")){
				values = new String[listeCategoriesPresentes.size()][Array.getLength(ColumnNames)];
				for (int l = 0; l<listeCategoriesPresentes.size(); l++){
					values[l][0] = listeCategoriesPresentes.get(l).getIntituleCategorie();
					ArrayList<Integer> listeNbRep = BDAnalyste.getNbPersParReponseParCategorie(idQuestionnaireChoisi, numQuest, listeCategoriesPresentes.get(l), ReponsesPossible);
					for (int c = 1; c-1<listeNbRep.size(); c++){
						values[l][c] = listeNbRep.get(c-1)+"";//TODO : a changer quand on aura la fct correcte
					}
				}
			}
			else{ //if (regroupement.equals("Age"))
				values = new String[listeTranchesPresentes.size()][Array.getLength(ColumnNames)];
				for (int l = 0; l<listeTranchesPresentes.size(); l++){
					values[l][0] = listeTranchesPresentes.get(l).getValeurDebut() + "-" + listeTranchesPresentes.get(l).getValeurFin() + " ans";
					ArrayList<Integer> listeNbRep = BDAnalyste.getNbPersParReponseParTranche(idQuestionnaireChoisi, numQuest, listeTranchesPresentes.get(l), ReponsesPossible);
					for (int c = 1; c-1<listeNbRep.size(); c++){
						//System.out.println(listeNbRep.get(c-1));
						values[l][c] = listeNbRep.get(c-1)+"";
					}
				}
				
			}
		}
		
		DefaultTableModel modele = new DefaultTableModel(values,ColumnNames){
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		return modele;
	}
	
	/**
	   * Retourne les données d'un diagramme circulaire en fonction du regroupement choisi et le la question (et donc de ses données)
	   * @param regroupement
	   * 	 nom du regroupement choisi
	   * @param numQuest
	   * 	 numero de la question
	   * @return un groupement de données pour la creation d'un diagramme circulaire
	   */
	public DefaultPieDataset createPieChartData(String regroupement, int numQuest){
		Question quest = listeQuestions.get(numQuest-1);
		DefaultPieDataset data = new DefaultPieDataset();
		ArrayList<String> listeReponses = new ArrayList<String>();
		ArrayList<String> listeReponsesID = new ArrayList<String>();
		if (quest.getIdTypeQuestion() == 'u' || quest.getIdTypeQuestion() == 'm' || quest.getIdTypeQuestion() == 'c')
		{
			int nbReponsesPossible  = listeQuestionsValPossible.get(quest).size();
			for (int i = 1; i<nbReponsesPossible+1; i++)
			{
				listeReponses.add(listeQuestionsValPossible.get(quest).get(i-1).getValeur());
				listeReponsesID.add(listeQuestionsValPossible.get(quest).get(i-1).getIdValeur()+"");
			}
		}
		else if (quest.getIdTypeQuestion() == 'n')
		{ 
			int nbReponsesPossible  = quest.getMaxValeur()+1;
			for (int i = 1; i<nbReponsesPossible+1; i++)
			{
				listeReponses.add(i-1 +"/" + quest.getMaxValeur());
				listeReponsesID.add(i-1+"");
			}
		}
		else //si quest.getIdTypeQuestion() == 'l'
		{
			for (Repondre rep : listeQuestionsReponses.get(quest))
			{
				if (!listeReponses.contains(rep.getValeur()))
				{
					listeReponses.add(rep.getValeur());
					listeReponsesID.add(rep.getValeur());
				}
					
			}
		}
		//System.out.println(listeReponsesID);
		ArrayList<Integer> listeNbRep = BDAnalyste.getNbPersParReponse(idQuestionnaireChoisi, numQuest, listeReponsesID);
		int nbPersDansPanel = BDAnalyste.getNbPersPanel(BDGen.getPanelDuQuestionnaireX(idQuestionnaireChoisi));
		//System.out.println(nbPersDansPanel);
		for (int i=0; i<listeReponses.size();i++)
		{
			float percentageNbPers = listeNbRep.get(i)*100/nbPersDansPanel;
			//System.out.println(listeReponses.get(i) + percentageNbPers );
			//System.out.println("-----------------");
			data.setValue(listeReponses.get(i), percentageNbPers);//TODO : a changer quand on aura la fct correcte
		}
		return data;
	}
	
	/**
	   * Retourne les données d'un diagramme en bar en fonction du regroupement choisi et le la question (et donc de ses données)
	   * @param regroupement
	   * 	 nom du regroupement choisi
	   * @param numQuest
	   * 	 numero de la question
	   * @return un groupement de données pour la creation d'un diagramme en bar
	   */
	public DefaultCategoryDataset createBarChartData(String regroupement, int numQuest){
		Question quest = listeQuestions.get(numQuest-1);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
		ArrayList<String> listeReponses = new ArrayList<String>();
		if (quest.getIdTypeQuestion() == 'u' || quest.getIdTypeQuestion() == 'm' || quest.getIdTypeQuestion() == 'c')
		{
			int nbReponsesPossible  = listeQuestionsValPossible.get(quest).size();
			for (int i = 1; i<nbReponsesPossible+1; i++)
				listeReponses.add(listeQuestionsValPossible.get(quest).get(i-1).getValeur());
		}
		else if (quest.getIdTypeQuestion() == 'n')
		{ 
			int nbReponsesPossible  = quest.getMaxValeur()+1;
			for (int i = 1; i<nbReponsesPossible+1; i++)
				listeReponses.add(i-1 +"/" + quest.getMaxValeur());
		}
		else //si quest.getIdTypeQuestion() == 'l'
		{
			for (Repondre rep : listeQuestionsReponses.get(quest))
			{
				if (!listeReponses.contains(rep.getValeur()))
					listeReponses.add(rep.getValeur());
			}
		}
		if (regroupement.equals("Categorie socio-professionnel"))
		{
			for (Categorie cat : listeCategoriesPresentes)
			{
				String nomCat = cat.getIntituleCategorie();
				for (String rep : listeReponses)
				{
					dataset.addValue(3.0,rep, nomCat);//TODO : a changer quand on aura la fct correcte
				}
			}
		}
		else if (regroupement.equals("Age"))
		{
			for (Tranche tr : listeTranchesPresentes)
			{
				String nomTr = tr.getValeurDebut() + "-" + tr.getValeurFin() + " ans";
				for (String rep : listeReponses)
				{
					dataset.addValue(2.0,rep, nomTr);//TODO : a changer quand on aura la fct correcte
				}
			}
		}
		else //SI ON CHOISIT LE TRI PAR REPONSE DONNEES
		{
			for (Tranche tr : listeTranchesPresentes)
			{
				String nomTr = tr.getValeurDebut() + "-" + tr.getValeurFin() + " ans";
				for (String rep : listeReponses)
				{
					dataset.addValue(2.0,nomTr, rep);//TODO : a changer quand on aura la fct correcte
				}
			}
		}
		return dataset;
	}
	
}
