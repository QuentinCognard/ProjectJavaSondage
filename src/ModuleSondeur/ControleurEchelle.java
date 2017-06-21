package ModuleSondeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Sonde;

public class ControleurEchelle implements ActionListener {
	private Vue_Echelle vueEchelle;
	private Question laquestionsuiv;
	private Question laquestionpre;
	private Sonde lesonde;
	private Questionnaire questionnaire;
	private String val;
	private Sondeur s;

	private ArrayList<Question> listeQuest;

	
	public ControleurEchelle(Vue_Echelle vueEchelle){
		this.vueEchelle=vueEchelle;
		this.s=vueEchelle.s;

		if (vueEchelle.quest.getNumeroQuestion()<vueEchelle.modrep.listeQuestion.size()){
			this.laquestionsuiv=vueEchelle.modrep.listeQuestion.get(vueEchelle.quest.getNumeroQuestion());
		}
		
		if (vueEchelle.quest.getNumeroQuestion()>1){

			this.laquestionpre=vueEchelle.modrep.listeQuestion.get(vueEchelle.quest.getNumeroQuestion()-1);
		}
		
		this.lesonde=vueEchelle.lesonde;
		this.questionnaire=vueEchelle.questnaire;
		this.listeQuest= new ArrayList<Question>();
		this.listeQuest=vueEchelle.modrep.bdgene.getListeQuestion(questionnaire.getIdQuestionnaire());

		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		this.val=String.valueOf(vueEchelle.slider.getValue());
		
		if (((JButton)e.getSource()).getText().equals("Annuler sondage")){
			this.s.afficherFenetrePrinc();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Valider sondage")){
			vueEchelle.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueEchelle.quest.getNumeroQuestion(), vueEchelle.quest.getIdTypeQuestion(), val);
			vueEchelle.modrep.bdsond.setSondeInterroger(questionnaire,lesonde);
			this.s.afficherFenetrePrinc();

		}
		
	
		else if (((JButton)e.getSource()).getText().equals("Suivant")){
			vueEchelle.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueEchelle.quest.getNumeroQuestion(), vueEchelle.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Precedent")){
			vueEchelle.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueEchelle.quest.getNumeroQuestion(), vueEchelle.quest.getIdTypeQuestion(), val);
			if (laquestionpre.getIdTypeQuestion() =='u' || laquestionpre.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionpre,questionnaire,lesonde,vueEchelle.modrep);
			}
			else if (laquestionpre.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionpre,questionnaire,lesonde,vueEchelle.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionpre,questionnaire,lesonde,vueEchelle.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionpre,questionnaire,lesonde,vueEchelle.modrep);
	
			}

		}
		
		
		else if (Integer.parseInt(((JButton)e.getSource()).getText())<listeQuest.size()+1){
			
			this.laquestionsuiv=vueEchelle.modrep.listeQuestion.get(Integer.parseInt(((JButton)e.getSource()).getText())-1);
			
			vueEchelle.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueEchelle.quest.getNumeroQuestion(), vueEchelle.quest.getIdTypeQuestion(), val);
			
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
	
			}

		}

	}

}
