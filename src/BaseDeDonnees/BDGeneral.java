package BaseDeDonnees;

import java.sql.*;
import java.util.ArrayList;
import BaseDeDonnees.BDConnexionMySQL;

/**
 * BDGeneral est une classe qui va regrouper les fonctions jdbc qui seront utilisées dans plusieurs modules
 * @author nathan
 *
 */
public class BDGeneral {
  /**
   * La connexion mysql
   * @see BDConnexionMySQL
   */
  BDConnexionMySQL connexion;
  /**
   * Ordres SQL
   */
  Statement st;
  /**
   * 
   * @param c
   * 		La connexion mysql
   */
  public BDGeneral (BDConnexionMySQL c) {
		this.connexion = c;
		try {
	        this.st = this.connexion.mysql.createStatement();
	    }

		catch (SQLException e) {
			
		}
	}

  /**
   * Retourne la liste de questionnaires selon l'état du questionnaire
   * @param etat
   * 	 'C' (en cours de création), 'S' (prêt pour sondeur), 'A' (prêt pour analyste)
   * @return une ArrayList de questionnaire
   */
  public ArrayList <Questionnaire> getListeQuestionnaire (char etat) {
	  ArrayList <Questionnaire> listeQu = new ArrayList <Questionnaire> ();
	  try {
		  String requete = "SELECT * FROM QUESTIONNAIRE WHERE Etat = '"+etat+"' ORDER BY idQ;";
		  ResultSet rs = this.st.executeQuery(requete);
		  while (rs.next()) {
			  Questionnaire q = new Questionnaire (rs.getInt("idQ"), rs.getString("Titre"), rs.getString("Etat").charAt(0), rs.getInt("numC"), rs.getInt("idU"), rs.getInt("idPan"));
			  listeQu.add(q);
	
		  }
		  rs.close();
		  return listeQu;
	  }

	  catch (SQLException e) {
		  return null;
	  }
  }
  /**
   * Supprime le questionnaire
   * @param identifiantQuestionnaire
   */
  public void supprimerQuestionnaire (int identifiantQuestionnaire) {
	  try {
		  String supprimerQuestionnaire = "DELETE FROM QUESTIONNAIRE WHERE idQ = "+identifiantQuestionnaire+";";
		  String supprimerQuestions = "DELETE FROM QUESTION WHERE idQ = "+identifiantQuestionnaire+";";
		  String supprimerValeursPossibles = "DELETE FROM VALPOSSIBLE WHERE idQ = "+identifiantQuestionnaire+";";
		  String supprimerReponses = "DELETE FROM REPONDRE WHERE idQ = "+identifiantQuestionnaire+";";
		  String supprimerInterroger = "DELETE FROM INTERROGER WHERE idQ = "+identifiantQuestionnaire+";";
		  this.st.executeUpdate(supprimerValeursPossibles);
		  this.st.executeUpdate(supprimerReponses);
		  this.st.executeUpdate(supprimerQuestions);
		  this.st.executeUpdate(supprimerQuestionnaire);
		  this.st.executeUpdate(supprimerInterroger);
	  }
		
	  catch (SQLException e) {    
		  
	  }
	}
	

  
  /**
   * Retourne le client selon l'identifiant du questionnaire
   * @param idQuestionnaire
   * @return le Client du questionnaire
   * @see Client
   */
  public Client getClientDuQuestionnaireX (int idQuestionnaire) {
      try {
        String requete = "SELECT * FROM CLIENT WHERE numC = (SELECT numC FROM QUESTIONNAIRE WHERE idQ = "+idQuestionnaire+");";
        ResultSet rs = this.st.executeQuery(requete);
        rs.next();
        return new Client (rs.getInt("numC"), rs.getString("raisonSoc"), rs.getString("adresse1"), rs.getString("adresse2") , rs.getInt("CodePostal"), rs.getString("Ville"), rs.getString("Telephone"), rs.getString("email"));
      }

      catch (SQLException e) {
        return null;
      }
  }
  /**
   * Retourne le panel selon l'identifiant du questionnaire
   * @param idQuestionnaire
   * @return le Panel du questionnaire
   * @see Panel
   */
  public Panel getPanelDuQuestionnaireX (int idQuestionnaire) {
	  try {
		  String requete = "SELECT * FROM PANEL WHERE idPan IN (SELECT idPan FROM QUESTIONNAIRE WHERE idQ = "+idQuestionnaire+");";
		  ResultSet rs = this.st.executeQuery(requete);
		  rs.next();
		  return new Panel (rs.getInt("idPan"), rs.getString("nomPan"));
	  }
	  
	  catch (SQLException e) {
		  return null;
	  }
  }
  /**
   * Retourne les questions selon l'identifiant du questionnaire
   * @param idQuestionnaire
   * @return une ArrayList de Question
   * @see Question
   */
  public ArrayList <Question> getListeQuestion (int idQuestionnaire) {
	  ArrayList <Question> listeQuestions = new ArrayList <Question> ();
	  try {
		  String requete = "SELECT * FROM QUESTION WHERE idQ = "+idQuestionnaire+" ORDER BY numQ;";
		  ResultSet rs = this.st.executeQuery(requete);
		  while (rs.next()) {
			  Question q = new Question (rs.getInt("idQ"), rs.getInt("numQ"), rs.getString("texteQ"), rs.getInt("MaxVal"), rs.getString("idT").charAt(0));
			  listeQuestions.add(q);
		  }
		  rs.close();
		  return listeQuestions;
	  }
	  
	  catch (SQLException e) {
		  return listeQuestions;
	  }
  }
 
  
  
  /**
   * Retourne les valeurs possibles d'une question d'un questionnaire
   * @param idQuestionnaire
   * @param idQuestion
   * @return une ArrayList de ValeurPossible
   * @see ValeurPossible
   */
  public ArrayList <ValeurPossible> getListeValPossible (int idQuestionnaire, int idQuestion) {
	  ArrayList <ValeurPossible> listevaleur = new ArrayList <ValeurPossible> ();
	  try {
		  String requete = "SELECT * FROM VALPOSSIBLE WHERE idQ = "+idQuestionnaire+" and numQ = "+idQuestion+" ORDER BY idV;";
		  ResultSet rs = this.st.executeQuery(requete);
		  while (rs.next()) {
			  ValeurPossible val = new ValeurPossible (rs.getInt("idQ"), rs.getInt("numQ"), rs.getInt("idV"), rs.getString("Valeur"));
			  listevaleur.add(val);
		  }
		  rs.close();
		  return listevaleur;
	  }
	  
	  catch (SQLException e) {
		  return listevaleur;
	  }
  }
  

  
  /**
   * Retourne les utilisateurs d'un role précis
   * @param roleUtilisateur
   * 		'1' pour les concepteurs, '2' pour les sondeurs, '3' pour les analystes
   * @return une ArrayList d'Utilisateur
   * @see Utilisateur
   */
  public ArrayList <Utilisateur> getListeUtilisateursSelonRole (char roleUtilisateur) {
	  ArrayList <Utilisateur> listeUsers = new ArrayList <Utilisateur> ();
	  try {
		  String requete = "SELECT * FROM UTILISATEUR WHERE idR = '"+roleUtilisateur+"' ORDER BY idU;";
		  ResultSet rs = this.st.executeQuery(requete);
		  while (rs.next()) {
			  Utilisateur u = new Utilisateur (rs.getInt("idU"), rs.getString("nomU"), rs.getString("prenomU"), rs.getString("login"), rs.getString("motDePasse"), rs.getString("idR").charAt(0));
			  listeUsers.add(u);
		  }
		  rs.close();
		  return listeUsers;
	  }
	  
	  catch (SQLException e) {
		  return null;
	  }
  }
}