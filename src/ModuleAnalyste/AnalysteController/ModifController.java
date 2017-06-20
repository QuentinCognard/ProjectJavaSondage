package ModuleAnalyste.AnalysteController;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ModuleAnalyste.Analyste;

public class ModifController implements ActionListener {
	
	private Analyste ana;
	
	public ModifController(Analyste ana){
		super();
		this.ana = ana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//AnalysteModidfication ana = ((Component) e.getSource()).getParent()
		if (((JButton)e.getSource()).getText().equals("<== Retour")){
			//TODO: retour au panel pr�c�dent AVEC un message si le Travail non enregistr�
			System.out.println("RETOUR");
			ana.afficherPanelBase();
		}
		else if (((JButton)e.getSource()).getText().equals("Supprimer")){
			System.out.println("SUPPRIMER");
			//TODO:Supprime les resultats de la BD
		}
		else if (((JButton)e.getSource()).getText().equals("Enregistrer")){
			System.out.println("ENREGISTRER");
			//TODO:enregistre les res et la mise en forme dans un fichier
		}
		else if (((JButton)e.getSource()).getText().equals("Annuler")){
			System.out.println("ANNULER");
			//TODO:Revient � l'enregistrement pr�c�dent
		}
		else if (((JButton)e.getSource()).getText().equals("Generer un PDF")){
			if (ana.getAnalysteModification().isComment())
				System.out.println("PDF");
			else{
				JOptionPane.showMessageDialog(ana,"Commentaire final non rempli","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
			}
			//TODO:Genere un pdf et affiche une Jframe pour choisir l'emplacement de la save
		}
		else if (((JButton)e.getSource()).getText().equals("Se deconnecter")){
			System.out.println("DECONNEXION");
			ana.getModeleAnalyste().deconnexion(ana.getSondio());
			//TODO:Revient � l'�cran de connexion AVEC un message si le Travail non enregistr�
		}
		
	}

}