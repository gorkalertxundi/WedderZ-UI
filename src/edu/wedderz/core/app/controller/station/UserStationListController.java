package edu.wedderz.core.app.controller.station;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import edu.wedderz.core.app.view.UIFrame;
import edu.wedderz.core.app.view.station.StationDataList;
import edu.wedderz.core.app.view.station.StationList;
import edu.wedderz.core.app.view.station.UserStationListView;
import edu.wedderz.core.app.view.station.UserStationView;
import edu.wedderz.core.dataaccess.repo.impl.DataServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.StationServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.DataService;
import edu.wedderz.core.dataaccess.repo.serv.StationService;
import edu.wedderz.core.model.Station;

public class UserStationListController implements ActionListener {
	
	private final int MAX_DATA = 200;
	
	private static StationService stationService = new StationServiceImpl();
	private static DataService dataService = new DataServiceImpl();
	
	UIFrame parent;
	int a;
	UserStationListView userStationListView;
	StationList stationList;
	StationListController stationListController;
	
	StationDataList stationDataList;
	
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
		}
		
	}
	
	void switchToStationPanel(int stationId) {
		Station station = stationService.getStationById(stationId);
		stationDataList = new StationDataList();
		stationDataList.setDataList(dataService.getCrudeDataLatestByStation(station, MAX_DATA));
		stationPanel = new UserStationView(station, stationDataList);
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