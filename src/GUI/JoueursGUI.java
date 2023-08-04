package GUI;

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

import data.Joueur;
import data.properties.TextsProperties;
import main.Launch;

public class JoueursGUI extends JPanel {

	private static final long serialVersionUID = -6559051654385212939L;
	private JList<Joueur> inGame;
	private JList<Joueur> inStock;
	private JoueurPanel joueurPanel;

	private JButton versLeStockBouton;
	private JButton creerjoueurBouton;
	private JButton supprimerjoueurBouton;
	private JButton enregistrerBouton;
	private JButton inGameBouton;
	private JButton exporterBouton;
	private JButton importerBouton;
	
	public JoueursGUI() {
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
		joueurPanel = new JoueurPanel();
		JScrollPane scroll = new JScrollPane(joueurPanel);
		add(scroll,BorderLayout.CENTER);

		// Listes de joueurs
		inGame = new JList<Joueur>();
		inGame.setModel(new DefaultListModel<Joueur>());
		remplirListesJoueurs(true);
		inGame.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				enableButtons();
				joueurPanel.setEnabled(false);
				joueurPanel.loadJoueur(inGame.getSelectedValue());
			}
		});

		inStock = new JList<Joueur>();
		inStock.setModel(new DefaultListModel<Joueur>());
		remplirListesJoueurs(false);
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
	
	
	public void remplirListesJoueurs(boolean isInGame){
		DefaultListModel<Joueur> model;
		if(isInGame) {
			model = (DefaultListModel<Joueur>) inGame.getModel();
		} else {
			model = (DefaultListModel<Joueur>) inStock.getModel();
		}	
		model.removeAllElements();
		ArrayList<Joueur> list;
		if(isInGame) {
			list = Launch.getInstance().getData().getJoueursInGame();
		} else {
			list = Launch.getInstance().getData().getJoueurs();
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
		for(Joueur joueur : inStock.getSelectedValuesList()) {
			message += joueur.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_EXPORT2;

		String nom = JOptionPane.showInputDialog(this, message);
		if (nom != null && ! "".equals(nom)) {
			File file = new File("exchange/players/"+nom+".json");
			if(file.exists()) {
				int res = JOptionPane.showConfirmDialog(this, TextsProperties.MESSAGE_FICHIEREXISTANT, TextsProperties.BUTTON_EXPORT, JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION) {
					Launch.getInstance().exportJoueurs(inStock.getSelectedValuesList(), file.toPath());
				} else {
					exportJoueurs();
				}
			} else {
				Launch.getInstance().exportJoueurs(inStock.getSelectedValuesList(), file.toPath());
			}
		}
	}

	public void importJoueurs() {
		File dir = new File("exchange/players");
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
				Launch.getInstance().importJoueurs(new File("exchange/players/"+nom).toPath());
				remplirListesJoueurs(false);
			}
		}
	}

	public void supprimerJoueurs() {
		//TODO ajouter dépendance aux équipes
		String message = TextsProperties.MESSAGE_DELETE + "\n";
		for(Joueur joueur : inStock.getSelectedValuesList()) {
			message += joueur.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_IRREVERSIBLE + " " + TextsProperties.MESSAGE_SURE;

		int res = JOptionPane.showConfirmDialog(this, message, TextsProperties.BUTTON_DELETE, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			for(Joueur j : inStock.getSelectedValuesList()) {
				Launch.getInstance().getData().supprimerJoueur(j);	
			}
			remplirListesJoueurs(false);
			Launch.getInstance().saveData();	
		}
	}

	public void creerJoueur() {
		Joueur nouveau = Launch.getInstance().getData().nouveauJoueur();
		remplirListesJoueurs(false);
		Launch.getInstance().saveData();
		inStock.setSelectedValue(nouveau, true);
	}

	public void ajouterJoueursAuStock() {
		String message = TextsProperties.MESSAGE_ADDELEMENTS + "\n";
		for(Joueur joueur : inGame.getSelectedValuesList()) {
			message += joueur.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_SURE;

		int res = JOptionPane.showConfirmDialog(this, message, TextsProperties.BUTTON_ADD, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			Launch.getInstance().getData().ajouterJoueursAuStock((ArrayList<Joueur>)inGame.getSelectedValuesList());
		}
	}
	
	public void sauvegarderJoueur() {
		Joueur j = inStock.getSelectedValue();
		joueurPanel.saveJoueur();
		Launch.getInstance().saveData();
		remplirListesJoueurs(false);
		inStock.setSelectedValue(j, true);
	}
	
	public void envoyerInGame() {
		String message = TextsProperties.MESSAGE_TOGAME1 + "\n";
		message += inGame.getSelectedValue().getNom() + "\n";
		message += TextsProperties.MESSAGE_TOGAME2 + "\n";
		message += inStock.getSelectedValue().getNom() + "\n";
		message += "\n" + TextsProperties.MESSAGE_IRREVERSIBLE + " " + TextsProperties.MESSAGE_SURE;
		
		int res = JOptionPane.showConfirmDialog(this, message,TextsProperties.BUTTON_TOGAME, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			Launch.getInstance().getData().saveIntoGame(inStock.getSelectedValue(), inGame.getSelectedIndex());
			Launch.getInstance().getData().loadJoueursFromGame();
			remplirListesJoueurs(true);
		}
	}
}
