package edu.wedderz.core.app.controller.station.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashSet;

import edu.wedderz.core.app.controller.station.StationDataListController;
import edu.wedderz.core.app.controller.station.StationListController;
import edu.wedderz.core.app.controller.station.user.UserStationController;
import edu.wedderz.core.app.view.UIFrame;
import edu.wedderz.core.app.view.station.StationList;
import edu.wedderz.core.app.view.station.admin.AdminStationListView;
import edu.wedderz.core.dataaccess.repo.impl.DataServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.LocalityServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.StationServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.UserServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.DataService;
import edu.wedderz.core.dataaccess.repo.serv.LocalityService;
import edu.wedderz.core.dataaccess.repo.serv.StationService;
import edu.wedderz.core.dataaccess.repo.serv.UserService;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Station;
import edu.wedderz.core.model.User;

public class AdminStationListController implements ActionListener {

	private final int MAX_DATA = 200;

	private static StationService stationService = new StationServiceImpl();
	private static DataService dataService = new DataServiceImpl();
	private static UserService userService = new UserServiceImpl();
	private static LocalityService localityService = new LocalityServiceImpl();

	private UIFrame parent;
	private AdminStationListView adminStationListView;
	private StationList stationList;
	private StationListController stationListController;

	private StationDataListController stationDataListController;

	private AdminStationController stationPanel;

	public AdminStationListController(UIFrame parent) {
		this.parent = parent;
		stationListController = new StationListController(this);
		stationList = stationListController.getStationList();
		adminStationListView = new AdminStationListView(this, stationList);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String ac = e.getActionCommand();

		switch (ac) {
		case "SEARCH":
			searchStations();
			break;
		default:
			switchToStationPanel(Integer.valueOf(ac));
		}

	}

	private void switchToStationPanel(int stationId) {
		Station station = stationService.getStationById(stationId);
		stationDataListController = new StationDataListController();
		stationDataListController.setDataList(dataService.getCrudeDataLatestByStation(station, MAX_DATA));
		stationPanel = new AdminStationController(station, stationDataListController.getStationDataList());
		parent.setContentPane(stationPanel.getAdminStationView());
		parent.refresh();
	}

	private void searchStations() {
		switch(adminStationListView.getSearchMode()) {
		case "User":
			searchByUser();
			break;
		case "Locality":
			searchByLocality();
			break;
		}
		
	}
	
	private void searchByUser() {
		Collection<User> users = userService.getUsersByName(adminStationListView.getSearchFieldValue());
		Collection<Station> results = new HashSet<>();
		for(User u : users) results.addAll(stationService.getStationsOfUser(u.getUserId()));
		stationListController.setStationList(results);
		
	}
	
	private void searchByLocality() {
		Collection<Locality> localities = localityService.getLocalitiesByName(adminStationListView.getSearchFieldValue());
		Collection<Station> results = new HashSet<>();
		for(Locality l : localities) results.addAll(stationService.getStationsByLocality(l));
		stationListController.setStationList(results);
	}
	

	public AdminStationListView getAdminStationListView() {
		return adminStationListView;
	}

}
