package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import GUI.tabs.BuildsGUI;
import GUI.tabs.CompositionsGUI;
import GUI.tabs.EquipesGUI;
import GUI.tabs.JoueursGUI;
import data.properties.TextsProperties;

public class MainGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	public static Color darkBase = new Color(18,55,115);
	public static Color lightBase = new Color(240,250,250);
	public static Color gris = new Color(29,29,39);
	public static Color jaune = new Color(223,201,54);
	public static Color selectionBackground = new Color(11,98,148);
	public static Color selectionBorder = new Color(12,240,246);
	public static Font textFont;
	public static Font titreFont;
	
	private JoueursGUI joueursGUI;
	private EquipesGUI equipesGUI;
	private BuildsGUI buildsGUI;
	private CompositionsGUI compositionsGUI;

	static{
		try{
			textFont = Font.createFont(Font.TRUETYPE_FONT,new File("fonts/texte.ttf"));
			titreFont = Font.createFont(Font.TRUETYPE_FONT,new File("fonts/titre.ttf"));
		} catch(Exception e){e.printStackTrace();}
	}

	public MainGUI() {
		// Config visuelle
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			UIManager.put("Panel.background",darkBase);
			UIManager.put("Panel.font",textFont.deriveFont(Font.PLAIN,14));
			UIManager.put("Panel.foreground",lightBase);

			UIManager.put("Button.font",textFont.deriveFont(Font.PLAIN,14));

			UIManager.put("TitledBorder.titleColor",lightBase);
			UIManager.put("TitledBorder.font",titreFont.deriveFont(Font.PLAIN,14));

			UIManager.put("Label.background",darkBase);
			UIManager.put("Label.font",titreFont.deriveFont(Font.PLAIN,15));
			UIManager.put("Label.foreground",lightBase);

			UIManager.put("List.background",gris);
			UIManager.put("List.font",textFont.deriveFont(Font.BOLD,16));
			UIManager.put("List.foreground",lightBase);
			UIManager.put("List.selectionBackground",selectionBackground);
			UIManager.put("List.selectionForeground",lightBase);

			UIManager.put("OptionPane.background",darkBase);
			UIManager.put("OptionPane.font",textFont.deriveFont(Font.PLAIN,16));
			UIManager.put("OptionPane.foreground",lightBase);
			UIManager.put("OptionPane.MessageFont",textFont.deriveFont(Font.PLAIN,16));
			UIManager.put("OptionPane.messageForeground",lightBase);
			
			UIManager.put("Slider.background",darkBase);
			UIManager.put("Slider.tickColor",gris);
			UIManager.put("Slider.highlight",gris);
			UIManager.put("Slider.shadow",gris);
			
			/*UIManager.put("ComboBox.background",gris);
			UIManager.put("ComboBox.foreground",lightBase);
			UIManager.put("ComboBox.selectionBackground",selectionBackground);
			UIManager.put("ComboBox.selectionForeground",lightBase);
			UIManager.put("Table.background",gris);
			
			UIManager.put("TextField.background",gris);
			UIManager.put("TextField.foreground",lightBase);*/
			
			UIManager.put("ActiveCaption",Color.RED);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JTabbedPane mainPanel = new JTabbedPane();
		
		joueursGUI = new JoueursGUI();
		mainPanel.addTab(TextsProperties.LABEL_JOUEURS, joueursGUI);
		
		equipesGUI = new EquipesGUI();
		mainPanel.addTab(TextsProperties.LABEL_EQUIPES, equipesGUI);
		
		buildsGUI = new BuildsGUI();
		mainPanel.addTab(TextsProperties.LABEL_JOUEURSBASE, buildsGUI);
		
		compositionsGUI = new CompositionsGUI();
		mainPanel.addTab(TextsProperties.LABEL_EQUIPESBASE, compositionsGUI);
		
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		// Config fenêtre
		setTitle("R.O.N.C.E : Rise Of New Champions Editor");
		setIconImage(new ImageIcon("icon.png").getImage());
		setPreferredSize(new Dimension(1280,720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setLocationRelativeTo(getParent());
		setVisible(true);
	}

	public static JPanel getListePanel(JList<?> liste,String nom){
		JPanel listPanel = new JPanel(new BorderLayout());
		listPanel.setBorder(new EmptyBorder(5,5,5,5));
		listPanel.setPreferredSize(new Dimension(180,720));

		JLabel titre = new JLabel(nom);
		titre.setHorizontalAlignment(JLabel.CENTER);
		listPanel.add(titre,BorderLayout.NORTH);

		JScrollPane scroll = new JScrollPane(liste);
		listPanel.add(scroll,BorderLayout.CENTER);

		return listPanel;
	}
	
	public JoueursGUI getJoueursGUI() {
		return joueursGUI;
	}

	public void setJoueursGUI(JoueursGUI joueursGUI) {
		this.joueursGUI = joueursGUI;
	}

	public EquipesGUI getEquipesGUI() {
		return equipesGUI;
	}

	public void setEquipesGUI(EquipesGUI equipesGUI) {
		this.equipesGUI = equipesGUI;
	}
	
	public BuildsGUI getBuildsGUI() {
		return buildsGUI;
	}

	public void setBuildsGUI(BuildsGUI buildsGUI) {
		this.buildsGUI = buildsGUI;
	}

	public CompositionsGUI getCompositionsGUI() {
		return compositionsGUI;
	}

	public void setCompositionsGUI(CompositionsGUI compositionsGUI) {
		this.compositionsGUI = compositionsGUI;
	}
}
