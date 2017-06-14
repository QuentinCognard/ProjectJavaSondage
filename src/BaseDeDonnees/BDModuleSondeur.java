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
	
	public void questionnairePretPourAnalyste (int idQuestionnaire) {
		try {
			String requete = "UPDATE QUESTIONNAIRE SET Etat = 'A' WHERE idQ = "+idQuestionnaire+";";
			this.st.executeUpdate(requete);
		}
		
		catch (SQLException e) {
			
		}
	}
}
