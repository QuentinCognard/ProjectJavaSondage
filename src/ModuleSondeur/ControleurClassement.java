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
	private Sondeur s;

	private ArrayList<Question> listeQuest;
	
	private ArrayList<String> listeclassee;
	
	public ControleurClassement(Vue_Classement vueClassement){
		this.vueClassement=vueClassement;
		this.s=vueClassement.s;

		
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
		
		
		this.val=listeclassee.toString();
		
		if (((JButton)e.getSource()).getText().equals("Annuler sondage")){
			this.s.afficherFenetrePrinc();
		}
		
		else if (((JButton)e.getSource()).getText().equals("Valider sondage")){
			vueClassement.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueClassement.quest.getNumeroQuestion(), vueClassement.quest.getIdTypeQuestion(), val);
			vueClassement.modrep.bdsond.setSondeInterroger(questionnaire,lesonde);
			this.s.afficherFenetrePrinc();

		}
		
		else if (Integer.parseInt(((JButton)e.getSource()).getText())<listeQuest.size()){
			
			this.laquestionsuiv=vueClassement.modrep.listeQuestion.get(Integer.parseInt(((JButton)e.getSource()).getText()));
			
			vueClassement.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueClassement.quest.getNumeroQuestion(), vueClassement.quest.getIdTypeQuestion(), val);
			
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
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
		
		else if (((JButton)e.getSource()).getText().equals("Suivant")){
			vueClassement.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueClassement.quest.getNumeroQuestion(), vueClassement.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionsuiv,questionnaire,lesonde,vueClassement.modrep);
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
		
		else if (((JButton)e.getSource()).getText().equals("Pr�c�dent")){
			vueClassement.modrep.ajouterReponse(questionnaire.getNumeroQuestionnaire(),vueClassement.quest.getNumeroQuestion(), vueClassement.quest.getIdTypeQuestion(), val);
			if (laquestionsuiv.getIdTypeQuestion() =='u' || laquestionsuiv.getIdTypeQuestion() =='n'){
				this.s.afficherEchelle(laquestionpre,questionnaire,lesonde,vueClassement.modrep);
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
		
		
		else if (((JButton)e.getSource()).getText().equals("R�initialiser")){
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
