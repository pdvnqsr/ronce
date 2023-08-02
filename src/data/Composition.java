package data;

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

	public void update(Composition e) {
		this.id = e.getId();
		this.description = e.getDescription();
		this.nom = e.getNom();
		this.tactiques = e.getTactiques();
		this.joueurs = e.getJoueurs();
		this.numeros = e.getNumeros();
	}

	@Override
	public String toString() {
		return nom;
	}
	
	
}
