package data.elements;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import data.properties.DataProperties;
import data.properties.GamedataProperties;
import main.Launch;

public class JoueurAutre implements Serializable {

	private static final long serialVersionUID = -2793262450709560428L;

	private String id;
	private String description;
	private String nom;
	
	private int position = DataProperties.POSITION.getDefaut();

	private int typeCorps = GamedataProperties.CP_TYPECORPS.getDefaut();
	private int couleurPeau = GamedataProperties.CP_COULEURPEAU.getDefaut();
	
	private int visage = GamedataProperties.CP_VISAGE.getDefaut();
	
	private int cheveux = GamedataProperties.CP_CHEVEUX.getDefaut();
	private int couleurCheveux = GamedataProperties.CP_COULEURCHEVEUX.getDefaut();
	
	private int yeux = GamedataProperties.CP_YEUX.getDefaut();
	private int couleurYeux = GamedataProperties.CP_COULEURYEUX.getDefaut();
	
	private int sourcils = GamedataProperties.CP_SOURCILS.getDefaut();
	private int couleurSourcils = GamedataProperties.CP_COULEURSOURCILS.getDefaut();
	
	private int nez = GamedataProperties.CP_NEZ.getDefaut();
	
	private int crampons = GamedataProperties.CP_CRAMPONS.getDefaut();
	
	private int lunettes = GamedataProperties.CP_LUNETTES.getDefaut();
	private int couleurLunettes = GamedataProperties.CP_COULEURLUNETTES.getDefaut();
	
	private int attaque = DataProperties.STAT.getDefaut();
	private int defense = DataProperties.STAT.getDefaut();
	private int puissance = DataProperties.STAT.getDefaut();
	private int vitesse = DataProperties.STAT.getDefaut();
	private int technique = DataProperties.STAT.getDefaut();
	
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
	private int arrets = DataProperties.ARRETS.getDefaut();
	private int superArret = DataProperties.SUPERARRET.getDefaut();
	
	private int competenceCapitaine = DataProperties.COMPETENCECAPITAINE.getDefaut();
	private int competence1 = DataProperties.COMPETENCES.getDefaut();
	private int competence2 = DataProperties.COMPETENCES.getDefaut();
	private int competence3 = DataProperties.COMPETENCES.getDefaut();
	private int competence4 = DataProperties.COMPETENCES.getDefaut();
	private int competence5 = DataProperties.COMPETENCES.getDefaut();
	private int competence6 = DataProperties.COMPETENCES.getDefaut();
	
	private int celebration1 = DataProperties.CELEBRATION.getDefaut();
	private int celebration2 = DataProperties.CELEBRATION.getDefaut();
	private int celebration3 = DataProperties.CELEBRATION.getDefaut();
	private int celebration4 = DataProperties.CELEBRATION.getDefaut();
	
	public JoueurAutre(String nom, boolean withId) {
		this.nom = nom;
		if(withId) {
			id = regenerateId();
		}
	}
	
	public String regenerateId() {
		return "R:" + UUID.randomUUID().toString();
	}
	
	public String getEquipes() {
		String equipes = "";
		if(id != null && !"".equals(id)) {
			for(Equipe e : Launch.getInstance().getData().getEquipes()) {
				for(String s : e.getJoueurs()) {
					if(s.equals(id)) {
						equipes += e.getNom() + "\n";
					}
				}
			}
		}
		return equipes;
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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setVisage(int visage) {
		this.visage = visage;
	}

	public int getTypeCorps() {
		return typeCorps;
	}

	public void setTypeCorps(int typeCorps) {
		this.typeCorps = typeCorps;
	}

	public int getCouleurPeau() {
		return couleurPeau;
	}

	public void setCouleurPeau(int couleurPeau) {
		this.couleurPeau = couleurPeau;
	}

	public int getVisage() {
		return visage;
	}

	public int getCheveux() {
		return cheveux;
	}

	public void setCheveux(int cheveux) {
		this.cheveux = cheveux;
	}

	public int getCouleurCheveux() {
		return couleurCheveux;
	}

	public void setCouleurCheveux(int couleurCheveux) {
		this.couleurCheveux = couleurCheveux;
	}

	public int getYeux() {
		return yeux;
	}

	public void setYeux(int yeux) {
		this.yeux = yeux;
	}

	public int getCouleurYeux() {
		return couleurYeux;
	}

	public void setCouleurYeux(int couleurYeux) {
		this.couleurYeux = couleurYeux;
	}

	public int getSourcils() {
		return sourcils;
	}

	public void setSourcils(int sourcils) {
		this.sourcils = sourcils;
	}

	public int getCouleurSourcils() {
		return couleurSourcils;
	}

	public void setCouleurSourcils(int couleurSourcils) {
		this.couleurSourcils = couleurSourcils;
	}

	public int getNez() {
		return nez;
	}

	public void setNez(int nez) {
		this.nez = nez;
	}

	public int getCrampons() {
		return crampons;
	}

	public void setCrampons(int crampons) {
		this.crampons = crampons;
	}

	public int getLunettes() {
		return lunettes;
	}

	public void setLunettes(int lunettes) {
		this.lunettes = lunettes;
	}

	public int getCouleurLunettes() {
		return couleurLunettes;
	}

	public void setCouleurLunettes(int couleurLunettes) {
		this.couleurLunettes = couleurLunettes;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getTechnique() {
		return technique;
	}

	public void setTechnique(int technique) {
		this.technique = technique;
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

	public int getArrets() {
		return arrets;
	}

	public void setArrets(int arrets) {
		this.arrets = arrets;
	}

	public int getSuperArret() {
		return superArret;
	}

	public void setSuperArret(int superArret) {
		this.superArret = superArret;
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

	public int getCelebration1() {
		return celebration1;
	}

	public void setCelebration1(int celebration1) {
		this.celebration1 = celebration1;
	}

	public int getCelebration2() {
		return celebration2;
	}

	public void setCelebration2(int celebration2) {
		this.celebration2 = celebration2;
	}

	public int getCelebration3() {
		return celebration3;
	}

	public void setCelebration3(int celebration3) {
		this.celebration3 = celebration3;
	}

	public int getCelebration4() {
		return celebration4;
	}

	public void setCelebration4(int celebration4) {
		this.celebration4 = celebration4;
	}
	
	@Override
	public String toString() {
		return nom;
	}

	public void update(JoueurAutre j) {
		this.id = j.getId();
		this.description = j.getDescription();
		this.nom = j.getNom();
		this.position = j.getPosition();
		this.typeCorps = j.getTypeCorps();
		this.couleurPeau = j.getCouleurPeau();
		this.visage = j.getVisage();
		this.cheveux = j.getCheveux();
		this.couleurCheveux = j.getCouleurCheveux();
		this.yeux = j.getYeux();
		this.couleurYeux = j.getCouleurYeux();
		this.sourcils = j.getSourcils();
		this.couleurSourcils = j.getCouleurSourcils();
		this.nez = j.getNez();
		this.crampons = j.getCrampons();
		this.lunettes = j.getLunettes();
		this.couleurLunettes = j.getCouleurLunettes();
		this.attaque = j.getAttaque();
		this.defense = j.getDefense();
		this.puissance = j.getPuissance();
		this.vitesse = j.getVitesse();
		this.technique = j.getTechnique();
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
		this.arrets = j.getArrets();
		this.superArret = j.getSuperArret();
		this.competenceCapitaine = j.getCompetenceCapitaine();
		this.competence1 = j.getCompetence1();
		this.competence2 = j.getCompetence2();
		this.competence3 = j.getCompetence3();
		this.competence4 = j.getCompetence4();
		this.competence5 = j.getCompetence5();
		this.competence6 = j.getCompetence6();
		this.celebration1 = j.getCelebration1();
		this.celebration2 = j.getCelebration2();
		this.celebration3 = j.getCelebration3();
		this.celebration4 = j.getCelebration4();
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrets, attaque, blocage, celebration1, celebration2, celebration3, celebration4, cheveux,
				competence1, competence2, competence3, competence4, competence5, competence6, competenceCapitaine,
				couleurCheveux, couleurLunettes, couleurPeau, couleurSourcils, couleurYeux, crampons, defense,
				description, dribble1, dribble2, id, lunettes, nez, nom, passe, passesCombo, position, puissance,
				sourcils, superArret, superTir, superTirAlt, tacle1, tacle2, technique, tir, tirAerien, tirAlt,
				tirCombo1, tirCombo2, typeCorps, visage, vitesse, yeux);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JoueurAutre other = (JoueurAutre) obj;
		return arrets == other.arrets && attaque == other.attaque && blocage == other.blocage
				&& celebration1 == other.celebration1 && celebration2 == other.celebration2
				&& celebration3 == other.celebration3 && celebration4 == other.celebration4 && cheveux == other.cheveux
				&& competence1 == other.competence1 && competence2 == other.competence2
				&& competence3 == other.competence3 && competence4 == other.competence4
				&& competence5 == other.competence5 && competence6 == other.competence6
				&& competenceCapitaine == other.competenceCapitaine && couleurCheveux == other.couleurCheveux
				&& couleurLunettes == other.couleurLunettes && couleurPeau == other.couleurPeau
				&& couleurSourcils == other.couleurSourcils && couleurYeux == other.couleurYeux
				&& crampons == other.crampons && defense == other.defense
				&& Objects.equals(description, other.description) && dribble1 == other.dribble1
				&& dribble2 == other.dribble2 && Objects.equals(id, other.id) && lunettes == other.lunettes
				&& nez == other.nez && Objects.equals(nom, other.nom) && passe == other.passe
				&& passesCombo == other.passesCombo && position == other.position && puissance == other.puissance
				&& sourcils == other.sourcils && superArret == other.superArret && superTir == other.superTir
				&& superTirAlt == other.superTirAlt && tacle1 == other.tacle1 && tacle2 == other.tacle2
				&& technique == other.technique && tir == other.tir && tirAerien == other.tirAerien
				&& tirAlt == other.tirAlt && tirCombo1 == other.tirCombo1 && tirCombo2 == other.tirCombo2
				&& typeCorps == other.typeCorps && visage == other.visage && vitesse == other.vitesse
				&& yeux == other.yeux;
	}
}
