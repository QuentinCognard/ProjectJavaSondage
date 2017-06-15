package ModuleConcepteur;

import java.util.ArrayList;

public class Question {
	String intitule;
	ArrayList<String> reponse;
	
	Question(String i, ArrayList<String> l){
		this.intitule = i;
		this.reponse = l;
	}
	
	public String getIntitule(){
		return this.intitule;
	}
}
