package data;

import java.util.ArrayList;

public class EquipeExchangeData {

	private ArrayList<Equipe> equipes;
	private ArrayList<Joueur> joueursCustom;
	
	public EquipeExchangeData() {
		equipes = new ArrayList<Equipe>();
		joueursCustom = new ArrayList<Joueur>();
	}
	
	public ArrayList<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(ArrayList<Equipe> equipes) {
		this.equipes = equipes;
	}

	public ArrayList<Joueur> getJoueursCustom() {
		return joueursCustom;
	}

	public void setJoueursCustom(ArrayList<Joueur> joueursCustom) {
		this.joueursCustom = joueursCustom;
	}
}
