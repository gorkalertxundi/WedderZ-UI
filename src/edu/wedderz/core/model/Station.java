package edu.wedderz.core.model;

public class Station {

	private int stationId;
	private String description;
	private Double latitude;
	private Double longitude;
	private Locality locality;
	private int userId;
	private boolean disabled;
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setLocality(Locality locality) {
		this.locality = locality;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public int getStationId() {
		return stationId;
	}

	public String getDescription() {
		return description;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Locality getLocality() {
		return locality;
	}

	public int getUserId() {
		return userId;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public Station(int stationId, int userId) {
		this.stationId = stationId;
		this.userId = userId;
	}
	
	public Station(int stationId, String description, double latitude, double longitude, Locality locality,
			int userId, boolean disabled) {
		super();
		this.stationId = stationId;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.locality = locality;
		this.userId = userId;
		this.disabled = disabled;
	}
	
	
	
}
