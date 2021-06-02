package edu.wedderz.core.dataaccess.repo.serv;

import java.sql.Timestamp;
import java.util.Set;

import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.ProcessedData;

public interface ProcessedDataService {

	public Set<ProcessedData> getProcessedDataLatest(Locality location, int days);
	
	public Set<ProcessedData> getProcessedDataByDate(Locality location, Timestamp date);
	
}
