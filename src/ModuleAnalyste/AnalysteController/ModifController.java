package ModuleAnalyste.AnalysteController;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import ModuleAnalyste.Analyste;

/**
 * ModifController est une classe (controller) qui gère tous les BOUTON de la vue AnalysteModification
 * @author Julien Revaud
 *
 */

public class ModifController implements ActionListener {
	
	/**
	 * La classe (vue) de base du module analyste
	 */
	private Analyste ana;
	
	/**
	   * cré la classe controller
	   * @param ana
	   * 	 la classe analyste
	   */
	public ModifController(Analyste ana){
		super();
		this.ana = ana;
	}
	
	/**
	   * execute une instruction lorsqu'un bouton est enclenché
	   * @param e
	   * 	 l'ActioEvent qui permet de retrouver quel bouton a été cliqué
	   */
	@Override
	public void actionPerformed(ActionEvent e) {
		//AnalysteModidfication ana = ((Component) e.getSource()).getParent()
		if (((JButton)e.getSource()).getText().equals("<== Retour")){
			ana.afficherPanelBase();
		}
		else if (((JButton)e.getSource()).getText().equals("Supprimer")){
			
			int choix = JOptionPane.showConfirmDialog(ana,"Etes-vous sûr de vouloir supprimer ce questionnaire ? \nAucune récupération ne pourra etre faite","ATTENTION",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			if (choix == JOptionPane.YES_OPTION)
			{
				ana.getModeleAnalyste().supprimerQuestionnaire();
				ana.afficherPanelBase();
			}
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
			{
				JFileChooser chooseSave = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf","PDF");
				chooseSave.setFileFilter(filter);
				int confirmation = chooseSave.showSaveDialog(ana);
				if (confirmation == JFileChooser.APPROVE_OPTION)
				{
					System.out.println(chooseSave.getSelectedFile().getAbsolutePath());
					try {
						ana.getModeleAnalyste().createPDF(chooseSave.getSelectedFile().getAbsolutePath()+".pdf", ana.getAnalysteModification().getListePGraphs(),ana.getAnalysteModification().getFieldCommentaireFinal().getText());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(ana,"Impossible de créer un pdf avec des tableaux pour le moment","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
						e1.printStackTrace();
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(ana,"Commentaire final non rempli","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
			}
			//TODO:Genere un pdf et affiche une Jframe pour choisir l'emplacement de la save
		}
		else if (((JButton)e.getSource()).getText().equals("Se deconnecter")){
			System.out.println("DECONNEXION");
			ana.getModeleAnalyste().deconnexion();
			//TODO:Revient � l'�cran de connexion AVEC un message si le Travail non enregistr�
		}
		
	}

}