package edu.wedderz.core.app.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Collection;

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
	
	//private JTextField textField;
	private JScrollPane listPane;
	StationListController stationListController;
	
	public StationListView(StationListController stationListController) {
		this.stationListController = stationListController;
		setBackground(Color.BLACK);

		listPane = new JScrollPane();
		
		listPane.setPreferredSize(new Dimension(500, 500));
		
		listPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		/*
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{43, 116, 73, 81, 0};
		gridBagLayout.rowHeights = new int[]{25, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(10, 0, 10, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(stationList, gbc_textField);
		*/
		
		this.add(listPane);
		
	}
	
	public void setStationList(Collection<Station> stations) {
		System.out.println((stations.size() / 2) + stations.size() % 2);
		JPanel panel = new JPanel(new GridLayout((stations.size() / 2) + stations.size() % 2, 2));
		for(Station station : stations) {
			JPanel stationPanel = new JPanel();
			
			JLabel iconLabel = new JLabel(String.valueOf(station.getStationId()));
			iconLabel.setIcon(new ImageIcon(new ImageIcon("icons/estacion.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
			stationPanel.add(iconLabel);
			
			Locality locality = station.getLocality();
			stationPanel.add(new JLabel(locality != null ? locality.getName() : "Locality not defined"));
			
			JButton button = new JButton();
			button.setText("Ver estación");
			button.addActionListener(stationListController);
			button.setActionCommand(String.valueOf(station.getStationId()));
			stationPanel.add(button);
			
			panel.add(stationPanel);
		}
		listPane.setViewportView(panel);
		listPane.repaint();
	}

	
}
