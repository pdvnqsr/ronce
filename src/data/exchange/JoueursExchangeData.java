package data.exchange;

import java.util.ArrayList;

import data.elements.Joueur;

public class JoueursExchangeData {

	private ArrayList<Joueur> joueurs;
	
	public JoueursExchangeData() {
		joueurs = new ArrayList<Joueur>();
	}

	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
}
