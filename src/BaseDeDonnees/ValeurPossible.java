package BaseDeDonnees;

public class ValeurPossible {
	
	private int idQuestion;
	private int numeroQuestionnaire;
	private int idValeur;
	private String valeur;
	
	public ValeurPossible (int idq, int numq, int idv, String v) {
		this.idQuestion = idq;
		this.numeroQuestionnaire = numq;
		this.idValeur = idv;
		this.valeur = v;
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public int getNumeroQuestionnaire() {
		return numeroQuestionnaire;
	}

	public void setNumeroQuestionnaire(int numeroQuestionnaire) {
		this.numeroQuestionnaire = numeroQuestionnaire;
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
