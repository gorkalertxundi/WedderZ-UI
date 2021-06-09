package edu.wedderz.core.app.view.station;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;
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
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(Box.createRigidArea(new Dimension(0, 32)));
		this.add(Box.createVerticalGlue());
		
		JLabel idLabel = new JLabel("Station ID: " + station.getStationId());
		idLabel.setIcon(new ImageIcon(
				new ImageIcon("icons/estacion.png").getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH)));
		idLabel.setAlignmentX(CENTER_ALIGNMENT);
		idLabel.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		JPanel headerWrapper = new JPanel();
		headerWrapper.setBackground(Color.WHITE);
		headerWrapper.add(idLabel);
		headerWrapper.setMaximumSize(new Dimension(headerWrapper.getMaximumSize().width, 32));
		headerWrapper.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
		this.add(headerWrapper);
		
		JPanel columnWrapper = new JPanel();
		columnWrapper.setBackground(Color.WHITE);
		columnWrapper.setLayout(new BoxLayout(columnWrapper, BoxLayout.LINE_AXIS));
		
		columnWrapper.add(Box.createRigidArea(new Dimension(64, 0)));
		columnWrapper.add(dataList);
		
		
		JPanel stationFormPanel = new JPanel();
		stationFormPanel.setLayout(new BoxLayout(stationFormPanel, BoxLayout.PAGE_AXIS));
		stationFormPanel.setBackground(Color.WHITE);
		stationFormPanel.setBorder(BorderFactory.createEmptyBorder(64, 64, 128, 64));
		stationFormPanel.add(Box.createVerticalGlue());
		
		descriptionField = new JTextArea(station.getDescription());
		descriptionField.getDocument().addDocumentListener(userStationController);
		JScrollPane descriptionPane = new JScrollPane(descriptionField);
		descriptionPane.setBorder(BorderFactory.createTitledBorder("Description"));
		descriptionPane.setBackground(Color.WHITE);
		stationFormPanel.add(descriptionPane);
		stationFormPanel.add(Box.createRigidArea(new Dimension(0, 16)));
		
		
		JPanel localitySearchPanel = new JPanel(new FlowLayout());
		localitySearchPanel.setBackground(Color.WHITE);
		
		localitySearchField = new JTextField(10);
		localitySearchField.setBorder(BorderFactory.createTitledBorder("Locality name"));
		localitySearchPanel.add(localitySearchField);
		
		localitySearchButton = new JButton();
		localitySearchButton.setText("Search");
		localitySearchButton.setActionCommand("SEARCH_LOCALITY");
		localitySearchButton.addActionListener(userStationController);
		localitySearchButton.setPreferredSize(new Dimension(80, 32));
		localitySearchPanel.add(localitySearchButton);

		localitySearchResults = new JComboBox<>();
		localitySearchResults.setBackground(Color.WHITE);
		localitySearchResults.setPreferredSize(new Dimension(128, 48));
		localitySearchResults.setRenderer(new ListCellRenderer<Locality>() {

			@Override
			public Component getListCellRendererComponent(JList<? extends Locality> list, Locality value, int index,
					boolean isSelected, boolean cellHasFocus) {
				return new JLabel(value.getName());
			}
		});
		localitySearchResults.setBorder(BorderFactory.createTitledBorder("Select locality"));
		stationFormPanel.add(localitySearchPanel);
		stationFormPanel.add(Box.createRigidArea(new Dimension(0, 16)));
		stationFormPanel.add(localitySearchResults);
		
		stationFormPanel.add(Box.createRigidArea(new Dimension(0, 16)));
		
		if(station.getLocality() != null) {
			localitySearchField.setText(station.getLocality().getName());
			localitySearchResults.addItem(station.getLocality());
			localitySearchResults.setSelectedIndex(0);
		}
		
		
		stationFormPanel.add(Box.createRigidArea(new Dimension(0, 16)));
		
		
		double latitude = 0.0;
		if(station.getLatitude() != null) latitude = station.getLatitude();
		SpinnerNumberModel latitudeModel = new SpinnerNumberModel(latitude, -90.0, 90.0, 0.1);
		latitudeField = new JSpinner(latitudeModel);
		latitudeField.setBorder(BorderFactory.createTitledBorder("Latitude"));
		latitudeField.addChangeListener(userStationController);
		latitudeField.setMaximumSize(new Dimension(300, 64));
		latitudeField.setBackground(Color.WHITE);
		stationFormPanel.add(latitudeField);
		stationFormPanel.add(Box.createRigidArea(new Dimension(0, 16)));
		
		double longitude = 0.0;
		if(station.getLongitude() != null) longitude = station.getLongitude();
		SpinnerNumberModel longitudeModel = new SpinnerNumberModel(longitude, -180.0, 180.0, 0.1);
		longitudeField = new JSpinner(longitudeModel);
		longitudeField.setBorder(BorderFactory.createTitledBorder("Longitude"));
		longitudeField.addChangeListener(userStationController);
		longitudeField.setMaximumSize(new Dimension(300, 64));
		longitudeField.setBackground(Color.WHITE);
		stationFormPanel.add(longitudeField);

		
		stationFormPanel.add(Box.createRigidArea(new Dimension(0, 32)));
		saveButton = new JButton("Save changes");
		saveButton.setActionCommand("SAVE_FORM");
		saveButton.addActionListener(userStationController);
		saveButton.setEnabled(false);
		stationFormPanel.add(saveButton);
		stationFormPanel.add(Box.createRigidArea(new Dimension(0, 32)));
		stationFormPanel.add(Box.createVerticalGlue());
		
		columnWrapper.add(stationFormPanel);
		columnWrapper.add(Box.createRigidArea(new Dimension(32, 0)));
		columnWrapper.add(Box.createHorizontalGlue());
		
		this.add(columnWrapper);
		this.add(Box.createVerticalGlue());
	}

	public void setLocalityResults(Collection<Locality> localities) {
		localitySearchResults.removeAllItems();
		for(Locality l : localities) localitySearchResults.addItem(l);
	}
	
	public void enableSaveButton() {
		saveButton.setEnabled(true);
	}
	
	public String getDescription() {
		return descriptionField.getText();
	}
	
	public Locality getLocality() {
		return (Locality) localitySearchResults.getSelectedItem();
	}
	
	public Double getLatitude() {
		return (Double) latitudeField.getValue();
	}
	
	public Double getLongitude() {
		return (Double) longitudeField.getValue();
	}
	
	public String getSearch() {
		return localitySearchField.getText();
	}

}
