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
	
	private ArrayList<Question> listeQuest;

	
	public ControleurChoixMultiples(Vue_ChoixMultiples vueChoixmultiples){
		this.vueChoixmultiples=vueChoixmultiples;
		if (vueChoixmultiples.quest.getNumeroQuestion()<vueChoixmultiples.modrep.listeQuestion.size()){
			this.laquestionsuiv=vueChoixmultiples.modrep.listeQuestion.get(vueChoixmultiples.quest.getNumeroQuestion()+1);
		}
		
		if (vueChoixmultiples.quest.getNumeroQuestion()>0){

			this.laquestionpre=vueChoixmultiples.modrep.listeQuestion.get(vueChoixmultiples.quest.getNumeroQuestion()-1);
		}
		
		this.lesonde=vueChoixmultiples.lesonde;
		this.questionnaire=vueChoixmultiples.questnaire;
		this.listeQuest=vueChoixmultiples.modrep.bdgene.getListeQuestion(questionnaire.getNumeroQuestionnaire());

		
	}

		
	public void actionPerformed(ActionEvent e) {
		
		Sondeur fenetresondage=(Sondeur) vueChoixmultiples.getRootPane().getParent();
		
		for (Checkbox choix : vueChoixmultiples.lesCheckbox ){
			if (choix.getState()==true){
				if (listechoix.size()<vueChoixmultiples.quest.getMaxValeur()){
					listechoix.add(choix.getLabel());
				}
			}
			
		}
		
		val=listechoix.toString();
		
		if (((JButton)e.getSource()).getText().equals("Annuler sondage")){
			fenetresondage.afficherFenetrePrinc();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Valider sondage")){
			vueChoixmultiples.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueChoixmultiples.quest.getNumeroQuestion(), vueChoixmultiples.quest.getIdTypeQuestion(), val);
			vueChoixmultiples.modrep.bdsond.setSondeInterroger(questionnaire,lesonde);
			fenetresondage.afficherFenetrePrinc();

		}
		
		else if (Integer.parseInt(((JButton)e.getSource()).getText())<listeQuest.size()){
			
			this.laquestionsuiv=vueChoixmultiples.modrep.listeQuestion.get(Integer.parseInt(((JButton)e.getSource()).getText()));
			
			vueChoixmultiples.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueChoixmultiples.quest.getNumeroQuestion(), vueChoixmultiples.quest.getIdTypeQuestion(), val);
			
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Suivant")){
			vueChoixmultiples.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueChoixmultiples.quest.getNumeroQuestion(), vueChoixmultiples.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Précédent")){
			vueChoixmultiples.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueChoixmultiples.quest.getNumeroQuestion(), vueChoixmultiples.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionpre,questionnaire,lesonde,vueChoixmultiples.modrep);
			}
			else if (laquestionpre.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionpre,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionpre,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionpre,questionnaire,lesonde,vueChoixmultiples.modrep);
	
			}

		}
		

	}

}
