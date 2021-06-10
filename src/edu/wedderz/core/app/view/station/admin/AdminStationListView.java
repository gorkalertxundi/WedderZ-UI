package edu.wedderz.core.app.view.station.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.wedderz.core.app.controller.station.admin.AdminStationListController;
import edu.wedderz.core.app.view.station.StationList;

public class AdminStationListView extends JPanel {

	private AdminStationListController controller;

	private JTextField searchField;
	private JComboBox<String> searchMode;
	private final String[] searchModes = { "User", "Locality" };
	private JButton searchButton;

	public AdminStationListView(AdminStationListController controller, StationList stationList) {
		this.setBackground(Color.WHITE);
		this.controller = controller;
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JLabel headerLabel = new JLabel("Search stations:");
		headerLabel.setAlignmentX(CENTER_ALIGNMENT);
		headerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));

		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(Color.WHITE);

		searchField = new JTextField(10);
		searchPanel.add(searchField);

		searchMode = new JComboBox<>(searchModes);
		searchMode.setSelectedIndex(0);
		searchPanel.add(searchMode);

		searchButton = new JButton("Search");
		searchButton.addActionListener(controller);
		searchButton.setActionCommand("SEARCH");
		searchPanel.add(searchButton);

		JPanel headerWrapper = new JPanel();
		headerWrapper.setBackground(Color.WHITE);
		headerWrapper.add(headerLabel);
		headerWrapper.setMaximumSize(new Dimension(headerWrapper.getMaximumSize().width, 32));
		headerWrapper.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));

		this.add(Box.createVerticalGlue());
		this.add(headerWrapper);
		this.add(searchPanel);
		this.add(stationList);
		this.add(Box.createRigidArea(new Dimension(0, 32)));
		this.add(Box.createVerticalGlue());
	}

	public String getSearchFieldValue() {
		return searchField.getText();
	}

	public String getSearchMode() {
		return (String) searchMode.getSelectedItem();
	}

}
