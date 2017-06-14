package BaseDeDonnees;

public class Interroger {
	private int identifiantUtilisateur;
	private int numeroSonde;
	private int identifiantQuestionnaire;
	
	public Interroger (int iu, int ns, int idq) {
		this.identifiantUtilisateur = iu;
		this.numeroSonde = ns;
		this.identifiantQuestionnaire = idq;
	}

	public int getIdentifiantUtilisateur() {
		return identifiantUtilisateur;
	}

	public void setIdentifiantUtilisateur(int identifiantUtilisateur) {
		this.identifiantUtilisateur = identifiantUtilisateur;
	}

	public int getNumeroSonde() {
		return numeroSonde;
	}

	public void setNumeroSonde(int numeroSonde) {
		this.numeroSonde = numeroSonde;
	}

	public int getIdentifiantQuestionnaire() {
		return identifiantQuestionnaire;
	}

	public void setIdentifiantQuestionnaire(int identifiantQuestionnaire) {
		this.identifiantQuestionnaire = identifiantQuestionnaire;
	}
	
	
}
