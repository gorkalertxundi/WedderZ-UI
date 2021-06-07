package edu.wedderz.core.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.wedderz.core.app.view.StationListView;
import edu.wedderz.core.dataaccess.repo.impl.StationServiceImpl;

public class StationListController implements ActionListener {
	
	StationListView stationListView;
	
	public StationListController() {
		stationListView = new StationListView(this);
		stationListView.setStationList(new StationServiceImpl().getStationsOfUser(UserLoginController.login(null, null).getUserId()));
	}

	public StationListView getStationListView() {
		return stationListView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}