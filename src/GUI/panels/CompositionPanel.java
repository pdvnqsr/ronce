package GUI.panels;


import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.elements.Composition;
import data.properties.DataProperties;
import data.properties.TextsProperties;

public class CompositionPanel extends ElementPanel {

	private static final long serialVersionUID = -3464583622449755160L;

	private Composition compositionSelectionnee = null;
	
	private JTextField nomField;
	private JTextField idField;
	private JTextField descriptionField;
	
	private JComboBox<String> formationField;
	private JComboBox<String> capitaineField;
	private JComboBox<String> tireurCornerField;
	private RosterPanel rosterPanel;
	
	private TactiquePanel[] tactiquePanels;
	
	public CompositionPanel() {
		FlowLayout layout = new FlowLayout(FlowLayout.LEADING,0,0);
		setLayout(layout);
		
		tactiquePanels = new TactiquePanel[4];
		tactiquePanels[0] = new TactiquePanel(1);
		tactiquePanels[1] = new TactiquePanel(2);
		tactiquePanels[2] = new TactiquePanel(3);
		tactiquePanels[3] = new TactiquePanel(4);
		
		layout = new FlowLayout(FlowLayout.TRAILING,10,10);
		JPanel infos = new JPanel(layout);
		infos.setPreferredSize(new Dimension(300,550));
		add(infos);
		
		rosterPanel = new RosterPanel();
		add(rosterPanel);
		
		JPanel strategie = new JPanel(layout);
		strategie.setPreferredSize(new Dimension(300,550));
		add(strategie);
		
		nomField = new JTextField(15);
		idField = new JTextField(28);
		idField.setEditable(false);
		descriptionField = new JTextField(20);		
		formationField = makeComboboxComponent(DataProperties.EQUIPE_FORMATION);
		capitaineField = makeComboboxComponent(DataProperties.EQUIPE_CAPITAINE);
		tireurCornerField = makeComboboxComponent(DataProperties.EQUIPE_TIREURCORNER);
		
		infos.add(makeFieldPanel(TextsProperties.LABEL_NOM, nomField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_ID, idField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_DESCRIPTION, descriptionField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_FORMATION, formationField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_CAPITAINE, capitaineField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_TIREURCORNER, tireurCornerField));
		
		strategie.add(tactiquePanels[0]);
		strategie.add(tactiquePanels[1]);
		strategie.add(tactiquePanels[2]);
		strategie.add(tactiquePanels[3]);
		
		setEnabled(false);
	}
	
	public void save(){
		if(compositionSelectionnee != null) {
			compositionSelectionnee.setDescription(descriptionField.getText());
			compositionSelectionnee.setNom(nomField.getText());
			compositionSelectionnee.setFormation(formationField.getSelectedIndex());
			compositionSelectionnee.setCapitaine(capitaineField.getSelectedIndex());
			compositionSelectionnee.setTireurCorner(tireurCornerField.getSelectedIndex());
			tactiquePanels[0].save(compositionSelectionnee.getTactiques()[0]);
			tactiquePanels[1].save(compositionSelectionnee.getTactiques()[1]);
			tactiquePanels[2].save(compositionSelectionnee.getTactiques()[2]);
			tactiquePanels[3].save(compositionSelectionnee.getTactiques()[3]);
			rosterPanel.save(compositionSelectionnee);
		}
	}
	
	public void load(Composition composition){
		compositionSelectionnee = composition;

		if(composition != null) {
			idField.setText(composition.getId());
			descriptionField.setText(composition.getDescription());
			nomField.setText(composition.getNom());
			formationField.setSelectedIndex(composition.getFormation());
			capitaineField.setSelectedIndex(composition.getCapitaine());
			tireurCornerField.setSelectedIndex(composition.getTireurCorner());
			tactiquePanels[0].load(composition.getTactiques()[0]);
			tactiquePanels[1].load(composition.getTactiques()[1]);
			tactiquePanels[2].load(composition.getTactiques()[2]);
			tactiquePanels[3].load(composition.getTactiques()[3]);	
			rosterPanel.load(composition);
		}
	}
	
	public Composition getCompositionSelectionnee() {
		return compositionSelectionnee;
	}

	public void setCompositionSelectionnee(Composition compositionSelectionnee) {
		this.compositionSelectionnee = compositionSelectionnee;
	}

	public RosterPanel getRosterPanel() {
		return rosterPanel;
	}
}
