package data.properties.types;

import java.util.ArrayList;
import java.util.Properties;

import data.properties.TextsProperties;
import data.properties.mappings.ValueMapping;

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
		this.defaut = Integer.parseInt(props.getProperty(key+".defaut"));
		
		this.vals = new ArrayList<ValueMapping>();
		String valsKey = key;
		if(props.containsKey(key+".vals")) {
			valsKey = props.getProperty(valsKey+".vals");
		}
		
		boolean go = true;
		int i=0;
		String[] valContent;
		String displayValue;
		while(go) {
			valContent = props.getProperty(valsKey+".vals."+i).split(":");
			displayValue = valContent[1];
			if(displayValue.startsWith("txt.")) {
				displayValue = TextsProperties.TEXTS.getString(displayValue);
			}
			this.vals.add(new ValueMapping( Integer.parseInt(valContent[0]), displayValue));
			i++;
			go = props.containsKey(valsKey+".vals."+i);
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
