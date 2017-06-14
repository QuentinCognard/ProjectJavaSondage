package BaseDeDonnees;

public class RoleUtilisateur {
	private char identifiantRole;
	private String nomRole;
	
	public RoleUtilisateur (char idr, String nr) {
		this.identifiantRole = idr;
		this.nomRole = nr;
	}

	public char getIdentifiantRole() {
		return identifiantRole;
	}

	public String getNomRole() {
		return nomRole;
	}
	
	
}
