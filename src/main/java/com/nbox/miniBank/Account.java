package main.java.com.nbox.miniBank;

import java.util.Calendar;

public class Account {
	
	//Variables.
	private String userId;
	private String username;
	private String password;
	
	//Constructor with used a generateUserId method.
	public Account(String username, String password) {
		super();
		this.userId = generateUserId();
		this.username = username;
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//Method for generate user ID. Use Java Calendar.
	private String generateUserId(){
		Calendar date = Calendar.getInstance();
		String id = "" + date.getTimeInMillis();
		return id;
	}
	
	
}
