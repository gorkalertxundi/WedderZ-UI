package edu.wedderz.core.model;

import java.util.Date;

public class Data {

	Locality locality;
	DataType dataType;
	Date date;
	double value;
	
	public Data(Locality locality, DataType dataType, Date date, double value) {
		super();
		this.locality = locality;
		this.dataType = dataType;
		this.date = date;
		this.value = value;
	}

	public Locality getLocality() {
		return locality;
	}

	public DataType getDataType() {
		return dataType;
	}

	public Date getDate() {
		return date;
	}

	public double getValue() {
		return value;
	}
	
	
	
	
}
