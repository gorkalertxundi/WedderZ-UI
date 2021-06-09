package edu.wedderz.core.dataaccess.repo.serv;

import java.util.Set;

import edu.wedderz.core.model.Incident;

public interface IncidentService {

	public Incident getIncidentById(int incidentId);
	
	public Set<Incident> getIncidentsByUser(int userId);
	
	public Set<Incident> getIncidentsByAdmin(int adminId);
		
	public Set<Incident> getIncidentByStation(int stationId);
	
	public Set<Incident> setIncident(int stationId); // setIncident(asunto,descripcion,idEstacion) para insertar una incidencia

	
	public boolean createIncident(Incident incident);
	
	public boolean updateIncident(Incident incident);
	
}
