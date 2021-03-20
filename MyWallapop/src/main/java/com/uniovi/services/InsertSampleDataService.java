package com.uniovi.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.User;

@Service
public class InsertSampleDataService {
	@Autowired
	private UsersService usersService;

	@Autowired
	private RolesService rolesService;

	@PostConstruct
	public void init() {
		/*
		 * Sólo existirá un usuario administrador en el sistema con email
		 * “admin@email.com” y contraseña “admin”
		 */
		//TODO ELIMINAR AL TERMINAR LA APLICACION
		insertDataEasyAccess();

		User admin = new User("admin@email.com", "AdministradorPoggers", "Bonk");
		admin.setPassword("admin");
		admin.setRole(rolesService.getRoles()[1]);
		
		usersService.addUser(admin);
		
		User user1 = new User("99999990A@wywallapop.com", "Pedro", "Díaz");
		user1.setPassword("123456");
		user1.setRole(rolesService.getRoles()[0]);

		User user2 = new User("99999991B@wywallapop.com", "Lucas", "Núñez");
		user2.setPassword("123456");
		user2.setRole(rolesService.getRoles()[0]);

		User user3 = new User("99999992C@wywallapop.com", "María", "Rodríguez");
		user3.setPassword("123456");
		user3.setRole(rolesService.getRoles()[0]);

		User user4 = new User("99999993D@wywallapop.com", "Marta", "Almonte");
		user4.setPassword("123456");
		user4.setRole(rolesService.getRoles()[0]);

		User user5 = new User("99999977E@wywallapop.com", "Pelayo", "Valdes");
		user5.setPassword("123456");
		user5.setRole(rolesService.getRoles()[0]);

		User user6 = new User("99999988F@wywallapop.com", "Edward", "Núñez");
		user6.setPassword("123456");
		user6.setRole(rolesService.getRoles()[0]);	

		User user7 = new User("antonio@wywallapop.com", "Antonio", "Suarez");
		user7.setPassword("123456");
		user7.setRole(rolesService.getRoles()[0]);

		User user8 = new User("pablo@wywallapop.com", "Pablo", "Diaz");
		user8.setPassword("123456");
		user8.setRole(rolesService.getRoles()[0]);

		usersService.addUser(user1);
		usersService.addUser(user2);
		usersService.addUser(user3);
		usersService.addUser(user4);
		usersService.addUser(user5);
		usersService.addUser(user6);
		usersService.addUser(user7);
		usersService.addUser(user8);
	}

	private void insertDataEasyAccess() {
		User user = new User("user", "user", "user");
		user.setPassword("123456");
		user.setRole(rolesService.getRoles()[0]);

		User admin = new User("admin", "Admin", "Admin");
		admin.setPassword("123456");
		admin.setRole(rolesService.getRoles()[1]);

		usersService.addUser(user);
		usersService.addUser(admin);
	}
}