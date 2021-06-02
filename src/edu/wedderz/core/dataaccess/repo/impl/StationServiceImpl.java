package edu.wedderz.core.dataaccess.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import edu.wedderz.core.dataaccess.PostgreSQLCon;
import edu.wedderz.core.dataaccess.repo.serv.LocalityService;
import edu.wedderz.core.dataaccess.repo.serv.StationService;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Station;
import edu.wedderz.core.model.User;

public class StationServiceImpl implements StationService {

	private static LocalityService localityService = new LocalityServiceImpl();

	@Override
	public Station getStationById(int estationId) {
		String query = "SELECT station_id, description, latitude, longitude, locality_id, users_id, is_disabled\r\n"
				+ "	FROM wedderz.station WHERE station_id = ?;";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, estationId);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			rs.next();

			int stationId = rs.getInt("station_id");
			String description = rs.getString("description");
			double latitude = rs.getDouble("latitude");
			double longitude = rs.getDouble("longitude");
			int localityId = rs.getInt("locality_id");
			int userId = rs.getInt("users_id");
			boolean disabled = rs.getBoolean("is_disabled");
			
			statement.close();
			
			return new Station(stationId, description, latitude, longitude, localityService.getLocalityById(localityId),
					userId, disabled);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Set<Station> getStationsByLocality(Locality locality) {
		Set<Station> stations = new HashSet<>();
		String query = "SELECT station_id, description, latitude, longitude, locality_id, users_id, is_disabled\r\n"
				+ "	FROM wedderz.station WHERE locality_id = ?;";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, locality.getLocalityId());
			statement.execute();
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				int stationId = rs.getInt("station_id");
				String description = rs.getString("description");
				double latitude = rs.getDouble("latitude");
				double longitude = rs.getDouble("longitude");
				int localityId = rs.getInt("locality_id");
				int userId = rs.getInt("users_id");
				boolean disabled = rs.getBoolean("is_disabled");
				stations.add(new Station(stationId, description, latitude, longitude,
						localityService.getLocalityById(localityId), userId, disabled));
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stations;
	}

	@Override
	public Set<Station> getStationsOfUser(int userId) {
		Set<Station> stations = new HashSet<>();
		String query = "SELECT station_id, description, latitude, longitude, locality_id, users_id, is_disabled\r\n"
				+ "	FROM wedderz.station WHERE users_id = ?;";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, userId);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				int stationId = rs.getInt("station_id");
				String description = rs.getString("description");
				double latitude = rs.getDouble("latitude");
				double longitude = rs.getDouble("longitude");
				int localityId = rs.getInt("locality_id");
				boolean disabled = rs.getBoolean("is_disabled");
				stations.add(new Station(stationId, description, latitude, longitude,
						localityService.getLocalityById(localityId), userId, disabled));
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stations;
	}

	@Override
	public Set<Integer> registerStations(User user, Connection con, int ammount) throws SQLException {
		Set<Integer> stationIds = new HashSet<>();
		if(ammount <= 0) return stationIds;
		StringBuilder query = new StringBuilder("INSERT INTO wedderz.station (users_id, is_disabled) VALUES (?, ?)");
		for(int i = 0; i < ammount - 1; i++) query.append(", (?, ?)");
		query.append(";");
		
		PreparedStatement statement = con.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
		int j = 1;
		for(int i = 0; i < ammount; i++) {
			statement.setInt(j++, user.getUserId());
			statement.setBoolean(j++, true);
		}
		if(statement.executeUpdate() > 0 ); //success

		ResultSet rs = statement.getGeneratedKeys();
		while(rs.next()) stationIds.add(rs.getInt(1));
		statement.close();
		return stationIds;
	}

	@Override
	public boolean updateStation(Station station) {
		boolean success = false;
		
		String query = "UPDATE wedderz.station\r\n"
				+ "	SET description = ?, latitude = ?, longitude = ?, locality_id = ?, is_disabled = ?\r\n"
				+ "	WHERE station_id = ?;";
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query.toString());
			int i = 1;
			statement.setString(i++, station.getDescription());
			statement.setDouble(i++, station.getLatitude());
			statement.setDouble(i++, station.getLongitude());
			statement.setInt(i++, station.getLocality().getLocalityId());
			statement.setBoolean(i++, station.isDisabled());
			statement.setInt(i++, station.getStationId());
			
			success = (statement.executeUpdate() > 0);
			
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
		
	}

}
