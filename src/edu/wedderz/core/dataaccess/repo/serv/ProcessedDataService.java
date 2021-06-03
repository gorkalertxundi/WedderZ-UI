package edu.wedderz.core.dataaccess.repo.serv;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;
import java.util.TreeMap;

import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.ProcessedData;

public interface ProcessedDataService {

	public TreeMap<Date, Set<ProcessedData>> getProcessedDataLatest(Locality location, int days);
	
	public TreeMap<Date, Set<ProcessedData>> getProcessedDataByDate(Locality location, Timestamp date);
	
}
