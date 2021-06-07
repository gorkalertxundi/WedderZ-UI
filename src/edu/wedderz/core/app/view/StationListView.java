package edu.wedderz.core.app.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.wedderz.core.app.controller.StationListController;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Station;

public class StationListView extends JPanel {
	private static final long serialVersionUID = 1L;

	// private JTextField textField;
	private JScrollPane listPane;
	StationListController stationListController;

	public StationListView(StationListController stationListController) {
		this.stationListController = stationListController;
		setBackground(Color.BLACK);

		listPane = new JScrollPane();

		listPane.setPreferredSize(new Dimension(400, 350));

		listPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		/*
		 * GridBagLayout gridBagLayout = new GridBagLayout(); gridBagLayout.columnWidths
		 * = new int[]{43, 116, 73, 81, 0}; gridBagLayout.rowHeights = new int[]{25, 0,
		 * 0}; gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0,
		 * Double.MIN_VALUE}; gridBagLayout.rowWeights = new double[]{0.0, 1.0,
		 * Double.MIN_VALUE}; setLayout(gridBagLayout);
		 * 
		 * GridBagConstraints gbc_textField = new GridBagConstraints();
		 * gbc_textField.fill = GridBagConstraints.HORIZONTAL; gbc_textField.insets =
		 * new Insets(10, 0, 10, 5); gbc_textField.gridx = 1; gbc_textField.gridy = 0;
		 * add(stationList, gbc_textField);
		 */

		this.add(listPane);

	}

	public void setStationList(Collection<Station> stations) {
		System.out.println((stations.size() / 2) + stations.size() % 2);
		//JPanel panel = new JPanel(new GridLayout((stations.size() / 2) + stations.size() % 2, 2));
		JPanel wrapper = new JPanel();
		wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.PAGE_AXIS));
		for (Station station : stations) {
			JPanel stationWrapper = new JPanel();
			stationWrapper.setLayout(new BoxLayout(stationWrapper, BoxLayout.LINE_AXIS));
			stationWrapper.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createCompoundBorder(
					BorderFactory.createEmptyBorder(4, 4, 4, 4),
					BorderFactory.createLineBorder(Color.BLACK)),
					BorderFactory.createEmptyBorder(16, 8, 16, 8)
					));
			stationWrapper.add(Box.createRigidArea(new Dimension(16, 0)));
			
			JPanel infoPanel = new JPanel();
			infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
			infoPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 40));

			JLabel idLabel = new JLabel("Station #" + String.valueOf(station.getStationId()));
			idLabel.setIcon(new ImageIcon(
					new ImageIcon("icons/estacion.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
			infoPanel.add(idLabel);
			infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
			
			Locality locality = station.getLocality();
			infoPanel.add(new JLabel("Locality: " + (locality != null
					? locality.getName() + ", " + locality.getCountry().getCountryId().toUpperCase()
					: "Not defined")));
			infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));

			String description = station.getDescription();
			infoPanel.add(new JLabel("Description: " + (description != null ? description : "Not defined")));
			infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));

			Double latitude = station.getLatitude();
			infoPanel.add(new JLabel("Latitude: " + ((latitude != null && latitude != 0) ? String.valueOf(latitude) : "Not defined")));
			infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));

			Double longitude = station.getLongitude();
			infoPanel.add(new JLabel("Longitude: " + ((longitude != null && longitude != 0) ?  String.valueOf(longitude) : "Not defined")));
			infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));

			stationWrapper.add(infoPanel);
			stationWrapper.add(Box.createHorizontalGlue());
			
			JButton button = new JButton();
			button.setText("Ver");
			button.addActionListener(stationListController);
			button.setActionCommand(String.valueOf(station.getStationId()));
			button.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(8, 16, 8, 16)));
			stationWrapper.add(button);
			stationWrapper.add(Box.createRigidArea(new Dimension(16, 0)));
			
			

			wrapper.add(stationWrapper);
		}
		listPane.setViewportView(wrapper);
		listPane.repaint();
	}

}
