package ModuleConcepteur;

import javax.swing.JPanel;
import BaseDeDonnees.*;

public class QuestionPanel extends JPanel{
	
	Question q;
	
	QuestionPanel(Question q){
		this.q = q;
	}
	public Question getQuestion(){
		return this.q;
	}
	public int getNumeroQuestion(){
		return q.getNumeroQuestion();
	}
	public int getIdQuestionnaire(){
		return q.getIdQuestionnaire();
	}
	public String getTexteQuestion(){
		return q.getTexteQuestion();
	}
	public char getIdTypeQuestion(){
		return q.getIdTypeQuestion();
	}
}
