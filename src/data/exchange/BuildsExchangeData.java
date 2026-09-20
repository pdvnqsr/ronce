package data.exchange;

import java.util.ArrayList;

import data.elements.JoueurStar;

public class BuildsExchangeData {

	private ArrayList<JoueurStar> builds;
	
	public BuildsExchangeData() {
		builds = new ArrayList<JoueurStar>();
	}

	public ArrayList<JoueurStar> getBuilds() {
		return builds;
	}

	public void setBuilds(ArrayList<JoueurStar> builds) {
		this.builds = builds;
	}
}
