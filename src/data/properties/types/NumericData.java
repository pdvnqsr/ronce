package data.properties.types;

import java.util.Properties;

public class NumericData {

	private int[] offsets;
	private int min;
	private int max;
	private int defaut;

	public NumericData(Properties props, String key) {
		super();
		String[] temp = props.getProperty(key+".offset").split(",");
		this.offsets = new int[temp.length];
		for(int i=0;i<temp.length;i++) {
			this.offsets[i] = Integer.parseInt(temp[i]);
		}
		this.min = Integer.parseInt(props.getProperty(key+".min"));
		this.max = Integer.parseInt(props.getProperty(key+".max"));
		this.defaut = Integer.parseInt(props.getProperty(key+".defaut"));
	}
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getDefaut() {
		return defaut;
	}
	public void setDefaut(int defaut) {
		this.defaut = defaut;
	}
	public int[] getOffsets() {
		return offsets;
	}
	public void setOffset(int[] offsets) {
		this.offsets = offsets;
	}
}
