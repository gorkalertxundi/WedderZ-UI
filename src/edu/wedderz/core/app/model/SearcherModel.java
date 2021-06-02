package edu.wedderz.core.app.model;

import java.util.HashSet;
import java.util.Set;

import edu.wedderz.core.dataaccess.repo.impl.LocalityServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.ProcessedDataServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.LocalityService;
import edu.wedderz.core.dataaccess.repo.serv.ProcessedDataService;
import edu.wedderz.core.model.Country;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.ProcessedData;

public class SearcherModel {
	
	LocalityService localityService;
	ProcessedDataService processedDataService;
	
	public SearcherModel() {
		localityService = new LocalityServiceImpl();
		processedDataService = new ProcessedDataServiceImpl();
	}

	public Set<Locality> getLocality(String textString) {
		localityService.getLocalitiesByName(textString);
		Locality locality1 = new Locality(1, "Vitoria", 1001, 100, new Country("ES", "España"));
		Locality locality2 = new Locality(1, "Victoria", 1002, 100, new Country("ES", "España"));
		Locality locality3 = new Locality(1, "Vista Alegre", 1003, 100, new Country("ES", "España"));
		Set<Locality> localities = new HashSet<>();
		localities.add(locality1);
		localities.add(locality2);
		localities.add(locality3);

		return 	localityService.getLocalitiesByName(textString);

	}

	public Set<ProcessedData> getProcessedData(Locality localidad) {
		return 	processedDataService.getProcessedDataLatest(localidad);
	}

	/*public PastData[] getPastData(Locality localidad) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}
