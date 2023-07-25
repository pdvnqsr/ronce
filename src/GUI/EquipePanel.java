package GUI;


import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import data.Equipe;
import data.properties.DataProperties;
import data.properties.TextsProperties;

public class EquipePanel extends ElementPanel {

	private static final long serialVersionUID = -3464583622449755160L;

	private Equipe equipeSelectionne = null;
	
	private JTextField nomField;
	private JTextField abreviationField;
	private JComboBox<String> fondField;
	private JComboBox<String> fondMotifField;
	private JComboBox<String> fondCouleur1Field;
	private JComboBox<String> fondCouleur2Field;
	private JComboBox<String> fondCouleur3Field;
	private JComboBox<String> fondCouleur4Field;
	private JComboBox<String> milieuField;
	private JComboBox<String> milieuCouleur1Field;
	private JComboBox<String> milieuCouleur2Field;
	private JComboBox<String> coteField;
	private JComboBox<String> coteCouleur1Field;
	private JComboBox<String> coteCouleur2Field;
	private JComboBox<String> hautField;
	private JComboBox<String> hautCouleur1Field;
	private JComboBox<String> hautCouleur2Field;
	private JComboBox<String> basField;
	private JComboBox<String> basCouleur1Field;
	private JComboBox<String> basCouleur2Field;
	private MultiSelectPanel triElementsField;
	
	private TenuePanel[] tenuePanels;
	
	public EquipePanel() {
		setLayout(new GridLayout(1, 3));
		tenuePanels = new TenuePanel[4];
		tenuePanels[0] = new TenuePanel();
		tenuePanels[1] = new TenuePanel();
		tenuePanels[2] = new TenuePanel();
		tenuePanels[3] = new TenuePanel();
		
		GridLayout layout = new GridLayout(20,1);
		JPanel infosContainer = new JPanel();
		JPanel infos = new JPanel(layout);
		infosContainer.add(infos);
		add(infosContainer);
		
		JTabbedPane tenuesPane = new JTabbedPane(JTabbedPane.LEFT);
		tenuesPane.addTab(TextsProperties.LABEL_TENUEJOUEUR + "(" + TextsProperties.LABEL_DOMICILE + ")", tenuePanels[0]);
		tenuesPane.addTab(TextsProperties.LABEL_TENUEJOUEUR + "(" + TextsProperties.LABEL_EXTERIEUR + ")", tenuePanels[1]);
		tenuesPane.addTab(TextsProperties.LABEL_TENUEGARDIEN + "(" + TextsProperties.LABEL_DOMICILE + ")", tenuePanels[2]);
		tenuesPane.addTab(TextsProperties.LABEL_TENUEGARDIEN + "(" + TextsProperties.LABEL_EXTERIEUR + ")", tenuePanels[3]);
		add(tenuesPane);
		
		JPanel roster = new JPanel(layout);
		add(roster);
		
		nomField = new JTextField(DataProperties.EQUIPE_NOM.getLongueur());
		abreviationField = new JTextField(DataProperties.EQUIPE_ABREVIATION.getLongueur());
		fondField = makeComboboxComponent(DataProperties.EQUIPE_FOND);
		fondMotifField = makeComboboxComponent(DataProperties.EQUIPE_MOTIFFOND);
		fondCouleur1Field = makeComboboxComponent(DataProperties.EQUIPE_COULEURFOND1);
		fondCouleur2Field = makeComboboxComponent(DataProperties.EQUIPE_COULEURFOND2);
		fondCouleur3Field = makeComboboxComponent(DataProperties.EQUIPE_COULEURFOND3);
		fondCouleur4Field = makeComboboxComponent(DataProperties.EQUIPE_COULEURFOND4);
		milieuField = makeComboboxComponent(DataProperties.EQUIPE_MILIEU);
		milieuCouleur1Field = makeComboboxComponent(DataProperties.EQUIPE_COULEURMILIEU1);
		milieuCouleur2Field = makeComboboxComponent(DataProperties.EQUIPE_COULEURMILIEU2);
		coteField = makeComboboxComponent(DataProperties.EQUIPE_COTE);
		coteCouleur1Field = makeComboboxComponent(DataProperties.EQUIPE_COULEURCOTE1);
		coteCouleur2Field = makeComboboxComponent(DataProperties.EQUIPE_COULEURCOTE2);
		hautField = makeComboboxComponent(DataProperties.EQUIPE_HAUT);
		hautCouleur1Field = makeComboboxComponent(DataProperties.EQUIPE_COULEURHAUT1);
		hautCouleur2Field = makeComboboxComponent(DataProperties.EQUIPE_COULEURHAUT2);
		basField = makeComboboxComponent(DataProperties.EQUIPE_BAS);
		basCouleur1Field = makeComboboxComponent(DataProperties.EQUIPE_COULEURBAS1);
		basCouleur2Field = makeComboboxComponent(DataProperties.EQUIPE_COULEURBAS2);
		triElementsField = new MultiSelectPanel(this, DataProperties.EQUIPE_TRIPIECES);
		
		infos.add(makeFieldPanel(TextsProperties.LABEL_NOM, nomField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_ABREVIATION, abreviationField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_FOND, fondField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_MOTIF, fondMotifField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_FOND + " : " + TextsProperties.LABEL_COULEUR + " 1", fondCouleur1Field));
		infos.add(makeFieldPanel(TextsProperties.LABEL_FOND + " : " + TextsProperties.LABEL_COULEUR + " 2", fondCouleur2Field));
		infos.add(makeFieldPanel(TextsProperties.LABEL_FOND + " : " + TextsProperties.LABEL_COULEUR + " 3", fondCouleur3Field));
		infos.add(makeFieldPanel(TextsProperties.LABEL_FOND + " : " + TextsProperties.LABEL_COULEUR + " 4", fondCouleur4Field));
		infos.add(makeFieldPanel(TextsProperties.LABEL_MILIEU, milieuField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_MILIEU + " : " + TextsProperties.LABEL_COULEUR + " 1", milieuCouleur1Field));
		infos.add(makeFieldPanel(TextsProperties.LABEL_MILIEU + " : " + TextsProperties.LABEL_COULEUR + " 2", milieuCouleur2Field));
		infos.add(makeFieldPanel(TextsProperties.LABEL_COTE, coteField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_COTE + " : " + TextsProperties.LABEL_COULEUR + " 1", coteCouleur1Field));
		infos.add(makeFieldPanel(TextsProperties.LABEL_COTE + " : " + TextsProperties.LABEL_COULEUR + " 2", coteCouleur2Field));
		infos.add(makeFieldPanel(TextsProperties.LABEL_HAUT, hautField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_HAUT + " : " + TextsProperties.LABEL_COULEUR + " 1", hautCouleur1Field));
		infos.add(makeFieldPanel(TextsProperties.LABEL_HAUT + " : " + TextsProperties.LABEL_COULEUR + " 2", hautCouleur2Field));
		infos.add(makeFieldPanel(TextsProperties.LABEL_BAS, basField));
		infos.add(makeFieldPanel(TextsProperties.LABEL_BAS + " : " + TextsProperties.LABEL_COULEUR + " 1", basCouleur1Field));
		infos.add(makeFieldPanel(TextsProperties.LABEL_BAS + " : " + TextsProperties.LABEL_COULEUR + " 2", basCouleur2Field));
		infosContainer.add(makeFieldPanel(TextsProperties.LABEL_TRIPIECES + " : ", triElementsField));
		
		
		setEnabled(false);
	}
	
	public void save(){
		if(equipeSelectionne != null) {
			equipeSelectionne.setNom(nomField.getText());
			equipeSelectionne.setAbreviation(abreviationField.getText());
			equipeSelectionne.setFond(fondField.getSelectedIndex());
			equipeSelectionne.setMotifFond(fondMotifField.getSelectedIndex());
			equipeSelectionne.setCouleurFond1(fondCouleur1Field.getSelectedIndex());
			equipeSelectionne.setCouleurFond2(fondCouleur2Field.getSelectedIndex());
			equipeSelectionne.setCouleurFond3(fondCouleur3Field.getSelectedIndex());
			equipeSelectionne.setCouleurFond4(fondCouleur4Field.getSelectedIndex());
			equipeSelectionne.setMilieu(milieuField.getSelectedIndex());
			equipeSelectionne.setCouleurMilieu1(milieuCouleur1Field.getSelectedIndex());
			equipeSelectionne.setCouleurMilieu2(milieuCouleur2Field.getSelectedIndex());
			equipeSelectionne.setCote(coteField.getSelectedIndex());
			equipeSelectionne.setCouleurCote1(coteCouleur1Field.getSelectedIndex());
			equipeSelectionne.setCouleurCote2(coteCouleur2Field.getSelectedIndex());
			equipeSelectionne.setHaut(hautField.getSelectedIndex());
			equipeSelectionne.setCouleurHaut1(hautCouleur1Field.getSelectedIndex());
			equipeSelectionne.setCouleurHaut2(hautCouleur2Field.getSelectedIndex());
			equipeSelectionne.setBas(basField.getSelectedIndex());
			equipeSelectionne.setCouleurBas1(basCouleur1Field.getSelectedIndex());
			equipeSelectionne.setCouleurBas2(basCouleur2Field.getSelectedIndex());
			equipeSelectionne.setTriPieces(triElementsField.getVals());
			tenuePanels[0].save(equipeSelectionne.getTenues()[0]);
			tenuePanels[1].save(equipeSelectionne.getTenues()[1]);
			tenuePanels[2].save(equipeSelectionne.getTenues()[2]);
			tenuePanels[3].save(equipeSelectionne.getTenues()[3]);
		}
	}
	
	public void load(Equipe equipe){
		equipeSelectionne = equipe;

		if(equipe != null) {
			nomField.setText(equipe.getNom());
			abreviationField.setText(equipe.getAbreviation());
			fondField.setSelectedIndex(equipe.getFond());
			fondMotifField.setSelectedIndex(equipe.getMotifFond());
			fondCouleur1Field.setSelectedIndex(equipe.getCouleurFond1());
			fondCouleur2Field.setSelectedIndex(equipe.getCouleurFond2());
			fondCouleur3Field.setSelectedIndex(equipe.getCouleurFond3());
			fondCouleur4Field.setSelectedIndex(equipe.getCouleurFond4());
			milieuField.setSelectedIndex(equipe.getMilieu());
			milieuCouleur1Field.setSelectedIndex(equipe.getCouleurMilieu1());
			milieuCouleur2Field.setSelectedIndex(equipe.getCouleurMilieu2());
			coteField.setSelectedIndex(equipe.getCote());
			coteCouleur1Field.setSelectedIndex(equipe.getCouleurCote1());
			coteCouleur2Field.setSelectedIndex(equipe.getCouleurCote2());
			hautField.setSelectedIndex(equipe.getHaut());
			hautCouleur1Field.setSelectedIndex(equipe.getCouleurHaut1());
			hautCouleur2Field.setSelectedIndex(equipe.getCouleurHaut2());
			basField.setSelectedIndex(equipe.getBas());
			basCouleur1Field.setSelectedIndex(equipe.getCouleurBas1());
			basCouleur2Field.setSelectedIndex(equipe.getCouleurBas2());
			triElementsField.setVals(equipe.getTriPieces());
			tenuePanels[0].load(equipe.getTenues()[0]);
			tenuePanels[1].load(equipe.getTenues()[1]);
			tenuePanels[2].load(equipe.getTenues()[2]);
			tenuePanels[3].load(equipe.getTenues()[3]);
		}
	}

	public Equipe getEquipeSelectionne() {
		return equipeSelectionne;
	}

	public void setEquipeSelectionne(Equipe equipeSelectionne) {
		this.equipeSelectionne = equipeSelectionne;
	}
}
