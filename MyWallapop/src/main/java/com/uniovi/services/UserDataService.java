package com.uniovi.services;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.entities.User;

@Service
public class UserDataService {
	@Autowired
	private UsersService usersService;

	@Autowired
	private RolesService rolesService;

	public void init() {
		User admin = new User("admin@email.com", "admin", "admin", "admin");
		admin.setRole(rolesService.getRoles()[0]);
		
		User user = new User("u@email.com","default","user","123456");
		user.setRole(rolesService.getRoles()[1]);
		usersService.addUser(admin);
		usersService.addUser(user);
	}
}
