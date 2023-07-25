package GUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import data.properties.MultiSelectData;
import data.properties.NumericData;
import data.properties.SelectData;

public class ElementPanel extends JPanel {

	private static final long serialVersionUID = 5425440262836656704L;

	public JComboBox<String> makeComboboxComponent(SelectData props) {
		JComboBox<String> component = new JComboBox<String>();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for(int i=0 ; i<props.getVals().size() ; i++) {
			model.addElement(props.getVals().get(i).getDisplayValue());		}
		component.setModel(model);
		AutoCompleteDecorator.decorate(component);
		return component;
	}

	public JComboBox<String> makeMultiComboboxComponent(MultiSelectData props) {
		JComboBox<String> component = new JComboBox<String>();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for(int i=0 ; i<props.getVals().size() ; i++) {
			model.addElement(props.getVals().get(i).getDisplayValue());		}
		component.setModel(model);
		AutoCompleteDecorator.decorate(component);
		return component;
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
            if (comp instanceof Container)
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
}
