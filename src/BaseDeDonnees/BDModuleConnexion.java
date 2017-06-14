package BaseDeDonnees;

import java.sql.*;

public class BDModuleConnexion {
	
	BDConnexionMySQL connexion;
	Statement st;
	
	public BDModuleConnexion (BDConnexionMySQL c) {
		this.connexion = c;
		
		try {
	        this.st = this.connexion.mysql.createStatement();
	    }
		
		catch (SQLException e) {	
		}
	
	}
	
	public int maxIdentifiantUtilisateur () {
		try {
	        String requete = "SELECT MAX(idU) idMax FROM UTILISATEUR;";
	        ResultSet rs = this.st.executeQuery(requete);
	        rs.next();
	        return rs.getInt("idMax");
	      }
		
		catch (SQLException e) {
	         return -1;
	      }
	}
	
	public void insererUtilisateur (Utilisateur u) {
		try {
			String requete = "INSERT INTO UTILISATEUR (idU, nomU, prenomU, login, motDePasse, idR) values (?,?,?,?,?,?);";
			PreparedStatement ps = this.connexion.mysql.prepareStatement(requete);
			ps.setInt(1, u.getIdentifiantUtilisateur());
			ps.setString(2, u.getNomUtilisateur());
			ps.setString(3, u.getPrenomUtilisateur());
			ps.setString(4, u.getLoginUtilisateur());
			ps.setString(5, u.getMotdepasseUtilisateur());
			ps.setString(6, String.valueOf(u.getIdentifiantRole()));
			ps.executeUpdate();
			System.out.println("UTILISATEUR AJOUTE");
		}
		
		catch (SQLException e) {
			
		}
		
	}
	
	public Utilisateur connectionUtilisateur (String log, String mdp) {
		try {
			String requete = "SELECT * FROM UTILISATEUR WHERE login = '"+log+"' AND motDePasse = '"+mdp+"';";
			ResultSet rs = this.st.executeQuery(requete);
			rs.next();
			return new Utilisateur (rs.getInt("idU"), rs.getString("nomU"), rs.getString("prenomU"), rs.getString("login"), rs.getString("motDePasse"), rs.getString("idR").charAt(0));
		}
		
		catch (SQLException e) {
			return null;
		}
	}
	
	public boolean loginDejaExistant (String log) {
		try {
			String requete = "SELECT login FROM UTILISATEUR;";
			ResultSet rs = this.st.executeQuery(requete);
			while (rs.next()) {
				if (log.equals(rs.getString("login"))) {
					return true;
				}
			}
			rs.close();
			return false;
		}
		
		catch (SQLException e) {
			return true;
		}
	}
}
