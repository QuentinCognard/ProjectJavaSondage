package ModuleSondeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Sonde;

public class Contr_OuiNon implements ActionListener{
	
	private Vue_OuiNon vueOuiNon;
	private Question laquestionsuiv;
	private Question laquestionpre;
	private Sonde lesonde;
	private Questionnaire questionnaire;
	private String val;
	private Sondeur s;

	private ArrayList<Question> listeQuest;

	
	Contr_OuiNon(Vue_OuiNon vueOuiNon){
		this.vueOuiNon=vueOuiNon;
		this.s=vueOuiNon.s;

		
		if (vueOuiNon.quest.getNumeroQuestion()<vueOuiNon.modrep.listeQuestion.size()){
			this.laquestionsuiv=vueOuiNon.modrep.listeQuestion.get(vueOuiNon.quest.getNumeroQuestion()+1);
		}
		
		if (vueOuiNon.quest.getNumeroQuestion()>0){

			this.laquestionpre=vueOuiNon.modrep.listeQuestion.get(vueOuiNon.quest.getNumeroQuestion()-1);
		}
		
		this.lesonde=vueOuiNon.lesonde;
		this.questionnaire=vueOuiNon.questnaire;
		this.listeQuest=vueOuiNon.modrep.bdgene.getListeQuestion(questionnaire.getNumeroQuestionnaire());
	}

public void actionPerformed(ActionEvent e) {
		
		
		
		if (((JButton)e.getSource()).getText().equals("Annuler sondage")){
			this.s.afficherFenetrePrinc();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Valider sondage")){
			
			vueOuiNon.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueOuiNon.quest.getNumeroQuestion(), vueOuiNon.quest.getIdTypeQuestion(), val);
			vueOuiNon.modrep.bdsond.setSondeInterroger(questionnaire,lesonde);

			this.s.afficherFenetrePrinc();

		}
		
		else if (Integer.parseInt(((JButton)e.getSource()).getText())<listeQuest.size()){
			
			this.laquestionsuiv=vueOuiNon.modrep.listeQuestion.get(Integer.parseInt(((JButton)e.getSource()).getText()));
			
			vueOuiNon.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueOuiNon.quest.getNumeroQuestion(), vueOuiNon.quest.getIdTypeQuestion(), val);
			
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
	
			}

		}
	
		else if (((JButton)e.getSource()).getText().equals("Suivant")){
			vueOuiNon.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueOuiNon.quest.getNumeroQuestion(), vueOuiNon.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Précédent")){
			vueOuiNon.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueOuiNon.quest.getNumeroQuestion(), vueOuiNon.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionpre,questionnaire,lesonde,vueOuiNon.modrep);
			}
			else if (laquestionpre.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionpre,questionnaire,lesonde,vueOuiNon.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionpre,questionnaire,lesonde,vueOuiNon.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionpre,questionnaire,lesonde,vueOuiNon.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Oui")){
			val=((JButton)e.getSource()).getText();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Non")){
			val=((JButton)e.getSource()).getText();
		}
		

	}
	
	
}
