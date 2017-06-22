package Commun;

import BaseDeDonnees.BDConnexionMySQL;
import BaseDeDonnees.BDGeneral;
import BaseDeDonnees.Utilisateur;
/**
 * Modele commun est un modele qui va nous servir tout au long de l'application
 * @author nathan
 *
 */
public class ModeleCommun {
	/**
	 * La fenetre principale
	 * @see Sondio
	 */
	private Sondio sondio;
	/**
	 * L'utilisateur qui utilise l'application
	 * @see Utilisateur
	 */
	private Utilisateur user;
	
	/**
	 * La connexion mysql
	 * @see BDConnexionMySQL
	 */
	private BDConnexionMySQL bdConnexion;
	/**
	 * La classe ou va se trouver les fonctions jdbc utiles pour tous les modules
	 */
	private BDGeneral bdGeneral;
	
	/**
	 * Constructeur
	 * C'est ici qu'on initialise la connexion mysql pour tous les modules
	 * @param s
	 */
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

	/**
	   * Permet de revenir à l'écran de connexion de l'application
	   * @param sondio
	   * 	 La classe principale de l'application
	   */
	public void deconnexion(){
		this.user = null;
		this.sondio.afficherConnexion();
	}
	
	
	

}
