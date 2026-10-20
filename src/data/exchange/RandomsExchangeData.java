package data.exchange;

import java.util.ArrayList;

import data.elements.JoueurAutre;

public class RandomsExchangeData {

	private ArrayList<JoueurAutre> rendoms;
	
	public RandomsExchangeData() {
		rendoms = new ArrayList<JoueurAutre>();
	}

	public ArrayList<JoueurAutre> getRandoms() {
		return rendoms;
	}

	public void setRandom(ArrayList<JoueurAutre> rendoms) {
		this.rendoms = rendoms;
	}
}
