package data.properties;

import java.util.Properties;

public class TextData {

	private int offset;
	private String defaut;
	private int longueur;

	public TextData(Properties props, String key) {
		super();
		this.offset = Integer.parseInt(props.getProperty(key+".offset"));
		this.longueur = Integer.parseInt(props.getProperty(key+".longueur"));
		this.defaut = props.getProperty(key+".defaut");
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getDefaut() {
		return defaut;
	}

	public void setDefaut(String defaut) {
		this.defaut = defaut;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
}
