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

import data.Equipe;
import data.Joueur;
import data.properties.TextsProperties;
import main.Launch;

public class EquipesGUI extends JPanel {

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
	
	
	public EquipesGUI() {
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

		panel = new EquipePanel();
		JScrollPane scroll = new JScrollPane(panel);
		add(scroll,BorderLayout.CENTER);

		inGame = new JList<Equipe>();
		inGame.setModel(new DefaultListModel<Equipe>());
		remplirListes(true);
		inGame.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				enableButtons();
				panel.setEnabled(false);
				panel.load(inGame.getSelectedValue());
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
				panel.load(inStock.getSelectedValue());
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
		ArrayList<Equipe> list;
		if(isInGame) {
			list = Launch.getInstance().getData().getEquipesInGame();
		} else {
			list = Launch.getInstance().getData().getEquipes();
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
		for(Equipe e : inStock.getSelectedValuesList()) {
			message += e.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_EXPORT2;

		String nom = JOptionPane.showInputDialog(this, message);
		if (nom != null && ! "".equals(nom)) {
			File file = new File("exchange/teams/"+nom+".json");
			if(file.exists()) {
				int res = JOptionPane.showConfirmDialog(this, TextsProperties.MESSAGE_FICHIEREXISTANT, TextsProperties.BUTTON_EXPORT, JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION) {
					Launch.getInstance().exportEquipes(inStock.getSelectedValuesList(), file.toPath());
				} else {
					export();
				}
			} else {
				Launch.getInstance().exportEquipes(inStock.getSelectedValuesList(), file.toPath());
			}
		}
	}

	public void importer() {
		File dir = new File("exchange/teams");
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
				Launch.getInstance().importEquipes(new File("exchange/teams/"+nom).toPath());
				remplirListes(false);
			}
		}
	}

	public void supprimer() {
		String message = TextsProperties.MESSAGE_DELETE + "\n";
		for(Equipe e : inStock.getSelectedValuesList()) {
			message += e.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_IRREVERSIBLE + " " + TextsProperties.MESSAGE_SURE;

		int res = JOptionPane.showConfirmDialog(this, message, TextsProperties.BUTTON_DELETE, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			for(Equipe e : inStock.getSelectedValuesList()) {
				Launch.getInstance().getData().supprimerEquipe(e);	
			}
			remplirListes(false);
			Launch.getInstance().saveData();	
		}
	}

	public void creer() {
		Equipe nouveau = Launch.getInstance().getData().nouvelleEquipe();
		remplirListes(false);
		Launch.getInstance().saveData();
		inStock.setSelectedValue(nouveau, true);
	}

	public void ajouterAuStock() {
		String message = TextsProperties.MESSAGE_ADDPLAYERS + "\n";
		ArrayList<Joueur> joueursToImport = new ArrayList<Joueur>();
		ArrayList<String> idToReplace = new ArrayList<String>();
		String id;
		Joueur j;
		String listeJoueurs = "";
		
		for(Equipe e : inGame.getSelectedValuesList()) {
			message += e.getNom() + "\n";
			
			for(int i=0;i<e.getJoueurs().length;i++) {
				id = e.getJoueurs()[i];
				if(id.startsWith("NH-")) {
					j = Launch.getInstance().getData().getJoueursInGame().get(Integer.parseInt(id.split("-")[1]));
					if(!joueursToImport.contains(j)) {						
						joueursToImport.add(j);
						idToReplace.add(id);
						listeJoueurs += "\n" + j.getNom();
					}
				}
			}
		}
		
		if(!"".equals(listeJoueurs)) {
			message += "\n" + TextsProperties.MESSAGE_ADDPLAYERS + listeJoueurs + "\n";
		}
		
		message += "\n" + TextsProperties.MESSAGE_SURE;

		int res = JOptionPane.showConfirmDialog(this, message, TextsProperties.BUTTON_ADD, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			ArrayList<String> idAjoutes= Launch.getInstance().getData().ajouterJoueursAuStock(joueursToImport);
			
			for(Equipe e : inGame.getSelectedValuesList()) {
				e.setId(e.regenerateId());
				for(int i=0;i<e.getJoueurs().length;i++) {
					if(idToReplace.contains(e.getJoueurs()[i])) {
						e.getJoueurs()[i] = idAjoutes.get(idToReplace.indexOf(e.getJoueurs()[i]));
					}
				}
				Launch.getInstance().getData().getEquipes().add(e);					
			}
			
			remplirListes(false);
			Launch.getInstance().saveData();
		}
	}
	
	public void sauvegarder() {
		Equipe e = inStock.getSelectedValue();
		panel.save();
		Launch.getInstance().saveData();
		remplirListes(false);
		inStock.setSelectedValue(e, true);
	}
	
	public void envoyerInGame() {
		String message = TextsProperties.MESSAGE_TOGAME1 + "\n";
		message += inGame.getSelectedValue().getNom() + "\n";
		message += TextsProperties.MESSAGE_TOGAME2 + "\n";
		message += inStock.getSelectedValue().getNom() + "\n";
		message += "\n" + TextsProperties.MESSAGE_IRREVERSIBLE + " " + TextsProperties.MESSAGE_SURE;
		
		int res = JOptionPane.showConfirmDialog(this, message,TextsProperties.BUTTON_TOGAME, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			Launch.getInstance().getData().saveEquipeIntoGame(inStock.getSelectedValue(), inGame.getSelectedIndex()+1);
			Launch.getInstance().getData().loadEquipesFromGame();
			remplirListes(true);
		}
	}
}
