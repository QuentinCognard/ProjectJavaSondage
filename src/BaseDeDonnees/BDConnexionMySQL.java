package BaseDeDonnees;

import java.sql.*;

public class BDConnexionMySQL {
	Connection mysql = null;
	boolean connecte = false;

	public BDConnexionMySQL(String nomServeur, String nomBase, String nomLogin, String motDePasse) {
		
		// verifie la presence du driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			System.out.println ("Driver SQL non trouve");
			mysql = null;
			return;
		}

		// va se connecter a la base de donnees
		try {
			String url = "jdbc:mysql://" + nomServeur + ":3306/" + nomBase;
			mysql = DriverManager.getConnection (url, nomLogin, motDePasse);
			connecte = true;
		}

		catch (SQLException e) {
			System.out.println("Echec de connexion");
			System.out.println(e.getMessage());
			mysql = null;
			return;
		}
	}


}
