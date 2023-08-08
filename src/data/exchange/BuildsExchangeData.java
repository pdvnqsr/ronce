package data.exchange;

import java.util.ArrayList;

import data.elements.Build;

public class BuildsExchangeData {

	private ArrayList<Build> builds;
	
	public BuildsExchangeData() {
		builds = new ArrayList<Build>();
	}

	public ArrayList<Build> getBuilds() {
		return builds;
	}

	public void setBuilds(ArrayList<Build> builds) {
		this.builds = builds;
	}
}
