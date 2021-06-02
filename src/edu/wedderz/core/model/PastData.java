package edu.wedderz.core.model;

import java.sql.Date;

public class PastData {

	Date date;
	Locality locality;
	double maxTemp;
	double minTemp;
	double meanTemp;
	double humidity;	

	public PastData(Date date, Locality locality, double maxTemp, double minTemp, double meanTemp, double humidity) {
		super();
		this.date = date;
		this.locality = locality;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.meanTemp = meanTemp;
		this.humidity = humidity;
	}
	
	public Date getDate() {
		return date;
	}
	public double getMeanTemp() {
		return meanTemp;
	}
	public Locality getLocality() {
		return locality;
	}
	public double getMaxTemp() {
		return maxTemp;
	}
	public double getMinTemp() {
		return minTemp;
	}
	public double getHumidity() {
		return humidity;
	}
	
	
	
}
