package edu.wedderz.core.app.controller.station.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import edu.wedderz.core.app.view.station.StationDataList;
import edu.wedderz.core.app.view.station.user.UserStationView;
import edu.wedderz.core.dataaccess.repo.impl.LocalityServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.StationServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.LocalityService;
import edu.wedderz.core.dataaccess.repo.serv.StationService;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Station;

public class UserStationController implements DocumentListener, ActionListener, ChangeListener {

	LocalityService localityService;
	StationService stationService;

	Station station;

	UserStationView userStationView;

	public UserStationController(Station station, StationDataList dataList) {
		this.station = station;
		localityService = new LocalityServiceImpl();
		stationService = new StationServiceImpl();
		userStationView = new UserStationView(station, dataList, this);
	}

	public UserStationView getUserStationView() {
		return userStationView;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		userStationView.enableSaveButton();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		userStationView.enableSaveButton();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		userStationView.enableSaveButton();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();

		switch (ac) {
		case "SAVE_FORM":
			saveForm();
			break;

		case "SEARCH_LOCALITY":
			searchLocality();
			break;
		default:
			break;
		}

		userStationView.enableSaveButton();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		userStationView.enableSaveButton();
	}

	private void saveForm() {
		String description = userStationView.getDescription();
		Locality locality = userStationView.getLocality();
		Double latitude = userStationView.getLatitude();
		Double longitude = userStationView.getLongitude();
		
		station.setDescription(description);
		station.setLocality(locality);
		station.setLatitude(latitude);
		station.setLongitude(longitude);
		
		if(stationService.updateStation(station))
			JOptionPane.showMessageDialog(userStationView, "Station information updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
		else JOptionPane.showMessageDialog(userStationView, "There was an error updating the station information. "
				+ "Please check that the information is correct and try again.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	private void searchLocality() {
		userStationView.setLocalityResults(localityService.getLocalitiesByName(userStationView.getSearch()));
	}
	

}
