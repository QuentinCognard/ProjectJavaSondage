package ModuleConnexion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

import BaseDeDonnees.Utilisateur;

public class ActionSinscrire implements ActionListener {
	
	Connexion connexion;
	
	public ActionSinscrire (Connexion c) {
		this.connexion = c;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		this.connexion.vuein.getMessage().setText(" ");
		
		String prenom = this.connexion.vuein.getZoneDeSaisiePrenom().getText();
		String nom = this.connexion.vuein.getZoneDeSaisieNom().getText();
		String login = this.connexion.vuein.getZoneDeSaisieIdentifiant().getText();
		String mdp1 = new String (this.connexion.vuein.getZoneDeSaisieMotDePasse1().getPassword());
		String mdp2 = new String (this.connexion.vuein.getZoneDeSaisieMotDePasse2().getPassword());
		String [] listeChamps = {prenom, nom, login, mdp1, mdp2};
		
		// si certains champs sont vides
		if (fieldsVides(listeChamps)) {
			this.connexion.vuein.getMessage().setText("Un ou plusieurs champ(s) ne sont pas rempli(s), veuillez remplir tous les champs");
			this.connexion.vuein.getMessage().setForeground(Color.RED);
		}
		// si le login saisi existe deja
		else if (this.connexion.modeleconnexion.bdmoduleconnexion.loginDejaExistant(login)) {
			this.connexion.vuein.getMessage().setText("Ce login existe déjà, veuillez en choisir un autre");
			this.connexion.vuein.getMessage().setForeground(Color.RED);
		}
		// si les mots de passe saisis ne se correspondent pas
		else if (!mdp1.equals(mdp2)) {
			this.connexion.vuein.getMessage().setText("Les mots de passe sont différents, veuillez rentrer le même mot de passe dans les 2 champs");
			this.connexion.vuein.getMessage().setForeground(Color.RED);
		}
		
		else {
			Utilisateur user = new Utilisateur (this.connexion.modeleconnexion.bdmoduleconnexion.maxIdentifiantUtilisateur()+1, nom, prenom, login, mdp1, getCharactereChoixRole());
			this.connexion.modeleconnexion.bdmoduleconnexion.insererUtilisateur(user);
			this.connexion.modelecommun.setUser(user);
			this.connexion.modeleconnexion.connexion(user.getIdentifiantRole());
		}
	}
	
	public boolean fieldsVides (String [] champs) {
		for (String saisie : champs) {
			if (saisie.equals("")) {
				return true;
			}
		}
		return false;
	}
	
	public char getCharactereChoixRole () {
		if (this.connexion.vuein.getChoixConcepteur().isSelected()) {
			return '1';
		}
		
		else if (this.connexion.vuein.getChoixSondeur().isSelected()) {
			return '2';
		}
		
		else {
			return '3';
		}
	}
}
