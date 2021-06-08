package edu.wedderz.core.app.controller.station;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import edu.wedderz.core.app.view.UIFrame;
import edu.wedderz.core.app.view.station.StationList;
import edu.wedderz.core.app.view.station.UserStationListView;
import edu.wedderz.core.app.view.station.UserStationView;
import edu.wedderz.core.dataaccess.repo.impl.StationServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.StationService;
import edu.wedderz.core.model.Station;

public class UserStationListController implements ActionListener {
	
	StationService stationService = new StationServiceImpl();
	
	UIFrame parent;
	int a;
	UserStationListView userStationListView;
	StationList stationList;
	StationListController stationListController;
	
	JPanel stationPanel;
	
	
	public UserStationListController(UIFrame parent) {
		this.parent = parent;
		stationListController = new StationListController(this);
		stationList = stationListController.getStationList();
		userStationListView = new UserStationListView(this, stationList);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ac = e.getActionCommand();
		
		switch(ac) {
		
		case "search": System.out.println("Search");
			break;
		default:
			switchToStationPanel(Integer.valueOf(ac));
			System.out.println(Integer.valueOf(ac));
		}
		
	}
	
	void switchToStationPanel(int stationId) {
		Station station = stationService.getStationById(stationId);
		stationPanel = new UserStationView(station);
		parent.setContentPane(stationPanel);
		parent.refresh();
	}
	
	void switchToStationList() {
		parent.setContentPane(userStationListView);
	}
	
	public UserStationListView getUserStationListView() {
		return userStationListView;
	}

	
}
