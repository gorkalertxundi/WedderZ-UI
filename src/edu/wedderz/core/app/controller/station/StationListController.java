package edu.wedderz.core.app.controller.station;

import java.awt.event.ActionListener;

import edu.wedderz.core.app.controller.UserLoginController;
import edu.wedderz.core.app.view.station.StationList;
import edu.wedderz.core.dataaccess.repo.impl.StationServiceImpl;

public class StationListController {
	
	StationList stationList;
	
	public StationListController(ActionListener parent) {
		stationList = new StationList(this, parent);
		stationList.setStationList(new StationServiceImpl().getStationsOfUser(UserLoginController.login(null, null).getUserId()));
	}

	public StationList getStationList() {
		return stationList;
	}
	
}