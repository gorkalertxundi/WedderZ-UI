package edu.wedderz.core.app.model;

import java.sql.Date;
import java.util.Map;
import java.util.Set;

import edu.wedderz.core.dataaccess.repo.impl.LocalityServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.ProcessedDataServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.LocalityService;
import edu.wedderz.core.dataaccess.repo.serv.ProcessedDataService;
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
		return 	localityService.getLocalitiesByName(textString);

	}

	public Map<Date, Set<ProcessedData>> getProcessedData(Locality localidad) {
	
		Map<Date, Set<ProcessedData>> processedDatas = (Map<Date, Set<ProcessedData>>) processedDataService.getProcessedDataLatest(localidad, 6);
		
		return processedDatas;
	}
	
}
