package BaseDeDonnees;

import java.sql.Date;

public class Sonde {
	private int numeroSonde;
	private String nomSonde;
	private String prenomSonde;
	private Date dateNaissanceSonde;
	private String telephoneSonde;
	private String identifiantCaracteristique;
	
	public Sonde (int nums, String noms, String ps, Date ddns, String ts, String idc) {
		this.numeroSonde = nums;
		this.nomSonde = noms;
		this.prenomSonde = ps;
		this.dateNaissanceSonde = ddns;
		this.telephoneSonde = ts;
		this.identifiantCaracteristique = idc;
	}

	public int getNumeroSonde() {
		return numeroSonde;
	}

	public String getNomSonde() {
		return nomSonde;
	}

	public String getPrenomSonde() {
		return prenomSonde;
	}

	public Date getDateNaissanceSonde() {
		return dateNaissanceSonde;
	}

	public String getTelephoneSonde() {
		return telephoneSonde;
	}

	public String getIdentifiantCaracteristique() {
		return identifiantCaracteristique;
	}
	
	
}
