package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.SearcherController;
import modelo.Locality;
import modelo.ProcessedData;
import modelo.SearcherModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class BusquedaLocalidades extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	SearcherModel searcherModel = new SearcherModel();
	WeatherPanel weatherPanel;
	SearcherController searcherController;

	
	public BusquedaLocalidades() {
		setBackground(Color.WHITE);
		
		weatherPanel = new WeatherPanel();
		searcherController = new SearcherController(this, weatherPanel, searcherModel);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{43, 116, 73, 81, 0};
		gridBagLayout.rowHeights = new int[]{25, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(10, 0, 10, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setActionCommand("searchButton");
		btnNewButton.addActionListener(searcherController);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton.insets = new Insets(10, 5, 10, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Locations");
		comboBox.addItem("Countries");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(10, 5, 10, 5);
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(weatherPanel, gbc_panel);
		
		
	}

	public String getTextField() {
		return textField.getText();
	}

	
}