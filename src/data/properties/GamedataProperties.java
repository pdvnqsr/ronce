package data.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import data.properties.types.IncrementalData;
import data.properties.types.NumericData;
import data.properties.types.SelectData;


public class GamedataProperties {
	
	public static IncrementalData CPD_JOUEURSBASE;
	public static NumericData CPD_STAT;
	public static SelectData CPD_POSITION;
	
	public static IncrementalData CP_JOUEURSBASE;
	public static SelectData CP_TYPECORPS;
	public static NumericData CP_TAILLE;
	public static NumericData CP_TAILLETETE;
	public static SelectData CP_COULEURPEAU;
	public static SelectData CP_VISAGE;
	public static SelectData CP_CHEVEUX;
	public static SelectData CP_COULEURCHEVEUX;
	public static SelectData CP_YEUX;
	public static SelectData CP_COULEURYEUX;
	public static SelectData CP_SOURCILS;
	public static SelectData CP_COULEURSOURCILS;
	public static SelectData CP_NEZ;
	public static SelectData CP_CRAMPONS;
	public static SelectData CP_LUNETTES;
	public static SelectData CP_COULEURLUNETTES;

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
            CP_TYPECORPS = new SelectData(prop, "customPreset.typeCorps");
            CP_TAILLE = new NumericData(prop, "customPreset.taille");
            CP_TAILLETETE = new NumericData(prop, "customPreset.tailleTete");
            CP_COULEURPEAU = new SelectData(prop, "customPreset.couleurPeau");
            CP_VISAGE = new SelectData(prop, "customPreset.visage");
            CP_CHEVEUX = new SelectData(prop, "customPreset.cheveux");
            CP_COULEURCHEVEUX = new SelectData(prop, "customPreset.couleurCheveux");
            CP_YEUX = new SelectData(prop, "customPreset.yeux");
            CP_COULEURYEUX = new SelectData(prop, "customPreset.couleurYeux");
            CP_SOURCILS = new SelectData(prop, "customPreset.sourcils");
            CP_COULEURSOURCILS = new SelectData(prop, "customPreset.couleurSourcils");
            CP_NEZ = new SelectData(prop, "customPreset.nez");
            CP_CRAMPONS = new SelectData(prop, "customPreset.crampons");
            CP_LUNETTES = new SelectData(prop, "customPreset.lunettes");
            CP_COULEURLUNETTES = new SelectData(prop, "customPreset.couleurLunettes");
        	
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}