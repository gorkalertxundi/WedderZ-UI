package edu.wedderz.core.dataaccess.repo.serv;

import java.util.Set;

import edu.wedderz.core.model.User;

public interface UserService {

	public User getUserById(int userId);
	
	public Set<User> getUsersByName(String name);
	
	public boolean createUser(User user);
	
	public boolean updateUser(User user);
	
	public String getUserName(int userId);
	
	public User login(String email, String password);
}
