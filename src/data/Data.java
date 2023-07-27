package data;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import data.properties.DataProperties;
import data.properties.MultiSelectData;
import data.properties.NumericData;
import data.properties.SelectData;
import data.properties.SystemProperties;
import data.properties.TextData;

public class Data implements Serializable {

	private static final long serialVersionUID = 6632461413087395187L;


	private ArrayList<Joueur> joueurs;
	private transient ArrayList<Joueur> joueursInGame;
	
	private ArrayList<Equipe> equipes;
	private transient ArrayList<Equipe> equipesInGame;

	public Data() {
		joueurs = new ArrayList<Joueur>();
		joueursInGame = new ArrayList<Joueur>();
		
		equipes = new ArrayList<Equipe>();
		equipesInGame = new ArrayList<Equipe>();
	}

	public void supprimerJoueur(Joueur j) {
		joueurs.remove(j);
	}
	
	public Joueur nouveauJoueur() {
		Joueur joueur = new Joueur(DataProperties.JOUEUR_NOM.getDefaut(),true);
		joueurs.add(joueur);
		return joueur;
	}
	
	public void supprimerEquipe(Equipe e) {
		equipes.remove(e);
	}
	
	public Equipe nouvelleEquipe() {
		Equipe e = new Equipe(true);
		equipes.add(e);
		return e;
	}

	public Joueur getJoueurParId(String id) {
		Joueur joueur = null;
		for(Joueur j : joueurs) {
			if(id.equals(j.getId())) {
				joueur = j;
			}
		}
		return joueur;
	}
	
	public Equipe getEquipeParId(String id) {
		Equipe equipe = null;
		for(Equipe e : equipes) {
			if(id.equals(e.getId())) {
				equipe = e;
			}
		}
		return equipe;
	}
	
	public void loadJoueursFromGame() {
		try  {
			RandomAccessFile raf = new RandomAccessFile(SystemProperties.PATH, "rw");
			
			joueursInGame.clear();
			
			Joueur joueur;
			for(int i=1;i<=20;i++) {
				Long addr = DataProperties.JOUEURS_ADDRESS.get(i);
				
				joueur = new Joueur(getTextFromGame(raf, addr, DataProperties.JOUEUR_NOM),false);
				joueur.setPosition(getIntFromGame(raf, addr, DataProperties.POSITION,0));
				joueur.setTypeCorps(getIntFromGame(raf, addr, DataProperties.TYPECORPS,0));
				joueur.setTaille(getIntFromGame(raf, addr, DataProperties.TAILLE,0));
				joueur.setTailleTete(getIntFromGame(raf, addr, DataProperties.TAILLETETE,0));
				joueur.setCouleurPeau(getIntFromGame(raf, addr, DataProperties.COULEURPEAU,0));
				joueur.setStyleManche(getIntFromGame(raf, addr, DataProperties.STYLEMANCHE,0));
				joueur.setVisage(getIntFromGame(raf, addr, DataProperties.VISAGE,0));
				joueur.setTailleBouche(getIntFromGame(raf, addr, DataProperties.TAILLEBOUCHE,0));
				joueur.setCommissures(getIntFromGame(raf, addr, DataProperties.COMMISSURES,0));
				joueur.setPositionBouche(getIntFromGame(raf, addr, DataProperties.POSITIONBOUCHE,0));
				joueur.setCheveux(getIntFromGame(raf, addr, DataProperties.CHEVEUX,0));
				joueur.setCouleurCheveux(getIntFromGame(raf, addr, DataProperties.COULEURCHEVEUX,0));
				joueur.setYeux(getIntFromGame(raf, addr, DataProperties.YEUX,0));
				joueur.setTailleYeux(getIntFromGame(raf, addr, DataProperties.TAILLEYEUX,0));
				joueur.setPositionYeux(getIntFromGame(raf, addr, DataProperties.POSITIONYEUX,0));
				joueur.setEspacementYeux(getIntFromGame(raf, addr, DataProperties.ESPACEMENTYEUX,0));
				joueur.setTaillePupilles(getIntFromGame(raf, addr, DataProperties.TAILLEPUPILLES,0));
				joueur.setCouleurYeux(getIntFromGame(raf, addr, DataProperties.COULEURYEUX,0));
				joueur.setSourcils(getIntFromGame(raf, addr, DataProperties.SOURCILS,0));
				joueur.setCouleurSourcils(getIntFromGame(raf, addr, DataProperties.COULEURSOURCILS,0));
				joueur.setNez(getIntFromGame(raf, addr, DataProperties.NEZ,0));
				joueur.setPositionNez(getIntFromGame(raf, addr, DataProperties.POSITIONNEZ,0));
				joueur.setTailleNez(getIntFromGame(raf, addr, DataProperties.TAILLENEZ,0));
				joueur.setCrampons(getIntFromGame(raf, addr, DataProperties.CRAMPONS,0));
				joueur.setVoix(getIntFromGame(raf, addr, DataProperties.VOIX,0));
				joueur.setLunettes(getIntFromGame(raf, addr, DataProperties.LUNETTES,0));
				joueur.setCouleurLunettes(getIntFromGame(raf, addr, DataProperties.COULEURLUNETTES,0));
				joueur.setCelebration1(getIntFromGame(raf, addr, DataProperties.CELEBRATION,0));
				joueur.setCelebration2(getIntFromGame(raf, addr, DataProperties.CELEBRATION,1));
				joueur.setCelebration3(getIntFromGame(raf, addr, DataProperties.CELEBRATION,2));
				joueur.setCelebration4(getIntFromGame(raf, addr, DataProperties.CELEBRATION,3));
				joueur.setAttaque(getIntFromGame(raf, addr, DataProperties.STAT,0));
				joueur.setDefense(getIntFromGame(raf, addr, DataProperties.STAT,1));
				joueur.setPuissance(getIntFromGame(raf, addr, DataProperties.STAT,2));
				joueur.setVitesse(getIntFromGame(raf, addr, DataProperties.STAT,3));
				joueur.setTechnique(getIntFromGame(raf, addr, DataProperties.STAT,4));
				joueur.setTir(getIntFromGame(raf, addr, DataProperties.TIRS,0));
				joueur.setTirAlt(getIntFromGame(raf, addr, DataProperties.TIRS,1));
				joueur.setTirAerien(getIntFromGame(raf, addr, DataProperties.TIRSAERIENS,0));
				joueur.setSuperTir(getIntFromGame(raf, addr, DataProperties.SUPERTIRS,0));
				joueur.setSuperTirAlt(getIntFromGame(raf, addr, DataProperties.SUPERTIRS,1));
				joueur.setDribble1(getIntFromGame(raf, addr, DataProperties.DRIBBLES,0));
				joueur.setDribble2(getIntFromGame(raf, addr, DataProperties.DRIBBLES,1));
				joueur.setPasse(getIntFromGame(raf, addr, DataProperties.PASSES,0));
				joueur.setTirCombo1(getIntFromGame(raf, addr, DataProperties.TIRSCOMBO1,0));
				joueur.setTirCombo2(getIntFromGame(raf, addr, DataProperties.TIRSCOMBO2,0));
				joueur.setPassesCombo(getIntFromGame(raf, addr, DataProperties.PASSESCOMBO,0));
				joueur.setTacle1(getIntFromGame(raf, addr, DataProperties.TACLES,0));
				joueur.setTacle2(getIntFromGame(raf, addr, DataProperties.TACLES,1));
				joueur.setBlocage(getIntFromGame(raf, addr, DataProperties.BLOCAGES,0));
				joueur.setCompetenceCapitaine(getIntFromGame(raf, addr, DataProperties.COMPETECESCAPITAINE,0));
				joueur.setCompetence1(getIntFromGame(raf, addr, DataProperties.COMPETENCES,0));
				joueur.setCompetence2(getIntFromGame(raf, addr, DataProperties.COMPETENCES,1));
				joueur.setCompetence3(getIntFromGame(raf, addr, DataProperties.COMPETENCES,2));
				joueur.setCompetence4(getIntFromGame(raf, addr, DataProperties.COMPETENCES,3));
				joueur.setCompetence5(getIntFromGame(raf, addr, DataProperties.COMPETENCES,4));
				joueur.setCompetence6(getIntFromGame(raf, addr, DataProperties.COMPETENCES,5));
				joueursInGame.add(joueur);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveIntoGame(Joueur joueur, int inGameIndex) {
		archiveSavedata();
		try {
			Long addr = DataProperties.JOUEURS_ADDRESS.get(inGameIndex);
			
			RandomAccessFile raf = new RandomAccessFile(SystemProperties.PATH, "rw");
			writeTextInGame(raf, addr, DataProperties.JOUEUR_NOM, joueur.getNom());
			writeIntInGame(raf, addr, DataProperties.POSITION,0,joueur.getPosition());
			writeIntInGame(raf, addr, DataProperties.TYPECORPS,0,joueur.getTypeCorps());
			writeIntInGame(raf, addr, DataProperties.TAILLE,0,joueur.getTaille());
			writeIntInGame(raf, addr, DataProperties.TAILLETETE,0,joueur.getTailleTete());
			writeIntInGame(raf, addr, DataProperties.COULEURPEAU,0,joueur.getCouleurPeau());
			writeIntInGame(raf, addr, DataProperties.STYLEMANCHE,0,joueur.getStyleManche());
			writeIntInGame(raf, addr, DataProperties.VISAGE,0,joueur.getVisage());
			writeIntInGame(raf, addr, DataProperties.TAILLEBOUCHE,0,joueur.getTailleBouche());
			writeIntInGame(raf, addr, DataProperties.COMMISSURES,0,joueur.getCommissures());
			writeIntInGame(raf, addr, DataProperties.POSITIONBOUCHE,0,joueur.getPositionBouche());
			writeIntInGame(raf, addr, DataProperties.CHEVEUX,0,joueur.getCheveux());
			writeIntInGame(raf, addr, DataProperties.COULEURCHEVEUX,0,joueur.getCouleurCheveux());
			writeIntInGame(raf, addr, DataProperties.YEUX,0,joueur.getYeux());
			writeIntInGame(raf, addr, DataProperties.TAILLEYEUX,0,joueur.getTailleYeux());
			writeIntInGame(raf, addr, DataProperties.POSITIONYEUX,0,joueur.getPositionYeux());
			writeIntInGame(raf, addr, DataProperties.ESPACEMENTYEUX,0,joueur.getEspacementYeux());
			writeIntInGame(raf, addr, DataProperties.TAILLEPUPILLES,0,joueur.getTaillePupilles());
			writeIntInGame(raf, addr, DataProperties.COULEURYEUX,0,joueur.getCouleurYeux());
			writeIntInGame(raf, addr, DataProperties.SOURCILS,0,joueur.getSourcils());
			writeIntInGame(raf, addr, DataProperties.COULEURSOURCILS,0,joueur.getCouleurSourcils());
			writeIntInGame(raf, addr, DataProperties.NEZ,0,joueur.getNez());
			writeIntInGame(raf, addr, DataProperties.POSITIONNEZ,0,joueur.getPositionNez());
			writeIntInGame(raf, addr, DataProperties.TAILLENEZ,0,joueur.getTailleNez());
			writeIntInGame(raf, addr, DataProperties.CRAMPONS,0,joueur.getCrampons());
			writeIntInGame(raf, addr, DataProperties.VOIX,0,joueur.getVoix());
			writeIntInGame(raf, addr, DataProperties.LUNETTES,0,joueur.getLunettes());
			writeIntInGame(raf, addr, DataProperties.COULEURLUNETTES,0,joueur.getCouleurLunettes());
			writeIntInGame(raf, addr, DataProperties.CELEBRATION,0,joueur.getCelebration1());
			writeIntInGame(raf, addr, DataProperties.CELEBRATION,1,joueur.getCelebration2());
			writeIntInGame(raf, addr, DataProperties.CELEBRATION,2,joueur.getCelebration3());
			writeIntInGame(raf, addr, DataProperties.CELEBRATION,3,joueur.getCelebration4());
			writeIntInGame(raf, addr, DataProperties.STAT,0,joueur.getAttaque());
			writeIntInGame(raf, addr, DataProperties.STAT,1,joueur.getDefense());
			writeIntInGame(raf, addr, DataProperties.STAT,2,joueur.getPuissance());
			writeIntInGame(raf, addr, DataProperties.STAT,3,joueur.getVitesse());
			writeIntInGame(raf, addr, DataProperties.STAT,4,joueur.getTechnique());
			writeIntInGame(raf, addr, DataProperties.TIRS,0,joueur.getTir());
			writeIntInGame(raf, addr, DataProperties.TIRS,1,joueur.getTirAlt());
			writeIntInGame(raf, addr, DataProperties.TIRSAERIENS,0,joueur.getTirAerien());
			writeIntInGame(raf, addr, DataProperties.SUPERTIRS,0,joueur.getSuperTir());
			writeIntInGame(raf, addr, DataProperties.SUPERTIRS,1,joueur.getSuperTirAlt());
			writeIntInGame(raf, addr, DataProperties.DRIBBLES,0,joueur.getDribble1());
			writeIntInGame(raf, addr, DataProperties.DRIBBLES,1,joueur.getDribble2());
			writeIntInGame(raf, addr, DataProperties.PASSES,0,joueur.getPasse());
			writeIntInGame(raf, addr, DataProperties.TIRSCOMBO1,0,joueur.getTirCombo1());
			writeIntInGame(raf, addr, DataProperties.TIRSCOMBO2,0,joueur.getTirCombo2());
			writeIntInGame(raf, addr, DataProperties.PASSESCOMBO,0,joueur.getPassesCombo());
			writeIntInGame(raf, addr, DataProperties.TACLES,0,joueur.getTacle1());
			writeIntInGame(raf, addr, DataProperties.TACLES,1,joueur.getTacle2());
			writeIntInGame(raf, addr, DataProperties.BLOCAGES,0,joueur.getBlocage());
			writeIntInGame(raf, addr, DataProperties.COMPETECESCAPITAINE,0,joueur.getCompetenceCapitaine());
			writeIntInGame(raf, addr, DataProperties.COMPETENCES,0,joueur.getCompetence1());
			writeIntInGame(raf, addr, DataProperties.COMPETENCES,1,joueur.getCompetence2());
			writeIntInGame(raf, addr, DataProperties.COMPETENCES,2,joueur.getCompetence3());
			writeIntInGame(raf, addr, DataProperties.COMPETENCES,3,joueur.getCompetence4());
			writeIntInGame(raf, addr, DataProperties.COMPETENCES,4,joueur.getCompetence5());
			writeIntInGame(raf, addr, DataProperties.COMPETENCES,5,joueur.getCompetence6());
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadEquipesFromGame() {
		try  {
			RandomAccessFile raf = new RandomAccessFile(SystemProperties.PATH, "rw");
			
			equipesInGame.clear();
			
			Equipe equipe;
			for(int i=1;i<=5;i++) {
				Long addr = DataProperties.EQUIPES_ADDRESS.get(i)[0];
				
				equipe = new Equipe(false);
				equipe.setNom(getTextFromGame(raf, addr, DataProperties.EQUIPE_NOM));
				equipe.setAbreviation(getTextFromGame(raf, addr, DataProperties.EQUIPE_ABREVIATION));
				equipe.setFond(getIntFromGame(raf, addr, DataProperties.EQUIPE_FOND,0));
				equipe.setMotifFond(getIntFromGame(raf, addr, DataProperties.EQUIPE_MOTIFFOND,0));
				equipe.setCouleurFond1(getIntFromGame(raf, addr, DataProperties.EQUIPE_COULEURFOND1,0));
				equipe.setCouleurFond2(getIntFromGame(raf, addr, DataProperties.EQUIPE_COULEURFOND2,0));
				equipe.setCouleurFond3(getIntFromGame(raf, addr, DataProperties.EQUIPE_COULEURFOND3,0));
				equipe.setCouleurFond4(getIntFromGame(raf, addr, DataProperties.EQUIPE_COULEURFOND4,0));
				equipe.setMilieu(getIntFromGame(raf, addr, DataProperties.EQUIPE_MILIEU,0));
				equipe.setCouleurMilieu1(getIntFromGame(raf, addr, DataProperties.EQUIPE_COULEURMILIEU1,0));
				equipe.setCouleurMilieu2(getIntFromGame(raf, addr, DataProperties.EQUIPE_COULEURMILIEU2,0));
				equipe.setCote(getIntFromGame(raf, addr, DataProperties.EQUIPE_COTE,0));
				equipe.setCouleurCote1(getIntFromGame(raf, addr, DataProperties.EQUIPE_COULEURCOTE1,0));
				equipe.setCouleurCote2(getIntFromGame(raf, addr, DataProperties.EQUIPE_COULEURCOTE2,0));
				equipe.setHaut(getIntFromGame(raf, addr, DataProperties.EQUIPE_HAUT,0));
				equipe.setCouleurHaut1(getIntFromGame(raf, addr, DataProperties.EQUIPE_COULEURHAUT1,0));
				equipe.setCouleurHaut2(getIntFromGame(raf, addr, DataProperties.EQUIPE_COULEURHAUT2,0));
				equipe.setBas(getIntFromGame(raf, addr, DataProperties.EQUIPE_BAS,0));
				equipe.setCouleurBas1(getIntFromGame(raf, addr, DataProperties.EQUIPE_COULEURBAS1,0));
				equipe.setCouleurBas2(getIntFromGame(raf, addr, DataProperties.EQUIPE_COULEURBAS2,0));
				equipe.setTriPieces(getMultiIntFromGame(raf, addr, DataProperties.EQUIPE_TRIPIECES));
				for(int j=0;j<equipe.getTenues().length;j++) {
					equipe.getTenues()[j].setMaillot(getIntFromGame(raf, addr, DataProperties.EQUIPE_MAILLOT,j));
					equipe.getTenues()[j].setCol(getIntFromGame(raf, addr, DataProperties.EQUIPE_COL,j));
					equipe.getTenues()[j].setMaillotCouleur1(getIntFromGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR1,j));
					equipe.getTenues()[j].setMaillotCouleur2(getIntFromGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR2,j));
					equipe.getTenues()[j].setMaillotCouleur3(getIntFromGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR3,j));
					equipe.getTenues()[j].setMaillotCouleur4(getIntFromGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR4,j));
					equipe.getTenues()[j].setShortModele(getIntFromGame(raf, addr, DataProperties.EQUIPE_SHORT,j));
					equipe.getTenues()[j].setShortMarques(getIntFromGame(raf, addr, DataProperties.EQUIPE_SHORTMARQUES,j));
					equipe.getTenues()[j].setShortCouleur1(getIntFromGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR1,j));
					equipe.getTenues()[j].setShortCouleur2(getIntFromGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR2,j));
					equipe.getTenues()[j].setShortCouleur3(getIntFromGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR3,j));
					equipe.getTenues()[j].setShortCouleur4(getIntFromGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR4,j));
					equipe.getTenues()[j].setChaussettes(getIntFromGame(raf, addr, DataProperties.EQUIPE_CHAUSSETTES,j));
					equipe.getTenues()[j].setChaussettesCouleur1(getIntFromGame(raf, addr, DataProperties.EQUIPE_CHAUSSETTESCOULEUR1,j));
					equipe.getTenues()[j].setChaussettesCouleur2(getIntFromGame(raf, addr, DataProperties.EQUIPE_CHAUSSETTESCOULEUR2,j));
					equipe.getTenues()[j].setChaussettesCouleur3(getIntFromGame(raf, addr, DataProperties.EQUIPE_CHAUSSETTESCOULEUR3,j));
					equipe.getTenues()[j].setChaussettesCouleur4(getIntFromGame(raf, addr, DataProperties.EQUIPE_CHAUSSETTESCOULEUR4,j));
					equipe.getTenues()[j].setPolice(getIntFromGame(raf, addr, DataProperties.EQUIPE_POLICE,j));
					equipe.getTenues()[j].setPoliceBordure(getIntFromGame(raf, addr, DataProperties.EQUIPE_POLICEBORDURE,j));
					equipe.getTenues()[j].setPoliceCouleur1(getIntFromGame(raf, addr, DataProperties.EQUIPE_POLICECOULEUR1,j));
					equipe.getTenues()[j].setPoliceCouleur2(getIntFromGame(raf, addr, DataProperties.EQUIPE_POLICECOULEUR2,j));
					equipe.getTenues()[j].setPoliceCouleur3(getIntFromGame(raf, addr, DataProperties.EQUIPE_POLICECOULEUR3,j));
					equipe.getTenues()[j].setPoliceCouleur4(getIntFromGame(raf, addr, DataProperties.EQUIPE_POLICECOULEUR4,j));
					equipe.getTenues()[j].setBrassardCouleur(getIntFromGame(raf, addr, DataProperties.EQUIPE_BRASSARDCOULEUR,j));
				}
				
				addr = DataProperties.EQUIPES_ADDRESS.get(i)[1];
				
				equipe.setFormation(getByteFromGame(raf, addr, DataProperties.EQUIPE_FORMATION, 0));
				equipe.setCapitaine(getByteFromGame(raf, addr, DataProperties.EQUIPE_CAPITAINE,0));
				equipe.setTireurCorner(getByteFromGame(raf, addr, DataProperties.EQUIPE_TIREURCORNER,0));
				
				for(int j=0;j<equipe.getTactiques().length;j++) {
					equipe.getTactiques()[j].setTactique(getIntFromGame(raf, addr, DataProperties.EQUIPE_TACTIQUE,j));
					equipe.getTactiques()[j].setJoueur1(getIntFromGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR1,j));
					equipe.getTactiques()[j].setJoueur2(getIntFromGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR2,j));
					equipe.getTactiques()[j].setJoueur3(getIntFromGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR3,j));
					equipe.getTactiques()[j].setJoueur3(getIntFromGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR4,j));
				}
				
				equipesInGame.add(equipe);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveEquipeIntoGame(Equipe equipe, int inGameIndex) {
		archiveSavedata();
		try {
			Long addr = DataProperties.EQUIPES_ADDRESS.get(inGameIndex)[0];
			
			RandomAccessFile raf = new RandomAccessFile(SystemProperties.PATH, "rw");
			writeTextInGame(raf, addr, DataProperties.EQUIPE_NOM, equipe.getNom());
			writeTextInGame(raf, addr, DataProperties.EQUIPE_ABREVIATION, equipe.getAbreviation());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_FOND,0,equipe.getFond());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_FOND,1,equipe.getFond());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_MOTIFFOND,0,equipe.getMotifFond());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURFOND1,0,equipe.getCouleurFond1());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURFOND1,1,equipe.getCouleurFond1());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURFOND2,0,equipe.getCouleurFond2());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURFOND2,1,equipe.getCouleurFond2());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURFOND3,0,equipe.getCouleurFond3());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURFOND4,0,equipe.getCouleurFond4());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_MILIEU,0,equipe.getMilieu());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURMILIEU1,0,equipe.getCouleurMilieu1());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURMILIEU2,0,equipe.getCouleurMilieu2());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COTE,0,equipe.getCote());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURCOTE1,0,equipe.getCouleurCote1());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURCOTE2,0,equipe.getCouleurCote2());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_HAUT,0,equipe.getHaut());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURHAUT1,0,equipe.getCouleurHaut1());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURHAUT2,0,equipe.getCouleurHaut2());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_BAS,0,equipe.getBas());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURBAS1,0,equipe.getCouleurBas1());
			writeIntInGame(raf, addr, DataProperties.EQUIPE_COULEURBAS2,0,equipe.getCouleurBas2());
			writeMultiIntInGame(raf, addr, DataProperties.EQUIPE_TRIPIECES,equipe.getTriPieces());
			for(int j=0;j<equipe.getTenues().length;j++) {
				writeIntInGame(raf, addr, DataProperties.EQUIPE_MAILLOT,j,equipe.getTenues()[j].getMaillot());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_COL,j,equipe.getTenues()[j].getCol());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR1,j,equipe.getTenues()[j].getMaillotCouleur1());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR2,j,equipe.getTenues()[j].getMaillotCouleur2());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR3,j,equipe.getTenues()[j].getMaillotCouleur3());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR4,j,equipe.getTenues()[j].getMaillotCouleur4());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_SHORT,j,equipe.getTenues()[j].getShortModele());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_SHORTMARQUES,j,equipe.getTenues()[j].getShortMarques());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR1,j,equipe.getTenues()[j].getShortCouleur1());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR2,j,equipe.getTenues()[j].getShortCouleur2());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR3,j,equipe.getTenues()[j].getShortCouleur3());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR4,j,equipe.getTenues()[j].getShortCouleur4());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_CHAUSSETTES,j,equipe.getTenues()[j].getChaussettes());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_CHAUSSETTESCOULEUR1,j,equipe.getTenues()[j].getChaussettesCouleur1());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_CHAUSSETTESCOULEUR2,j,equipe.getTenues()[j].getChaussettesCouleur2());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_CHAUSSETTESCOULEUR3,j,equipe.getTenues()[j].getChaussettesCouleur3());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_CHAUSSETTESCOULEUR4,j,equipe.getTenues()[j].getChaussettesCouleur4());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_POLICE,j,equipe.getTenues()[j].getPolice());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_POLICEBORDURE,j,equipe.getTenues()[j].getPoliceBordure());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_POLICECOULEUR1,j,equipe.getTenues()[j].getPoliceCouleur1());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_POLICECOULEUR2,j,equipe.getTenues()[j].getPoliceCouleur2());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_POLICECOULEUR3,j,equipe.getTenues()[j].getPoliceCouleur3());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_POLICECOULEUR4,j,equipe.getTenues()[j].getPoliceCouleur4());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_BRASSARDCOULEUR,j,equipe.getTenues()[j].getBrassardCouleur());
			}
			
			addr = DataProperties.EQUIPES_ADDRESS.get(inGameIndex)[1];
			
			writeByteInGame(raf, addr, DataProperties.EQUIPE_FORMATION,0,equipe.getFormation());
			writeByteInGame(raf, addr, DataProperties.EQUIPE_CAPITAINE,0,equipe.getCapitaine());
			writeByteInGame(raf, addr, DataProperties.EQUIPE_TIREURCORNER,0,equipe.getTireurCorner());
			
			for(int j=0;j<equipe.getTactiques().length;j++) {
				writeIntInGame(raf, addr, DataProperties.EQUIPE_TACTIQUE,j,equipe.getTactiques()[j].getTactique());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR1,j,equipe.getTactiques()[j].getJoueur1());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR2,j,equipe.getTactiques()[j].getJoueur2());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR3,j,equipe.getTactiques()[j].getJoueur3());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR4,j,equipe.getTactiques()[j].getJoueur4());
			}
			
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getTextFromGame(RandomAccessFile raf, long addr, TextData props) throws Exception {
		String text = "";
		boolean stop = false;
		int nextRead;
		raf.seek(addr + props.getOffset());
		for(int i=0;i<props.getLongueur() && !stop ;i++) {
			nextRead = raf.read();
			stop = nextRead == 0;
			if(!stop) {
				text += (char)nextRead;
			}
		}
		return text;
	}
	
	private int getIntFromGame(RandomAccessFile raf, long addr, SelectData props, int offsetIdex) throws Exception {
		int i = getIntFromGame(raf, addr, props.getOffsets()[offsetIdex]);
		return props.getIndexFromInGameValue(i, props.getDefaut());
	}
	
	private int getIntFromGame(RandomAccessFile raf, long addr, NumericData props, int offsetIdex) throws Exception {
		int i = getIntFromGame(raf, addr, props.getOffsets()[offsetIdex]);
		return i;
	}
	
	private int getIntFromGame(RandomAccessFile raf, Long address, int offset) throws Exception {
		raf.seek(address + offset);
		byte[] bytesVal = new byte[2];
		bytesVal[1]=raf.readByte();
		bytesVal[0]=raf.readByte();
		ByteBuffer wrapped = ByteBuffer.wrap(bytesVal);
		return Short.toUnsignedInt(wrapped.getShort());
	}
	
	private int[] getMultiIntFromGame(RandomAccessFile raf, Long address, MultiSelectData props) throws Exception {
		int[] inGameVals = new int[props.getOffsets().length];
		byte[] bytesVal;
		for(int i=0;i<props.getOffsets().length;i++) {
			raf.seek(address + props.getOffsets()[i]);
			bytesVal = new byte[2];
			bytesVal[1]=raf.readByte();
			bytesVal[0]=raf.readByte();
			ByteBuffer wrapped = ByteBuffer.wrap(bytesVal);
			inGameVals[i] = Short.toUnsignedInt(wrapped.getShort()); 
		}
		int[] vals = new int[props.getDefaut().length];
		int start = 0;
		for(int i=0;i<vals.length;i++) {
			boolean go = true;
			int n = 1;
			int nextVal;
			while(go && start + n <= inGameVals.length) {
				nextVal = props.getIndexFromInGameValue(Arrays.copyOfRange(inGameVals, start, start+n));
				if(nextVal == -1) {
					n++;
				} else {
					vals[i] = nextVal;
					start += n;
					go = false;
				}
			}
		}
		return vals;
	}
	
	private int getByteFromGame(RandomAccessFile raf, long addr, SelectData props, int offsetIdex) throws Exception {
		raf.seek(addr + props.getOffsets()[offsetIdex]);
		byte[] bytesVal = new byte[2];
		bytesVal[1]=raf.readByte();
		bytesVal[0]=0;
		ByteBuffer wrapped = ByteBuffer.wrap(bytesVal);
		return props.getIndexFromInGameValue(Short.toUnsignedInt(wrapped.getShort()), props.getDefaut());
	}
	
	private void writeTextInGame(RandomAccessFile raf, long addr, TextData props, String text) throws Exception {
		raf.seek(addr + props.getOffset());
		for(int i=0;i<props.getLongueur();i++) {
			if(i<text.length()) {
				raf.write(text.charAt(i));
			} else {
				raf.write(0);
			}
		}
	}
	
	private void writeIntInGame(RandomAccessFile raf, long addr, SelectData props, int offsetIdex, int value) throws Exception {
		writeIntInGame(raf, addr, props.getOffsets()[offsetIdex], props.getVals().get(value).getInGameValue());
	}
	
	private void writeIntInGame(RandomAccessFile raf, long addr, NumericData props, int offsetIdex, int value) throws Exception {
		writeIntInGame(raf, addr, props.getOffsets()[offsetIdex], value);
	}
	
	private void writeIntInGame(RandomAccessFile raf, Long address, int offset, int value) throws Exception {
		raf.seek(address + offset);
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(value);
		byte[] bytesValue = {bb.array()[3], bb.array()[2]};
		raf.write(bytesValue);
	}
	
	private void writeMultiIntInGame(RandomAccessFile raf, Long address, MultiSelectData props, int[] value) throws Exception {
		int[] toWrite = props.getInGameValue(value);
		for(int i=0;i<props.getOffsets().length;i++) {
			raf.seek(address + props.getOffsets()[i]);
			ByteBuffer bb = ByteBuffer.allocate(4);
			bb.putInt(toWrite[i]);
			byte[] bytesValue = {bb.array()[3], bb.array()[2]};
			raf.write(bytesValue);
		}
	}
	
	private void writeByteInGame(RandomAccessFile raf, long addr, SelectData props, int offsetIdex, int value) throws Exception {
		raf.seek(addr + props.getOffsets()[offsetIdex]);
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(value);
		raf.write(bb.array()[3]);
	}
	
	private void archiveSavedata() {
	    try {
	    	Path copied = Paths.get("backup/savedata_" + new Date().toString().replace(":", "-"));
	    	Path originalPath = Paths.get(SystemProperties.PATH);
			Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public ArrayList<Joueur> getJoueursInGame() {
		return joueursInGame;
	}
	
	public ArrayList<Equipe> getEquipes() {
		return equipes;
	}

	public ArrayList<Equipe> getEquipesInGame() {
		return equipesInGame;
	}
}
