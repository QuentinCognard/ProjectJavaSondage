package ModuleConcepteur;

import java.util.ArrayList;

public class AjouterQuestion {
	String intitule;
	ArrayList<String> reponse;
	
	AjouterQuestion(String i, ArrayList<String> l){
		this.intitule = i;
		this.reponse = l;
	}
	
	public String getIntitule(){
		return this.intitule;
	}
}
