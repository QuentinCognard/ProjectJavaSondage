package BaseDeDonnees;

import java.sql.*;

public class BDModuleSondeur {
	
	BDConnexionMySQL connexion;
	Statement st;
	
	public BDModuleSondeur (BDConnexionMySQL c) {
		this.connexion = c;
		
		try {
	        this.st = this.connexion.mysql.createStatement();
	    }
		
		catch (SQLException e) {	
		
		}
	}

	
	
	
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
	
	public void questionnairePretPourAnalyste (int idQuestionnaire) {
		try {
			String requete = "UPDATE QUESTIONNAIRE SET Etat = 'A' WHERE idQ = "+idQuestionnaire+";";
			this.st.executeUpdate(requete);
		}
		
		catch (SQLException e) {
			
		}
	}
}
