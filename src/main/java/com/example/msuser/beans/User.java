package com.example.msuser.beans;

import java.sql.Date;

public class User {
	private final String username;
	private final String name;
	private final Date dateCreated;
	private final String userGroup;
	
	public User(String username, String name, Date dateCreated, String userGroup) {
		super();
		this.username = username;
		this.name = name;
		this.dateCreated = dateCreated;
		this.userGroup = userGroup;
	}
	public String getUsername() {
		return username;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public String getName() {
		return name;
	}
	
}
