package BaseDeDonnees;

public class TypeQuestion {

	private char idTypeQuestion;
	private String intituleTypeQuestion;
	private String typeReponse;
	
	static char CHOIXUNIQUE = 'u';
	static char CHOIXMULTIPLE = 'm';
	static char CLASSEMENT = 'c';
	static char NOTE = 'n';
	static char REPONSELIBRE = 'l';
	
	public TypeQuestion (char idtq, String itq, String tr) {
		this.idTypeQuestion = idtq;
		this.intituleTypeQuestion = itq;
		this.typeReponse = tr;
	}

	public char getIdTypeQuestion() {
		return idTypeQuestion;
	}

	public void setIdTypeQuestion(char idTypeQuestion) {
		this.idTypeQuestion = idTypeQuestion;
	}

	public String getIntituleTypeQuestion() {
		return intituleTypeQuestion;
	}

	public void setIntituleTypeQuestion(String intituleTypeQuestion) {
		this.intituleTypeQuestion = intituleTypeQuestion;
	}

	public String getTypeReponse() {
		return typeReponse;
	}

	public void setTypeReponse(String typeReponse) {
		this.typeReponse = typeReponse;
	}
	
	
}
