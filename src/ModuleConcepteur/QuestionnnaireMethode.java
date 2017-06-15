package ModuleConcepteur;

import java.util.ArrayList;

public class QuestionnnaireMethode {
	ArrayList<Question> question;
	String titre;
	String panel;
	int id;
	String taux;
	String societe;
	
	QuestionnnaireMethode(){
		this.question = new ArrayList<Question>();
		this.id = 1;
		
	}
	
	public void ajouterQuestion(String in, ArrayList<String> lis){
		this.question.add(new Question(in,lis));
	}
	
	public void setTitre(String t){
		this.titre = t;
	}
	
	public void setPanel(String p){
		this.panel = p;
	}
	
	public void setSociete(String s){
		this.societe = s;
	}
	
	public void setTaux(String t){
		this.taux = t;
	}
	
	public String getTitre(){
		return this.titre;
	}
	
	public String getPanel(){
		return this.panel;
	}

	public String getSociete(){
		return this.societe;
	}

	public String getTaux(){
		return this.taux;
	}
	
	public ArrayList<Question> getListe(){
		return this.question;
	}
}
