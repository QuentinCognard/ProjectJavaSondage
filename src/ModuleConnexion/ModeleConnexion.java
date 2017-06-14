package ModuleConnexion;

import BaseDeDonnees.BDConnexionMySQL;
import BaseDeDonnees.BDModuleConnexion;

public class ModeleConnexion {
	
	Connexion connexion;
	BDConnexionMySQL bdconnexionsql;
	BDModuleConnexion bdmoduleconnexion;
	
	ModeleConnexion (Connexion c) {
		this.connexion = c;
		this.bdconnexionsql = new BDConnexionMySQL ("localhost", "Sondio", "essai", "essai");
		this.bdmoduleconnexion = new BDModuleConnexion (this.bdconnexionsql);
	}
	
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
