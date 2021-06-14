package edu.wedderz.core.model;

public class Incident {

	int incidentId;
	String description;
	String subject;
	Station station;
	Integer adminId;
	boolean solved;
	
	public Incident(int incidentId, String description, String subject, Station station, Integer adminId, boolean solved) {
		super();
		this.incidentId = incidentId;
		this.description = description;
		this.station = station;
		this.adminId = adminId;
		this.solved = solved;
		this.subject = subject;
	}

	public Integer getAdminId() {
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
	
	public String getSubject() {
		return subject;
	}
	
	
	
	
}
