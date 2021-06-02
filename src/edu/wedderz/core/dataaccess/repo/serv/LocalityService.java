package edu.wedderz.core.dataaccess.repo.serv;

import java.util.Set;

import edu.wedderz.core.model.Country;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.User;

public interface LocalityService {

	public Locality getLocalityById(int localityId);
	
	public Set<Locality> getLocalitiesByName(String name);
	
	public Set<Locality> getLocalitiesByCountry(Country country);
	
	public boolean createLocality(Locality locality);
	
	public Set<Locality> getFavLocalities(int userId);
	
	public boolean makeFavorite(User user, Locality locality);
	
	public boolean deleteFavorite(User user, Locality locality);
	
}
