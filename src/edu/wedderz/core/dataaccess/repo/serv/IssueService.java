package edu.wedderz.core.dataaccess.repo.serv;

import java.util.Set;

import edu.wedderz.core.model.Issue;

public interface IssueService {

	public Issue getIncidentById(int incidentId);
	
	public Set<Issue> getIssuesByUser(int userId);
	
	public Set<Issue> getIssuesByAdmin(int adminId);
		
	public Set<Issue> getIssuesByStation(int stationId);
	
	public boolean createIssues(Issue incident);
	
	public boolean updateIssues(Issue incident);
	
}
