package GUI;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import data.Equipe;
import data.Joueur;
import data.properties.DataProperties;
import data.properties.JoueurMapping;
import data.properties.TextsProperties;
import main.Launch;

public class RosterPanel extends ElementPanel {

	private static final long serialVersionUID = 4704010769567011307L;

	private ArrayList<JComboBox<JoueurMapping>> joueurFields;
	private ArrayList<JComboBox<String>> numeroFields;

	public RosterPanel() {
		setLayout(new GridLayout(18, 2));

		joueurFields = new ArrayList<JComboBox<JoueurMapping>>();
		numeroFields = new ArrayList<JComboBox<String>>();

		for(int i=0;i<DataProperties.EQUIPE_JOUEURS.getOffsets().length;i++) {
			joueurFields.add(makeJoueursComboboxComponent());
		}

		for(int i=0;i<DataProperties.EQUIPE_NUMEROS.getOffsets().length;i++) {
			numeroFields.add(makeComboboxComponent(DataProperties.EQUIPE_NUMEROS));
		}

		for(int i=0;i<joueurFields.size();i++) {
			add(makeFieldPanel(TextsProperties.LABEL_JOUEUR + " " + (i+1), joueurFields.get(i)));
			add(makeFieldPanel(TextsProperties.LABEL_NUMERO, numeroFields.get(i)));
		}

	}

	public void load(Equipe e) {
		String id;
		int indexInGame;
		int indexInStock;
		Joueur j;
		if(e.getJoueurs() != null) {
			for(int i=0;i<e.getJoueurs().length;i++) 
			{
				id = e.getJoueurs()[i];
				if(id.startsWith("NH-")) {
					indexInGame = Integer.parseInt(id.split("-")[1]);
					j = Launch.getInstance().getData().getJoueursInGame().get(indexInGame);
					indexInStock = Launch.getInstance().getData().getJoueurs().indexOf(j);
					if(indexInStock == -1) {
						joueurFields.get(i).setSelectedItem(new JoueurMapping(id, j.getNom()));
					} else {
						j = Launch.getInstance().getData().getJoueurs().get(indexInStock);
						joueurFields.get(i).setSelectedItem(new JoueurMapping(j.getId(), j.getNom()));
					}
				} else {
					try {
						indexInGame = Integer.parseInt(id);
						joueurFields.get(i).setSelectedItem(DataProperties.JOUEURSBASE.getVals().get(indexInGame));
					} catch (Exception ex) {
						j = Launch.getInstance().getData().getJoueurParId(id);
						joueurFields.get(i).setSelectedItem(new JoueurMapping(j.getId(), j.getNom()));
					}
				}
			}
		}

		if(e.getNumeros() != null) {
			for(int i=0;i<e.getNumeros().length;i++) {
				numeroFields.get(i).setSelectedIndex(e.getNumeros()[i]);
			}
		}
	}

	public void save(Equipe e) {
		int val;
		String id;
		ArrayList<Joueur> joueursToImport = new ArrayList<Joueur>();
		ArrayList<Integer> indexesToSave = new ArrayList<Integer>();
		for(int i=0;i<e.getJoueurs().length;i++) {
			id = ((JoueurMapping)joueurFields.get(i).getSelectedItem()).getInGameValue();
			if(id.startsWith("NH-")) {
				joueursToImport.add(Launch.getInstance().getData().getJoueursInGame().get(Integer.parseInt(id.split("-")[1])));
				indexesToSave.add(i);
				e.getJoueurs()[i] = id;
			} else {
				val = DataProperties.JOUEURSBASE.getIndexFromInGameValue(id, -1);
				if(val != -1) {
					e.getJoueurs()[i] = "" + val; 
				} else {
					e.getJoueurs()[i] = id;
				}
			}
		}
		if(joueursToImport.size() > 0) {
			ArrayList<String> idAjoutes = ajouterJoueursAuStock(joueursToImport);
			for(int i=0;i<idAjoutes.size();i++) {
				e.getJoueurs()[indexesToSave.get(i)] = idAjoutes.get(i);
			}
		}
		
		for(int i=0;i<e.getNumeros().length;i++) {
			e.getNumeros()[i] = numeroFields.get(i).getSelectedIndex();
		}
	}
	
	private ArrayList<String> ajouterJoueursAuStock(ArrayList<Joueur> joueurs) {
		ArrayList<String> idAjoutes = new ArrayList<String>();
		
		String message = TextsProperties.MESSAGE_ADDPLAYERS + "\n";
		for(Joueur joueur : joueurs) {
			message += joueur.getNom() + "\n";
		}
		message += "\n" + TextsProperties.MESSAGE_SURE;

		int res = JOptionPane.showConfirmDialog(Launch.getInstance().getGui(), message, TextsProperties.BUTTON_ADD, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) {
			idAjoutes = Launch.getInstance().getData().ajouterJoueursAuStock(joueurs);
		}
		return idAjoutes;
	}
}
