package BaseDeDonnees;

public class Utilisateur {
	private int identifiantUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String loginUtilisateur;
	private String motdepasseUtilisateur;
	private char identifiantRole;
	
	public Utilisateur (int id, String nu, String pu, String lu, String mdpu, char idr) {
		this.identifiantUtilisateur = id;
		this.nomUtilisateur = nu;
		this.prenomUtilisateur = pu;
		this.loginUtilisateur = lu;
		this.motdepasseUtilisateur = mdpu;
		this.identifiantRole = idr;
	}

	public int getIdentifiantUtilisateur() {
		return identifiantUtilisateur;
	}

	public void setIdentifiantUtilisateur(int identifiantUtilisateur) {
		this.identifiantUtilisateur = identifiantUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getLoginUtilisateur() {
		return loginUtilisateur;
	}

	public void setLoginUtilisateur(String loginUtilisateur) {
		this.loginUtilisateur = loginUtilisateur;
	}

	public String getMotdepasseUtilisateur() {
		return motdepasseUtilisateur;
	}

	public void setMotdepasseUtilisateur(String motdepasseUtilisateur) {
		this.motdepasseUtilisateur = motdepasseUtilisateur;
	}

	public char getIdentifiantRole() {
		return identifiantRole;
	}

	public void setIdentifiantRole(char identifiantRole) {
		this.identifiantRole = identifiantRole;
	}
	
	
}
