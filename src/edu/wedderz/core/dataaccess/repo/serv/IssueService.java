package edu.wedderz.core.dataaccess.repo.serv;

import java.util.Set;

import edu.wedderz.core.model.Issue;

public interface IssueService {

	public Issue getIncidentById(int incidentId);
	
	public Set<Issue> getIssuesByUser(int userId);
	
	public Set<Issue> getIssuesByAdmin(int adminId);
		
	public Set<Issue> getIssuesByStation(int stationId);
	
	//setIncident(asunto,descripción,idEstacion) //para insertar una incidencia
	// setIncidentAcceptDeny(asunto,estacionID); //para aceptar o denegar la incidencia
	//getIncident(asunto); //para pillar la incidencia
	
	public boolean createIssues(Issue incident);
	
	public boolean updateIssues(Issue incident);
	
}
