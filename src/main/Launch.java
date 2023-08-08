package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import GUI.MainGUI;
import data.Data;
import data.elements.Build;
import data.elements.Composition;
import data.elements.Equipe;
import data.elements.Joueur;
import data.exchange.BuildsExchangeData;
import data.exchange.CompositionsExchangeData;
import data.exchange.EquipesExchangeData;
import data.exchange.JoueursExchangeData;
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
		data.loadBuildsFromGame();
		data.loadCompositionsFromGame();
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
			importerJoueurs(exchangeData.getJoueurs());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private HashMap<String, String> importerJoueurs(ArrayList<Joueur> joueurs) {
		HashMap<String, String> idToReplace = new HashMap<String, String>();
		Joueur existant = null;
		String newId;
		for(Joueur joueur : joueurs) {
			if(joueur.getId() == null || joueur.getId().equals("")) {
				joueur.setId(joueur.regenerateId());
			}
			existant = data.getJoueurParId(joueur.getId()); 
			if(existant != null) {
				if(!joueur.equals(existant)) {
					int res = JOptionPane.showConfirmDialog(gui, TextsProperties.MESSAGE_IDEXISTANT1 + " : \n" + existant.getNom() + "\n" + TextsProperties.MESSAGE_IDEXISTANT2);
					if(res == JOptionPane.YES_NO_OPTION) {
						existant.update(joueur);
					} else if(res == JOptionPane.NO_OPTION) {
						newId = joueur.regenerateId();
						idToReplace.put(joueur.getId(), newId);
						joueur.setId(newId);
						data.getJoueurs().add(joueur);
					}
				}
			} else {
				data.getJoueurs().add(joueur);
			}
			existant = null;
		}
		saveData();
		return idToReplace;
	}

	public void exportEquipes(List<Equipe> equipes, Path path) {
		EquipesExchangeData exchangeData = new EquipesExchangeData();
		Joueur j;
		for(Equipe equipe : equipes) {
			exchangeData.getEquipes().add(equipe);

			for(String id : equipe.getJoueurs()) {
				j = data.getJoueurParId(id);
				if(j != null && !exchangeData.getJoueursCustom().contains(j)) {
					exchangeData.getJoueursCustom().add(j);
				}
			}
		}

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
			EquipesExchangeData exchangeData = gson.fromJson(json, EquipesExchangeData.class);

			HashMap<String, String> idToReplace = importerJoueurs(exchangeData.getJoueursCustom());
			String toReplace;
			String id;

			Equipe existant = null;
			for(Equipe equipe : exchangeData.getEquipes()) {
				for(int i=0;i<equipe.getJoueurs().length;i++) {
					id = equipe.getJoueurs()[i];
					toReplace = idToReplace.get(id); 
					if(toReplace != null) {
						equipe.getJoueurs()[i] = toReplace;
					}
				}
				
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
				existant = null;
			}
			saveData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void exportBuilds(List<Build> builds, Path path) {
		BuildsExchangeData exchangeData = new BuildsExchangeData();
		for(Build build : builds) {
			exchangeData.getBuilds().add(build);
		}

		String json = gson.toJson(exchangeData);
		try {
			Files.writeString(path, json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void importBuilds(Path path) {
		try {
			String json = Files.readString(path);
			BuildsExchangeData exchangeData = gson.fromJson(json, BuildsExchangeData.class);
			Build existant = null;
			String newId;
			for(Build build : exchangeData.getBuilds()) {
				if(build.getId() == null || build.getId().equals("")) {
					build.setId(build.regenerateId());
				}
				existant = data.getBuildParId(build.getId()); 
				if(existant != null) {
					if(!build.equals(existant)) {
						int res = JOptionPane.showConfirmDialog(gui, TextsProperties.MESSAGE_IDEXISTANT1 + " : \n" + existant.getNom() + "\n" + TextsProperties.MESSAGE_IDEXISTANT2);
						if(res == JOptionPane.YES_NO_OPTION) {
							existant.update(build);
						} else if(res == JOptionPane.NO_OPTION) {
							newId = build.regenerateId();
							build.setId(newId);
							data.getBuilds().add(build);
						}
					}
				} else {
					data.getBuilds().add(build);
				}
				existant = null;
			}
			saveData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exportCompositions(List<Composition> compositions, Path path) {
		CompositionsExchangeData exchangeData = new CompositionsExchangeData();
		Joueur j;
		for(Composition composition : compositions) {
			exchangeData.getCompositions().add(composition);

			for(String id : composition.getJoueurs()) {
				j = data.getJoueurParId(id);
				if(j != null && !exchangeData.getJoueursCustom().contains(j)) {
					exchangeData.getJoueursCustom().add(j);
				}
			}
		}

		String json = gson.toJson(exchangeData);
		try {
			Files.writeString(path, json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void importCompositions(Path path) {
		try {
			String json = Files.readString(path);
			CompositionsExchangeData exchangeData = gson.fromJson(json, CompositionsExchangeData.class);

			HashMap<String, String> idToReplace = importerJoueurs(exchangeData.getJoueursCustom());
			String toReplace;
			String id;

			Composition existant = null;
			for(Composition composition : exchangeData.getCompositions()) {
				for(int i=0;i<composition.getJoueurs().length;i++) {
					id = composition.getJoueurs()[i];
					toReplace = idToReplace.get(id); 
					if(toReplace != null) {
						composition.getJoueurs()[i] = toReplace;
					}
				}
				
				if(composition.getId() == null || composition.getId().equals("")) {
					composition.setId(composition.regenerateId());
				}
				existant = data.getCompositionParId(composition.getId()); 
				if(existant != null) {
					int res = JOptionPane.showConfirmDialog(gui, TextsProperties.MESSAGE_IDEXISTANT1 + " : \n" + existant.getNom() + "\n" + TextsProperties.MESSAGE_IDEXISTANT2);
					if(res == JOptionPane.YES_NO_OPTION) {
						existant.update(composition);
					} else if(res == JOptionPane.NO_OPTION) {
						composition.setId(composition.regenerateId());
						data.getCompositions().add(composition);
					}
				} else {
					data.getCompositions().add(composition);
				}
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
		//generateVals("joueursBase", 371, 0);
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
