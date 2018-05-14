package com.example.msuser.dao.impl;

import java.util.HashMap;
import java.util.stream.Stream;

import com.example.msuser.beans.User;
import com.example.msuser.dao.UserDAO;

public class SimpleUserDAO implements UserDAO {
	
	HashMap<String, User> users;

	public SimpleUserDAO() {
		users = new HashMap<>();
	}

	@Override
	public void insert(User user) {
		if (!users.containsKey(user.getUsername())) {
			users.put(user.getUsername(), user);
		}
	}

	@Override
	public boolean usernameAvailable(String username) {
		return !users.containsKey(username);
	}

	@Override
	public Stream<User> getAllUsersStream() {
		return users.values().stream();
	}

	@Override
	public User findByUsername(String username) {
		return users.get(username);
	}

	@Override
	public boolean authenticate(String username, String password) {
		if(!users.containsKey(username))return false;
		User user = users.get(username);
		return user.getPassword().equals(password);
	}
}
