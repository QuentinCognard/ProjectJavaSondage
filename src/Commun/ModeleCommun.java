package Commun;

import BaseDeDonnees.BDConnexionMySQL;
import BaseDeDonnees.BDGeneral;
import BaseDeDonnees.Utilisateur;

public class ModeleCommun {
	
	private Sondio sondio;
	private Utilisateur user;
	
	private BDConnexionMySQL bdConnexion;
	private BDGeneral bdGeneral;
	
	
	public ModeleCommun (Sondio s) {
		this.sondio = s;
		this.user = null;
		this.bdConnexion = new BDConnexionMySQL("localhost","Sondio","essai","essai");
		this.bdGeneral = new BDGeneral(this.bdConnexion);
	}


	public Sondio getSondio() {
		return sondio;
	}


	public void setSondio(Sondio sondio) {
		this.sondio = sondio;
	}


	public Utilisateur getUser() {
		return user;
	}


	public void setUser(Utilisateur user) {
		this.user = user;
	}


	public BDConnexionMySQL getBdConnexion() {
		return bdConnexion;
	}


	public BDGeneral getBdGeneral() {
		return bdGeneral;
	}


	
	
	

}
