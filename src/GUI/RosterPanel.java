package GUI;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
	
	private String deselectedItem;

	public RosterPanel() {
		setLayout(new GridLayout(18, 2));

		joueurFields = new ArrayList<JComboBox<JoueurMapping>>();
		numeroFields = new ArrayList<JComboBox<String>>();

		for(int i=0;i<DataProperties.EQUIPE_JOUEURS.getOffsets().length;i++) {
			joueurFields.add(makeJoueursComboboxComponent());
		}

		JComboBox<String> field;
		for(int i=0;i<DataProperties.EQUIPE_NUMEROS.getOffsets().length;i++) {
			field = makeComboboxComponent(DataProperties.EQUIPE_NUMEROS);
			numeroFields.add(field);
			field.addItemListener(new ItemListener() {
				@SuppressWarnings("unchecked")
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.DESELECTED) {
						deselectedItem = e.getItem().toString();
					} else {
						swapSelection((JComboBox<String>)e.getSource(), e.getItem().toString());
					}
				}
			});
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
						joueurFields.get(i).setSelectedItem(DataProperties.JOUEURSBASE.getVals().get(Integer.parseInt(id)));
					} catch (Exception ex) {
						j = Launch.getInstance().getData().getJoueurParId(id);
						if(j != null) {
							joueurFields.get(i).setSelectedItem(new JoueurMapping(j.getId(), j.getNom()));
						}
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
			try {
				val = Integer.parseInt(id);
				id = Launch.getInstance().getData().getJoueurId(val);
			} catch (Exception ex) {}
			
			if(id.startsWith("NH-")) {
				joueursToImport.add(Launch.getInstance().getData().getJoueursInGame().get(Integer.parseInt(id.split("-")[1])));
				indexesToSave.add(i);
				e.getJoueurs()[i] = id;
			} else {
				e.getJoueurs()[i] = id;
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
		
		String message = TextsProperties.MESSAGE_JOUEURSMANQUANTS + "\n";
		for(Joueur joueur : joueurs) {
			message += joueur.getNom() + "\n";
		}

		JOptionPane.showMessageDialog(Launch.getInstance().getGui(), message);
		idAjoutes = Launch.getInstance().getData().ajouterJoueursAuStock(joueurs);
		return idAjoutes;
	}
	
	private void swapSelection(JComboBox<String> sourceField, String selected) {
		for(JComboBox<String> field : numeroFields) {
			if(!field.equals(sourceField) && selected.equals(field.getSelectedItem())) {
				field.setSelectedItem(deselectedItem);
			}
		}
		deselectedItem = null;
	}
}
