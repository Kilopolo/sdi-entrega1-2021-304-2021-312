package com.uniovi.services;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Offer;
import com.uniovi.entities.User;

@Service
public class InsertSampleDataService {
	@Autowired
	private UsersService usersService;

	@Autowired
	private RolesService rolesService;

	@PostConstruct
	public void init() {


		User admin = new User("admin@email.com", "AdministradorPoggers", "Bonk");
		admin.setPassword("admin");
		admin.setMoney(0.0);
		admin.setRole(rolesService.getRoles()[1]);
		
		usersService.addUser(admin);
		
		User user1 = new User("99999990A@wywallapop.com", "Pedro", "Díaz");
		user1.setPassword("123456");
		user1.setMoney(100.0);
		user1.setRole(rolesService.getRoles()[0]);

		User user2 = new User("99999991B@wywallapop.com", "Lucas", "Núñez");
		user2.setPassword("123456");
		user2.setMoney(100.0);
		user2.setRole(rolesService.getRoles()[0]);

		User user3 = new User("99999992C@wywallapop.com", "María", "Rodríguez");
		user3.setPassword("123456");
		user3.setMoney(100.0);
		user3.setRole(rolesService.getRoles()[0]);

		User user4 = new User("99999993D@wywallapop.com", "Marta", "Almonte");
		user4.setPassword("123456");
		user4.setMoney(100.0);
		user4.setRole(rolesService.getRoles()[0]);

		User user5 = new User("99999977E@wywallapop.com", "Pelayo", "Valdes");
		user5.setPassword("123456");
		user5.setMoney(100.0);
		user5.setRole(rolesService.getRoles()[0]);

		User user6 = new User("99999988F@wywallapop.com", "Edward", "Núñez");
		user6.setPassword("123456");
		user6.setMoney(100.0);
		user6.setRole(rolesService.getRoles()[0]);	

		User user7 = new User("antonio@wywallapop.com", "Antonio", "Suarez");
		user7.setPassword("123456");
		user7.setMoney(100.0);
		user7.setRole(rolesService.getRoles()[0]);

		User user8 = new User("pablo@wywallapop.com", "Pablo", "Diaz");
		user8.setPassword("123456");
		user8.setMoney(100.0);
		user8.setRole(rolesService.getRoles()[0]);
		
		Set<Offer> user1Offers = new HashSet<Offer>(){
			{
				add(new Offer("Oferta1","Oferta1",10.0,user1));
				add(new Offer("Oferta2","Oferta2",20.0,user1));
				add(new Offer("Oferta3","Oferta3",15.0,user1));
				add(new Offer("Oferta4","Oferta4",15.0,user1));
			}
		};
		
		user1.setOffers(user1Offers);
		
		Set<Offer> user2Offers = new HashSet<Offer>(){
			{
				add(new Offer("Oferta5","Oferta5",10.0,user2));
				add(new Offer("Oferta6","Oferta6",20.0,user2));
				add(new Offer("Oferta7","Oferta7",15.0,user2));
				add(new Offer("Oferta8","Oferta8",15.0,user2));
			}
		};
		
		user2.setOffers(user2Offers);
		
		Set<Offer> user3Offers = new HashSet<Offer>(){
			{
				add(new Offer("Oferta9","Oferta9",10.0,user3));
				add(new Offer("Oferta10","Oferta10",20.0,user3));
				add(new Offer("Oferta11","Oferta11",15.0,user3));
				add(new Offer("Oferta12","Oferta12",15.0,user3));
			}
		};
		
		user3.setOffers(user3Offers);
		
		Set<Offer> user4Offers = new HashSet<Offer>(){
			{
				add(new Offer("Oferta13","Oferta",10.0,user4));
				add(new Offer("Oferta14","Oferta",20.0,user4));
				add(new Offer("Oferta15","Oferta",15.0,user4));
				add(new Offer("Oferta16","Oferta",15.0,user4));
			}
		};
		
		user4.setOffers(user4Offers);
		
		Set<Offer> user5Offers = new HashSet<Offer>(){
			{
				add(new Offer("Oferta17","Oferta",10.0,user5));
				add(new Offer("Oferta18","Oferta",20.0,user5));
				add(new Offer("Oferta19","Oferta",15.0,user5));
				add(new Offer("Oferta20","Oferta",110.0,user5));
			}
		};
		
		user5.setOffers(user5Offers);

		usersService.addUser(user1);
		usersService.addUser(user2);
		usersService.addUser(user3);
		usersService.addUser(user4);
		usersService.addUser(user5);
		usersService.addUser(user6);
		usersService.addUser(user7);
		usersService.addUser(user8);
	}


}