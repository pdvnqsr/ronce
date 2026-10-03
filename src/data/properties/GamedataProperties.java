package data.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import data.properties.types.IncrementalData;
import data.properties.types.NumericData;
import data.properties.types.SelectData;


public class GamedataProperties {
	
	public static IncrementalData JOUEURSBASE;
	public static NumericData CPD_STAT;
	public static SelectData CPD_POSITION;

	static {
		init();
	}
	
	public static void init() {
		try (InputStream input = new FileInputStream("config/gamedata.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            		
            JOUEURSBASE = new IncrementalData(prop, "charParamData.joueursBase");
            CPD_STAT = new NumericData(prop, "charParamData.stat");
            CPD_POSITION = new SelectData(prop, "charParamData.position");
        	
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}