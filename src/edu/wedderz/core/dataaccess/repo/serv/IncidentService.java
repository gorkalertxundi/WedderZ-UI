package edu.wedderz.core.dataaccess.repo.serv;

import java.util.Collection;

import edu.wedderz.core.model.Incident;

public interface IncidentService {

	public Incident getIncidentById(int incidentId);
	
	//public Collection<Incident> getIncidentsByUser(int userId);
	
	//public Collection<Incident> getIncidentsByAdmin(int adminId);
		
	//public Collection<Incident> getIncidentByStation(int stationId);
	
	public Collection<Incident> getOpenIncidents();
	
	public Incident createIncident(int stationId, String subject, String description);
	
	public Boolean updateIncident(int incidentId, boolean status);
	
	// setIncident(asunto,descripcion,idEstacion) para insertar una incidencia
	//setIncident(asunto,descripción,idEstacion) //para insertar una incidencia
	// setIncidentAcceptDeny(asunto,estacionID,bolean); //para aceptar o denegar la incidencia
	//getIncident(asunto); //para pillar la incidencia
	
}
