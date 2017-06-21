package BaseDeDonnees;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * BDModuleAnalyste est une classe qui va regrouper les fonctions jdbc qui seront utilisées dans le module analyste
 * @author nathan Faure et Julien Revaud
 *
 */
public class BDModuleAnalyste {
	/**
	   * La connexion mysql
	   * @see BDConnexionMySQL
	   */
	BDConnexionMySQL connexion;
	/**
	 * Ordres mysql
	 */
	Statement st;
	/**
	 * La connexion mysql
	 * @param c
	 */
	public BDModuleAnalyste (BDConnexionMySQL c) {
		this.connexion = c;
		
		try {
	        this.st = this.connexion.mysql.createStatement();
	    }
		
		catch (SQLException e) {	
		
		}
	}
	
	
	/**
	 * Retourne la liste des reponses selon l'id du questionnaire et le numero de la question
	 * @param idQuestionnaire
	 * @param numeroQuestion
	 * @see Repondre
	 * @return une ArrayList de Repondre
	 */
	public ArrayList <Repondre> getReponsesQuestion (int idQuestionnaire, int numeroQuestion) {
		ArrayList <Repondre> listeReponses = new ArrayList <Repondre> ();
		try {
			String requete = "SELECT * FROM REPONDRE WHERE idQ = "+idQuestionnaire+" AND numQ = "+numeroQuestion+";";
			ResultSet rs = this.st.executeQuery(requete);
			while (rs.next()) {
				Repondre r = new Repondre (rs.getInt("idQ"), rs.getInt("numQ"), rs.getString("idC"),rs.getString("valeur"));
				listeReponses.add(r);
			}
			rs.close();
			return listeReponses;
		}
		
		catch (SQLException e) {
			return listeReponses;
		}
	}

	// a modifier
	public ArrayList <String> getChoixQuestionUnique (int idQuestionnaire, int numeroQuestion) {
		ArrayList <String> listeChoix = new ArrayList <String> ();
		try {
			String requete = "SELECT Valeur FROM VALPOSSIBLE WHERE idQ = "+idQuestionnaire+" AND numQ = "+numeroQuestion+";";
			ResultSet rs = this.st.executeQuery(requete);
			while (rs.next()) {
				listeChoix.add(rs.getString("Valeur"));
			}
		}
		
		catch (SQLException e) {
			
		}
		
		return listeChoix;
	}

	public ArrayList <String> getValeursReponseLibre (int idQuestionnaire, int numeroQuestion) {
		ArrayList <String> listeValeurs = new ArrayList <String> ();
		try {
			String requete = "SELECT valeur FROM REPONDRE WHERE idQ = "+idQuestionnaire+" AND numQ = "+numeroQuestion+";";
			ResultSet rs = this.st.executeQuery(requete);
			while (rs.next()) {
				listeValeurs.add(rs.getString("valeur"));
			}
		}
		
		catch (SQLException e) {
			
		}
		return listeValeurs;
	}
	
	/**
	 * Retourne la liste des categories presentes selon l'id d'un questionnaire
	 * @param idQuestionnaire
	 * @see Categorie
	 * @return une ArrayList de Categorie
	 */
	public ArrayList <Categorie> getCategoriesQuestionnaire (int idQuestionnaire) {
		ArrayList <Categorie> listeCat = new ArrayList <Categorie> ();
		try {
			String requete = "SELECT * FROM CATEGORIE WHERE idCat in (SELECT idCat FROM CARACTERISTIQUE NATURAL JOIN SONDE NATURAL JOIN INTERROGER WHERE idQ = "+idQuestionnaire+")";
			ResultSet rs = this.st.executeQuery(requete);
			while (rs.next()) {
				Categorie c = new Categorie (rs.getString("idCat").charAt(0),rs.getString("intituleCat"));
				listeCat.add(c);
			}
		}
		
		catch (SQLException e) {
			
		}
		return listeCat;
	}

	/**
	 * Retourne la liste des tranches d'ages presentes selon l'id d'un questionnaire
	 * @param idQuestionnaire
	 * @see Tranche
	 * @return une ArrayList de Tranche
	 */
	public ArrayList <Tranche> getTranchesQuestionnaire (int idQuestionnaire) {
		ArrayList <Tranche> listeTr = new ArrayList <Tranche> ();
		try {
			String requete = "SELECT * FROM TRANCHE WHERE idTr in (SELECT idTr FROM TRANCHE NATURAL JOIN SONDE NATURAL JOIN INTERROGER WHERE idQ = "+idQuestionnaire+")";
			ResultSet rs = this.st.executeQuery(requete);
			while (rs.next()) {
				Tranche t = new Tranche (rs.getString("idTr").charAt(0),rs.getInt("valDebut"), rs.getInt("valFin"));
				listeTr.add(t);
			}
		}
		
		catch (SQLException e) {
			
		}
		return listeTr;
	}
	
	/**
	 * Retourne la liste du nombre de personne aillant répondu une telle réponse et appartenant à une telle tranche
	 * @param idQuestionnaire
	 * 		id du questionnaire
	 * @param numQuest
	 * 		numéro de la question
	 * @param tr
	 * 		tranche d'age choisi
	 * @param listeRep
	 * 		la liste des réponses
	 * @return une ArrayList de int
	 */
	public ArrayList<Integer> getNbPersParReponseParTranche (int idQuestionnaire,int numQuest, Tranche tr, ArrayList<String> listeRep) {//ATTENTION : la liste des réponses contient à l'incide 0 le nom de la 1ère colonne: "Regrpmt/rep"
		ArrayList<Integer> listeNbRepParTranche = new ArrayList<Integer>();
		for (int i =0; i<listeRep.size(); i++)
		{
			try{
				String requete = "SELECT count(valeur) nb FROM REPONDRE natural join CARACTERISTIQUE natural join TRANCHE WHERE idQ = "+idQuestionnaire+" and numQ = "+numQuest+" and valeur = '"+listeRep.get(i)+"' and idTr = "+tr.getIdTranche();
				System.out.println(requete);
				ResultSet rs = this.st.executeQuery(requete);  
				rs.next();
				listeNbRepParTranche.add(rs.getInt("nb"));
			}
			catch (SQLException e){
				System.out.println("Erreur lors de l'obtention du nombre de personne par tranche d'age par reponse : " + e.getMessage());
			}
		}
			return listeNbRepParTranche;
		}
	
}