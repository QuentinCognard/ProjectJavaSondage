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

}
