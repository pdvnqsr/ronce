package data.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import data.properties.types.IncrementalData;
import data.properties.types.MultiSelectData;
import data.properties.types.NumericData;
import data.properties.types.SelectData;
import data.properties.types.SideData;
import data.properties.types.TextData;

public class DataProperties {
	public static TextData JOUEUR_NOM;
	
	public static SelectData POSITION;
	
	public static SelectData TYPECORPS;
	public static NumericData TAILLE;
	public static NumericData TAILLETETE;
	public static SelectData COULEURPEAU;
	public static SelectData STYLEMANCHE;
	public static SelectData VISAGE;
	public static NumericData TAILLEBOUCHE;
	public static NumericData COMMISSURES;
	public static NumericData POSITIONBOUCHE;
	public static SelectData CHEVEUX;
	public static SelectData COULEURCHEVEUX;
	public static SelectData YEUX;
	public static NumericData TAILLEYEUX;
	public static NumericData POSITIONYEUX;
	public static NumericData ESPACEMENTYEUX;
	public static NumericData TAILLEPUPILLES;
	public static SelectData COULEURYEUX;
	public static SelectData SOURCILS;
	public static SelectData COULEURSOURCILS;
	public static SelectData NEZ;
	public static NumericData POSITIONNEZ;
	public static NumericData TAILLENEZ;
	public static SelectData CRAMPONS;
	public static SelectData VOIX;
	public static SelectData LUNETTES;
	public static SelectData COULEURLUNETTES;
	
	public static SelectData CELEBRATION;
	
	public static NumericData STAT;
	
	public static SelectData TIRS;
	public static SelectData TIRSAERIENS;
	public static SelectData SUPERTIRS;
	public static SelectData DRIBBLES;
	public static SelectData PASSES;
	public static SelectData TIRSCOMBO1;
	public static SelectData TIRSCOMBO2;
	public static SelectData PASSESCOMBO;
	public static SelectData TACLES;
	public static SelectData BLOCAGES;
	
	public static SelectData COMPETECESCAPITAINE;
	public static SelectData COMPETENCES;
	
	
	public static ArrayList<Long[]> EQUIPES_ADDRESS;
	public static TextData EQUIPE_NOM;
	public static TextData EQUIPE_ABREVIATION;
	
	public static SelectData EQUIPE_FOND;
	public static SelectData EQUIPE_MOTIFFOND;
	public static SelectData EQUIPE_COULEURFOND1;
	public static SelectData EQUIPE_COULEURFOND2;
	public static SelectData EQUIPE_COULEURFOND3;
	public static SelectData EQUIPE_COULEURFOND4;
	public static SelectData EQUIPE_MILIEU;
	public static SelectData EQUIPE_COULEURMILIEU1;
	public static SelectData EQUIPE_COULEURMILIEU2;
	public static SelectData EQUIPE_COTE;
	public static SelectData EQUIPE_COULEURCOTE1;
	public static SelectData EQUIPE_COULEURCOTE2;
	public static SelectData EQUIPE_HAUT;
	public static SelectData EQUIPE_COULEURHAUT1;
	public static SelectData EQUIPE_COULEURHAUT2;
	public static SelectData EQUIPE_BAS;
	public static SelectData EQUIPE_COULEURBAS1;
	public static SelectData EQUIPE_COULEURBAS2;
	public static MultiSelectData EQUIPE_TRIPIECES;
	
	public static SelectData EQUIPE_MAILLOT;
	public static SelectData EQUIPE_MAILLOTGK;
	public static SelectData EQUIPE_COL;
	public static SelectData EQUIPE_MAILLOTCOULEUR1;
	public static SelectData EQUIPE_MAILLOTCOULEUR2;
	public static SelectData EQUIPE_MAILLOTCOULEUR3;
	public static SelectData EQUIPE_MAILLOTCOULEUR4;
	public static SelectData EQUIPE_SHORT;
	public static SelectData EQUIPE_SHORTGK;
	public static SelectData EQUIPE_SHORTMARQUES;
	public static SelectData EQUIPE_SHORTCOULEUR1;
	public static SelectData EQUIPE_SHORTCOULEUR2;
	public static SelectData EQUIPE_SHORTCOULEUR3;
	public static SelectData EQUIPE_SHORTCOULEUR4;
	public static SelectData EQUIPE_CHAUSSETTES;
	public static SelectData EQUIPE_CHAUSSETTESGK;
	public static SelectData EQUIPE_CHAUSSETTESCOULEUR1;
	public static SelectData EQUIPE_CHAUSSETTESCOULEUR2;
	public static SelectData EQUIPE_CHAUSSETTESCOULEUR3;
	public static SelectData EQUIPE_CHAUSSETTESCOULEUR4;
	public static SelectData EQUIPE_POLICE;
	public static SelectData EQUIPE_POLICEBORDURE;
	public static SelectData EQUIPE_POLICECOULEUR1;
	public static SelectData EQUIPE_POLICECOULEUR2;
	public static SelectData EQUIPE_POLICECOULEUR3;
	public static SelectData EQUIPE_POLICECOULEUR4;
	public static SelectData EQUIPE_BRASSARDCOULEUR;
	
	public static SelectData EQUIPE_FORMATION;
	public static SelectData EQUIPE_CAPITAINE;
	public static SelectData EQUIPE_TIREURCORNER;
	public static SelectData EQUIPE_TACTIQUE;
	public static SelectData EQUIPE_TACTIQUEJOUEUR1;
	public static SelectData EQUIPE_TACTIQUEJOUEUR2;
	public static SelectData EQUIPE_TACTIQUEJOUEUR3;
	public static SelectData EQUIPE_TACTIQUEJOUEUR4;
	public static SideData EQUIPE_TACTIQUENBJOUEURS;
	
	public static SelectData EQUIPE_NUMEROS;
	public static SelectData EQUIPE_JOUEURS;
	public static String[] EQUIPE_JOUEURSDEFAUT;
	public static NumericData EQUIPE_PLACEMENTY;
	public static NumericData EQUIPE_PLACEMENTX;
	
	public static IncrementalData JOUEURSBASE;
	public static IncrementalData EQUIPESBASE;
	public static IncrementalData EQUIPESBASEPLACEMENT;
	public static IncrementalData JOUEURSCUSTOM;
	public static int JOUEURSBASEEDITABLES;
	public static int JOUEURSETOILENOMBRE;
	public static int JOUEURSETOILEOFFSET;
	
	static {
		init();
	}
	
	public static void init() {
		try (InputStream input = new FileInputStream("config/data.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            		
            JOUEUR_NOM = new TextData(prop, "nom");
            
            POSITION = new SelectData(prop, "position");
 
            TYPECORPS = new SelectData(prop, "typeCorps");
            TAILLE = new NumericData(prop, "taille");
            TAILLETETE = new NumericData(prop, "tailleTete");
            COULEURPEAU = new SelectData(prop, "couleurPeau");
            STYLEMANCHE = new SelectData(prop, "styleManche");
            VISAGE = new SelectData(prop, "visage");
            TAILLEBOUCHE = new NumericData(prop, "tailleBouche");
            COMMISSURES = new NumericData(prop, "commissures");
            POSITIONBOUCHE = new NumericData(prop, "positionBouche");
            CHEVEUX = new SelectData(prop, "cheveux");
            COULEURCHEVEUX = new SelectData(prop, "couleurCheveux");
            YEUX = new SelectData(prop, "yeux");
            TAILLEYEUX = new NumericData(prop, "tailleYeux");
            POSITIONYEUX = new NumericData(prop, "positionYeux");
            ESPACEMENTYEUX = new NumericData(prop, "espacementYeux");
            TAILLEPUPILLES = new NumericData(prop, "taillePupilles");
            COULEURYEUX = new SelectData(prop, "couleurYeux");
            SOURCILS = new SelectData(prop, "sourcils");
            COULEURSOURCILS = new SelectData(prop, "couleurSourcils");
            NEZ = new SelectData(prop, "nez");
            POSITIONNEZ = new NumericData(prop, "positionNez");
            TAILLENEZ = new NumericData(prop, "tailleNez");
            CRAMPONS = new SelectData(prop, "crampons");
            VOIX = new SelectData(prop, "voix");
            LUNETTES = new SelectData(prop, "lunettes");
            COULEURLUNETTES = new SelectData(prop, "couleurLunettes");
            
            CELEBRATION = new SelectData(prop, "celebration");
            
            STAT = new NumericData(prop, "stat");
            
            TIRS = new SelectData(prop, "tir");
            TIRSAERIENS = new SelectData(prop, "tirAerien");
            SUPERTIRS = new SelectData(prop, "superTir");
            DRIBBLES = new SelectData(prop, "dribble");
            PASSES = new SelectData(prop, "passe");
            TIRSCOMBO1 = new SelectData(prop, "tirCombo1");
            TIRSCOMBO2 = new SelectData(prop, "tirCombo2");
            PASSESCOMBO = new SelectData(prop, "passesCombo");
            TACLES = new SelectData(prop, "tacle");
            BLOCAGES = new SelectData(prop, "blocage");
            
            COMPETECESCAPITAINE = new SelectData(prop, "competenceCapitaine");
            COMPETENCES = new SelectData(prop, "competence");
            
            
            EQUIPES_ADDRESS = new ArrayList<Long[]>();
            EQUIPES_ADDRESS.add(new Long[0]);
            for(int i=1;i<=5;i++) {
            	String[] hexAdresses = prop.getProperty("equipe.address."+i).split(",");
            	Long[] adresses = {Long.parseLong(hexAdresses[0], 16), Long.parseLong(hexAdresses[1], 16), Long.parseLong(hexAdresses[2], 16)};
            	EQUIPES_ADDRESS.add(adresses);
            }
            
        	EQUIPE_NOM = new TextData(prop, "equipe.nom");
        	EQUIPE_ABREVIATION = new TextData(prop, "equipe.abreviation");
        	EQUIPE_FOND = new SelectData(prop, "equipe.emblemeFondPiece");
        	EQUIPE_MOTIFFOND = new SelectData(prop, "equipe.emblemeFondMotif");
        	EQUIPE_COULEURFOND1 = new SelectData(prop, "equipe.emblemeFondCouleur1");
        	EQUIPE_COULEURFOND2 = new SelectData(prop, "equipe.emblemeFondCouleur2");
        	EQUIPE_COULEURFOND3 = new SelectData(prop, "equipe.emblemeFondCouleur3");
        	EQUIPE_COULEURFOND4 = new SelectData(prop, "equipe.emblemeFondCouleur4");
        	EQUIPE_MILIEU = new SelectData(prop, "equipe.emblemeMilieuPiece");
        	EQUIPE_COULEURMILIEU1 = new SelectData(prop, "equipe.emblemeMilieuCouleur1");
        	EQUIPE_COULEURMILIEU2 = new SelectData(prop, "equipe.emblemeMilieuCouleur2");
        	EQUIPE_COTE = new SelectData(prop, "equipe.emblemeCotePiece");
        	EQUIPE_COULEURCOTE1 = new SelectData(prop, "equipe.emblemeCoteCouleur1");
        	EQUIPE_COULEURCOTE2 = new SelectData(prop, "equipe.emblemeCoteCouleur2");
        	EQUIPE_HAUT = new SelectData(prop, "equipe.emblemeHautPiece");
        	EQUIPE_COULEURHAUT1 = new SelectData(prop, "equipe.emblemeHautCouleur1");
        	EQUIPE_COULEURHAUT2 = new SelectData(prop, "equipe.emblemeHautCouleur2");
        	EQUIPE_BAS = new SelectData(prop, "equipe.emblemeBasPiece");
        	EQUIPE_COULEURBAS1 = new SelectData(prop, "equipe.emblemeBasCouleur1");
        	EQUIPE_COULEURBAS2 = new SelectData(prop, "equipe.emblemeBasCouleur2");
        	EQUIPE_TRIPIECES = new MultiSelectData(prop, "equipe.emblemeTri");
        	
        	EQUIPE_MAILLOT = new SelectData(prop, "equipe.maillot");
        	EQUIPE_MAILLOTGK = new SelectData(prop, "equipe.maillotGK");
        	EQUIPE_COL = new SelectData(prop, "equipe.col");
        	EQUIPE_MAILLOTCOULEUR1 = new SelectData(prop, "equipe.maillotCouleur1");
        	EQUIPE_MAILLOTCOULEUR2 = new SelectData(prop, "equipe.maillotCouleur2");
        	EQUIPE_MAILLOTCOULEUR3 = new SelectData(prop, "equipe.maillotCouleur3");
        	EQUIPE_MAILLOTCOULEUR4 = new SelectData(prop, "equipe.maillotCouleur4");
        	EQUIPE_SHORT = new SelectData(prop, "equipe.short");
        	EQUIPE_SHORTGK = new SelectData(prop, "equipe.shortGK");
        	EQUIPE_SHORTMARQUES = new SelectData(prop, "equipe.shortMarque");
        	EQUIPE_SHORTCOULEUR1 = new SelectData(prop, "equipe.shortCouleur1");
        	EQUIPE_SHORTCOULEUR2 = new SelectData(prop, "equipe.shortCouleur2");
        	EQUIPE_SHORTCOULEUR3 = new SelectData(prop, "equipe.shortCouleur3");
        	EQUIPE_SHORTCOULEUR4 = new SelectData(prop, "equipe.shortCouleur4");
        	EQUIPE_CHAUSSETTES = new SelectData(prop, "equipe.chaussettes");
        	EQUIPE_CHAUSSETTESGK = new SelectData(prop, "equipe.chaussettesGK");
        	EQUIPE_CHAUSSETTESCOULEUR1 = new SelectData(prop, "equipe.chaussettesCouleur1");
        	EQUIPE_CHAUSSETTESCOULEUR2 = new SelectData(prop, "equipe.chaussettesCouleur2");
        	EQUIPE_CHAUSSETTESCOULEUR3 = new SelectData(prop, "equipe.chaussettesCouleur3");
        	EQUIPE_CHAUSSETTESCOULEUR4 = new SelectData(prop, "equipe.chaussettesCouleur4");
        	EQUIPE_POLICE = new SelectData(prop, "equipe.police");
        	EQUIPE_POLICEBORDURE = new SelectData(prop, "equipe.policeBordure");
        	EQUIPE_POLICECOULEUR1 = new SelectData(prop, "equipe.policeCouleur1");
        	EQUIPE_POLICECOULEUR2 = new SelectData(prop, "equipe.policeCouleur2");
        	EQUIPE_POLICECOULEUR3 = new SelectData(prop, "equipe.policeCouleur3");
        	EQUIPE_POLICECOULEUR4 = new SelectData(prop, "equipe.policeCouleur4");
        	EQUIPE_BRASSARDCOULEUR = new SelectData(prop, "equipe.brassardCouleur");
        	
        	EQUIPE_FORMATION = new SelectData(prop, "equipe.formation");
        	EQUIPE_CAPITAINE = new SelectData(prop, "equipe.capitaine");
        	EQUIPE_TIREURCORNER = new SelectData(prop, "equipe.tireurCorner");
        	EQUIPE_TACTIQUE = new SelectData(prop, "equipe.tactique");
        	EQUIPE_TACTIQUEJOUEUR1 = new SelectData(prop, "equipe.tactiqueJoueur1");
        	EQUIPE_TACTIQUEJOUEUR2 = new SelectData(prop, "equipe.tactiqueJoueur2");
        	EQUIPE_TACTIQUEJOUEUR3 = new SelectData(prop, "equipe.tactiqueJoueur3");
        	EQUIPE_TACTIQUEJOUEUR4 = new SelectData(prop, "equipe.tactiqueJoueur4");
        	EQUIPE_TACTIQUENBJOUEURS = new SideData(prop, "equipe.tactiqueNbJoueurs");
        	
        	EQUIPE_NUMEROS = new SelectData(prop, "equipe.numeros");
        	EQUIPE_JOUEURS = new SelectData(prop, "equipe.joueurs");
        	EQUIPE_JOUEURSDEFAUT = prop.getProperty("equipe.JoueursDefaut").split(",");
        	EQUIPE_PLACEMENTY = new NumericData(prop, "equipe.placementY");
        	EQUIPE_PLACEMENTX = new NumericData(prop, "equipe.placementX");
        	
        	EQUIPESBASE = new IncrementalData(prop, "equipesBase");
        	EQUIPESBASEPLACEMENT = new IncrementalData(prop, "equipesBasePlacement");
        	JOUEURSBASE = new IncrementalData(prop, "joueursBase");
        	JOUEURSCUSTOM = new IncrementalData(prop, "joueursCustom");
        	JOUEURSBASEEDITABLES = Integer.parseInt(prop.getProperty("joueursBaseEditables.nombre"));
        	JOUEURSETOILENOMBRE = Integer.parseInt(prop.getProperty("joueursEtoile.nombre"));
        	JOUEURSETOILEOFFSET = Integer.parseInt(prop.getProperty("joueursEtoile.offset"));
        	
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}