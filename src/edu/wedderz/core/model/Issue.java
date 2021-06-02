package edu.wedderz.core.model;

public class Issue {

	int issueId;
	String description;
	String solucion;
	Station station;
	int adminId;
	int userId;
	
	public Issue(int issueId, String description, String solucion, Station station, int userId, int adminId) {
		super();
		this.issueId = issueId;
		this.description = description;
		this.solucion = solucion;
		this.station = station;
		this.userId = userId;
		this.adminId = adminId;
	}
	
	public Issue(int issueId, String description, String solucion, Station station, int userId) {
		super();
		this.issueId = issueId;
		this.description = description;
		this.solucion = solucion;
		this.station = station;
		this.userId = userId;
	}


	public int getIssueId() {
		return issueId;
	}

	public String getDescription() {
		return description;
	}

	public String getSolucion() {
		return solucion;
	}

	public Station getStation() {
		return station;
	}

	public int getUserId() {
		return userId;
	}
	
	
	
	
	
	
	
}
