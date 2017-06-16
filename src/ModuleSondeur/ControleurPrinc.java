package ModuleSondeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDeDonnees.BDGeneral;
import BaseDeDonnees.BDModuleSondeur;
import BaseDeDonnees.Question;
import BaseDeDonnees.Questionnaire;

public class ControleurPrinc implements ActionListener {
	
	private Vue_FenetrPrinc vueFenetrePrinc;
	private Questionnaire questionnaire;
	private Question laquestion;
	private BDGeneral laBD;
	private ModeleReponse modrep;
	private BDModuleSondeur bdSond;
	
	public ControleurPrinc(Vue_FenetrPrinc vueFenetrePrinc,Questionnaire questionnaire,BDGeneral laBD,BDModuleSondeur bdSond){
		super();
		this.vueFenetrePrinc=vueFenetrePrinc;
		this.bdSond=bdSond;
		this.laBD=laBD;
		this.questionnaire=questionnaire;
		this.laquestion=laBD.getListeQuestion(questionnaire.getNumeroQuestionnaire()).get(0);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		this.modrep= new ModeleReponse(laBD,bdSond,questionnaire);
		Sondeur fenetresondage=(Sondeur) vueFenetrePrinc.getRootPane().getParent();
		vueFenetrePrinc.progressBarSond.setMaximum(modrep.listeDeSondeInterroge.size()+modrep.listeDeSonde.size());
		if (laquestion.getIdTypeQuestion() =='u' || laquestion.getIdTypeQuestion() =='n'){
			vueFenetrePrinc.progressBarSond.setValue(modrep.listeDeSondeInterroge.size()+1);
			fenetresondage.afficherEchelle(laquestion,questionnaire,modrep.lesonde,modrep);
		}
		else if (laquestion.getIdTypeQuestion() =='m'){
			vueFenetrePrinc.progressBarSond.setValue(modrep.listeDeSondeInterroge.size()+1);

			fenetresondage.afficherChoixMultiples(laquestion,questionnaire,modrep.lesonde,modrep);

		}
		else if (laquestion.getIdTypeQuestion() =='c'){
			vueFenetrePrinc.progressBarSond.setValue(modrep.listeDeSondeInterroge.size()+1);

			fenetresondage.afficherClassement(laquestion,questionnaire,modrep.lesonde,modrep);

		}
		else if (laquestion.getIdTypeQuestion() =='l'){
			vueFenetrePrinc.progressBarSond.setValue(modrep.listeDeSondeInterroge.size()+1);

			fenetresondage.afficherLibre(laquestion,questionnaire,modrep.lesonde,modrep);

		}

		else if (modrep.listeDeSonde==null){
			fenetresondage.afficherPlusDeSonde();

		}
	}

}
