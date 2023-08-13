package GUI.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import GUI.utils.BoundsPopupMenuListener;
import data.elements.Joueur;
import data.properties.DataProperties;
import data.properties.mappings.JoueurMapping;
import data.properties.types.IncrementalData;
import data.properties.types.MultiSelectData;
import data.properties.types.NumericData;
import data.properties.types.SelectData;
import main.Launch;

public class ElementPanel extends JPanel {

	private static final long serialVersionUID = 5425440262836656704L;

	public JComboBox<String> makeComboboxComponent(SelectData props) {
		Dimension dimension = new Dimension();
		JComboBox<String> component = new JComboBox<String>();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for(int i=0 ; i<props.getVals().size() ; i++) {
			model.addElement(props.getVals().get(i).getDisplayValue());
		}
		component.setModel(model);

		String sample = props.getVals().get(0).getDisplayValue();
		
		if(sample.toString().startsWith("#")) {
			component.setRenderer(new DefaultListCellRenderer() {
				private static final long serialVersionUID = 1L;
				@Override
				public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
					DefaultListCellRenderer cell = (DefaultListCellRenderer) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					cell.setIcon(getImageFromColor(value.toString()));
					cell.setText("");

					list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
					list.setVisibleRowCount(Math.round((float)list.getModel().getSize()/(float)12));
					return cell;
				}
			});
			BoundsPopupMenuListener menuListener = new BoundsPopupMenuListener();
			menuListener.setPopupWider(true);
			menuListener.setScrollBarRequired(false);
			component.addPopupMenuListener(menuListener);
			
		} else if(sample.toString().startsWith("img/")) {
			component.setRenderer(new DefaultListCellRenderer() {
				private static final long serialVersionUID = 1L;
				@Override
				public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
					DefaultListCellRenderer cell = (DefaultListCellRenderer) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					cell.setIcon(getImageFromPath(value.toString()));
					cell.setText("");

					list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
					list.setVisibleRowCount(Math.round((float)list.getModel().getSize()/(float)4));
					dimension.setSize(cell.getIcon().getIconWidth() + 14, cell.getIcon().getIconHeight() + 4);
					return cell;
				}
			});
			BoundsPopupMenuListener menuListener = new BoundsPopupMenuListener();
			menuListener.setPopupWider(true);
			menuListener.setScrollBarRequired(true);
			component.addPopupMenuListener(menuListener);
			component.setPreferredSize(dimension);
		} else {
			AutoCompleteDecorator.decorate(component);
		}

		return component;
	}

	public JComboBox<String> makeMultiComboboxComponent(MultiSelectData props) {
		JComboBox<String> component = new JComboBox<String>();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for(int i=0 ; i<props.getVals().size() ; i++) {
			model.addElement(props.getVals().get(i).getDisplayValue());
		}
		component.setModel(model);
		AutoCompleteDecorator.decorate(component);
		return component;
	}

	public JComboBox<JoueurMapping> makeJoueursComboboxComponent() {
		JComboBox<JoueurMapping> component = new JComboBox<JoueurMapping>();
		setJoueursComboboxModel(component);
		AutoCompleteDecorator.decorate(component);
		return component;
	}

	public void setJoueursComboboxModel(JComboBox<JoueurMapping> component) {
		DefaultComboBoxModel<JoueurMapping> model = new DefaultComboBoxModel<JoueurMapping>();
		// Joueurs de base
		IncrementalData props = DataProperties.JOUEURSBASE;
		for(int i=0 ; i<props.getVals().size() ; i++) {
			model.addElement(props.getVals().get(i));
		}
		// Joueurs du stock
		for(Joueur j : Launch.getInstance().getData().getJoueurs()) {
			model.addElement(new JoueurMapping(j.getId(), j.getNom()));
		}
		Joueur j;
		// Joueurs du jeu non présents dans le stock
		for(int i=0 ; i<DataProperties.JOUEURSCUSTOM.getNombre() ; i++) {
			j = Launch.getInstance().getData().getJoueursInGame().get(i);
			if(!Launch.getInstance().getData().getJoueurs().contains(j)) {
				model.addElement(new JoueurMapping("" + DataProperties.JOUEURSCUSTOM.getVals().get(i).getInGameValue(), j.getNom()));
			}
		}
		component.setModel(model);
	}

	public JSlider makeSliderComponent(NumericData props) {
		JSlider component = new JSlider(props.getMin(), props.getMax(), props.getDefaut());
		return component;
	}

	public JSpinner makeSpinnerComponent(NumericData props) {
		JSpinner component = new JSpinner(new SpinnerNumberModel(props.getDefaut(), props.getMin(), props.getMax(), 1));
		return component;
	}

	public JPanel makeFieldPanel(String nom, JComponent champ) {
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT,5,0);
		JPanel panel = new JPanel(layout);
		JLabel nomLabel = new JLabel(nom);
		panel.add(nomLabel);
		panel.add(champ);
		return panel;
	}

	public List<Component> getAllComponents(final Container c) {
		Component[] comps = c.getComponents();
		List<Component> compList = new ArrayList<Component>();
		for (Component comp : comps) {
			compList.add(comp);
			if (comp instanceof Container && !(comp instanceof TactiquePanel))
				compList.addAll(getAllComponents((Container) comp));
		}
		return compList;
	}

	@Override
	public void setEnabled(boolean enabled) {
		List<Component> comps = getAllComponents(this);
		for (Component comp : comps) {
			comp.setEnabled(enabled || (comp instanceof JTabbedPane));
		}
	}

	public ImageIcon getImageFromPath(String path) {
		Image image = new ImageIcon(path).getImage();
		ImageIcon icon;
		if(path.contains("/celebrations/")) {
			int w = (int)(image.getWidth(null) * 0.8);
			int h = (int)(image.getHeight(null) * 0.8);
			icon = new ImageIcon(image.getScaledInstance(w, h, Image.SCALE_AREA_AVERAGING));	
		} else {
			icon = new ImageIcon(image);
		}
		return icon;
	}
	
	public ImageIcon getImageFromColor(String code) {
		BufferedImage image = new BufferedImage(25, 25, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = image.createGraphics();
		graphics.setPaint(new Color(Integer.parseInt(code.replace("#",""), 16)));
		graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
		ImageIcon imageIcon = new ImageIcon(image);
		return imageIcon;
	}
}
