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
	private Sondeur s;
	private int i;

	/**
 	*Controlleur général pour les vues
	*@param vueFenetrePrinc
		*La fenetre principale sur laquelle on va greffer toutes les vues
	*@param questionnaire
		*Le questionnaire selectionner pour ce sondage
	*@param laBD
		*Base de données utilisée
	*@param bdSond
		*La base de données des sondeurs
	*/
	
	public ControleurPrinc(Vue_FenetrPrinc vueFenetrePrinc,Questionnaire questionnaire,BDGeneral laBD,BDModuleSondeur bdSond){
		super();
		this.vueFenetrePrinc=vueFenetrePrinc;
		this.bdSond=bdSond;
		this.laBD=laBD;
		this.s=vueFenetrePrinc.s;
		this.questionnaire=questionnaire;
		this.laquestion=laBD.getListeQuestion(questionnaire.getIdQuestionnaire()).get(0);
		this.i=questionnaire.getIdQuestionnaire()-1;
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		this.modrep= new ModeleReponse(laBD,bdSond,questionnaire);
		vueFenetrePrinc.progressBarSond[i].setMaximum(modrep.listeDeSondeInterroge.size()+modrep.listeDeSonde.size());
		if (laquestion.getIdTypeQuestion() =='u' || laquestion.getIdTypeQuestion() =='n'){
			vueFenetrePrinc.progressBarSond[i].setValue(modrep.listeDeSondeInterroge.size()+1);
			this.s.afficherEchelle(laquestion,questionnaire,modrep.lesonde,modrep);
		}
		else if (laquestion.getIdTypeQuestion() =='m'){
			vueFenetrePrinc.progressBarSond[i].setValue(modrep.listeDeSondeInterroge.size()+1);

			this.s.afficherChoixMultiples(laquestion,questionnaire,modrep.lesonde,modrep);

		}
		else if (laquestion.getIdTypeQuestion() =='c'){
			vueFenetrePrinc.progressBarSond[i].setValue(modrep.listeDeSondeInterroge.size()+1);

			this.s.afficherClassement(laquestion,questionnaire,modrep.lesonde,modrep);

		}
		else if (laquestion.getIdTypeQuestion() =='l'){
			vueFenetrePrinc.progressBarSond[i].setValue(modrep.listeDeSondeInterroge.size()+1);

			this.s.afficherLibre(laquestion,questionnaire,modrep.lesonde,modrep);

		}

		else if (modrep.listeDeSonde==null){
			this.s.afficherPlusDeSonde();

		}
	}

}
