package ModuleConnexion;

import BaseDeDonnees.BDConnexionMySQL;
import BaseDeDonnees.BDModuleConnexion;
import Commun.ModeleCommun;

public class ModeleConnexion {
	
	Connexion connexion;
	
	ModeleCommun modelecommun;
	
	BDConnexionMySQL bdconnexionsql;
	BDModuleConnexion bdmoduleconnexion;
	
	ModeleConnexion (Connexion c) {
		this.connexion = c;
		this.modelecommun = c.modelecommun;
		this.bdconnexionsql = this.modelecommun.getBdConnexion();
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
