package ModuleSondeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;
import BaseDeDonnees.Sonde;

public class ControleurClassement implements ActionListener {
	private Vue_Classement vueClassement;
	private Question laquestionsuiv;
	private Question laquestionpre;
	private Sonde lesonde;
	private Questionnaire questionnaire;
	private String val;
	private int classement;
	private int idvalpos;
	
	private ArrayList<Question> listeQuest;
	
	private ArrayList<String> listeclassee;
	
	public ControleurClassement(Vue_Classement vueClassement){
		this.vueClassement=vueClassement;
		
		if (vueClassement.quest.getNumeroQuestion()<vueClassement.modrep.listeQuestion.size()){
			this.laquestionsuiv=vueClassement.modrep.listeQuestion.get(vueClassement.quest.getNumeroQuestion()+1);
		}
		
		if (vueClassement.quest.getNumeroQuestion()>0){

			this.laquestionpre=vueClassement.modrep.listeQuestion.get(vueClassement.quest.getNumeroQuestion()-1);
		}
		
		this.lesonde=vueClassement.lesonde;
		this.questionnaire=vueClassement.questnaire;
		this.listeQuest=vueClassement.modrep.bdgene.getListeQuestion(questionnaire.getNumeroQuestionnaire());

		
	}
		
	
	public void actionPerformed(ActionEvent e) {
		
		Sondeur fenetresondage=(Sondeur) vueClassement.getRootPane().getParent();
		
		this.val=listeclassee.toString();
		
		if (((JButton)e.getSource()).getText().equals("Annuler sondage")){
			fenetresondage.afficherFenetrePrinc();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Valider sondage")){
			vueClassement.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueClassement.quest.getNumeroQuestion(), vueClassement.quest.getIdTypeQuestion(), val);
			vueClassement.modrep.bdsond.setSondeInterroger(questionnaire,lesonde);
			fenetresondage.afficherFenetrePrinc();

		}
		
		else if (Integer.parseInt(((JButton)e.getSource()).getText())<listeQuest.size()){
			
			this.laquestionsuiv=vueClassement.modrep.listeQuestion.get(Integer.parseInt(((JButton)e.getSource()).getText()));
			
			vueClassement.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueClassement.quest.getNumeroQuestion(), vueClassement.quest.getIdTypeQuestion(), val);
			
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Suivant")){
			vueClassement.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueClassement.quest.getNumeroQuestion(), vueClassement.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
	
			}
			else if (laquestionsuiv.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
	
			}

		}
		
		else if (((JButton)e.getSource()).getText().equals("Précédent")){
			vueClassement.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueClassement.quest.getNumeroQuestion(), vueClassement.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				fenetresondage.afficherEchelle(laquestionpre,questionnaire,lesonde,vueClassement.modrep);
			}
			else if (laquestionpre.getIdTypeQuestion() =='m'){
				fenetresondage.afficherChoixMultiples(laquestionpre,questionnaire,lesonde,vueClassement.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='c'){
				fenetresondage.afficherClassement(laquestionpre,questionnaire,lesonde,vueClassement.modrep);
	
			}
			else if (laquestionpre.getIdTypeQuestion() =='l'){
				fenetresondage.afficherLibre(laquestionpre,questionnaire,lesonde,vueClassement.modrep);
	
			}

		}
		
		
		else if (((JButton)e.getSource()).getText().equals("Réinitialiser")){
			for (JLabel label : vueClassement.leslabelschoix){
				label.setText(": 0");
				
			}
			this.classement=0;
			this.val="";
		}
		
		else{
			listeclassee.add(((JButton)e.getSource()).getText());
			this.classement+=1;
			for (int i = 0; i<vueClassement.lesboutonschoix.length;i++){
				if (vueClassement.lesboutonschoix[i].getText()==((JButton)e.getSource()).getText()){
					this.idvalpos=i;
				}
			}
			vueClassement.leslabelschoix[idvalpos].setText(": "+String.valueOf(classement));
		}
		

	}

}
