	package ModuleSondeur;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Sonde;

public class ControleurChoixMultiples implements ActionListener {

	private Vue_ChoixMultiples vueChoixmultiples;
	private Question laquestionsuiv;
	private Question laquestionpre;
	private Sonde lesonde;
	private Questionnaire questionnaire;
	private String val;
	private ArrayList<String> listechoix;
	private Sondeur s;

	private ArrayList<Question> listeQuest;

	
	public ControleurChoixMultiples(Vue_ChoixMultiples vueChoixmultiples){
		this.vueChoixmultiples=vueChoixmultiples;
		this.s=vueChoixmultiples.s;

		if (vueChoixmultiples.quest.getNumeroQuestion()<vueChoixmultiples.modrep.listeQuestion.size()){
			this.laquestionsuiv=vueChoixmultiples.modrep.listeQuestion.get(vueChoixmultiples.quest.getNumeroQuestion());
		}
		
		if (vueChoixmultiples.quest.getNumeroQuestion()>0){

			this.laquestionpre=vueChoixmultiples.modrep.listeQuestion.get(vueChoixmultiples.quest.getNumeroQuestion()-1);
		}
		
		this.lesonde=vueChoixmultiples.lesonde;
		this.questionnaire=vueChoixmultiples.questnaire;
		this.listeQuest=vueChoixmultiples.modrep.bdgene.getListeQuestion(questionnaire.getIdQuestionnaire());

		
	}

		
	public void actionPerformed(ActionEvent e) {
		
		
		for (Checkbox choix : vueChoixmultiples.lesCheckbox ){
			if (choix.getState()==true){
				if (listechoix.size()<vueChoixmultiples.quest.getMaxValeur()){
					listechoix.add(choix.getLabel());
				}
			}
			
		}
		
		val=listechoix.toString();
		
		if (((JButton)e.getSource()).getText().equals("Annuler sondage")){
			this.s.afficherFenetrePrinc();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Valider sondage")){
			vueChoixmultiples.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueChoixmultiples.quest.getNumeroQuestion(), vueChoixmultiples.quest.getIdTypeQuestion(), val);
			vueChoixmultiples.modrep.bdsond.setSondeInterroger(questionnaire,lesonde);
			this.s.afficherFenetrePrinc();

		}
		
		
		else if (((JButton)e.getSource()).getText().equals("Suivant")){
			vueChoixmultiples.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueChoixmultiples.quest.getNumeroQuestion(), vueChoixmultiples.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Precedent")){
			vueChoixmultiples.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueChoixmultiples.quest.getNumeroQuestion(), vueChoixmultiples.quest.getIdTypeQuestion(), val);
			if (laquestionpre.getIdTypeQuestion() =='u' || laquestionpre.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionpre,questionnaire,lesonde,vueChoixmultiples.modrep);
			}
			else if (laquestionpre.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionpre,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionpre,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionpre,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}

		}
		
		else if (Integer.parseInt(((JButton)e.getSource()).getText())<listeQuest.size()){
			
			this.laquestionsuiv=vueChoixmultiples.modrep.listeQuestion.get(Integer.parseInt(((JButton)e.getSource()).getText()));
			
			vueChoixmultiples.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueChoixmultiples.quest.getNumeroQuestion(), vueChoixmultiples.quest.getIdTypeQuestion(), val);
			
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}

		}
		

	}

}
