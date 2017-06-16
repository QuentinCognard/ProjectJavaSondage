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
	
	private ArrayList<Question> listeQuest;

	
	Contr_Libre(Vue_Libre vueLibre){
		this.vueLibre=vueLibre;
		
		if (vueLibre.quest.getNumeroQuestion()<vueLibre.modrep.listeQuestion.size()){
			this.laquestionsuiv=vueLibre.modrep.listeQuestion.get(vueLibre.quest.getNumeroQuestion()+1);
		}
		
		if (vueLibre.quest.getNumeroQuestion()>0){

			this.laquestionpre=vueLibre.modrep.listeQuestion.get(vueLibre.quest.getNumeroQuestion()-1);
		}
		
		this.lesonde=vueLibre.lesonde;
		this.questionnaire=vueLibre.questnaire;
		this.listeQuest=vueLibre.modrep.bdgene.getListeQuestion(questionnaire.getNumeroQuestionnaire());
	}

public void actionPerformed(ActionEvent e) {
		
		Sondeur fenetresondage=(Sondeur) vueLibre.getRootPane().getParent();
		
		val=vueLibre.reponse.getText();
		
		if (((JButton)e.getSource()).getText().equals("Annuler sondage")){
			fenetresondage.afficherFenetrePrinc();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Valider sondage")){
			
			vueLibre.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueLibre.quest.getNumeroQuestion(), vueLibre.quest.getIdTypeQuestion(), val);
			vueLibre.modrep.bdsond.setSondeInterroger(questionnaire,lesonde);
			fenetresondage.afficherFenetrePrinc();

		}
		
		else if (Integer.parseInt(((JButton)e.getSource()).getText())<listeQuest.size()){
			
			this.laquestionsuiv=vueLibre.modrep.listeQuestion.get(Integer.parseInt(((JButton)e.getSource()).getText()));
			
			vueLibre.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueLibre.quest.getNumeroQuestion(), vueLibre.quest.getIdTypeQuestion(), val);
			
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
			}

		}
	
		else if (((JButton)e.getSource()).getText().equals("Suivant")){
			vueLibre.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueLibre.quest.getNumeroQuestion(), vueLibre.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueLibre.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Précédent")){
			vueLibre.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueLibre.quest.getNumeroQuestion(), vueLibre.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionpre,questionnaire,lesonde,vueLibre.modrep);
			}
			else if (laquestionpre.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionpre,questionnaire,lesonde,vueLibre.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionpre,questionnaire,lesonde,vueLibre.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionpre,questionnaire,lesonde,vueLibre.modrep);
	
			}

		}
		
		

	}
	
	
}
