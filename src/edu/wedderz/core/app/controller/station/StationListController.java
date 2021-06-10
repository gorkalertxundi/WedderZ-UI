package edu.wedderz.core.app.controller.station;

import java.awt.event.ActionListener;
import java.util.Collection;

import edu.wedderz.core.app.view.station.StationList;
import edu.wedderz.core.model.Station;

public class StationListController {
	
	private StationList stationList;

	
	public StationListController(ActionListener parent) {
		stationList = new StationList(parent);
	}

	public StationList getStationList() {
		return stationList;
	}
	
	public void setStationList(Collection<Station> stations) {
		stationList.setStationList(stations);
	}


	

	
}