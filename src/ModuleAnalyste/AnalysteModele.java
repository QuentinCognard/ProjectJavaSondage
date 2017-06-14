package ModuleAnalyste;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import BaseDeDonnees.BDGeneral;
import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;

public class AnalysteModele {
	BDGeneral BDGen;
	
	public AnalysteModele(){
		/*TODO: recuperer la classe BD générale qui devra etre créer dans Sondio.java (avec BDConnexion)
		 * et crer BDModuleAnalyste
		 */
	}
	
	public ArrayList<Questionnaire> getQuestionnaireFini(){
		//TODO: utiliser la méthode de la classe BDGeneral
		return null;
	}
	
	public ArrayList<Question> getListeQuestion(int idQuestionnaire){
		//TODO: utiliser la méthode de la classe BDGeneral
		return null;
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
