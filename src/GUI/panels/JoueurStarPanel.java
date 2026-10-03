package GUI.panels;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import data.elements.JoueurStar;
import data.properties.DataProperties;
import data.properties.GamedataProperties;
import data.properties.TextsProperties;

public class JoueurStarPanel extends ElementPanel {

	private static final long serialVersionUID = 1L;

	private JoueurStar joueurSelectionne = null;

	private JTextField idField;
	private JTextField descriptionField;
	private JTextField nomField;
	private JSpinner attaqueField;
	private JSpinner defenseField;
	private JSpinner puissanceField;
	private JSpinner vitesseField;
	private JSpinner techniqueField;
	private JComboBox<String> positionField;
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
	private JComboBox<String> arretsField;
	private JComboBox<String> superArretField;
	private JComboBox<String> competenceCapitaineField;
	private JComboBox<String> competence1Field;
	private JComboBox<String> competence2Field;
	private JComboBox<String> competence3Field;
	private JComboBox<String> competence4Field;
	private JComboBox<String> competence5Field;
	private JComboBox<String> competence6Field;

	public JoueurStarPanel() {
		setLayout(new FlowLayout(FlowLayout.LEADING));
		
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
		attaqueField = makeSpinnerComponent(GamedataProperties.CPD_STAT);
		defenseField = makeSpinnerComponent(GamedataProperties.CPD_STAT);
		puissanceField = makeSpinnerComponent(GamedataProperties.CPD_STAT);
		vitesseField = makeSpinnerComponent(GamedataProperties.CPD_STAT);
		techniqueField = makeSpinnerComponent(GamedataProperties.CPD_STAT);
		positionField = makeComboboxComponent(GamedataProperties.CPD_POSITION);
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
		arretsField = makeComboboxComponent(DataProperties.ARRETS);
		superArretField = makeComboboxComponent(DataProperties.SUPERARRET);
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
		infos.add(makeFieldPanel(TextsProperties.LABEL_ATTAQUE, attaqueField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_DEFENSE, defenseField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_PUISSANCE, puissanceField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_VITESSE, vitesseField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_TECHNIQUE, techniqueField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_POSTE, positionField));
		
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
		techniques.add(makeFieldPanel(TextsProperties.LABEL_ARRETS, arretsField));
		techniques.add(makeFieldPanel(TextsProperties.LABEL_SUPERARRET, superArretField));
		
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETECECAPITAINE, competenceCapitaineField));
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 1", competence1Field));
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 2", competence2Field));
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 3", competence3Field));
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 4", competence4Field));
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 5", competence5Field));
		competences.add(makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 6", competence6Field));
		
		setEnabled(false);
	}

	public void load(JoueurStar joueur){
		joueurSelectionne = joueur;

		if(joueur != null) {
			idField.setText(joueur.getId());
			descriptionField.setText(joueur.getDescription());
			nomField.setText(joueur.getNom());
			attaqueField.setValue(joueur.getAttaque());
			defenseField.setValue(joueur.getDefense());
			puissanceField.setValue(joueur.getPuissance());
			vitesseField.setValue(joueur.getVitesse());
			techniqueField.setValue(joueur.getTechnique());
			positionField.setSelectedIndex(joueur.getPosition());
			tirField.setSelectedIndex(joueur.getTir());
			tirAltField.setSelectedIndex(joueur.getTirAlt());
			tirAerienField.setSelectedIndex(joueur.getTirAerien());
			superTirField.setSelectedIndex(joueur.getSuperTir());
			superTirAltField.setSelectedIndex(joueur.getSuperTirAlt());
			dribble1Field.setSelectedIndex(joueur.getDribble1());
			dribble2Field.setSelectedIndex(joueur.getDribble2());
			passeField.setSelectedIndex(joueur.getPasse());
			tirCombo1Field.setSelectedIndex(joueur.getTirCombo1());
			tirCombo2Field.setSelectedIndex(joueur.getTirCombo2());
			passesComboField.setSelectedIndex(joueur.getPassesCombo());
			tacle1Field.setSelectedIndex(joueur.getTacle1());
			tacle2Field.setSelectedIndex(joueur.getTacle2());
			blocageField.setSelectedIndex(joueur.getBlocage());
			arretsField.setSelectedIndex(joueur.getArrets());
			superArretField.setSelectedIndex(joueur.getSuperArret());
			competenceCapitaineField.setSelectedIndex(joueur.getCompetenceCapitaine());
			competence1Field.setSelectedIndex(joueur.getCompetence1());
			competence2Field.setSelectedIndex(joueur.getCompetence2());
			competence3Field.setSelectedIndex(joueur.getCompetence3());
			competence4Field.setSelectedIndex(joueur.getCompetence4());
			competence5Field.setSelectedIndex(joueur.getCompetence5());
			competence6Field.setSelectedIndex(joueur.getCompetence6());
		}
	}

	public void save() {
		if(joueurSelectionne != null) {
			joueurSelectionne.setDescription(descriptionField.getText());
			joueurSelectionne.setNom(nomField.getText());
			joueurSelectionne.setAttaque((int)attaqueField.getValue());
			joueurSelectionne.setDefense((int)defenseField.getValue());
			joueurSelectionne.setPuissance((int)puissanceField.getValue());
			joueurSelectionne.setVitesse((int)vitesseField.getValue());
			joueurSelectionne.setTechnique((int)techniqueField.getValue());
			joueurSelectionne.setPosition(positionField.getSelectedIndex());
			joueurSelectionne.setTir(tirField.getSelectedIndex());
			joueurSelectionne.setTirAlt(tirAltField.getSelectedIndex());
			joueurSelectionne.setTirAerien(tirAerienField.getSelectedIndex());
			joueurSelectionne.setSuperTir(superTirField.getSelectedIndex());
			joueurSelectionne.setSuperTirAlt(superTirAltField.getSelectedIndex());
			joueurSelectionne.setDribble1(dribble1Field.getSelectedIndex());
			joueurSelectionne.setDribble2(dribble2Field.getSelectedIndex());
			joueurSelectionne.setPasse(passeField.getSelectedIndex());
			joueurSelectionne.setTirCombo1(tirCombo1Field.getSelectedIndex());
			joueurSelectionne.setTirCombo2(tirCombo2Field.getSelectedIndex());
			joueurSelectionne.setPassesCombo(passesComboField.getSelectedIndex());
			joueurSelectionne.setTacle1(tacle1Field.getSelectedIndex());
			joueurSelectionne.setTacle2(tacle2Field.getSelectedIndex());
			joueurSelectionne.setBlocage(blocageField.getSelectedIndex());
			joueurSelectionne.setArrets(arretsField.getSelectedIndex());
			joueurSelectionne.setSuperArret(superArretField.getSelectedIndex());
			joueurSelectionne.setCompetenceCapitaine(competenceCapitaineField.getSelectedIndex());
			joueurSelectionne.setCompetence1(competence1Field.getSelectedIndex());
			joueurSelectionne.setCompetence2(competence2Field.getSelectedIndex());
			joueurSelectionne.setCompetence3(competence3Field.getSelectedIndex());
			joueurSelectionne.setCompetence4(competence4Field.getSelectedIndex());
			joueurSelectionne.setCompetence5(competence5Field.getSelectedIndex());
			joueurSelectionne.setCompetence6(competence6Field.getSelectedIndex());
		}
	}
}
