package edu.wedderz.core.model;

public class Country {

	private String countryId;
	private String name;
	
	public Country(String countryId, String name) {
		this.countryId = countryId;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryId() {
		return countryId;
	}
	
}
