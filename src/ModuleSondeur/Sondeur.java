package ModuleSondeur;

import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;

import BaseDeDonnees.BDConnexionMySQL;
import BaseDeDonnees.BDGeneral;
import BaseDeDonnees.BDModuleSondeur;
import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Sonde;
import Commun.ModeleCommun;




public class Sondeur extends JPanel {

	ModeleReponse modrep;
	Vue_FenetrPrinc fenetredebut;
	Vue_ChoixMultiples choixmultiples;
	Vue_Libre replibre;
	Vue_PlusSondes plusonde;
	Vue_Classement classement;
	Vue_PlusSondes plusSondes;
	Vue_Echelle echelle;
	BDGeneral laBD;
	BDModuleSondeur bdSond;
	Question quest;
	Questionnaire questionnaire;
	Sonde lesonde;
	int numQuestion;
	ModeleCommun modcom;
	BDConnexionMySQL connexion;
	
	
	public Sondeur (ModeleCommun modcom) {
		super();
		this.connexion=this.modcom.getBdConnexion();
		this.laBD=modcom.getBdGeneral();
		this.bdSond= new BDModuleSondeur(this.connexion); 
		this.numQuestion=0;
		this.setLayout(new BorderLayout());
		afficherFenetrePrinc();
	}
	
	public void afficherPanelDuHaut () {
		setLayout(new BorderLayout(0, 0));
		JPanel panelduhaut = new JPanel();
		panelduhaut.setPreferredSize(new Dimension(300, 250));
		this.add(panelduhaut,"North");
		panelduhaut.setLayout(new BorderLayout());
		
		JPanel boiteImage = new JPanel ();
		panelduhaut.add(boiteImage,"Center");
			// creation de l'image
			JLabel labelImage = new JLabel ();
			boiteImage.add(labelImage);
			Icon source = new ImageIcon("Sondeur.png");
			ImageIcon imageconnexion = new ImageIcon(((ImageIcon) source).getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT));
			labelImage.setIcon(imageconnexion);	
	}
	
	public void afficherFenetrePrinc(){
		removeAll();
		afficherPanelDuHaut();
		this.fenetredebut=new Vue_FenetrPrinc(this,this.laBD,lesonde,bdSond);
		add(this.fenetredebut,"Center");


	}
	
	public void afficherChoixMultiples(Question quest,Questionnaire questionnaire,Sonde lesonde,ModeleReponse modrep){
		removeAll();
		this.lesonde=lesonde;
		this.quest=quest;
		this.questionnaire=questionnaire;
		this.modrep=modrep;
		afficherPanelDuHaut();
		this.choixmultiples = new Vue_ChoixMultiples (this,lesonde,quest,questionnaire,modrep);
		add(this.choixmultiples, "Center");
		validate();
		repaint();
	}
	
	public void afficherClassement(Question quest,Questionnaire questionnaire,Sonde lesonde,ModeleReponse modrep){
		removeAll();
		this.lesonde=lesonde;
		this.quest=quest;
		this.questionnaire=questionnaire;
		afficherPanelDuHaut();
		this.modrep=modrep;
		this.classement = new Vue_Classement (this,lesonde,quest,questionnaire,modrep);
		add(this.classement, "Center");
		validate();
		repaint();
	}
	
	public void afficherEchelle(Question quest,Questionnaire questionnaire,Sonde lesonde,ModeleReponse modrep){
		removeAll();
		this.lesonde=lesonde;
		this.quest=quest;
		this.questionnaire=questionnaire;
		this.modrep=modrep;
		afficherPanelDuHaut();
		this.echelle = new Vue_Echelle (this,lesonde,quest,questionnaire,modrep);
		add(this.echelle, "Center");
		validate();
		repaint();
	}
	
	public void afficherLibre(Question quest,Questionnaire questionnaire,Sonde lesonde,ModeleReponse modrep){
		removeAll();
		this.lesonde=lesonde;
		this.quest=quest;
		this.questionnaire=questionnaire;
		this.modrep=modrep;
		afficherPanelDuHaut();
		this.replibre = new Vue_Libre (this,lesonde,quest,questionnaire,modrep);
		add(this.choixmultiples, "Center");
		validate();
		repaint();
	}
	

	public void afficherPlusDeSonde(){
		removeAll();
		afficherPanelDuHaut();
		this.plusSondes=new Vue_PlusSondes(this);
		add(this.fenetredebut,"Center");


	}

}

