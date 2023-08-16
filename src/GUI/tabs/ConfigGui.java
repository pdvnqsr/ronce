package GUI.tabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.properties.SystemProperties;
import data.properties.TextsProperties;
import main.Launch;

public class ConfigGui extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public ConfigGui() {
		JButton modifierLocale = new JButton(TextsProperties.BUTTON_MODIFIER);
		modifierLocale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Launch.getInstance().changeLocale(true);
			}
		});
		JButton modifierSavedata = new JButton(TextsProperties.BUTTON_MODIFIER);
		modifierSavedata.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Launch.getInstance().changeSavedata(true);
			}
		});
		
		JLabel locale = new JLabel("Locale : " + SystemProperties.LOCALE);
		JLabel savedata = new JLabel("Savedata : " + SystemProperties.PATH);
		
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHonorsVisibility(true);

		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(modifierLocale)
						.addGap(10)
						.addComponent(locale)
				)
				.addGroup(layout.createSequentialGroup()
						.addComponent(modifierSavedata)
						.addGap(10)
						.addComponent(savedata)
				)
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(modifierLocale)
						.addComponent(locale)
				)
				.addGap(20)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(savedata)
						.addComponent(modifierSavedata)
				)
		);
	}

}
