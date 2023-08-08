package data.elements;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import data.properties.DataProperties;

public class Composition {

	private String id;
	private String description;
	private String nom;
	
	private int formation;
	private int capitaine;
	private int tireurCorner;
	
	private Tactique[] tactiques;
	
	private String[] joueurs;
	private int[] numeros;
	
	private int[] placementY;
	private int[] placementX;
	
	public Composition(boolean withId){
		if(withId) {
			id = regenerateId();
		}
		nom = DataProperties.EQUIPE_NOM.getDefaut();
		
		formation = DataProperties.EQUIPE_FORMATION.getDefaut();
		capitaine = DataProperties.EQUIPE_CAPITAINE.getDefaut();
		tireurCorner = DataProperties.EQUIPE_TIREURCORNER.getDefaut();
		
		tactiques = new Tactique[4];
		tactiques[0] = new Tactique();
		tactiques[1] = new Tactique();
		tactiques[2] = new Tactique();
		tactiques[3] = new Tactique();
		
		joueurs = new String[DataProperties.EQUIPE_JOUEURS.getOffsets().length];
		numeros = new int[DataProperties.EQUIPE_NUMEROS.getOffsets().length];
		
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
	
	public void update(Composition e) {
		this.id = e.getId();
		this.description = e.getDescription();
		this.nom = e.getNom();
		this.tactiques = e.getTactiques();
		this.joueurs = e.getJoueurs();
		this.numeros = e.getNumeros();
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
		result = prime * result + Objects.hash(capitaine, formation, nom, tireurCorner);
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
		Composition other = (Composition) obj;
		return capitaine == other.capitaine && formation == other.formation && Arrays.equals(joueurs, other.joueurs)
				&& Objects.equals(nom, other.nom) && Arrays.equals(numeros, other.numeros)
				&& Arrays.equals(placementX, other.placementX) && Arrays.equals(placementY, other.placementY)
				&& Arrays.equals(tactiques, other.tactiques) && tireurCorner == other.tireurCorner;
	}

	@Override
	public String toString() {
		return nom;
	}
}
