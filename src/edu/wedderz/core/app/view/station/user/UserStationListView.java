package edu.wedderz.core.app.view.station.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.wedderz.core.app.controller.station.user.UserStationListController;
import edu.wedderz.core.app.view.station.StationList;

public class UserStationListView extends JPanel {

	UserStationListController controller;
	
	public UserStationListView(UserStationListController controller, StationList stationList) {
		this.setBackground(Color.WHITE);
		this.controller = controller;
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JLabel headerLabel = new JLabel("Your stations:");
		headerLabel.setAlignmentX(CENTER_ALIGNMENT);
		headerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		JPanel headerWrapper = new JPanel();
		headerWrapper.setBackground(Color.WHITE);
		headerWrapper.add(headerLabel);
		headerWrapper.setMaximumSize(new Dimension(headerWrapper.getMaximumSize().width, 32));
		headerWrapper.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
		
		this.add(Box.createVerticalGlue());
		this.add(headerWrapper);
		this.add(stationList);
		this.add(Box.createVerticalGlue());
		
		
		
	}

}
