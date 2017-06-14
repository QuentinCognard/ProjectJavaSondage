package BaseDeDonnees;

public class Question {
	private int idQuestionnaire;
	private int numeroQuestion;
	private String texteQuestion;
	private int maxValeur;
	private char idTypeQuestion;
	
	public Question (int idq, int numq, String tq, int mv, char idtq) {
		this.idQuestionnaire = idq;
		this.numeroQuestion = numq;
		this.texteQuestion = tq;
		this.maxValeur = mv;
		this.idTypeQuestion = idtq;
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

	