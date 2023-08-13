package GUI.utils;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import data.elements.Joueur;
import data.properties.TextsProperties;

public class JoueursToGameDialog extends JDialog {

	private static final long serialVersionUID = 3814665338070483032L;

	private String deselectedItem;
	
	private int res;
	private ArrayList<JComboBox<String>> fields;
	private ArrayList<Integer> selection;
	
	
	public JoueursToGameDialog(HashMap<Joueur, Integer> joueursAEdit, ArrayList<Joueur> choix) {
		fields = new ArrayList<JComboBox<String>>();
		selection = new ArrayList<Integer>();
		
		getContentPane().add(new JLabel(TextsProperties.MESSAGE_REMPLACERJOUEURS), BorderLayout.NORTH);

		JPanel selectionPanel = new JPanel(new GridLayout(joueursAEdit.size() + 1, 2));
		selectionPanel.add(new JLabel(TextsProperties.LABEL_LISTINSTOCK));
		selectionPanel.add(new JLabel(TextsProperties.LABEL_LISTINGAME));
		int i=0;
		for(Joueur joueur : joueursAEdit.keySet()) {
			selectionPanel.add(new JLabel(joueur.getNom()));
			selectionPanel.add(makeInGameJouersComboboxComponent(choix,i));
			i++;
		}
		getContentPane().add(selectionPanel, BorderLayout.CENTER);
		
		JPanel boutonsPanel = new JPanel();
		JButton boutonValider = new JButton(TextsProperties.BUTTON_VALIDER);
		boutonValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				res = JOptionPane.OK_OPTION;
				setSelection();
				dispose();
			}
		});
		JButton boutonAnnuler = new JButton(TextsProperties.BUTTON_ANNULER);
		boutonAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				res = JOptionPane.CANCEL_OPTION;
				dispose();
			}
		});
		boutonsPanel.add(boutonValider);
		boutonsPanel.add(boutonAnnuler);
		getContentPane().add(boutonsPanel, BorderLayout.SOUTH);
		
		setModal(true);
		pack();
		setLocationRelativeTo(getParent());
		setVisible(true);
	}

	private void setSelection(){
		for(JComboBox<String> field : fields) {
			selection.add(field.getSelectedIndex());
		}
	}
	
	public JComboBox<String> makeInGameJouersComboboxComponent(ArrayList<Joueur> choix, int defaut) {
		JComboBox<String> component = new JComboBox<String>();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for(int i=0 ; i<choix.size() ; i++) {
			model.addElement(choix.get(i).getNom());
		}
		component.setModel(model);
		component.setSelectedIndex(defaut);
		AutoCompleteDecorator.decorate(component);
		
		component.addItemListener(new ItemListener() {
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
		
		fields.add(component);
		return component;
	}

	private void swapSelection(JComboBox<String> sourceField, String selected) {
		for(JComboBox<String> field : fields) {
			if(!field.equals(sourceField) && selected.equals(field.getSelectedItem())) {
				field.setSelectedItem(deselectedItem);
			}
		}
		deselectedItem = null;
	}
	
	public int getRes() {
		return res;
	}

	public ArrayList<Integer> getSelection() {
		return selection;
	}
	
}
