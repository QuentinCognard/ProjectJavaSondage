package BaseDeDonnees;

import java.sql.*;
import java.util.ArrayList;

public class BDModuleAnalyste {
	
	BDConnexionMySQL connexion;
	Statement st;
	
	public BDModuleAnalyste (BDConnexionMySQL c) {
		this.connexion = c;
		
		try {
	        this.st = this.connexion.mysql.createStatement();
	    }
		
		catch (SQLException e) {	
		
		}
	}
	
	
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

	

}