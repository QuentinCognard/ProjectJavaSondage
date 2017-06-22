package ModuleConcepteur;

import java.util.ArrayList;

import BaseDeDonnees.Question;
import BaseDeDonnees.TypeQuestion;
import BaseDeDonnees.ValeurPossible;

public class CreationQuestion {
	Question question;
	ArrayList<ValeurPossible> listeRep;
	
	CreationQuestion(int nbQ){
		this.question = new Question(nbQ,0,"",0,'l');
		this.listeRep = new ArrayList<ValeurPossible>();
	}
	
	public void setTypeQuestion(char c){
		this.question.setIdTypeQuestion(c);
	}
	
	public void setIntitule(String s){
		this.question.setTexteQuestion(s);
	}
	
	public void setNumQuestion(int i){
		this.question.setNumeroQuestion(i);
		for (ValeurPossible v:this.listeRep){
			v.setNumeroQuestion(i);
		}
	}
	
	public void addReponse(String s){
		this.listeRep.add(new ValeurPossible(this.question.getIdQuestionnaire(),0,this.listeRep.size()+1,s));
	}
	
	public char getTypeQuestion(){
		return this.question.getIdTypeQuestion();
	}
	
	public String getIntitule(){
		return this.question.getTexteQuestion();
	}
	
	public void setMaxValeur(int i){
		this.question.setMaxValeur(i);
	}
	
	public Question getQuestion(){
		return this.question;
	}
	
	public ArrayList<ValeurPossible> getReponse(){
		return this.listeRep;
	}
}
