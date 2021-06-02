package edu.wedderz.core.model;

public class DataType {

	private int dataTypeId;
	private String description;
	private String unit;
	
	
	public DataType(int dataTypeId, String description, String unit) {
		this.dataTypeId = dataTypeId;
		this.description = description;
		this.unit = unit;
	}

	public int getDataTypeId() {
		return dataTypeId;
	}

	public String getDescription() {
		return description;
	}

	public String getUnit() {
		return unit;
	}
	
	@Override
	public int hashCode() {
		return (dataTypeId + description).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof DataType)) return false;
		DataType dt = (DataType) obj;
		if(dt.getDataTypeId() == this.dataTypeId) return true;
		return false;
	}
	
	
	
}
