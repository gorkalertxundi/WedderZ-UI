package edu.wedderz.core.dataaccess.repo.serv;

import java.sql.Date;
import java.util.Map;
import java.util.Set;

import edu.wedderz.core.model.Data;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Station;

public interface DataService {

	public Map<Date, Set<Data>> getProcessedDataLatest(Locality location, int days);
	
	//public Map<Date, Set<Data>> getProcessedDataByDate(Locality location, Date date, int days);
	
	public Set<Data> getCrudeDataLatestByStation(Station station, int ammount);
	
	//public Set<Data> getPastDataByDate(Locality locality, Date date, int numDays);
}
