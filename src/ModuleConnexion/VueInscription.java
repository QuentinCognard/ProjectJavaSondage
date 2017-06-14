package ModuleConnexion;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VueInscription extends JPanel {
	
	Connexion connexion;
	
	private JLabel message;
	
	private JTextField zonedesaisieprenom;
	private JTextField zonedesaisienom;
	private JTextField zonedesaisieid;
	
	private JPasswordField zonedesaisiemdp1;
	private JPasswordField zonedesaisiemdp2;
	
	private JRadioButton choixconcepteur;
	private JRadioButton choixsondeur;
	private JRadioButton choixanalyste;
	
	private JButton boutoninscription;
	
	public VueInscription (Connexion c) {
		super();
		this.connexion = c;
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		afficherTitre();
		afficherChamps();
		afficherBoutonInscription();
	}
	
	
	public JLabel getMessage () {
		return this.message;
	}
	
	public JTextField getZoneDeSaisiePrenom() {
		return this.zonedesaisieprenom;
	}
	
	public JTextField getZoneDeSaisieNom() {
		return this.zonedesaisienom;
	}
	
	public JTextField getZoneDeSaisieIdentifiant() {
		return this.zonedesaisieid;
	}
	
	public JPasswordField getZoneDeSaisieMotDePasse1() {
		return this.zonedesaisiemdp1;
	}
	
	public JPasswordField getZoneDeSaisieMotDePasse2() {
		return this.zonedesaisiemdp2;
	}

	public JRadioButton getChoixConcepteur () {
		return this.choixconcepteur;
	}

	public JRadioButton getChoixSondeur () {
		return this.choixsondeur;
	}
	
	public JRadioButton getChoixAnalyste () {
		return this.choixanalyste;
	}
	
	public JButton getBoutonInscription () {
		return this.boutoninscription;
	}

	
	
	public void afficherTitre () {
		JPanel boiteTitre = new JPanel();
		add(boiteTitre);
		
			JLabel titre = new JLabel("INSCRIPTION");
			boiteTitre.add(titre);
			titre.setFont(titre.getFont().deriveFont(50f));
	}
	
	public void afficherChamps () {
		
		String [] listeNomsChamps = {"Prénom ", "Nom ", "Identifiant ", "Mot de passe ", "Mot de passe à nouveau "};
		JTextField [] listeTextField = {this.zonedesaisieprenom, this.zonedesaisienom, this.zonedesaisieid};
		JPasswordField [] listePasswordField = {this.zonedesaisiemdp1, this.zonedesaisiemdp2};
		
		// boite qui va contenir les champs
		JPanel boiteChamps = new JPanel();
		boiteChamps.setLayout(new BoxLayout(boiteChamps, BoxLayout.Y_AXIS));
		add(boiteChamps);
		
		// partie message (erreurs ...)
		JPanel boiteMessage = new JPanel ();
		boiteChamps.add(boiteMessage);
				
			this.message = new JLabel (" ");
			boiteMessage.add(message);
		
		// partie prenom
		JPanel boitePrenom = new JPanel ();
		boiteChamps.add(boitePrenom);
			
			JLabel labelprenom = new JLabel ("Prénom");
			boitePrenom.add(labelprenom);
			labelprenom.setPreferredSize(new Dimension(200,20));
			labelprenom.setHorizontalAlignment(SwingConstants.CENTER);
			this.zonedesaisieprenom = new JTextField(20);
			boitePrenom.add(this.zonedesaisieprenom);
		
		// partie nom
		JPanel boiteNom = new JPanel ();
		boiteChamps.add(boiteNom);
				
				JLabel labelnom = new JLabel ("Nom");
				boiteNom.add(labelnom);
				labelnom.setPreferredSize(new Dimension(200,20));
				labelnom.setHorizontalAlignment(SwingConstants.CENTER);
				this.zonedesaisienom = new JTextField(20);
				boiteNom.add(this.zonedesaisienom);
		
		// partie login
		JPanel boiteLogin = new JPanel ();
		boiteChamps.add(boiteLogin);
						
				JLabel labellogin = new JLabel ("Login");
				boiteLogin.add(labellogin);
				labellogin.setPreferredSize(new Dimension(200,20));
				labellogin.setHorizontalAlignment(SwingConstants.CENTER);
				this.zonedesaisieid = new JTextField(20);
				boiteLogin.add(this.zonedesaisieid);
		
		// partie mot de passe 1
		JPanel boiteMdp1 = new JPanel ();
		boiteChamps.add(boiteMdp1);
								
				JLabel labelmdp1 = new JLabel ("Mot de passe");
				boiteMdp1.add(labelmdp1);
				labelmdp1.setPreferredSize(new Dimension(200,20));
				labelmdp1.setHorizontalAlignment(SwingConstants.CENTER);
				this.zonedesaisiemdp1 = new JPasswordField(20);
				this.zonedesaisiemdp1.setEchoChar('*');
				boiteMdp1.add(this.zonedesaisiemdp1);
		
		// partie mot de passe 2
		JPanel boiteMdp2 = new JPanel ();
		boiteChamps.add(boiteMdp2);
										
				JLabel labelmdp2 = new JLabel ("Mot de passe à nouveau");
				boiteMdp2.add(labelmdp2);
				labelmdp2.setPreferredSize(new Dimension(200,20));
				labelmdp2.setHorizontalAlignment(SwingConstants.CENTER);
				this.zonedesaisiemdp2 = new JPasswordField(20);
				this.zonedesaisiemdp2.setEchoChar('*');
				boiteMdp2.add(this.zonedesaisiemdp2);
				
		// partie role
		JPanel boiteRoles = new JPanel ();
		boiteChamps.add(boiteRoles);
				
			JLabel role = new JLabel ("Rôle envisagé                ");
			boiteRoles.add(role);	
			role.setPreferredSize(new Dimension(200,20));
			role.setHorizontalAlignment(SwingConstants.CENTER);
			
			JPanel panelChoix = new JPanel();
			boiteRoles.add(panelChoix);
			panelChoix.setLayout(new BoxLayout(panelChoix,BoxLayout.Y_AXIS)) ;
					
				choixconcepteur = new JRadioButton ("Concepteur");
				panelChoix.add(choixconcepteur);
				choixconcepteur.setSelected(true);
				choixsondeur = new JRadioButton ("Sondeur");
				panelChoix.add(choixsondeur);
				choixanalyste = new JRadioButton ("Analyste");
				panelChoix.add(choixanalyste);
				
				ButtonGroup groupeboutons = new ButtonGroup () ;
				groupeboutons.add(choixconcepteur);
				groupeboutons.add(choixsondeur);
				groupeboutons.add(choixanalyste);	
	}
	
	public void afficherBoutonInscription () {
		JPanel boiteBouton = new JPanel ();
		add(boiteBouton);
		
			this.boutoninscription = new JButton ("S'INSCRIRE");
			boiteBouton.add(this.boutoninscription);
			this.boutoninscription.setPreferredSize(new Dimension(250, 50));
			this.boutoninscription.setFont(this.boutoninscription.getFont().deriveFont(20f));
			this.boutoninscription.addActionListener(new ActionSinscrire(this.connexion));
	}

	
}
