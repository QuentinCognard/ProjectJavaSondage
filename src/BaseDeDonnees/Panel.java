package BaseDeDonnees;

public class Panel {
	
	private int identifiantPanel;
	private String nomPanel;
	
	public Panel (int idp, String np) {
		this.identifiantPanel = idp;
		this.nomPanel = np;
	}

	public int getIdentifiantPanel() {
		return identifiantPanel;
	}

	public String getNomPanel() {
		return nomPanel;
	}
	
	
}
