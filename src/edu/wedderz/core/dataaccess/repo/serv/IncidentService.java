package edu.wedderz.core.dataaccess.repo.serv;

import java.util.Set;

import edu.wedderz.core.model.Incident;

public interface IncidentService {

	public Incident getIncidentById(int incidentId);
	
	public Set<Incident> getIncidentsByUser(int userId);
	
	public Set<Incident> getIncidentsByAdmin(int adminId);
		
	public Set<Incident> getIncidentByStation(int stationId);
	
	public Set<Incident> setIncident(int stationId);
	// setIncident(asunto,descripcion,idEstacion) para insertar una incidencia
	//setIncident(asunto,descripción,idEstacion) //para insertar una incidencia
	// setIncidentAcceptDeny(asunto,estacionID,bolean); //para aceptar o denegar la incidencia
	//getIncident(asunto); //para pillar la incidencia
	//showIncident()
	//admin?
	public boolean createIncident(Incident incident);
	
	public boolean updateIncident(Incident incident);
	
}
