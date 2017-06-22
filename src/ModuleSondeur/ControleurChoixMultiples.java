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
	/**
 	*Controlleur pour la vue Choix Multiples
	*@param vueChoixmultiples
		*La vue que l'on va utiliser pour ce controleur
	*/
	
	public ControleurChoixMultiples(Vue_ChoixMultiples vueChoixmultiples){
		this.vueChoixmultiples=vueChoixmultiples;
		this.s=vueChoixmultiples.s;

		if (vueChoixmultiples.quest.getNumeroQuestion()<vueChoixmultiples.modrep.listeQuestion.size()){
			this.laquestionsuiv=vueChoixmultiples.modrep.listeQuestion.get(vueChoixmultiples.quest.getNumeroQuestion());
		}
		
		if (vueChoixmultiples.quest.getNumeroQuestion()>0){

			this.laquestionpre=vueChoixmultiples.modrep.listeQuestion.get(vueChoixmultiples.quest.getNumeroQuestion()-2);
		}
		
		this.lesonde=vueChoixmultiples.lesonde;
		this.questionnaire=vueChoixmultiples.questnaire;
		this.listechoix=vueChoixmultiples.lalistedechoix;
		this.listeQuest=vueChoixmultiples.modrep.bdgene.getListeQuestion(questionnaire.getIdQuestionnaire());

		
	}

		
	public void actionPerformed(ActionEvent e) {
		
		
		for (Checkbox choix : vueChoixmultiples.lesCheckbox ){
			if (choix.getState()==true){
				if (listechoix.size()<vueChoixmultiples.quest.getMaxValeur()){
					for (ValeurPossible valpos : vueChoixmultiples.valeursPossibles){
						if (valpos.getValeur()==choix.getLabel()){
							listechoix.add(String.valueOf(valpos.getIdValeur()));
						}
					}
				}
			}
			
		}
		
		if (listechoix!=null){
			this.val=listechoix.toString();
			this.val=this.val.replace(',',';');
			
		}
				
		if (((JButton)e.getSource()).getText().equals("Annuler sondage")){
			this.s.afficherFenetrePrinc();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Valider sondage")){
			vueChoixmultiples.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueChoixmultiples.quest.getNumeroQuestion(), val);

			vueChoixmultiples.modrep.validerQuestionnaire();
			vueChoixmultiples.modrep.bdsond.setSondeInterroger(questionnaire,lesonde);
			this.s.afficherFenetrePrinc();

		}
		
		
		else if (((JButton)e.getSource()).getText().equals("Suivant")){
			vueChoixmultiples.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueChoixmultiples.quest.getNumeroQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
			}
			else if(laquestionsuiv.getIdTypeQuestion() =='u'){
				this.s.afficherUnique(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);

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
			if (laquestionpre.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionpre,questionnaire,lesonde,vueChoixmultiples.modrep);
			}
			else if(laquestionpre.getIdTypeQuestion() =='u'){
				this.s.afficherUnique(laquestionpre,questionnaire,lesonde,vueChoixmultiples.modrep);

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
		
		else if (Integer.parseInt(((JButton)e.getSource()).getText())<listeQuest.size()-1){
			
			this.laquestionsuiv=vueChoixmultiples.modrep.listeQuestion.get(Integer.parseInt(((JButton)e.getSource()).getText())+1);
			
			vueChoixmultiples.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueChoixmultiples.quest.getNumeroQuestion(),  val);
			if (laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);
			}
			else if(laquestionsuiv.getIdTypeQuestion() =='u'){
				this.s.afficherUnique(laquestionsuiv,questionnaire,lesonde,vueChoixmultiples.modrep);

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
