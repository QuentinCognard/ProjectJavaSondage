package ModuleConnexion;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class VueConnexion extends JPanel {
	
	Connexion connexion;
	
	private JLabel message;
	private JTextField zonedesaisielogin;
	private JPasswordField zonedesaisiemotdepasse;
	private JButton boutonconnexion;
	private JLabel motdepasseoublie;
	private JLabel inscription;
	
	public VueConnexion (Connexion c) {
		super();
		this.connexion = c;
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		afficherTitre();
		afficherChamps();
		afficherBoutonConnexion();
	}
	
	
	public JLabel getMessage () {
		return this.message;
	}
	
	public JTextField getZoneDeSaisieLogin () {
		return this.zonedesaisielogin;
	}
	
	public JPasswordField getZoneDeSaisieMotDePasse () {
		return this.zonedesaisiemotdepasse;
	}
	
	public JLabel getLabelMotDePasseOublie () {
		return this.motdepasseoublie;
	}
	
	public JLabel getLabelInscription () {
		return this.inscription; 
	}
	
	public JButton getBoutonConnexion () {
		return this.boutonconnexion;
	}
	
	
	
	
	public void afficherTitre () {
		JPanel boiteTitre = new JPanel();
		add(boiteTitre);
		boiteTitre.setBorder(BorderFactory.createEmptyBorder(0,0,-50,0));
		
			JLabel titre = new JLabel("CONNEXION");
			boiteTitre.add(titre);
			titre.setFont(titre.getFont().deriveFont(50f));
	}
	
	public void afficherChamps() {
		// partie message (mot de passe oublie ...)
		JPanel boiteMessage = new JPanel ();
		add(boiteMessage);
		boiteMessage.setBorder(BorderFactory.createEmptyBorder(0,0,-70,0));
		
			this.message = new JLabel (" ");
			boiteMessage.add(message);
			
		
		// partie saisie du login
		JPanel boiteLogin = new JPanel ();
		add(boiteLogin);
		boiteLogin.setBorder(BorderFactory.createEmptyBorder(0,0,-70,0));
		
			JLabel login = new JLabel("       Login        ");
			boiteLogin.add(login);
			login.setFont(login.getFont().deriveFont(25f));

			this.zonedesaisielogin = new JTextField (20);
			boiteLogin.add(this.zonedesaisielogin);
		
		// partie saisie du mot de passe
		JPanel boiteMotDePasse = new JPanel ();
		add(boiteMotDePasse);
		boiteMotDePasse.setBorder(BorderFactory.createEmptyBorder(0,0,-50,0));
			
			JLabel motdepasse = new JLabel("Mot de passe  ");
			boiteMotDePasse.add(motdepasse);
			motdepasse.setFont(motdepasse.getFont().deriveFont(25f));

			this.zonedesaisiemotdepasse = new JPasswordField (20);
			this.zonedesaisiemotdepasse.setEchoChar('*');
			boiteMotDePasse.add(this.zonedesaisiemotdepasse);
		
		// partie mot de passe oublie
		JPanel boitemotdepasseoublie = new JPanel ();
		add(boitemotdepasseoublie);
		boitemotdepasseoublie.setBorder(BorderFactory.createEmptyBorder(0,0,-90,0));
			
			this.motdepasseoublie = new JLabel("<HTML><U>Mot de passe oublié ?</U> </HTML>");
			boitemotdepasseoublie.add(this.motdepasseoublie);
			this.motdepasseoublie.setForeground(Color.blue);
			this.motdepasseoublie.addMouseListener(new ActionMotDePasseOublie(this.connexion));
		
		// partie inscription
		JPanel boiteinscription = new JPanel ();
		add(boiteinscription);
		boiteinscription.setBorder(BorderFactory.createEmptyBorder(0,0,-50,0));
				
			this.inscription = new JLabel("<HTML><U>Vous n'avez pas de compte ? Créez-en un !</U></HTML>");
			boiteinscription.add(this.inscription);
			this.inscription.setForeground(Color.blue);
			this.inscription.addMouseListener(new ActionPasDeCompte(this.connexion));
	}
	
	public void afficherBoutonConnexion () {
		JPanel boiteBouton = new JPanel ();
		add(boiteBouton);
		
			this.boutonconnexion = new JButton ("SE CONNECTER");
			boiteBouton.add(this.boutonconnexion);
			this.boutonconnexion.setPreferredSize(new Dimension(250, 50));
			this.boutonconnexion.setFont(this.boutonconnexion.getFont().deriveFont(20f));
			this.boutonconnexion.addActionListener(new ActionSeConnecter(this.connexion));
	}

}

