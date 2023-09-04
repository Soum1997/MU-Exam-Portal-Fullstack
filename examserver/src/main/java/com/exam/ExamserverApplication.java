package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;



@SpringBootApplication
//@EntityScan(basePackages = {"com.exam.Models"})
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		User user = new User();
//
//		user.setEmail("sr15014556035@gmail.com");
//		user.setEnabled(true);
//		user.setFirstName("Soumya");
//		user.setLastname("Ranjan");
//		user.setPassword("secret");
//		user.setPhone("9811602650");
//		user.setUsername("soum23");
//
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//
//		Set<UserRole> userRoleSet =new HashSet<>() ;
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());

	}

}

