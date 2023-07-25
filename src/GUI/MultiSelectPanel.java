package GUI;


import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import data.properties.MultiSelectData;

public class MultiSelectPanel extends JPanel {
	
	private static final long serialVersionUID = -1747586526854018805L;

	private ArrayList<JComboBox<String>> fields;
	
	public MultiSelectPanel(ElementPanel parent, MultiSelectData props) {
		setLayout(new GridLayout(props.getVals().size(),1));
		fields = new ArrayList<JComboBox<String>>();
		
		JComboBox<String> field;
		for(int i=0;i<props.getVals().size();i++) {
			field = parent.makeMultiComboboxComponent(props);
			fields.add(field);
			add(parent.makeFieldPanel(""+(i+1), field));
		}
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
