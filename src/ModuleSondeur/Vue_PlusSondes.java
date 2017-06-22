package ModuleSondeur;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class Vue_PlusSondes extends JPanel {
	Sondeur s;
	/**
	 * 
	 * @param sondeur
	 	* Le sondeur actuel
	 */	
	public Vue_PlusSondes (Sondeur sondeur) {
		super();
		
		this.s=sondeur;
		afficher();
	}
	
	/**
	 * Affiche le texte et le corp de la question
	 */
	public void afficher () {
		
		JPanel panel_principal = new JPanel();
		this.add(panel_principal, BorderLayout.CENTER);
		panel_principal.setLayout(new BorderLayout(0, 0));
			
		JPanel panel_corp = new JPanel();
		panel_corp.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_principal.add(panel_corp);
			
		JLabel lblPlusDeSonds = new JLabel("Plus de sondé à appeler");
		panel_corp.add(lblPlusDeSonds);
		
		JPanel panelRetour = new JPanel();
		panel_principal.add(panelRetour, BorderLayout.SOUTH);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ControleurPlusSond(this));
		panelRetour.add(btnRetour);
		
	}
}
