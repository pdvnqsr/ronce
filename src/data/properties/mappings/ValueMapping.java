package data.properties.mappings;

public class ValueMapping {

	private int inGameValue;
	private String displayValue;
	
	public ValueMapping(int inGameValue, String displayValue) {
		super();
		this.inGameValue = inGameValue;
		this.displayValue = displayValue;
	}

	public int getInGameValue() {
		return inGameValue;
	}

	public void setInGameValue(int inGameValue) {
		this.inGameValue = inGameValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
	
	@Override
	public String toString() {
		return displayValue;
	}
}
