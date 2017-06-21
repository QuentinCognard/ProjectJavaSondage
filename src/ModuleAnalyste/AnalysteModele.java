package ModuleAnalyste;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
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
		//TODO: Nathan s'en charge, à aller chercher dans AnalysteBD
		listeTranchesPresentes = new ArrayList<Tranche>(); //à changer quand on aura la fct
		listeTranchesPresentes.add(new Tranche('1',8,17));
		listeTranchesPresentes.add(new Tranche('2',18,25));
		listeTranchesPresentes.add(new Tranche('3',26,35));
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
	   * @param sondio
	   * 	 La classe principale de l'application
	   */
	public void deconnexion(Sondio sondio){
		sondio.afficherConnexion();
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
	
	public void createPDF(String dest){
		//TODO: crée pdf et le renvoie pour enregistrement
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
		String[] ColumnNames;
		String[][] values;
		if (quest.getIdTypeQuestion() == 'u' || quest.getIdTypeQuestion() == 'm' || quest.getIdTypeQuestion() == 'c')
		{
			int nbReponsesPossible  = listeQuestionsValPossible.get(quest).size();
			ColumnNames = new String[nbReponsesPossible + 1];
			ColumnNames[0] = "Regpmt/Rep";
			for (int i = 1; i<nbReponsesPossible+1; i++)
				ColumnNames[i] = listeQuestionsValPossible.get(quest).get(i-1).getValeur();
		}
		else if (quest.getIdTypeQuestion() == 'n')
		{ 
			int nbReponsesPossible  = quest.getMaxValeur()+1;
			ColumnNames = new String[nbReponsesPossible + 1];
			ColumnNames[0] = "Regpmt/Rep";
			for (int i = 1; i<nbReponsesPossible+1; i++)
				ColumnNames[i] = i-1 +"";
		}
		else //si quest.getIdTypeQuestion() == 'l'
		{
			ArrayList<String> ReponsesPossible = new ArrayList<String>();
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
		if (regroupement.equals("Categorie socio-professionnel")){
			values = new String[listeCategoriesPresentes.size()][Array.getLength(ColumnNames)];
			for (int l = 0; l<listeCategoriesPresentes.size(); l++){
				values[l][0] = listeCategoriesPresentes.get(l).getIntituleCategorie();
				for (int c = 1; c<Array.getLength(ColumnNames); c++){
					values[l][c] = "cat";//TODO : a changer quand on aura la fct correcte
				}
			}
		}
		else{ //if (regroupement.equals("Age"))
			values = new String[listeTranchesPresentes.size()][Array.getLength(ColumnNames)];
			for (int l = 0; l<listeTranchesPresentes.size(); l++){
				values[l][0] = listeTranchesPresentes.get(l).getValeurDebut() + "-" + listeTranchesPresentes.get(l).getValeurFin() + " ans";
				for (int c = 1; c<Array.getLength(ColumnNames); c++){
					values[l][c] = "a";//TODO : a changer quand on aura la fct correcte
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
		for (String rep : listeReponses)
		{
			data.setValue(rep, new Double(9.0));//TODO : a changer quand on aura la fct correcte
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
