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

public class AnalysteModele {
	BDGeneral BDGen;
	BDModuleAnalyste BDAnalyste;
	private ArrayList<Question> listeQuestions;
	private HashMap<Question,ArrayList<Repondre>> listeQuestionsReponses;
	private HashMap<Question,ArrayList<ValeurPossible>> listeQuestionsValPossible;
	private ArrayList<Tranche> listeTranchesPresentes;
	private ArrayList<Categorie> listeCategoriesPresentes;
	
	public AnalysteModele( ModeleCommun modCommun){
		/*TODO: recuperer la classe BD générale qui devra etre créer dans Sondio.java (avec BDConnexion)
		 * et crer BDModuleAnalyste
		 */
		this.BDGen = modCommun.getBdGeneral();
		this.BDAnalyste = new BDModuleAnalyste(modCommun.getBdConnexion());
		this.listeQuestionsReponses = new HashMap<Question,ArrayList<Repondre>>();
		this.listeQuestionsValPossible = new HashMap<Question,ArrayList<ValeurPossible>>();
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
	
	public void createListesQuestions(int idQuestionnaireChoisi){
		listeQuestions = getListeQuestions(idQuestionnaireChoisi);
	}
	
	public void createListesQuestionsValPossible(int idQuestionnaireChoisi){
		for(int i = 0; i<listeQuestions.size(); i++){
			listeQuestionsValPossible.put(listeQuestions.get(i), getListeValPossible(idQuestionnaireChoisi, i+1) );
		}
	}
	
	public void createListesQuestionsReponses(int idQuestionnaireChoisi){
		for(int i = 0; i<listeQuestions.size(); i++){
			listeQuestionsReponses.put(listeQuestions.get(i), getReponsesQuestion(idQuestionnaireChoisi, i+1) );
		}
	}
	
	public void createListeTranchesPresentes(int idQuestionnaireChoisi){
		//TODO: Nathan s'en charge, à aller chercher dans AnalysteBD
		listeTranchesPresentes = new ArrayList<Tranche>(); //à changer quand on aura la fct
		listeTranchesPresentes.add(new Tranche('1',8,17));
		listeTranchesPresentes.add(new Tranche('2',18,25));
		listeTranchesPresentes.add(new Tranche('3',26,35));
	}
	
	public void createListeCategoriesPresentes(int idQuestionnaireChoisi){
		//TODO: Nathan s'en charge, à aller chercher dans AnalysteBD
		listeCategoriesPresentes = new ArrayList<Categorie>(); //à changer quand on aura la fct
		listeCategoriesPresentes.add(new Categorie('1',"PAUVRE"));
		listeCategoriesPresentes.add(new Categorie('2',"MOYEN"));
		listeCategoriesPresentes.add(new Categorie('3',"RICHE"));
	}
	
	public ArrayList<Questionnaire> getQuestionnaireFini(){
		return BDGen.getListeQuestionnaire('A');
	}
	
	public ArrayList<Question> getListeQuestions(int idQuestionnaire){
		return BDGen.getListeQuestion (idQuestionnaire);
	}
	
	public ArrayList <Repondre> getReponsesQuestion(int idQuestionnaire, int numeroQuestion){
		return BDAnalyste.getReponsesQuestion(idQuestionnaire, numeroQuestion);
	}
	
	public ArrayList<ValeurPossible> getListeValPossible(int idQuestionnaire, int numQuestion){
		return BDGen.getListeValPossible (idQuestionnaire, numQuestion);
	}
	
	public void deconnexion(){
		//TODO: à voir avec Nathan
	}
	
	public ArrayList<Questionnaire> trieQuestionnaires(int idQuestionnaire, String NomQuestionnaire){
		//TODO: utiliser le getQuestionnaireFini précédent et appliquer des conditions
		return null;
	}
	
	public void supprimerQuestionnaire(){
		//TODO: utiliser une futurs méthode de la classe BDModuleAnalyste (ou BDGeneral ?)
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
	
	/*public pdf ExportPDF(???){
		//TODO: crée pdf et le renvoie pour enregistrement
	}*/
	
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
		else if (regroupement.equals("Age")){
			values = new String[listeTranchesPresentes.size()][Array.getLength(ColumnNames)];
			for (int l = 0; l<listeTranchesPresentes.size(); l++){
				values[l][0] = listeTranchesPresentes.get(l).getValeurDebut() + "-" + listeTranchesPresentes.get(l).getValeurFin() + " ans";
				for (int c = 1; c<Array.getLength(ColumnNames); c++){
					values[l][c] = "a";//TODO : a changer quand on aura la fct correcte
				}
			}
		}
		else{ //SI ON CHOISIT LE TRI PAR REPONSE DONNEES
			//????????????????????????????????????????????????????????????????
			values = new String[listeTranchesPresentes.size()][Array.getLength(ColumnNames)];
			for (int l = 0; l<listeTranchesPresentes.size(); l++){
				for (int c = 0; c<Array.getLength(ColumnNames); c++){
					values[l][c] = "rd";//TODO : a changer quand on aura la fct correcte
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
