package ModuleConcepteur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import BaseDeDonnees.BDModuleConcepteur;
import BaseDeDonnees.Client;

public class ConcepteurAjouterClient extends JPanel {
	VuePanelTextAvecField raisonSoc;
	VuePanelTextAvecField adresse1;
	VuePanelTextAvecField adresse2;
	VuePanelTextAvecField codePostal;
	VuePanelTextAvecField ville;
	VuePanelTextAvecField telephone;
	VuePanelTextAvecField email;
	BDModuleConcepteur bdC;
	VuePanelCreerInfoQuestionnaire vue;
	
	ConcepteurAjouterClient(BDModuleConcepteur bdC,VuePanelCreerInfoQuestionnaire vue){
		this.bdC = bdC;
		this.vue = vue;
		this.setPreferredSize(new Dimension(598,248));
		this.setLayout(new GridLayout(3,3));
		this.raisonSoc = new VuePanelTextAvecField("Raison sociale",15);
		this.adresse1 = new VuePanelTextAvecField("Adresse n°1",15);
		this.adresse2 = new VuePanelTextAvecField("Adresse n°2",15);
		this.codePostal = new VuePanelTextAvecField("Code Postal",15);
		this.ville = new VuePanelTextAvecField("Ville",15);
		this.telephone = new VuePanelTextAvecField("Telephone",15);
		this.email = new VuePanelTextAvecField("Email",15);
		this.add(this.raisonSoc);
		this.add(this.adresse1);
		this.add(this.adresse2);
		this.add(this.codePostal);
		this.add(this.ville);
		this.add(this.telephone);
		this.add(this.email);
		JPanel p1 = new JPanel();
		JButton annuler = new JButton("Annuler");
		p1.add(annuler);
		JPanel p2 = new JPanel();
		JButton enregistrer = new JButton("Enregistrer");
		p2.add(enregistrer);
		this.add(p1);
		this.add(p2);
		ActionBoutonCreerClient act = new ActionBoutonCreerClient(this);
		annuler.addActionListener(act);
		enregistrer.addActionListener(act);
	}

	public void creerClient() {
		Client c = new Client(this.bdC.maxIdentifiantClient()+10,this.raisonSoc.getJTextField().getText(),this.adresse1.getJTextField().getText(),this.adresse2.getJTextField().getText(),Integer.parseInt(this.codePostal.getJTextField().getText()),this.ville.getJTextField().getText(),this.telephone.getJTextField().getText(),this.email.getJTextField().getText());
		this.bdC.insererClient(c);
		this.vue.afficherInfo();
	}
	
	public VuePanelTextAvecField getCodeP() {
		return this.codePostal;
	}
	
	public void afficherInfoRetour(){
		this.vue.afficherInfo();
	}
}
