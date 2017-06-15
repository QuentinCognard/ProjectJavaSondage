package BaseDeDonnees;

public class Caracteristique {
	
	private char idCaracteristique;
	private char sexe;
	private char idTranche;
	private char idCategorie;
	
	public Caracteristique (char idc, char s, char idtr, char idcat) {
		this.idCaracteristique = idc;
		this.sexe = s;
		this.idTranche = idtr;
		this.idCategorie = idcat;
	}

	public char getIdCaracteristique() {
		return idCaracteristique;
	}

	public void setIdCaracteristique(char idCaracteristique) {
		this.idCaracteristique = idCaracteristique;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public char getIdTranche() {
		return idTranche;
	}

	public void setIdTranche(char idTranche) {
		this.idTranche = idTranche;
	}

	public char getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(char idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	
}
