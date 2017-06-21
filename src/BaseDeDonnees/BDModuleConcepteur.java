package BaseDeDonnees;

import java.sql.*;
/**
 * BDModuleConcepteur est une classe qui va regrouper les fonctions jdbc qui seront utilisées dans le module concepteur
 * @author nathan
 *
 */
public class BDModuleConcepteur {
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
	public BDModuleConcepteur (BDConnexionMySQL c) {
		this.connexion = c;
		
		try {
	        this.st = this.connexion.mysql.createStatement();
	    }
		
		catch (SQLException e) {	
		
		}
	}
	
	
	
	
	/**
	 * 
	 * @return L'identifiant le plus grand parmi les identifiants questionnaires
	 */
	public int maxIdentifiantQuestionnaire () {
		try {
	        String requete = "SELECT IFNULL(MAX(idQ),0) idMax FROM QUESTIONNAIRE;";
	        ResultSet rs = this.st.executeQuery(requete);
	        rs.next();
	        return rs.getInt("idMax");
	      }
		
		catch (SQLException e) {
	         return -1;
	      }
	}
	/**
	 * Insere un questionnaire q dans la base de données
	 * @param q
	 * @see Questionnaire
	 */
	public void insererQuestionnaire (Questionnaire q) {
		try {
			String requete = "INSERT INTO QUESTIONNAIRE (idQ, Titre, Etat, numC, idU, idPan) VALUES (?,?,?,?,?,?);";
			PreparedStatement ps = this.connexion.mysql.prepareStatement(requete);
			ps.setInt(1, q.getIdQuestionnaire());
			ps.setString(2, q.getTitreQuestionnaire());
			ps.setString(3, String.valueOf(q.getEtatQuestionnaire()));
			ps.setInt(4, q.getNumClient());
			ps.setInt(5, q.getIdentifiantUtilisateur());
			ps.setInt(6, q.getIdentifiantPanel());
			ps.executeUpdate();
		}

		catch (SQLException e) {
      
		}
	}
	/**
	 * Met a jour un questionnaire q dans la base de données
	 * @param q
	 * @see Questionnaire
	 */
	public void modifierQuestionnaire (Questionnaire q) {
		try {
	        String requete = "UPDATE QUESTIONNAIRE SET Titre = '"+q.getTitreQuestionnaire()+"', numC = "+q.getNumClient()+", idPan = "+q.getIdentifiantPanel()+" WHERE idQ = "+q.getIdQuestionnaire()+";";
	        this.st.executeUpdate(requete);
		}
		
		catch (SQLException e) {
			
		}
        
	}
	
	// SUPPRIMER QUESTIONNAIRE DANS BD GENERAL
	
	
	/**
	 * 
	 * @return L'identifiant le plus grand parmi les identifiants client
	 */
	public int maxIdentifiantClient () {
		try {
	        String requete = "SELECT IFNULL(MAX(numC),15008) idMax FROM CLIENT;";
	        ResultSet rs = this.st.executeQuery(requete);
	        rs.next();
	        return rs.getInt("idMax");
	      }
		
		catch (SQLException e) {
	         return 15008;
	      }
	}
	/**
	 * Insere un client c dans la base de données
	 * @param c
	 * @see Client
	 */
	public void insererClient (Client c) {
		try {
			String requete = "INSERT INTO CLIENT (numC, raisonSoc, adresse1, adresse2, CodePostal, Ville, Telephone, email) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement ps = this.connexion.mysql.prepareStatement(requete);
			ps.setInt(1, c.getNumeroClient());
			ps.setString(2, c.getRaisonSociale());
			ps.setString(3, c.getAdresse1());
			ps.setString(4, c.getAdresse2());
			ps.setInt(5, c.getCodePostal());
			ps.setString(6, c.getVille());
			ps.setString(7, c.getNumeroTelephone());
			ps.setString(8, c.getEmail());
			ps.executeUpdate();
		}
		
		catch (SQLException e) {
			
		}
	}

	
	/**
	 * 
	 * @param identifiantQuestionnaire
	 * @return L'identifiant le plus grand parmi les identifiants question
	 */
	public int maxIdentifiantQuestion (int identifiantQuestionnaire) {
		try {
	        String requete = "SELECT IFNULL(MAX(numQ),0) idMax FROM QUESTION WHERE idQ = "+identifiantQuestionnaire+";";
	        ResultSet rs = this.st.executeQuery(requete);
	        rs.next();
	        return rs.getInt("idMax");
	      }
		
		catch (SQLException e) {
	         return 0;
	      }
	}
	/**
	 * Insere une question dans la base de données
	 * @param q
	 * @see Question
	 */
	public void insererQuestion (Question q) {
		try {
			String requete = "INSERT INTO QUESTION (idQ, numQ, texteQ, MaxVal, idT) VALUES (?,?,?,?,?);";
			PreparedStatement ps = this.connexion.mysql.prepareStatement(requete);
			ps.setInt(1, q.getIdQuestionnaire());
			ps.setInt(2, q.getNumeroQuestion());
			ps.setString(3, q.getTexteQuestion());
			ps.setInt(4, q.getMaxValeur());
			ps.setString(5, String.valueOf(q.getIdTypeQuestion()));
			ps.executeUpdate();
		}

		catch (SQLException e) {

		}
	}
	
	/**
	 * Met a jour une question dans la base de données
	 * @param q
	 * @see Question
	 */
	public void modifierQuestion (Question q) {
		try {
	        String requete = "UPDATE QUESTION SET texteQ = '"+q.getTexteQuestion()+"', MaxVal = "+q.getMaxValeur()+", idT = "+q.getIdTypeQuestion()+" WHERE idQ = "+q.getIdQuestionnaire()+" AND numQ = "+q.getNumeroQuestion()+";";
	        this.st.executeUpdate(requete);
		}
		
		catch (SQLException e) {
			
		}
	}
	/**
	 * Supprime une question de la base de données
	 * @param idQuestionnaire
	 * @param numeroQuestion
	 * @see Question
	 */
	public void supprimerQuestion (int idQuestionnaire, int numeroQuestion) {
		try {
	        String requete = "DELETE FROM QUESTION WHERE idQ = "+idQuestionnaire+" AND numQ = "+numeroQuestion+";";
	        this.st.executeUpdate(requete);
		}
		
		catch (SQLException e) {
	        
	    }
	}

	
	/**
	 * 
	 * @param identifiantQuestionnaire
	 * @param numeroQuestion
	 * @return L'identifiant le plus grand parmi les identifiants valpossible
	 */
	public int maxValeurPossible (int identifiantQuestionnaire, int numeroQuestion) {
		try {
	        String requete = "SELECT IFNULL(MAX(idV),0) idMax FROM VALPOSSIBLE WHERE idQ = "+identifiantQuestionnaire+" AND numQ = "+numeroQuestion+";";
	        ResultSet rs = this.st.executeQuery(requete);
	        rs.next();
	        return rs.getInt("idMax");
	      }
		
		catch (SQLException e) {
	         return 0;
	      }
	}
	/**
	 * Insere une valeur possible vp dans la base de données
	 * @param vp
	 * @see ValeurPossible
	 */
	public void insererValeurPossible (ValeurPossible vp) {
		try {
			String requete = "INSERT INTO VALPOSSIBLE (idQ, numQ, idV, Valeur) VALUES (?,?,?,?);";
			PreparedStatement ps = this.connexion.mysql.prepareStatement("requete");
			ps.setInt(1, vp.getIdQuestionnaire());
			ps.setInt(2, vp.getNumeroQuestion());
			ps.setInt(3, vp.getIdValeur());
			ps.setString(4, vp.getValeur());
			ps.executeUpdate();
		}
		
		catch (SQLException e) {
			
		}
	}
	/**
	 * Supprime toutes les valeurs possibles d'une question d'un questionnaire
	 * @param identifiantQuestionnaire
	 * @param numeroQuestion
	 */
	public void supprimerValeursPossibles (int identifiantQuestionnaire, int numeroQuestion) {
		try {
	        String requete = "DELETE FROM VALPOSSIBLE WHERE idQ = "+identifiantQuestionnaire+" AND numQ = "+numeroQuestion+";";
	        this.st.executeUpdate(requete); 
		}
		
		catch (SQLException e) {
	        
	    }
	}
	
	/**
	 * Modifie l'etat du questionnaire ('C' en 'S') quand celui-ci est en fin de création
	 * @param idQuestionnaire
	 */
	public void questionnairePretPourSondage (int idQuestionnaire) {
		try {
			String requete = "UPDATE QUESTIONNAIRE SET Etat = 'S' WHERE idQ = "+idQuestionnaire+";";
			this.st.executeUpdate(requete);
		}
		
		catch (SQLException e) {
			
		}
	}
}
