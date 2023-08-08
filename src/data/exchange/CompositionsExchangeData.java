package data.exchange;

import java.util.ArrayList;

import data.elements.Composition;
import data.elements.Joueur;

public class CompositionsExchangeData {

	private ArrayList<Composition> compositions;
	private ArrayList<Joueur> joueursCustom;
	
	public CompositionsExchangeData() {
		compositions = new ArrayList<Composition>();
		joueursCustom = new ArrayList<Joueur>();
	}
	
	public ArrayList<Composition> getCompositions() {
		return compositions;
	}

	public void setCompositions(ArrayList<Composition> compositions) {
		this.compositions = compositions;
	}

	public ArrayList<Joueur> getJoueursCustom() {
		return joueursCustom;
	}

	public void setJoueursCustom(ArrayList<Joueur> joueursCustom) {
		this.joueursCustom = joueursCustom;
	}
}
