package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import data.Equipe;
import data.properties.TextsProperties;

public class BuildsGUI extends JPanel {

	private static final long serialVersionUID = 6079462095300583953L;
	
	private JList<Equipe> inGame;
	private JList<Equipe> inStock;
	private EquipePanel panel;

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
		boutonsPanel.add(creerBouton);
		boutonsPanel.add(supprimerBouton);
		boutonsPanel.add(enregistrerBouton);
		boutonsPanel.add(inGameBouton);
		boutonsPanel.add(exporterBouton);
		boutonsPanel.add(importerBouton);
		add(boutonsPanel, BorderLayout.NORTH);

		// Présentation/édition d'un joueur
		panel = new EquipePanel();
		JScrollPane scroll = new JScrollPane(panel);
		add(scroll,BorderLayout.CENTER);

		// Listes de joueurs
		inGame = new JList<Equipe>();
		inGame.setModel(new DefaultListModel<Equipe>());
		remplirListes(true);
		inGame.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				enableButtons();
				panel.setEnabled(false);
				//panel.loadJoueur(inGame.getSelectedValue());
			}
		});

		inStock = new JList<Equipe>();
		inStock.setModel(new DefaultListModel<Equipe>());
		remplirListes(false);
		inStock.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				enableButtons();
				panel.setEnabled(true);
				//TODO joueurPanel.loadJoueur(inStock.getSelectedValue());
			}
		});

		JPanel listesPanel = new JPanel(new GridLayout(1,2));
		listesPanel.add(MainGUI.getListePanel(inGame, TextsProperties.LABEL_LISTINGAME));
		listesPanel.add(MainGUI.getListePanel(inStock, TextsProperties.LABEL_LISTINSTOCK));
		add(listesPanel, BorderLayout.WEST);
		
		enableButtons();
	}

	public void remplirListes(boolean isInGame){
		DefaultListModel<Equipe> model;
		if(isInGame) {
			model = (DefaultListModel<Equipe>) inGame.getModel();
		} else {
			model = (DefaultListModel<Equipe>) inStock.getModel();
		}	
		model.removeAllElements();
		//TODO
		/*ArrayList<Equipe> list;
		if(isInGame) {
			list = Launch.getInstance().getData().getJoueursInGame();
		} else {
			list = Launch.getInstance().getData().getJoueurs();
		}
		for(int i=0;i<list.size();i++){
			model.addElement(list.get(i));
		}*/
	}

	public void enableButtons() {
		versLeStockBouton.setEnabled(!inGame.isSelectionEmpty());
		supprimerBouton.setEnabled(!inStock.isSelectionEmpty());
		enregistrerBouton.setEnabled(!inStock.isSelectionEmpty());
		inGameBouton.setEnabled(!inGame.isSelectionEmpty() && !inStock.isSelectionEmpty());
		exporterBouton.setEnabled(!inStock.isSelectionEmpty());
	}

	public void exportJoueurs() {
		//TODO
		/*String message = TextsProperties.MESSAGE_EXPORT1 + "\n";
		for(Joueur joueur : inStock.getSelectedValuesList()) {
			message += joueur.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_EXPORT2;

		String nom = JOptionPane.showInputDialog(this, message);
		if (nom != null && ! "".equals(nom)) {
			Launch.getInstance().exportJoueurs(inStock.getSelectedValuesList(), new File("exchange/"+nom+".json").toPath());
		}*/
	}

	public void importJoueurs() {
		//TODO
		/*File dir = new File("exchange");
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
				Launch.getInstance().importJoueurs(new File("exchange/"+nom).toPath());
				remplirListesJoueurs(false);
			}
		}*/
	}

	public void supprimer() {
		//TODO
		/*String message = TextsProperties.MESSAGE_DELETE + "\n";
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
		}*/
	}

	public void creer() {
		//TODO
		/*Joueur nouveau = Launch.getInstance().getData().nouveauJoueur();
		remplirListesJoueurs(false);
		Launch.getInstance().saveData();
		inStock.setSelectedValue(nouveau, true);*/
	}

	public void ajouterAuStock() {
		//TODO
		/*String message = TextsProperties.MESSAGE_ADDPLAYERS + "\n";
		for(Joueur joueur : inGame.getSelectedValuesList()) {
			message += joueur.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_SURE;

		int res = JOptionPane.showConfirmDialog(this, message, TextsProperties.BUTTON_ADD, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			for(Joueur joueur : inGame.getSelectedValuesList()) {
				Launch.getInstance().getData().getJoueurs().add(joueur);					
			}
			remplirListesJoueurs(false);
			Launch.getInstance().saveData();
		}*/
	}
	
	public void sauvegarder() {
		//TODO
		/*Joueur j = inStock.getSelectedValue();
		joueurPanel.saveJoueur();
		Launch.getInstance().saveData();
		remplirListesJoueurs(false);
		inStock.setSelectedValue(j, true);*/
	}
	
	public void envoyerInGame() {
		//TODO
		/*String message = TextsProperties.MESSAGE_TOGAME1 + "\n";
		message += inGame.getSelectedValue().getNom() + "\n";
		message += TextsProperties.MESSAGE_TOGAME2 + "\n";
		message += inStock.getSelectedValue().getNom() + "\n";
		message += "\n" + TextsProperties.MESSAGE_IRREVERSIBLE + " " + TextsProperties.MESSAGE_SURE;
		
		int res = JOptionPane.showConfirmDialog(this, message,TextsProperties.BUTTON_TOGAME, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			Launch.getInstance().getData().saveIntoGame(inStock.getSelectedValue(), inGame.getSelectedIndex()+1);
			Launch.getInstance().getData().loadJoueursFromGame();
			remplirListesJoueurs(true);
		}*/
	}
}
