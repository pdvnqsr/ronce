package data.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Properties;

public class SystemProperties {

	private static String PROPS_PATH = "config/system.properties";
	private static String PATH_KEY = "savedata.path";
	private static String LOCALE_KEY = "locale";
	private static Properties PROPS;
	
	public static boolean LOG_IN_FILE;
	public static String LOCALE;
	public static String PATH;
	
	
	static {
		try (InputStream input = new FileInputStream(PROPS_PATH)) {
			PROPS = new Properties();
			PROPS.load(input);

            PATH = PROPS.getProperty(PATH_KEY);
            LOG_IN_FILE = "true".equals(PROPS.getProperty("log.file"));
            LOCALE = PROPS.getProperty(LOCALE_KEY);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
	public static void setPath(String path) {
		try(OutputStream outputStream = new FileOutputStream(PROPS_PATH)){  
			PATH = path;
			PROPS.setProperty(PATH_KEY, path);
		    PROPS.store(outputStream, null);
		} catch (IOException e) {
		    e.printStackTrace();
		} 
	}
	
	public static Locale getLocale() {
		Locale locale = Locale.getDefault();
		if(LOCALE != null && !"".equals(LOCALE)) {
			locale = new Locale(LOCALE);
		}
		return locale;
	}
	
	public static void setLocale(String locale) {
		try(OutputStream outputStream = new FileOutputStream(PROPS_PATH)){  
			LOCALE = locale;
			PROPS.setProperty(LOCALE_KEY, locale);
		    PROPS.store(outputStream, null);
		} catch (IOException e) {
		    e.printStackTrace();
		} 
	}
}