package edu.wedderz.core.app.controller.station.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.wedderz.core.app.view.station.StationDataList;
import edu.wedderz.core.app.view.station.admin.AdminStationView;
import edu.wedderz.core.dataaccess.repo.impl.LocalityServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.StationServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.UserServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.StationService;
import edu.wedderz.core.dataaccess.repo.serv.UserService;
import edu.wedderz.core.model.Station;

public class AdminStationController implements ActionListener {

	private static StationService stationService = new StationServiceImpl();
	private static UserService userService = new UserServiceImpl();

	Station station;

	AdminStationView adminStationView;

	public AdminStationController(Station station, StationDataList dataList) {
		this.station = station;
		adminStationView = new AdminStationView(station, userService.getUserById(station.getUserId()), dataList, this);
	}

	public AdminStationView getAdminStationView() {
		return adminStationView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();

		switch (ac) {
		case "ENABLE_STATION":
			station.setDisabled(false);
			if(stationService.updateStation(station)) {
				JOptionPane.showMessageDialog(adminStationView, "Station enabled successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
				adminStationView.setToggleButton(true);
			}
			else JOptionPane.showMessageDialog(adminStationView, "There was an error enabling the station. "
					+ "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
			break;
			
		case "DISABLE_STATION":
			station.setDisabled(true);
			if(stationService.updateStation(station)) {
				JOptionPane.showMessageDialog(adminStationView, "Station disabled successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
				adminStationView.setToggleButton(true);
			}
			else JOptionPane.showMessageDialog(adminStationView, "There was an error disabling the station. "
					+ "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
			break;
		default:
			break;
		}

	}

}
