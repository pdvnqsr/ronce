package GUI.tabs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
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
import GUI.panels.JoueurAutrePanel;
import data.elements.JoueurAutre;
import data.properties.TextsProperties;
import main.Launch;

public class JoueursAutresGUI extends JPanel {

	private static final long serialVersionUID = -6559051654385212939L;
	private JList<JoueurAutre> inGame;
	private JList<JoueurAutre> inStock;
	private JoueurAutrePanel joueurPanel;

	private JButton versLeStockBouton;
	private JButton creerjoueurBouton;
	private JButton supprimerjoueurBouton;
	private JButton enregistrerBouton;
	private JButton inGameBouton;
	private JButton exporterBouton;
	private JButton importerBouton;
	
	public JoueursAutresGUI() {
		setLayout(new BorderLayout());
		
		// Actions
		JPanel boutonsPanel = new JPanel();
		versLeStockBouton = new JButton(TextsProperties.BUTTON_ADD);
		versLeStockBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ajouterJoueursAuStock();
			}
		});
		creerjoueurBouton = new JButton(TextsProperties.BUTTON_CREATE);
		creerjoueurBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creerJoueur();
			}
		});
		supprimerjoueurBouton = new JButton(TextsProperties.BUTTON_DELETE);
		supprimerjoueurBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				supprimerJoueurs();
			}
		});
		enregistrerBouton = new JButton(TextsProperties.BUTTON_SAVE);
		enregistrerBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sauvegarderJoueur();
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
				exportJoueurs();
			}
		});
		importerBouton = new JButton(TextsProperties.BUTTON_IMPORT);
		importerBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				importJoueurs();
			}
		});

		boutonsPanel.add(versLeStockBouton);
		boutonsPanel.add(creerjoueurBouton);
		boutonsPanel.add(supprimerjoueurBouton);
		boutonsPanel.add(enregistrerBouton);
		boutonsPanel.add(inGameBouton);
		boutonsPanel.add(exporterBouton);
		boutonsPanel.add(importerBouton);
		add(boutonsPanel, BorderLayout.NORTH);

		// Présentation/édition d'un joueur
		joueurPanel = new JoueurAutrePanel();
		JScrollPane scroll = new JScrollPane(joueurPanel);
		add(scroll,BorderLayout.CENTER);

		// Listes de joueurs
		inGame = new JList<JoueurAutre>();
		inGame.setModel(new DefaultListModel<JoueurAutre>());
		remplirListes(true);
		inGame.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				enableButtons();
				joueurPanel.setEnabled(false);
				joueurPanel.loadJoueur(inGame.getSelectedValue());
			}
		});

		inStock = new JList<JoueurAutre>();
		inStock.setModel(new DefaultListModel<JoueurAutre>());
		remplirListes(false);
		inStock.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				enableButtons();
				joueurPanel.setEnabled(true);
				joueurPanel.loadJoueur(inStock.getSelectedValue());
			}
		});

		JPanel listesPanel = new JPanel(new GridLayout(1,2));
		listesPanel.add(MainGUI.getListePanel(inGame, TextsProperties.LABEL_LISTINGAME));
		listesPanel.add(MainGUI.getListePanel(inStock, TextsProperties.LABEL_LISTINSTOCK));
		add(listesPanel, BorderLayout.WEST);
		
		enableButtons();
	}
	
	
	public void remplirListes(boolean isInGame){
		DefaultListModel<JoueurAutre> model;
		if(isInGame) {
			model = (DefaultListModel<JoueurAutre>) inGame.getModel();
		} else {
			model = (DefaultListModel<JoueurAutre>) inStock.getModel();
		}	
		model.removeAllElements();
		ArrayList<JoueurAutre> list;
		if(isInGame) {
			list = Launch.getInstance().getData().getJoueursAutresInGame();
		} else {
			list = Launch.getInstance().getData().getJoueursAutres();
		}
		for(int i=0;i<list.size();i++){
			model.addElement(list.get(i));
		}
	}

	public void enableButtons() {
		versLeStockBouton.setEnabled(!inGame.isSelectionEmpty());
		supprimerjoueurBouton.setEnabled(!inStock.isSelectionEmpty());
		enregistrerBouton.setEnabled(!inStock.isSelectionEmpty());
		inGameBouton.setEnabled(!inGame.isSelectionEmpty() && !inStock.isSelectionEmpty());
		exporterBouton.setEnabled(!inStock.isSelectionEmpty());
	}

	public void exportJoueurs() {
		String message = TextsProperties.MESSAGE_EXPORT1 + "\n";
		for(JoueurAutre joueur : inStock.getSelectedValuesList()) {
			message += joueur.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_EXPORT2;

		String nom = JOptionPane.showInputDialog(this, message);
		if (nom != null && ! "".equals(nom)) {
			File file = new File("exchange/randoms/"+nom+".json");
			if(file.exists()) {
				int res = JOptionPane.showConfirmDialog(this, TextsProperties.MESSAGE_FICHIEREXISTANT, TextsProperties.BUTTON_EXPORT, JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION) {
					Launch.getInstance().exportRandoms(inStock.getSelectedValuesList(), file.toPath());
				} else {
					exportJoueurs();
				}
			} else {
				Launch.getInstance().exportRandoms(inStock.getSelectedValuesList(), file.toPath());
			}
		}
	}

	public void importJoueurs() {
		File dir = new File("exchange/randoms");
		File[] fichiers = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".json");
			}
		});

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
				Launch.getInstance().importRandoms(new File("exchange/randoms/"+nom).toPath());
				remplirListes(false);
			}
		}
	}

	public void supprimerJoueurs() {
		String message = TextsProperties.MESSAGE_DELETE + "\n";
		for(JoueurAutre joueur : inStock.getSelectedValuesList()) {
			message += joueur.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_IRREVERSIBLE + " " + TextsProperties.MESSAGE_SURE;

		int res = JOptionPane.showConfirmDialog(this, message, TextsProperties.BUTTON_DELETE, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			for(JoueurAutre j : inStock.getSelectedValuesList()) {
				if(!"".equals(j.getEquipes())){
					JOptionPane.showMessageDialog(this, j.getNom() + "\n" + TextsProperties.MESSAGE_IMPOSSIBLESUPPRIMER + "\n" + j.getEquipes());
					continue;
				}
				Launch.getInstance().getData().supprimerJoueurAutre(j);	
			}
			remplirListes(false);
			Launch.getInstance().saveData();	
		}
		Launch.getInstance().getGui().getEquipesGUI().majGui();
	}

	public void creerJoueur() {
		JoueurAutre nouveau = Launch.getInstance().getData().nouveauJoueurAutre();
		remplirListes(false);
		Launch.getInstance().saveData();
		inStock.setSelectedValue(nouveau, true);
		Launch.getInstance().getGui().getEquipesGUI().majGui();
	}

	public void ajouterJoueursAuStock() {
		String message = TextsProperties.MESSAGE_ADDELEMENTS + "\n";
		for(JoueurAutre joueur : inGame.getSelectedValuesList()) {
			message += joueur.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_SURE;

		int res = JOptionPane.showConfirmDialog(this, message, TextsProperties.BUTTON_ADD, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			Launch.getInstance().getData().ajouterJoueurAutreAuStock((ArrayList<JoueurAutre>)inGame.getSelectedValuesList());
		}
	}
	
	public void sauvegarderJoueur() {
		JoueurAutre j = inStock.getSelectedValue();
		joueurPanel.saveJoueur();
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
			Launch.getInstance().getData().saveJoueurAutreIntoGame(inStock.getSelectedValue(), inGame.getSelectedIndex());
			Launch.getInstance().getData().loadJoueursAutresFromGame();
			remplirListes(true);
		}
	}
}
