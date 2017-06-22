package ModuleSondeur;

import java.util.ArrayList;

import BaseDeDonnees.BDGeneral;
import BaseDeDonnees.BDModuleSondeur;
import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Repondre;
import BaseDeDonnees.Sonde;

public class ModeleReponse {
	
	ArrayList<Repondre> listerep;	
	BDGeneral bdgene;
	BDModuleSondeur bdsond;
	Questionnaire questionnaire;
	ArrayList<Question> listeQuestion;
	ArrayList <Sonde> listeDeSonde;
	ArrayList <Sonde> listeDeSondeInterroge;
	Sonde lesonde;
	/**
	 * Le modele pour les reponses du sondage
	 * 
	 * @param bdgene
	 	* La base de donn�es utilis�e par l'application
	 * @param bdsond
	 	* La base de donn�es des sondeurs
	 * @param questionnaire
	 	* Le questionnaire utilis� pour ce sondage
	 */
	
	public ModeleReponse(BDGeneral bdgene,BDModuleSondeur bdsond,Questionnaire questionnaire) {
		this.bdgene=bdgene;
		this.bdsond=bdsond;
		this.questionnaire=questionnaire;
		this.listeQuestion=bdgene.getListeQuestion(questionnaire.getIdQuestionnaire());
		this.listeDeSonde=bdsond.getListeSondesNonInterroges(questionnaire);
		this.listeDeSondeInterroge=bdsond.getListeSondesInterroges(questionnaire);
		this.lesonde=listeDeSonde.get(0);
		this.listerep=new ArrayList<Repondre>();
		
	}
	
	/**
	 * Permet d'ajouter une reponse
	 * 
	 * @param idQuestionnaire
	 	* Id du questionnaire utilis�
	 * @param idQuestion
	 	* Id de la question actuelle du sondage
	 * @param idCaracteristique
	 	* Id du type de la question(Choix Multiples, Echelle,...)
	 * @param val
	 	* La reponse a ajouter
	 */
	
	public void ajouterReponse(int idQuestionnaire, int idQuestion, String val){
		if (this.listerep.size()>=idQuestion){
			
			if (this.listerep.contains(this.listerep.get(idQuestion-1))){
				this.listerep.set(idQuestion-1, new Repondre(idQuestionnaire,idQuestion,lesonde.getIdentifiantCaracteristique(),val));
			}

		}
		
		else {
			this.listerep.add(new Repondre(idQuestionnaire,idQuestion,lesonde.getIdentifiantCaracteristique(),val));

		}

		}

	
	
	/**
	 * Permet d'ajouter les reponses � la base de donn�es
	 * 
	 */
	public void validerQuestionnaire(){
		for (Repondre rep : listerep){
			this.bdsond.insererReponse(rep);
		}
	}
}
