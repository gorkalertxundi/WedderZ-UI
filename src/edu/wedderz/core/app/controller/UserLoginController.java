package edu.wedderz.core.app.controller;

import edu.wedderz.core.dataaccess.repo.impl.UserServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.UserService;
import edu.wedderz.core.model.User;

public class UserLoginController {

	static User user = null;
	private static UserService userService = new UserServiceImpl();
	
	public static User login(String email, String password) {
		//TODO: login view
		return userService.login("angoni@zapatos.yes", "123");
	}
	
	public static User getUser() {
		return user;
	}
	
}
