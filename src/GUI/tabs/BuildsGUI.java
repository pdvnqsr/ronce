package GUI.tabs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GUI.MainGUI;
import GUI.panels.BuildPanel;
import data.elements.Build;
import data.properties.TextsProperties;
import main.Launch;

public class BuildsGUI extends JPanel {

	private static final long serialVersionUID = -6559051654385212939L;
	private JList<Build> inGame;
	private JList<Build> inStock;
	private BuildPanel buildPanel;

	private JButton versLeStockBouton;
	private JButton creerBouton;
	private JButton supprimerBouton;
	private JButton enregistrerBouton;
	private JButton inGameBouton;
	private JButton exporterBouton;
	private JButton importerBouton;
	
	public BuildsGUI() {
		setLayout(new BorderLayout());
		
		// Actions
		JPanel boutonsPanel = new JPanel();
		versLeStockBouton = new JButton(TextsProperties.BUTTON_ADD);
		versLeStockBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ajouterAuStock();
			}
		});
		creerBouton = new JButton(TextsProperties.BUTTON_CREATE);
		creerBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creer();
			}
		});
		supprimerBouton = new JButton(TextsProperties.BUTTON_DELETE);
		supprimerBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				supprimer();
			}
		});
		enregistrerBouton = new JButton(TextsProperties.BUTTON_SAVE);
		enregistrerBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sauvegarder();
			}
		});
		inGameBouton = new JButton(TextsProperties.BUTTON_TOGAME);
		inGameBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				envoyerInGame();
			}
		});
		exporterBouton = new JButton(TextsProperties.BUTTON_EXPORT);
		exporterBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				export();
			}
		});
		importerBouton = new JButton(TextsProperties.BUTTON_IMPORT);
		importerBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				importer();
			}
		});

		boutonsPanel.add(versLeStockBouton);
		boutonsPanel.add(creerBouton);
		boutonsPanel.add(supprimerBouton);
		boutonsPanel.add(enregistrerBouton);
		boutonsPanel.add(inGameBouton);
		boutonsPanel.add(exporterBouton);
		boutonsPanel.add(importerBouton);
		add(boutonsPanel, BorderLayout.NORTH);

		// Présentation/édition d'un build
		buildPanel = new BuildPanel();
		JScrollPane scroll = new JScrollPane(buildPanel);
		add(scroll,BorderLayout.CENTER);

		// Listes de builds
		inGame = new JList<Build>();
		inGame.setModel(new DefaultListModel<Build>());
		remplirListes(true);
		inGame.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				enableButtons();
				buildPanel.setEnabled(false);
				buildPanel.load(inGame.getSelectedValue());
			}
		});

		inStock = new JList<Build>();
		inStock.setModel(new DefaultListModel<Build>());
		remplirListes(false);
		inStock.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				enableButtons();
				buildPanel.setEnabled(true);
				buildPanel.load(inStock.getSelectedValue());
			}
		});

		JPanel listesPanel = new JPanel(new GridLayout(1,2));
		listesPanel.add(MainGUI.getListePanel(inGame, TextsProperties.LABEL_LISTINGAME));
		listesPanel.add(MainGUI.getListePanel(inStock, TextsProperties.LABEL_LISTINSTOCK));
		add(listesPanel, BorderLayout.WEST);
		
		enableButtons();
	}
	
	
	public void remplirListes(boolean isInGame){
		DefaultListModel<Build> model;
		if(isInGame) {
			model = (DefaultListModel<Build>) inGame.getModel();
		} else {
			model = (DefaultListModel<Build>) inStock.getModel();
		}	
		model.removeAllElements();
		ArrayList<Build> list;
		if(isInGame) {
			list = Launch.getInstance().getData().getBuildsInGame();
		} else {
			list = Launch.getInstance().getData().getBuilds();
		}
		for(int i=0;i<list.size();i++){
			model.addElement(list.get(i));
		}
	}

	public void enableButtons() {
		versLeStockBouton.setEnabled(!inGame.isSelectionEmpty());
		supprimerBouton.setEnabled(!inStock.isSelectionEmpty());
		enregistrerBouton.setEnabled(!inStock.isSelectionEmpty());
		inGameBouton.setEnabled(!inGame.isSelectionEmpty() && !inStock.isSelectionEmpty());
		exporterBouton.setEnabled(!inStock.isSelectionEmpty());
	}

	public void export() {
		String message = TextsProperties.MESSAGE_EXPORT1 + "\n";
		for(Build build : inStock.getSelectedValuesList()) {
			message += build.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_EXPORT2;

		String nom = JOptionPane.showInputDialog(this, message);
		if (nom != null && ! "".equals(nom)) {
			File file = new File("exchange/builds/"+nom+".json");
			if(file.exists()) {
				int res = JOptionPane.showConfirmDialog(this, TextsProperties.MESSAGE_FICHIEREXISTANT, TextsProperties.BUTTON_EXPORT, JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION) {
					Launch.getInstance().exportBuilds(inStock.getSelectedValuesList(), file.toPath());
				} else {
					export();
				}
			} else {
				Launch.getInstance().exportBuilds(inStock.getSelectedValuesList(), file.toPath());
			}
		}
	}

	public void importer() {
		File dir = new File("exchange/builds");
		File[] fichiers = dir.listFiles();

		if(fichiers.length == 0) {
			JOptionPane.showMessageDialog(this, TextsProperties.MESSAGE_IMPORTERROR);
		} else {
			String message = TextsProperties.MESSAGE_IMPORT;
			String[] nomsFichiers = new String[fichiers.length];
			for(int i=0;i<nomsFichiers.length;i++) {
				nomsFichiers[i] = fichiers[i].getName();
			}

			String nom = JOptionPane.showInputDialog(
					this, message, TextsProperties.BUTTON_IMPORT, JOptionPane.PLAIN_MESSAGE, null, nomsFichiers, nomsFichiers[0]).toString();
			if (nom != null && ! "".equals(nom)) {
				Launch.getInstance().importBuilds(new File("exchange/builds/"+nom).toPath());
				remplirListes(false);
			}
		}
	}

	public void supprimer() {
		String message = TextsProperties.MESSAGE_DELETE + "\n";
		for(Build build : inStock.getSelectedValuesList()) {
			message += build.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_IRREVERSIBLE + " " + TextsProperties.MESSAGE_SURE;

		int res = JOptionPane.showConfirmDialog(this, message, TextsProperties.BUTTON_DELETE, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			for(Build j : inStock.getSelectedValuesList()) {
				Launch.getInstance().getData().supprimerBuild(j);	
			}
			remplirListes(false);
			Launch.getInstance().saveData();	
		}
		Launch.getInstance().getGui().getEquipesGUI().majGui();
	}

	public void creer() {
		Build nouveau = Launch.getInstance().getData().nouveauBuild();
		remplirListes(false);
		Launch.getInstance().saveData();
		inStock.setSelectedValue(nouveau, true);
		Launch.getInstance().getGui().getEquipesGUI().majGui();
	}

	public void ajouterAuStock() {
		String message = TextsProperties.MESSAGE_ADDELEMENTS + "\n";
		for(Build build : inGame.getSelectedValuesList()) {
			message += build.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_SURE;

		int res = JOptionPane.showConfirmDialog(this, message, TextsProperties.BUTTON_ADD, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			Launch.getInstance().getData().ajouterBuildsAuStock((ArrayList<Build>)inGame.getSelectedValuesList());
		}
	}
	
	public void sauvegarder() {
		Build j = inStock.getSelectedValue();
		buildPanel.save();
		Launch.getInstance().saveData();
		remplirListes(false);
		inStock.setSelectedValue(j, true);
		Launch.getInstance().getGui().getEquipesGUI().majGui();
	}
	
	public void envoyerInGame() {
		String message = TextsProperties.MESSAGE_TOGAME1 + "\n";
		message += inGame.getSelectedValue().getNom() + "\n";
		message += TextsProperties.MESSAGE_TOGAME2 + "\n";
		message += inStock.getSelectedValue().getNom() + "\n";
		message += "\n" + TextsProperties.MESSAGE_IRREVERSIBLE + " " + TextsProperties.MESSAGE_SURE;
		
		int res = JOptionPane.showConfirmDialog(this, message,TextsProperties.BUTTON_TOGAME, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			Launch.getInstance().getData().saveBuildIntoGame(inStock.getSelectedValue(), inGame.getSelectedIndex());
			Launch.getInstance().getData().loadBuildsFromGame();
			remplirListes(true);
		}
	}
}
