package data;

import java.io.Serializable;
import java.util.UUID;

import data.properties.DataProperties;

public class Joueur implements Serializable {

	private static final long serialVersionUID = -2793262450709560428L;

	private String id;
	private String description;
	private String nom;
	
	private int position = DataProperties.POSITION.getDefaut();

	private int titre1=0;
	private int titre2=0;
	private int titre3=0;
	
	private int typeCorps = DataProperties.TYPECORPS.getDefaut();
	private int taille = DataProperties.TAILLE.getDefaut();
	private int tailleTete = DataProperties.TAILLETETE.getDefaut();
	private int couleurPeau = DataProperties.COULEURPEAU.getDefaut();
	private int styleManche = DataProperties.STYLEMANCHE.getDefaut();
	
	private int visage = DataProperties.VISAGE.getDefaut();
	private int tailleBouche = DataProperties.TAILLEBOUCHE.getDefaut();
	private int commissures = DataProperties.COMMISSURES.getDefaut();
	private int positionBouche = DataProperties.POSITIONBOUCHE.getDefaut();
	
	private int cheveux = DataProperties.CHEVEUX.getDefaut();
	private int couleurCheveux = DataProperties.COULEURCHEVEUX.getDefaut();
	
	private int yeux = DataProperties.YEUX.getDefaut();
	private int tailleYeux = DataProperties.TAILLEYEUX.getDefaut();
	private int positionYeux = DataProperties.POSITIONYEUX.getDefaut();
	private int espacementYeux = DataProperties.ESPACEMENTYEUX.getDefaut();
	
	private int taillePupilles = DataProperties.TAILLEPUPILLES.getDefaut();
	private int couleurYeux = DataProperties.COULEURYEUX.getDefaut();
	
	private int sourcils = DataProperties.SOURCILS.getDefaut();
	private int couleurSourcils = DataProperties.COULEURSOURCILS.getDefaut();
	
	private int nez = DataProperties.NEZ.getDefaut();
	private int positionNez = DataProperties.POSITIONNEZ.getDefaut();
	private int tailleNez = DataProperties.TAILLENEZ.getDefaut();
	
	private int crampons = DataProperties.CRAMPONS.getDefaut();
	
	private int voix = DataProperties.VOIX.getDefaut();
	
	private int lunettes = DataProperties.LUNETTES.getDefaut();
	private int couleurLunettes = DataProperties.COULEURLUNETTES.getDefaut();
	
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
	
	private int competenceCapitaine = DataProperties.COMPETECESCAPITAINE.getDefaut();
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
	
	public Joueur(String nom, boolean withId) {
		this.nom = nom;
		if(withId) {
			id = regenerateId();
		}
	}
	
	public String regenerateId() {
		return "J:" + UUID.randomUUID().toString();
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

	public int getTitre1() {
		return titre1;
	}

	public void setTitre1(int titre1) {
		this.titre1 = titre1;
	}

	public int getTitre2() {
		return titre2;
	}

	public void setTitre2(int titre2) {
		this.titre2 = titre2;
	}

	public int getTitre3() {
		return titre3;
	}

	public void setTitre3(int titre3) {
		this.titre3 = titre3;
	}

	public int getTypeCorps() {
		return typeCorps;
	}

	public void setTypeCorps(int typeCorps) {
		this.typeCorps = typeCorps;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getTailleTete() {
		return tailleTete;
	}

	public void setTailleTete(int tailleTete) {
		this.tailleTete = tailleTete;
	}

	public int getCouleurPeau() {
		return couleurPeau;
	}

	public void setCouleurPeau(int couleurPeau) {
		this.couleurPeau = couleurPeau;
	}

	public int getStyleManche() {
		return styleManche;
	}

	public void setStyleManche(int styleManche) {
		this.styleManche = styleManche;
	}

	public int getVisage() {
		return visage;
	}

	public void setVisage(int visage) {
		this.visage = visage;
	}

	public int getTailleBouche() {
		return tailleBouche;
	}

	public void setTailleBouche(int tailleBouche) {
		this.tailleBouche = tailleBouche;
	}

	public int getCommissures() {
		return commissures;
	}

	public void setCommissures(int commissures) {
		this.commissures = commissures;
	}

	public int getPositionBouche() {
		return positionBouche;
	}

	public void setPositionBouche(int positionBouche) {
		this.positionBouche = positionBouche;
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

	public int getTailleYeux() {
		return tailleYeux;
	}

	public void setTailleYeux(int tailleYeux) {
		this.tailleYeux = tailleYeux;
	}

	public int getPositionYeux() {
		return positionYeux;
	}

	public void setPositionYeux(int positionYeux) {
		this.positionYeux = positionYeux;
	}

	public int getEspacementYeux() {
		return espacementYeux;
	}

	public void setEspacementYeux(int espacementYeux) {
		this.espacementYeux = espacementYeux;
	}

	public int getTaillePupilles() {
		return taillePupilles;
	}

	public void setTaillePupilles(int taillePupilles) {
		this.taillePupilles = taillePupilles;
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

	public int getPositionNez() {
		return positionNez;
	}

	public void setPositionNez(int positionNez) {
		this.positionNez = positionNez;
	}

	public int getTailleNez() {
		return tailleNez;
	}

	public void setTailleNez(int tailleNez) {
		this.tailleNez = tailleNez;
	}

	public int getCrampons() {
		return crampons;
	}

	public void setCrampons(int crampons) {
		this.crampons = crampons;
	}

	public int getVoix() {
		return voix;
	}

	public void setVoix(int voix) {
		this.voix = voix;
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

	public void update(Joueur j) {
		this.id = j.getId();
		this.description = j.getDescription();
		this.nom = j.getNom();
		this.position = j.getPosition();
		this.titre1 = j.getTitre1();
		this.titre2 = j.getTitre2();
		this.titre3 = j.getTitre3();
		this.typeCorps = j.getTypeCorps();
		this.taille = j.getTaille();
		this.tailleTete = j.getTailleTete();
		this.couleurPeau = j.getCouleurPeau();
		this.styleManche = j.getStyleManche();
		this.visage = j.getVisage();
		this.tailleBouche = j.getTailleBouche();
		this.commissures = j.getCommissures();
		this.positionBouche = j.getPositionBouche();
		this.cheveux = j.getCheveux();
		this.couleurCheveux = j.getCouleurCheveux();
		this.yeux = j.getYeux();
		this.tailleYeux = j.getTailleYeux();
		this.positionYeux = j.getPositionYeux();
		this.espacementYeux =  j.getEspacementYeux();
		this.taillePupilles = j.getTaillePupilles();
		this.couleurYeux = j.getCouleurYeux();
		this.sourcils = j.getSourcils();
		this.couleurSourcils = j.getCouleurSourcils();
		this.nez = j.getNez();
		this.positionNez = j.getPositionNez();
		this.tailleNez = j.getTailleNez();
		this.crampons = j.getCrampons();
		this.voix = j.getVoix();
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
	
	
}
