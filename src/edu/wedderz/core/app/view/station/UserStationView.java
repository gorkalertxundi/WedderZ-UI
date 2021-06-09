package edu.wedderz.core.app.view.station;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SpinnerNumberModel;

import edu.wedderz.core.app.controller.station.UserStationController;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Station;

public class UserStationView extends JPanel {

	private JTextArea descriptionField;
	private JTextField localitySearchField;
	private JComboBox<Locality> localitySearchResults;
	private JButton localitySearchButton;
	private JSpinner latitudeField;
	private JSpinner longitudeField;
	private JButton saveButton;

	public UserStationView(Station station, StationDataList dataList, UserStationController userStationController) {
		this.setBackground(Color.ORANGE);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(Box.createRigidArea(new Dimension(32, 0)));
		this.add(Box.createHorizontalGlue());
		
		JLabel idLabel = new JLabel("Station ID: " + station.getStationId());
		idLabel.setAlignmentX(CENTER_ALIGNMENT);
		idLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		JPanel headerWrapper = new JPanel();
		headerWrapper.setBackground(Color.WHITE);
		headerWrapper.add(idLabel);
		headerWrapper.setMaximumSize(new Dimension(headerWrapper.getMaximumSize().width, 32));
		headerWrapper.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
		this.add(headerWrapper);
		
		JPanel columnWrapper = new JPanel();
		columnWrapper.setLayout(new BoxLayout(columnWrapper, BoxLayout.LINE_AXIS));
		
		columnWrapper.add(Box.createRigidArea(new Dimension(32, 0)));
		columnWrapper.add(dataList);
		columnWrapper.add(Box.createRigidArea(new Dimension(32, 0)));
		
		
		JPanel stationFormPanel = new JPanel();
		stationFormPanel.setLayout(new BoxLayout(stationFormPanel, BoxLayout.PAGE_AXIS));
		
		descriptionField = new JTextArea();
		descriptionField.getDocument().addDocumentListener(userStationController);
		descriptionField.setBorder(BorderFactory.createTitledBorder("Description"));
		stationFormPanel.add(descriptionField);
		
		JPanel localitySearchPanel = new JPanel();
		
		localitySearchField = new JTextField(10);
		localitySearchField.setBorder(BorderFactory.createTitledBorder("Locality name"));
		localitySearchPanel.add(localitySearchField);
		
		localitySearchButton = new JButton();
		localitySearchButton.setText("Search");
		localitySearchButton.setActionCommand("SEARCH_LOCALITY");
		localitySearchButton.addActionListener(userStationController);
		localitySearchPanel.add(localitySearchButton);

		localitySearchResults = new JComboBox<>();
		localitySearchResults.setPreferredSize(new Dimension(128, 52));
		localitySearchResults.setRenderer(new ListCellRenderer<Locality>() {

			@Override
			public Component getListCellRendererComponent(JList<? extends Locality> list, Locality value, int index,
					boolean isSelected, boolean cellHasFocus) {
				return new JLabel(value.getName());
			}

			
			
		});
		localitySearchResults.setBorder(BorderFactory.createTitledBorder("Select locality"));
		localitySearchPanel.add(localitySearchResults);
		stationFormPanel.add(localitySearchPanel);
		
		if(station.getLocality() != null) {
			localitySearchField.setText(station.getLocality().getName());
			localitySearchResults.addItem(station.getLocality());
			localitySearchResults.setSelectedIndex(0);
		}
		
		
		
		JPanel coordPanel = new JPanel(new GridLayout(1, 2));
		
		latitudeField = new JSpinner(new SpinnerNumberModel());
		latitudeField.setBorder(BorderFactory.createTitledBorder("Latitude"));
		latitudeField.addChangeListener(userStationController);
		coordPanel.add(latitudeField);
		
		longitudeField = new JSpinner(new SpinnerNumberModel());
		longitudeField.setBorder(BorderFactory.createTitledBorder("Longitude"));
		longitudeField.addChangeListener(userStationController);
		coordPanel.add(longitudeField);

		stationFormPanel.add(coordPanel);
		
		saveButton = new JButton("Save changes");
		saveButton.setActionCommand("SAVE_FORM");
		saveButton.addActionListener(userStationController);
		saveButton.setEnabled(false);
		stationFormPanel.add(saveButton);
		
		columnWrapper.add(stationFormPanel);
		columnWrapper.add(Box.createRigidArea(new Dimension(32, 0)));
		columnWrapper.add(Box.createHorizontalGlue());
		
		this.add(columnWrapper);
	}

	public void setDescriptionField() {

	}
	
	public void enableSaveButton() {
		saveButton.setEnabled(true);
	}

}
