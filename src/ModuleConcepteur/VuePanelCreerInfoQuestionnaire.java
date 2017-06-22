package ModuleConcepteur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import BaseDeDonnees.BDModuleConcepteur;
import BaseDeDonnees.Client;
import BaseDeDonnees.Panel;

public class VuePanelCreerInfoQuestionnaire extends JPanel {
	VuePanelTextAvecField titre;
	VuePanelTextAvecComboBox societe;
	VuePanelTextAvecComboBox panel;
	BDModuleConcepteur bdC;
	ArrayList<Panel> listeP;
	ArrayList<Client> listeS;
	JPanel panelInfo;
	JPanel p ;
	
	VuePanelCreerInfoQuestionnaire(BDModuleConcepteur bdC){
		super();
		this.bdC = bdC;
		this.panelInfo = new JPanel();
		this.init();
	}
	
	private void init(){
		this.panelInfo.setLayout(new GridLayout(2,2));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setPreferredSize(new Dimension(600,250));
		this.panelInfo.setPreferredSize(new Dimension(598,248));
		
		this.listeP = this.bdC.getListePanel();
		String listePanel[]  = new String[listeP.size()];
		for (int i=0;i<listeP.size();i++){
			listePanel[i] = listeP.get(i).getNomPanel();
		}
		
		this.listeS = this.bdC.getListeSociete();
		String listeSociete[]  = new String[listeS.size()];
		for (int i=0;i<listeS.size();i++){
			listeSociete[i] = listeS.get(i).getRaisonSociale();
		}
		
		
		this.titre = new VuePanelTextAvecField("Titre",20);
		this.societe = new VuePanelTextAvecComboBox("Société cliente",listeSociete);
		this.panel = new VuePanelTextAvecComboBox("Panel",listePanel);
		JButton bouton = new JButton("Ajouter société cliente");
		ActionBoutonCreerInfo act = new ActionBoutonCreerInfo(this);
		bouton.addActionListener(act);
		this.panelInfo.add(this.titre);
		this.panelInfo.add(this.societe);
		this.panelInfo.add(this.panel);
		this.p = new JPanel();
		this.p.add(bouton);
		this.panelInfo.add(p);
		this.add(this.panelInfo);
		
	}
	
	public ArrayList<String> getInfo(){
		ArrayList<String> liste = new ArrayList<String>();
		System.out.println(this.titre.getJTextField().getText());
		liste.add(this.titre.getJTextField().getText());
		liste.add((String) this.societe.getJComboBox().getSelectedItem());
		liste.add((String) this.panel.getJComboBox().getSelectedItem());
		return liste;
	}
	
	public String getTitre(){
		return this.titre.getJTextField().getText();
	}
	
	public Client getClient(){
		for (Client c:this.listeS){
			if (((String) this.societe.getJComboBox().getSelectedItem()).equals(c.getRaisonSociale())){
				return c;
			}
		}
		return null;
	}
	
	public Panel getPanel(){
		for (Panel p:this.listeP){
			if (((String) this.panel.getJComboBox().getSelectedItem()).equals(p.getNomPanel())){
				return p;
			}
		}
		return null;
	}

	public void afficherAjouterClient() {
		this.removeAll();
		this.add(new ConcepteurAjouterClient(this.bdC,this));
		this.validate();
		this.repaint();
	}
	
	public void afficherInfo(){
		this.removeAll();
		
		this.listeS = this.bdC.getListeSociete();
		String listeSociete[]  = new String[listeS.size()];
		for (int i=0;i<listeS.size();i++){
			listeSociete[i] = listeS.get(i).getRaisonSociale();
			System.out.println(listeS.get(i).getRaisonSociale());
			
		}
		this.societe = new VuePanelTextAvecComboBox("Société cliente",listeSociete);
		this.panelInfo.removeAll();
		this.panelInfo.add(this.titre);
		this.panelInfo.add(this.societe);
		this.panelInfo.add(this.panel);
		this.panelInfo.add(p);
		this.add(this.panelInfo);
		
		this.validate();
		this.repaint();
	}

}
