package data;

import data.properties.DataProperties;

public class Equipe {

	private String nom;
	private String abreviation;
	
	private int fond;
	private int motifFond;
	private int couleurFond1;
	private int couleurFond2;
	private int couleurFond3;
	private int couleurFond4;
	private int milieu;
	private int couleurMilieu1;
	private int couleurMilieu2;
	private int cote;
	private int couleurCote1;
	private int couleurCote2;
	private int haut;
	private int couleurHaut1;
	private int couleurHaut2;
	private int bas;
	private int couleurBas1;
	private int couleurBas2;
	private int[] triPieces;
	
	private Tenue[] tenues;
	
	public Equipe(){
		nom = DataProperties.EQUIPE_NOM.getDefaut();
		abreviation = DataProperties.EQUIPE_ABREVIATION.getDefaut();
		fond = DataProperties.EQUIPE_FOND.getDefaut();
		motifFond = DataProperties.EQUIPE_MOTIFFOND.getDefaut();
		couleurFond1 = DataProperties.EQUIPE_COULEURFOND1.getDefaut();
		couleurFond2 = DataProperties.EQUIPE_COULEURFOND2.getDefaut();
		couleurFond3 = DataProperties.EQUIPE_COULEURFOND3.getDefaut();
		couleurFond4 = DataProperties.EQUIPE_COULEURFOND4.getDefaut();
		milieu = DataProperties.EQUIPE_MILIEU.getDefaut();
		couleurMilieu1 = DataProperties.EQUIPE_COULEURMILIEU1.getDefaut();
		couleurMilieu2 = DataProperties.EQUIPE_COULEURMILIEU2.getDefaut();
		cote = DataProperties.EQUIPE_COTE.getDefaut();
		couleurCote1 = DataProperties.EQUIPE_COULEURMILIEU1.getDefaut();
		couleurCote2 = DataProperties.EQUIPE_COULEURMILIEU2.getDefaut();
		haut = DataProperties.EQUIPE_BAS.getDefaut();
		couleurHaut1 = DataProperties.EQUIPE_COULEURHAUT1.getDefaut();
		couleurHaut2 = DataProperties.EQUIPE_COULEURHAUT2.getDefaut();
		bas = DataProperties.EQUIPE_BAS.getDefaut();
		couleurBas1 = DataProperties.EQUIPE_COULEURBAS1.getDefaut();
		couleurBas2 = DataProperties.EQUIPE_COULEURBAS2.getDefaut();
		triPieces = DataProperties.EQUIPE_TRIPIECES.getDefaut();
		
		tenues = new Tenue[4];
		tenues[0] = new Tenue();
		tenues[1] = new Tenue();
		tenues[2] = new Tenue();
		tenues[3] = new Tenue();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	public int getFond() {
		return fond;
	}

	public void setFond(int fond) {
		this.fond = fond;
	}

	public int getMotifFond() {
		return motifFond;
	}

	public void setMotifFond(int motifFond) {
		this.motifFond = motifFond;
	}

	public int getCouleurFond1() {
		return couleurFond1;
	}

	public void setCouleurFond1(int couleurFond1) {
		this.couleurFond1 = couleurFond1;
	}

	public int getCouleurFond2() {
		return couleurFond2;
	}

	public void setCouleurFond2(int couleurFond2) {
		this.couleurFond2 = couleurFond2;
	}

	public int getCouleurFond3() {
		return couleurFond3;
	}

	public void setCouleurFond3(int couleurFond3) {
		this.couleurFond3 = couleurFond3;
	}

	public int getCouleurFond4() {
		return couleurFond4;
	}

	public void setCouleurFond4(int couleurFond4) {
		this.couleurFond4 = couleurFond4;
	}

	public int getMilieu() {
		return milieu;
	}

	public void setMilieu(int milieu) {
		this.milieu = milieu;
	}

	public int getCouleurMilieu1() {
		return couleurMilieu1;
	}

	public void setCouleurMilieu1(int couleurMilieu1) {
		this.couleurMilieu1 = couleurMilieu1;
	}

	public int getCouleurMilieu2() {
		return couleurMilieu2;
	}

	public void setCouleurMilieu2(int couleurMilieu2) {
		this.couleurMilieu2 = couleurMilieu2;
	}

	public int getCote() {
		return cote;
	}

	public void setCote(int cote) {
		this.cote = cote;
	}

	public int getCouleurCote1() {
		return couleurCote1;
	}

	public void setCouleurCote1(int couleurcote1) {
		this.couleurCote1 = couleurcote1;
	}

	public int getCouleurCote2() {
		return couleurCote2;
	}

	public void setCouleurCote2(int couleurCote2) {
		this.couleurCote2 = couleurCote2;
	}

	public int getHaut() {
		return haut;
	}

	public void setHaut(int haut) {
		this.haut = haut;
	}

	public int getCouleurHaut1() {
		return couleurHaut1;
	}

	public void setCouleurHaut1(int couleurHaut1) {
		this.couleurHaut1 = couleurHaut1;
	}

	public int getCouleurHaut2() {
		return couleurHaut2;
	}

	public void setCouleurHaut2(int couleurHaut2) {
		this.couleurHaut2 = couleurHaut2;
	}

	public int getBas() {
		return bas;
	}

	public void setBas(int bas) {
		this.bas = bas;
	}

	public int getCouleurBas1() {
		return couleurBas1;
	}

	public void setCouleurBas1(int couleurBas1) {
		this.couleurBas1 = couleurBas1;
	}

	public int getCouleurBas2() {
		return couleurBas2;
	}

	public void setCouleurBas2(int couleurBas2) {
		this.couleurBas2 = couleurBas2;
	}
	
	public int[] getTriPieces() {
		return triPieces;
	}

	public void setTriPieces(int[] triPieces) {
		this.triPieces = triPieces;
	}
	
	public Tenue[] getTenues() {
		return tenues;
	}

	public void setTenues(Tenue[] tenues) {
		this.tenues = tenues;
	}

	@Override
	public String toString() {
		return nom;
	}
}
