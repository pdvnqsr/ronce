package GUI.panels;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.elements.Build;
import data.properties.DataProperties;
import data.properties.TextsProperties;

public class BuildPanel extends ElementPanel {

	private static final long serialVersionUID = 1L;

	private Build buildSelectionne = null;

	private JTextField idField;
	private JTextField descriptionField;
	private JTextField nomField;
	private JComboBox<String> tirField;
	private JComboBox<String> tirAltField;
	private JComboBox<String> tirAerienField;
	private JComboBox<String> superTirField;
	private JComboBox<String> superTirAltField;
	private JComboBox<String> dribble1Field;
	private JComboBox<String> dribble2Field;
	private JComboBox<String> passeField;
	private JComboBox<String> tirCombo1Field;
	private JComboBox<String> tirCombo2Field;
	private JComboBox<String> passesComboField;
	private JComboBox<String> tacle1Field;
	private JComboBox<String> tacle2Field;
	private JComboBox<String> blocageField;
	private JComboBox<String> competenceCapitaineField;
	private JComboBox<String> competence1Field;
	private JComboBox<String> competence2Field;
	private JComboBox<String> competence3Field;
	private JComboBox<String> competence4Field;
	private JComboBox<String> competence5Field;
	private JComboBox<String> competence6Field;

	public BuildPanel() {
		GridLayout layout = new GridLayout(20,1,10,10);
		JPanel infos = new JPanel(layout);
		add(infos);
		JPanel techniques = new JPanel(layout);
		add(techniques);
		JPanel competences = new JPanel(layout);
		add(competences);
		
		idField = new JTextField(28);
		idField.setEditable(false);
		descriptionField = new JTextField(20);
		nomField = new JTextField(15);
		tirField = makeComboboxComponent(DataProperties.TIRS);
		tirAltField = makeComboboxComponent(DataProperties.TIRS);
		tirAerienField = makeComboboxComponent(DataProperties.TIRSAERIENS);
		superTirField = makeComboboxComponent(DataProperties.SUPERTIRS);
		superTirAltField = makeComboboxComponent(DataProperties.SUPERTIRS);
		dribble1Field = makeComboboxComponent(DataProperties.DRIBBLES);
		dribble2Field = makeComboboxComponent(DataProperties.DRIBBLES);
		passeField = makeComboboxComponent(DataProperties.PASSES);
		tirCombo1Field = makeComboboxComponent(DataProperties.TIRSCOMBO1);
		tirCombo2Field = makeComboboxComponent(DataProperties.TIRSCOMBO2);
		passesComboField = makeComboboxComponent(DataProperties.PASSESCOMBO);
		tacle1Field = makeComboboxComponent(DataProperties.TACLES);
		tacle2Field = makeComboboxComponent(DataProperties.TACLES);
		blocageField = makeComboboxComponent(DataProperties.BLOCAGES);
		competenceCapitaineField = makeComboboxComponent(DataProperties.COMPETECESCAPITAINE);
		competence1Field = makeComboboxComponent(DataProperties.COMPETENCES);
		competence2Field = makeComboboxComponent(DataProperties.COMPETENCES);
		competence3Field = makeComboboxComponent(DataProperties.COMPETENCES);
		competence4Field = makeComboboxComponent(DataProperties.COMPETENCES);
		competence5Field = makeComboboxComponent(DataProperties.COMPETENCES);
		competence6Field = makeComboboxComponent(DataProperties.COMPETENCES);
		
		infos.add(makeFieldPanel(TextsProperties.LABEL_NOM, nomField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_ID, idField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_DESCRIPTION, descriptionField));
		
		techniques.add(makeFieldPanel(TextsProperties.LABEL_TIR, tirField));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_TIR + " *", tirAltField));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_TIRAERIENS, tirAerienField));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_SUPERTIR, superTirField));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_SUPERTIR + " *", superTirAltField));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_DRIBBLE + " 1", dribble1Field));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_DRIBBLE + " 2", dribble2Field));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_PASSELONGUE, passeField));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_TIRSCOMBOS + " 1", tirCombo1Field));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_TIRSCOMBOS + " 2", tirCombo2Field));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_PASSESCOMBO, passesComboField));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_TACLE + " 1", tacle1Field));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_TACLE + " 2", tacle2Field));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_BLOCAGE, blocageField));
		
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETECECAPITAINE, competenceCapitaineField));
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 1", competence1Field));
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 2", competence2Field));
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 3", competence3Field));
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 4", competence4Field));
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 5", competence5Field));
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 6", competence6Field));
		
		setEnabled(false);
	}

	public void load(Build build){
		buildSelectionne = build;

		if(build != null) {
			idField.setText(build.getId());
			descriptionField.setText(build.getDescription());
			nomField.setText(build.getNom());
			tirField.setSelectedIndex(build.getTir());
			tirAltField.setSelectedIndex(build.getTirAlt());
			tirAerienField.setSelectedIndex(build.getTirAerien());
			superTirField.setSelectedIndex(build.getSuperTir());
			superTirAltField.setSelectedIndex(build.getSuperTirAlt());
			dribble1Field.setSelectedIndex(build.getDribble1());
			dribble2Field.setSelectedIndex(build.getDribble2());
			passeField.setSelectedIndex(build.getPasse());
			tirCombo1Field.setSelectedIndex(build.getTirCombo1());
			tirCombo2Field.setSelectedIndex(build.getTirCombo2());
			passesComboField.setSelectedIndex(build.getPassesCombo());
			tacle1Field.setSelectedIndex(build.getTacle1());
			tacle2Field.setSelectedIndex(build.getTacle2());
			blocageField.setSelectedIndex(build.getBlocage());
			competenceCapitaineField.setSelectedIndex(build.getCompetenceCapitaine());
			competence1Field.setSelectedIndex(build.getCompetence1());
			competence2Field.setSelectedIndex(build.getCompetence2());
			competence3Field.setSelectedIndex(build.getCompetence3());
			competence4Field.setSelectedIndex(build.getCompetence4());
			competence5Field.setSelectedIndex(build.getCompetence5());
			competence6Field.setSelectedIndex(build.getCompetence6());
		}
	}

	public void save() {
		if(buildSelectionne != null) {
			buildSelectionne.setDescription(descriptionField.getText());
			buildSelectionne.setNom(nomField.getText());
			buildSelectionne.setTir(tirField.getSelectedIndex());
			buildSelectionne.setTirAlt(tirAltField.getSelectedIndex());
			buildSelectionne.setTirAerien(tirAerienField.getSelectedIndex());
			buildSelectionne.setSuperTir(superTirField.getSelectedIndex());
			buildSelectionne.setSuperTirAlt(superTirAltField.getSelectedIndex());
			buildSelectionne.setDribble1(dribble1Field.getSelectedIndex());
			buildSelectionne.setDribble2(dribble2Field.getSelectedIndex());
			buildSelectionne.setPasse(passeField.getSelectedIndex());
			buildSelectionne.setTirCombo1(tirCombo1Field.getSelectedIndex());
			buildSelectionne.setTirCombo2(tirCombo2Field.getSelectedIndex());
			buildSelectionne.setPassesCombo(passesComboField.getSelectedIndex());
			buildSelectionne.setTacle1(tacle1Field.getSelectedIndex());
			buildSelectionne.setTacle2(tacle2Field.getSelectedIndex());
			buildSelectionne.setBlocage(blocageField.getSelectedIndex());
			buildSelectionne.setCompetenceCapitaine(competenceCapitaineField.getSelectedIndex());
			buildSelectionne.setCompetence1(competence1Field.getSelectedIndex());
			buildSelectionne.setCompetence2(competence2Field.getSelectedIndex());
			buildSelectionne.setCompetence3(competence3Field.getSelectedIndex());
			buildSelectionne.setCompetence4(competence4Field.getSelectedIndex());
			buildSelectionne.setCompetence5(competence5Field.getSelectedIndex());
			buildSelectionne.setCompetence6(competence6Field.getSelectedIndex());
		}
	}
}
