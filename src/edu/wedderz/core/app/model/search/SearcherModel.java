package edu.wedderz.core.app.model.search;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import edu.wedderz.core.dataaccess.repo.impl.CountryServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.DataServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.LocalityServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.CountryService;
import edu.wedderz.core.dataaccess.repo.serv.DataService;
import edu.wedderz.core.dataaccess.repo.serv.LocalityService;
import edu.wedderz.core.model.Country;
import edu.wedderz.core.model.Data;
import edu.wedderz.core.model.Locality;

public class SearcherModel {
	
	LocalityService localityService;
	DataService processedDataService;
	CountryService countryService;
	
	public SearcherModel() {
		localityService = new LocalityServiceImpl();
		processedDataService = new DataServiceImpl();
		countryService = new CountryServiceImpl();
	}

	public Set<Locality> getLocality(String textString, String filter) {
		if(filter.equals("Country")) {
			Set<Locality> localities = new HashSet<Locality>();
			Set<Country> countries = countryService.getCountriesByName(textString);
			Iterator<Country> iterator = countries.iterator();
			for(Country c: countries) {
				localities.addAll(localityService.getLocalitiesByCountry(c));
			}
			return localities;
		}
		else {
			return localityService.getLocalitiesByName(textString);
		}
	}

	public Map<Date, Set<Data>> getProcessedData(Locality localidad) {
	
		Map<Date, Set<Data>> processedDatas = (Map<Date, Set<Data>>) processedDataService.getProcessedDataLatest(localidad, 6);
		
		return processedDatas;
	}
	
}
