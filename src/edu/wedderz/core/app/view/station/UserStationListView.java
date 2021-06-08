package edu.wedderz.core.app.view.station;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.wedderz.core.app.controller.station.UserStationListController;

public class UserStationListView extends JPanel {

	UserStationListController controller;
	
	public UserStationListView(UserStationListController controller, StationList stationList) {
		this.setBackground(Color.PINK);
		this.controller = controller;
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JLabel headerLabel = new JLabel("Your stations");
		headerLabel.setAlignmentY(CENTER_ALIGNMENT);
		headerLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		this.add(Box.createVerticalGlue());
		this.add(headerLabel);
		this.add(stationList);
		this.add(Box.createVerticalGlue());
		
		
	}

}
