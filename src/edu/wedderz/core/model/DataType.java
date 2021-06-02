package edu.wedderz.core.model;

public class DataType {

	private int dataTypeId;
	private String description;
	
	
	public DataType(int dataTypeId, String description) {
		this.dataTypeId = dataTypeId;
		this.description = description;
	}

	public int getDataTypeId() {
		return dataTypeId;
	}

	public String getDescription() {
		return description;
	}
	
	
}
