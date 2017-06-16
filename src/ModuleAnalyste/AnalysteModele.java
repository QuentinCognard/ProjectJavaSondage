package ModuleAnalyste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import BaseDeDonnees.BDGeneral;
import BaseDeDonnees.BDModuleAnalyste;
import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Repondre;
import Commun.ModeleCommun;

public class AnalysteModele {
	BDGeneral BDGen;
	BDModuleAnalyste BDAnalyste;
	private HashMap<Question,ArrayList<Repondre>> listeQuestionsReponses;
	
	public AnalysteModele( ModeleCommun modCommun){
		/*TODO: recuperer la classe BD générale qui devra etre créer dans Sondio.java (avec BDConnexion)
		 * et crer BDModuleAnalyste
		 */
		this.BDGen = modCommun.getBdGeneral();
		this.BDAnalyste = new BDModuleAnalyste(modCommun.getBdConnexion());
		this.listeQuestionsReponses = new HashMap<Question,ArrayList<Repondre>>();
	}
	
	public HashMap<Question,ArrayList<Repondre>> getListeQuestionsReponses(){
		return listeQuestionsReponses;
	}
	
	public void createListesQuestionsReponses(int idQuestionnaireChoisi){
		ArrayList<Question> listeQuestions = getListeQuestions(idQuestionnaireChoisi);
		for(int i = 0; i<listeQuestions.size(); i++){
			listeQuestionsReponses.put(listeQuestions.get(i), getReponsesQuestion(idQuestionnaireChoisi, i+1) );
		}
	}
	
	public ArrayList<Questionnaire> getQuestionnaireFini(){
		return BDGen.getListeQuestionnaire ('A');
	}
	
	public ArrayList<Question> getListeQuestions(int idQuestionnaire){
		return BDGen.getListeQuestion (idQuestionnaire);
	}
	
	public ArrayList <Repondre> getReponsesQuestion(int idQuestionnaire, int numeroQuestion){
		return BDAnalyste.getReponsesQuestion(idQuestionnaire, numeroQuestion);
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
	
	public DefaultTableModel createTableModel(String regroupement, String[] listeReponses, String[] listeNbPersParRep ){
		/*TODO: prend une liste de reponse et la liste des personnes ayant répondu cette réponse et
		 * renvoie le model de la table en fonction du REGROuPEMENT
		 */
		return null;
	}
	
	public DefaultPieDataset createPieChartData(String regroupement, String[] listeReponses, String[] listeNbPersParRep ){
		//TODO: prend une liste de reponse et la liste des personnes ayant répondu cette réponse et renvoie le dataset de piechart
		return null;
	}
	
	public DefaultCategoryDataset createBarChartData(String regroupement, String[] listeReponses, String[] listeNbPersParRep ){
		/*TODO: prend une liste de reponse et la liste des personnes ayant répondu cette réponse
		 * et renvoie le dataset de BarChart en fonction du REGROUPEMENT
		 */
		return null;
	}
	
}
