package BaseDeDonnees;

public class Categorie {
	
	private char idCategorie;
	private String intituleCategorie;
	
	public Categorie (char idcat, String icat) {
		this.idCategorie = idcat;
		this.intituleCategorie = icat;
	}

	public char getIdCategorie() {
		return idCategorie;
	}

	public String getIntituleCategorie() {
		return intituleCategorie;
	}
	
	
}
