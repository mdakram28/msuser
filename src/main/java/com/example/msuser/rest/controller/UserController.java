package com.example.msuser.rest.controller;

import java.sql.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.msuser.beans.User;
import com.example.msuser.beans.Welcome;
import com.example.msuser.dao.UserDAO;

@RestController
public class UserController {
	private static final String message = "Welcome Mr. %s.!";

	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/")
	public String test() {
		return "SUCCESS";
	}

	@GetMapping("/welcome/user")
	@ResponseBody
	public Welcome welcomeUser(@RequestParam(name = "name", required = false, defaultValue = "Java Fan") String name) {
		return new Welcome(String.format(message, name));
	}

	@PostMapping("/add")
	@ResponseBody
	public void addUser(@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "password", required = true) String password,
			@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "userGroup", required = false, defaultValue= "VISITOR") String userGroup) {
		User user = new User(username, password, name, new Date(new java.util.Date().getTime()), userGroup);
		userDAO.insert(user);
	}

	@GetMapping("/all")
	@ResponseBody
	public Stream<User> getAllUsers() {
		return userDAO.getAllUsersStream();
	}

	@GetMapping("/usernameAvailable")
	@ResponseBody
	public boolean usernameAvailable(@RequestParam(name = "username", required = true) String username) {
		return userDAO.usernameAvailable(username);
	}
	
	@PostMapping("/details")
	@ResponseBody
	public User getUserDetails(@RequestParam(name = "username", required = true) String username) {
		return userDAO.findByUsername(username);
	}
 }
