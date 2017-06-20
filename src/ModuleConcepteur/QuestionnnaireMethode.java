package ModuleConcepteur;

import java.util.ArrayList;

public class QuestionnnaireMethode {
	ArrayList<AjouterQuestion> ajouterQuestion;
	String titre;
	String panel;
	int id;
	String taux;
	String societe;
	
	QuestionnnaireMethode(){
		this.ajouterQuestion = new ArrayList<AjouterQuestion>();
		this.id = 1;
		
	}
	
	public void ajouterQuestion(String in, ArrayList<String> lis){
		this.ajouterQuestion.add(new AjouterQuestion(in,lis));
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
	
	public ArrayList<AjouterQuestion> getListe(){
		return this.ajouterQuestion;
	}
}
