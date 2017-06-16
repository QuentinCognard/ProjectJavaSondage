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
	
	private ArrayList<Question> listeQuest;

	
	Contr_OuiNon(Vue_OuiNon vueOuiNon){
		this.vueOuiNon=vueOuiNon;
		
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
		
		Sondeur fenetresondage=(Sondeur) vueOuiNon.getRootPane().getParent();
		
		
		if (((JButton)e.getSource()).getText().equals("Annuler sondage")){
			fenetresondage.afficherFenetrePrinc();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Valider sondage")){
			
			vueOuiNon.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueOuiNon.quest.getNumeroQuestion(), vueOuiNon.quest.getIdTypeQuestion(), val);
			vueOuiNon.modrep.bdsond.setSondeInterroger(questionnaire,lesonde);

			fenetresondage.afficherFenetrePrinc();

		}
		
		else if (Integer.parseInt(((JButton)e.getSource()).getText())<listeQuest.size()){
			
			this.laquestionsuiv=vueOuiNon.modrep.listeQuestion.get(Integer.parseInt(((JButton)e.getSource()).getText()));
			
			vueOuiNon.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueOuiNon.quest.getNumeroQuestion(), vueOuiNon.quest.getIdTypeQuestion(), val);
			
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
	
			}

		}
	
		else if (((JButton)e.getSource()).getText().equals("Suivant")){
			vueOuiNon.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueOuiNon.quest.getNumeroQuestion(), vueOuiNon.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueOuiNon.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Précédent")){
			vueOuiNon.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueOuiNon.quest.getNumeroQuestion(), vueOuiNon.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionpre,questionnaire,lesonde,vueOuiNon.modrep);
			}
			else if (laquestionpre.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionpre,questionnaire,lesonde,vueOuiNon.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionpre,questionnaire,lesonde,vueOuiNon.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionpre,questionnaire,lesonde,vueOuiNon.modrep);
	
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
