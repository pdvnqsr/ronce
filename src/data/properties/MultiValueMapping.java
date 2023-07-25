package data.properties;

public class MultiValueMapping {

	private int[] inGameValue;
	private String displayValue;
	
	public MultiValueMapping(int[] inGameValue, String displayValue) {
		super();
		this.inGameValue = inGameValue;
		this.displayValue = displayValue;
	}

	public int[] getInGameValue() {
		return inGameValue;
	}

	public void setInGameValue(int[] inGameValue) {
		this.inGameValue = inGameValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
}
