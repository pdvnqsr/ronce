package data.properties.mappings;

public class LongValueMapping {

	private long inGameValue;
	private String displayValue;
	
	public LongValueMapping(long inGameValue, String displayValue) {
		super();
		this.inGameValue = inGameValue;
		this.displayValue = displayValue;
	}

	public long getInGameValue() {
		return inGameValue;
	}

	public void setInGameValue(long inGameValue) {
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
