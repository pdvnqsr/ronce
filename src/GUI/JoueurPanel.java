package GUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import data.Joueur;
import data.properties.NumericData;
import data.properties.DataProperties;
import data.properties.SelectData;

public class JoueurPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Joueur joueurSelectionne = null;

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

	public JoueurPanel() {
		setLayout(new GridLayout(1, 3));
		GridLayout layout = new GridLayout(30,1);
		JPanel infos = new JPanel(layout);
		add(infos);
		JPanel apparence = new JPanel(layout);
		add(apparence);
		JPanel autres = new JPanel(layout);
		add(autres);
		
		nomField = new JTextField(DataProperties.NOM_LONGUEUR);
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
				
		infos.add(makeFieldPanel("Nom", nomField));
		infos.add(makeFieldPanel("Poste", posteField));
		apparence.add(makeFieldPanel("Type de corps", typeCorpsField));
		apparence.add(makeFieldPanel("Taille", tailleField));
		apparence.add(makeFieldPanel("Taille de la tête", tailleTeteField));
		apparence.add(makeFieldPanel("Couleur de peau", couleurPeauField));
		apparence.add(makeFieldPanel("Style de manches", manchesField));
		apparence.add(makeFieldPanel("Visage", visageField));
		apparence.add(makeFieldPanel("Taille de la bouche", tailleBoucheField));
		apparence.add(makeFieldPanel("Commissure des lèvres", commissuresField));
		apparence.add(makeFieldPanel("Position de la bouche", positionBoucheField));
		apparence.add(makeFieldPanel("Cheveux", cheveuxField));
		apparence.add(makeFieldPanel("Couleur des cheveux", couleurCheveuxField));
		apparence.add(makeFieldPanel("Forme des yeux", yeuxField));
		apparence.add(makeFieldPanel("Taille des yeux", tailleYeuxField));
		apparence.add(makeFieldPanel("Position des yeux", positionYeuxField));
		apparence.add(makeFieldPanel("Espacement des yeux", espacementYeuxField));
		apparence.add(makeFieldPanel("Taille des pupilles", taillePupillesField));
		apparence.add(makeFieldPanel("Couleur des yeux", couleurYeuxField));
		apparence.add(makeFieldPanel("Forme des sourcils", sourcilsField));
		apparence.add(makeFieldPanel("Couleur des sourcils", couleurSourcilsField));
		apparence.add(makeFieldPanel("Forme du nez", nezField));
		apparence.add(makeFieldPanel("Position du nez", positionNezField));
		apparence.add(makeFieldPanel("Taille du nez", tailleNezField));
		autres.add(makeFieldPanel("Crampons", cramponsField));
		autres.add(makeFieldPanel("Voix", voixField));
		autres.add(makeFieldPanel("Lunettes", lunettesField));
		autres.add(makeFieldPanel("Couleur des lunettes", couleurLunettesField));
		autres.add(makeFieldPanel("Célébration 1", celebration1Field));
		autres.add(makeFieldPanel("Célébration 2", celebration2Field));
		autres.add(makeFieldPanel("Célébration 3", celebration3Field));
		autres.add(makeFieldPanel("Célébration 4", celebration4Field));
		infos.add(makeFieldPanel("Attaque", attaqueField));
		infos.add(makeFieldPanel("Défense", defenseField));
		infos.add(makeFieldPanel("Puissance", puissanceField));
		infos.add(makeFieldPanel("Vitesse", vitesseField));
		infos.add(makeFieldPanel("Technique", techniqueField));
		infos.add(makeFieldPanel("Tir", tirField));
		infos.add(makeFieldPanel("Tir *", tirAltField));
		infos.add(makeFieldPanel("Tir aérien", tirAerienField));
		infos.add(makeFieldPanel("Super Tir", superTirField));
		infos.add(makeFieldPanel("Super Tir *", superTirAltField));
		infos.add(makeFieldPanel("Dribble 1", dribble1Field));
		infos.add(makeFieldPanel("Dribble 2", dribble2Field));
		infos.add(makeFieldPanel("Passe longue", passeField));
		infos.add(makeFieldPanel("Tir combos 1", tirCombo1Field));
		infos.add(makeFieldPanel("Tir combos 2", tirCombo2Field));
		infos.add(makeFieldPanel("Passes combo", passesComboField));
		infos.add(makeFieldPanel("Tacle 1", tacle1Field));
		infos.add(makeFieldPanel("Tacle 2", tacle2Field));
		infos.add(makeFieldPanel("Compétence capitaine", competenceCapitaineField));
		infos.add(makeFieldPanel("Compétence 1", competence1Field));
		infos.add(makeFieldPanel("Compétence 2", competence2Field));
		infos.add(makeFieldPanel("Compétence 3", competence3Field));
		infos.add(makeFieldPanel("Compétence 4", competence4Field));
		infos.add(makeFieldPanel("Compétence 5", competence5Field));
		infos.add(makeFieldPanel("Compétence 6", competence6Field));
		
		setEnabled(false);
	}

	public void loadJoueur(Joueur joueur){
		joueurSelectionne = joueur;

		if(joueur != null) {
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
		}
	}

	public void saveJoueur() {
		if(joueurSelectionne != null) {
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

	private JComboBox<String> makeComboboxComponent(SelectData props) {
		JComboBox<String> component = new JComboBox<String>();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for(int i=0 ; i<props.getVals().size() ; i++) {
			model.addElement(props.getVals().get(i).getDisplayValue());		}
		component.setModel(model);
		AutoCompleteDecorator.decorate(component);
		return component;
	}

	private JSlider makeSliderComponent(NumericData props) {
		JSlider component = new JSlider(props.getMin(), props.getMax(), props.getDefaut());
		return component;
	}
	
	private JSpinner makeSpinnerComponent(NumericData props) {
		JSpinner component = new JSpinner(new SpinnerNumberModel(props.getDefaut(), props.getMin(), props.getMax(), 1));
		return component;
	}

	private JPanel makeFieldPanel(String nom, JComponent champ) {
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
		JPanel panel = new JPanel(layout);
		JLabel nomLabel = new JLabel(nom);
		panel.add(nomLabel);
		panel.add(champ);
		return panel;
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		List<Component> comps = getAllComponents(this);
		for (Component comp : comps) {
		       comp.setEnabled(enabled);
		}
	}
	
	private List<Component> getAllComponents(final Container c) {
        Component[] comps = c.getComponents();
        List<Component> compList = new ArrayList<Component>();
        for (Component comp : comps) {
            compList.add(comp);
            if (comp instanceof Container)
                compList.addAll(getAllComponents((Container) comp));
        }
        return compList;
	}
}
