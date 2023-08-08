package data.properties.types;

import java.util.ArrayList;
import java.util.Properties;

import data.properties.mappings.JoueurMapping;

public class IncrementalData {

	private long adresse;
	private int increment;
	private int nombre;
	private ArrayList<JoueurMapping> vals;
	
	public IncrementalData(Properties props, String key) {
		super();
		this.adresse = Long.parseLong(props.getProperty(key+".address"), 16);
		this.increment = Integer.parseInt(props.getProperty(key+".increment"));
		this.nombre = Integer.parseInt(props.getProperty(key+".nombre"));
		this.vals = new ArrayList<JoueurMapping>();
		boolean go = true;
		int i=0;
		
		String valsKey = key;
		if(props.containsKey(key+".vals")) {
			valsKey = props.getProperty(valsKey+".vals");
		}
		
		String[] valContent;
		while(go) {
			valContent = props.getProperty(valsKey+".vals."+i).split(":");
			this.vals.add(new JoueurMapping(valContent[0], valContent[1]));
			i++;
			go = props.containsKey(valsKey+".vals."+i);
		}
	}

	public int getIndexFromInGameValue(String value, int defaut) {
		int index = defaut;
		JoueurMapping jm;
		for(int i=0;i<vals.size();i++) {
			jm = vals.get(i);
			if(jm.getInGameValue().equals(value)) {
				index = i;
			}
		}
		return index;
	}
	
	public Long getAdresse(int i) {
		return adresse + (i * increment);
	}
	
	public int getNombre() {
		return nombre;
	}

	public ArrayList<JoueurMapping> getVals() {
		return vals;
	}

	public void setVals(ArrayList<JoueurMapping> vals) {
		this.vals = vals;
	}
}
