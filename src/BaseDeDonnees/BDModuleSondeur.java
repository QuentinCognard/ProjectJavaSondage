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
	
}
