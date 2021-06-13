package edu.wedderz.core.app.view.search;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.wedderz.core.app.controller.search.SearcherController;
import edu.wedderz.core.app.model.search.SearcherModel;
import edu.wedderz.core.app.view.UIFrame;

public class BusquedaLocalidades extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	SearcherModel searcherModel = new SearcherModel();
	WeatherPanel weatherPanel;
	LocationSelectionPanel locationSelectionPanel;
	SearcherController searcherController;
	JPanel currentJPanel;
	LocalityNotFound localityNotFound;
	JComboBox<String> comboBox;

	
	public BusquedaLocalidades(UIFrame uiFrame) {
		setBackground(Color.WHITE);
		
		weatherPanel = new WeatherPanel();
		localityNotFound = new LocalityNotFound();
		locationSelectionPanel = new LocationSelectionPanel();
		searcherController = new SearcherController(this, weatherPanel, searcherModel, locationSelectionPanel, uiFrame);
		
		searcherController.setValuesTEMPORAL();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{43, 116, 73, 81, 0};
		gridBagLayout.rowHeights = new int[]{25, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(20, 0, 10, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(25);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setActionCommand("searchButton");
		btnNewButton.addActionListener(searcherController);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(20, 5, 10, 10);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		comboBox = new JComboBox<String>();
		comboBox.addItem("Locality name");
		comboBox.addItem("Country");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(20, 5, 10, 290);
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 0, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		currentJPanel = weatherPanel;
		add(currentJPanel, gbc_panel);
		
		
	}

	public String getTextField() {
		return textField.getText();
	}

	public void changePanelToSelection() {
		this.remove(currentJPanel);
		currentJPanel = locationSelectionPanel;
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		this.add(currentJPanel, gbc_panel);
    }

	public void changePanelToData() {
		this.remove(currentJPanel);
		currentJPanel = weatherPanel;
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		this.add(currentJPanel, gbc_panel);
	}

	public void changePanelToNotFound() {
		this.remove(currentJPanel);
		currentJPanel = localityNotFound;
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		this.add(currentJPanel, gbc_panel);
	}

	public String getFilter() {
		return comboBox.getSelectedItem().toString();
	}

	
}
