package data.properties.mappings;

import java.util.Objects;

public class JoueurMapping {

	private String inGameValue;
	private String displayValue;
	
	public JoueurMapping(String inGameValue, String displayValue) {
		this.inGameValue = inGameValue;
		this.displayValue = displayValue;
	}
	
	public String getInGameValue() {
		return inGameValue;
	}

	public void setInGameValue(String inGameValue) {
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

	@Override
	public int hashCode() {
		return Objects.hash(displayValue, inGameValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JoueurMapping other = (JoueurMapping) obj;
		return Objects.equals(displayValue, other.displayValue) && Objects.equals(inGameValue, other.inGameValue);
	}
}
