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
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import GUI.MainGUI;
import data.Data;
import data.Equipe;
import data.EquipeExchangeData;
import data.JoueursExchangeData;
import data.Joueur;
import data.properties.SystemProperties;
import data.properties.TextsProperties;

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
		data.loadEquipesFromGame();
	}

	public void exportJoueurs(List<Joueur> joueurs, Path path) {
		JoueursExchangeData exchangeData = new JoueursExchangeData();
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
			JoueursExchangeData exchangeData = gson.fromJson(json, JoueursExchangeData.class);
			Joueur existant = null;
			for(Joueur joueur : exchangeData.getJoueurs()) {
				if(joueur.getId() == null || joueur.getId().equals("")) {
					joueur.setId(joueur.regenerateId());
				}
				existant = data.getJoueurParId(joueur.getId()); 
				if(existant != null) {
					int res = JOptionPane.showConfirmDialog(gui, TextsProperties.MESSAGE_IDEXISTANT1 + " : \n" + existant.getNom() + "\n" + TextsProperties.MESSAGE_IDEXISTANT2);
					if(res == JOptionPane.YES_NO_OPTION) {
						existant.update(joueur);
					} else if(res == JOptionPane.NO_OPTION) {
						joueur.setId(joueur.regenerateId());
						data.getJoueurs().add(joueur);
					}
				} else {
					data.getJoueurs().add(joueur);
				}
				existant = null;
			}
			saveData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exportEquipes(List<Equipe> equipes, Path path) {
		EquipeExchangeData exchangeData = new EquipeExchangeData();
		for(Equipe equipe : equipes) {
			exchangeData.getEquipes().add(equipe);
		}
		
		//TODO ajouter les joueurs custom
		
		String json = gson.toJson(exchangeData);
		try {
			Files.writeString(path, json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void importEquipes(Path path) {
		try {
			String json = Files.readString(path);
			EquipeExchangeData exchangeData = gson.fromJson(json, EquipeExchangeData.class);
			Equipe existant = null;
			for(Equipe equipe : exchangeData.getEquipes()) {
				if(equipe.getId() == null || equipe.getId().equals("")) {
					equipe.setId(equipe.regenerateId());
				}
				existant = data.getEquipeParId(equipe.getId()); 
				if(existant != null) {
					int res = JOptionPane.showConfirmDialog(gui, TextsProperties.MESSAGE_IDEXISTANT1 + " : \n" + existant.getNom() + "\n" + TextsProperties.MESSAGE_IDEXISTANT2);
					if(res == JOptionPane.YES_NO_OPTION) {
						existant.update(equipe);
					} else if(res == JOptionPane.NO_OPTION) {
						equipe.setId(equipe.regenerateId());
						data.getEquipes().add(equipe);
					}
				} else {
					data.getEquipes().add(equipe);
				}
				//TODO ajouter joueurs custom
				existant = null;
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
		//generateVals("equipe.capitaine", 11, 0);
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
