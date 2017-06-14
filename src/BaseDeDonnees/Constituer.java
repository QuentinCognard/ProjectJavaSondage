package BaseDeDonnees;

public class Constituer {
	private int numSonde;
	private int numPanel;
	
	public Constituer (int ns, int np) {
		this.numSonde = ns;
		this.numPanel = np;
	}

	public int getNumSonde() {
		return numSonde;
	}

	public void setNumSonde(int numSonde) {
		this.numSonde = numSonde;
	}

	public int getNumPanel() {
		return numPanel;
	}

	public void setNumPanel(int numPanel) {
		this.numPanel = numPanel;
	}
	
	
}
