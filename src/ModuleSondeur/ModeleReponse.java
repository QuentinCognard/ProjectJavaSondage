package ModuleSondeur;

import java.util.ArrayList;

import BaseDeDonnees.BDGeneral;
import BaseDeDonnees.BDModuleSondeur;
import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Repondre;
import BaseDeDonnees.Sonde;

public class ModeleReponse {
	
	Repondre rep;	
	BDGeneral bdgene;
	BDModuleSondeur bdsond;
	Questionnaire questionnaire;
	ArrayList<Question> listeQuestion;
	ArrayList <Sonde> listeDeSonde;
	ArrayList <Sonde> listeDeSondeInterroge;
	Sonde lesonde;
	
	
	public ModeleReponse(BDGeneral bdgene,BDModuleSondeur bdsond,Questionnaire questionnaire) {
		this.bdgene=bdgene;
		this.bdsond=bdsond;
		this.questionnaire=questionnaire;
		this.listeQuestion=bdgene.getListeQuestion(questionnaire.getIdQuestionnaire());
		this.listeDeSonde=bdsond.getListeSondesNonInterroges(questionnaire);
		this.listeDeSondeInterroge=bdsond.getListeSondesInterroges(questionnaire);
		this.lesonde=listeDeSonde.get(0);
		this.rep=new Repondre(0,0,"","");
		
	}
	

	
	public void ajouterReponse(int idQuestionnaire, int idQuestion, String val){
		this.rep.setIdQuestionnaire(idQuestionnaire);
		this.rep.setNumQuestion(idQuestion);
		this.rep.setIdCaracteristique(lesonde.getIdentifiantCaracteristique());
		this.rep.setValeur(val);
		this.bdsond.insererReponse(this.rep);
	}
	
}
