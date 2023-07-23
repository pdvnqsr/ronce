package data.properties;

import java.util.ArrayList;
import java.util.Properties;

public class SelectData {

	private int[] offsets;
	private int defaut;
	private ArrayList<ValueMapping> vals;
	
	public SelectData(Properties props, String key) {
		super();
		String[] temp = props.getProperty(key+".offset").split(",");
		this.offsets = new int[temp.length];
		for(int i=0;i<temp.length;i++) {
			this.offsets[i] = Integer.parseInt(temp[i]);
		}
		this.vals = new ArrayList<ValueMapping>();
		this.defaut = Integer.parseInt(props.getProperty(key+".defaut"));
		boolean go = true;
		int i=0;
		String[] valContent;
		while(go) {
			valContent = props.getProperty(key+".vals."+i).split(":");
			this.vals.add(new ValueMapping( Integer.parseInt(valContent[0]),valContent[1]));
			i++;
			go = props.containsKey(key+".vals."+i);
		}
	}

	public int getIndexFromInGameValue(int value, int defaut) {
		int index = defaut;
		ValueMapping vm;
		for(int i=0;i<vals.size();i++) {
			vm = vals.get(i);
			if(vm.getInGameValue() == value) {
				index = i;
			}
		}
		return index;
	}
	
	public int[] getOffsets() {
		return offsets;
	}

	public void setOffsets(int[] offsets) {
		this.offsets = offsets;
	}

	public int getDefaut() {
		return defaut;
	}

	public void setDefaut(int defaut) {
		this.defaut = defaut;
	}

	public ArrayList<ValueMapping> getVals() {
		return vals;
	}

	public void setVals(ArrayList<ValueMapping> vals) {
		this.vals = vals;
	}
}
