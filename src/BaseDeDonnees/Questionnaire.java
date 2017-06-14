package BaseDeDonnees;

public class Questionnaire {
	private int numeroQuestionnaire;
	private String titreQuestionnaire;
	private char etatQuestionnaire;
	private int numClient;
	private int identifiantUtilisateur;
	private int identifiantPanel;
	
	static char ENCOURS = 'C';
	static char PRETPOURLESONDAGE = 'S';
	static char PRETPOURANALYSTE = 'A';
	
	public Questionnaire (int nq, String tq, char eq, int nc, int iu, int ip) {
		this.numeroQuestionnaire = nq;
		this.titreQuestionnaire = tq;
		this.etatQuestionnaire = eq;
		this.numClient = nc;
		this.identifiantUtilisateur = iu;
		this.identifiantPanel = ip;
	}

	public int getNumeroQuestionnaire() {
		return numeroQuestionnaire;
	}

	public void setNumeroQuestionnaire(int numeroQuestionnaire) {
		this.numeroQuestionnaire = numeroQuestionnaire;
	}

	public String getTitreQuestionnaire() {
		return titreQuestionnaire;
	}

	public void setTitreQuestionnaire(String titreQuestionnaire) {
		this.titreQuestionnaire = titreQuestionnaire;
	}

	public char getEtatQuestionnaire() {
		return etatQuestionnaire;
	}

	public void setEtatQuestionnaire(char etatQuestionnaire) {
		this.etatQuestionnaire = etatQuestionnaire;
	}

	public int getNumClient() {
		return numClient;
	}

	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}

	public int getIdentifiantUtilisateur() {
		return identifiantUtilisateur;
	}

	public void setIdentifiantUtilisateur(int identifiantUtilisateur) {
		this.identifiantUtilisateur = identifiantUtilisateur;
	}

	public int getIdentifiantPanel() {
		return identifiantPanel;
	}

	public void setIdentifiantPanel(int identifiantPanel) {
		this.identifiantPanel = identifiantPanel;
	}
	
	
}
