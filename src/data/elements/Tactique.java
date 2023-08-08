package data.elements;

import data.properties.DataProperties;

public class Tactique {

	private int tactique;
	private int joueur1;
	private int joueur2;
	private int joueur3;
	private int joueur4;
	
	public Tactique() {
		tactique = DataProperties.EQUIPE_TACTIQUE.getDefaut();
		joueur1 = DataProperties.EQUIPE_TACTIQUEJOUEUR1.getDefaut();
		joueur2 = DataProperties.EQUIPE_TACTIQUEJOUEUR2.getDefaut();
		joueur3 = DataProperties.EQUIPE_TACTIQUEJOUEUR3.getDefaut();
		joueur4 = DataProperties.EQUIPE_TACTIQUEJOUEUR4.getDefaut();
	}

	public int getTactique() {
		return tactique;
	}

	public void setTactique(int tactique) {
		this.tactique = tactique;
	}

	public int getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(int joueur1) {
		this.joueur1 = joueur1;
	}

	public int getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(int joueur2) {
		this.joueur2 = joueur2;
	}

	public int getJoueur3() {
		return joueur3;
	}

	public void setJoueur3(int joueur3) {
		this.joueur3 = joueur3;
	}

	public int getJoueur4() {
		return joueur4;
	}

	public void setJoueur4(int joueur4) {
		this.joueur4 = joueur4;
	}


}
