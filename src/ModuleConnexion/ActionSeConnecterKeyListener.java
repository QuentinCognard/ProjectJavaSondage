package ModuleConnexion;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import BaseDeDonnees.Utilisateur;
/**
 * ActionSeConnecterKeyListener est une classe qui va gerer le bouton "Se connecter" dans la VueConnexion
 * Meme classe que ActionSeConnecter
 * @author nathan
 *
 */
public class ActionSeConnecterKeyListener implements KeyListener{
	/**
	 * La classe principale de ce module
	 * @see Connexion
	 */
	Connexion connexion;
	/**
	 * Constructeur
	 * @param c
	 */
	public ActionSeConnecterKeyListener (Connexion c) {
		this.connexion = c;
	}
	
	/**
	 * Va recuperer le login et le mot de passe rentre par l'utilisateur 
	 * et les verifier. Si ces champs sont corrects, la vue va changer 
	 * selon le role de l'utilisateur, sinon un message d'erreur est affiche
	 */
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
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

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
