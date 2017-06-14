package BaseDeDonnees;

import java.sql.*;

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
	
}