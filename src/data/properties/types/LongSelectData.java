package data.properties.types;

import java.util.ArrayList;
import java.util.Properties;

import data.properties.TextsProperties;
import data.properties.mappings.LongValueMapping;

public class LongSelectData {

	private int[] offsets;
	private int defaut;
	private ArrayList<LongValueMapping> vals;
	
	public LongSelectData(Properties props, String key) {
		super();
		String[] temp = props.getProperty(key+".offset").split(",");
		this.offsets = new int[temp.length];
		for(int i=0;i<temp.length;i++) {
			this.offsets[i] = Integer.parseInt(temp[i]);
		}
		this.defaut = Integer.parseInt(props.getProperty(key+".defaut"));
		
		this.vals = new ArrayList<LongValueMapping>();
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
			this.vals.add(new LongValueMapping(Long.parseLong(valContent[0]), displayValue));
			i++;
			go = props.containsKey(valsKey+".vals."+i);
		}
	}

	public int getIndexFromInGameValue(long value, int defaut) {
		int index = defaut;
		LongValueMapping vm;
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

	public ArrayList<LongValueMapping> getVals() {
		return vals;
	}

	public void setVals(ArrayList<LongValueMapping> vals) {
		this.vals = vals;
	}
}
