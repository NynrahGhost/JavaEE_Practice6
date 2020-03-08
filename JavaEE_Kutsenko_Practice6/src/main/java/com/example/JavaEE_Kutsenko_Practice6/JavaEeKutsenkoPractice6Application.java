package com.example.JavaEE_Kutsenko_Practice6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaEeKutsenkoPractice6Application {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = SpringApplication.run(JavaEeKutsenkoPractice6Application.class, args);
		
		UserService userService = applicationContext.getBean(UserService.class);

		userService.createUser("1", "1", "email1@example.com");
		userService.createUser("2", "Smith", "email1@example.com");
		userService.createUser("3a", "Smith", "email1@example.com");
		userService.createUser("4", "4a", "email1@example.com");
		
		System.out.println("\n\nList of all users: \n");
		for(UserEntity user : userService.getUsers())
			System.out.println(user.toString());
		
		System.out.println("\n\nList of all users with \"Smith\" surname: \n");
		for(UserEntity user : userService.getSmiths())
			System.out.println(user.toString());
		
		System.out.println("\n\nList of all users with \"a\" in name or surname: \n");
		for(UserEntity user : userService.getA())
			System.out.println(user.toString());
		
		System.out.println('\n');
	}

}
