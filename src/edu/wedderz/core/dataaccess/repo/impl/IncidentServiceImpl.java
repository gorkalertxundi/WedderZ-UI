package edu.wedderz.core.dataaccess.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import edu.wedderz.core.dataaccess.PostgreSQLCon;
import edu.wedderz.core.dataaccess.repo.serv.IncidentService;
import edu.wedderz.core.dataaccess.repo.serv.StationService;
import edu.wedderz.core.model.Incident;
import edu.wedderz.core.model.Station;

public class IncidentServiceImpl implements IncidentService {

	private static StationService stationService = new StationServiceImpl();
	
	@Override
	public Incident getIncidentById(int incidentId) {
		
		String query = "SELECT incident_id, description, station_id, admin_id, subject, solved\r\n"
				+ "	FROM wedderz.incident\r\n"
				+ "	WHERE incident_id = ?;";
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, incidentId);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			rs.next();
			
			String description = rs.getString("description");
			int stationId = rs.getInt("station_id");
			Integer admin_id = rs.getInt("admin_id");
			if(admin_id == 0) admin_id = null;
			String subject = rs.getString("subject");
			Boolean solved = rs.getBoolean("solved");
			
			Station station = stationService.getStationById(stationId);
			
			statement.close();
			
			return new Incident(incidentId, description, subject, station, admin_id, solved);
					
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Collection<Incident> getOpenIncidents() {
		Set<Incident> incidents = new TreeSet<>();
		
		String query = "SELECT incident_id, description, station_id, admin_id, subject, solved\r\n"
				+ "	FROM wedderz.incident\r\n"
				+ "	WHERE solved = FALSE;";
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.execute();
			
			ResultSet rs = statement.getResultSet();
			while(rs.next()) {
				
				int incidentId = rs.getInt("incident_id");
				String description = rs.getString("description");
				int stationId = rs.getInt("station_id");
				Integer admin_id = rs.getInt("admin_id");
				if(admin_id == 0) admin_id = null;
				String subject = rs.getString("subject");
				Boolean solved = rs.getBoolean("solved");
				
				Station station = stationService.getStationById(stationId);
				
				statement.close();
				
				incidents.add(new Incident(incidentId, description, subject, station, admin_id, solved));
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return incidents;
	}

	@Override
	public Incident createIncident(int stationId, String subject, String description) {
		Incident incident = null;
		if(stationId <= 0) return incident;
		
		String query = "INSERT INTO wedderz.incident(\r\n"
				+ "	description, station_id, admin_id, subject, solved)\r\n"
				+ "	VALUES (?, ?, ?, ?, ?);";
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			int i = 1;
			statement.setString(i++, description);
			statement.setInt(i++, stationId);
			statement.setNull(i++, java.sql.Types.NULL);
			statement.setString(i++, subject);
			statement.setBoolean(i++, false);
			
			if(statement.executeUpdate() > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				incident = new Incident(rs.getInt(1), description, subject, stationService.getStationById(stationId), null, false);
				
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return incident;
	}

	@Override
	public Boolean updateIncident(int incidentId, boolean status) {
		if(incidentId <= 0) return false;
		
		String query = "UPDATE wedderz.incident\r\n"
				+ "	SET solved=?\r\n"
				+ "	WHERE incident_id = ?;";
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			int i = 1;
			
			statement.setBoolean(i++, status);
			statement.setInt(i++, incidentId);
			
			if(statement.executeUpdate() > 0); //success
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
