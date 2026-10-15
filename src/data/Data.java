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

import data.elements.JoueurStar;
import data.elements.Composition;
import data.elements.Equipe;
import data.elements.Joueur;
import data.elements.JoueurAutre;
import data.properties.DataProperties;
import data.properties.GamedataProperties;
import data.properties.SystemProperties;
import data.properties.types.CatData;
import data.properties.types.LongSelectData;
import data.properties.types.MultiSelectData;
import data.properties.types.NumericData;
import data.properties.types.SelectData;
import data.properties.types.TextData;
import main.Launch;

public class Data implements Serializable {

	private static final long serialVersionUID = 6632461413087395187L;


	private ArrayList<Joueur> joueurs;
	private transient ArrayList<Joueur> joueursInGame;

	private ArrayList<Equipe> equipes;
	private transient ArrayList<Equipe> equipesInGame;
	
	private ArrayList<JoueurStar> builds;
	private transient ArrayList<JoueurStar> joueursStarsInGame;
	
	private ArrayList<JoueurAutre> randoms;
	private transient ArrayList<JoueurAutre> joueursAutresInGame;
	
	private ArrayList<Composition> compositions;
	private transient ArrayList<Composition> compositionsInGame;

	public Data() {
		joueurs = new ArrayList<Joueur>();
		joueursInGame = new ArrayList<Joueur>();

		equipes = new ArrayList<Equipe>();
		equipesInGame = new ArrayList<Equipe>();
		
		builds = new ArrayList<JoueurStar>();
		joueursStarsInGame = new ArrayList<JoueurStar>();
		
		randoms = new ArrayList<JoueurAutre>();
		joueursAutresInGame = new ArrayList<JoueurAutre>();
		
		compositions = new ArrayList<Composition>();
		compositionsInGame = new ArrayList<Composition>();
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

	public void supprimerjoueurStar(JoueurStar b) {
		builds.remove(b);
	}

	public JoueurStar nouveauJoueurStar() {
		JoueurStar joueur = new JoueurStar(DataProperties.JOUEUR_NOM.getDefaut(),true);
		builds.add(joueur);
		return joueur;
	}

	public void supprimerJoueurAutre(JoueurAutre r) {
		randoms.remove(r);
	}

	public JoueurAutre nouveauJoueurAutre() {
		JoueurAutre joueur = new JoueurAutre(DataProperties.JOUEUR_NOM.getDefaut(),true);
		randoms.add(joueur);
		return joueur;
	}
	
	public void supprimerComposition(Composition c) {
		compositions.remove(c);
	}

	public Composition nouvelleComposition() {
		Composition c = new Composition(true);
		compositions.add(c);
		return c;
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

	public JoueurStar getJoueurStarParId(String id) {
		JoueurStar joueur = null;
		for(JoueurStar j : builds) {
			if(id.equals(j.getId())) {
				joueur = j;
			}
		}
		return joueur;
	}
	
	public Composition getCompositionParId(String id) {
		Composition composition = null;
		for(Composition c : compositions) {
			if(id.equals(c.getId())) {
				composition = c;
			}
		}
		return composition;
	}
	
	public ArrayList<String> ajouterJoueursAuStock(ArrayList<Joueur> joueurs) {
		ArrayList<String> idAjoutes = new ArrayList<String>();
		for(Joueur joueur : joueurs) {
			joueur.setId(joueur.regenerateId());
			getJoueurs().add(joueur);
			idAjoutes.add(joueur.getId());
		}
		Launch.getInstance().getGui().getJoueursGUI().remplirListesJoueurs(false);
		Launch.getInstance().saveData();
		return idAjoutes;
	}
	
	public ArrayList<String> ajouterJoueurStarAuStock(ArrayList<JoueurStar> joueurs) {
		ArrayList<String> idAjoutes = new ArrayList<String>();
		for(JoueurStar joueur : joueurs) {
			joueur.setId(joueur.regenerateId());
			getJoueursStars().add(joueur);
			idAjoutes.add(joueur.getId());
		}
		Launch.getInstance().getGui().getJoueursStarsGUI().remplirListes(false);
		Launch.getInstance().saveData();
		return idAjoutes;
	}
	
	public ArrayList<String> ajouterJoueurAutreAuStock(ArrayList<JoueurAutre> joueurs) {
		ArrayList<String> idAjoutes = new ArrayList<String>();
		for(JoueurAutre joueur : joueurs) {
			joueur.setId(joueur.regenerateId());
			getJoueursAutres().add(joueur);
			idAjoutes.add(joueur.getId());
		}
		Launch.getInstance().getGui().getJoueursAutresGUI().remplirListes(false);
		Launch.getInstance().saveData();
		return idAjoutes;
	}

	public void loadJoueursFromGame() {
		try  {
			RandomAccessFile raf = new RandomAccessFile(SystemProperties.PATH, "rw");

			joueursInGame.clear();

			Joueur joueur;
			for(int i=0;i<DataProperties.JOUEURSCUSTOM.getNombre();i++) {
				Long addr = DataProperties.JOUEURSCUSTOM.getAdresse(i);

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
				joueur.setArrets(getIntFromGame(raf, addr, DataProperties.ARRETS,0));
				joueur.setSuperArret(getIntFromGame(raf, addr, DataProperties.SUPERARRET,0));
				joueur.setCompetenceCapitaine(getIntFromGame(raf, addr, DataProperties.COMPETENCECAPITAINE,0));
				joueur.setCompetence1(getIntFromGame(raf, addr, DataProperties.COMPETENCES,0));
				joueur.setCompetence2(getIntFromGame(raf, addr, DataProperties.COMPETENCES,1));
				joueur.setCompetence3(getIntFromGame(raf, addr, DataProperties.COMPETENCES,2));
				joueur.setCompetence4(getIntFromGame(raf, addr, DataProperties.COMPETENCES,3));
				joueur.setCompetence5(getIntFromGame(raf, addr, DataProperties.COMPETENCES,4));
				joueur.setCompetence6(getIntFromGame(raf, addr, DataProperties.COMPETENCES,5));
				joueursInGame.add(joueur);
			}
			
			raf.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveIntoGame(Joueur joueur, int inGameIndex) {
		archiveSavedata();
		try {
			Long addr = DataProperties.JOUEURSCUSTOM.getAdresse(inGameIndex);

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
			writeIntInGame(raf, addr, DataProperties.ARRETS,0,joueur.getArrets());
			writeIntInGame(raf, addr, DataProperties.SUPERARRET,0,joueur.getSuperArret());
			writeIntInGame(raf, addr, DataProperties.COMPETENCECAPITAINE,0,joueur.getCompetenceCapitaine());
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
					SelectData maillot;
					SelectData shorts;
					SelectData chaussettes;
					int k;
					if(j == 0 || j== 1) {
						maillot = DataProperties.EQUIPE_MAILLOT;
						shorts = DataProperties.EQUIPE_SHORT;
						chaussettes = DataProperties.EQUIPE_CHAUSSETTES;
						k = j;
					} else {
						maillot = DataProperties.EQUIPE_MAILLOTGK;
						shorts = DataProperties.EQUIPE_SHORTGK;
						chaussettes = DataProperties.EQUIPE_CHAUSSETTESGK;
						k = j-2;
					}
					
					equipe.getTenues()[j].setMaillot(getIntFromGame(raf, addr, maillot,k));
					equipe.getTenues()[j].setCol(getIntFromGame(raf, addr, DataProperties.EQUIPE_COL,j));
					equipe.getTenues()[j].setMaillotCouleur1(getIntFromGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR1,j));
					equipe.getTenues()[j].setMaillotCouleur2(getIntFromGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR2,j));
					equipe.getTenues()[j].setMaillotCouleur3(getIntFromGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR3,j));
					equipe.getTenues()[j].setMaillotCouleur4(getIntFromGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR4,j));
					equipe.getTenues()[j].setShortModele(getIntFromGame(raf, addr, shorts,k));
					equipe.getTenues()[j].setShortMarques(getIntFromGame(raf, addr, DataProperties.EQUIPE_SHORTMARQUES,j));
					equipe.getTenues()[j].setShortCouleur1(getIntFromGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR1,j));
					equipe.getTenues()[j].setShortCouleur2(getIntFromGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR2,j));
					equipe.getTenues()[j].setShortCouleur3(getIntFromGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR3,j));
					equipe.getTenues()[j].setShortCouleur4(getIntFromGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR4,j));
					equipe.getTenues()[j].setChaussettes(getIntFromGame(raf, addr, chaussettes,k));
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
					equipe.getTactiques()[j].setJoueur4(getIntFromGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR4,j));
				}

				for(int j=0;j<equipe.getJoueurs().length;j++) {
					equipe.getJoueurs()[j] = "" + getJoueurIdFromGame(raf, addr, j);
				}

				for(int j=0;j<equipe.getNumeros().length;j++) {
					equipe.getNumeros()[j] = getByteFromGame(raf, addr, DataProperties.EQUIPE_NUMEROS,j);
				}
				
				addr = DataProperties.EQUIPES_ADDRESS.get(i)[2];
				
				for(int j=0;j<equipe.getPlacementY().length;j++) {
					equipe.getPlacementY()[j] = getLongFromGame(raf, addr, DataProperties.EQUIPE_PLACEMENTY,j);
				}
				
				for(int j=0;j<equipe.getPlacementX().length;j++) {
					equipe.getPlacementX()[j] = getLongFromGame(raf, addr, DataProperties.EQUIPE_PLACEMENTX,j);
				}

				equipesInGame.add(equipe);
			}
			
			raf.close();
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
				SelectData maillot;
				SelectData shorts;
				SelectData chaussettes;
				int k;
				if(j == 0 || j== 1) {
					maillot = DataProperties.EQUIPE_MAILLOT;
					shorts = DataProperties.EQUIPE_SHORT;
					chaussettes = DataProperties.EQUIPE_CHAUSSETTES;
					k = j;
				} else {
					maillot = DataProperties.EQUIPE_MAILLOTGK;
					shorts = DataProperties.EQUIPE_SHORTGK;
					chaussettes = DataProperties.EQUIPE_CHAUSSETTESGK;
					k = j-2;
				}
				
				writeIntInGame(raf, addr, maillot,k,equipe.getTenues()[j].getMaillot());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_COL,j,equipe.getTenues()[j].getCol());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR1,j,equipe.getTenues()[j].getMaillotCouleur1());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR2,j,equipe.getTenues()[j].getMaillotCouleur2());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR3,j,equipe.getTenues()[j].getMaillotCouleur3());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_MAILLOTCOULEUR4,j,equipe.getTenues()[j].getMaillotCouleur4());
				writeIntInGame(raf, addr, shorts,k,equipe.getTenues()[j].getShortModele());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_SHORTMARQUES,j,equipe.getTenues()[j].getShortMarques());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR1,j,equipe.getTenues()[j].getShortCouleur1());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR2,j,equipe.getTenues()[j].getShortCouleur2());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR3,j,equipe.getTenues()[j].getShortCouleur3());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_SHORTCOULEUR4,j,equipe.getTenues()[j].getShortCouleur4());
				writeIntInGame(raf, addr, chaussettes,k,equipe.getTenues()[j].getChaussettes());
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

			for(int j=0;j<equipe.getJoueurs().length;j++) {
				writeJoueurIdInGame(raf, addr, j, equipe.getJoueurs()[j]);
			}
			
			for(int j=0;j<equipe.getNumeros().length;j++) {
				writeByteInGame(raf, addr, DataProperties.EQUIPE_NUMEROS,j,equipe.getNumeros()[j]);
			}
			
			addr = DataProperties.EQUIPES_ADDRESS.get(inGameIndex)[2];
			
			for(int j=0;j<equipe.getPlacementY().length;j++) {
				writeLongInGame(raf, addr, DataProperties.EQUIPE_PLACEMENTY,j,equipe.getPlacementY()[j]);
			}
			
			for(int j=0;j<equipe.getPlacementX().length;j++) {
				writeLongInGame(raf, addr, DataProperties.EQUIPE_PLACEMENTX,j,equipe.getPlacementX()[j]);
			}

			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadJoueursStarsFromGame() {
		try  {
			RandomAccessFile save = new RandomAccessFile(SystemProperties.PATH, "rw");
			RandomAccessFile cpd = new RandomAccessFile(SystemProperties.CHARPARAMDATA_PATH, "rw");

			joueursStarsInGame.clear();

			JoueurStar joueur;
			int index;
			for(int i=0;i<DataProperties.JOUEURSBASEEDITABLES + DataProperties.JOUEURSETOILENOMBRE;i++) {
				index = i;
				if(i >= DataProperties.JOUEURSBASEEDITABLES) {
					index = i + DataProperties.JOUEURSETOILEOFFSET - DataProperties.JOUEURSBASEEDITABLES;
				}
				Long saveAddr = DataProperties.JOUEURSBASE.getAdresse(i);
				Long cpdAddr = GamedataProperties.CPD_JOUEURSBASE.getAdresse(i);

				joueur = new JoueurStar(DataProperties.JOUEURSBASE.getVals().get(index).getDisplayValue(),false);				
				joueur.setAttaque(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,0));
				joueur.setDefense(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,1));
				joueur.setPuissance(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,2));
				joueur.setVitesse(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,3));
				joueur.setTechnique(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,4));
				joueur.setPosition(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_POSITION,0));
				joueur.setTir(getIntFromGame(save, saveAddr, DataProperties.TIRS,0));
				joueur.setTirAlt(getIntFromGame(save, saveAddr, DataProperties.TIRS,1));
				joueur.setTirAerien(getIntFromGame(save, saveAddr, DataProperties.TIRSAERIENS,0));
				joueur.setSuperTir(getIntFromGame(save, saveAddr, DataProperties.SUPERTIRS,0));
				joueur.setSuperTirAlt(getIntFromGame(save, saveAddr, DataProperties.SUPERTIRS,1));
				joueur.setDribble1(getIntFromGame(save, saveAddr, DataProperties.DRIBBLES,0));
				joueur.setDribble2(getIntFromGame(save, saveAddr, DataProperties.DRIBBLES,1));
				joueur.setPasse(getIntFromGame(save, saveAddr, DataProperties.PASSES,0));
				joueur.setTirCombo1(getIntFromGame(save, saveAddr, DataProperties.TIRSCOMBO1,0));
				joueur.setTirCombo2(getIntFromGame(save, saveAddr, DataProperties.TIRSCOMBO2,0));
				joueur.setPassesCombo(getIntFromGame(save, saveAddr, DataProperties.PASSESCOMBO,0));
				joueur.setTacle1(getIntFromGame(save, saveAddr, DataProperties.TACLES,0));
				joueur.setTacle2(getIntFromGame(save, saveAddr, DataProperties.TACLES,1));
				joueur.setBlocage(getIntFromGame(save, saveAddr, DataProperties.BLOCAGES,0));
				joueur.setArrets(getIntFromGame(save, saveAddr, DataProperties.ARRETS,0));
				joueur.setSuperArret(getIntFromGame(save, saveAddr, DataProperties.SUPERARRET,0));
				joueur.setCompetenceCapitaine(getIntFromGame(save, saveAddr, DataProperties.COMPETENCECAPITAINE,0));
				joueur.setCompetence1(getIntFromGame(save, saveAddr, DataProperties.COMPETENCES,0));
				joueur.setCompetence2(getIntFromGame(save, saveAddr, DataProperties.COMPETENCES,1));
				joueur.setCompetence3(getIntFromGame(save, saveAddr, DataProperties.COMPETENCES,2));
				joueur.setCompetence4(getIntFromGame(save, saveAddr, DataProperties.COMPETENCES,3));
				joueur.setCompetence5(getIntFromGame(save, saveAddr, DataProperties.COMPETENCES,4));
				joueur.setCompetence6(getIntFromGame(save, saveAddr, DataProperties.COMPETENCES,5));
				joueursStarsInGame.add(joueur);
			}
			
			save.close();
			cpd.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveJoueurStarIntoGame(JoueurStar joueur, int inGameIndex) {
		archiveSavedata();
		archiveCharParamData();
		
		try {
			Long saveAddr = DataProperties.JOUEURSBASE.getAdresse(inGameIndex);
			Long cpdAddr = GamedataProperties.CPD_JOUEURSBASE.getAdresse(inGameIndex);

			RandomAccessFile save = new RandomAccessFile(SystemProperties.PATH, "rw");
			RandomAccessFile cpd = new RandomAccessFile(SystemProperties.CHARPARAMDATA_PATH, "rw");
			
			writeIntInGame(save, saveAddr, DataProperties.STAT,0,joueur.getAttaque());
			writeIntInGame(save, saveAddr, DataProperties.STAT,1,joueur.getDefense());
			writeIntInGame(save, saveAddr, DataProperties.STAT,2,joueur.getPuissance());
			writeIntInGame(save, saveAddr, DataProperties.STAT,3,joueur.getVitesse());
			writeIntInGame(save, saveAddr, DataProperties.STAT,4,joueur.getTechnique());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,0,joueur.getAttaque());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,1,joueur.getDefense());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,2,joueur.getPuissance());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,3,joueur.getVitesse());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,4,joueur.getTechnique());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_POSITION,0,joueur.getPosition());
			
			writeIntInGame(save, saveAddr, DataProperties.TIRS,0,joueur.getTir());
			writeIntInGame(save, saveAddr, DataProperties.TIRS,1,joueur.getTirAlt());
			writeIntInGame(save, saveAddr, DataProperties.TIRSAERIENS,0,joueur.getTirAerien());
			writeIntInGame(save, saveAddr, DataProperties.SUPERTIRS,0,joueur.getSuperTir());
			writeIntInGame(save, saveAddr, DataProperties.SUPERTIRS,1,joueur.getSuperTirAlt());
			writeIntInGame(save, saveAddr, DataProperties.DRIBBLES,0,joueur.getDribble1());
			writeIntInGame(save, saveAddr, DataProperties.DRIBBLES,1,joueur.getDribble2());
			writeIntInGame(save, saveAddr, DataProperties.PASSES,0,joueur.getPasse());
			writeIntInGame(save, saveAddr, DataProperties.TIRSCOMBO1,0,joueur.getTirCombo1());
			writeIntInGame(save, saveAddr, DataProperties.TIRSCOMBO2,0,joueur.getTirCombo2());
			writeIntInGame(save, saveAddr, DataProperties.PASSESCOMBO,0,joueur.getPassesCombo());
			writeIntInGame(save, saveAddr, DataProperties.TACLES,0,joueur.getTacle1());
			writeIntInGame(save, saveAddr, DataProperties.TACLES,1,joueur.getTacle2());
			writeIntInGame(save, saveAddr, DataProperties.BLOCAGES,0,joueur.getBlocage());
			writeIntInGame(save, saveAddr, DataProperties.ARRETS,0,joueur.getArrets());
			writeIntInGame(save, saveAddr, DataProperties.SUPERARRET,0,joueur.getSuperArret());
			writeIntInGame(save, saveAddr, DataProperties.COMPETENCECAPITAINE,0,joueur.getCompetenceCapitaine());
			writeIntInGame(save, saveAddr, DataProperties.COMPETENCES,0,joueur.getCompetence1());
			writeIntInGame(save, saveAddr, DataProperties.COMPETENCES,1,joueur.getCompetence2());
			writeIntInGame(save, saveAddr, DataProperties.COMPETENCES,2,joueur.getCompetence3());
			writeIntInGame(save, saveAddr, DataProperties.COMPETENCES,3,joueur.getCompetence4());
			writeIntInGame(save, saveAddr, DataProperties.COMPETENCES,4,joueur.getCompetence5());
			writeIntInGame(save, saveAddr, DataProperties.COMPETENCES,5,joueur.getCompetence6());
			
			save.close();
			cpd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadJoueursAutresFromGame() {
		try  {
			RandomAccessFile cp = new RandomAccessFile(SystemProperties.CUSTOMPRESET_PATH, "rw");
			RandomAccessFile cpd = new RandomAccessFile(SystemProperties.CHARPARAMDATA_PATH, "rw");
			RandomAccessFile cd = new RandomAccessFile(SystemProperties.CHARACTORDATA_PATH, "rw");
			int index;

			joueursAutresInGame.clear();

					
			JoueurAutre joueur;
			//Démarrer à 1 à cause du préset des NH
			for(int i=1;i<GamedataProperties.CP_JOUEURSBASE.getNombre();i++) {
				index = DataProperties.JOUEURSBASEEDITABLES + DataProperties.JOUEURSETOILENOMBRE + i - 1;
				Long cpAddr = GamedataProperties.CP_JOUEURSBASE.getAdresse(i);
				Long cpdAddr = GamedataProperties.CPD_JOUEURSBASE.getAdresse(index);

				joueur = new JoueurAutre(GamedataProperties.CP_JOUEURSBASE.getVals().get(i).getDisplayValue(),false);
				joueur.setTypeCorps(getLongFromGame(cp, cpAddr, GamedataProperties.CP_TYPECORPS,0));
				//joueur.setTaille(getLongFromGame(cp, addr, GamedataProperties.CP_TAILLE,0));
				//joueur.setTailleTete(getLongFromGame(cp, addr, GamedataProperties.CP_TAILLETETE,0));
				joueur.setCouleurPeau(getLongFromGame(cp, cpAddr, GamedataProperties.CP_COULEURPEAU,0));
				joueur.setVisage(getLongFromGame(cp, cpAddr, GamedataProperties.CP_VISAGE,0));
				joueur.setCheveux(getLongFromGame(cp, cpAddr, GamedataProperties.CP_CHEVEUX,0));
				joueur.setCouleurCheveux(getLongFromGame(cp, cpAddr, GamedataProperties.CP_COULEURCHEVEUX,0));
				joueur.setYeux(getLongFromGame(cp, cpAddr, GamedataProperties.CP_YEUX,0));
				joueur.setCouleurYeux(getLongFromGame(cp, cpAddr, GamedataProperties.CP_COULEURYEUX,0));
				joueur.setSourcils(getLongFromGame(cp, cpAddr, GamedataProperties.CP_SOURCILS,0));
				joueur.setCouleurSourcils(getLongFromGame(cp, cpAddr, GamedataProperties.CP_COULEURSOURCILS,0));
				joueur.setNez(getLongFromGame(cp, cpAddr, GamedataProperties.CP_NEZ,0));
				joueur.setLunettes(getLongFromGame(cp, cpAddr, GamedataProperties.CP_LUNETTES,0));
				joueur.setCouleurLunettes(getLongFromGame(cp, cpAddr, GamedataProperties.CP_COULEURLUNETTES,0));
				joueur.setCrampons(getLongFromGame(cp, cpAddr, GamedataProperties.CP_CRAMPONS,0));
				
				joueur.setPosition(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_POSITION,0));
				joueur.setAttaque(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,0));
				joueur.setDefense(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,1));
				joueur.setPuissance(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,2));
				joueur.setVitesse(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,3));
				joueur.setTechnique(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,4));
				
				joueur.setTir(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_TIRS,0));
				joueur.setTirAlt(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_TIRS,1));
				joueur.setTirAerien(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_TIRSAERIENS,0));
				joueur.setSuperTir(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_SUPERTIRS,0));
				joueur.setSuperTirAlt(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_SUPERTIRS,1));
				joueur.setDribble1(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_DRIBBLES,0));
				joueur.setDribble2(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_DRIBBLES,1));
				joueur.setPasse(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_PASSES,0));
				joueur.setTirCombo1(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_TIRSCOMBO1,0));
				joueur.setTirCombo2(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_TIRSCOMBO2,0));
				joueur.setPassesCombo(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_PASSESCOMBO,0));
				joueur.setTacle1(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_TACLES,0));
				joueur.setTacle2(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_TACLES,1));
				joueur.setBlocage(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_BLOCAGES,0));
				joueur.setArrets(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_ARRETS,0));
				joueur.setSuperArret(getIntFromGame(cpd, cpdAddr, GamedataProperties.CPD_SUPERARRET,0));
				
				if(GamedataProperties.CD_CAT.getTailles().get(index) >= 12 ) {
					joueur.setCompetence1(getLongFromGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCES,0));
				}
				if(GamedataProperties.CD_CAT.getTailles().get(index) >= 16 ) {
					joueur.setCompetence2(getLongFromGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCES,1));
				}
				if(GamedataProperties.CD_CAT.getTailles().get(index) >= 20 ) {
					joueur.setCompetence3(getLongFromGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCES,2));
				}
				if(GamedataProperties.CD_CAT.getTailles().get(index) >= 24 ) {
					joueur.setCompetence4(getLongFromGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCES,3));
				}
				if(GamedataProperties.CD_CAT.getTailles().get(index) >= 32 ) {
					joueur.setCompetence5(getLongFromGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCES,4));
				}
				if(GamedataProperties.CD_CAT.getTailles().get(index) >= 36 ) {
					joueur.setCompetence6(getLongFromGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCES,5));
				}
				if(GamedataProperties.CD_CAT.getTailles().get(index) >= 40 ) {
					joueur.setCompetenceCapitaine(getLongFromGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCECAPITAINE,0));
				}
				
				joueursAutresInGame.add(joueur);
			}

			cp.close();
			cpd.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveJoueurAutreIntoGame(JoueurAutre joueur, int inGameIndex) {
		archiveCustomPreset();
		archiveCharParamData();
		archiveCharactorData();
		
		try {
			//+1 à cause du preset de NH 
			int index = DataProperties.JOUEURSBASEEDITABLES + DataProperties.JOUEURSETOILENOMBRE + inGameIndex;
			Long cpAddr = GamedataProperties.CP_JOUEURSBASE.getAdresse(inGameIndex+1);
			Long cpdAddr = GamedataProperties.CPD_JOUEURSBASE.getAdresse(index);
			RandomAccessFile cp = new RandomAccessFile(SystemProperties.CUSTOMPRESET_PATH, "rw");
			RandomAccessFile cpd = new RandomAccessFile(SystemProperties.CHARPARAMDATA_PATH, "rw");
			RandomAccessFile cd = new RandomAccessFile(SystemProperties.CHARACTORDATA_PATH, "rw");

			writeLongInGame(cp, cpAddr, GamedataProperties.CP_TYPECORPS,0,joueur.getTypeCorps());
			//writeLongInGame(cp, addr, GamedataProperties.CP_TAILLE,0,joueur.getTaille());
			//writeLongInGame(cp, addr, GamedataProperties.CP_TAILLETETE,0,joueur.getTailleTete());
			writeLongInGame(cp, cpAddr, GamedataProperties.CP_COULEURPEAU,0,joueur.getCouleurPeau());
			writeLongInGame(cp, cpAddr, GamedataProperties.CP_VISAGE,0,joueur.getVisage());
			writeLongInGame(cp, cpAddr, GamedataProperties.CP_CHEVEUX,0,joueur.getCheveux());
			writeLongInGame(cp, cpAddr, GamedataProperties.CP_COULEURCHEVEUX,0,joueur.getCouleurCheveux());
			writeLongInGame(cp, cpAddr, GamedataProperties.CP_YEUX,0,joueur.getYeux());
			writeLongInGame(cp, cpAddr, GamedataProperties.CP_COULEURYEUX,0,joueur.getCouleurYeux());
			writeLongInGame(cp, cpAddr, GamedataProperties.CP_SOURCILS,0,joueur.getSourcils());
			writeLongInGame(cp, cpAddr, GamedataProperties.CP_COULEURSOURCILS,0,joueur.getCouleurSourcils());
			writeLongInGame(cp, cpAddr, GamedataProperties.CP_NEZ,0,joueur.getNez());
			writeLongInGame(cp, cpAddr, GamedataProperties.CP_LUNETTES,0,joueur.getLunettes());
			writeLongInGame(cp, cpAddr, GamedataProperties.CP_COULEURLUNETTES,0,joueur.getCouleurLunettes());
			writeLongInGame(cp, cpAddr, GamedataProperties.CP_CRAMPONS,0,joueur.getCrampons());
			
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,0,joueur.getAttaque());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,1,joueur.getDefense());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,2,joueur.getPuissance());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,3,joueur.getVitesse());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_STAT,4,joueur.getTechnique());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_POSITION,0,joueur.getPosition());
			
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_TIRS,0,joueur.getTir());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_TIRS,1,joueur.getTirAlt());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_TIRSAERIENS,0,joueur.getTirAerien());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_SUPERTIRS,0,joueur.getSuperTir());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_SUPERTIRS,1,joueur.getSuperTirAlt());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_DRIBBLES,0,joueur.getDribble1());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_DRIBBLES,1,joueur.getDribble2());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_PASSES,0,joueur.getPasse());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_TIRSCOMBO1,0,joueur.getTirCombo1());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_TIRSCOMBO2,0,joueur.getTirCombo2());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_PASSESCOMBO,0,joueur.getPassesCombo());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_TACLES,0,joueur.getTacle1());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_TACLES,1,joueur.getTacle2());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_BLOCAGES,0,joueur.getBlocage());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_ARRETS,0,joueur.getArrets());
			writeIntInGame(cpd, cpdAddr, GamedataProperties.CPD_SUPERARRET,0,joueur.getSuperArret());
			
			
			writeLongInGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCES,0,joueur.getCompetence1());
			writeLongInGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCES,1,joueur.getCompetence2());
			writeLongInGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCES,2,joueur.getCompetence3());
			writeLongInGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCES,3,joueur.getCompetence4());
			writeLongInGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCES,4,joueur.getCompetence5());
			writeLongInGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCES,5,joueur.getCompetence6());
			writeLongInGame(cd, GamedataProperties.CD_CAT, index, GamedataProperties.CD_COMPETENCECAPITAINE,0,joueur.getCompetenceCapitaine());
			
			cp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void loadCompositionsFromGame() {
		try  {
			RandomAccessFile raf = new RandomAccessFile(SystemProperties.PATH, "rw");

			compositionsInGame.clear();

			Composition composition;
			for(int i=0;i<DataProperties.EQUIPESBASE.getNombre();i++) {
				Long addr = DataProperties.EQUIPESBASE.getAdresse(i);

				composition = new Composition(false);
				composition.setNom(DataProperties.EQUIPESBASE.getVals().get(i).getDisplayValue());

				composition.setFormation(getByteFromGame(raf, addr, DataProperties.EQUIPE_FORMATION, 0));
				composition.setCapitaine(getByteFromGame(raf, addr, DataProperties.EQUIPE_CAPITAINE,0));
				composition.setTireurCorner(getByteFromGame(raf, addr, DataProperties.EQUIPE_TIREURCORNER,0));

				for(int j=0;j<composition.getTactiques().length;j++) {
					composition.getTactiques()[j].setTactique(getIntFromGame(raf, addr, DataProperties.EQUIPE_TACTIQUE,j));
					composition.getTactiques()[j].setJoueur1(getIntFromGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR1,j));
					composition.getTactiques()[j].setJoueur2(getIntFromGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR2,j));
					composition.getTactiques()[j].setJoueur3(getIntFromGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR3,j));
					composition.getTactiques()[j].setJoueur4(getIntFromGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR4,j));
				}

				for(int j=0;j<composition.getJoueurs().length;j++) {
					composition.getJoueurs()[j] = "" + getJoueurIdFromGame(raf, addr, j);
				}

				for(int j=0;j<composition.getNumeros().length;j++) {
					composition.getNumeros()[j] = getByteFromGame(raf, addr, DataProperties.EQUIPE_NUMEROS,j);
				}
				
				
				addr = DataProperties.EQUIPESBASEPLACEMENT.getAdresse(i);
				
				for(int j=0;j<composition.getPlacementY().length;j++) {
					composition.getPlacementY()[j] = getLongFromGame(raf, addr, DataProperties.EQUIPE_PLACEMENTY,j);
				}
				
				for(int j=0;j<composition.getPlacementX().length;j++) {
					composition.getPlacementX()[j] = getLongFromGame(raf, addr, DataProperties.EQUIPE_PLACEMENTX,j);
				}

				compositionsInGame.add(composition);
			}
			
			raf.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveCompositionIntoGame(Composition composition, int inGameIndex) {
		archiveSavedata();
		try {
			Long addr = DataProperties.EQUIPESBASE.getAdresse(inGameIndex);

			RandomAccessFile raf = new RandomAccessFile(SystemProperties.PATH, "rw");

			writeByteInGame(raf, addr, DataProperties.EQUIPE_FORMATION,0,composition.getFormation());
			writeByteInGame(raf, addr, DataProperties.EQUIPE_CAPITAINE,0,composition.getCapitaine());
			writeByteInGame(raf, addr, DataProperties.EQUIPE_TIREURCORNER,0,composition.getTireurCorner());

			for(int j=0;j<composition.getTactiques().length;j++) {
				writeIntInGame(raf, addr, DataProperties.EQUIPE_TACTIQUE,j,composition.getTactiques()[j].getTactique());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR1,j,composition.getTactiques()[j].getJoueur1());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR2,j,composition.getTactiques()[j].getJoueur2());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR3,j,composition.getTactiques()[j].getJoueur3());
				writeIntInGame(raf, addr, DataProperties.EQUIPE_TACTIQUEJOUEUR4,j,composition.getTactiques()[j].getJoueur4());
			}

			for(int j=0;j<composition.getJoueurs().length;j++) {
				writeJoueurIdInGame(raf, addr, j, composition.getJoueurs()[j]);
			}
			
			for(int j=0;j<composition.getNumeros().length;j++) {
				writeByteInGame(raf, addr, DataProperties.EQUIPE_NUMEROS,j,composition.getNumeros()[j]);
			}
			
			
			addr = DataProperties.EQUIPESBASEPLACEMENT.getAdresse(inGameIndex);
			
			for(int j=0;j<composition.getPlacementY().length;j++) {
				writeLongInGame(raf, addr, DataProperties.EQUIPE_PLACEMENTY,j,composition.getPlacementY()[j]);
			}
			
			for(int j=0;j<composition.getPlacementX().length;j++) {
				writeLongInGame(raf, addr, DataProperties.EQUIPE_PLACEMENTX,j,composition.getPlacementX()[j]);
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

	private int getIntFromGame(RandomAccessFile raf, long addr, SelectData props, int offsetIndex) throws Exception {
		int i = getIntFromGame(raf, addr, props.getOffsets()[offsetIndex]);
		return props.getIndexFromInGameValue(i, props.getDefaut());
	}

	private int getIntFromGame(RandomAccessFile raf, long addr, NumericData props, int offsetIndex) throws Exception {
		int i = getIntFromGame(raf, addr, props.getOffsets()[offsetIndex]);
		return i;
	}

	private String getJoueurIdFromGame(RandomAccessFile raf, long addr, int offsetIndex) throws Exception {
		int i = getIntFromGame(raf, addr, DataProperties.EQUIPE_JOUEURS.getOffsets()[offsetIndex]);
		return getJoueurId(i);
	}

	public String getJoueurId(int i) {
		int val = DataProperties.JOUEURSBASE.getIndexFromInGameValue(""+i, -1);
		String res = null;
		if(val == -1) {
			i = DataProperties.JOUEURSCUSTOM.getIndexFromInGameValue(""+i, DataProperties.EQUIPE_JOUEURS.getDefaut());
			Joueur j = getJoueursInGame().get(i);
			int indexInStock = Launch.getInstance().getData().getJoueurs().indexOf(j);
			if(indexInStock == -1) {
				res = "NH-" + i; 
			} else {
				j = Launch.getInstance().getData().getJoueurs().get(indexInStock);
				res = j.getId();
			}
		} else {
			res = "" + val;
		}
		return res;
	}
	
	private int getLongFromGame(RandomAccessFile raf, long addr, LongSelectData props, int offsetIndex) throws Exception {
		long i = getLongFromGame(raf, addr, props.getOffsets()[offsetIndex]);
		return props.getIndexFromInGameValue(i, props.getDefaut());
	}
	
	private int getLongFromGame(RandomAccessFile raf, CatData cat, int catIndex, LongSelectData props, int offsetIndex) throws Exception {
		long i = getLongFromGame(raf, cat.getAdresses().get(catIndex), cat.getOffset() + props.getOffsets()[offsetIndex]);
		int result = props.getDefaut();
		if(props.getOffsets()[offsetIndex] < cat.getTailles().get(catIndex) - 4) {
			result = props.getIndexFromInGameValue(i, props.getDefaut());
		}
		return result;
	}
	
	private int getIntFromGame(RandomAccessFile raf, Long address, int offset) throws Exception {
		raf.seek(address + offset);
		byte[] bytesVal = new byte[2];
		bytesVal[1]=raf.readByte();
		bytesVal[0]=raf.readByte();
		ByteBuffer wrapped = ByteBuffer.wrap(bytesVal);
		return Short.toUnsignedInt(wrapped.getShort());
	}
	
	private long getLongFromGame(RandomAccessFile raf, Long address, int offset) throws Exception {
		raf.seek(address + offset);
		byte[] bytesVal = new byte[8];
		bytesVal[7]=raf.readByte();
		bytesVal[6]=raf.readByte();
		bytesVal[5]=raf.readByte();
		bytesVal[4]=raf.readByte();
		bytesVal[3]=0;
		bytesVal[2]=0;
		bytesVal[1]=0;
		bytesVal[0]=0;
		ByteBuffer wrapped = ByteBuffer.wrap(bytesVal);
		return wrapped.getLong();
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

	private int getByteFromGame(RandomAccessFile raf, long addr, SelectData props, int offsetIndex) throws Exception {
		raf.seek(addr + props.getOffsets()[offsetIndex]);
		byte[] bytesVal = new byte[2];
		bytesVal[1]=raf.readByte();
		bytesVal[0]=0;
		ByteBuffer wrapped = ByteBuffer.wrap(bytesVal);
		return props.getIndexFromInGameValue(Short.toUnsignedInt(wrapped.getShort()), props.getDefaut());
	}
	
	private int getLongFromGame(RandomAccessFile raf, long addr, NumericData props, int offsetIndex) throws Exception {
		raf.seek(addr + props.getOffsets()[offsetIndex]);
		byte[] bytesVal = new byte[4];
		bytesVal[3]=raf.readByte();
		bytesVal[2]=raf.readByte();
		bytesVal[1]=raf.readByte();
		bytesVal[0]=raf.readByte();
		ByteBuffer wrapped = ByteBuffer.wrap(bytesVal);
		return wrapped.getInt();
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

	private void writeIntInGame(RandomAccessFile raf, long addr, SelectData props, int offsetIndex, int value) throws Exception {
		writeIntInGame(raf, addr, props.getOffsets()[offsetIndex], props.getVals().get(value).getInGameValue());
	}

	private void writeIntInGame(RandomAccessFile raf, long addr, NumericData props, int offsetIndex, int value) throws Exception {
		writeIntInGame(raf, addr, props.getOffsets()[offsetIndex], value);
	}

	private void writeJoueurIdInGame(RandomAccessFile raf, long addr, int offsetIndex, String value) throws Exception {
		int index;
		int intValue;
		if(value.startsWith("NH-")) {
			index = Integer.parseInt(value.split("-")[1]);
			intValue = Integer.parseInt(DataProperties.JOUEURSCUSTOM.getVals().get(index).getInGameValue());
		} else {
			index = Integer.parseInt(value);
			intValue = Integer.parseInt(DataProperties.JOUEURSBASE.getVals().get(index).getInGameValue());
		}
		writeIntInGame(raf, addr, DataProperties.EQUIPE_JOUEURS.getOffsets()[offsetIndex], intValue);
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

	private void writeByteInGame(RandomAccessFile raf, long addr, SelectData props, int offsetIndex, int value) throws Exception {
		raf.seek(addr + props.getOffsets()[offsetIndex]);
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(props.getVals().get(value).getInGameValue());
		raf.write(bb.array()[3]);
	}
	
	private void writeLongInGame(RandomAccessFile raf, long addr, LongSelectData props, int offsetIndex, int value) throws Exception {
		writeLongInGame(raf, addr, props.getOffsets()[offsetIndex], props.getVals().get(value).getInGameValue());
	}
	
	private void writeLongInGame(RandomAccessFile raf, long addr, NumericData props, int offsetIndex, int value) throws Exception {
		raf.seek(addr + props.getOffsets()[offsetIndex]);
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(value);
		byte[] bytesValue = {bb.array()[3], bb.array()[2], bb.array()[1], bb.array()[0]};
		raf.write(bytesValue);
		
	}

	private void writeLongInGame(RandomAccessFile raf, CatData cat, int catIndex, LongSelectData props, int offsetIndex, int value) throws Exception {
		raf.seek(cat.getAdresses().get(catIndex) + cat.getOffset() + props.getOffsets()[offsetIndex]);
		ByteBuffer bb = ByteBuffer.allocate(8);
		bb.putLong(props.getVals().get(value).getInGameValue());
		byte[] bytesValue = {bb.array()[7], bb.array()[6], bb.array()[5], bb.array()[4]};
		if(props.getOffsets()[offsetIndex] <= cat.getTailles().get(catIndex) - 8) {
			raf.write(bytesValue);
		}	
	}
	
	private void writeLongInGame(RandomAccessFile raf, Long address, int offset, long value) throws Exception {
		raf.seek(address + offset);
		ByteBuffer bb = ByteBuffer.allocate(8);
		bb.putLong(value);
		byte[] bytesValue = {bb.array()[7], bb.array()[6], bb.array()[5], bb.array()[4]};
		raf.write(bytesValue);
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
	
	private void archiveCharParamData() {
		try {
			Path copied = Paths.get("backup/binary/CharactorParam/CharParamData_" + new Date().toString().replace(":", "-"));
			Path originalPath = Paths.get(SystemProperties.CHARPARAMDATA_PATH);
			Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void archiveCharactorData() {
		try {
			Path copied = Paths.get("backup/binary/CharactorParam/CharactorData_" + new Date().toString().replace(":", "-"));
			Path originalPath = Paths.get(SystemProperties.CHARACTORDATA_PATH);
			Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void archiveCustomPreset() {
		try {
			Path copied = Paths.get("backup/binary/CharaEdit/CustomPreset_" + new Date().toString().replace(":", "-"));
			Path originalPath = Paths.get(SystemProperties.CUSTOMPRESET_PATH);
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
	
	public ArrayList<JoueurStar> getJoueursStars() {
		return builds;
	}

	public ArrayList<JoueurStar> getJoueursStarsInGame() {
		return joueursStarsInGame;
	}
	
	public ArrayList<JoueurAutre> getJoueursAutres() {
		return randoms;
	}

	public ArrayList<JoueurAutre> getJoueursAutresInGame() {
		return joueursAutresInGame;
	}

	public ArrayList<Composition> getCompositions() {
		return compositions;
	}

	public ArrayList<Composition> getCompositionsInGame() {
		return compositionsInGame;
	}
}
