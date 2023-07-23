package data;

import java.util.ArrayList;

public class ExchangeData {

	private ArrayList<Joueur> joueurs;
	
	public ExchangeData() {
		joueurs = new ArrayList<Joueur>();
	}

	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
}
