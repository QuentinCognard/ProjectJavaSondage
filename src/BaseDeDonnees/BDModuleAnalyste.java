package BaseDeDonnees;

import java.sql.*;
import java.util.ArrayList;
/**
 * BDModuleAnalyste est une classe qui va regrouper les fonctions jdbc qui seront utilisées dans le module analyste
 * @author nathan
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
				Repondre r = new Repondre (rs.getInt("idQ"), rs.getInt("numQ"), rs.getString("idC").charAt(0),rs.getString("valeur"));
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


}