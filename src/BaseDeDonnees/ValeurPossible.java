package BaseDeDonnees;

public class ValeurPossible {
	
	private int idQuestionnaire;
	private int numeroQuestion;
	private int idValeur;
	private String valeur;
	
	public ValeurPossible (int idq, int numq, int idv, String v) {
		this.idQuestionnaire = idq;
		this.numeroQuestion = numq;
		this.idValeur = idv;
		this.valeur = v;
	}

	public int getIdQuestionnaire() {
		return idQuestionnaire;
	}

	public void setIdQuestionnaire(int idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	public int getNumeroQuestion() {
		return numeroQuestion;
	}

	public void setNumeroQuestion(int numeroQuestion) {
		this.numeroQuestion = numeroQuestion;
	}

	public int getIdValeur() {
		return idValeur;
	}

	public void setIdValeur(int idValeur) {
		this.idValeur = idValeur;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	
	
	
}
