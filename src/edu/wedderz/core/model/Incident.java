package edu.wedderz.core.model;

public class Incident {

	int incidentId;
	String description;
	Station station;
	int adminId;
	
	public Incident(int incidentId, String description, Station station, int adminId) {
		super();
		this.incidentId = incidentId;
		this.description = description;
		this.station = station;
		this.adminId = adminId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getIncidentId() {
		return incidentId;
	}

	public String getDescription() {
		return description;
	}

	public Station getStation() {
		return station;
	}
	
	
	
	
	
}
