package ModuleSondeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Sonde;
import BaseDeDonnees.ValeurPossible;

public class ControleurClassement implements ActionListener {
	private Vue_Classement vueClassement;
	private Question laquestionsuiv;
	private Question laquestionpre;
	private Sonde lesonde;
	private Questionnaire questionnaire;
	private String val;
	private int idvalpos;
	private Sondeur s;

	private ArrayList<Question> listeQuest;
	
	private ArrayList<String> listeclassee;
	/**
 	*Controlleur pour la vue Classement
	*@param vueClassement
		*La vue que l'on va utiliser pour ce controleur
	*/	
	public ControleurClassement(Vue_Classement vueClassement){
		this.vueClassement=vueClassement;
		this.s=vueClassement.s;

		
		if (vueClassement.quest.getNumeroQuestion()<vueClassement.modrep.listeQuestion.size()){
			this.laquestionsuiv=vueClassement.modrep.listeQuestion.get(vueClassement.quest.getNumeroQuestion());
		}
		
		if (vueClassement.quest.getNumeroQuestion()>0){

			this.laquestionpre=vueClassement.modrep.listeQuestion.get(vueClassement.quest.getNumeroQuestion()-2);
		}
		
		this.lesonde=vueClassement.lesonde;
		this.questionnaire=vueClassement.questnaire;
		this.listeQuest=vueClassement.modrep.bdgene.getListeQuestion(questionnaire.getIdQuestionnaire());
		this.listeclassee=vueClassement.listeclasse;
		
	}
		
	
	public void actionPerformed(ActionEvent e) {
		
		if (listeclassee!=null){
			this.val=listeclassee.toString();
			this.val=this.val.replace(',',';');
			
		}

		if (((JButton)e.getSource()).getText().equals("Annuler sondage")){
			this.s.afficherFenetrePrinc();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Valider sondage")){
			vueClassement.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueClassement.quest.getNumeroQuestion(), val);
			vueClassement.modrep.validerQuestionnaire();
			vueClassement.modrep.bdsond.setSondeInterroger(questionnaire,lesonde);
			this.s.afficherFenetrePrinc();

		}
		
		
		else if (((JButton)e.getSource()).getText().equals("Suivant")){
			vueClassement.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueClassement.quest.getNumeroQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
			}
			else if(laquestionsuiv.getIdTypeQuestion() =='u'){
				this.s.afficherUnique(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);

			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Precedent")){
			if (laquestionpre.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionpre,questionnaire,lesonde,vueClassement.modrep);
			}
			else if(laquestionpre.getIdTypeQuestion() =='u'){
				this.s.afficherUnique(laquestionpre,questionnaire,lesonde,vueClassement.modrep);

			}
			else if (laquestionpre.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionpre,questionnaire,lesonde,vueClassement.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionpre,questionnaire,lesonde,vueClassement.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionpre,questionnaire,lesonde,vueClassement.modrep);
	
			}

		}
		
		
		
		else if (((JButton)e.getSource()).getText().equals("Reinitialiser")){
			for (JLabel label : vueClassement.leslabelschoix){
				label.setText(": 0");
				
			}
			this.listeclassee= new ArrayList<String>();
			vueClassement.classement=0;
			this.val="";
		}
		
		else if (((JButton)e.getSource()).getText().length()>1){
			for (ValeurPossible valpos : vueClassement.valeursPossibles){
				if (valpos.getValeur()==((JButton)e.getSource()).getText()){
					listeclassee.add(String.valueOf(valpos.getIdValeur()));
				}
			}
			vueClassement.classement+=1;
			for (int i = 0; i<vueClassement.lesboutonschoix.length;i++){
				if (vueClassement.lesboutonschoix[i].getText()==((JButton)e.getSource()).getText()){
					this.idvalpos=i;
				}
			}
			vueClassement.leslabelschoix[idvalpos].setText(": "+String.valueOf(vueClassement.classement));
		}
		
		else if (Integer.parseInt(((JButton)e.getSource()).getText())<listeQuest.size()+1){
			
			this.laquestionsuiv=vueClassement.modrep.listeQuestion.get(Integer.parseInt(((JButton)e.getSource()).getText())-1);
			
			vueClassement.modrep.ajouterReponse(questionnaire.getIdQuestionnaire(),vueClassement.quest.getNumeroQuestion(),  val);
			if (laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
			}
			else if(laquestionsuiv.getIdTypeQuestion() =='u'){
				this.s.afficherUnique(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);

			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				this.s.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				this.s.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				this.s.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
	
			}

		}
		

	}

}
