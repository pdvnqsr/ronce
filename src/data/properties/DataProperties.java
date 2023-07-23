package data.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class DataProperties {
	public static ArrayList<Long> JOUEURS_ADDRESS;
	public static long NOM_OFFSET;
	public static int NOM_LONGUEUR;
	public static String NOM_DEFAUT;
	
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
	
	
	static {
		try (InputStream input = new FileInputStream("config/data.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            JOUEURS_ADDRESS = new ArrayList<Long>();
            JOUEURS_ADDRESS.add((long)0);
            for(int i=1;i<=20;i++) {
            	JOUEURS_ADDRESS.add(Long.parseLong(prop.getProperty("joueurs.address."+i), 16));
            }
            		
            NOM_OFFSET = Long.parseLong(prop.getProperty("nom.offset"));
            NOM_LONGUEUR = Integer.parseInt(prop.getProperty("nom.longueur"));
            NOM_DEFAUT = prop.getProperty("nom.defaut");
            
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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}