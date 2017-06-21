package ModuleSondeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Sonde;

public class Contr_Libre implements ActionListener{
	
	private Vue_Libre vueLibre;
	private Question laquestionsuiv;
	private Question laquestionpre;
	private Sonde lesonde;
	private Questionnaire questionnaire;
	private String val;
	private Sondeur s;

	
	private ArrayList<Question> listeQuest;

	
	Contr_Libre(Vue_Libre vueLibre){
		this.vueLibre=vueLibre;
		this.s=vueLibre.s;

		
		if (vueLibre.quest.getNumeroQuestion()<vueLibre.modrep.listeQuestion.size()){
			this.laquestionsuiv=vueLibre.modrep.listeQuestion.get(vueLibre.quest.getNumeroQuestion());
		}
		
		if (vueLibre.quest.getNumeroQuestion()>0){

			this.laquestionpre=vueLibre.modrep.listeQuestion.get(vueLibre.quest.getNumeroQuestion()-1);
		}
		
		this.lesonde=vueLibre.lesonde;
		this.questionnaire=vueLibre.questnaire;
		this.listeQuest=vueLibre.modrep.bdgene.getListeQuestion(questionnaire.getIdQuestionnaire());
	}

public void actionPerformed(ActionEvent e) {
		
		
		val=vueLibre.reponse.getText();
		
		if (((JButton)e.getSource()).getText().equals("Annuler sondage")){
			this.s.afficherFenetrePrinc();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Valider sondage")){
			
			vueLibre.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueLibre.quest.getNumeroQuestion(), vueLibre.quest.getIdTypeQuestion(), val);
			vueLibre.modrep.bdsond.setSondeInterroger(questionnaire,lesonde);
			this.s.afficherFenetrePrinc();

		}
		

	
		else if (((JButton)e.getSource()).getText().equals("Suivant")){
			vueLibre.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueLibre.quest.getNumeroQuestion(), vueLibre.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Precedent")){
			vueLibre.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueLibre.quest.getNumeroQuestion(), vueLibre.quest.getIdTypeQuestion(), val);
			if (laquestionpre.getIdTypeQuestion() =='u' || laquestionpre.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionpre,questionnaire,lesonde,vueLibre.modrep);
			}
			else if (laquestionpre.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionpre,questionnaire,lesonde,vueLibre.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionpre,questionnaire,lesonde,vueLibre.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionpre,questionnaire,lesonde,vueLibre.modrep);
	
			}

		}
		
		else if (Integer.parseInt(((JButton)e.getSource()).getText())<listeQuest.size()+1){
			
			this.laquestionsuiv=vueLibre.modrep.listeQuestion.get(Integer.parseInt(((JButton)e.getSource()).getText())-1);
			
			vueLibre.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueLibre.quest.getNumeroQuestion(), vueLibre.quest.getIdTypeQuestion(), val);
			
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
	
			}

		}
		
		

	}
	
	
}
