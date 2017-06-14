package Commun;

import BaseDeDonnees.Utilisateur;

public class ModeleCommun {
	
	private Sondio sondio;
	private Utilisateur user;
	
	public ModeleCommun (Sondio s) {
		this.sondio = s;
		this.user = null;
	}
	
	
	public Sondio getSondio() {
		return sondio;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

}
