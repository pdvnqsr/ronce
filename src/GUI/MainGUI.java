package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import data.Joueur;
import main.Launch;

public class MainGUI extends JFrame {

	private static final long serialVersionUID = 1L;

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

	public static Color darkBase = new Color(18,55,115);
	public static Color lightBase = new Color(240,250,250);
	public static Color gris = new Color(29,29,39);
	public static Color jaune = new Color(223,201,54);
	public static Color selectionBackground = new Color(11,98,148);
	public static Color selectionBorder = new Color(12,240,246);
	public static Font textFont;
	public static Font titreFont;

	static{
		try{
			textFont = Font.createFont(Font.TRUETYPE_FONT,new File("fonts/texte.ttf"));
			titreFont = Font.createFont(Font.TRUETYPE_FONT,new File("fonts/titre.ttf"));
		} catch(Exception e){e.printStackTrace();}
	}

	public MainGUI() {
		// Config visuelle
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			UIManager.put("Panel.background",darkBase);
			UIManager.put("Panel.font",textFont.deriveFont(Font.PLAIN,14));
			UIManager.put("Panel.foreground",lightBase);

			UIManager.put("Button.font",textFont.deriveFont(Font.PLAIN,14));

			UIManager.put("TitledBorder.titleColor",lightBase);
			UIManager.put("TitledBorder.font",titreFont.deriveFont(Font.PLAIN,14));

			UIManager.put("Label.background",darkBase);
			UIManager.put("Label.font",titreFont.deriveFont(Font.PLAIN,15));
			UIManager.put("Label.foreground",lightBase);

			UIManager.put("List.background",gris);
			UIManager.put("List.font",textFont.deriveFont(Font.BOLD,16));
			UIManager.put("List.foreground",lightBase);
			UIManager.put("List.selectionBackground",selectionBackground);
			UIManager.put("List.selectionForeground",lightBase);

			UIManager.put("OptionPane.background",darkBase);
			UIManager.put("OptionPane.font",textFont.deriveFont(Font.PLAIN,16));
			UIManager.put("OptionPane.foreground",lightBase);
			UIManager.put("OptionPane.MessageFont",textFont.deriveFont(Font.PLAIN,16));
			UIManager.put("OptionPane.messageForeground",lightBase);
			
			UIManager.put("Slider.background",darkBase);
			UIManager.put("Slider.tickColor",gris);
			UIManager.put("Slider.highlight",gris);
			UIManager.put("Slider.shadow",gris);
			
			/*UIManager.put("ComboBox.background",gris);
			UIManager.put("ComboBox.foreground",lightBase);
			UIManager.put("ComboBox.selectionBackground",selectionBackground);
			UIManager.put("ComboBox.selectionForeground",lightBase);
			UIManager.put("Table.background",gris);
			
			UIManager.put("TextField.background",gris);
			UIManager.put("TextField.foreground",lightBase);*/
			
			UIManager.put("ActiveCaption",Color.RED);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Actions
		JPanel boutonsPanel = new JPanel();
		versLeStockBouton = new JButton("Ajouter au stock");
		versLeStockBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ajouterJoueursAuStock();
			}
		});
		creerjoueurBouton = new JButton("Créer");
		creerjoueurBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creerJoueur();
			}
		});
		supprimerjoueurBouton = new JButton("Supprimer");
		supprimerjoueurBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				supprimerJoueurs();
			}
		});
		enregistrerBouton = new JButton("Sauvegarder");
		enregistrerBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sauvegarderJoueur();
			}
		});
		inGameBouton = new JButton("Envoyer vers le jeu");
		inGameBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				envoyerInGame();
			}
		});
		exporterBouton = new JButton("Exporter");
		exporterBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportJoueurs();
			}
		});
		importerBouton = new JButton("Importer");
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
		getContentPane().add(boutonsPanel, BorderLayout.NORTH);

		// Présentation/édition d'un joueur
		joueurPanel = new JoueurPanel();
		JScrollPane scroll = new JScrollPane(joueurPanel);
		getContentPane().add(scroll,BorderLayout.CENTER);

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
		listesPanel.add(getListePanel(inGame, "Joueurs dans le jeu"));
		listesPanel.add(getListePanel(inStock, "Tous mes joueurs"));
		getContentPane().add(listesPanel, BorderLayout.WEST);


		// Config fenêtre
		setTitle("R.O.N.C.E : Rise Of New Champions Editor");
		setIconImage(new ImageIcon("icon.png").getImage());
		setPreferredSize(new Dimension(1280,720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setLocationRelativeTo(getParent());
		setVisible(true);

		enableButtons();
	}

	public static JPanel getListePanel(JList<?> liste,String nom){
		JPanel listPanel = new JPanel(new BorderLayout());
		listPanel.setBorder(new EmptyBorder(5,5,5,5));
		listPanel.setPreferredSize(new Dimension(150,720));

		JLabel titre = new JLabel(nom);
		titre.setHorizontalAlignment(JLabel.CENTER);
		listPanel.add(titre,BorderLayout.NORTH);

		JScrollPane scroll = new JScrollPane(liste);
		listPanel.add(scroll,BorderLayout.CENTER);

		return listPanel;
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
		String message = "Vous allez exporter les joueurs suivants : \n";
		for(Joueur joueur : inStock.getSelectedValuesList()) {
			message += joueur.getNom() + "\n";
		}
		message += "\nIndiquez le nom du fichier";

		String nom = JOptionPane.showInputDialog(this, message);
		if (nom != null && ! "".equals(nom)) {
			Launch.getInstance().exportJoueurs(inStock.getSelectedValuesList(), new File("exchange/"+nom+".json").toPath());
		}
	}

	public void importJoueurs() {
		File dir = new File("exchange");
		File[] fichiers = dir.listFiles();

		if(fichiers.length == 0) {
			JOptionPane.showMessageDialog(this, "Aucun fichier disponible pour l'import.");
		} else {

			String message = "Sélectionnez le fichier à importer : ";
			String[] nomsFichiers = new String[fichiers.length];
			for(int i=0;i<nomsFichiers.length;i++) {
				nomsFichiers[i] = fichiers[i].getName();
			}

			String nom = JOptionPane.showInputDialog(
					this, message, "Importer", JOptionPane.PLAIN_MESSAGE, null, nomsFichiers, nomsFichiers[0]).toString();
			if (nom != null && ! "".equals(nom)) {
				Launch.getInstance().importJoueurs(new File("exchange/"+nom).toPath());
				remplirListesJoueurs(false);
			}
		}
	}

	public void supprimerJoueurs() {
		String message = "Vous allez supprimer les joueurs suivants : \n";
		for(Joueur joueur : inStock.getSelectedValuesList()) {
			message += joueur.getNom() + "\n";
		}
		message += "\nCette action est irréversible, êtes-vous sûr ?";

		int res = JOptionPane.showConfirmDialog(this, message, "Supprimer", JOptionPane.YES_NO_OPTION);
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
		String message = "Vous allez ajouter les joueurs suivants : \n";
		for(Joueur joueur : inGame.getSelectedValuesList()) {
			message += joueur.getNom() + "\n";
		}
		message += "\nEtes-vous sûr ?";

		int res = JOptionPane.showConfirmDialog(this, message, "Ajouter au stock", JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			for(Joueur joueur : inGame.getSelectedValuesList()) {
				Launch.getInstance().getData().getJoueurs().add(joueur);					
			}
			remplirListesJoueurs(false);
			Launch.getInstance().saveData();
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
		String message = "Vous allez remplacer dans le jeu, le joueur : \n";
		message += inGame.getSelectedValue().getNom() + "\n";
		message += "Par le joueur : \n";
		message += inStock.getSelectedValue().getNom() + "\n";
		message += "\nCette action est irréversible, êtes-vous sûr ?";
		
		int res = JOptionPane.showConfirmDialog(this, message, "Envoyer dans le jeu", JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			Launch.getInstance().getData().saveIntoGame(inStock.getSelectedValue(), inGame.getSelectedIndex()+1);
			Launch.getInstance().getData().loadJoueursFromGame();
			remplirListesJoueurs(true);
		}
	}
}
