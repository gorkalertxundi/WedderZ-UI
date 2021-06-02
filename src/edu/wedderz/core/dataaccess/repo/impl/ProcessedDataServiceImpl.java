package edu.wedderz.core.dataaccess.repo.impl;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import edu.wedderz.core.dataaccess.repo.serv.ProcessedDataService;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.ProcessedData;

public class ProcessedDataServiceImpl implements ProcessedDataService {

	@Override
	public Set<ProcessedData> getProcessedDataLatest(Locality locality) {
		Set<ProcessedData> data = new HashSet<>();
		String query = "";
		
		return data;
	}

	@Override
	public Set<ProcessedData> getProcessedDataByDate(Locality locality, Timestamp date) {
		Set<ProcessedData> data = new HashSet<>();
		return data;
	}

	
	
}
