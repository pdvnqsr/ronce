package data;

import data.properties.DataProperties;

public class Tenue {

	private int maillot;
	private int col;
	private int maillotCouleur1;
	private int maillotCouleur2;
	private int maillotCouleur3;
	private int maillotCouleur4;
	private int shortModele;
	private int shortMarques;
	private int shortCouleur1;
	private int shortCouleur2;
	private int shortCouleur3;
	private int shortCouleur4;
	private int chaussettes;
	private int chaussettesCouleur1;
	private int chaussettesCouleur2;
	private int chaussettesCouleur3;
	private int chaussettesCouleur4;
	private int police;
	private int policeBordure;
	private int policeCouleur1;
	private int policeCouleur2;
	private int policeCouleur3;
	private int policeCouleur4;
	private int brassardCouleur;
	
	public Tenue() {
		maillot = DataProperties.EQUIPE_MAILLOT.getDefaut();
		col = DataProperties.EQUIPE_COL.getDefaut();
		maillotCouleur1 = DataProperties.EQUIPE_MAILLOTCOULEUR1.getDefaut();
		maillotCouleur2 = DataProperties.EQUIPE_MAILLOTCOULEUR2.getDefaut();
		maillotCouleur3 = DataProperties.EQUIPE_MAILLOTCOULEUR3.getDefaut();
		maillotCouleur4 = DataProperties.EQUIPE_MAILLOTCOULEUR4.getDefaut();
		shortModele = DataProperties.EQUIPE_SHORT.getDefaut();
		shortMarques = DataProperties.EQUIPE_SHORTMARQUES.getDefaut();
		shortCouleur1 = DataProperties.EQUIPE_SHORTCOULEUR1.getDefaut();
		shortCouleur2 = DataProperties.EQUIPE_SHORTCOULEUR2.getDefaut();
		shortCouleur3 = DataProperties.EQUIPE_SHORTCOULEUR3.getDefaut();
		shortCouleur4 = DataProperties.EQUIPE_SHORTCOULEUR4.getDefaut();
		chaussettes = DataProperties.EQUIPE_CHAUSSETTES.getDefaut();
		chaussettesCouleur1 = DataProperties.EQUIPE_CHAUSSETTESCOULEUR1.getDefaut();
		chaussettesCouleur2 = DataProperties.EQUIPE_CHAUSSETTESCOULEUR2.getDefaut();
		chaussettesCouleur3 = DataProperties.EQUIPE_CHAUSSETTESCOULEUR3.getDefaut();
		chaussettesCouleur4 = DataProperties.EQUIPE_CHAUSSETTESCOULEUR4.getDefaut();
		police = DataProperties.EQUIPE_POLICE.getDefaut();
		policeBordure = DataProperties.EQUIPE_POLICEBORDURE.getDefaut();
		policeCouleur1 = DataProperties.EQUIPE_POLICECOULEUR1.getDefaut();
		policeCouleur2 = DataProperties.EQUIPE_POLICECOULEUR2.getDefaut();
		policeCouleur3 = DataProperties.EQUIPE_POLICECOULEUR3.getDefaut();
		policeCouleur4 = DataProperties.EQUIPE_POLICECOULEUR4.getDefaut();
		brassardCouleur = DataProperties.EQUIPE_BRASSARDCOULEUR.getDefaut();
	}

	public int getMaillot() {
		return maillot;
	}

	public void setMaillot(int maillot) {
		this.maillot = maillot;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getMaillotCouleur1() {
		return maillotCouleur1;
	}

	public void setMaillotCouleur1(int maillotCouleur1) {
		this.maillotCouleur1 = maillotCouleur1;
	}

	public int getMaillotCouleur2() {
		return maillotCouleur2;
	}

	public void setMaillotCouleur2(int maillotCouleur2) {
		this.maillotCouleur2 = maillotCouleur2;
	}

	public int getMaillotCouleur3() {
		return maillotCouleur3;
	}

	public void setMaillotCouleur3(int maillotCouleur3) {
		this.maillotCouleur3 = maillotCouleur3;
	}

	public int getMaillotCouleur4() {
		return maillotCouleur4;
	}

	public void setMaillotCouleur4(int maillotCouleur4) {
		this.maillotCouleur4 = maillotCouleur4;
	}

	public int getShortModele() {
		return shortModele;
	}

	public void setShortModele(int shortModele) {
		this.shortModele = shortModele;
	}

	public int getShortMarques() {
		return shortMarques;
	}

	public void setShortMarques(int shortMarques) {
		this.shortMarques = shortMarques;
	}

	public int getShortCouleur1() {
		return shortCouleur1;
	}

	public void setShortCouleur1(int shortCouleur1) {
		this.shortCouleur1 = shortCouleur1;
	}

	public int getShortCouleur2() {
		return shortCouleur2;
	}

	public void setShortCouleur2(int shortCouleur2) {
		this.shortCouleur2 = shortCouleur2;
	}

	public int getShortCouleur3() {
		return shortCouleur3;
	}

	public void setShortCouleur3(int shortCouleur3) {
		this.shortCouleur3 = shortCouleur3;
	}

	public int getShortCouleur4() {
		return shortCouleur4;
	}

	public void setShortCouleur4(int shortCouleur4) {
		this.shortCouleur4 = shortCouleur4;
	}

	public int getChaussettes() {
		return chaussettes;
	}

	public void setChaussettes(int chaussettes) {
		this.chaussettes = chaussettes;
	}

	public int getChaussettesCouleur1() {
		return chaussettesCouleur1;
	}

	public void setChaussettesCouleur1(int chaussettesCouleur1) {
		this.chaussettesCouleur1 = chaussettesCouleur1;
	}

	public int getChaussettesCouleur2() {
		return chaussettesCouleur2;
	}

	public void setChaussettesCouleur2(int chaussettesCouleur2) {
		this.chaussettesCouleur2 = chaussettesCouleur2;
	}

	public int getChaussettesCouleur3() {
		return chaussettesCouleur3;
	}

	public void setChaussettesCouleur3(int chaussettesCouleur3) {
		this.chaussettesCouleur3 = chaussettesCouleur3;
	}

	public int getChaussettesCouleur4() {
		return chaussettesCouleur4;
	}

	public void setChaussettesCouleur4(int chaussettesCouleur4) {
		this.chaussettesCouleur4 = chaussettesCouleur4;
	}

	public int getPolice() {
		return police;
	}

	public void setPolice(int police) {
		this.police = police;
	}

	public int getPoliceBordure() {
		return policeBordure;
	}

	public void setPoliceBordure(int policeBordure) {
		this.policeBordure = policeBordure;
	}

	public int getPoliceCouleur1() {
		return policeCouleur1;
	}

	public void setPoliceCouleur1(int policeCouleur1) {
		this.policeCouleur1 = policeCouleur1;
	}

	public int getPoliceCouleur2() {
		return policeCouleur2;
	}

	public void setPoliceCouleur2(int policeCouleur2) {
		this.policeCouleur2 = policeCouleur2;
	}

	public int getPoliceCouleur3() {
		return policeCouleur3;
	}

	public void setPoliceCouleur3(int policeCouleur3) {
		this.policeCouleur3 = policeCouleur3;
	}

	public int getPoliceCouleur4() {
		return policeCouleur4;
	}

	public void setPoliceCouleur4(int policeCouleur4) {
		this.policeCouleur4 = policeCouleur4;
	}

	public int getBrassardCouleur() {
		return brassardCouleur;
	}

	public void setBrassardCouleur(int brassardCouleur) {
		this.brassardCouleur = brassardCouleur;
	}
	
}
