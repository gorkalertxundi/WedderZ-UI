package edu.wedderz.core.app.view.station.admin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SpinnerNumberModel;

import edu.wedderz.core.app.controller.station.admin.AdminStationController;
import edu.wedderz.core.app.view.station.StationDataList;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Station;
import edu.wedderz.core.model.User;

public class AdminStationView extends JPanel {

	private final String NOT_DEFINED_TEXT = "Not defined";

	private JButton toggleDisableButton;

	public AdminStationView(Station station, User owner, StationDataList dataList,
			AdminStationController adminStationController) {
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

		JPanel stationInfoPanel = new JPanel();
		stationInfoPanel.setLayout(new BoxLayout(stationInfoPanel, BoxLayout.PAGE_AXIS));
		stationInfoPanel.setBackground(Color.WHITE);
		stationInfoPanel.setBorder(BorderFactory.createEmptyBorder(64, 64, 128, 64));
		stationInfoPanel.add(Box.createVerticalGlue());

		String ownerName = owner.getName();
		if(owner.getSurname() != null) ownerName += " " + owner.getSurname();
		
		JPanel userWrapper = new JPanel(new GridLayout());
		userWrapper.setBackground(Color.WHITE);
		JLabel userLabel = new JLabel(ownerName);
		userLabel.setBorder(BorderFactory.createTitledBorder("Owner"));
		userWrapper.add(userLabel);
		stationInfoPanel.add(userWrapper);
		stationInfoPanel.add(Box.createRigidArea(new Dimension(0, 16)));
		
		JPanel descriptionWrapper = new JPanel(new GridLayout());
		descriptionWrapper.setBackground(Color.WHITE);
		JLabel descriptionLabel = new JLabel(station.getDescription());
		descriptionLabel.setBorder(BorderFactory.createTitledBorder("Description"));
		descriptionWrapper.add(descriptionLabel);
		stationInfoPanel.add(descriptionWrapper);
		stationInfoPanel.add(Box.createRigidArea(new Dimension(0, 16)));

		JPanel localityWrapper = new JPanel(new GridLayout());
		localityWrapper.setBackground(Color.WHITE);
		JLabel localityLabel = new JLabel(
				(station.getLocality() != null) ? station.getLocality().getName() : NOT_DEFINED_TEXT);
		localityLabel.setBorder(BorderFactory.createTitledBorder("Locality name"));
		localityWrapper.add(localityLabel);
		stationInfoPanel.add(localityWrapper);

		stationInfoPanel.add(Box.createRigidArea(new Dimension(0, 16)));

		JPanel latitudeWrapper = new JPanel(new GridLayout());
		latitudeWrapper.setBackground(Color.WHITE);
		JLabel latitudeLabel = new JLabel(
				(station.getLatitude() != null) ? String.valueOf(station.getLatitude()) : NOT_DEFINED_TEXT);
		latitudeLabel.setBorder(BorderFactory.createTitledBorder("Latitude"));
		latitudeWrapper.add(latitudeLabel);
		stationInfoPanel.add(latitudeWrapper);

		stationInfoPanel.add(Box.createRigidArea(new Dimension(0, 16)));

		JPanel longitudeWrapper = new JPanel(new GridLayout());
		longitudeWrapper.setBackground(Color.WHITE);
		JLabel longitudeLabel = new JLabel(
				(station.getLongitude() != null) ? String.valueOf(station.getLongitude()) : NOT_DEFINED_TEXT);
		longitudeLabel.setBorder(BorderFactory.createTitledBorder("Longitude"));
		longitudeWrapper.add(longitudeLabel);
		stationInfoPanel.add(longitudeWrapper);
		stationInfoPanel.add(Box.createRigidArea(new Dimension(0, 16)));
		
		JPanel toggleButtonWrapper = new JPanel(new GridLayout());
		toggleButtonWrapper.setBackground(Color.WHITE);
		toggleDisableButton = new JButton();
		toggleDisableButton.addActionListener(adminStationController);
		setToggleButton(station.isDisabled());
		toggleButtonWrapper.add(toggleDisableButton);
		stationInfoPanel.add(toggleButtonWrapper);
		stationInfoPanel.add(Box.createRigidArea(new Dimension(0, 32)));
		stationInfoPanel.add(Box.createVerticalGlue());

		columnWrapper.add(stationInfoPanel);
		columnWrapper.add(Box.createRigidArea(new Dimension(32, 0)));
		columnWrapper.add(Box.createHorizontalGlue());

		this.add(columnWrapper);
		this.add(Box.createVerticalGlue());
	}

	public void setToggleButton(boolean disabled) {
		if (!disabled) {
			toggleDisableButton.setActionCommand("ENABLE_STATION");
			toggleDisableButton.setText("Enable");
		} else {
			toggleDisableButton.setActionCommand("DISABLE_STATION");
			toggleDisableButton.setText("Disable");
		}
	}

}
