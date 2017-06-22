package ModuleSondeur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Sonde;
import BaseDeDonnees.ValeurPossible;

import java.awt.Dimension;

public class Vue_Classement extends JPanel {
	Sonde lesonde;
	Questionnaire questnaire;
	Question quest;
	ModeleReponse modrep;
	ArrayList<ValeurPossible> valeursPossibles;
	ArrayList<String> listeclasse;
	Sondeur s;
	int classement;

	
	JPanel []lespanelschoix;
	JButton []lesboutonschoix;
	JLabel []leslabelschoix;
	
	JButton [] lesboutons;
	
	/**
	 * 
	 * @param sondeur
	 	* Le sondeur actuel
	 * @param lesonde
	 	* Le sonde actuel
	 * @param quest
	 	* La question actuel
	 * @param questnaire
	 	* Le questionnaire actuel
	 * @param modrep
	 	* Le modele de reponse
	 */
	
	public Vue_Classement (Sondeur sondeur,Sonde lesonde,Question quest,Questionnaire questnaire,ModeleReponse modrep) {
		super();
		this.s=sondeur;

		this.lesonde=lesonde;
		this.quest=quest;
		this.modrep=modrep;
		this.questnaire=questnaire;
		this.listeclasse= new ArrayList<String>();
		this.valeursPossibles=modrep.bdgene.getListeValPossible(questnaire.getIdQuestionnaire(), quest.getNumeroQuestion());
		this.lesboutons=new JButton [modrep.bdgene.getListeQuestion(questnaire.getIdQuestionnaire()).size()];
		this.lespanelschoix=new JPanel [valeursPossibles.size()];
		this.lesboutonschoix=new JButton [valeursPossibles.size()];
		this.leslabelschoix=new JLabel [valeursPossibles.size()];
		
		
		afficherClassement();
	}
	
	/**
	 * Affiche la question
	 */

	
	public void afficherClassement(){
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelHeader.setMaximumSize(new Dimension(10000, 250));
		panelPrincipal.add(panelHeader);
		panelHeader.setLayout(new BorderLayout(0, 0));
		
			JPanel panelInfoSond = new JPanel();
			panelInfoSond.setBorder(new EmptyBorder(0, 0, 0, 0));
			panelHeader.add(panelInfoSond);
			panelInfoSond.setLayout(new BoxLayout(panelInfoSond, BoxLayout.Y_AXIS));
			
			JLabel questionEtat = new JLabel("Question "+quest.getNumeroQuestion()+"/"+modrep.bdgene.getListeQuestion(questnaire.getIdQuestionnaire()).size());
			questionEtat.setAlignmentX(Component.CENTER_ALIGNMENT);
			questionEtat.setBorder(new EmptyBorder(20, 0, 5, 0));
			panelInfoSond.add(questionEtat);
			
			JLabel prenomNomSond = new JLabel(lesonde.getPrenomSonde()+" "+lesonde.getNomSonde());
			prenomNomSond.setAlignmentX(Component.CENTER_ALIGNMENT);
			prenomNomSond.setBorder(new EmptyBorder(5, 0, 20, 0));
			panelInfoSond.add(prenomNomSond);
			
			JPanel panelAnnul = new JPanel();
			panelHeader.add(panelAnnul, BorderLayout.WEST);
			
			JButton btnAnnule = new JButton("Annuler sondage");
			btnAnnule.addActionListener(new ControleurClassement(this));
			panelAnnul.add(btnAnnule);
			btnAnnule.setPreferredSize(new Dimension(200, 25));
			btnAnnule.setMinimumSize(new Dimension(11, 11));
			btnAnnule.setMaximumSize(new Dimension(1000, 1000));
			
			JPanel panelValid = new JPanel();
			panelValid.setPreferredSize(new Dimension(150, 10));
			panelHeader.add(panelValid, BorderLayout.EAST);


		JPanel panelQuestion = new JPanel();
		panelQuestion.setMaximumSize(new Dimension(10000, 32767));
		panelQuestion.setMinimumSize(new Dimension(1000, 10));
		panelQuestion.setPreferredSize(new Dimension(1000, 200));
		panelQuestion.setBorder(null);
		panelPrincipal.add(panelQuestion);
		panelQuestion.setLayout(null);
		
			JLabel intituleQuestion = new JLabel(quest.getTexteQuestion());
			intituleQuestion.setBounds(400, 0, 300, 49);
			intituleQuestion.setBorder(new EmptyBorder(20, 0, 15, 0));
			intituleQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelQuestion.add(intituleQuestion);
			
			JButton btnRein = new JButton("Reinitialiser");
			btnRein.setBounds(750, 10, 150, 30);
			btnRein.addActionListener(new ControleurClassement(this));
			panelQuestion.add(btnRein);
			
			
			JPanel panelListeChoix = new JPanel();
			panelListeChoix.setLayout(new BoxLayout(panelListeChoix, BoxLayout.Y_AXIS));
			
			
			
			for (ValeurPossible valpos : valeursPossibles){


				lespanelschoix[valpos.getIdValeur()-1]=new JPanel();
				lespanelschoix[valpos.getIdValeur()-1].setMaximumSize(new Dimension(1000, 40));
				lespanelschoix[valpos.getIdValeur()-1].setBorder(null);
				lespanelschoix[valpos.getIdValeur()-1].setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

				
					lesboutonschoix[valpos.getIdValeur()-1] = new JButton(valpos.getValeur());
					lesboutonschoix[valpos.getIdValeur()-1].addActionListener(new ControleurClassement(this));
					lespanelschoix[valpos.getIdValeur()-1].add(lesboutonschoix[valpos.getIdValeur()-1]);
					
					leslabelschoix[valpos.getIdValeur()-1] = new JLabel(": 0");
					leslabelschoix[valpos.getIdValeur()-1].setBorder(new EmptyBorder(0, 100, 0, 0));
					lespanelschoix[valpos.getIdValeur()-1].add(leslabelschoix[valpos.getIdValeur()-1]);
				
				panelListeChoix.add(lespanelschoix[valpos.getIdValeur()-1]); //avant cetait plus en haut

			}
		
		JScrollPane jscroll = new JScrollPane(panelListeChoix);
		jscroll.setSize(700, 150);
		jscroll.setLocation(100, 50);
		jscroll.setBorder(new LineBorder(Color.BLACK));
		jscroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jscroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jscroll.setPreferredSize(new Dimension(700, 700));
		panelQuestion.add(jscroll, BorderLayout.CENTER);
		
		JPanel panelLesQuestions = new JPanel();
		panelLesQuestions.setMaximumSize(new Dimension(1000, 1000));
		panelLesQuestions.setPreferredSize(new Dimension(1000, 70));
		panelPrincipal.add(panelLesQuestions);
		panelLesQuestions.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(15, 0, 0, 0)));
		FlowLayout fl_panelLesQuestions = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panelLesQuestions.setLayout(fl_panelLesQuestions);
		
		for (Question q : modrep.bdgene.getListeQuestion(questnaire.getIdQuestionnaire()) ){
			
			lesboutons[q.getNumeroQuestion()-1]=new JButton(String.valueOf(q.getNumeroQuestion()));
			if (q.getNumeroQuestion() > modrep.listerep.size()+1 ){
				lesboutons[q.getNumeroQuestion()-1].setEnabled(false);
			}
			lesboutons[q.getNumeroQuestion()-1].addActionListener(new ControleurClassement(this));

			panelLesQuestions.add(lesboutons[q.getNumeroQuestion()-1]);

		}
		
		
		JPanel panelNavi = new JPanel();
		panelNavi.setMaximumSize(new Dimension(32767, 15));
		panelNavi.setBorder(new EmptyBorder(15, 15, 15, 15));
		panelNavi.setPreferredSize(new Dimension(300, 100));
		panelPrincipal.add(panelNavi);
		panelNavi.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		if (quest.getNumeroQuestion()==1){
			
			JButton btnSuivant = new JButton("Suivant");
			btnSuivant.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnSuivant.addActionListener(new ControleurClassement(this));
			panelNavi.add(btnSuivant);
		}
		
		else if (quest.getNumeroQuestion()==modrep.listeQuestion.size()){
			
			JButton btnValide = new JButton("Valider sondage");
			btnValide.addActionListener(new ControleurClassement(this));
			panelValid.add(btnValide);
			
			JButton btnPrecedent = new JButton("Precedent");
			btnPrecedent.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnPrecedent.addActionListener(new ControleurClassement(this));
			panelNavi.add(btnPrecedent);
		}
		
		else {
			
			if (modrep.listerep.size()>=modrep.listeQuestion.size()){
				JButton btnValide = new JButton("Valider sondage");
				btnValide.addActionListener(new ControleurClassement(this));
				panelValid.add(btnValide);
			}
			
			JButton btnPrecedent = new JButton("Precedent");
			btnPrecedent.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnPrecedent.addActionListener(new ControleurClassement(this));
			panelNavi.add(btnPrecedent);
			
			JButton btnSuivant = new JButton("Suivant");
			btnSuivant.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnSuivant.addActionListener(new ControleurClassement(this));
			panelNavi.add(btnSuivant);
		}		
		
		
		System.out.println(modrep.listerep.size());


}


}
