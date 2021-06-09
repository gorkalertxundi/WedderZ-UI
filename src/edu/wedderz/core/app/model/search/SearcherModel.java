package edu.wedderz.core.app.model.search;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.postgresql.core.SetupQueryRunner;

import edu.wedderz.core.dataaccess.repo.impl.CountryServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.LocalityServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.ProcessedDataServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.CountryService;
import edu.wedderz.core.dataaccess.repo.serv.LocalityService;
import edu.wedderz.core.dataaccess.repo.serv.ProcessedDataService;
import edu.wedderz.core.model.Country;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.ProcessedData;

public class SearcherModel {
	
	LocalityService localityService;
	ProcessedDataService processedDataService;
	CountryService countryService;
	
	public SearcherModel() {
		localityService = new LocalityServiceImpl();
		processedDataService = new ProcessedDataServiceImpl();
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

	public Map<Date, Set<ProcessedData>> getProcessedData(Locality localidad) {
	
		Map<Date, Set<ProcessedData>> processedDatas = (Map<Date, Set<ProcessedData>>) processedDataService.getProcessedDataLatest(localidad, 6);
		
		return processedDatas;
	}
	
}
