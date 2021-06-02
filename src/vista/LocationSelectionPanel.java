package vista;

import javax.swing.JPanel;

import controlador.SearcherController;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import edu.wedderz.dataaccess.model.Locality;


public class LocationSelectionPanel extends JPanel{
	
	JComboBox<String> comboBox;
	JButton btnNewButton;
	
	public LocationSelectionPanel() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{440, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{22, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 5, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		
		btnNewButton = new JButton("Select");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
	}
	
	public void putLocalities(ArrayList<Locality> localities) {
		comboBox.removeAllItems();
		for (int i = 0; i < localities.size(); i++) {
			Locality locality = localities.get(i);
			comboBox.addItem(locality.getName());
		}
		comboBox.setSelectedIndex(-1);
		
	}

	public void setActionListener(SearcherController searcherController) {
		btnNewButton.setActionCommand("Selection");
		btnNewButton.addActionListener(searcherController);
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}
	
}
