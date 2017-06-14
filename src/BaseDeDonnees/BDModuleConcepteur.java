package BaseDeDonnees;

import java.sql.*;

public class BDModuleConcepteur {
	
	BDConnexionMySQL connexion;
	Statement st;
	
	public BDModuleConcepteur (BDConnexionMySQL c) {
		this.connexion = c;
		
		try {
	        this.st = this.connexion.mysql.createStatement();
	    }
		
		catch (SQLException e) {	
		
		}
	}
	
	public int maxIdentifiantQuestionnaire () {
		try {
	        String requete = "SELECT MAX(idQ) idMax FROM QUESTIONNAIRE;";
	        ResultSet rs = this.st.executeQuery(requete);
	        rs.next();
	        return rs.getInt("idMax");
	      }
		
		catch (SQLException e) {
	         return -1;
	      }
	}
	
	public void insererQuestionnaire (Questionnaire q) {
		try {
			String requete = "INSERT INTO QUESTIONNAIRE (idQ, Titre, Etat, numC, idU, idPan) VALUES (?,?,?,?,?,?);";
			PreparedStatement ps = this.connexion.mysql.prepareStatement(requete);
			ps.setInt(1, q.getNumeroQuestionnaire());
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
	
	public void supprimerQuestionnaire (int identifiantQuestionnaire) {
		try {
	        String requete = "DELETE FROM QUESTIONNAIRE WHERE idQ = "+identifiantQuestionnaire+";";
	        this.st.executeUpdate(requete);
		}
		
		catch (SQLException e) {
	        
	    }
	}
	
	
	
	
	
	public int maxIdentifiantClient () {
		try {
	        String requete = "SELECT MAX(numC) idMax FROM CLIENT;";
	        ResultSet rs = this.st.executeQuery(requete);
	        rs.next();
	        return rs.getInt("idMax");
	      }
		
		catch (SQLException e) {
	         return -1;
	      }
	}
	
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

	
	
	
	
	public int maxIdentifiantQuestion () {
		try {
	        String requete = "SELECT MAX(numQ) idMax FROM QUESTION;";
	        ResultSet rs = this.st.executeQuery(requete);
	        rs.next();
	        return rs.getInt("idMax");
	      }
		
		catch (SQLException e) {
	         return -1;
	      }
	}
	
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

	public void supprimerQuestion (int idQuestionnaire, int numeroQuestion) {
		try {
	        String requete = "DELETE FROM QUESTION WHERE idQ = "+idQuestionnaire+" AND numQ = "+numeroQuestion+";";
	        this.st.executeUpdate(requete);
		}
		
		catch (SQLException e) {
	        
	    }
	}

}
