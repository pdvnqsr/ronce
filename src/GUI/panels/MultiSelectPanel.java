package GUI.panels;


import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import data.properties.types.MultiSelectData;

public class MultiSelectPanel extends JPanel {
	
	private static final long serialVersionUID = -1747586526854018805L;

	private ArrayList<JComboBox<String>> fields;
	
	private String deselectedItem;
	
	public MultiSelectPanel(ElementPanel parent, MultiSelectData props) {
		setLayout(new GridLayout(props.getVals().size(),1));
		fields = new ArrayList<JComboBox<String>>();
		
		JComboBox<String> field;
		for(int i=0;i<props.getVals().size();i++) {
			field = parent.makeMultiComboboxComponent(props);
			fields.add(field);
			add(parent.makeFieldPanel(""+(i+1), field));
			field.addItemListener(new ItemListener() {
				@SuppressWarnings("unchecked")
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.DESELECTED) {
						deselectedItem = e.getItem().toString();
					} else {
						swapSelection((JComboBox<String>)e.getSource(), e.getItem().toString());
					}
				}
			});
		}
	}
	
	private void swapSelection(JComboBox<String> sourceField, String selected) {
		for(JComboBox<String> field : fields) {
			if(!field.equals(sourceField) && selected.equals(field.getSelectedItem())) {
				field.setSelectedItem(deselectedItem);
			}
		}
		deselectedItem = null;
	}
	
	public int[] getVals() {
		int[] vals = new int[fields.size()];
		for(int i=0;i<fields.size();i++) {
			vals[i] = fields.get(i).getSelectedIndex();
		}
		return vals;
	}
	
	public void setVals(int[] vals) {
		for(int i=0;i<fields.size();i++) {
			fields.get(i).setSelectedIndex(vals[i]);
		}
	}
}
