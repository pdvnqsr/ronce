package GUI.panels;


import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import data.elements.Equipe;
import data.properties.DataProperties;
import data.properties.TextsProperties;

public class EquipePanel extends ElementPanel {

	private static final long serialVersionUID = -3464583622449755160L;

	private Equipe equipeSelectionne = null;
	
	private JTextField idField;
	private JTextField descriptionField;
	
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
	private JComboBox<String> formationField;
	private JComboBox<String> capitaineField;
	private JComboBox<String> tireurCornerField;
	private RosterPanel rosterPanel;
	
	private TenuePanel[] tenuePanels;
	private TactiquePanel[] tactiquePanels;
	
	public EquipePanel() {
		setLayout(new GridLayout(1, 3));
		tenuePanels = new TenuePanel[4];
		tenuePanels[0] = new TenuePanel();
		tenuePanels[1] = new TenuePanel();
		tenuePanels[2] = new TenuePanel();
		tenuePanels[3] = new TenuePanel();
		
		tactiquePanels = new TactiquePanel[4];
		tactiquePanels[0] = new TactiquePanel(1);
		tactiquePanels[1] = new TactiquePanel(2);
		tactiquePanels[2] = new TactiquePanel(3);
		tactiquePanels[3] = new TactiquePanel(4);
		
		JTabbedPane tenuesPane = new JTabbedPane();
		tenuesPane.addTab(TextsProperties.LABEL_JOUEUR + " " + TextsProperties.LABEL_DOMICILE, tenuePanels[0]);
		tenuesPane.addTab(TextsProperties.LABEL_JOUEUR + " " + TextsProperties.LABEL_EXTERIEUR, tenuePanels[1]);
		tenuesPane.addTab(TextsProperties.LABEL_GARDIEN + " " + TextsProperties.LABEL_DOMICILE, tenuePanels[2]);
		tenuesPane.addTab(TextsProperties.LABEL_GARDIEN + " " + TextsProperties.LABEL_EXTERIEUR, tenuePanels[3]);
		add(tenuesPane);
		
		rosterPanel = new RosterPanel();
		
		idField = new JTextField(28);
		idField.setEditable(false);
		descriptionField = new JTextField(20);
		
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
		formationField = makeComboboxComponent(DataProperties.EQUIPE_FORMATION);
		capitaineField = makeComboboxComponent(DataProperties.EQUIPE_CAPITAINE);
		tireurCornerField = makeComboboxComponent(DataProperties.EQUIPE_TIREURCORNER);
		
		JPanel idPanel = makeFieldPanel(TextsProperties.LABEL_ID, idField);
		JPanel descriptionPanel = makeFieldPanel(TextsProperties.LABEL_DESCRIPTION, descriptionField);
		JPanel nomPanel = makeFieldPanel(TextsProperties.LABEL_NOM, nomField);
		JPanel abreviationPanel = makeFieldPanel(TextsProperties.LABEL_ABREVIATION, abreviationField);
		JPanel fondPanel = makeFieldPanel(TextsProperties.LABEL_FOND, fondField);
		JPanel fondMotifPanel = makeFieldPanel(TextsProperties.LABEL_MOTIF, fondMotifField);
		JPanel fondCouleur1Panel = makeFieldPanel("1", fondCouleur1Field);
		JPanel fondCouleur2Panel = makeFieldPanel("2", fondCouleur2Field);
		JPanel fondCouleur3Panel = makeFieldPanel("3", fondCouleur3Field);
		JPanel fondCouleur4Panel = makeFieldPanel("4", fondCouleur4Field);
		JPanel milieuPanel = makeFieldPanel(TextsProperties.LABEL_MILIEU, milieuField);
		JPanel milieuCouleur1Panel = makeFieldPanel("1", milieuCouleur1Field);
		JPanel milieuCouleur2Panel = makeFieldPanel("2", milieuCouleur2Field);
		JPanel cotePanel = makeFieldPanel(TextsProperties.LABEL_COTE, coteField);
		JPanel coteCouleur1Panel = makeFieldPanel("1", coteCouleur1Field);
		JPanel coteCouleur2Panel = makeFieldPanel("2", coteCouleur2Field);
		JPanel hautPanel = makeFieldPanel(TextsProperties.LABEL_HAUT, hautField);
		JPanel hautCouleur1Panel = makeFieldPanel("1", hautCouleur1Field);
		JPanel hautCouleur2Panel = makeFieldPanel("2", hautCouleur2Field);
		JPanel basPanel = makeFieldPanel(TextsProperties.LABEL_BAS, basField);
		JPanel basCouleur1Panel = makeFieldPanel("1", basCouleur1Field);
		JPanel basCouleur2Panel = makeFieldPanel("2", basCouleur2Field);
		JPanel triPanel = makeFieldPanel(TextsProperties.LABEL_TRIPIECES + " : ", triElementsField);
		
		JPanel formationPanel = makeFieldPanel(TextsProperties.LABEL_FORMATION, formationField);
		JPanel capitainePanel = makeFieldPanel(TextsProperties.LABEL_CAPITAINE, capitaineField);
		JPanel tireurCornerPanel = makeFieldPanel(TextsProperties.LABEL_TIREURCORNER, tireurCornerField);
		
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
									.addComponent(nomPanel, 300, 300, 300)
									.addComponent(abreviationPanel, 300, 300, 300)
									.addComponent(idPanel, 300, 300, 300)
									.addComponent(descriptionPanel, 300, 300, 300)
							)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addComponent(formationPanel, 220, 220, 220)
									.addComponent(capitainePanel, 220, 220, 220)
									.addComponent(tireurCornerPanel, 220, 220, 220)
							)
					)
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
									.addComponent(fondPanel, 170, 170, 170)
									.addGroup(layout.createSequentialGroup()
											.addComponent(fondCouleur1Panel, 70, 70, 70)
											.addComponent(fondCouleur2Panel, 70, 70, 70)
									)
									.addComponent(cotePanel, 170, 170, 170)
									.addGroup(layout.createSequentialGroup()
											.addComponent(coteCouleur1Panel, 70, 70, 70)
											.addComponent(coteCouleur2Panel, 70, 70, 70)
									)
									.addComponent(triPanel, 170, 170, 170)
							)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
									.addComponent(fondMotifPanel, 170, 170, 170)
									.addGroup(layout.createSequentialGroup()
											.addComponent(fondCouleur3Panel, 70, 70, 70)
											.addComponent(fondCouleur4Panel, 70, 70, 70)
									)
									.addComponent(hautPanel, 170, 170, 170)
									.addGroup(layout.createSequentialGroup()
											.addComponent(hautCouleur1Panel, 70, 70, 70)
											.addComponent(hautCouleur2Panel, 70, 70, 70)
									)
							)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
									.addComponent(milieuPanel, 170, 170, 170)
									.addGroup(layout.createSequentialGroup()
											.addComponent(milieuCouleur1Panel, 70, 70, 70)
											.addComponent(milieuCouleur2Panel, 70, 70, 70)
									)
									.addComponent(basPanel, 170, 170, 170)
									.addGroup(layout.createSequentialGroup()
											.addComponent(basCouleur1Panel, 70, 70, 70)
											.addComponent(basCouleur2Panel, 70, 70, 70)
									)
							)
					)
			)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addComponent(rosterPanel)
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addComponent(tactiquePanels[0], 350, 350, 350)
									.addComponent(tactiquePanels[1], 350, 350, 350)
									.addComponent(tactiquePanels[2], 350, 350, 350)
									.addComponent(tactiquePanels[3], 350, 350, 350)
							)
					)
			)
			.addGap(100)
			.addComponent(tenuesPane, 400, 400, 400)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(nomPanel)
							.addComponent(formationPanel)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(abreviationPanel)
							.addComponent(capitainePanel)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(descriptionPanel)
							.addComponent(tireurCornerPanel)
					)
					.addComponent(idPanel)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(fondPanel)
							.addComponent(fondMotifPanel)
							.addComponent(milieuPanel)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(fondCouleur1Panel)
							.addComponent(fondCouleur2Panel)
							.addComponent(fondCouleur3Panel)
							.addComponent(fondCouleur4Panel)
							.addComponent(milieuCouleur1Panel)
							.addComponent(milieuCouleur2Panel)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(cotePanel)
							.addComponent(hautPanel)
							.addComponent(basPanel)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(coteCouleur1Panel)
							.addComponent(coteCouleur2Panel)
							.addComponent(hautCouleur1Panel)
							.addComponent(hautCouleur2Panel)
							.addComponent(basCouleur1Panel)
							.addComponent(basCouleur2Panel)
					)
					.addComponent(triPanel)
			)
			.addGroup(layout.createSequentialGroup()
					.addComponent(tactiquePanels[0])
					.addComponent(tactiquePanels[1])
					.addComponent(tactiquePanels[2])
					.addComponent(tactiquePanels[3])
					.addComponent(rosterPanel)
			)
			.addGroup(layout.createSequentialGroup()
					.addComponent(tenuesPane)
			)
		);
		
		setEnabled(false);
	}
	
	public void save(){
		if(equipeSelectionne != null) {
			equipeSelectionne.setDescription(descriptionField.getText());
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
			equipeSelectionne.setFormation(formationField.getSelectedIndex());
			equipeSelectionne.setCapitaine(capitaineField.getSelectedIndex());
			equipeSelectionne.setTireurCorner(tireurCornerField.getSelectedIndex());
			tactiquePanels[0].save(equipeSelectionne.getTactiques()[0]);
			tactiquePanels[1].save(equipeSelectionne.getTactiques()[1]);
			tactiquePanels[2].save(equipeSelectionne.getTactiques()[2]);
			tactiquePanels[3].save(equipeSelectionne.getTactiques()[3]);
			rosterPanel.save(equipeSelectionne);
		}
	}
	
	public void load(Equipe equipe){
		equipeSelectionne = equipe;

		if(equipe != null) {
			idField.setText(equipe.getId());
			descriptionField.setText(equipe.getDescription());
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
			formationField.setSelectedIndex(equipe.getFormation());
			capitaineField.setSelectedIndex(equipe.getCapitaine());
			tireurCornerField.setSelectedIndex(equipe.getTireurCorner());
			tactiquePanels[0].load(equipe.getTactiques()[0]);
			tactiquePanels[1].load(equipe.getTactiques()[1]);
			tactiquePanels[2].load(equipe.getTactiques()[2]);
			tactiquePanels[3].load(equipe.getTactiques()[3]);	
			rosterPanel.load(equipe);
		}
	}
	
	public Equipe getEquipeSelectionne() {
		return equipeSelectionne;
	}

	public void setEquipeSelectionne(Equipe equipeSelectionne) {
		this.equipeSelectionne = equipeSelectionne;
	}

	public RosterPanel getRosterPanel() {
		return rosterPanel;
	}
}
