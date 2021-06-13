package edu.wedderz.core.app.controller.station.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import edu.wedderz.core.app.controller.station.StationDataListController;
import edu.wedderz.core.app.controller.station.StationListController;
import edu.wedderz.core.app.view.UIFrame;
import edu.wedderz.core.app.view.station.StationDataList;
import edu.wedderz.core.app.view.station.StationList;
import edu.wedderz.core.app.view.station.user.UserStationListView;
import edu.wedderz.core.app.view.station.user.UserStationView;
import edu.wedderz.core.dataaccess.repo.impl.DataServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.StationServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.DataService;
import edu.wedderz.core.dataaccess.repo.serv.StationService;
import edu.wedderz.core.model.Station;
import edu.wedderz.core.model.User;

public class UserStationListController implements ActionListener {

	private final int MAX_DATA = 200;

	private static StationService stationService = new StationServiceImpl();
	private static DataService dataService = new DataServiceImpl();

	private UIFrame parent;
	private UserStationListView userStationListView;
	private StationList stationList;
	private StationListController stationListController;

	private StationDataListController stationDataListController;

	private UserStationController stationPanel;

	public UserStationListController(UIFrame parent, User user) {
		this.parent = parent;
		stationListController = new StationListController(this);
		stationList = stationListController.getStationList();
		stationList.setStationList(stationService.getStationsOfUser(user.getUserId()));
		userStationListView = new UserStationListView(this, stationList);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String ac = e.getActionCommand();

		switch (ac) {
		default:
			switchToStationPanel(Integer.valueOf(ac));
		}

	}

	void switchToStationPanel(int stationId) {
		Station station = stationService.getStationById(stationId);
		stationDataListController = new StationDataListController();
		stationDataListController.setDataList(dataService.getCrudeDataLatestByStation(station, MAX_DATA));
		stationPanel = new UserStationController(station, stationDataListController.getStationDataList());
		parent.setContentPane(stationPanel.getUserStationView());
		parent.refresh();
	}

	void switchToStationList() {
		parent.setContentPane(userStationListView);
	}

	public UserStationListView getUserStationListView() {
		return userStationListView;
	}

}
