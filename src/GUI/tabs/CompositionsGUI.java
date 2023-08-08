package GUI.tabs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GUI.MainGUI;
import GUI.dialogs.JoueursToGameDialog;
import GUI.panels.CompositionPanel;
import data.elements.Composition;
import data.elements.Joueur;
import data.properties.TextsProperties;
import main.Launch;

public class CompositionsGUI extends JPanel {

	private static final long serialVersionUID = 3866850435545699476L;

	private JList<Composition> inGame;
	private JList<Composition> inStock;
	private CompositionPanel panel;

	private JButton versLeStockBouton;
	private JButton creerBouton;
	private JButton supprimerBouton;
	private JButton enregistrerBouton;
	private JButton inGameBouton;
	private JButton exporterBouton;
	private JButton importerBouton;
	
	
	public CompositionsGUI() {
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

		panel = new CompositionPanel();
		JScrollPane scroll = new JScrollPane(panel);
		add(scroll,BorderLayout.CENTER);

		inGame = new JList<Composition>();
		inGame.setModel(new DefaultListModel<Composition>());
		remplirListes(true);
		inGame.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				enableButtons();
				panel.setEnabled(false);
				panel.load(inGame.getSelectedValue());
			}
		});

		inStock = new JList<Composition>();
		inStock.setModel(new DefaultListModel<Composition>());
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
		DefaultListModel<Composition> model;
		if(isInGame) {
			model = (DefaultListModel<Composition>) inGame.getModel();
		} else {
			model = (DefaultListModel<Composition>) inStock.getModel();
		}	
		model.removeAllElements();
		ArrayList<Composition> list;
		if(isInGame) {
			list = Launch.getInstance().getData().getCompositionsInGame();
		} else {
			list = Launch.getInstance().getData().getCompositions();
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
		for(Composition c : inStock.getSelectedValuesList()) {
			message += c.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_EXPORT2;

		String nom = JOptionPane.showInputDialog(this, message);
		if (nom != null && ! "".equals(nom)) {
			File file = new File("exchange/compositions/"+nom+".json");
			if(file.exists()) {
				int res = JOptionPane.showConfirmDialog(this, TextsProperties.MESSAGE_FICHIEREXISTANT, TextsProperties.BUTTON_EXPORT, JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION) {
					Launch.getInstance().exportCompositions(inStock.getSelectedValuesList(), file.toPath());
				} else {
					export();
				}
			} else {
				Launch.getInstance().exportCompositions(inStock.getSelectedValuesList(), file.toPath());
			}
		}
	}

	public void importer() {
		File dir = new File("exchange/compositions");
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
				Launch.getInstance().importCompositions(new File("exchange/compositions/"+nom).toPath());
				remplirListes(false);
				Launch.getInstance().getGui().getJoueursGUI().remplirListesJoueurs(false);
			}
		}
	}

	public void supprimer() {
		String message = TextsProperties.MESSAGE_DELETE + "\n";
		for(Composition c : inStock.getSelectedValuesList()) {
			message += c.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_IRREVERSIBLE + " " + TextsProperties.MESSAGE_SURE;

		int res = JOptionPane.showConfirmDialog(this, message, TextsProperties.BUTTON_DELETE, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			for(Composition c : inStock.getSelectedValuesList()) {
				Launch.getInstance().getData().supprimerComposition(c);	
			}
			remplirListes(false);
			Launch.getInstance().saveData();	
		}
	}

	public void creer() {
		Composition nouveau = Launch.getInstance().getData().nouvelleComposition();
		remplirListes(false);
		Launch.getInstance().saveData();
		inStock.setSelectedValue(nouveau, true);
	}

	public void ajouterAuStock() {
		String message = TextsProperties.MESSAGE_ADDELEMENTS + "\n";
		ArrayList<Joueur> joueursToImport = new ArrayList<Joueur>();
		ArrayList<String> idToReplace = new ArrayList<String>();
		String id;
		Joueur j;
		String listeJoueurs = "";
		
		for(Composition c : inGame.getSelectedValuesList()) {
			message += c.getNom() + "\n";
			
			for(int i=0;i<c.getJoueurs().length;i++) {
				id = c.getJoueurs()[i];
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
			message += "\n" + TextsProperties.MESSAGE_JOUEURSMANQUANTS + listeJoueurs + "\n";
		}
		
		message += "\n" + TextsProperties.MESSAGE_SURE;

		int res = JOptionPane.showConfirmDialog(this, message, TextsProperties.BUTTON_ADD, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			ArrayList<String> idAjoutes= Launch.getInstance().getData().ajouterJoueursAuStock(joueursToImport);
			
			for(Composition c : inGame.getSelectedValuesList()) {
				c.setId(c.regenerateId());
				for(int i=0;i<c.getJoueurs().length;i++) {
					if(idToReplace.contains(c.getJoueurs()[i])) {
						c.getJoueurs()[i] = idAjoutes.get(idToReplace.indexOf(c.getJoueurs()[i]));
					}
				}
				Launch.getInstance().getData().getCompositions().add(c);					
			}
			
			remplirListes(false);
			Launch.getInstance().saveData();
		}
	}
	
	public void sauvegarder() {
		Composition c = inStock.getSelectedValue();
		panel.save();
		Launch.getInstance().saveData();
		remplirListes(false);
		inStock.setSelectedValue(c, true);
	}
	
	public void envoyerInGame() {
		String message = TextsProperties.MESSAGE_TOGAME1 + "\n";
		message += inGame.getSelectedValue().getNom() + "\n";
		message += TextsProperties.MESSAGE_TOGAME2 + "\n";
		message += inStock.getSelectedValue().getNom() + "\n";
		message += "\n" + TextsProperties.MESSAGE_IRREVERSIBLE + " " + TextsProperties.MESSAGE_SURE;
		
		int res = JOptionPane.showConfirmDialog(this, message,TextsProperties.BUTTON_TOGAME, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			ArrayList<Joueur> choix = new ArrayList<Joueur>(Launch.getInstance().getData().getJoueursInGame());
			HashMap<Joueur, Integer> joueursAEdit = new HashMap<Joueur, Integer>();
			String id;
			Joueur j;
			Composition composition = new Composition(false); 
			composition.update(inStock.getSelectedValue());
			for(int i=0;i<composition.getJoueurs().length;i++) {
				id = composition.getJoueurs()[i];
				j = Launch.getInstance().getData().getJoueurParId(id);
				if(j != null) {
					if(choix.contains(j)) {
						composition.getJoueurs()[i] = "NH-" + Launch.getInstance().getData().getJoueursInGame().indexOf(j);
						choix.remove(j);
					}
					 else {
						joueursAEdit.put(j, i);
					}
				}
			}
			
			int envoyer = JOptionPane.OK_OPTION;
			
			if(joueursAEdit.size()>0) {
				JoueursToGameDialog dialog = new JoueursToGameDialog(joueursAEdit, choix);
				envoyer = dialog.getRes();
				
				if(envoyer == JOptionPane.OK_OPTION) {
					ArrayList<Integer> selection = dialog.getSelection();
					int i=0;
					int indexInGame;
					for(Joueur joueur : joueursAEdit.keySet()) {
						j = choix.get(selection.get(i));
						indexInGame = Launch.getInstance().getData().getJoueursInGame().indexOf(j);
						composition.getJoueurs()[joueursAEdit.get(joueur)] = "NH-" + indexInGame;
						Launch.getInstance().getData().saveIntoGame(joueur, indexInGame);
						i++;
					}
					Launch.getInstance().getData().loadJoueursFromGame();
					Launch.getInstance().getGui().getJoueursGUI().remplirListesJoueurs(true);
				}
			}
			
			if(envoyer == JOptionPane.OK_OPTION) {
				Launch.getInstance().getData().saveCompositionIntoGame(composition, inGame.getSelectedIndex());
				Launch.getInstance().getData().loadCompositionsFromGame();
				remplirListes(true);
			}
		}
	}
	
	public void majGui() {
		panel.getRosterPanel().majGui();
	}
}
