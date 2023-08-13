package GUI.panels;

import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.elements.Joueur;
import data.properties.DataProperties;
import data.properties.TextsProperties;

public class JoueurPanel extends ElementPanel {

	private static final long serialVersionUID = 1L;

	private Joueur joueurSelectionne = null;

	private JTextField idField;
	private JTextField descriptionField;
	private JTextField nomField;
	private JComboBox<String> posteField;
	private JComboBox<String> typeCorpsField;
	private JSlider tailleField;
	private JSlider tailleTeteField;
	private JComboBox<String> couleurPeauField;
	private JComboBox<String> manchesField;
	private JComboBox<String> visageField;
	private JSlider tailleBoucheField;
	private JSlider commissuresField;
	private JSlider positionBoucheField;
	private JComboBox<String> cheveuxField;
	private JComboBox<String> couleurCheveuxField;
	private JComboBox<String> yeuxField;
	private JSlider tailleYeuxField;
	private JSlider positionYeuxField;
	private JSlider espacementYeuxField;
	private JSlider taillePupillesField;
	private JComboBox<String> couleurYeuxField;
	private JComboBox<String> sourcilsField;
	private JComboBox<String> couleurSourcilsField;
	private JComboBox<String> nezField;
	private JSlider positionNezField;
	private JSlider tailleNezField;
	private JComboBox<String> cramponsField;
	private JComboBox<String> voixField;
	private JComboBox<String> lunettesField;
	private JComboBox<String> couleurLunettesField;
	private JComboBox<String> celebration1Field;
	private JComboBox<String> celebration2Field;
	private JComboBox<String> celebration3Field;
	private JComboBox<String> celebration4Field;
	private JSpinner attaqueField;
	private JSpinner defenseField;
	private JSpinner puissanceField;
	private JSpinner vitesseField;
	private JSpinner techniqueField;
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
	private JTextArea equipesField;

	public JoueurPanel() {		
		idField = new JTextField(28);
		idField.setEditable(false);
		descriptionField = new JTextField(20);
		nomField = new JTextField(DataProperties.JOUEUR_NOM.getLongueur());
		posteField = makeComboboxComponent(DataProperties.POSITION);
		typeCorpsField = makeComboboxComponent(DataProperties.TYPECORPS);
		tailleField = makeSliderComponent(DataProperties.TAILLE);
		tailleTeteField = makeSliderComponent(DataProperties.TAILLETETE);
		couleurPeauField = makeComboboxComponent(DataProperties.COULEURPEAU);
		manchesField = makeComboboxComponent(DataProperties.STYLEMANCHE);
		visageField = makeComboboxComponent(DataProperties.VISAGE);
		tailleBoucheField = makeSliderComponent(DataProperties.TAILLEBOUCHE);
		commissuresField = makeSliderComponent(DataProperties.COMMISSURES);
		positionBoucheField = makeSliderComponent(DataProperties.POSITIONBOUCHE);
		cheveuxField = makeComboboxComponent(DataProperties.CHEVEUX);
		couleurCheveuxField = makeComboboxComponent(DataProperties.COULEURCHEVEUX);
		yeuxField = makeComboboxComponent(DataProperties.YEUX);
		tailleYeuxField = makeSliderComponent(DataProperties.TAILLEYEUX);
		positionYeuxField = makeSliderComponent(DataProperties.POSITIONYEUX);
		espacementYeuxField = makeSliderComponent(DataProperties.ESPACEMENTYEUX);
		taillePupillesField = makeSliderComponent(DataProperties.TAILLEPUPILLES);
		couleurYeuxField = makeComboboxComponent(DataProperties.COULEURYEUX);
		sourcilsField = makeComboboxComponent(DataProperties.SOURCILS);
		couleurSourcilsField = makeComboboxComponent(DataProperties.COULEURSOURCILS);
		nezField = makeComboboxComponent(DataProperties.NEZ);
		positionNezField = makeSliderComponent(DataProperties.POSITIONNEZ);
		tailleNezField = makeSliderComponent(DataProperties.TAILLENEZ);
		cramponsField = makeComboboxComponent(DataProperties.CRAMPONS);
		voixField = makeComboboxComponent(DataProperties.VOIX);
		lunettesField = makeComboboxComponent(DataProperties.LUNETTES);
		couleurLunettesField = makeComboboxComponent(DataProperties.COULEURLUNETTES);
		celebration1Field = makeComboboxComponent(DataProperties.CELEBRATION);
		celebration2Field = makeComboboxComponent(DataProperties.CELEBRATION);
		celebration3Field = makeComboboxComponent(DataProperties.CELEBRATION);
		celebration4Field = makeComboboxComponent(DataProperties.CELEBRATION);
		attaqueField = makeSpinnerComponent(DataProperties.STAT);
		defenseField = makeSpinnerComponent(DataProperties.STAT);
		puissanceField = makeSpinnerComponent(DataProperties.STAT);
		vitesseField = makeSpinnerComponent(DataProperties.STAT);
		techniqueField = makeSpinnerComponent(DataProperties.STAT);
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
		
		equipesField = new JTextArea(1,10);
		equipesField.setEditable(false);
				
		JPanel nomPanel = makeFieldPanel(TextsProperties.LABEL_NOM, nomField);
		JPanel postePanel = makeFieldPanel(TextsProperties.LABEL_POSTE, posteField);
		JPanel typeCorpsPanel = makeFieldPanel(TextsProperties.LABEL_TYPECORPS, typeCorpsField);
		JPanel taillePanel = makeFieldPanel(TextsProperties.LABEL_TAILLE, tailleField);
		JPanel tailleTetePanel = makeFieldPanel(TextsProperties.LABEL_TAILLETETE, tailleTeteField);
		JPanel couleurPeauPanel = makeFieldPanel(TextsProperties.LABEL_COULEURPEAU, couleurPeauField);
		JPanel manchesPanel = makeFieldPanel(TextsProperties.LABEL_STYLEMANCHES, manchesField);
		JPanel visagePanel = makeFieldPanel(TextsProperties.LABEL_VISAGE, visageField);
		JPanel tailleBouchePanel = makeFieldPanel(TextsProperties.LABEL_TAILLEBOUCHE, tailleBoucheField);
		JPanel commissurePanel = makeFieldPanel(TextsProperties.LABEL_COMMISSURE, commissuresField);
		JPanel positionBouchePanel = makeFieldPanel(TextsProperties.LABEL_POSITIONBOUCHE, positionBoucheField);
		JPanel cheveuxPanel = makeFieldPanel(TextsProperties.LABEL_CHEVEUX, cheveuxField);
		JPanel couleurCheveuxPanel = makeFieldPanel(TextsProperties.LABEL_COULEURCHEVEUX, couleurCheveuxField);
		JPanel yeuxPanel = makeFieldPanel(TextsProperties.LABEL_YEUX, yeuxField);
		JPanel tailleYeuxPanel = makeFieldPanel(TextsProperties.LABEL_TAILLEYEUX, tailleYeuxField);
		JPanel positionYeuxPanel = makeFieldPanel(TextsProperties.LABEL_POSITIONYEUX, positionYeuxField);
		JPanel espacementYeuxPanel = makeFieldPanel(TextsProperties.LABEL_ESPACEMENTYEUX, espacementYeuxField);
		JPanel taillePupillesPanel = makeFieldPanel(TextsProperties.LABEL_TAILLEPUPILLES, taillePupillesField);
		JPanel couleurYeuxPanel = makeFieldPanel(TextsProperties.LABEL_COULEURYEUX, couleurYeuxField);
		JPanel sourcilsPanel = makeFieldPanel(TextsProperties.LABEL_SOURCILS, sourcilsField);
		JPanel couleurSourcilsPanel = makeFieldPanel(TextsProperties.LABEL_COULEURSOURCILS, couleurSourcilsField);
		JPanel nezPanel = makeFieldPanel(TextsProperties.LABEL_NEZ, nezField);
		JPanel positionNezPanel = makeFieldPanel(TextsProperties.LABEL_POSITIONNEZ, positionNezField);
		JPanel tailleNezPanel = makeFieldPanel(TextsProperties.LABEL_TAILLENEZ, tailleNezField);
		JPanel cramponsPanel = makeFieldPanel(TextsProperties.LABEL_CRAMPONS, cramponsField);
		JPanel voixPanel = makeFieldPanel(TextsProperties.LABEL_VOIX, voixField);
		JPanel lunettesPanel = makeFieldPanel(TextsProperties.LABEL_LUNETTES, lunettesField);
		JPanel couleurLunettesPanel = makeFieldPanel(TextsProperties.LABEL_COULEURLUNETTES, couleurLunettesField);
		JPanel celebration1Panel = makeFieldPanel(TextsProperties.LABEL_CELEBRATION + " 1", celebration1Field);
		JPanel celebration2Panel = makeFieldPanel(TextsProperties.LABEL_CELEBRATION + " 2", celebration2Field);
		JPanel celebration3Panel = makeFieldPanel(TextsProperties.LABEL_CELEBRATION + " 3", celebration3Field);
		JPanel celebration4Panel = makeFieldPanel(TextsProperties.LABEL_CELEBRATION + " 4", celebration4Field);
		JPanel attaquePanel = makeFieldPanel(TextsProperties.LABEL_ATTAQUE, attaqueField);
		JPanel defensePanel = makeFieldPanel(TextsProperties.LABEL_DEFENSE, defenseField);
		JPanel puissancePanel = makeFieldPanel(TextsProperties.LABEL_PUISSANCE, puissanceField);
		JPanel vitessePanel = makeFieldPanel(TextsProperties.LABEL_VITESSE, vitesseField);
		JPanel techniquePanel = makeFieldPanel(TextsProperties.LABEL_TECHNIQUE, techniqueField);
		JPanel tirPanel = makeFieldPanel(TextsProperties.LABEL_TIR, tirField);
		JPanel tirAltPanel = makeFieldPanel(TextsProperties.LABEL_TIR + " *", tirAltField);
		JPanel tirAerienPanel = makeFieldPanel(TextsProperties.LABEL_TIRAERIENS, tirAerienField);
		JPanel superTirPanel = makeFieldPanel(TextsProperties.LABEL_SUPERTIR, superTirField);
		JPanel superTirAltPanel = makeFieldPanel(TextsProperties.LABEL_SUPERTIR + " *", superTirAltField);
		JPanel dribble1Panel = makeFieldPanel(TextsProperties.LABEL_DRIBBLE + " 1", dribble1Field);
		JPanel dribble2Panel = makeFieldPanel(TextsProperties.LABEL_DRIBBLE + " 2", dribble2Field);
		JPanel passePanel = makeFieldPanel(TextsProperties.LABEL_PASSELONGUE, passeField);
		JPanel tirCombo1Panel = makeFieldPanel(TextsProperties.LABEL_TIRSCOMBOS + " 1", tirCombo1Field);
		JPanel tirCombo2Panel = makeFieldPanel(TextsProperties.LABEL_TIRSCOMBOS + " 2", tirCombo2Field);
		JPanel passesComboPanel = makeFieldPanel(TextsProperties.LABEL_PASSESCOMBO, passesComboField);
		JPanel tacle1Panel = makeFieldPanel(TextsProperties.LABEL_TACLE + " 1", tacle1Field);
		JPanel tacle2Panel = makeFieldPanel(TextsProperties.LABEL_TACLE + " 2", tacle2Field);
		JPanel blocagePanel = makeFieldPanel(TextsProperties.LABEL_BLOCAGE, blocageField);
		JPanel competenceCapitainePanel = makeFieldPanel(TextsProperties.LABEL_COMPETECECAPITAINE, competenceCapitaineField);
		JPanel competence1Panel = makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 1", competence1Field);
		JPanel competence2Panel = makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 2", competence2Field);
		JPanel competence3Panel = makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 3", competence3Field);
		JPanel competence4Panel = makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 4", competence4Field);
		JPanel competence5Panel = makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 5", competence5Field);
		JPanel competence6Panel = makeFieldPanel(TextsProperties.LABEL_COMPETENCE + " 6", competence6Field);
		
		JPanel idPanel = makeFieldPanel(TextsProperties.LABEL_ID, idField);
		JPanel descriptionPanel = makeFieldPanel(TextsProperties.LABEL_DESCRIPTION, descriptionField);
		
		JPanel equipesPanel = makeFieldPanel(TextsProperties.LABEL_EQUIPES, equipesField);
		
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHonorsVisibility(true);

		layout.setHorizontalGroup(
			layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addComponent(nomPanel)
									.addComponent(idPanel)
									.addComponent(descriptionPanel)
									.addComponent(postePanel)
									.addComponent(voixPanel)
							)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addComponent(attaquePanel)
									.addComponent(defensePanel)
									.addComponent(puissancePanel)
									.addComponent(vitessePanel)
									.addComponent(techniquePanel)
							)
					)
					.addComponent(tirPanel)
					.addComponent(tirAltPanel)
					.addComponent(tirAerienPanel)
					.addComponent(superTirPanel)
					.addComponent(superTirAltPanel)
					.addComponent(dribble1Panel)
					.addComponent(dribble2Panel)
					.addComponent(passePanel)
					.addComponent(tirCombo1Panel)
					.addComponent(tirCombo2Panel)
					.addComponent(passesComboPanel)
					.addComponent(tacle1Panel)
					.addComponent(tacle2Panel)
					.addComponent(blocagePanel)
					.addComponent(competenceCapitainePanel)
					.addComponent(competence1Panel)
					.addComponent(competence2Panel)
					.addComponent(competence3Panel)
					.addComponent(competence4Panel)
					.addComponent(competence5Panel)
					.addComponent(competence6Panel)
			)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(typeCorpsPanel, 250, 250, 250)
					.addComponent(manchesPanel, 250, 250, 250)
					.addComponent(visagePanel, 250, 250, 250)
					.addComponent(couleurPeauPanel, 250, 250, 250)
					.addComponent(yeuxPanel, 250, 250, 250)
					.addComponent(couleurYeuxPanel, 250, 250, 250)
					.addComponent(nezPanel, 250, 250, 250)
					.addComponent(cheveuxPanel, 250, 250, 250)
					.addComponent(couleurCheveuxPanel, 250, 250, 250)
			)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(taillePanel, 370, 370, 370)
					.addComponent(tailleTetePanel, 370, 370, 370)
					.addComponent(tailleBouchePanel, 370, 370, 370)
					.addComponent(commissurePanel, 370, 370, 370)
					.addComponent(positionBouchePanel, 370, 370, 370)
					.addComponent(tailleYeuxPanel, 370, 370, 370)
					.addComponent(positionYeuxPanel, 370, 370, 370)
					.addComponent(espacementYeuxPanel, 370, 370, 370)
					.addComponent(taillePupillesPanel, 370, 370, 370)
					.addComponent(tailleNezPanel, 370, 370, 370)
					.addComponent(positionNezPanel, 370, 370, 370)
					.addComponent(sourcilsPanel, 370, 370, 370)
					.addComponent(couleurSourcilsPanel, 370, 370, 370)
			)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addComponent(celebration1Panel, 400, 400, 400)
					.addComponent(celebration2Panel, 400, 400, 400)
					.addComponent(celebration3Panel, 400, 400, 400)
					.addComponent(celebration4Panel, 400, 400, 400)
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
									.addComponent(lunettesPanel, 250, 250, 250)
									.addComponent(couleurLunettesPanel, 250, 250, 250)
									.addComponent(cramponsPanel, 250, 250, 250)
							)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
									.addComponent(equipesPanel, 100, 100, 100)
							)
					)
			)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(layout.createSequentialGroup()
									.addComponent(nomPanel)
									.addComponent(idPanel)
									.addComponent(descriptionPanel)
									.addComponent(postePanel)
									.addComponent(voixPanel)
							)
							.addGroup(layout.createSequentialGroup()
									.addComponent(attaquePanel)
									.addComponent(defensePanel)
									.addComponent(puissancePanel)
									.addComponent(vitessePanel)
									.addComponent(techniquePanel)
							)
					)
					.addComponent(tirPanel)
					.addComponent(tirAltPanel)
					.addComponent(tirAerienPanel)
					.addComponent(superTirPanel)
					.addComponent(superTirAltPanel)
					.addComponent(dribble1Panel)
					.addComponent(dribble2Panel)
					.addComponent(passePanel)
					.addComponent(tirCombo1Panel)
					.addComponent(tirCombo2Panel)
					.addComponent(passesComboPanel)
					.addComponent(tacle1Panel)
					.addComponent(tacle2Panel)
					.addComponent(blocagePanel)
					.addComponent(competenceCapitainePanel)
					.addComponent(competence1Panel)
					.addComponent(competence2Panel)
					.addComponent(competence3Panel)
					.addComponent(competence4Panel)
					.addComponent(competence5Panel)
					.addComponent(competence6Panel)
			)
			.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(layout.createSequentialGroup()
									.addComponent(typeCorpsPanel)
									.addComponent(manchesPanel)
							)
							.addGroup(layout.createSequentialGroup()
									.addComponent(taillePanel)
									.addComponent(tailleTetePanel)
							)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(layout.createSequentialGroup()
									.addComponent(visagePanel)
									.addComponent(couleurPeauPanel)
							)
							.addGroup(layout.createSequentialGroup()
									.addComponent(tailleBouchePanel)
									.addComponent(commissurePanel)
									.addComponent(positionBouchePanel)
							)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(layout.createSequentialGroup()
									.addComponent(yeuxPanel)
									.addComponent(couleurYeuxPanel)
							)
							.addGroup(layout.createSequentialGroup()
									.addComponent(tailleYeuxPanel)
									.addComponent(positionYeuxPanel)
									.addComponent(espacementYeuxPanel)
									.addComponent(taillePupillesPanel)
							)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(layout.createSequentialGroup()
									.addComponent(nezPanel)
							)
							.addGroup(layout.createSequentialGroup()
									.addComponent(tailleNezPanel)
									.addComponent(positionNezPanel)
							)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(layout.createSequentialGroup()
									.addComponent(cheveuxPanel)
									.addComponent(couleurCheveuxPanel)
							)
							.addGroup(layout.createSequentialGroup()
									.addComponent(sourcilsPanel)
									.addComponent(couleurSourcilsPanel)
							)
					)
			)
			.addGroup(layout.createSequentialGroup()
					.addComponent(celebration1Panel)
					.addComponent(celebration2Panel)
					.addComponent(celebration3Panel)
					.addComponent(celebration4Panel)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(layout.createSequentialGroup()
									.addComponent(lunettesPanel)
									.addComponent(couleurLunettesPanel)
									.addComponent(cramponsPanel)
							)
							.addGroup(layout.createSequentialGroup()
									.addComponent(equipesPanel)
							)
					)
			)
		);
		
		setEnabled(false);
	}

	public void loadJoueur(Joueur joueur){
		joueurSelectionne = joueur;

		if(joueur != null) {
			idField.setText(joueur.getId());
			descriptionField.setText(joueur.getDescription());
			nomField.setText(joueur.getNom());
			posteField.setSelectedIndex(joueur.getPosition());
			typeCorpsField.setSelectedIndex(joueur.getTypeCorps());
			tailleField.setValue(joueur.getTaille());
			tailleTeteField.setValue(joueur.getTailleTete());
			couleurPeauField.setSelectedIndex(joueur.getCouleurPeau());
			manchesField.setSelectedIndex(joueur.getStyleManche());
			visageField.setSelectedIndex(joueur.getVisage());
			tailleBoucheField.setValue(joueur.getTailleBouche());
			commissuresField.setValue(joueur.getCommissures());
			positionBoucheField.setValue(joueur.getPositionBouche());
			cheveuxField.setSelectedIndex(joueur.getCheveux());
			couleurCheveuxField.setSelectedIndex(joueur.getCouleurCheveux());
			yeuxField.setSelectedIndex(joueur.getYeux());
			tailleYeuxField.setValue(joueur.getTailleYeux());
			positionYeuxField.setValue(joueur.getPositionYeux());
			espacementYeuxField.setValue(joueur.getEspacementYeux());
			taillePupillesField.setValue(joueur.getTaillePupilles());
			couleurYeuxField.setSelectedIndex(joueur.getCouleurYeux());
			sourcilsField.setSelectedIndex(joueur.getSourcils());
			couleurSourcilsField.setSelectedIndex(joueur.getCouleurSourcils());
			nezField.setSelectedIndex(joueur.getNez());
			positionNezField.setValue(joueur.getPositionNez());
			tailleNezField.setValue(joueur.getTailleNez());
			cramponsField.setSelectedIndex(joueur.getCrampons());
			voixField.setSelectedIndex(joueur.getVoix());
			lunettesField.setSelectedIndex(joueur.getLunettes());
			couleurLunettesField.setSelectedIndex(joueur.getCouleurLunettes());
			celebration1Field.setSelectedIndex(joueur.getCelebration1());
			celebration2Field.setSelectedIndex(joueur.getCelebration2());
			celebration3Field.setSelectedIndex(joueur.getCelebration3());
			celebration4Field.setSelectedIndex(joueur.getCelebration4());
			attaqueField.setValue(joueur.getAttaque());
			defenseField.setValue(joueur.getDefense());
			puissanceField.setValue(joueur.getPuissance());
			vitesseField.setValue(joueur.getVitesse());
			techniqueField.setValue(joueur.getTechnique());
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
			competenceCapitaineField.setSelectedIndex(joueur.getCompetenceCapitaine());
			competence1Field.setSelectedIndex(joueur.getCompetence1());
			competence2Field.setSelectedIndex(joueur.getCompetence2());
			competence3Field.setSelectedIndex(joueur.getCompetence3());
			competence4Field.setSelectedIndex(joueur.getCompetence4());
			competence5Field.setSelectedIndex(joueur.getCompetence5());
			competence6Field.setSelectedIndex(joueur.getCompetence6());
			equipesField.setText(joueur.getEquipes());
		}
	}

	public void saveJoueur() {
		if(joueurSelectionne != null) {
			joueurSelectionne.setDescription(descriptionField.getText());
			joueurSelectionne.setNom(nomField.getText());
			joueurSelectionne.setPosition(posteField.getSelectedIndex());
			joueurSelectionne.setTypeCorps(typeCorpsField.getSelectedIndex());
			joueurSelectionne.setTaille(tailleField.getValue());
			joueurSelectionne.setTailleTete(tailleTeteField.getValue());
			joueurSelectionne.setCouleurPeau(couleurPeauField.getSelectedIndex());
			joueurSelectionne.setStyleManche(manchesField.getSelectedIndex());
			joueurSelectionne.setVisage(visageField.getSelectedIndex());
			joueurSelectionne.setTailleBouche(tailleBoucheField.getValue());
			joueurSelectionne.setCommissures(commissuresField.getValue());
			joueurSelectionne.setPositionBouche(positionBoucheField.getValue());
			joueurSelectionne.setCheveux(cheveuxField.getSelectedIndex());
			joueurSelectionne.setCouleurCheveux(couleurCheveuxField.getSelectedIndex());
			joueurSelectionne.setYeux(yeuxField.getSelectedIndex());
			joueurSelectionne.setTailleYeux(tailleYeuxField.getValue());
			joueurSelectionne.setPositionYeux(positionYeuxField.getValue());
			joueurSelectionne.setEspacementYeux(espacementYeuxField.getValue());
			joueurSelectionne.setTaillePupilles(taillePupillesField.getValue());
			joueurSelectionne.setCouleurYeux(couleurYeuxField.getSelectedIndex());
			joueurSelectionne.setSourcils(sourcilsField.getSelectedIndex());
			joueurSelectionne.setCouleurSourcils(couleurSourcilsField.getSelectedIndex());
			joueurSelectionne.setNez(nezField.getSelectedIndex());
			joueurSelectionne.setPositionNez(positionNezField.getValue());
			joueurSelectionne.setTailleNez(tailleNezField.getValue());
			joueurSelectionne.setCrampons(cramponsField.getSelectedIndex());
			joueurSelectionne.setVoix(voixField.getSelectedIndex());
			joueurSelectionne.setLunettes(lunettesField.getSelectedIndex());
			joueurSelectionne.setCouleurLunettes(couleurLunettesField.getSelectedIndex());
			joueurSelectionne.setCelebration1(celebration1Field.getSelectedIndex());
			joueurSelectionne.setCelebration2(celebration2Field.getSelectedIndex());
			joueurSelectionne.setCelebration3(celebration3Field.getSelectedIndex());
			joueurSelectionne.setCelebration4(celebration4Field.getSelectedIndex());
			joueurSelectionne.setAttaque((int)attaqueField.getValue());
			joueurSelectionne.setDefense((int)defenseField.getValue());
			joueurSelectionne.setPuissance((int)puissanceField.getValue());
			joueurSelectionne.setVitesse((int)vitesseField.getValue());
			joueurSelectionne.setTechnique((int)techniqueField.getValue());
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
