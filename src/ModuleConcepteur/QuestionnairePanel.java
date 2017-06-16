package ModuleConcepteur;

import javax.swing.JPanel;
import BaseDeDonnees.Questionnaire;

public class QuestionnairePanel extends JPanel{
	
	Questionnaire q;
	
	QuestionnairePanel(Questionnaire q){
		this.q = q;
	}
	public Questionnaire getQuestionnaire(){
		return this.q;
	}
	public int getId(){
		return this.q.getNumeroQuestionnaire();
	}
	public String getTitreQuestionnaire(){
		return this.q.getTitreQuestionnaire();
	}
	public int getIdPanel(){
		return this.q.getIdentifiantPanel();
	}
	public int getNumClient(){
		return this.q.getNumClient();
	}
	
	public void setTitreQuestionnaire(String titre){
		this.q.setTitreQuestionnaire(titre);
	}
}
