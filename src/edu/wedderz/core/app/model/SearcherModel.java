package edu.wedderz.core.app.model;

import java.sql.Date;
import java.util.Map;
import java.util.Set;

import edu.wedderz.core.dataaccess.repo.impl.LocalityServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.DataServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.LocalityService;
import edu.wedderz.core.dataaccess.repo.serv.DataService;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Data;

public class SearcherModel {
	
	LocalityService localityService;
	DataService processedDataService;
	
	public SearcherModel() {
		localityService = new LocalityServiceImpl();
		processedDataService = new DataServiceImpl();
	}

	public Set<Locality> getLocality(String textString) {
		return 	localityService.getLocalitiesByName(textString);

	}

	public Map<Date, Set<Data>> getProcessedData(Locality localidad) {
	
		Map<Date, Set<Data>> processedDatas = (Map<Date, Set<Data>>) processedDataService.getProcessedDataLatest(localidad, 6);
		return processedDatas;
	}
	
}
