package ModuleConnexion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDeDonnees.BDGeneral;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Utilisateur;

public class ActionSeConnecter implements ActionListener  {
	
	Connexion connexion;
	
	public ActionSeConnecter (Connexion c) {
		this.connexion = c;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		this.connexion.vueco.getMessage().setText(" ");	
		
		String log = this.connexion.vueco.getZoneDeSaisieLogin().getText();
		String mdp = new String (this.connexion.vueco.getZoneDeSaisieMotDePasse().getPassword());
		Utilisateur u = this.connexion.modeleconnexion.bdmoduleconnexion.connectionUtilisateur(log, mdp);
		
		// si le login et le mot de passe rentre par l'utilisateur existe dans la base de donnees
		if (u != null) {
			// on change l'user du modele general
			this.connexion.modelecommun.setUser(u);
			// on va se connecter au module concepteur si c'est un concepteur, sondeur si c'est un sondeur ...
			this.connexion.modeleconnexion.connexion(u.getIdentifiantRole());
		}
		
		// 
		else {
			this.connexion.vueco.getMessage().setText("Login ou mot de passe incorrect");	
			this.connexion.vueco.getMessage().setForeground(Color.RED);
			this.connexion.vueco.getZoneDeSaisieLogin().setText("");
			this.connexion.vueco.getZoneDeSaisieMotDePasse().setText("");
		}

	}
}