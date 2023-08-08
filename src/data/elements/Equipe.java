package data.elements;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import data.properties.DataProperties;

public class Equipe {

	private String id;
	private String description;
	
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
	
	private int formation;
	private int capitaine;
	private int tireurCorner;
	
	private Tactique[] tactiques;
	
	private String[] joueurs;
	private int[] numeros;
	private int[] placementY;
	private int[] placementX;
	
	public Equipe(boolean withId){
		if(withId) {
			id = regenerateId();
		}
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
		
		formation = DataProperties.EQUIPE_FORMATION.getDefaut();
		capitaine = DataProperties.EQUIPE_CAPITAINE.getDefaut();
		tireurCorner = DataProperties.EQUIPE_TIREURCORNER.getDefaut();
		
		tactiques = new Tactique[4];
		tactiques[0] = new Tactique();
		tactiques[1] = new Tactique();
		tactiques[2] = new Tactique();
		tactiques[3] = new Tactique();
		
		joueurs = new String[DataProperties.EQUIPE_JOUEURS.getOffsets().length];
		for(int i=0;i<joueurs.length;i++) {
			joueurs[i] = DataProperties.EQUIPE_JOUEURSDEFAUT[i];
		}
		numeros = new int[DataProperties.EQUIPE_NUMEROS.getOffsets().length];
		for(int i=0;i<numeros.length;i++) {
			numeros[i] = i;
		}
		
		placementY = new int[DataProperties.EQUIPE_PLACEMENTY.getOffsets().length];
		Arrays.fill(placementY, DataProperties.EQUIPE_PLACEMENTY.getDefaut());
		placementX = new int[DataProperties.EQUIPE_PLACEMENTX.getOffsets().length];
		Arrays.fill(placementX, DataProperties.EQUIPE_PLACEMENTX.getDefaut());
	}

	public String regenerateId() {
		return "E:" + UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	public int getFormation() {
		return formation;
	}

	public void setFormation(int formation) {
		this.formation = formation;
	}

	public int getCapitaine() {
		return capitaine;
	}

	public void setCapitaine(int capitaine) {
		this.capitaine = capitaine;
	}

	public int getTireurCorner() {
		return tireurCorner;
	}

	public void setTireurCorner(int tireurCorner) {
		this.tireurCorner = tireurCorner;
	}
	
	public Tactique[] getTactiques() {
		if(tactiques == null) {
			tactiques = new Tactique[4];
			tactiques[0] = new Tactique();
			tactiques[1] = new Tactique();
			tactiques[2] = new Tactique();
			tactiques[3] = new Tactique();
		}
		return tactiques;
	}

	public void setTactiques(Tactique[] tactiques) {
		this.tactiques = tactiques;
	}

	public String[] getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(String[] joueurs) {
		this.joueurs = joueurs;
	}

	public int[] getNumeros() {
		return numeros;
	}

	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}
	
	public int[] getPlacementY() {
		if(placementY == null) {
			placementY = new int[DataProperties.EQUIPE_PLACEMENTY.getOffsets().length];
			Arrays.fill(placementY, DataProperties.EQUIPE_PLACEMENTY.getDefaut());
		}
		return placementY;
	}

	public void setPlacementY(int[] placementY) {
		this.placementY = placementY;
	}

	public int[] getPlacementX() {
		if(placementX == null) {
			placementX = new int[DataProperties.EQUIPE_PLACEMENTX.getOffsets().length];
			Arrays.fill(placementX, DataProperties.EQUIPE_PLACEMENTX.getDefaut());
		}
		return placementX;
	}

	public void setPlacementX(int[] placementX) {
		this.placementX = placementX;
	}

	public void update(Equipe e) {
		this.id = e.getId();
		this.description = e.getDescription();
		this.nom = e.getNom();
		this.abreviation = e.getAbreviation();
		this.fond = e.getFond();
		this.motifFond = e.getMotifFond();
		this.couleurFond1 = e.getCouleurFond1();
		this.couleurFond2 = e.getCouleurFond2();
		this.couleurFond3 = e.getCouleurFond3();
		this.couleurFond4 = e.getCouleurFond4();
		this.milieu = e.getMilieu();
		this.couleurMilieu1 = e.getCouleurMilieu1();
		this.couleurMilieu2 = e.getCouleurMilieu2();
		this.cote = e.getCote();
		this.couleurCote1 = e.getCouleurCote1();
		this.couleurCote2 = e.getCouleurCote2();
		this.haut = e.getHaut();
		this.couleurHaut1 = e.getCouleurHaut1();
		this.couleurHaut2 = e.getCouleurHaut2();
		this.bas = e.getBas();
		this.couleurBas1 = e.getCouleurBas1();
		this.couleurBas2 = e.getCouleurBas2();
		this.triPieces = Arrays.copyOf(e.getTriPieces(), e.getTriPieces().length);
		this.tenues = Arrays.copyOf(e.getTenues(), e.getTenues().length);
		this.tactiques = Arrays.copyOf(e.getTactiques(), e.getTactiques().length);
		this.joueurs = Arrays.copyOf(e.getJoueurs(), e.getJoueurs().length);
		this.numeros = Arrays.copyOf(e.getNumeros(), e.getNumeros().length);
		this.placementY = Arrays.copyOf(e.getPlacementY(), e.getPlacementY().length);
		this.placementX = Arrays.copyOf(e.getPlacementX(), e.getPlacementX().length);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(joueurs);
		result = prime * result + Arrays.hashCode(numeros);
		result = prime * result + Arrays.hashCode(placementX);
		result = prime * result + Arrays.hashCode(placementY);
		result = prime * result + Arrays.hashCode(tactiques);
		result = prime * result + Arrays.hashCode(tenues);
		result = prime * result + Arrays.hashCode(triPieces);
		result = prime * result
				+ Objects.hash(abreviation, bas, capitaine, cote, couleurBas1, couleurBas2, couleurCote1, couleurCote2,
						couleurFond1, couleurFond2, couleurFond3, couleurFond4, couleurHaut1, couleurHaut2,
						couleurMilieu1, couleurMilieu2, fond, formation, haut, milieu, motifFond, nom, tireurCorner);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipe other = (Equipe) obj;
		return Objects.equals(abreviation, other.abreviation) && bas == other.bas && capitaine == other.capitaine
				&& cote == other.cote && couleurBas1 == other.couleurBas1 && couleurBas2 == other.couleurBas2
				&& couleurCote1 == other.couleurCote1 && couleurCote2 == other.couleurCote2
				&& couleurFond1 == other.couleurFond1 && couleurFond2 == other.couleurFond2
				&& couleurFond3 == other.couleurFond3 && couleurFond4 == other.couleurFond4
				&& couleurHaut1 == other.couleurHaut1 && couleurHaut2 == other.couleurHaut2
				&& couleurMilieu1 == other.couleurMilieu1 && couleurMilieu2 == other.couleurMilieu2
				&& fond == other.fond && formation == other.formation && haut == other.haut
				&& Arrays.equals(joueurs, other.joueurs) && milieu == other.milieu && motifFond == other.motifFond
				&& Objects.equals(nom, other.nom) && Arrays.equals(numeros, other.numeros)
				&& Arrays.equals(placementX, other.placementX) && Arrays.equals(placementY, other.placementY)
				&& Arrays.equals(tactiques, other.tactiques) && Arrays.equals(tenues, other.tenues)
				&& tireurCorner == other.tireurCorner && Arrays.equals(triPieces, other.triPieces);
	}

	@Override
	public String toString() {
		return nom;
	}
}
