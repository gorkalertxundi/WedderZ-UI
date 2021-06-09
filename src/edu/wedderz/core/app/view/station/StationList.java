package edu.wedderz.core.app.view.station;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.wedderz.core.app.controller.station.StationListController;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Station;

public class StationList extends JPanel {
	private static final long serialVersionUID = 1L;

	private JScrollPane listPane;
	StationListController stationListController;
	ActionListener parent;

	public StationList(StationListController stationListController, ActionListener parent) {
		this.stationListController = stationListController;
		this.parent = parent;
		setBackground(Color.WHITE);

		listPane = new JScrollPane();
		listPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		listPane.setPreferredSize(new Dimension(600, 550));
		listPane.setBackground(Color.WHITE);

		this.add(listPane);

	}

	public void setStationList(Collection<Station> stations) {
		JPanel wrapper = new JPanel();
		wrapper.setBackground(Color.WHITE);
		wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.PAGE_AXIS));
		for (Station station : stations) {
			JPanel stationWrapper = new JPanel();
			stationWrapper.setBackground(Color.WHITE);
			stationWrapper.setLayout(new BoxLayout(stationWrapper, BoxLayout.LINE_AXIS));
			stationWrapper.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createCompoundBorder(
					BorderFactory.createEmptyBorder(4, 4, 4, 4),
					BorderFactory.createLineBorder(Color.BLACK)),
					BorderFactory.createEmptyBorder(16, 8, 16, 8)
					));
			stationWrapper.add(Box.createHorizontalGlue());
			
			JPanel infoPanel = new JPanel();
			infoPanel.setBackground(Color.WHITE);
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
			button.setText("View");
			button.addActionListener(parent);
			button.setActionCommand(String.valueOf(station.getStationId()));
			button.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(8, 16, 8, 16)));
			stationWrapper.add(button);
			stationWrapper.add(Box.createHorizontalGlue());
			
			

			wrapper.add(stationWrapper);
		}
		listPane.setViewportView(wrapper);
		listPane.repaint();
	}

}
