package BaseDeDonnees;

public class Client {
	private int numeroClient;
	private String raisonSociale;
	private String adresse1;
	private String adresse2;
	private int codePostal;
	private String ville;
	private String numeroTelephone;
	private String email;
	
	public Client (int nc, String rs, String a1, String a2, int cp, String v, String tel, String em ) {
		this.numeroClient = nc;
		this.raisonSociale = rs;
		this.adresse1 = a1;
		this.adresse2 = a2;
		this.codePostal = cp;
		this.ville = v;
		this.numeroTelephone = tel;
		this.email = em;
	}

	public int getNumeroClient() {
		return numeroClient;
	}

	public void setNumeroClient(int numeroClient) {
		this.numeroClient = numeroClient;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getAdresse1() {
		return adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
