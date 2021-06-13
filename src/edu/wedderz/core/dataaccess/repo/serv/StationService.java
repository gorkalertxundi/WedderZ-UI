package edu.wedderz.core.dataaccess.repo.serv;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;

import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Station;
import edu.wedderz.core.model.User;

public interface StationService {

	public Station getStationById(int estationId);
	
	public Collection<Station> getStationsByLocality(Locality locality);
	
	public Collection<Station> getStationsOfUser(int userId);
	
	public Collection<Integer> registerStations(User user, Connection con, int ammount) throws SQLException;
	
	public boolean updateStation(Station station);
	
}
