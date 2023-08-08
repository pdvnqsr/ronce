package data.properties.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import data.properties.mappings.MultiValueMapping;

public class MultiSelectData {

	private int[] offsets;
	private int[] defaut;
	private ArrayList<MultiValueMapping> vals;
	
	public MultiSelectData(Properties props, String key) {
		super();
		String[] temp = props.getProperty(key+".offset").split(",");
		this.offsets = new int[temp.length];
		for(int i=0;i<temp.length;i++) {
			this.offsets[i] = Integer.parseInt(temp[i]);
		}
		temp = props.getProperty(key+".defaut").split(",");
		this.defaut = new int[temp.length];
		for(int i=0;i<temp.length;i++) {
			this.defaut[i] = Integer.parseInt(temp[i]);
		}
		this.vals = new ArrayList<MultiValueMapping>();
		boolean go = true;
		int i=0;
		String[] valContent;
		while(go) {
			valContent = props.getProperty(key+".vals."+i).split(":");
			temp = valContent[0].split(",");
			int[] values = new int[temp.length];
			for(int j=0;j<temp.length;j++) {
				values[j] = Integer.parseInt(temp[j]);
			}
			this.vals.add(new MultiValueMapping(values,valContent[1]));
			i++;
			go = props.containsKey(key+".vals."+i);
		}
	}

	public int getIndexFromInGameValue(int[] value) {
		int index = -1;
		MultiValueMapping vm;
		for(int i=0;i<vals.size() && index == -1;i++) {
			vm = vals.get(i);
			if(Arrays.equals(vm.getInGameValue(), value)) {
				index = i;
			}
		}
		return index;
	}
	
	public int[] getInGameValue(int[] value) {
		int [] inGame = {};
		for(int v : value) {
			inGame = concat(inGame, getVals().get(v).getInGameValue());
		}
		return inGame;
	}
	
	private int[] concat(int[] array1, int[] array2) {
	    int[] result = Arrays.copyOf(array1, array1.length + array2.length);
	    System.arraycopy(array2, 0, result, array1.length, array2.length);
	    return result;
	}
	
	public int[] getOffsets() {
		return offsets;
	}

	public void setOffsets(int[] offsets) {
		this.offsets = offsets;
	}

	public int[] getDefaut() {
		return defaut;
	}

	public void setDefaut(int[] defaut) {
		this.defaut = defaut;
	}

	public ArrayList<MultiValueMapping> getVals() {
		return vals;
	}

	public void setVals(ArrayList<MultiValueMapping> vals) {
		this.vals = vals;
	}
}
