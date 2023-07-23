package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFileChooser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import GUI.MainGUI;
import data.Data;
import data.ExchangeData;
import data.Joueur;
import data.properties.SystemProperties;

public class Launch {
	private static Launch instance = null;
	
	private static final Path savePath = Paths.get("data.json");
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	private Data data;
	private MainGUI gui;
	
	private void init(){
		try {
			if(SystemProperties.LOG_IN_FILE) {
				new File("ronce.log").delete();
				System.setOut(new PrintStream(new FileOutputStream("ronce.log",true)));
				System.setErr(new PrintStream(new FileOutputStream("ronce.log",true)));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		lookForSavedata();
		data = new Data();
		loadData();
		gui = new MainGUI();
	}
	
	public static Launch getInstance() {
		if(instance == null) {
			instance = new Launch();
			instance.init();
		}
		return instance;
	}
	
	private Launch() {}
	
	public void saveData() {
		String json = gson.toJson(data);
		try {
			Files.writeString(savePath, json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadData() {
		try {
			String json = Files.readString(savePath);
			data = gson.fromJson(json, Data.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		data.loadJoueursFromGame();
	}

	public void exportJoueurs(List<Joueur> joueurs, Path path) {
		ExchangeData exchangeData = new ExchangeData();
		for(Joueur joueur : joueurs) {
			exchangeData.getJoueurs().add(joueur);
		}
		
		String json = gson.toJson(exchangeData);
		try {
			Files.writeString(path, json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void importJoueurs(Path path) {
		try {
			String json = Files.readString(path);
			ExchangeData exchangeData = gson.fromJson(json, ExchangeData.class);
			for(Joueur joueur : exchangeData.getJoueurs()) {
				data.getJoueurs().add(joueur);
			}
			saveData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void lookForSavedata() {
		if(!new File(SystemProperties.PATH).exists()) {
			JFileChooser choose = new JFileChooser(System.getProperty("user.home"));
			choose.setDialogTitle("Sélectionnez le savedata.dat du jeu");
			int res = choose.showOpenDialog(null);
			if (res == JFileChooser.APPROVE_OPTION) {
				SystemProperties.setPath(choose.getSelectedFile().getAbsolutePath());
			}
		}
	}
	
	public static void main(String[] args) {
		Launch.getInstance();
		//generateVals("couleurLunettes", 60, 0);
	}

	@SuppressWarnings("unused")
	private static void generateVals(String prop, int max, int offset) {
		for(int i=0;i<max;i++) {
			System.out.println(prop + ".vals." + i + "=" + (i+offset) + ":" + (i+1));
		}
	}
	
	public Data getData() {
		return data;
	}

	public MainGUI getGui() {
		return gui;
	}

	public Gson getGson() {
		return gson;
	}
	
}
