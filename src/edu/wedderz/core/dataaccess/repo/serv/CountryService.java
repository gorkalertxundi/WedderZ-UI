package edu.wedderz.core.dataaccess.repo.serv;

import java.util.Set;

import edu.wedderz.core.model.Country;

public interface CountryService {

	public Country getCountryById(String countryId);
	
	public Set<Country> getCountriesByName(String name);
	
}
