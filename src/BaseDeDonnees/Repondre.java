package BaseDeDonnees;

public class Repondre {
	
	private int idQuestionnaire;
	private int numQuestion;
	private char idCaracteristique;
	private String valeur;
	
	public Repondre (int idq, int numq, char idc, String v) {
		this.idQuestionnaire = idq;
		this.numQuestion = numq;
		this.idCaracteristique = idc;
		this.valeur = v;
	}

	public int getIdQuestionnaire() {
		return idQuestionnaire;
	}

	public void setIdQuestionnaire(int idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	public int getNumQuestion() {
		return numQuestion;
	}

	public void setNumQuestion(int numQuestion) {
		this.numQuestion = numQuestion;
	}

	public char getIdCaracteristique() {
		return idCaracteristique;
	}

	public void setIdCaracteristique(char idCaracteristique) {
		this.idCaracteristique = idCaracteristique;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	
}
