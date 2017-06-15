package BaseDeDonnees;

public class Tranche {
	private char idTranche;
	private int valeurDebut;
	private int valeurFin;
	
	public Tranche (char idtr, int vd, int vf) {
		this.idTranche = idtr;
		this.valeurDebut = vd;
		this.valeurFin = vf;
	}

	public char getIdTranche() {
		return idTranche;
	}

	public int getValeurDebut() {
		return valeurDebut;
	}

	public int getValeurFin() {
		return valeurFin;
	}
	
	
}
