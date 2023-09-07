package GUI.panels;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.elements.Tactique;
import data.properties.DataProperties;
import data.properties.TextsProperties;

public class TactiquePanel extends ElementPanel {

	private static final long serialVersionUID = 1860827715673979993L;
	
	private JComboBox<String> tactiqueField;
	private JComboBox<String> joueur1Field;
	private JComboBox<String> joueur2Field;
	private JComboBox<String> joueur3Field;
	private JComboBox<String> joueur4Field;
	
	public TactiquePanel(int index) {
		tactiqueField = makeComboboxComponent(DataProperties.EQUIPE_TACTIQUE);
		joueur1Field = makeComboboxComponent(DataProperties.EQUIPE_TACTIQUEJOUEUR1);
		joueur2Field = makeComboboxComponent(DataProperties.EQUIPE_TACTIQUEJOUEUR2);
		joueur3Field = makeComboboxComponent(DataProperties.EQUIPE_TACTIQUEJOUEUR3);
		joueur4Field = makeComboboxComponent(DataProperties.EQUIPE_TACTIQUEJOUEUR4);
		JLabel joueursLabel = new JLabel(TextsProperties.LABEL_JOUEURS);
		JPanel tactiquePanel = makeFieldPanel(TextsProperties.LABEL_TACTIQUE + index, tactiqueField);
		
		tactiqueField.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					manageJoueurFields();
				}
			}
		});
		
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		//layout.setAutoCreateContainerGaps(true);
		layout.setHonorsVisibility(true);

		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addComponent(tactiquePanel)
				.addGroup(layout.createSequentialGroup()
						.addComponent(joueursLabel)
						.addComponent(joueur1Field, 50, 50, 50)
						.addComponent(joueur2Field, 50, 50, 50)
						.addComponent(joueur3Field, 50, 50, 50)
						.addComponent(joueur4Field, 50, 50, 50)
				)
		);
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addComponent(tactiquePanel)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(joueursLabel)
						.addComponent(joueur1Field)
						.addComponent(joueur2Field)
						.addComponent(joueur3Field)
						.addComponent(joueur4Field)
				)
		);
		
		manageJoueurFields();
	}
	
	public void load(Tactique tactique) {
		tactiqueField.setSelectedIndex(tactique.getTactique());
		joueur1Field.setSelectedIndex(tactique.getJoueur1());
		joueur2Field.setSelectedIndex(tactique.getJoueur2());
		joueur3Field.setSelectedIndex(tactique.getJoueur3());
		joueur4Field.setSelectedIndex(tactique.getJoueur4());
	}
	
	public void save(Tactique tactique) {
		tactique.setTactique(tactiqueField.getSelectedIndex());
		tactique.setJoueur1(joueur1Field.getSelectedIndex());
		tactique.setJoueur2(joueur2Field.getSelectedIndex());
		tactique.setJoueur3(joueur3Field.getSelectedIndex());
		tactique.setJoueur4(joueur4Field.getSelectedIndex());
	}
	
	private void manageJoueurFields() {
		int i = DataProperties.EQUIPE_TACTIQUENBJOUEURS.getVals().get(tactiqueField.getSelectedIndex()); 
		if(i == 0) {
			disablefield(joueur1Field);
			disablefield(joueur2Field);
			disablefield(joueur3Field);
			disablefield(joueur4Field);
		}
		if(i == 1) {
			enablefield(joueur1Field,1);
			disablefield(joueur2Field);
			disablefield(joueur3Field);
			disablefield(joueur4Field);
		}
		if(i == 2) {
			enablefield(joueur1Field,1);
			enablefield(joueur2Field,2);
			disablefield(joueur3Field);
			disablefield(joueur4Field);
		}
		if(i == 3) {
			enablefield(joueur1Field,1);
			enablefield(joueur2Field,2);
			enablefield(joueur3Field,3);
			disablefield(joueur4Field);
		}
		if(i == 4) {
			enablefield(joueur1Field,1);
			enablefield(joueur2Field,2);
			enablefield(joueur3Field,3);
			enablefield(joueur4Field,4);
		}
	}
	
	private void disablefield(JComboBox<String> field) {
		field.setEnabled(false);
		field.setSelectedIndex(0);
	}
	
	private void enablefield(JComboBox<String> field, int i) {
		field.setEnabled(true);
		field.setSelectedIndex(i);
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		if(enabled) {
			tactiqueField.setEnabled(enabled);
			manageJoueurFields();	
		} else {
			tactiqueField.setEnabled(enabled);
			joueur1Field.setEnabled(enabled);
			joueur2Field.setEnabled(enabled);
			joueur3Field.setEnabled(enabled);
			joueur4Field.setEnabled(enabled);
		}
		
	}
}
