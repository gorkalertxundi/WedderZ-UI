package edu.wedderz.core.dataaccess.repo.serv;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Set;

import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Data;

public interface ProcessedDataService {

	public Map<Date, Set<Data>> getProcessedDataLatest(Locality location, int days);
	
	public Map<Date, Set<Data>> getProcessedDataByDate(Locality location, Date date, int days);
	
}
