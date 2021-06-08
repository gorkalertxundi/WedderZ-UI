package edu.wedderz.core.app.controller.station;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import edu.wedderz.core.app.controller.UserLoginController;
import edu.wedderz.core.app.view.station.StationList;
import edu.wedderz.core.dataaccess.repo.impl.StationServiceImpl;
import edu.wedderz.core.model.Data;
import edu.wedderz.core.model.DataType;

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