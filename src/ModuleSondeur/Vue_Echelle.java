package ModuleSondeur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Sonde;

import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;

public class Vue_Echelle extends JPanel {
	private JTextField txtSaisirUneValeur;
	Sonde lesonde;
	Questionnaire questnaire;
	Question quest;
	ModeleReponse modrep;
	JSlider slider;

	
	public Vue_Echelle (Sonde lesonde,Question quest,Questionnaire questnaire,ModeleReponse modrep) {
		super();
		
		this.lesonde=lesonde;
		this.quest=quest;
		this.modrep=modrep;
		this.questnaire=questnaire;
		
		afficherEchelle();
	}
	

	

	public void afficherEchelle(){
		
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
			
			JLabel questionEtat = new JLabel("Question "+quest.getNumeroQuestion()+"/"+quest.getMaxValeur());
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
			btnAnnule.addActionListener(new ControleurEchelle(this));
			panelAnnul.add(btnAnnule);
			btnAnnule.setPreferredSize(new Dimension(150, 25));
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
		panelQuestion.setLayout(new BoxLayout(panelQuestion, BoxLayout.Y_AXIS));
		
			JLabel intituleQuestion = new JLabel(quest.getTexteQuestion());
			intituleQuestion.setBorder(new EmptyBorder(20, 0, 60, 0));
			intituleQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelQuestion.add(intituleQuestion);
			
			JLabel lbSaisir = new JLabel("Saisir une valeur :");
			lbSaisir.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelQuestion.add(lbSaisir);
			
			txtSaisirUneValeur = new JTextField();
			txtSaisirUneValeur.setToolTipText("");
			txtSaisirUneValeur.setMaximumSize(new Dimension(100, 40));
			panelQuestion.add(txtSaisirUneValeur);
			txtSaisirUneValeur.setColumns(10);
			
			this.slider = new JSlider();
			slider.setPaintLabels(true);
			slider.setPaintTicks(true);
			slider.setMinorTickSpacing(1);
			slider.setMajorTickSpacing(1);
			slider.setMaximumSize(new Dimension(400, 50));
			slider.setMaximum(quest.getMaxValeur());
			panelQuestion.add(slider);
		
		JPanel panelLesQuestions = new JPanel();
		panelLesQuestions.setMaximumSize(new Dimension(1000, 1000));
		panelLesQuestions.setPreferredSize(new Dimension(1000, 70));
		panelPrincipal.add(panelLesQuestions);
		panelLesQuestions.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(15, 0, 0, 0)));
		FlowLayout fl_panelLesQuestions = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panelLesQuestions.setLayout(fl_panelLesQuestions);
		
		JButton []lesboutons={};
		for (Question q : modrep.bdgene.getListeQuestion(questnaire.getNumeroQuestionnaire()) ){
			
			lesboutons[q.getNumeroQuestion()]=new JButton(String.valueOf(q.getNumeroQuestion()));
		
			panelLesQuestions.add(lesboutons[q.getNumeroQuestion()]);

		}
		
		JPanel panelNavi = new JPanel();
		panelNavi.setMaximumSize(new Dimension(32767, 15));
		panelNavi.setBorder(new EmptyBorder(15, 15, 15, 15));
		panelNavi.setPreferredSize(new Dimension(300, 100));
		panelPrincipal.add(panelNavi);
		panelNavi.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		
		if (quest.getNumeroQuestion()==0){
			
			JButton btnSuivant = new JButton("Suivant");
			btnSuivant.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnSuivant.addActionListener(new ControleurEchelle(this));
			panelNavi.add(btnSuivant);
		}
		
		else if (quest.getNumeroQuestion()==modrep.listeQuestion.size()){
			
			JButton btnValide = new JButton("Valider sondage");
			btnValide.addActionListener(new ControleurEchelle(this));
			panelValid.add(btnValide);
			
			JButton btnPrecedent = new JButton("Précédent");
			btnPrecedent.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnPrecedent.addActionListener(new ControleurEchelle(this));
			panelNavi.add(btnPrecedent);
		}
		
		else {
			JButton btnPrecedent = new JButton("Précédent");
			btnPrecedent.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnPrecedent.addActionListener(new ControleurEchelle(this));
			panelNavi.add(btnPrecedent);
			
			JButton btnSuivant = new JButton("Suivant");
			btnSuivant.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnSuivant.addActionListener(new ControleurEchelle(this));
			panelNavi.add(btnSuivant);
		}

	}
}
