package edu.wedderz.core.dataaccess.repo.serv;

import java.sql.Date;
import java.util.Set;

import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.PastData;

public interface PastDataService {

	public Set<PastData> getPastDataLatest(Locality locality, int numDays);
	
	public Set<PastData> getPastDataByDate(Locality locality, Date date, int numDays);
	
}
