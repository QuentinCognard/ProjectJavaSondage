package ModuleAnalyste.AnalysteController;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
			//TODO: retour au panel précédent AVEC un message si le Travail non enregistré
			System.out.println("RETOUR");
			ana.afficherPanelBase();
		}
		else if (((JButton)e.getSource()).getText().equals("Modifier")){
			System.out.println("INUTILE ?");
			//TODO: Est-ce que ce bouton est bien utile ?
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
			//TODO:Revient à l'enregistrement précédent
		}
		else if (((JButton)e.getSource()).getText().equals("Generer un PDF")){
			System.out.println("PDF");
			//TODO:Genere un pdf et affiche une Jframe pour choisir l'emplacement de la save
		}
		else if (((JButton)e.getSource()).getText().equals("Se deconnecter")){
			System.out.println("DECONNEXION");
			//TODO:Revient à l'écran de connexion AVEC un message si le Travail non enregistré
		}
		
	}

}