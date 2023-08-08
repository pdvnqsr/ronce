package GUI.panels;

import java.awt.GridLayout;

import javax.swing.JComboBox;

import data.elements.Tenue;
import data.properties.DataProperties;
import data.properties.TextsProperties;

public class TenuePanel extends ElementPanel {

	private static final long serialVersionUID = -104250330435821879L;

	private JComboBox<String> maillotField;
	private JComboBox<String> colField;
	private JComboBox<String> maillotCouleur1Field;
	private JComboBox<String> maillotCouleur2Field;
	private JComboBox<String> maillotCouleur3Field;
	private JComboBox<String> maillotCouleur4Field;
	private JComboBox<String> shortField;
	private JComboBox<String> shortMarquesField;
	private JComboBox<String> shortCouleur1Field;
	private JComboBox<String> shortCouleur2Field;
	private JComboBox<String> shortCouleur3Field;
	private JComboBox<String> shortCouleur4Field;
	private JComboBox<String> chaussettesField;
	private JComboBox<String> chaussettesCouleur1Field;
	private JComboBox<String> chaussettesCouleur2Field;
	private JComboBox<String> chaussettesCouleur3Field;
	private JComboBox<String> chaussettesCouleur4Field;
	private JComboBox<String> policeField;
	private JComboBox<String> policeBordureField;
	private JComboBox<String> policeCouleur1Field;
	private JComboBox<String> policeCouleur2Field;
	private JComboBox<String> policeCouleur3Field;
	private JComboBox<String> policeCouleur4Field;
	private JComboBox<String> brassardCouleurField;
	
	public TenuePanel() {
		setLayout(new GridLayout(24, 1));
		
		maillotField = makeComboboxComponent(DataProperties.EQUIPE_MAILLOT);
		colField = makeComboboxComponent(DataProperties.EQUIPE_COL);
		maillotCouleur1Field = makeComboboxComponent(DataProperties.EQUIPE_MAILLOTCOULEUR1);
		maillotCouleur2Field = makeComboboxComponent(DataProperties.EQUIPE_MAILLOTCOULEUR2);
		maillotCouleur3Field = makeComboboxComponent(DataProperties.EQUIPE_MAILLOTCOULEUR3);
		maillotCouleur4Field = makeComboboxComponent(DataProperties.EQUIPE_MAILLOTCOULEUR4);
		shortField = makeComboboxComponent(DataProperties.EQUIPE_SHORT);
		shortMarquesField = makeComboboxComponent(DataProperties.EQUIPE_SHORTMARQUES);
		shortCouleur1Field = makeComboboxComponent(DataProperties.EQUIPE_SHORTCOULEUR1);
		shortCouleur2Field = makeComboboxComponent(DataProperties.EQUIPE_SHORTCOULEUR2);
		shortCouleur3Field = makeComboboxComponent(DataProperties.EQUIPE_SHORTCOULEUR3);
		shortCouleur4Field = makeComboboxComponent(DataProperties.EQUIPE_SHORTCOULEUR4);
		chaussettesField = makeComboboxComponent(DataProperties.EQUIPE_CHAUSSETTES);
		chaussettesCouleur1Field = makeComboboxComponent(DataProperties.EQUIPE_CHAUSSETTESCOULEUR1);
		chaussettesCouleur2Field = makeComboboxComponent(DataProperties.EQUIPE_CHAUSSETTESCOULEUR2);
		chaussettesCouleur3Field = makeComboboxComponent(DataProperties.EQUIPE_CHAUSSETTESCOULEUR3);
		chaussettesCouleur4Field = makeComboboxComponent(DataProperties.EQUIPE_CHAUSSETTESCOULEUR4);
		policeField = makeComboboxComponent(DataProperties.EQUIPE_POLICE);
		policeBordureField = makeComboboxComponent(DataProperties.EQUIPE_POLICEBORDURE);
		policeCouleur1Field = makeComboboxComponent(DataProperties.EQUIPE_POLICECOULEUR1);
		policeCouleur2Field = makeComboboxComponent(DataProperties.EQUIPE_POLICECOULEUR2);
		policeCouleur3Field = makeComboboxComponent(DataProperties.EQUIPE_POLICECOULEUR3);
		policeCouleur4Field = makeComboboxComponent(DataProperties.EQUIPE_POLICECOULEUR4);
		brassardCouleurField = makeComboboxComponent(DataProperties.EQUIPE_BRASSARDCOULEUR);
		
		add(makeFieldPanel(TextsProperties.LABEL_MAILLOT, maillotField));
		add(makeFieldPanel(TextsProperties.LABEL_COL, colField));
		add(makeFieldPanel(TextsProperties.LABEL_MAILLOT + " : " + TextsProperties.LABEL_COULEUR + " 1", maillotCouleur1Field));
		add(makeFieldPanel(TextsProperties.LABEL_MAILLOT + " : " + TextsProperties.LABEL_COULEUR + " 2", maillotCouleur2Field));
		add(makeFieldPanel(TextsProperties.LABEL_MAILLOT + " : " + TextsProperties.LABEL_COULEUR + " 3", maillotCouleur3Field));
		add(makeFieldPanel(TextsProperties.LABEL_MAILLOT + " : " + TextsProperties.LABEL_COULEUR + " 4", maillotCouleur4Field));
		add(makeFieldPanel(TextsProperties.LABEL_SHORT, shortField));
		add(makeFieldPanel(TextsProperties.LABEL_MARQUES, shortMarquesField));
		add(makeFieldPanel(TextsProperties.LABEL_SHORT + " : " + TextsProperties.LABEL_COULEUR + " 1", shortCouleur1Field));
		add(makeFieldPanel(TextsProperties.LABEL_SHORT + " : " + TextsProperties.LABEL_COULEUR + " 2", shortCouleur2Field));
		add(makeFieldPanel(TextsProperties.LABEL_SHORT + " : " + TextsProperties.LABEL_COULEUR + " 3", shortCouleur3Field));
		add(makeFieldPanel(TextsProperties.LABEL_SHORT + " : " + TextsProperties.LABEL_COULEUR + " 4", shortCouleur4Field));
		add(makeFieldPanel(TextsProperties.LABEL_CHAUSSETTES, chaussettesField));
		add(makeFieldPanel(TextsProperties.LABEL_CHAUSSETTES + " : " + TextsProperties.LABEL_COULEUR + " 1", chaussettesCouleur1Field));
		add(makeFieldPanel(TextsProperties.LABEL_CHAUSSETTES + " : " + TextsProperties.LABEL_COULEUR + " 2", chaussettesCouleur2Field));
		add(makeFieldPanel(TextsProperties.LABEL_CHAUSSETTES + " : " + TextsProperties.LABEL_COULEUR + " 3", chaussettesCouleur3Field));
		add(makeFieldPanel(TextsProperties.LABEL_CHAUSSETTES + " : " + TextsProperties.LABEL_COULEUR + " 4", chaussettesCouleur4Field));
		add(makeFieldPanel(TextsProperties.LABEL_POLICE, policeField));
		add(makeFieldPanel(TextsProperties.LABEL_BORDURE, policeBordureField));
		add(makeFieldPanel(TextsProperties.LABEL_POLICE + " : " + TextsProperties.LABEL_COULEUR + " 1", policeCouleur1Field));
		add(makeFieldPanel(TextsProperties.LABEL_POLICE + " : " + TextsProperties.LABEL_COULEUR + " 2", policeCouleur2Field));
		add(makeFieldPanel(TextsProperties.LABEL_POLICE + " : " + TextsProperties.LABEL_COULEUR + " 3", policeCouleur3Field));
		add(makeFieldPanel(TextsProperties.LABEL_POLICE + " : " + TextsProperties.LABEL_COULEUR + " 4", policeCouleur4Field));
		add(makeFieldPanel(TextsProperties.LABEL_COULEURBRASSARD, brassardCouleurField));
	}
	
	public void load(Tenue tenue) {
		maillotField.setSelectedIndex(tenue.getMaillot());
		colField.setSelectedIndex(tenue.getCol());
		maillotCouleur1Field.setSelectedIndex(tenue.getMaillotCouleur1());
		maillotCouleur2Field.setSelectedIndex(tenue.getMaillotCouleur2());
		maillotCouleur3Field.setSelectedIndex(tenue.getMaillotCouleur3());
		maillotCouleur4Field.setSelectedIndex(tenue.getMaillotCouleur4());
		shortField.setSelectedIndex(tenue.getShortModele());
		shortMarquesField.setSelectedIndex(tenue.getShortMarques());
		shortCouleur1Field.setSelectedIndex(tenue.getShortCouleur1());
		shortCouleur2Field.setSelectedIndex(tenue.getShortCouleur2());
		shortCouleur3Field.setSelectedIndex(tenue.getShortCouleur3());
		shortCouleur4Field.setSelectedIndex(tenue.getShortCouleur4());
		chaussettesField.setSelectedIndex(tenue.getChaussettes());
		chaussettesCouleur1Field.setSelectedIndex(tenue.getChaussettesCouleur1());
		chaussettesCouleur2Field.setSelectedIndex(tenue.getChaussettesCouleur2());
		chaussettesCouleur3Field.setSelectedIndex(tenue.getChaussettesCouleur3());
		chaussettesCouleur4Field.setSelectedIndex(tenue.getChaussettesCouleur4());
		policeField.setSelectedIndex(tenue.getPolice());
		policeBordureField.setSelectedIndex(tenue.getPoliceBordure());
		policeCouleur1Field.setSelectedIndex(tenue.getPoliceCouleur1());
		policeCouleur2Field.setSelectedIndex(tenue.getPoliceCouleur2());
		policeCouleur3Field.setSelectedIndex(tenue.getPoliceCouleur3());
		policeCouleur4Field.setSelectedIndex(tenue.getPoliceCouleur4());
		brassardCouleurField.setSelectedIndex(tenue.getBrassardCouleur());
	}
	
	public void save(Tenue tenue) {
		tenue.setMaillot(maillotField.getSelectedIndex());
		tenue.setCol(colField.getSelectedIndex());
		tenue.setMaillotCouleur1(maillotCouleur1Field.getSelectedIndex());
		tenue.setMaillotCouleur2(maillotCouleur2Field.getSelectedIndex());
		tenue.setMaillotCouleur3(maillotCouleur3Field.getSelectedIndex());
		tenue.setMaillotCouleur4(maillotCouleur4Field.getSelectedIndex());
		tenue.setShortModele(shortField.getSelectedIndex());
		tenue.setShortMarques(shortMarquesField.getSelectedIndex());
		tenue.setShortCouleur1(shortCouleur1Field.getSelectedIndex());
		tenue.setShortCouleur2(shortCouleur2Field.getSelectedIndex());
		tenue.setShortCouleur3(shortCouleur3Field.getSelectedIndex());
		tenue.setShortCouleur4(shortCouleur4Field.getSelectedIndex());
		tenue.setChaussettes(chaussettesField.getSelectedIndex());
		tenue.setChaussettesCouleur1(chaussettesCouleur1Field.getSelectedIndex());
		tenue.setChaussettesCouleur2(chaussettesCouleur2Field.getSelectedIndex());
		tenue.setChaussettesCouleur3(chaussettesCouleur3Field.getSelectedIndex());
		tenue.setChaussettesCouleur4(chaussettesCouleur4Field.getSelectedIndex());
		tenue.setPolice(policeField.getSelectedIndex());
		tenue.setPoliceBordure(policeBordureField.getSelectedIndex());
		tenue.setPoliceCouleur1(policeCouleur1Field.getSelectedIndex());
		tenue.setPoliceCouleur2(policeCouleur2Field.getSelectedIndex());
		tenue.setPoliceCouleur3(policeCouleur3Field.getSelectedIndex());
		tenue.setPoliceCouleur4(policeCouleur4Field.getSelectedIndex());
		tenue.setBrassardCouleur(brassardCouleurField.getSelectedIndex());
	}
}
