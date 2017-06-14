package BaseDeDonnees;

public class Question {
	private int idQuestion;
	private int numeroQuestionnaire;
	private String texteQuestion;
	private int maxValeur;
	private char idTypeQuestion;
	
	public Question (int idq, int numq, String tq, int mv, char idtq) {
		this.idQuestion = idq;
		this.numeroQuestionnaire = numq;
		this.texteQuestion = tq;
		this.maxValeur = mv;
		this.idTypeQuestion = idtq;
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

	public String getTexteQuestion() {
		return texteQuestion;
	}

	public void setTexteQuestion(String texteQuestion) {
		this.texteQuestion = texteQuestion;
	}

	public int getMaxValeur() {
		return maxValeur;
	}

	public void setMaxValeur(int maxValeur) {
		this.maxValeur = maxValeur;
	}

	public char getIdTypeQuestion() {
		return idTypeQuestion;
	}

	public void setIdTypeQuestion(char idTypeQuestion) {
		this.idTypeQuestion = idTypeQuestion;
	}
	
	
}

	