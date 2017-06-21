package ModuleConnexion;

import BaseDeDonnees.BDConnexionMySQL;
import BaseDeDonnees.BDModuleConnexion;
import Commun.ModeleCommun;
/**
 * ModeleConnexion est la classe qui va nous servir de modele dans ce module
 * @author nathan
 *
 */
public class ModeleConnexion {
	/**
	 * La classe principale de ce module
	 * @see Connexion
	 */
	Connexion connexion;
	/**
	 * La connexion mysql
	 * @see BDConnexionMySQL
	 */
	BDConnexionMySQL bdconnexionsql;
	/**
	 * La classe ou se trouve les fonction jdbc
	 * @see BDModuleConnexion
	 */
	BDModuleConnexion bdmoduleconnexion;
	/**
	 * Constructeur
	 * @param c
	 */
	ModeleConnexion (Connexion c) {
		this.connexion = c;
		this.bdconnexionsql = c.modelecommun.getBdConnexion();
		this.bdmoduleconnexion = new BDModuleConnexion (this.bdconnexionsql);
	}
	
	/**
	 * Gere la connexion selon le role de l'utilisateur
	 * @param identifiantRoleUtilisateur
	 */
	public void connexion (char identifiantRoleUtilisateur) {
		// si l'utilisateur est un concepteur
		if (identifiantRoleUtilisateur == '1') {
			this.connexion.modelecommun.getSondio().afficherConcepteur();
		}
		// si l'utilisateur est un sondeur
		if (identifiantRoleUtilisateur == '2') {
			this.connexion.modelecommun.getSondio().afficherSondeur();
		}
		// si l'utilisateur est un analyste
		if (identifiantRoleUtilisateur == '3') {
			this.connexion.modelecommun.getSondio().afficherAnalyste();
		}
	}
	
	
}
