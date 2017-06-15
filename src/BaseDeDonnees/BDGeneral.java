package BaseDeDonnees;

import java.sql.*;
import java.util.ArrayList;

public class BDGeneral {

  BDConnexionMySQL connexion;
  Statement st;
  
  public BDGeneral (BDConnexionMySQL c) {
		this.connexion = c;
		try {
	        this.st = this.connexion.mysql.createStatement();
	    }

		catch (SQLException e) {
			
		}
	}

  // 'C' pour les concepteurs
  // 'S' pour les sondeurs
  // 'A' pour les analystes
  public ArrayList <Questionnaire> getListeQuestionnaire (char etat) {
	  ArrayList <Questionnaire> listeQu = new ArrayList <Questionnaire> ();
	  try {
		  String requete = "SELECT * FROM QUESTIONNAIRE WHERE Etat = '"+etat+"';";
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
	
  public ArrayList <Question> getListeQuestion (int idQuestionnaire) {
	  ArrayList <Question> listeQuestions = new ArrayList <Question> ();
	  try {
		  String requete = "SELECT * FROM QUESTION WHERE idQ = "+idQuestionnaire+";";
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

  

}