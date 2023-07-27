package data.properties;

import java.util.ArrayList;
import java.util.Properties;

public class SideData {

	private ArrayList<Integer> vals;
	
	public SideData(Properties props, String key) {
		super();
		this.vals = new ArrayList<Integer>();
		boolean go = true;
		int i=0;
		while(go) {
			this.vals.add(Integer.parseInt(props.getProperty(key+".vals."+i)));
			i++;
			go = props.containsKey(key+".vals."+i);
		}
	}

	public ArrayList<Integer> getVals() {
		return vals;
	}

	public void setVals(ArrayList<Integer> vals) {
		this.vals = vals;
	}
}
