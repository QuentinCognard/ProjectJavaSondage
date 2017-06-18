package BaseDeDonnees;

import java.sql.*;

/**
 * BDConnexionMySQL va nous permettre de se connecter a la base de données de l'application
 * @author nathan
 *
 */
public class BDConnexionMySQL {
	/**
	 * La connexion mysql 
	 */
	Connection mysql = null;
	/**
	 * Le boolean qui va nous indiquer si la connection est realisée
	 */
	boolean connecte = false;
	/**
	 * 
	 * @param nomServeur
	 * 				Le nom du serveur utilisé
	 * @param nomBase
	 * 				Le nom de notre base de données
	 * @param nomLogin
	 * 				Login utilisé pour se connecter à la base de données
	 * @param motDePasse
	 * 				Mot de passe utilisé pour se connecter à la base de données
	 */
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
