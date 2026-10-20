package data.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import data.properties.types.CatData;
import data.properties.types.IncrementalData;
import data.properties.types.LongSelectData;
import data.properties.types.NumericData;
import data.properties.types.SelectData;


public class GamedataProperties {
	
	public static IncrementalData CPD_JOUEURSBASE;
	public static NumericData CPD_STAT;
	public static SelectData CPD_POSITION;
	
	public static IncrementalData CP_JOUEURSBASE;
	public static LongSelectData CP_TYPECORPS;
	public static LongSelectData CP_COULEURPEAU;
	public static LongSelectData CP_VISAGE;
	public static LongSelectData CP_CHEVEUX;
	public static LongSelectData CP_COULEURCHEVEUX;
	public static LongSelectData CP_YEUX;
	public static LongSelectData CP_COULEURYEUX;
	public static LongSelectData CP_SOURCILS;
	public static LongSelectData CP_COULEURSOURCILS;
	public static LongSelectData CP_NEZ;
	public static LongSelectData CP_CRAMPONS;
	public static LongSelectData CP_LUNETTES;
	public static LongSelectData CP_COULEURLUNETTES;
	
	public static SelectData CPD_TIRS;
	public static SelectData CPD_TIRSAERIENS;
	public static SelectData CPD_SUPERTIRS;
	public static SelectData CPD_DRIBBLES;
	public static SelectData CPD_PASSES;
	public static SelectData CPD_TIRSCOMBO1;
	public static SelectData CPD_TIRSCOMBO2;
	public static SelectData CPD_PASSESCOMBO;
	public static SelectData CPD_TACLES;
	public static SelectData CPD_BLOCAGES;
	public static SelectData CPD_ARRETS;
	public static SelectData CPD_SUPERARRET;

	public static CatData CD_CAT;
	public static IncrementalData CD_JOUEURSBASE;
	public static LongSelectData CD_COMPETENCECAPITAINE;
	public static LongSelectData CD_COMPETENCES;
	
	static {
		init();
	}
	
	public static void init() {
		try (InputStream input = new FileInputStream("config/gamedata.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            		
            CPD_JOUEURSBASE = new IncrementalData(prop, "charParamData.joueursBase");
            CPD_STAT = new NumericData(prop, "charParamData.stat");
            CPD_POSITION = new SelectData(prop, "charParamData.position");
            
            CP_JOUEURSBASE = new IncrementalData(prop, "customPreset.joueursBase");
            CP_TYPECORPS = new LongSelectData(prop, "customPreset.typeCorps");
            CP_COULEURPEAU = new LongSelectData(prop, "customPreset.couleurPeau");
            CP_VISAGE = new LongSelectData(prop, "customPreset.visage");
            CP_CHEVEUX = new LongSelectData(prop, "customPreset.cheveux");
            CP_COULEURCHEVEUX = new LongSelectData(prop, "customPreset.couleurCheveux");
            CP_YEUX = new LongSelectData(prop, "customPreset.yeux");
            CP_COULEURYEUX = new LongSelectData(prop, "customPreset.couleurYeux");
            CP_SOURCILS = new LongSelectData(prop, "customPreset.sourcils");
            CP_COULEURSOURCILS = new LongSelectData(prop, "customPreset.couleurSourcils");
            CP_NEZ = new LongSelectData(prop, "customPreset.nez");
            CP_CRAMPONS = new LongSelectData(prop, "customPreset.crampons");
            CP_LUNETTES = new LongSelectData(prop, "customPreset.lunettes");
            CP_COULEURLUNETTES = new LongSelectData(prop, "customPreset.couleurLunettes");
            
            CPD_TIRS = new SelectData(prop, "charParamData.tir");
            CPD_TIRSAERIENS = new SelectData(prop, "charParamData.tirAerien");
            CPD_SUPERTIRS = new SelectData(prop, "charParamData.superTir");
            CPD_DRIBBLES = new SelectData(prop, "charParamData.dribble");
            CPD_PASSES = new SelectData(prop, "charParamData.passe");
            CPD_TIRSCOMBO1 = new SelectData(prop, "charParamData.tirCombo1");
            CPD_TIRSCOMBO2 = new SelectData(prop, "charParamData.tirCombo2");
            CPD_PASSESCOMBO = new SelectData(prop, "charParamData.passesCombo");
            CPD_TACLES = new SelectData(prop, "charParamData.tacle");
            CPD_BLOCAGES = new SelectData(prop, "charParamData.blocage");
            CPD_ARRETS = new SelectData(prop, "charParamData.arrets");
            CPD_SUPERARRET = new SelectData(prop, "charParamData.superarret");
            
            CD_CAT = new CatData(prop, "charactorData.cat");
            CD_JOUEURSBASE = new IncrementalData(prop, "charactorData.joueursBase");
            CD_COMPETENCECAPITAINE = new LongSelectData(prop, "charactorData.competenceCapitaine");
            CD_COMPETENCES = new LongSelectData(prop, "charactorData.competence");
        	
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}