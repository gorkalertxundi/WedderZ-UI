package edu.wedderz.core.dataaccess.repo.serv;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Station;
import edu.wedderz.core.model.User;

public interface StationService {

	public Station getStationById(int estationId);
	
	public Set<Station> getStationsByLocality(Locality locality);
	
	public Set<Station> getStationsOfUser(int userId);
	
	public Set<Integer> registerStations(User user, Connection con, int ammount) throws SQLException;
	
	public boolean updateStation(Station station);
	
}
