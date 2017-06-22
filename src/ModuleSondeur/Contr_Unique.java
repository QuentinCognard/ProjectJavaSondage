	package ModuleSondeur;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Sonde;
import BaseDeDonnees.ValeurPossible;

public class Contr_Unique implements ActionListener {

	private Vue_Unique vueUnique;
	private Question laquestionsuiv;
	private Question laquestionpre;
	private Sonde lesonde;
	private Questionnaire questionnaire;
	private String val;
	private ArrayList<String> listechoix;
	private Sondeur s;

	private ArrayList<Question> listeQuest;

	/**
 	*Controlleur pour la vue Choix Unique
	*@param vueUnique
		*La vue que l'on va utiliser pour ce controleur
	*/
	
	public Contr_Unique(Vue_Unique vueUnique){
		this.vueUnique=vueUnique;
		this.s=vueUnique.s;

		if (vueUnique.quest.getNumeroQuestion()<vueUnique.modrep.listeQuestion.size()){
			this.laquestionsuiv=vueUnique.modrep.listeQuestion.get(vueUnique.quest.getNumeroQuestion());
		}
		
		if (vueUnique.quest.getNumeroQuestion()>0){

			this.laquestionpre=vueUnique.modrep.listeQuestion.get(vueUnique.quest.getNumeroQuestion()-2);
		}
		
		this.lesonde=vueUnique.lesonde;
		this.questionnaire=vueUnique.questnaire;
		this.listechoix=vueUnique.lalistedechoix;
		this.listeQuest=vueUnique.modrep.bdgene.getListeQuestion(questionnaire.getIdQuestionnaire());

		
	}

		
	public void actionPerformed(ActionEvent e) {
		
		
		this.val=vueUnique.txtSaisirUneValeur.getText();
				
		if (((JButton)e.getSource()).getText().equals("Annuler sondage")){
			this.s.afficherFenetrePrinc();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Valider sondage")){
			vueUnique.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueUnique.quest.getNumeroQuestion(), val);

			vueUnique.modrep.validerQuestionnaire();
			vueUnique.modrep.bdsond.setSondeInterroger(questionnaire,lesonde);
			this.s.afficherFenetrePrinc();

		}
		
		
		else if (((JButton)e.getSource()).getText().equals("Suivant")){
			vueUnique.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueUnique.quest.getNumeroQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueUnique.modrep);
			}
			else if(laquestionsuiv.getIdTypeQuestion() =='u'){
				this.s.afficherUnique(laquestionsuiv,questionnaire,lesonde,vueUnique.modrep);

			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueUnique.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueUnique.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueUnique.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Precedent")){
			if (laquestionpre.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionpre,questionnaire,lesonde,vueUnique.modrep);
			}
			else if(laquestionpre.getIdTypeQuestion() =='u'){
				this.s.afficherUnique(laquestionpre,questionnaire,lesonde,vueUnique.modrep);

			}
			else if (laquestionpre.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionpre,questionnaire,lesonde,vueUnique.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionpre,questionnaire,lesonde,vueUnique.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionpre,questionnaire,lesonde,vueUnique.modrep);
	
			}

		}
		
		else if (Integer.parseInt(((JButton)e.getSource()).getText())<listeQuest.size()-1){
			
			this.laquestionsuiv=vueUnique.modrep.listeQuestion.get(Integer.parseInt(((JButton)e.getSource()).getText())+1);
			
			vueUnique.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueUnique.quest.getNumeroQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueUnique.modrep);
			}
			else if(laquestionsuiv.getIdTypeQuestion() =='u'){
				this.s.afficherUnique(laquestionsuiv,questionnaire,lesonde,vueUnique.modrep);

			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueUnique.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueUnique.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueUnique.modrep);
	
			}

		}
		

	}

}
