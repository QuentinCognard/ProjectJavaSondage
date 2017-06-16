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
	
	private ArrayList<Question> listeQuest;

	
	public ControleurEchelle(Vue_Echelle vueEchelle){
		this.vueEchelle=vueEchelle;
		
		if (vueEchelle.quest.getNumeroQuestion()<vueEchelle.modrep.listeQuestion.size()){
			this.laquestionsuiv=vueEchelle.modrep.listeQuestion.get(vueEchelle.quest.getNumeroQuestion()+1);
		}
		
		if (vueEchelle.quest.getNumeroQuestion()>0){

			this.laquestionpre=vueEchelle.modrep.listeQuestion.get(vueEchelle.quest.getNumeroQuestion()-1);
		}
		
		this.lesonde=vueEchelle.lesonde;
		this.questionnaire=vueEchelle.questnaire;
		this.listeQuest=vueEchelle.modrep.bdgene.getListeQuestion(questionnaire.getNumeroQuestionnaire());

		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Sondeur fenetresondage=(Sondeur) vueEchelle.getRootPane().getParent();
		
		this.val=String.valueOf(vueEchelle.slider.getValue());
		
		if (((JButton)e.getSource()).getText().equals("Annuler sondage")){
			fenetresondage.afficherFenetrePrinc();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Valider sondage")){
			vueEchelle.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueEchelle.quest.getNumeroQuestion(), vueEchelle.quest.getIdTypeQuestion(), val);
			vueEchelle.modrep.bdsond.setSondeInterroger(questionnaire,lesonde);
			fenetresondage.afficherFenetrePrinc();

		}
		
		else if (Integer.parseInt(((JButton)e.getSource()).getText())<listeQuest.size()){
			
			this.laquestionsuiv=vueEchelle.modrep.listeQuestion.get(Integer.parseInt(((JButton)e.getSource()).getText()));
			
			vueEchelle.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueEchelle.quest.getNumeroQuestion(), vueEchelle.quest.getIdTypeQuestion(), val);
			
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
	
			}

		}
	
		else if (((JButton)e.getSource()).getText().equals("Suivant")){
			vueEchelle.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueEchelle.quest.getNumeroQuestion(), vueEchelle.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueEchelle.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Précédent")){
			vueEchelle.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueEchelle.quest.getNumeroQuestion(), vueEchelle.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionpre,questionnaire,lesonde,vueEchelle.modrep);
			}
			else if (laquestionpre.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionpre,questionnaire,lesonde,vueEchelle.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionpre,questionnaire,lesonde,vueEchelle.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionpre,questionnaire,lesonde,vueEchelle.modrep);
	
			}

		}
		

	}

}
