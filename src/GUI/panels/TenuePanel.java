package GUI.panels;

import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import data.elements.Tenue;
import data.properties.DataProperties;
import data.properties.TextsProperties;
import data.properties.types.SelectData;

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
	
	public TenuePanel(boolean gk) {
		SelectData maillot;
		SelectData shorts;
		SelectData chaussettes;
		if(!gk) {
			maillot = DataProperties.EQUIPE_MAILLOT;
			shorts = DataProperties.EQUIPE_SHORT;
			chaussettes = DataProperties.EQUIPE_CHAUSSETTES;
		} else {
			maillot = DataProperties.EQUIPE_MAILLOTGK;
			shorts = DataProperties.EQUIPE_SHORTGK;
			chaussettes = DataProperties.EQUIPE_CHAUSSETTESGK;
		}
		
		maillotField = makeComboboxComponent(maillot);
		colField = makeComboboxComponent(DataProperties.EQUIPE_COL);
		maillotCouleur1Field = makeComboboxComponent(DataProperties.EQUIPE_MAILLOTCOULEUR1);
		maillotCouleur2Field = makeComboboxComponent(DataProperties.EQUIPE_MAILLOTCOULEUR2);
		maillotCouleur3Field = makeComboboxComponent(DataProperties.EQUIPE_MAILLOTCOULEUR3);
		maillotCouleur4Field = makeComboboxComponent(DataProperties.EQUIPE_MAILLOTCOULEUR4);
		shortField = makeComboboxComponent(shorts);
		shortMarquesField = makeComboboxComponent(DataProperties.EQUIPE_SHORTMARQUES);
		shortCouleur1Field = makeComboboxComponent(DataProperties.EQUIPE_SHORTCOULEUR1);
		shortCouleur2Field = makeComboboxComponent(DataProperties.EQUIPE_SHORTCOULEUR2);
		shortCouleur3Field = makeComboboxComponent(DataProperties.EQUIPE_SHORTCOULEUR3);
		shortCouleur4Field = makeComboboxComponent(DataProperties.EQUIPE_SHORTCOULEUR4);
		chaussettesField = makeComboboxComponent(chaussettes);
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
		
		JPanel maillotPanel = makeFieldPanel(TextsProperties.LABEL_MAILLOT, maillotField);
		JPanel colPanel = makeFieldPanel(TextsProperties.LABEL_COL, colField);
		JPanel maillotCouleur1Panel = makeFieldPanel("1", maillotCouleur1Field);
		JPanel maillotCouleur2Panel = makeFieldPanel("2", maillotCouleur2Field);
		JPanel maillotCouleur3Panel = makeFieldPanel("3", maillotCouleur3Field);
		JPanel maillotCouleur4Panel = makeFieldPanel("4", maillotCouleur4Field);
		JPanel shortPanel = makeFieldPanel(TextsProperties.LABEL_SHORT, shortField);
		JPanel shortMarquesPanel = makeFieldPanel(TextsProperties.LABEL_MARQUES, shortMarquesField);
		JPanel shortCouleur1Panel = makeFieldPanel("1", shortCouleur1Field);
		JPanel shortCouleur2Panel = makeFieldPanel("2", shortCouleur2Field);
		JPanel shortCouleur3Panel = makeFieldPanel("3", shortCouleur3Field);
		JPanel shortCouleur4Panel = makeFieldPanel("4", shortCouleur4Field);
		JPanel chaussettesPanel = makeFieldPanel(TextsProperties.LABEL_CHAUSSETTES, chaussettesField);
		JPanel chaussettesCouleur1Panel = makeFieldPanel("1", chaussettesCouleur1Field);
		JPanel chaussettesCouleur2Panel = makeFieldPanel("2", chaussettesCouleur2Field);
		JPanel chaussettesCouleur3Panel = makeFieldPanel("3", chaussettesCouleur3Field);
		JPanel chaussettesCouleur4Panel = makeFieldPanel("4", chaussettesCouleur4Field);
		JPanel policePanel = makeFieldPanel(TextsProperties.LABEL_POLICE, policeField);
		JPanel bordurePanel = makeFieldPanel(TextsProperties.LABEL_BORDURE, policeBordureField);
		JPanel policeCouleur1Panel = makeFieldPanel("1", policeCouleur1Field);
		JPanel policeCouleur2Panel = makeFieldPanel("2", policeCouleur2Field);
		JPanel policeCouleur3Panel = makeFieldPanel("3", policeCouleur3Field);
		JPanel policeCouleur4Panel = makeFieldPanel("4", policeCouleur4Field);
		JPanel brassardCouleurPanel = makeFieldPanel(TextsProperties.LABEL_COULEURBRASSARD, brassardCouleurField);
		
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHonorsVisibility(true);

		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(maillotPanel, 180, 180, 180)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(maillotCouleur1Panel, 70, 70, 70)
										.addComponent(maillotCouleur3Panel, 70, 70, 70)
								)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(maillotCouleur2Panel, 70, 70, 70)
										.addComponent(maillotCouleur4Panel, 70, 70, 70)
								)
						)
						.addComponent(policePanel, 180, 180, 180)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(policeCouleur1Panel, 70, 70, 70)
										.addComponent(policeCouleur3Panel, 70, 70, 70)
								)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(policeCouleur2Panel, 70, 70, 70)
										.addComponent(policeCouleur4Panel, 70, 70, 70)
								)
						)
						.addComponent(bordurePanel, 180, 180, 180)
						.addComponent(colPanel, 180, 180, 180)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(chaussettesPanel, 180, 180, 180)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(chaussettesCouleur1Panel, 70, 70, 70)
										.addComponent(chaussettesCouleur3Panel, 70, 70, 70)
								)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(chaussettesCouleur2Panel, 70, 70, 70)
										.addComponent(chaussettesCouleur4Panel, 70, 70, 70)
								)
						)
						.addComponent(shortPanel, 180, 180, 180)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(shortCouleur1Panel, 70, 70, 70)
										.addComponent(shortCouleur3Panel, 70, 70, 70)
								)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(shortCouleur2Panel, 70, 70, 70)
										.addComponent(shortCouleur4Panel, 70, 70, 70)
								)
						)
						.addComponent(shortMarquesPanel, 180, 180, 180)
						.addComponent(brassardCouleurPanel, 180, 180, 180)
				)
		);
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(maillotPanel)
						.addComponent(chaussettesPanel)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(maillotCouleur1Panel)
						.addComponent(maillotCouleur2Panel)
						.addComponent(chaussettesCouleur1Panel)
						.addComponent(chaussettesCouleur2Panel)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(maillotCouleur3Panel)
						.addComponent(maillotCouleur4Panel)
						.addComponent(chaussettesCouleur3Panel)
						.addComponent(chaussettesCouleur4Panel)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(policePanel)
						.addComponent(shortPanel)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(policeCouleur1Panel)
						.addComponent(policeCouleur2Panel)
						.addComponent(shortCouleur1Panel)
						.addComponent(shortCouleur2Panel)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(policeCouleur3Panel)
						.addComponent(policeCouleur4Panel)
						.addComponent(shortCouleur3Panel)
						.addComponent(shortCouleur4Panel)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(bordurePanel)
						.addComponent(shortMarquesPanel)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(colPanel)
						.addComponent(brassardCouleurPanel)
				)
		);
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
