package BaseDeDonnees;

import java.sql.*;
import java.util.ArrayList;
/**
 * BDModuleSondeur est une classe qui va regrouper les fonctions jdbc qui seront utilisées dans le module sondeur
 * @author nathan
 *
 */
public class BDModuleSondeur {
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
	public BDModuleSondeur (BDConnexionMySQL c) {
		this.connexion = c;
		
		try {
	        this.st = this.connexion.mysql.createStatement();
	    }
		
		catch (SQLException e) {	
		
		}
	}

	
	
	/**
	 * Insere une Repondre r dans la base de donnees
	 * @param r
	 * @see Repondre
	 */
	public void insererReponse (Repondre r) {
		try {
			String requete = "INSERT INTO REPONDRE (idQ, numQ, idC, valeur) VALUES (?,?,?,?);";
			PreparedStatement ps = this.connexion.mysql.prepareStatement(requete);
			ps.setInt(1, r.getIdQuestionnaire());
			ps.setInt(2, r.getNumQuestion());
			ps.setString(3, String.valueOf(r.getIdCaracteristique()));
			ps.setString(4, r.getValeur());
			ps.executeUpdate();
		}
		
		catch (SQLException e) {
			
		}
	}
	
	
	/**
	 * Recupere la liste des sondes deja interroges
	 * @param q
	 * @return une ArrayList de Sonde
	 * @see Sonde
	 */
	public ArrayList <Sonde> getListeSondesInterroges (Questionnaire q) {
		ArrayList <Sonde> listeSondes = new ArrayList <Sonde> ();
		try {
			String requete = "SELECT * FROM SONDE WHERE numSond IN (SELECT numSond FROM INTERROGER WHERE idQ = "+q.getIdQuestionnaire()+") ORDER BY numSond;";
			ResultSet rs = this.st.executeQuery(requete);
			while (rs.next()) {
				Sonde s = new Sonde (rs.getInt("numSond"), rs.getString("nomSond"), rs.getString("prenomSond"), rs.getDate("dateNaisSond"), rs.getString("telephoneSond"), rs.getString("idC"));
				listeSondes.add(s);
			}
			rs.close();
			return listeSondes;
		}
		
		catch (SQLException e) {
			return listeSondes;
		}
		
	}
	/**
	 * Recupere la liste des sondes qui n'ont pas ete interroges
	 * @param q
	 * @return une ArrayList de Sonde
	 * @see Sonde
	 */
	public ArrayList <Sonde> getListeSondesNonInterroges (Questionnaire q) {
		ArrayList <Sonde> listeSondes = new ArrayList <Sonde> ();
		try {
			String requete = "SELECT * FROM SONDE NATURAL JOIN CONSTITUER WHERE idPan = "+q.getIdentifiantPanel()+" AND numSond NOT IN (SELECT numSond FROM INTERROGER WHERE idQ = "+q.getIdQuestionnaire()+") ORDER BY numSond;";
			ResultSet rs = this.st.executeQuery(requete);
			while (rs.next()) {
				Sonde s = new Sonde (rs.getInt("numSond"), rs.getString("nomSond"), rs.getString("prenomSond"), rs.getDate("dateNaisSond"), rs.getString("telephoneSond"), rs.getString("idC"));
				listeSondes.add(s);
			}
			rs.close();
			return listeSondes;
		}
		
		catch (SQLException e) {
			return listeSondes;
		}
		
	}

	
	/**
	 * Insere dans la classe INTERROGER le fait qu'un sonde a ete interroge
	 * @param q
	 * @param s
	 */
	public void setSondeInterroger(Questionnaire q, Sonde s) {
		try {
			String requete = "INSERT INTO INTERROGER (idU, numSond, idQ) VALUES (?,?,?);";
			PreparedStatement ps = this.connexion.mysql.prepareStatement(requete);
			ps.setInt(1, q.getIdentifiantUtilisateur());
			ps.setInt(2, s.getNumeroSonde());
			ps.setInt(3, q.getIdQuestionnaire());
			ps.executeUpdate();
		}
		
		catch (SQLException e) {
			
		}
	}

	
	/**
	 * Modifie l'etat du questionnaire ('S' en 'A') quand celui-ci est en fin de sondage
	 * @param idQuestionnaire
	 */
	public void questionnairePretPourAnalyste (int idQuestionnaire) {
		try {
			String requete = "UPDATE QUESTIONNAIRE SET Etat = 'A' WHERE idQ = "+idQuestionnaire+";";
			this.st.executeUpdate(requete);
		}
		
		catch (SQLException e) {
			
		}
	}
}
