package edu.wedderz.core.app.view.station;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import edu.wedderz.core.model.Station;

public class UserStationView extends JPanel {
	
	public UserStationView(Station station, StationDataList dataList) {
		this.setBackground(Color.ORANGE);
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(Box.createHorizontalGlue());
		this.add(dataList);
		//this.add(Box.createRigidArea(new Dimension(32, 0)));
		this.add(Box.createHorizontalGlue());
	}
	
	
	
	
}
