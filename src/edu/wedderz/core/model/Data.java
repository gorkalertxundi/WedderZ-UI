package edu.wedderz.core.model;

import java.util.Comparator;
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

	private static class DataComparator implements Comparator<Data> {
		@Override
		public int compare(Data o1, Data o2) {
			return o1.getDate().compareTo(o2.getDate());
		}
	}
	
	public static DataComparator getComparator() {
		return new DataComparator();
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
