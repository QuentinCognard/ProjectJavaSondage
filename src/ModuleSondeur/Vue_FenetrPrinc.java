package ModuleSondeur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.ArrayList;

import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import BaseDeDonnees.BDGeneral;
import BaseDeDonnees.BDModuleSondeur;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Sonde;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Vue_FenetrPrinc extends JPanel {
	ArrayList<Questionnaire> lesQuestionnaire;
	BDGeneral laBD;
	BDModuleSondeur bdSond;
	JProgressBar progressBarSond;
	Sondeur s;

	public Vue_FenetrPrinc (Sondeur sondeur,BDGeneral laBD,Sonde s,BDModuleSondeur bdSond) {
		super();
		this.s=sondeur;

		this.bdSond=bdSond;
		this.laBD=laBD;
		this.lesQuestionnaire=laBD.getListeQuestionnaire('S');
		afficherPanelCentral();
	}
	

	
	public void afficherPanelCentral() {
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		panelPrincipal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPrincipal.setPreferredSize(new Dimension(500, 300));
		this.add(panelPrincipal,"Center");
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSondagesTerminer = new JLabel("Sondages à terminer :");
		lblSondagesTerminer.setPreferredSize(new Dimension(106, 30));
		panelPrincipal.add(lblSondagesTerminer,"North");
		
		JPanel panelListeSond = new JPanel();
		panelListeSond.setPreferredSize(new Dimension(100, 100));
		panelListeSond.setLayout(new BoxLayout(panelListeSond, BoxLayout.Y_AXIS));
		
		for ( int i=0;i<lesQuestionnaire.size();i++){
			JPanel panelEtatSond = new JPanel();
			panelEtatSond.setBorder(new EmptyBorder(5, 5, 5, 5));
			panelEtatSond.setMaximumSize(new Dimension(500, 30));
			panelEtatSond.setPreferredSize(new Dimension(200, 100));
			panelListeSond.add(panelEtatSond);
			
			JScrollPane jscroll = new JScrollPane(panelListeSond);
			jscroll.setBorder(new LineBorder(Color.BLACK));
			jscroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			jscroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			jscroll.setPreferredSize(new Dimension(100, 100));
			panelPrincipal.add(jscroll, BorderLayout.CENTER);
			panelEtatSond.setLayout(new GridLayout(0, 3, 5, 5));
	
			
			JLabel lblSondage = new JLabel(lesQuestionnaire.get(i).getTitreQuestionnaire());
			lblSondage.setPreferredSize(new Dimension(58, 20));
			lblSondage.setHorizontalTextPosition(SwingConstants.LEFT);
			panelEtatSond.add(lblSondage);
			
			this.progressBarSond = new JProgressBar();
			progressBarSond.setPreferredSize(new Dimension(100, 14));
			panelEtatSond.add(progressBarSond);
			
			JButton poursuivreButton = new JButton("Poursuivre");
			poursuivreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			poursuivreButton.addActionListener(new ControleurPrinc(this,lesQuestionnaire.get(i),laBD,bdSond));
	
			panelEtatSond.add(poursuivreButton);
		}
		
		JPanel panelVideG = new JPanel();
		panelPrincipal.add(panelVideG, BorderLayout.WEST);
		panelVideG.setPreferredSize(new Dimension(25, 10));
		
		JPanel panelVideD = new JPanel();
		panelPrincipal.add(panelVideD, BorderLayout.EAST);
		panelVideD.setPreferredSize(new Dimension(25, 10));
		
		JPanel panelVideBas = new JPanel();
		panelVideBas.setPreferredSize(new Dimension(10, 50));
		panelPrincipal.add(panelVideBas, BorderLayout.SOUTH);
		
		JPanel panelVide = new JPanel();
		panelVide.setPreferredSize(new Dimension(300, 100));
		add(panelVide, BorderLayout.SOUTH);
		
	}


}

