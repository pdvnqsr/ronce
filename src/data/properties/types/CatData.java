package data.properties.types;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import data.properties.SystemProperties;

public class CatData {

	private static HashMap<String, String> files = new HashMap<String, String>();
	static {
		files.put("charactorData", SystemProperties.CHARACTORDATA_PATH);
	}
	
	private String path;
	private long nombreAdr;
	private long offsetAdr;
	private long adressesAdr;
	private long taillesAdr;
	
	private int nombre;
	private int offset;
	private ArrayList<Long> adresses;
	private ArrayList<Long> tailles;
	
	public CatData(Properties props, String key) {
		super();
		this.path = files.get(props.getProperty(key+".fichier"));
		this.nombreAdr = Long.parseLong(props.getProperty(key+".nombre"), 16);
		this.offsetAdr = Long.parseLong(props.getProperty(key+".offset"), 16);
		this.adressesAdr = Long.parseLong(props.getProperty(key+".adresses"), 16);
		this.taillesAdr = Long.parseLong(props.getProperty(key+".tailles"), 16);
		this.adresses = new ArrayList<Long>();
		this.tailles = new ArrayList<Long>();
		
		try {
			RandomAccessFile raf = new RandomAccessFile(path, "rw");
			
			this.nombre = getLongFromFile(raf, nombreAdr, 0);
			this.offset = getLongFromFile(raf, offsetAdr, 0);
			
			for(int i=0;i<nombre;i++) {
				adresses.add((long) getLongFromFile(raf, adressesAdr, 4*i));
				tailles.add((long) getLongFromFile(raf, taillesAdr, 4*i));
			}
			
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private int getLongFromFile(RandomAccessFile raf, long addr, int offset) throws Exception {
		raf.seek(addr + offset);
		byte[] bytesVal = new byte[4];
		bytesVal[3]=raf.readByte();
		bytesVal[2]=raf.readByte();
		bytesVal[1]=raf.readByte();
		bytesVal[0]=raf.readByte();
		ByteBuffer wrapped = ByteBuffer.wrap(bytesVal);
		int result = wrapped.getInt();
		return result;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public ArrayList<Long> getAdresses() {
		return adresses;
	}

	public void setAdresses(ArrayList<Long> adresses) {
		this.adresses = adresses;
	}

	public ArrayList<Long> getTailles() {
		return tailles;
	}

	public void setTailles(ArrayList<Long> tailles) {
		this.tailles = tailles;
	}
}
