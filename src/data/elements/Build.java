package data.elements;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import data.properties.DataProperties;

public class Build implements Serializable {

	private static final long serialVersionUID = 3481539554063763182L;

	private String id;
	private String description;
	private String nom;
	
	private int tir = DataProperties.TIRS.getDefaut();
	private int tirAlt = DataProperties.TIRS.getDefaut();
	private int tirAerien = DataProperties.TIRSAERIENS.getDefaut();
	private int superTir = DataProperties.SUPERTIRS.getDefaut();
	private int superTirAlt = DataProperties.SUPERTIRS.getDefaut();
	private int dribble1 = DataProperties.DRIBBLES.getDefaut();
	private int dribble2 = DataProperties.DRIBBLES.getDefaut();
	private int passe = DataProperties.PASSES.getDefaut();
	private int tirCombo1 = DataProperties.TIRSCOMBO1.getDefaut();
	private int tirCombo2 = DataProperties.TIRSCOMBO2.getDefaut();
	private int passesCombo = DataProperties.PASSESCOMBO.getDefaut();
	private int tacle1 = DataProperties.TACLES.getDefaut();
	private int tacle2 = DataProperties.TACLES.getDefaut();
	private int blocage = DataProperties.BLOCAGES.getDefaut();
	
	private int competenceCapitaine = DataProperties.COMPETECESCAPITAINE.getDefaut();
	private int competence1 = DataProperties.COMPETENCES.getDefaut();
	private int competence2 = DataProperties.COMPETENCES.getDefaut();
	private int competence3 = DataProperties.COMPETENCES.getDefaut();
	private int competence4 = DataProperties.COMPETENCES.getDefaut();
	private int competence5 = DataProperties.COMPETENCES.getDefaut();
	private int competence6 = DataProperties.COMPETENCES.getDefaut();
	
	
	public Build(String nom, boolean withId) {
		this.nom = nom;
		if(withId) {
			id = regenerateId();
		}
	}
	
	public String regenerateId() {
		return "B:" + UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTir() {
		return tir;
	}

	public void setTir(int tir) {
		this.tir = tir;
	}
	
	public int getTirAlt() {
		return tirAlt;
	}

	public void setTirAlt(int tir) {
		this.tirAlt = tir;
	}

	public int getTirAerien() {
		return tirAerien;
	}

	public void setTirAerien(int tirAerien) {
		this.tirAerien = tirAerien;
	}

	public int getSuperTir() {
		return superTir;
	}

	public void setSuperTir(int superTir) {
		this.superTir = superTir;
	}
	
	public int getSuperTirAlt() {
		return superTirAlt;
	}

	public void setSuperTirAlt(int superTir) {
		this.superTirAlt = superTir;
	}

	public int getDribble1() {
		return dribble1;
	}

	public void setDribble1(int dribble1) {
		this.dribble1 = dribble1;
	}

	public int getDribble2() {
		return dribble2;
	}

	public void setDribble2(int dribble2) {
		this.dribble2 = dribble2;
	}

	public int getPasse() {
		return passe;
	}

	public void setPasse(int passe) {
		this.passe = passe;
	}

	public int getTirCombo1() {
		return tirCombo1;
	}

	public void setTirCombo1(int tirCombo1) {
		this.tirCombo1 = tirCombo1;
	}

	public int getTirCombo2() {
		return tirCombo2;
	}

	public void setTirCombo2(int tirCombo2) {
		this.tirCombo2 = tirCombo2;
	}

	public int getPassesCombo() {
		return passesCombo;
	}

	public void setPassesCombo(int passesCombo) {
		this.passesCombo = passesCombo;
	}

	public int getTacle1() {
		return tacle1;
	}

	public void setTacle1(int tacle1) {
		this.tacle1 = tacle1;
	}

	public int getTacle2() {
		return tacle2;
	}

	public void setTacle2(int tacle2) {
		this.tacle2 = tacle2;
	}

	public int getBlocage() {
		return blocage;
	}

	public void setBlocage(int blocage) {
		this.blocage = blocage;
	}

	public int getCompetenceCapitaine() {
		return competenceCapitaine;
	}

	public void setCompetenceCapitaine(int competenceCapitaine) {
		this.competenceCapitaine = competenceCapitaine;
	}

	public int getCompetence1() {
		return competence1;
	}

	public void setCompetence1(int competence1) {
		this.competence1 = competence1;
	}

	public int getCompetence2() {
		return competence2;
	}

	public void setCompetence2(int competence2) {
		this.competence2 = competence2;
	}

	public int getCompetence3() {
		return competence3;
	}

	public void setCompetence3(int competence3) {
		this.competence3 = competence3;
	}

	public int getCompetence4() {
		return competence4;
	}

	public void setCompetence4(int competence4) {
		this.competence4 = competence4;
	}

	public int getCompetence5() {
		return competence5;
	}

	public void setCompetence5(int competence5) {
		this.competence5 = competence5;
	}

	public int getCompetence6() {
		return competence6;
	}

	public void setCompetence6(int competence6) {
		this.competence6 = competence6;
	}
	
	@Override
	public String toString() {
		return nom;
	}

	public void update(Build j) {
		this.id = j.getId();
		this.description = j.getDescription();
		this.nom = j.getNom();
		this.tir = j.getTir();
		this.tirAlt = j.getTirAlt();
		this.tirAerien = j.getTirAerien();
		this.superTir = j.getSuperTir();
		this.superTirAlt = j.getSuperTirAlt();
		this.dribble1 = j.getDribble1();
		this.dribble2 = j.getDribble2();
		this.passe = j.getPasse();
		this.tirCombo1 = j.getTirCombo1();
		this.tirCombo2 = j.getTirCombo2();
		this.passesCombo = j.getPassesCombo();
		this.tacle1 = j.getTacle1();
		this.tacle2 = j.getTacle2();
		this.blocage = j.getBlocage();
		this.competenceCapitaine = j.getCompetenceCapitaine();
		this.competence1 = j.getCompetence1();
		this.competence2 = j.getCompetence2();
		this.competence3 = j.getCompetence3();
		this.competence4 = j.getCompetence4();
		this.competence5 = j.getCompetence5();
		this.competence6 = j.getCompetence6();
	}

	@Override
	public int hashCode() {
		return Objects.hash(blocage, competence1, competence2, competence3, competence4, competence5, competence6,
				competenceCapitaine, dribble1, dribble2, passe, passesCombo, superTir, superTirAlt, tacle1, tacle2, tir,
				tirAerien, tirAlt, tirCombo1, tirCombo2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Build other = (Build) obj;
		return blocage == other.blocage && competence1 == other.competence1 && competence2 == other.competence2
				&& competence3 == other.competence3 && competence4 == other.competence4
				&& competence5 == other.competence5 && competence6 == other.competence6
				&& competenceCapitaine == other.competenceCapitaine && dribble1 == other.dribble1
				&& dribble2 == other.dribble2 && passe == other.passe && passesCombo == other.passesCombo
				&& superTir == other.superTir && superTirAlt == other.superTirAlt && tacle1 == other.tacle1
				&& tacle2 == other.tacle2 && tir == other.tir && tirAerien == other.tirAerien && tirAlt == other.tirAlt
				&& tirCombo1 == other.tirCombo1 && tirCombo2 == other.tirCombo2;
	}
}
