package com.example.msuser.dao;

import java.util.stream.Stream;

import com.example.msuser.beans.User;

public interface UserDAO {
	public void insert(User user);
	public User findByUsername(String username);
	boolean usernameAvailable(String username);
	Stream<User> getAllUsersStream();
}
